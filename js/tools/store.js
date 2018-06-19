const Store = require('electron-store')
const { app } = require('electron')
const path = require('path')

const store = new Store({
    cwd: path.dirname(app.getPath('exe')),
    name: 'config'
})

module.exports = store