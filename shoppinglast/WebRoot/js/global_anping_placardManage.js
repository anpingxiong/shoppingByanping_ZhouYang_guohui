function init(){
	showPlacard(1);
}

var  pageMax = 200;
function showPlacard(page) {
	     
	if (page < 1) {
		page = 1;
	}
 if (page > pageMax) {
		page = page - 1;
		sAlert("温馨提示:到底了!");
	}
	$("#loadUserImg").show();
	$("#loadUserImg").fadeOut(500);

	$("#placardTable").empty();
	$("#yueSelect").empty();
	$
			.getJSON(
					"../showPlacard.do",
					{
						page : page
					},
					function(data) {

						for ( var i = 0; i < data.length; i++) {
                         
							$("#placardTable")
									.append(" <tr style='padding:5px;'> "  + 
                                           " <td width='10%' align='center'>"+data[i]["id"]+"</td>"+ 
                                            " <td width='40%' height='24' align='center'> "+data[i]["title"]+"</td> "+
                                            " <td width='20%' align='center'>"+data[i]["pdate"]+"</td>  "+
                                          "  <td width='20%' align='center'>"+data[i]["overdate"]+"</td>  "+ 
"<td width='5%' align='center'><a href='placard_modify.jsp?id="+data[i]["id"]+"'><img src='../images/modify.gif' width='15' height='15'></a></td>"+
"<td width='5%' align='center'><a onclick='deletePlacard("+data[i]["id"]+")'><img src='../images/del.gif' width='16' height='16'></a></td>"+
"</tr> ");
						}

						pageMax = data[0]["totalPage"];

						$("#yueSelect")
								.append(
										""
												+ "	  <tr>"
												+ "    <td align='right'>当前页数：["
												+ page
												+ "/"
												+ data[0]["totalPage"]
												+ "]&nbsp;"
												+ "	<a class='showHand' onclick='showPlacard(1)'>第一页</a> <a   class='showHand' onclick='showPlacard("
												+ (parseInt(page) - 1)
												+ ")'>上一页</a>"
												+ "	<a  class='showHand' onclick='showPlacard("
												+ (parseInt(page) + 1)
												+ ")'>下一页</a> <a class='showHand'  onclick='showPlacard("
												+ data[0]["totalPage"]
												+ ")'>最后一页&nbsp;</a>"
												+ "	</td>" + "	  </tr >");
					});

};

function  deletePlacard(id){
 
	$.get("../deleteNotice.do?id="+id,null,function(data){
		sAlert(data);
		showPlacard(1);
	});
}




var  pdate_m ;
function getPlacard(id){
   if(id==null){
	   return;
   }
	  
   $.getJSON("../showOnePlacard.do",{id:id},function(data){
	   pdate_m=  data[0]["pdate"];
	   $("#title").val(data[0]["title"]);
		$("#content").val(data[0]["content"]);
		$("#pdate").html(data[0]["pdate"]);
		$("#overDate").val(data[0]["overDate"]);
	  });
}


var   result_m  = true;
function  checkOverDateToPdate(){
	
	result_m = true;
 
   if($("#title").val()=="" || $("#content").val()==""   ||     $("#overDate").val()=="" ){
			sAlert("不能有为空数据");
		   return false;
	   }
   
 doCheckDate(pdate_m,$("#overDate").val());
	
	if(result_m==false){
		sAlert("失效日期不能小于发布日期");
	}
	
	 return result_m;
}
function   doCheckDate(pd,od){
	
	var sp=pd.split("-");
   var  so   =od.split("-");
  
	 for(var  i = 0; i<3;i++){
	     if(parseInt(sp[i])>parseInt(so[i])){
			 result_m = false;
			 break;
		 }
	 }
}

function sAlert(str){
	dhtmlx.modalbox({ 
		title:"消息框", 
		text:""+str+"</br></br> <a href='#' onclick='dhtmlx.modalbox.hide(this)'><span  class='dhtmlx_button'><input type='button'     value='点击关闭'  style='width:250px;'></a>",
		width:"100px",
		height:"150px"
	});
}



$(document).ready(a);

function  a (){
	
	$.get("../scanNotice.do",null,function(data){
		
	});
	$(".tableHide").fadeIn(500);
	$(".tableHide").fadeOut(500);
	
}
