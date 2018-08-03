'use strict'

const Util = require('./nbj-api-util')

const util = new Util()
const SUPER_KEY = '8888888888888888'
const SUPER_COOKIE = 'qFTs2vdeDZZ9up7cbx0c5FE2ZLY4JCjzm8QuB7mPwtq1qd%2B%2FXg3bgifEnOgltZRZxR4Fjkfj7wCO%0Adwt7TYnxGLBn9HDh%2Bcmk82BM0UbYqeLeSDPgSxzoQDu8sMpeLXgsr49B8v3nK0aH5FHkAlVDHpWF%0A%2FJ9IfXjJrtoxVyxuXccUr%2FlKTxvZcphatVQG35ZQU5ST8TWYzK4PuzYAVnWN6ILfOX4%2BWpCrPY68%0Axk6HteUEXobHePwwhe3p%2FDCIDNiSTe5xE9TB3%2BIRDWQkSz29yb4JI8vN%2F2IyNodfKCUGCJmIs1UO%0ATb38X6SM91TyC2ngSJ%2F8MG0GjAnc%2F9D%2BoQw6FA%3D%3D'

function Api () {
	this.option = {}
	this.option.headers = {}
}

function get (url, param, option, success, fail) {
	let request = {
		method: 'GET',
		uri: fixUrl(url, option.baseUrl),
		headers: option.headers,
		form: wrapParams(param)
	}
	util.request(request, function (error, response, body) {
		if (error) {
			fail(error)
			return
		}
		success(body)
	})
}

function post (url, param, option, success, fail) {
	let request = {
		method: 'POST',
		uri: fixUrl(url, option.baseUrl),
		headers: option.headers,
		form: wrapParams(param)
	}
	util.request(request, function (error, response, body) {
		if (error) {
			fail(error)
			return
		}
		success(body)
	})
}

function wrapParams(params) {
	let session = encodeURIComponent(new Buffer(util.encrypt(JSON.stringify(params), SUPER_KEY, Util.ALGORITHMS_AES), 'hex').toString('base64'))
	return {
		cookie: SUPER_COOKIE,
		session: session
	}
}

function parseParams (requestParams, apiParams) {
	if (Object.keys(requestParams).length <= 0) {
		return
	}
	if (typeof requestParams[0] !== 'object') {
		return
	}
	if (Object.keys(requestParams[0]).length < Object.keys(apiParams).length) {
		return
	}
	return requestParams[0]
}

function fixUrl(url, baseUrl) {
	if (!baseUrl || url.match('http|https')) {
		return url
	}
	return baseUrl + url
}

function getSuccessHandler (requestParams) {
	if (Object.keys(requestParams).length <= 0) {
		return
	}
	if (Object.keys(requestParams).length >= 2 && typeof requestParams[1] === 'function') {
		return requestParams[1]
	}
	return log
}

function getFailhandler (requestParams) {
	if (Object.keys(requestParams).length <= 0) {
		return
	}
	if (Object.keys(requestParams).length >= 3 && typeof requestParams[2] === 'function') {
		return requestParams[2]
	}
	return log
}

Api.prototype.setHeaders = function (headers) {
	this.option.headers = headers
}

Api.prototype.setBaseUrl = function (url) {
	this.option.baseUrl = url
}

Api.prototype.post = function (url, data, success, fail) {
	post(url, data, this.option, success, fail)
}

Api.prototype.get = function (url, data, success, fail) {
	get(url, data, this.option, success, fail)
}

module.exports = new Api()
