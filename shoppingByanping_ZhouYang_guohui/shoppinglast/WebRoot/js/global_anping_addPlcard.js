var   result_m  = true;
function  checkOverDateToPdate(){
	
	result_m = true;
 
	if(($("#title").val()=="" | $("#content").val()==""  |     $("#overDate").val()=="" )==true){
			sAlert("不能有为空，请填写完整");
		   return false;
	   }
	var   pdate_y  = new Date().getFullYear();
	 var  pdate_m = new  Date().getMonth();
	 var  pdate_d = new  Date().getDate();
	 var  pdate_m   = pdate_y +"-"+pdate_m+"-"+pdate_d;
	
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
		text:""+str+"</br></br> <a href='#' onclick='dhtmlx.modalbox.hide(this)'><input type='button'  class='dhtmlx_button'  value='点击关闭'  style='width:250px;'></a>",
		width:"100px",
		height:"150px"
	});
}


