<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" rel="stylesheet" href="${basePath}resources/css/header.css">
<input name="basePath" type="hidden" value="${basePath}"/>
<div class="header">
    <div class="logo">
        <img src="${basePath}resources/img/logo.png">
    </div>
    <div class="nav">
        <ul class="navList">
            <li><a href="${basePath}">首页</a></li>
            <li><a href="#">推荐</a></li>
            <li><a href="#">留言板</a></li>
            <li><div><input type="text" id="keywords" name="keywords" placeholder="搜索"/></div></li>
        </ul>
    </div>
    <div class="write">
        <a class="writeArticle" href="${basePath}article/editor">写文章</a>
    </div>
    <div class="profile">
        <c:choose>
            <c:when test="${sessionScope.blog_user == null}">
            <div class="sign">
                <a class="signIn" href="${basePath }user/sign-in">登录</a>
                <a class="signUp" href="${basePath }user/sign-up">注册</a>
            </div>
            </c:when>
            <c:otherwise>
                <div class="myhome">
	                <img src="${basePath}resources/img/avatar.png">
	                <ul class="dropdown-menu2">
	                    <li>
				            <a href="#"><i class="iconfont ic-navigation-profile"></i><span>我的主页</span></a>                
	                    </li>
	                    <li>
	                        <a href="${basePath }user/sign-out"><i class="iconfont ic-navigation-profile"></i><span>退出</span></a>                
	                    </li>
	                </ul>
                </div>
            </c:otherwise>
        </c:choose>
        
    </div>
</div>
<script src="${basePath}resources/plugins/jquery/jquery-2.1.1.min.js"></script>
<script src="${basePath}resources/js/header.js"></script>