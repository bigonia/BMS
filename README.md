# BackStageMS

### 这是一个博客网站的后台管理系统；
##### 项目描述：
######   后台登录认证以及权限管理：管理员登录后，可管理所有文章、标签、用户等信息；并且管理员可以实现对其他用户的权限控制。如：管理员Admin可以对用户Jack添加对文章的编辑功能。
1. 后端部分：
- 技术栈：springboot+springmvc+mybatis+spring+swagger
- swagger-ui管理接口；
- 数据库使用了MySQL，使用mybatis进行多表查询操作；
- 后端项目的部署以及启动：
> 1.用mybatis-generator生成项目所需类和接口：
    
```
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```
> 2.启动项目
	
```
mvn spring-boot:run
```
- ....

2. 前端部分

    <html>
    <a href="https://panjiachen.github.io/vue-element-admin-site/zh/">vue-element-admin</a>
    </html>

- 使用了vue-element-admin项目，因为本人对前端不了解，所以只能做到使用，也就是对着文档涂涂改改勉强写出来了；
- 前端项目的部署以及启动：
> 1) 进入项目中
	 cd vue-element-admin-site

> 2) 安装依赖
	 npm install 

> 3) 运行项目
	 npm run dev

    