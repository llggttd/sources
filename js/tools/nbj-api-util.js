const crypto = require('crypto')
const RSA = require('node-rsa')
const assert = require('assert')
const uuid = require('uuid')
const request = require('request')

const DEFAULT_KEY = 'bcc6fcc2'
const PRIVATE_KEY = 'MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC1cmQZf+cqahFonPMcRBMEDUaVGcSBScw3y+heGGbZQQdXkJ7Wdc1e0EDqzZ7yAeU4/nnvmpulmJdSZWiy9+C6M4qULwBa1PvKNwwUxdoMA9YY4Y2VmjOukiDYepEStWgT3OzLKj2EQrDUeaucqN250fIBKLs8lDbM+ZL8ApT3WJx3Wz/pnxiBNWlUR4XIwksIo/SFCp/0LJlUKoPwDKYMRt9TpqXbNl6+tORBtryyJ/AysIxRFzrItBxfy0IEZoi0CfKNyDXA6sbtfYIBD8qVwlXOaGg1bZsjbWElXkEgczqeYoUoFvLu0fy6U2+s+5SZDlO6iTuRgLYfCp0k3ci/AgMBAAECggEAaVW1ItCLxKW64X5r6/bhCzMhzKEe4OeUtLedeDK2Ul1cA8ujSmEtDmPbq/Qe1+OdzM5+v0iEH0hMYLsaYvtf7PjK9Geszw5h9eyrCMwrX1pCykL2zOiuJCQVCVduLOw/NXjFxtQIzmVg/ph7tgCaZ6un0GBzAiIRBkHEwKRHEqfTODD9v/gA7AVBUsfDJQCsBdKoUes0eW0sCIQiEPANvWm1KS8pIhPb7zB/fm+D2erE5+VnJZkyW9tJGd7lJ4b0Rwbmeqa8BsIqQ0Tzvmtjsx1lTQyrYCPQRg2CboyVQGezvVi+pdxhODTS8bo4R1GbC0dtr4GSboP+sSjJUzq2YQKBgQD7y77rpyGvdWH4QU2MPwulrH5Xwq4v96sr5cilIsPiDWC95LuGZfoDe/hfcEulwDNsnx0KO13NbRGiwEfh64nTZ8BDn6kbgMHbqWWXgHkKBkL2fs0BW66yObB2TXFQNN/iW2jr/KmUS1MygPU0+NYMwGdl7oQac+mT99jdOL3xtwKBgQC4efOS5b5BafxzZuqX7SNOt8mFvkKAnY12Rlhuye67KGRNooMOAkM4PMx891ItlZRUFLKkO6UbV2zGDaYFcf1e3+82bBaGjyPWtPdC9kQi7kHUL3iSN+K7CaWbG6ZYToV4HyXtUIycSHSpiEmxe1SMYB/dLypoITGu9qgyy2jBOQKBgQC3mYI2PKDgWpw8NAnCqLnqbROXFHqEuXgTwzKBzw68Bvsym9VtE3CxF7Usiipuyu30VzUKn+0u/Eeuv7vqbSALiYx1AreBOWqhrCxKwz/+4j/zktQTGHISvOQB70gfrt5NJFAmOw6/9gjNO6EQph0WITmD5t5ml3yLC18TN+uwkwKBgBIcVt9bEryVTSV/OxTDQS4fOPeaYCkETrkH2vK1fGx/YKmGhNtBOZwxy9mQ5k53WuKOTaN1/5WZlaI0ANKUCE3iKjfrkKKRNvGDPqsiRjovreLI7ktclTPLlKiPpFsTCmNqm2ya9dL6AgoKyUFVXE2Tuk0ark0exSPqL0UdVyFxAoGBAJ2uoGrKM+OAnUF9dmbo/3nPg7yElB0O7dreXreDHN0r2RqkY4OOuyuxmtzRyiv0MRtAjcJX6fpUs0OrIcNrKlYn+Onr6lw6v19kklKS1Avf7USf5cw1LvseG4SYlhG9MzyuQ0mLeai1le6Srt48XcR0fn9oz9p9+qyEnIncVUPH'

function Util() {
	Util.ALGORITHMS_AES = 'aes-128-cbc'
	Util.ALGORITHMS_DES = 'des-ecb'
}

/**
 * 生成一个uuid
 */
Util.prototype.uuid = function () {
	return uuid.v4()
}
/**
 * 获取字符串的md5值
 */
Util.prototype.md5 = function (data) {
	assert.ok(data, 'data can\'t be null')
	assert.deepStrictEqual(typeof data, 'string', 'data must be string')
	var md5 = crypto.createHash('md5')
	md5.update(data)
	return md5.digest('hex')
}

Util.prototype.ciphers = function () {
	return crypto.getCiphers()
}
/**
 * 使用des方式加密字符串
 */
Util.prototype.encrypt = function (data, key, mode = Util.ALGORITHMS_DES) {
	assert.ok(data, 'data can\'t be null')
	assert.deepStrictEqual(typeof data, 'string', 'data must be string')
	assert.ok(mode, 'mode can\'t be null')

	if (!key) {
		key = DEFAULT_KEY
	}
	let bufferKey, bufferIV
	if (mode === Util.ALGORITHMS_DES) {
		bufferKey = new Buffer(key)
		bufferIV = new Buffer(0)
	} else if (mode === Util.ALGORITHMS_AES) {
		bufferKey = new Buffer(key)
		bufferIV = new Buffer(key)
	} else {
		return
	}
	const cipher = crypto.createCipheriv(mode, bufferKey, bufferIV)
	cipher.setAutoPadding(true)
	var content = cipher.update(data, 'utf8', 'hex')
	content += cipher.final('hex')
	return content
}

/**
 * 使用des方式解密字符串
 */
Util.prototype.decrypt = function (data, key, mode = Util.ALGORITHMS_DES) {
	assert.ok(data, 'data can\'t be null')
	assert.deepStrictEqual(typeof data, 'string', 'data must be string')
	if (!key) {
		key = DEFAULT_KEY
	}
	let bufferKey, bufferIV
	if (mode === Util.ALGORITHMS_DES) {
		bufferKey = new Buffer(key)
		bufferIV = new Buffer(0)
	} else if (mode === Util.ALGORITHMS_AES) {
		bufferKey = new Buffer(key)
		bufferIV = new Buffer(key)
	}
	const decipher = crypto.createDecipheriv(mode, bufferKey, bufferIV)
	decipher.setAutoPadding(true)
	var content = decipher.update(data, 'hex', 'utf8')
	content += decipher.final('utf8')
	return content
}

Util.prototype.request = function (option, callback) {
	return request(option, callback)
}

Util.prototype.encryptRSA = function (data) {
	let key = new RSA()
	key.importKey(PRIVATE_KEY, 'pkcs8-private-pem')
	return key.encrypt(data, 'hex')
}

Util.prototype.decryptRSA = function (data) {
	let key = new RSA()
	key.importKey(PRIVATE_KEY, 'pkcs8-private-pem')
	return key.decrypt(data, 'utf8')
}

Util.prototype.genPWD = function (input, salt) {
	return this.md5(this.md5(input + salt), salt)
}

module.exports = Util
