# x-workout
分布式项目锻炼项目

#### 部署步骤
##### 部署euraka模块
##### 部署workout模块
1. pull代码
1. x-workout层执行`mvn install`安装依赖
1. x-workout-server层执行`mvn package`打包
1. 进入`/root/workPlace/x-workout/x-workout-server/target`路径，
1. kill掉原来运行中的本项目
1. 执行`nohup java -jar x-workout-server-1.0.0-SNAPSHOT.jar >/data/log/x-workout/running.out &`命令启动项目
