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
    <title>编辑文章</title>
    <link type="text/css" rel="stylesheet" href="${basePath}resources/css/editor.css">
    <link type="text/css" rel="stylesheet" href="${basePath}resources/plugins/editor-md/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${basePath}resources/plugins/editor-md/css/editormd.css" />
    <link type="text/css" rel="stylesheet" href="${basePath}resources/plugins/bootstrap/css/bootstrap.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="main" style="margin: 60px 0 0 0">
    <input type="hidden" value="${basePath}" id="basePath"/>
    <input type="hidden" value="${sessionScope.blog_user.username}" id="username"/>
    <div class="titleEdit">
        <input type="text" name="title" placeholder="文章标题" class="inputDiv" />
        <div class="submitArticle">发表博客</div>
    </div>
    <div id="editormd">
                <textarea style="display:none;">[TOC]

#### Disabled options

- TeX (Based on KaTeX);
- Emoji;
- Task lists;
- HTML tags decode;
- Flowchart and Sequence Diagram;

#### Editor.md directory

    editor.md/
            lib/
            css/
            scss/
            tests/
            fonts/
            images/
            plugins/
            examples/
            languages/
            editormd.js
            ...

```html
&lt;!-- English --&gt;
&lt;script src="../dist/js/languages/en.js"&gt;&lt;/script&gt;

&lt;!-- 繁體中文 --&gt;
&lt;script src="../dist/js/languages/zh-tw.js"&gt;&lt;/script&gt;
```
</textarea>
    </div>
</div>
<!-- 文章设置（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">文章设置</h4>
            </div>
            <div class="modal-body">
                <div class="summary">
                    <span class="tabName">文章摘要</span>
                    <textarea placeholder="摘要"></textarea>
                </div>
                <div class="personalType">
                    <span class="tabName">个人标签</span>
                    <div class="inputType">
                        <input type="text" maxlength="10">
                    </div>
                </div>
                <div class="myType">
                    
                </div>
                <div class="articleType">
                    <span class="tabName">文章分类</span>
                    <div class="inputType">
                        <select id="categorySelect">
                            
                        </select>
                    </div>
                </div>
                <div class="moreArticle">
                    <span class="tabName">更多文章</span>
                    <div class="inputMore">
                        <input type="url" name="extra_url">
                    </div>
                </div>
            </div>
            <input type="hidden" id="rid"/>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="submit">确认提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<script src="${basePath}resources/plugins/jquery/jquery-2.1.1.min.js"></script>
<script src="${basePath}resources/plugins/editor-md/editormd.js"></script>
<script src="${basePath}resources/plugins/bootstrap/js/bootstrap.js"></script>
<script src="${basePath}resources/js/editor.js"></script>
<script type="text/javascript">
    var editormd;
    $(function() {
    	// 获取窗口宽度
    	if (window.innerWidth)
    		   winWidth = window.innerWidth;
    	else if ((document.body) && (document.body.clientWidth))
    		   winWidth = document.body.clientWidth;
    	// 获取窗口高度
    	if (window.innerHeight)
    		   winHeight = window.innerHeight;
    	else if ((document.body) && (document.body.clientHeight))
    		   winHeight = document.body.clientHeight;
    	// 通过深入 Document 内部对 body 进行检测，获取窗口大小
    	if (document.documentElement && document.documentElement.clientHeight && document.documentElement.clientWidth)
    	{
	    	winHeight = document.documentElement.clientHeight;
	    	winWidth = document.documentElement.clientWidth;
    	}
    	var headerHeight = $(".header").height();
        editormd = editormd("editormd", {
            width   : "100%",
            height  : (winHeight - headerHeight - 100),
            syncScrolling : "single",
            path    : "${basePath}resources/plugins/editor-md/lib/"
        });
    });
</script>
</body>
</html>