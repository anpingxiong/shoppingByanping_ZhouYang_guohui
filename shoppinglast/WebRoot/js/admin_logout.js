function   adminLogOut(){
	$.get("adminLogOut.do",null,function(data){
		alert(data);
	});
}