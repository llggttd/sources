### StarUML 3.0.1破解

StarUML从3.0版本开始，开始通过`.msi`格式来发行，不再提供zip包格式的了，而且源码文件打包成了`.asar`


#### 安装asar

```bash
npm install -g asar

asar e app.asar
```

#### 修改文件

找到 app\src\engine\license-manager.js文件，

```js
var licenseInfo = null
```

修改成
```js
//*************crack***************
var licenseInfo = {
  name: '0z0ne',
  key: 'NOTHING',
  product: '',
  licenseType: 'PS',
  quantity: '1'
}
//*************crack***************
```

```js
//修改validate和register方法，直接跳过验证
validate () {
    return new Promise((resolve, reject) => {
        try {

        //*************crack***************
        resolve(licenseInfo)
        return
        //*************crack***************


register (licenseKey) {
    return new Promise((resolve, reject) => {

        //*************crack***************
        setStatus(this, true)
        resolve(licenseInfo)
        return
        //*************crack***************

```


