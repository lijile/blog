<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath",basePath);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的博客</title>
    <link type="text/css" rel="stylesheet" href="resources/css/home.css">
</head>
<body>

    <%@ include file="/WEB-INF/page/header.jsp" %>

    <div id="main" class="main">
        <div id="mainContent">
            <div class="forFlow">
                
            </div>
        </div>
        <div id="sideBar">
            <div class="newsItem">
                <div class="itemTitle">随笔分类</div>
                <div class="itemList">
                    <ul>
                        <li><a href="#">Android (10)</a></li>
                        <li><a href="#">Linux (5)</a></li>
                        <li><a href="#">基于Javaweb的公众号开发 (6)</a></li>
                    </ul>
                </div>
            </div>
            <div class="newsItem">
                <div class="itemTitle">阅读排行榜</div>
                <div class="itemList">
                    <ul>
                        <li><a href="#">Android 开发艺术</a></li>
                        <li><a href="#">深入理解java虚拟机读书笔记</a></li>
                        <li><a href="#">乱码汇总</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <script src="${basePath}resources/js/index.js"></script>
</body>
</html>