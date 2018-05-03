const chalk = require('chalk')
const util = require('util')

function uniqConcat (data) {
    let arr = []
    for (var i = 0; i < data.length; i++) {
        arr = arr.concat(data[i])
    }
    let result = []
    arr.forEach(value => {
        if (!result.includes(value)) {
            result.push(value)
        }
    })
    return result
}

function printWarning (msg) {
    console.warn('')
    console.warn(chalk.red('  [警告] ') + chalk.yellow('%s'), msg)
}

function outputResult (data) {
    data.forEach(function (item) {
        let msg = ''
        if (typeof item !== 'object') {
            msg = chalk.green('[') +  chalk.yellow(item) + chalk.green(']')
        } else {
            if (item.type) {
                msg += chalk.green('[') + chalk.yellow(item.type.toUpperCase()) + chalk.green(']')
            }
            if (item.key) {
                msg += chalk.green('[') + chalk.cyan(item.key) + chalk.green('] ')
            }
            if (item.delete) {
                msg += chalk.red('--> ') + chalk.cyan(item.delete)
            }
            if (item.value) {
                if (typeof item.value === 'object') {
                    msg += chalk.red('--> ') + chalk.cyan(JSON.stringify(item.value))
                } else {
                    msg += chalk.red('--> ') + chalk.cyan(item.value)
                } 
            }
        }
        console.log(msg)
    })
    process.exit()
}

function handleResult (promise) {
    promise.then(function (data) {
        outputResult(data)
    })
}


module.exports.uniqConcat = uniqConcat
module.exports.printWarning = printWarning
module.exports.outputResult = outputResult
module.exports.handleResult = handleResult