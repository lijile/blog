/**
 * Created by test on 12/20/2017.
 */
$(function(){
	listTag();
	listCategory();
    $(".submitArticle").click(function () {
        $("#myModal").modal("show");
    });
    $(".inputType input").on("keydown",function(e){
        //回车事件
        var keyCode = e.keyCode;
        switch (keyCode){
            case 13:
                var word = $(this).val();
                if (word != ""){
                    $(this).before("<span>"+word+"<a href='javascript:;' onclick='deleteA(this)'>×</a></span>");
                    $(this).val("");
                }
                break;
        }
    });
    $("#submit").click(function(){
    	var title = $("input[name='title']").val();
    	if($.trim(title) == '') {
    		$("#myModal").modal("hide");
    		alert("请输入文章标题！");
    		return;
    	}
    	var content = $("#editormd textarea").val();
    	if($.trim(content) == '') {
    		$("#myModal").modal("hide");
    		alert("请输入文章内容！");
    		return;
    	}
    	var summary = $(".summary textarea").val();
    	if($.trim(summary) == '') {
    		alert("请输入文章摘要！");
    		return;
    	}
    	var tags = new Array();
    	$(".personalType .inputType span").each(function(){
    		tags.push($(this).text().substr(0,$(this).text().length - 1));
    	});
    	if(tags.length == 0){
    		alert("至少填写一个标签！");
    		return;
    	}
    	var category = $(".articleType select").find("option:selected").val();
    	if(category == '0'){
    		alert("请选择文章类型！");
    		return;
    	}
    	var extra_url = $("input[name='extra_url']").val();
    	createArticle(title,summary,category,extra_url,tags,content);
    });
});
function deleteA(a){
    $(a).parent().remove();
    return false;
}
function addA(a){
    var add = $(a).parent().children().eq(0);
    var text = $(a).parent().text();
    text = text.substr(0,text.length - 1);
    $(".inputType input").before("<span>"+text+"<a href='javascript:;' onclick='deleteA(this)'>×</a></span>");
    $(a).parent().remove();
    return false;
}
function createArticle(title,summary,categoryId,extraUrl,tagName,content){
	$.ajax({
		url : 'createArticle',
		type : 'post',
		data : {
			'title' : title,
			'summary' : summary,
			'categoryId' : categoryId,
			'extraUrl' : extraUrl,
			'tagName[]' : tagName,
			'content' : content
		},
		dataType : 'json',
		success : function(data){
			if(data.result == '1'){
				var basePath = $("#basePath").val();
				var username = $("#username").val();
				window.location.href = basePath+ username + "/" + data.info;
			}else{
				alert("错误：" + data.errorMsg);
			}
		},
		error : function(data){
			alert("请重试");
		}
	});
}
function listTag(){
	$.ajax({
		url : 'tag',
		type : 'get',
		dataType : 'json',
		success : function(data){
			if(data.result == '1'){
				var tags = data.info;
				var html = "";
				for(var i = 0; i < tags.length; i++) {
					html += "<span>";
					html += tags[i].tagName;
					html += "<a href='javascript:;' onclick='addA(this)'>+</a></span>";
				}
				$(".myType").html(html);
			}else if(data.result == '2'){
				window.location.href = "../user/sign-in";
			}else{
				alert("错误：" + data.errorMsg);
			}
		},
		error : function(data){
			alert("请重试");
		}
	});
}
function listCategory(){
	$.ajax({
		url : 'category',
		type : 'get',
		dataType : 'json',
		success : function(data){
			if(data.result == '1'){
				var categoryList = data.info;
				var html = "<option value='0'>---请选择---</option>";
				for(var i = 0; i < categoryList.length; i++) {
					html += "<option value='";
					html += categoryList[i].id;
					html += "'>";
					html += categoryList[i].categoryName;
					html += "</option>";
				}
				$("#categorySelect").html(html);
			}else{
				alert("错误：" + data.errorMsg);
			}
		},
		error : function(data){
			alert("请重试");
		}
	});
}