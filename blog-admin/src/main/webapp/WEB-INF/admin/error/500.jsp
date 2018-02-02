<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
	request.setAttribute("basePath",basePath);
%>
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <meta name="description" content="overview &amp; stats" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

        <title>500 - Lecoder Admin</title>
        <!-- bootstrap & fontawesome -->
        <link rel="stylesheet" href="${basePath}resources/plugins/ace/assets/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${basePath}resources/plugins/ace/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

        <!-- text fonts -->
        <link rel="stylesheet" href="${basePath}resources/plugins/ace/assets/css/fonts.googleapis.com.css" />

        <!-- ace styles -->
        <link rel="stylesheet" href="${basePath}resources/plugins/ace/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

        <link rel="stylesheet" href="${basePath}resources/plugins/ace/assets/css/ace-skins.min.css" />
        <link rel="stylesheet" href="${basePath}resources/plugins/ace/assets/css/ace-rtl.min.css" />
        
        <!-- ace settings handler -->
        <script src="${basePath}resources/plugins/ace/assets/js/ace-extra.min.js"></script>
        
        <!--[if !IE]> -->
        <script src="${basePath}resources/plugins/ace/assets/js/jquery-2.1.4.min.js"></script>
	</head>
	<body class="no-skin">
        
        <%@ include file="../common/body_top.jsp" %>

        <div class="main-container ace-save-state" id="main-container">
            <script type="text/javascript">
                try{ace.settings.loadState('main-container')}catch(e){}
            </script>

            <c:set var="topmenu" value="error"/>
            <c:set var="thismenu" value=""/>
            
            <%@ include file="../common/menu.jsp" %>

            <div class="main-content">
                <div class="main-content-inner">
                    <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                        <ul class="breadcrumb">
                            <li>
                                <i class="ace-icon fa fa-home home-icon"></i>
                                <a href="#">Home</a>
                            </li>
                            <li class="active">Error</li>
                        </ul><!-- /.breadcrumb -->

                        <div class="nav-search" id="nav-search">
                            <form class="form-search">
                                <span class="input-icon">
                                    <input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
                                    <i class="ace-icon fa fa-search nav-search-icon"></i>
                                </span>
                            </form>
                        </div><!-- /.nav-search -->
                    </div>

                    <div class="page-content">
                        
                        <%@ include file="../common/ace_settings.jsp" %>

                        <div class="row">
                            <div class="col-xs-12">
                                <!-- PAGE CONTENT BEGINS -->

                                <div class="error-container">
                                    <div class="well">
                                        <h1 class="grey lighter smaller">
                                            <span class="blue bigger-125">
                                                <i class="ace-icon fa fa-random"></i>
                                                500
                                            </span>
                                            Something Went Wrong
                                        </h1>

                                        <hr />
                                        <h3 class="lighter smaller">
                                            But we are working
                                            <i class="ace-icon fa fa-wrench icon-animated-wrench bigger-125"></i>
                                            on it!
                                        </h3>

                                        <div class="space"></div>

                                        <div>
                                            <h4 class="lighter smaller">Meanwhile, try one of the following:</h4>

                                            <ul class="list-unstyled spaced inline bigger-110 margin-15">
                                                <li>
                                                    <i class="ace-icon fa fa-hand-o-right blue"></i>
                                                    Read the faq
                                                </li>

                                                <li>
                                                    <i class="ace-icon fa fa-hand-o-right blue"></i>
                                                    Give us more info on how this specific error occurred!
                                                </li>
                                            </ul>
                                        </div>

                                        <hr />
                                        <div class="space"></div>

                                        <div class="center">
                                            <a href="javascript:history.back()" class="btn btn-grey">
                                                <i class="ace-icon fa fa-arrow-left"></i>
                                                Go Back
                                            </a>

                                            <a href="#" class="btn btn-primary">
                                                <i class="ace-icon fa fa-tachometer"></i>
                                                Dashboard
                                            </a>
                                        </div>
                                    </div>
                                </div>

                                <!-- PAGE CONTENT ENDS -->
                            </div><!-- /.col -->
                        </div><!-- /.row -->
                    </div><!-- /.page-content -->
                </div>
            </div><!-- /.main-content -->

            <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
                <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
            </a>
        </div><!-- /.main-container -->

        <!-- basic scripts -->

        <script type="text/javascript">
            if('ontouchstart' in document.documentElement) document.write("<script src='${basePath}resources/plugins/ace/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
        </script>
        <script src="${basePath}resources/plugins/ace/assets/js/bootstrap.min.js"></script>

        <!-- ace scripts -->
        <script src="${basePath}resources/plugins/ace/assets/js/ace-elements.min.js"></script>
        <script src="${basePath}resources/plugins/ace/assets/js/ace.min.js"></script>

    </body>
</html>