<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
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

        <title>Users - Lecoder Admin</title>
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

            <c:set var="topmenu" value="users"/>
            <c:set var="thismenu" value="create_new_user"/>
            
            <%@ include file="../common/menu.jsp" %>

            <div class="main-content">
                <div class="main-content-inner">
                    <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                        <ul class="breadcrumb">
                            <li>
                                <i class="ace-icon fa fa-home home-icon"></i>
                                <a href="#">Home</a>
                            </li>
                            <li class="active">Users</li>
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
                                <form id="create-user-form" class="form-horizontal" action="doCreateUser.do" method="post" role="form">
                                    <div class="space-4"></div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">User Name</label>

                                        <div class="col-sm-9">
                                            <span class="input-icon" style="width:400px;">
                                                <input type="text" name="username" placeholder="user name" class="col-xs-10" required/>
                                                <i class="ace-icon fa fa-user orange"></i>
                                            </span>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Full Name</label>

                                        <div class="col-sm-9">
                                            <span class="input-icon" style="width:400px;">
                                                <input type="text" name="fullname" placeholder="full name" class="col-xs-10" required/>
                                                <i class="ace-icon fa fa-user orange"></i>
                                            </span>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Cellphone</label>

                                        <div class="col-sm-9">
                                            <span class="input-icon" style="width:400px;">
                                                <input type="text" name="cellphone" placeholder="cellphone" class="col-xs-10"/>
                                                <i class="ace-icon fa fa-mobile-phone orange"></i>
                                            </span>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Password</label>

                                        <div class="col-sm-9">
                                            <span class="input-icon" style="width:400px;">
                                                <input type="password" name="password" placeholder="password" class="col-xs-10" required/>
                                                <i class="ace-icon fa fa-lock orange"></i>
                                            </span>
                                        </div>
                                    </div>
                                    <div class="space-4"></div>

                                    <div class="clearfix form-actions">
                                        <div class="col-md-offset-3 col-md-9">
                                            <button class="btn btn-info" type="submit">
                                                <i class="ace-icon fa fa-check bigger-110"></i>
                                                Submit
                                            </button>

                                            &nbsp; &nbsp; &nbsp;
                                            <button class="btn" type="reset">
                                                <i class="ace-icon fa fa-undo bigger-110"></i>
                                                Reset
                                            </button>
                                        </div>
                                    </div>

                                </form>
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

        <!-- page specific plugin scripts -->

        <script src="${basePath}resources/plugins/ace/assets/js/jquery-ui.custom.min.js"></script>
        <script src="${basePath}resources/plugins/ace/assets/js/jquery.ui.touch-punch.min.js"></script>
        <script src="${basePath}resources/plugins/ace/assets/js/jquery.easypiechart.min.js"></script>
        <script src="${basePath}resources/plugins/ace/assets/js/jquery.sparkline.index.min.js"></script>
        <script src="${basePath}resources/plugins/ace/assets/js/jquery.flot.min.js"></script>
        <script src="${basePath}resources/plugins/ace/assets/js/jquery.flot.pie.min.js"></script>
        <script src="${basePath}resources/plugins/ace/assets/js/jquery.flot.resize.min.js"></script>

        <!-- ace scripts -->
        <script src="${basePath}resources/plugins/ace/assets/js/ace-elements.min.js"></script>
        <script src="${basePath}resources/plugins/ace/assets/js/ace.min.js"></script>

        <!-- inline scripts related to this page -->
        <script type="text/javascript">
            jQuery(function($) {
                $('.easy-pie-chart.percentage').each(function(){
                    var $box = $(this).closest('.infobox');
                    var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
                    var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
                    var size = parseInt($(this).data('size')) || 50;
                    $(this).easyPieChart({
                        barColor: barColor,
                        trackColor: trackColor,
                        scaleColor: false,
                        lineCap: 'butt',
                        lineWidth: parseInt(size/10),
                        animate: ace.vars['old_ie'] ? false : 1000,
                        size: size
                    });
                });
            
            })
        </script>
    </body>
</html>