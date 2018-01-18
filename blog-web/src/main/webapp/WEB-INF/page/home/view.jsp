<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath",basePath);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${article.title}</title>
    <link type="text/css" rel="stylesheet" href="${basePath}resources/css/preview.css">
    <link rel="stylesheet" href="${basePath}resources/plugins/editor-md/css/editormd.preview.css" />
</head>
<body>
    <%@ include file="../header.jsp" %>
    <div class="main">
        <div class="title">
            <h1>${article.title }</h1>
        </div>
        <div class="desc">
            发布时间：<fmt:formatDate value="${article.gmtCreate}" pattern="yyyy-MM-dd HH:mm"/> &nbsp;&nbsp;作者：<a href="${basePath}${article.username}">${article.fullname }</a>&nbsp;&nbsp;&nbsp;
        </div>
        <div id="test-editormd-view2">
                <textarea id="append-test" style="display:none;">${article.articleContent }
                </textarea>
        </div>
    </div>
    <script src="${basePath}resources/plugins/editor-md/js/jquery.min.js"></script>
    <script src="${basePath}resources/plugins/editor-md/lib/marked.min.js"></script>
    <script src="${basePath}resources/plugins/editor-md/lib/prettify.min.js"></script>

    <script src="${basePath}resources/plugins/editor-md/lib/raphael.min.js"></script>
    <script src="${basePath}resources/plugins/editor-md/lib/underscore.min.js"></script>
    <script src="${basePath}resources/plugins/editor-md/lib/sequence-diagram.min.js"></script>
    <script src="${basePath}resources/plugins/editor-md/lib/flowchart.min.js"></script>
    <script src="${basePath}resources/plugins/editor-md/lib/jquery.flowchart.min.js"></script>

    <script src="${basePath}resources/plugins/editor-md/editormd.js"></script>
    <script type="text/javascript">
        $(function() {
            var testEditormdView, testEditormdView2;

            $.get("test.md", function(markdown) {

                testEditormdView = editormd.markdownToHTML("test-editormd-view", {
                    markdown        : markdown ,//+ "\r\n" + $("#append-test").text(),
                    //htmlDecode      : true,       // 开启 HTML 标签解析，为了安全性，默认不开启
                    htmlDecode      : "style,script,iframe",  // you can filter tags decode
                    //toc             : false,
                    tocm            : true,    // Using [TOCM]
                    //tocContainer    : "#custom-toc-container", // 自定义 ToC 容器层
                    //gfm             : false,
                    //tocDropdown     : true,
                    // markdownSourceCode : true, // 是否保留 Markdown 源码，即是否删除保存源码的 Textarea 标签
                    emoji           : true,
                    taskList        : true,
                    tex             : true,  // 默认不解析
                    flowChart       : true,  // 默认不解析
                    sequenceDiagram : true,  // 默认不解析
                });

                //console.log("返回一个 jQuery 实例 =>", testEditormdView);

                // 获取Markdown源码
                //console.log(testEditormdView.getMarkdown());

                //alert(testEditormdView.getMarkdown());
            });

            testEditormdView2 = editormd.markdownToHTML("test-editormd-view2", {
                htmlDecode      : "style,script,iframe",  // you can filter tags decode
                emoji           : true,
                taskList        : true,
                tex             : true,  // 默认不解析
                flowChart       : true,  // 默认不解析
                sequenceDiagram : true,  // 默认不解析
            });
        });
    </script>
</body>
</html>