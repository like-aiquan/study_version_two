### Gradle

使用groovy脚本远不止此功能，我只做了我简单的学习和测试，很多集成脚本都是可以使用groovy实现的。总的来说比maven各有优缺点。

gradlew 会首先在同版本的jvm中去找有没有启动好的Daemon信息，所以说依赖文件可能很多个项目依赖都是一样的，只需要加载一次即可。Daemon有时间限制。

Daemon可以配置项目启动完成即down。

大部分笔记在代码里。

### 初始化项目 
fork -> init src/main/java/  and  src/main/resources/