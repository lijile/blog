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
    <title>登录</title>
    <link type="text/css" rel="stylesheet" href="${basePath}resources/css/sign-in.css">
    <link type="text/css" rel="stylesheet" href="${basePath}resources/plugins/editor-md/css/font-awesome.css">
</head>
<body>
<div class="home">
    <div class="logo">
        <img src="${basePath}resources/img/logo.png">
    </div>
    <form action="do-sign-in" method="post">
        <div class="inputUser">
            <i class="blog blog-user"></i>
            <input type="text" name="username" placeholder="用户名">
        </div>
        <div class="inputPassword">
            <i class="blog blog-password"></i>
            <input type="password" name="password" placeholder="密码">
        </div>

        <div class="btnLogin">
            <input type="submit" value="登录">
        </div>

        <div class="btnRegister">
            <a href="sign-up">注册</a>
        </div>
        <c:if test="${error != null}">
            <div class="errorDiv">${error }</div>
        </c:if>
    </form>
</div>
</body>
</html>