<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath",basePath);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>主页</title>
    <link type="text/css" rel="stylesheet" href="${basePath}resources/css/home.css">
</head>
<body>

    <%@ include file="../header.jsp" %>

    <div class="main">
        <div id="mainContent">
            <div class="forFlow">
                <c:forEach items="${articleList}" var="article">
                    <div class="day">
	                    <div class="postTitle">
	                        <a class="postTitle2" href="${basePath}${article.username}/${article.id }">${article.title }</a>
	                    </div>
	                    <div class="postCon">
	                        <div class="c_b_p_desc">摘要:${article.summary }
	                            <a href="${basePath}${username}/${article.id }" class="c_b_p_desc_readmore">阅读全文</a>
	                        </div>
	                    </div>
	                    <div class="clear"></div>
	                    <div class="postDesc">posted @ <fmt:formatDate value="${article.gmtCreate}" pattern="yyyy-MM-dd HH:mm"/>  阅读(${article.readCount }) 评论(${article.commentCount })
	                        <a href="#">编辑</a>
	                    </div>
	                    <div class="clear"></div>
	                </div>
                </c:forEach>
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

</body>
</html>