### oredis

#### 功能

- 支持对redis集群进行操作
- 目前支持的命令：
    + keys - 查询redis集群中指定模式的键
    + values 查询redis集群中指定模式的值
    + delete 删除指定模式的键值
    + flush 清空集群所有节点

#### 示例

```bash
## 查询所有键名中包含字符串"APP”的键
oredis -C keys -k *APP*

## 查询所有键名以字符串"bank”开头的键和值
oredis -C values -k bank*

## 删除所有以字符串"bank"开头的键
oredis -C delete -k bank*
```

#### 配置文件

默认配置文件名为"config.json", 要与主程序位于同一目录下。

```json
{
    "hosts": [
        { "host": "192.168.1.22", "port": "30001"},
        { "host": "192.168.1.22", "port": "30002"},
        { "host": "192.168.1.22", "port": "30003"},
        { "host": "192.168.1.22", "port": "30004"},
        { "host": "192.168.1.22", "port": "30005"},
        { "host": "192.168.1.22", "port": "30006"}
    ]
}
```