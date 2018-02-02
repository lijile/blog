$(function(){
	initEnvInfo();
});
function initEnvInfo(){
	$.ajax({
		url : 'getEnvInfo.do',
		type : 'get',
		dataType : 'json',
		success : function(data){
			if(data.result == '1'){
				var env = data.info;
				var java_version = env.version + " " + env.vendor + "--" + env.vmName;
				var os = env.os;
				var used_percent = env.usedMemory / env.maxMemory * 100;
				var free_memory = env.maxMemory - env.usedMemory;
				var address = env.location;
				$("#java_version").html(java_version);
				$("#os").html(os);
				$("#used_percent").html(parseInt(used_percent));
				$("#free_memory").html(parseInt(free_memory) + "MB remaining");
				$("#address").html(address);
			}else{
				alert("错误：" + data.errorMsg);
			}
		},
		error : function(data){
			
		}
	});
}