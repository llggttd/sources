const chalk = require('chalk')

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
        console.log(item)
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