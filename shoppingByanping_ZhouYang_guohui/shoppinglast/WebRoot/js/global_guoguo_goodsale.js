$(document).ready(function(){
	$.getJSON("./showGoodsSale.do",{},function(data){
	var  num  = data.length>7?7:data.length;
		for(var i = 0 ;i<num;i++){
			 $("#showGoodSale").append(   
            "<tr>"+
             "<td height='20' class='tableBorder_B_dashed'><a href='./showGoodDetail.do?name="+data[i]["name"]+"'>"+data[i]["name"]+"</a></td>"+
            "</tr>");
		 }
	});
	
});