###

#### 使用openssl生成DSA公私钥对

- 生成DSA参数
```sh
openssl dsaparam -out dsa.param 1024
```

- 生成DSA私钥
```sh
openssl gendsa -out dsa.private.key dsa.param
```

- 生成PKCS8格式的DSA私钥
```sh
openssl pkcs8 -topk8 -nocrypt -in dsa.private.key -out dsa.private.pkcs8.key
```

- 生成DSA公钥
```sh
openssl dsa -in dsa.private.key -pubout -out dsa.public.key
```

#### 生成com.atlassian.extras.decoder.v2.Version2LicenseDecoder.class


