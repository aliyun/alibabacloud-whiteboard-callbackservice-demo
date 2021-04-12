# 互动白板回调服务实现示例

> 使用SpringBoot构建

1. 请在application.properties里配置您的回调地址和回调URL

2. 回调逻辑示例请参照AppController中的实现

3. 项目打包部署:

```bash
# a.在项目目录下使用如下命令打包工程:
mvn clean package -Dmaven.test.skip=true

# b.将target目录下的rtc-white-board.jar上传部署环境(推荐使用ECS服务器), 使用如下命令启动服务:
nohup java -jar rtc-white-board.jar &

# c.监看服务日志
tail -f nohup.out

# 若因端口被占用而启动失败，可尝试使用以下命令杀死占用7001端口的所有java进程
lsof -i:7001 | grep java | awk '{print $2}' | xargs kill -9
```