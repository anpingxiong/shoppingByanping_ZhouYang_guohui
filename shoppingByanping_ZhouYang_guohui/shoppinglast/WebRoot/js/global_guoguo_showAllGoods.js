$(document).ready(showGoods(1));
var  i = 1 ;
var pageMax=200;
function  showGoods(page){
	      if (page < 1) {
	     	page = 1;
         	}

	      if (page > pageMax) {
	   	page = page - 1;
		   sAlert("温馨提示:到底了!");
	   }
	      $("#goodsTable").empty();
	  	$("#pageTable").empty();
	      
	  $.getJSON("../showAllGoodsByJs.do",{page:page},function(data){
		  for(var    i  =  0 ;i <data.length;i++){
			 
			  $("#goodsTable").append("" +
					    "<tr >"+
					     " <td width='5%' align='center'>"+i+"</td>"+
					     " <td width='25%' height='24' align='center'><a href='../showGoodsDetails.do?gid="+data[i]["gid"]+"'>"+data[i]["name"]+"</a></td>"+
					      "<td width='13%' align='center'>"+data[i]["type"]+"</td>   "+
					     " <td width='13%' align='center'>"+data[i]["nowPrice"]+"</td>                "+
					     " <td width='12%' align='center'>"+data[i]["goodsnum"]+"    </td>"+
					     " <td width='12%' align='center'>"+data[i]["ordernum"]+"(件)</td>"+
					     " <td width='5%' align='center'>"+data[i]["bargain"]+"</td>"+
					     " <td width='5%' align='center'>"+
"<span title='每件商品库存数量不能大于1万哦！你心里有数的！' class='buhuo' onclick='a()'><img  src='../images/add.gif' width='16' height='16' </span>"+
	       	"	</td>"+		
" <td width='5%' align='center'><a href='../showModifiedGoods.do?gid="+data[i]["gid"]+"'><img src='../images/modify.gif'  width='15' height='15'></a></td>"+
					     " <td width='5%' align='center'>" +
					     "<span><img  onclick='deleteGoods(\""+data[i]["gid"]+"\")'  src='../images/del.gif' width='16' height='16'></span>" +
					     "</td>"+
					    " </tr>"+
						   
					    		"");   
			           }
		  
			pageMax = data[0]["totalPage"];
       	$("#pageTable")
				    	.append(
							""
									+ "	  <tr>"
									+ "    <td align='right'>当前页数：["
									+ page
									+ "/"
									+ data[0]["totalPage"]
									+ "]&nbsp;"
									+ "	<a class='showHand' onclick='showGoods(1)'>第一页</a> <a   class='showHand' onclick='showGoods("
									+ (parseInt(page) - 1)
									+ ")'>上一页</a>"
									+ "	<a  class='showHand' onclick='showGoods("
									+ (parseInt(page) + 1)
									+ ")'>下一页</a> <a class='showHand'  onclick='showGoods("
									+ data[0]["totolPage"]
									+ ")'>最后一页&nbsp;</a>"
									+ "	</td>" + "	  </tr >");
	 	  });
	  
}

function   deleteGoods(id){
   $.get("../deleteGoods.do?",{gid:id},function(data){
		 alert(data);
		 window.location.reload();
	 });
}




 
    