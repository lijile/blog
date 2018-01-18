/**
 * Created by test on 12/20/2017.
 */
$(function(){
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