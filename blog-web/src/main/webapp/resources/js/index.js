var lastId = 0;
var lastAwayBtm = 10;
$(function(){
	lastId = 0;
	listArticle();
	$(window).scroll(function() {
	    var awayBtm = $(document).height() - $(window).scrollTop() - $(window).height();
	    //滚动至底部,并防止重复调用
	    if (awayBtm == 0 && lastAwayBtm != 0) {
	        console.log('触发了='+lastId);
	        listArticle();
	    }
	    lastAwayBtm = awayBtm;
	});
});
function listArticle(){
	$.ajax({
		url : 'article/listArticle?lastId='+lastId,
		type : 'get',
		dataType : 'json',
		success : function(data){
			if(data.result == '1'){
				var html = "";
				var articles = data.info;
				for(var i = 0; i < articles.length; i ++) {
					html += buildArticleDay(articles[i]);
					if(i == articles.length-1) {
						lastId = articles[i].id;
					}
				}
				$(".forFlow").append(html);
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
	html += "<a class='postTitle2' href='"+article.username+"/"+article.id+"'>";
	html += article.title;
	html += "</a>";
	html += "</div>";
	html += "<div class='postCon'>";
	html += "<div class='c_b_p_desc'>摘要: ";
	html += article.summary;
	html += " <a href='"+article.username+"/"+article.id+"' class='c_b_p_desc_readmore'>阅读全文</a>";
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