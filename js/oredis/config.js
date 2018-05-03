const fs = require('fs')

function Config () {
    this.hasLoad = false
}

Config.prototype.hasLoad = function () {
    return this.hasLoad
}

Config.prototype.load = function (path) {
    let file
    try {
         file = fs.readFileSync(path)
    } catch (error) {
        return false
    }

    try {
        this.config = JSON.parse(file)
    } catch (error) {
        console.log('配置文件必须为json格式文件')
        return false
    }
    this.hasLoad = true
    return true
}

Config.prototype.getHosts = function () {
    if (!this.hasLoad || !this.config.hosts) {
        return []
    }
    return this.config.hosts
}


module.exports = new Config()