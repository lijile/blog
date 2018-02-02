/**
使用方法:
//初始化
var pa = new Pagination() ;
pa.current_page = 2 ;
pa.record_num = 200 ;
//打印分页信息
pa.printPage() ;

还可以设置更多属性。请参考下面的一些变量
*/

function Pagination()
{
}

//变量设置，可以重新设置
/**
 *当前页，默认为0 
 */
Pagination.prototype.current_page = 0 ;
/**
 *记录数，默认为0 
 */
Pagination.prototype.record_num = 0 ;
/**
 *URL地址，默认为# 
 */
Pagination.prototype.pageUrl = "#" ;
/**
 *页码参数名，默认为page 
 */
Pagination.prototype.pageStr = "page" ;
/**
 *每页显示记录数，默认为10 
 */
Pagination.prototype.pageSize = 10 ;
/**
 *下一页显示文字 
 */
Pagination.prototype.nextPageStr = "下一页" ;
/**
 *上一页显示文字 
 */
Pagination.prototype.prevPageStr = "上一页" ;
/**
 *开始显示的页码个数 
 */
Pagination.prototype.start_num = 2 ;
/**
 *尾部显示的页码个数 
 */
Pagination.prototype.end_num = 2 ;
/**
 *中间左侧显示页码个数 
 */
Pagination.prototype.left_num_display = 3 ;
/**
 * 中间右侧显示页码个数
 */
Pagination.prototype.right_num_display = 3 ;
/**
 * 表单提交方法,总共3种方法：oget,get,post
 * 默认为oget,是为了兼容旧的提交方法
 */
Pagination.prototype.domethod = 'oget' ;
/**
 * 表单名称，用于处理表单参数
 */
Pagination.prototype.formName = '' ;
/**
 *表单参数,外部不要调用 
 */
Pagination.prototype.formParams = new Array() ;
/**
 *显示自定义分页大小 
 */
Pagination.prototype.showCusPageSize = false ;
/**
 *显示GOGO按钮 
 */
Pagination.prototype.showGotoButton = false ;

/**
 *设置提交方法 
 * @param {Object} domethod 提交方法类型，只能是get或者post
 */
Pagination.prototype.setDoMethod = function( domethod )
{
    if( domethod!='get'&&domethod!='post'&&domethod!='oget' )
    {
        alert('提交方法设置错误') ;
        return ;
    }
    this.domethod = domethod ;
}
/**
 *设置表单名称(在一个页面必须是唯一的)
 * @param {Object} formname 表单名称
 */
Pagination.prototype.pushParam = function( keyy,valee )
{
    var thisArray = new Array();
    thisArray.push( keyy ) ;
    if( valee==undefined )
        thisArray.push( '' ) ;
    else
        thisArray.push( valee ) ;
    this.formParams.push( thisArray ) ;
}


Pagination.prototype.setFormName = function( formName )
{
    var selfmy = this ;
    this.formName = formName ;
    var hidden_obj = $("form[name='"+formName+"'] input[type='hidden']") ;
    hidden_obj.each(function(){
        var keyy = $(this).attr('name') ;
        var valuee = $(this).val() ;
        selfmy.pushParam( keyy, valuee ) ;
    }) ;
    var text_obj = $("form[name='"+formName+"'] input[type='text']") ;
    // alert( this.formParams[0] ) ;
    text_obj.each(function(){
        var keyy = $(this).attr('name') ;
        var valuee = $(this).val() ;
        selfmy.pushParam( keyy, valuee ) ;
    }) ;
    
    //checkbox
    var checkbox_obj = $("form[name='"+formName+"'] input[type='checkbox']:checked") ;
    checkbox_obj.each(function(){
        var keyy = $(this).attr('name') ;
        var valuee = $(this).val() ;
        selfmy.pushParam( keyy, valuee ) ;
    }) ;
    
    //radio
    var radio_obj = $("form[name='"+formName+"'] input[type='radio']:checked") ;
    radio_obj.each(function(){
        var keyy = $(this).attr('name') ;
        var valuee = $(this).val() ;
        selfmy.pushParam( keyy, valuee ) ;
    }) ;
    
    //select
    var select_obj = $("form[name='"+formName+"'] select option:selected") ;
    select_obj.each(function(){
        var keyy = $(this).parent().attr('name') ;
        var valuee = $(this).val() ;
        selfmy.pushParam( keyy, valuee ) ;
    }) ;
	
    
}
//扩展String函数
String.prototype.myyStartWith=function(str){
  var reg=new RegExp("^"+str);     
  return reg.test(this);        
}
//扩展String函数 
String.prototype.myyEndWith=function(str){
  var reg=new RegExp(str+"$");     
  return reg.test(this);        
}

Pagination.prototype.printPage = function()
{
    if( this.pageUrl.indexOf("?")!=-1&&this.pageUrl.myyEndWith("&") )
       this.pageUrl = this.pageUrl.substring(0,this.pageUrl.length) ;//去掉尾部的&
	var thismethod = this.domethod ;
	if( thismethod=='oget' )
		thismethod = "get" ;
    document.write("<div id='pagination_hidden_div' style='display: none'>") ;
    document.write("<form name='pagination_hidden_form' id='pagination_hidden_form' method='"+thismethod+"' action='"+this.pageUrl+"'>") ;
    document.write("<input type='hidden' name='" + this.pageStr + "' value='0'/>" ) ;//页码
    document.write("<input type='hidden' name='pageSize' value='" + this.pageSize + "'/>" ) ;//
    for( var forvalue=0;forvalue<this.formParams.length;forvalue++)
    {
        document.write("<input type='hidden' name='"+ this.formParams[forvalue][0] +"' value='"+ this.formParams[forvalue][1] +"'/>") ;
    }
    document.write("</form>") ;
    document.write("</div>") ;
	var pageNum = 0 ;//页数
	var current_print_page = 0 ;
	pageNum = this.record_num/this.pageSize ;//做了除法后，结果值可能会变成double类型，下面的语句会将数值强制转换为int类型(如：3.999转换为3  3.22转换为3)
	pageNum = parseInt(pageNum) ;//
	document.write("<div class='mypagination' id='_pagination_'>") ;
	if( this.record_num>0&&this.current_page<=pageNum )
	{
		if( this.record_num%this.pageSize==0 )
			pageNum = pageNum -1 ;
		if(this.current_page==0)
			document.write("<a class='current prev'>"+this.prevPageStr+"</a>") ;//没有上一页
		else
			document.write("<a class='prev' href='#' title='" + (this.current_page-1) + "'>"+this.prevPageStr+"</a>") ;
		for( var i=0;i<this.current_page&&i<this.start_num;i++ )
		{
			document.write("<a href='#' title='" + i + "'>"+ (i+1) +"</a>") ;
			current_print_page++ ;
		}
		if( current_print_page<(this.current_page-this.left_num_display) )
			document.write("<span>...</span>") ;
		for( var i=(this.current_page-this.left_num_display);i<this.current_page;i++ )
		{
			if(i>=current_print_page)
			{
				document.write("<a href='#' title='" + i + "'>"+ (i+1) +"</a>") ;
				current_print_page++ ;
			}
		}
		document.write("<span class='current' title='" + this.current_page + "'>"+(this.current_page+1)+"</span>") ;
		current_print_page = this.current_page+1 ;
		for(var i=current_print_page;i<(this.current_page+this.right_num_display+1);i++)
		{
			if( i<=pageNum )
			{
				document.write("<a href='#' title='" + current_print_page + "'>"+ (current_print_page+1) +"</a>") ;
				current_print_page++ ;
			}
		}
		if( current_print_page<(pageNum-2) )
		{
			document.write("<span>...</span>") ;
			current_print_page = pageNum-(this.end_num-1) ;
		}
		//alert( current_print_page ) ;
		for( var i=current_print_page;i<=pageNum;i++ )
		{
			if( current_print_page<=pageNum )
				document.write("<a href='#' title='" + current_print_page + "'>"+ (current_print_page+1) +"</a>") ;
			current_print_page++ ;
		}
		if(this.current_page==pageNum)
			document.write("<a class='current next'>"+this.nextPageStr+"</a>") ;
		else
			document.write("<a class='next' href='#' title='" + (this.current_page+1) + "'>"+this.nextPageStr+"</a>") ;
		//自定义分页记录数
		document.write("<select id='_pagination_pageSize' name='_pagination_pageSize' style='display:none'>") ;
		document.write("<option value='0'>自定义分页</option>") ;
		document.write("<option value='15'>每页15条</option>") ;
		document.write("<option value='30'>每页30条</option>") ;
		document.write("<option value='50'>每页50条</option>") ;
		document.write("<option value='100'>每页100条</option>") ;
		document.write("</select>") ;
		//跳转到指定页
		document.write("<div id='_pagination_gotodiv_' style='display:none'>") ;
		document.write("<span class='textpattern'>跳转到</span>") ;
		document.write("<input type='text' name='_go_to_page_'/>") ;
		document.write("<span class='textpattern'>页</span>") ;
		document.write("<button id='_pagination_go_'>走</button>") ;
		document.write("</div>") ;
		
		//////////改变href链接地址
		var page_link_obj = $("div[id='_pagination_'] a") ;
        page_link_obj.each(function(){
            $(this).attr( 'href','#' ) ;
        }) ;
        //如果是post提交,添加点击事件
        if( this.domethod=='post'||this.domethod=='get' )
        {
            var thisPageStr = this.pageStr ;//页码参数名
            page_link_obj.bind("click",function(){
            	if($(this).attr("title") == undefined){
            		return ;
            	}
                var text_obj = $("form[name='pagination_hidden_form'] input[name='"+thisPageStr+"']") ;
                text_obj.val($(this).attr('title')) ;
                $("#pagination_hidden_form").submit() ;
            }) ;
        }
        else if( this.domethod=='oget' )
        {
            var thispagestr = this.pageStr ;//页码参数名
            var thispageurl = this.pageUrl ;
            if( thispageurl.indexOf("?")==-1 )
                thispageurl = thispageurl + "?" ;
            $.each( this.formParams,function(i,data){
            	thispageurl = thispageurl + "&" + data[0] + "=" + data[1] ;
            }) ;
            page_link_obj.each(function(){
                $(this).attr( 'href',thispageurl + "&" + thispagestr + "=" + $(this).attr( 'title' ) ) ;///////////////////////////////////////////////////////////////////////没有获得全部参数
            }) ;
        }
        //选中自定义记录数
        var this_pageSize = this.pageSize ;
        $("select[name='_pagination_pageSize'] option").each( function() {
            if( this_pageSize==$(this).val() )
                $(this).attr( "selected",true ) ;
        }) ;

        //添加自定义记录数事件监听
		var thiscurrent_page = this.current_page ;
		thiscurrent_page = parseInt( thiscurrent_page ) ;
        $("select[name='_pagination_pageSize']").change( function(){
			var current_pageSize = $("form[name='pagination_hidden_form'] input[name='pageSize']").val() ;
			current_pageSize = parseInt(current_pageSize) ;
			
            var new_pageSize = $("select[name='_pagination_pageSize'] option:selected").val() ;//获得当前被选中元素
			new_pageSize = parseInt(new_pageSize) ;
			
			var testrecordnum = current_pageSize * thiscurrent_page + 1;
			var thispageNum = 0 ;//页数
			if( new_pageSize!=0 )
			{
				thispageNum = testrecordnum/new_pageSize ;//做了除法后，结果值可能会变成double类型，下面的语句会将数值强制转换为int类型(如：3.999转换为3  3.22转换为3)
				thispageNum = parseInt(thispageNum) ;//
				$("form[name='pagination_hidden_form'] input[name='pageSize']").val( new_pageSize ) ;//改变隐藏域
				$("form[name='pagination_hidden_form'] input[name='page']").val( thispageNum ) ;
				$("#pagination_hidden_form").submit() ;
			}
        }) ;
        
        //“走”的动作监听(走按钮和文本框回车)
        var aaathisPageStr = this.pageStr ;
        $("#_pagination_go_").bind( "click",function(){
            var input_goto_val = $("input[name='_go_to_page_']").val() ;
            if(isNaN(input_goto_val)){
               alert("跳转的页码不为数字，请重新输入");
               return ;
            }
            $("form[name='pagination_hidden_form'] input[name='" + aaathisPageStr + "']").val( input_goto_val ) ;
            $("#pagination_hidden_form").submit() ;
        } ) ;
        //自定义记录数和“走”，默认为隐藏，根据配置，选择性显示这两项。（当method为oget时，决对不显示两项）
        if( this.showCusPageSize==true&&this.domethod!='oget' )
            $("#_pagination_pageSize").show() ;
        if( this.showGotoButton==true&&this.domethod!='oget' )
            $("#_pagination_gotodiv_").show() ;
        //配置错误提示信息
        if( this.showCusPageSize==true&&this.domethod=='oget' )
            alert('【分页提示】此提交方法不支持自定义分页大小') ;
        if( this.showGotoButton==true&&this.domethod=='oget' )
            alert('【分页提示】此提交方法不支持自定义跳转') ;
        
        //使用说明

	}
	document.write("</div>") ;
	
}