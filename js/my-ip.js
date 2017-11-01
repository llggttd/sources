const request = require('request')
const cheerio = require('cheerio')

const API = 'http://2017.ip138.com/ic.asp'

request(API, function (error, response, body) {
    let $ = cheerio.load(body)
    console.log($('center').text())
});