## 项目框架模板使用说明

### 框架模板相关说明
1. 总体框架 springboot springmvc mybatis
2. 默认底层数据库 oracle, DB连接池 druid
3. 缓存 ehcache
4. 日志框架 slf4j+logback(janino智能区分**开发**和**上线**模式)
5. 单元测试框架 junit hamcrest easymock
6. 系统配置解决 owner
7. 后端主动推送消息 websocket
8. http&http/2客户端 okhttp3
9. 第三方工具类 guava
10. 定时任务 quartz
11. maven直接打war包 jdk1.8
12. controll层统一异常处理 @RestControllerAdvice
13. 基于注解事务配置、service层方法性能统计 @Aspect
14. 自定义异常处理
15. mybatis分页插件 pagehelper
16. api管理 swagger2
17. controller层单元测试 MockMvc
18. ajax请求跨域配置

### 1.下载模板工程代码

直接git clone到本地

### 2.工程改名
1. 首先修改工程名，把工程文件夹名springboot-demo改为aaa-bb，可以参考jizhen-yunwei
2. 修改项目pom.xml文件,将springboot-demo全部替换为aaa-bb，并将<groupId>的值修改为com.aaa.bb
3. 修改项目的.project文件，打开workspace找到对应的项目，打开.project文件，修改成对应的项目名aaa-bb
4. 打开workspace找到项目下的.Settings目录，找到`org.eclipse.wst.common.component`文件，将springboot-demo全部替换为aaa-bb
5. 将项目放到eclipse的workspace目录，然后导入到eclipse中（maven项目）(import->maven->existing maven project)


### 3.修改其它配置

1. 修改src/main/webapp/WEB-INF目录下的web.xml文件，将springboot-demo全部替换为springboot-demo，把springboot.demo替换为aaa.bb
2. 修改src/main/resources和src/test/resources下的包名,建议用alt+shift+R快捷键，把springboot.demo替换为aaa.bb
3. 修改src/main/resources/mappers下的UserMapper.xml文件，把springboot.demo替换为aaa.bb
4. 修改src/main/resources下的spring.xml、spring-mvc.xml文件，把springboot.demo替换为aaa.bb
5. 修改src/main/resources下的logback.xml,将demo替换为bb，把springboot-demo替换为aaa-bb

### 4.更新配置

1. 鼠标左键选中工程名，然后按alt+F5键 update maven project，选择Force Update of Snapshots/Releases，更新整个工程的配置

### 5.创建单元测试所需数据库表（oracle）

```xml
在oracle实例中新建一个用户，然后新建一个user表，供单元测试用，建表语句为(主意需要把GXLY全部替换为你的数据库用户名)：
CREATE TABLE "GXLY"."TB_USER" (
"ID" VARCHAR2(255 BYTE) NOT NULL ,
"NAME" VARCHAR2(255 BYTE) NOT NULL ,
"PASSWORD" VARCHAR2(255 BYTE) NOT NULL ,
"CREATETIME" DATE NOT NULL ,
"LEVEL" VARCHAR2(255 BYTE) NULL ,
"REMARK" VARCHAR2(255 BYTE) NULL ,
"UID" VARCHAR2(255 BYTE) NOT NULL ,
"TELEPHONE" VARCHAR2(255 BYTE) NULL ,
"WEIXIN_ID" VARCHAR2(255 BYTE) NULL ,
"WEIXIN_NAME" VARCHAR2(255 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE
;

INSERT INTO "GXLY"."TB_USER" VALUES ('123', 'test1', '123', TO_DATE('2017-07-13 18:15:00', 'YYYY-MM-DD HH24:MI:SS'), '1', null, 'leisongwen', null, null, null);
INSERT INTO "GXLY"."TB_USER" VALUES ('124', 'test2', '123', TO_DATE('2017-07-13 18:15:17', 'YYYY-MM-DD HH24:MI:SS'), '2', null, 'loulvlin', null, null, null);

ALTER TABLE "GXLY"."TB_USER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "GXLY"."TB_USER" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "GXLY"."TB_USER" ADD CHECK ("PASSWORD" IS NOT NULL);
ALTER TABLE "GXLY"."TB_USER" ADD CHECK ("CREATETIME" IS NOT NULL);
ALTER TABLE "GXLY"."TB_USER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "GXLY"."TB_USER" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "GXLY"."TB_USER" ADD CHECK ("PASSWORD" IS NOT NULL);
ALTER TABLE "GXLY"."TB_USER" ADD CHECK ("CREATETIME" IS NOT NULL);
ALTER TABLE "GXLY"."TB_USER" ADD CHECK ("UID" IS NOT NULL);

ALTER TABLE "GXLY"."TB_USER" ADD PRIMARY KEY ("UID", "ID");
```

### 6.单元测试

1. 运行src/test/java下的Test类可以做单元测试

### 7.打包部署
1. 项目打包，右键项目>run as>maven build，Goals中填写`clean package`,选中'Skip tests'，然后apply>run
2. 将打好的war包添加到server中，启动
3. 在浏览器中输入`http://localhost:8080/springboot-demo/users/all`，请求json数据测试一下
4. 在浏览器中输入`http://localhost:8080/springboot-demo/index.jsp`测试websocket
>localhost和8080依个人配置的为准
