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

        <title>Articles - Lecoder Admin</title>
        <!-- bootstrap & fontawesome -->
        <link rel="stylesheet" href="${basePath}resources/plugins/ace/assets/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${basePath}resources/plugins/ace/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

        <!-- text fonts -->
        <link rel="stylesheet" href="${basePath}resources/plugins/ace/assets/css/fonts.googleapis.com.css" />

        <!-- ace styles -->
        <link rel="stylesheet" href="${basePath}resources/plugins/ace/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

        <link rel="stylesheet" href="${basePath}resources/plugins/ace/assets/css/ace-skins.min.css" />
        <link rel="stylesheet" href="${basePath}resources/plugins/ace/assets/css/ace-rtl.min.css" />
        
        <link rel="stylesheet" href="${basePath}resources/plugins/pagination/pagination.css" />

        <!-- ace settings handler -->
        <script src="${basePath}resources/plugins/ace/assets/js/ace-extra.min.js"></script>
        
        <!--[if !IE]> -->
        <script src="${basePath}resources/plugins/ace/assets/js/jquery-2.1.4.min.js"></script>
        <script src="${basePath}resources/plugins/pagination/pagination.js"></script>
	</head>
	<body class="no-skin">
        
        <%@ include file="../common/body_top.jsp" %>

        <div class="main-container ace-save-state" id="main-container">
            <script type="text/javascript">
                try{ace.settings.loadState('main-container')}catch(e){}
            </script>

            <c:set var="topmenu" value="articles"/>
            <c:set var="thismenu" value="article_summary"/>
            
            <%@ include file="../common/menu.jsp" %>

            <div class="main-content">
                <div class="main-content-inner">
                    <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                        <ul class="breadcrumb">
                            <li>
                                <i class="ace-icon fa fa-home home-icon"></i>
                                <a href="#">Home</a>
                            </li>
                            <li class="active">Articles</li>
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
                                <div class="clearfix">
                                    <div class="pull-right tableTools-container"></div>
                                </div>
                                <div class="table-header">
                                    Article Summary
                                </div>

                                <!-- div.table-responsive -->

                                <!-- div.dataTables_borderWrap -->
                                <div>
                                    <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th class="center">
                                                <label class="pos-rel">
                                                    <input type="checkbox" class="ace" />
                                                    <span class="lbl"></span>
                                                </label>
                                            </th>
                                            <th>User</th>
                                            <th>Title</th> 
                                            <th class="hidden-480">Summary</th>

                                            <th>
                                                <i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
                                                Create
                                            </th>

                                            <th>Operation</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${pager.result}" var="article">
                                            <tr>
	                                            <td class="center">
	                                                <label class="pos-rel">
	                                                    <input type="checkbox" class="ace" />
	                                                    <span class="lbl"></span>
	                                                </label>
	                                            </td>
	
	                                            <td>
	                                                <a href="#">${article.username}</a>
	                                            </td>
	                                            <td>
	                                               ${article.title}
	                                            </td>
	                                            <td width="40%">${article.summary}</td>
	                                            <td>${article.gmtCreate}</td>
	
	                                            <td>
	                                                <div class="hidden-sm hidden-xs action-buttons">
	                                                    <a class="blue" href="#">
	                                                        <i class="ace-icon fa fa-search-plus bigger-130"></i>
	                                                    </a>
	
	                                                    <a class="green" href="#">
	                                                        <i class="ace-icon fa fa-pencil bigger-130"></i>
	                                                    </a>
	
	                                                    <a class="red" href="#">
	                                                        <i class="ace-icon fa fa-trash-o bigger-130"></i>
	                                                    </a>
	                                                </div>
	
	                                                <div class="hidden-md hidden-lg">
	                                                    <div class="inline pos-rel">
	                                                        <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
	                                                            <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
	                                                        </button>
	
	                                                        <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
	                                                            <li>
	                                                                <a href="#" class="tooltip-info" data-rel="tooltip" title="View">
	                                                                                <span class="blue">
	                                                                                    <i class="ace-icon fa fa-search-plus bigger-120"></i>
	                                                                                </span>
	                                                                </a>
	                                                            </li>
	
	                                                            <li>
	                                                                <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
	                                                                                <span class="green">
	                                                                                    <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
	                                                                                </span>
	                                                                </a>
	                                                            </li>
	
	                                                            <li>
	                                                                <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
	                                                                                <span class="red">
	                                                                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
	                                                                                </span>
	                                                                </a>
	                                                            </li>
	                                                        </ul>
	                                                    </div>
	                                                </div>
	                                            </td>
	                                        </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <script type="text/javascript">
				                        var pa = new Pagination() ;
				                        pa.setDoMethod('get') ;  
				                        pa.setFormName('form1') ;
				                        pa.nextPageStr = "Next";
				                        pa.prevPageStr = "Prev";
				                        pa.current_page = ${pager.currentPageNo} ;
				                        pa.record_num = ${pager.totalCount};
				                        pa.pageUrl = "${basePath}article/list.do" ;
				                        pa.pageSize = 10;
				                        pa.printPage() ;
				                    </script>
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