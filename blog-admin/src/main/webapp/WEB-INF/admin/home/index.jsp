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

        <title>Dashboard - Lecoder Admin</title>
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
	</head>
	<body class="no-skin">
        
        <%@ include file="../common/body_top.jsp" %>

        <div class="main-container ace-save-state" id="main-container">
            <script type="text/javascript">
                try{ace.settings.loadState('main-container')}catch(e){}
            </script>

            <c:set var="topmenu" value="dashboard"/>
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
                            <li class="active">Dashboard</li>
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
                                <div class="alert alert-block alert-success">
                                    <button type="button" class="close" data-dismiss="alert">
                                        <i class="ace-icon fa fa-times"></i>
                                    </button>

                                    <i class="ace-icon fa fa-check green"></i>
                                    Welcome to
                                    <strong class="green">
                                        Lecoder Admin
                                    </strong>
                                </div>
                                <!-- PAGE CONTENT ENDS -->
                            </div><!-- /.col -->

                            <div class="col-lg-12">

                                <div class="profile-user-info profile-user-info-striped">
                                    <div class="profile-info-row">
                                        <div class="profile-info-name"> Java Version </div>

                                        <div class="profile-info-value">
                                            <span class="editable" id="java_version"></span>
                                        </div>
                                    </div>

                                    <div class="profile-info-row">
                                        <div class="profile-info-name"> Location </div>

                                        <div class="profile-info-value">
                                            <i class="fa fa-map-marker light-orange bigger-110"></i>
                                            <span class="editable" id="address"></span>
                                        </div>
                                    </div>

                                    <div class="profile-info-row">
                                        <div class="profile-info-name"> OS / Hardware </div>

                                        <div class="profile-info-value">
                                            <span class="editable" id="os"></span>
                                        </div>
                                    </div>

                                    <div class="profile-info-row">
                                        <div class="profile-info-name"> Java Memory </div>

                                        <div class="profile-info-value">
                                            <div class="infobox infobox-blue2">
                                                <div class="infobox-progress">
                                                    <div class="easy-pie-chart percentage" data-percent="30" data-size="46">
                                                        <span class="percent" id="used_percent">0</span>%
                                                    </div>
                                                </div>

                                                <div class="infobox-data">
                                                    <span class="infobox-text">used</span>

                                                    <div class="infobox-content">
                                                        <span class="bigger-110" id="free_memory">0</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                            </div>

                        </div><!-- /.row -->
                    </div><!-- /.page-content -->
                </div>
            </div><!-- /.main-content -->

            <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
                <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
            </a>
        </div><!-- /.main-container -->

        <!-- basic scripts -->

        <!--[if !IE]> -->
        <script src="${basePath}resources/plugins/ace/assets/js/jquery-2.1.4.min.js"></script>
        <script src="${basePath}resources/js/index.js"></script>

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