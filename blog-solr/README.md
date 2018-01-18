# 博客搜索模块
# 简介 
全文搜索引擎solr，版本为5.5.2
安装教程详见：[https://www.cnblogs.com/zhuxiaojie/p/5764680.html](https://www.cnblogs.com/zhuxiaojie/p/5764680.html "solr教程")
# 附加 
部分：managed-schema
```
<field name="id" type="int" indexed="true" stored="true" required="true" multiValued="false" /> 
<field name="title" type="text_ik" indexed="true" stored="true"/>
<field name="summary" type="text_ik" indexed="true" stored="true"/>
<field name="user_id" type="int" indexed="false" stored="true"/>
<field name="username" type="text_general" indexed="true" stored="true"/>
<field name="gmt_modified" type="date" indexed="true" stored="true"/>
<field name="article_content" type="text_ik" indexed="true" stored="false"/>

<field name="keywords" type="text_ik" indexed="true" stored="false"  multiValued="true"/>

<uniqueKey>id</uniqueKey>

<copyField source="title" dest="keywords"/>
<copyField source="summary" dest="keywords"/>
<copyField source="article_content" dest="keywords"/>
```
data-config.xml
```
<dataConfig>
    <!-- 这是mysql的配置，学会jdbc的都应该看得懂 -->
    <dataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/blog?useUnicode=true&amp;characterEncoding=utf8" user="root" password="root"/>
    <document>
        <!-- name属性，就代表着一个文档，可以随便命名 -->
        <!-- query是一条sql，代表在数据库查找出来的数据 -->
        <entity name="blog" query="SELECT t1.id as id,t1.title as title,t1.summary as summary,t1.user_id as user_id,t3.username as username,t1.gmt_modified as gmt_modified,t2.article_content as article_content FROM blog_article t1 LEFT JOIN blog_article_content t2 ON t1.id = t2.article_id LEFT JOIN blog_user_info t3 ON t1.user_id = t3.user_id">
            <!-- 每一个field映射着数据库中列与文档中的域，column是数据库列，name是solr的域(必须是在managed-schema文件中配置过的域才行) -->
           
			<field column="id" name="id"/>
            <field column="title" name="title"/>
            <field column="summary" name="summary"/>
            <field column="user_id" name="user_id"/>
            <field column="username" name="username"/>
			<field column="gmt_modified" name="gmt_modified"/>
            <field column="article_content" name="article_content"/>
        </entity>
    </document>
</dataConfig>
```