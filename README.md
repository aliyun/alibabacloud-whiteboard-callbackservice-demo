# 互动白板回调服务实现示例

> 使用SpringBoot构建

1. 请在application.properties里配置您的回调地址和回调URL

2. 回调逻辑示例请参照AppController中的实现

3. 项目打包部署:

```bash
# 在项目目录下
mvn clean package -Dmaven.test.skip=true
# 将target目录下的rtc-white-board.jar上传部署环境，启动服务
nohup java -jar rtc-white-board.jar &
```