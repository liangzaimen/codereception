自动发送密码请求/接收闪讯密码

## 大致想法

主要分为Android客户端以及Web端

### Android端-CodeReception

目的及问题

- [ ] 发送/读取短信
  - [ ] 获取本机手机号
    - [ ] 判断电信,联通,移动
  - [ ] 单卡/双卡区分
- [ ] 何时发送短信/何时向服务器发送短信信息

### Web端

- [ ] 通过指定路径获取密码
  比如: https://hellooooo.top/netkeeper/{identification}

### 流程

前提:

Android端安装了CodeReception客户端.

第一次安装CR客户端先发送一条信息给闪讯获得密码:

闪讯密码回复格式:

> 尊敬的闪讯用户，您的宽带上网密码是：216888,密码在2020-09-17 22:45:55以前有效

得到密码的同时获得了密码的有效期,将获得的密码以及有效期传回服务器同时将它保存在本地.每隔15分钟左右判断一次密码是否过期,如果发现过期时间小于15分钟,则间隔时间缩短为1分钟判断一次是否过期.直到过期.发送短信并回传服务器.这就完成了一次密码更新.

用户通过服务器暴露的web端获取密码,用户获取到的密码永远是数据库中的密码,而不一定是最新的.返回的密码建议为JSON格式,同时包含过期时间.

# 开发

- [ ] 完成用户手机号码获取
- [ ] 完成接收/发送短信以及读取短信
- [ ] 完成Android端密码过期监听
- [ ] Web构建完成