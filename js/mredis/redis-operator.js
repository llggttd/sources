const assert = require('assert')
const Redis = require('ioredis')
const utils = require('./utils')

function RedisOperator (option) {
	assert.ok(option, 'option can not be null')
	this.nodes = []
	if (option.host && option.port) {
		this.nodes.push(new Redis(option))
	} else if (option.cluster) {
		this.cluster = new Redis.Cluster(option.cluster, option)
		this.nodes = this.cluster.nodes('all')
	}
}

RedisOperator.prototype.getRedisHandle = function () {
	assert.ok((this.nodes.length > 0) || this.cluster, 'no redis handle found')
	if (this.cluster) {
		return this.cluster
	}
	if (this.nodes.length > 0) {
		return this.nodes[0]
	}
}

/**
 * 获取集群上的指定模式的key
 * 
 * @param {string} pattern query string pattern
 */
RedisOperator.prototype.keys = function (pattern) {
	return Promise.all(this.nodes.map(function (node) {
		return node.keys(pattern)
	})).then(function (data) {
		return Promise.resolve(utils.uniqConcat(data))
	})
}

/**
 * 获取集群上的指定模式的key值的value
 * 
 * @param {string} pattern query string pattern
 */
RedisOperator.prototype.values = function (pattern) {
	let handler = this.getRedisHandle()
	return Promise.all(this.nodes.map(function (node) {
		return node.keys(pattern)
	})).then(function (data) {
		return Promise.resolve(utils.uniqConcat(data))
	}).then(function (data) {
		return Promise.all(data.map(function (key) {
			return handler.type(key).then(function (result) {
				if (result === 'string') {
					return handler.get(key).then(function (result) {
						return { key: key, value: result, type: 'string' }
					})
				} else if (result === 'hash') {
					return handler.hgetall(key).then(function (result) {
						return { key: key, value: result, type: 'hash' }
					})
				} else if (result === 'set') {
					return handler.smembers(key).then(function (result) {
						return { key: key, value: result, type: 'set' }
					})
				} else if (result === 'zset') {
					return handler.zrange(key, 0, -1).then(function (result) {
						return { key: key, value: result, type: 'zset' }
					})
				}
			})
		}))
	})
}

/**
 * 删除集群上指定模式的key
 */
RedisOperator.prototype.delete = function (pattern) {
	let handle = this.getRedisHandle()
	return Promise.all(this.nodes.map(function (node) {
		return node.keys(pattern)
	})).then(function (data) {
		return Promise.resolve(utils.uniqConcat(data))
	}).then(function (data) {
		return Promise.all(data.map(function (key) {
			return handle.del(key).then(function (result) {
				return { key: key, delete: result}
			})
		}))
	})
}

/**
 * 清除集群中所有节点上的key
 */
RedisOperator.prototype.flush = function () {
	return Promise.all(this.nodes.map(function (node) {
		return node.flushdb()
	}))
}

module.exports = RedisOperator
