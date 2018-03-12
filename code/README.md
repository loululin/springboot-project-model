# 注意事项
1. 建议把工程导入到eclipse后，再进行项目名称修改或做其它配置修改
2. 修改时，建议使用IDE重构快捷键，eclipse是`alt+shift+R`
3. ojdbc6包和hiynn-util包安装到本地maven仓库，可以参考如下命令：

```sh
mvn install:install-file -Dfile=D:\你的路径\ojdbc6-10.2.0.2.0.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=10.2.0.2.0 -Dpackaging=jar
```