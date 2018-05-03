const args = require('args')
const chalk = require('chalk')
const utils = require('./utils')
const config = require('./config')
const RedisOperator = require('./redis-operator')

const commands = [
  'keys',
  'values',
  'delete',
  'flush'
]

args
  .option('host', 'redis服务器地址')
  .option('port', 'redis服务器端口')
  .option('config', '配置文件', './config.json')
  .option('command', '命令: keys, values, delete, flush')
  .option('key', '查询字符')

const options = args.parse(process.argv, {
    'name': 'mredis',
    'exit': { help: true, version: true},
    'help': false,
    'version': false
})

if (!options.command && !options.key) {
  args.showHelp()
}

if (!options.command || !commands.includes(options.command)) {
  utils.printWarning('请指定要执行的命令(-C)，命令可以是：' + commands.join(', '))
  process.exit()
}

if (!options.key || !/^[*]?[^*]+[*]?$|^[*]$/.test(options.key)) {
  utils.printWarning('请指定查询字符串(-k)，型如： *, *key, key*, *key*')
  process.exit()
}

config.load(options.config)

let hosts = config.getHosts()
let option = {}
if (hosts.length <= 0) {
  if (!options.host || !options.port) {
    utils.printWarning('请指定要连接的服务器')
    process.exit()
  }
  option.host = 'localhost'
  option.port = '6379'
} else {
  option.cluster = hosts
}

const redisOperator = new RedisOperator(option)

switch (options.command) {

  case 'keys':
    utils.handleResult(redisOperator.keys(options.key))
    break;

  case 'values':
    utils.handleResult(redisOperator.values(options.key))
    break

  case 'delete':
    utils.handleResult(redisOperator.delete(options.key))
    break

  case 'flush':
    utils.handleResult(redisOperator.flush())
    break

  default:
    break;
}
