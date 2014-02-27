//这个方法是读取的时候我就去拿到我的notice公告  但是我拿的坑定是最后5个
$(document).ready(function(){
	        $.getJSON("./showPlacard.do",{page:1},function(data){
	          	for(var i= 0;i<5;i++ ){
	        		$("#showNotice").append("" +
	        				"<tr>"+
       "<td height='24' class='tableBorder_T_dashed'><a href='showPlacardDetail.do?id="+data[i]["id"]+"'>"+data[i]["content"]+"</a></td>"+
       "</tr>");
	        	}
	        });
});

