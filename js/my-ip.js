const request = require('request')
const cheerio = require('cheerio')

const API = 'http://2017.ip138.com/ic.asp'

request(API, function (error, response, body) {
    if (error || !body) {
        console.log("测试接口不可用")
        return
    }
    let $ = cheerio.load(body)
    let matcher = $('center').text().match(/.*\[(.*)\].*/)
    if (matcher) {
        console.log('WAN IP: %s', matcher[1])
    }
});