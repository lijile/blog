var basePath = $("input[name='basePath']").val();
$(function(){
	$("#keywords").bind("keypress",function(event){
		if(event.keyCode == 13) {
			var keywords = $("#keywords").val();
			if(keywords == null || keywords == '') {
				return;
			}
			search(keywords);
		}
	});
	$(".myhome").mouseover(function(){
		$(".dropdown-menu2").css("display","block");
	});
	$(".myhome").mouseout(function(){
		$(".dropdown-menu2").css("display","none");
	});
});
function search(keywords){
	$.ajax({
		url : basePath + 'article/search',
		type : 'post',
		data : {'keywords':keywords},
		dataType : 'json',
		success : function(data){
			if(data.result == '1'){
				var html = "";
				var articles = data.info;
				$(".main").html("<div id='mainContent'><div class='forFlow'></div></div>");
				$(".main").css("margin","76px 10px 10px 150px");
				for(var i = 0; i < articles.length; i ++) {
					html += buildArticleDay(articles[i]);
					if(i == articles.length-1) {
						lastId = articles[i].id;
					}
				}
				$(".forFlow").html(html);
			}else{
				alert("错误：" + data.errorMsg);
			}
		},
		error : function(data){
			alert("请重试");
		}
	});
}

function buildArticleDay(article){
	var html = "<div class='day'>";
	html += "<div class='postTitle'>";
	html += "<a class='postTitle2' href='"+basePath+article.username+"/"+article.id+"'>";
	html += article.title;
	html += "</a>";
	html += "</div>";
	html += "<div class='postCon'>";
	html += "<div class='c_b_p_desc'>摘要: ";
	html += article.summary;
	html += " <a href='"+basePath+article.username+"/"+article.id+"' class='c_b_p_desc_readmore'>阅读全文</a>";
	html += "</div>";
	html += "</div>";
	html += "<div class='clear'></div>";
	html += "<div class='postDesc'>posted @ ";
	html += article.gmtCreate;
	html += " ";
	html += article.fullname;
	html += " 阅读(";
	html += article.readCount;
	html += ") 评论(";
	html += article.commentCount;
	html += ") ";
	html += "</div>";
	html += "<div class='clear'></div>";
	html += "</div>";
	return html;
}