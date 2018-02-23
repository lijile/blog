# 我的博客
# 简介 
基于Spring+SpringMVC+Mybatis分布式开发系统架构
# 后端技术
|技术|名称|官网|
|----|----|----|
|Spring Framework|容器|http://projects.spring.io/spring-framework/|
|SpringMVC|MVC框架|http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc|
|MyBatis|ORM框架|http://www.mybatis.org/mybatis-3/zh/index.html|
|ZooKeeper|分布式协调服务|http://zookeeper.apache.org/|
|Dubbo|分布式服务框架|http://dubbo.io/|
|solr|全文搜索引擎|http://lucene.apache.org/solr/|
|Apache Shiro|安全框架|http://shiro.apache.org/|
|Maven|项目构建管理|http://maven.apache.org/|
# 前端技术
|技术|名称|官网|
|----|----|----|
|jQuery|函式库|    http://jquery.com/|
|Editor.md|Markdown编辑器|https://github.com/pandao/editor.md|
|Bootstrap|前端框架|http://getbootstrap.com/|
|Ace Admin|后台管理界面模板|https://github.com/bopoda/ace|
# 模块介绍
|模块名|描述|
|----|----|
|blog-common|公共模块，如工具类|
|blog-pojo|简单java对象模块，用于存放持久对象类，值对象类等|
|blog-dao|服务端DAO模块，数据访问对象，主要是数据库操作|
|blog-interface|服务层接口，方便表示层调用和分布式部署|
|blog-service|服务层接口实现|
|blog-solr|博客全文搜索模块|
|blog-ui|ui模块，前端静态网页|
|blog-admin|后台管理系统模块|
|blog-web|博客网站模块|
# 主要系统截图
- 前端博客
![登录](https://raw.githubusercontent.com/lijile/blog/master/blog-ui/src/main/webapp/images/search.png)

![编辑器](https://raw.githubusercontent.com/lijile/blog/master/blog-ui/src/main/webapp/images/editor.png)

![浏览](https://raw.githubusercontent.com/lijile/blog/master/blog-ui/src/main/webapp/images/preview.png)

- 后台管理
![登录](https://raw.githubusercontent.com/lijile/blog/master/blog-ui/src/main/webapp/images/admin_article_summary.png)

# 本地测试运行顺序
mvn install blog-common  
mvn install blog-pojo  
mvn install blog-dao  
mvn install blog-interface  
mvn install blog-service  
mvn install blog-solr  
mvn tomcat7:run blog-web  