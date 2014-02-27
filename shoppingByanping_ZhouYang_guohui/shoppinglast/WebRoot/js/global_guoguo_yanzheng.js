var checkGoodsName = false; // 用来显示提示商品名称已经存在的语句的span
var  checkNotNullResult=false;// 用来显示不为空的提示语句



function not_null(id,name){
 var obj1 = $("#"+id).val();
  if(obj1==""){
	 sAlert(name+"不能为空，请重新填写！");	
	 checkNotNullResult=false;
	 } 
 else{
	   checkNotNullResult=true;
       var name = $("#goodsName").val();
      $.get("../checkGoodsName.do?name="+name,null,callback_1);
  	}

	 
 }
  function callback_1(data){
	 $("#checkGoodsName").html(data);// 获得提示的语句 在servlet里面写了的
	
	 if(data=="<font color='red'>商品名已经存在</font>"){
			checkGoodsName = false;
		}else{
			checkGoodsName = true;
		}
}

function checkSubmit(){
	if(checkNotNullResult==false){
		 sAlert("有信息未填写！");
		return  false;
	}
	 
}
function sAlert(str){
	dhtmlx.modalbox({ 
		title:"消息框", 
		text:""+str+"</br></br> <a href='#' onclick='dhtmlx.modalbox.hide(this)'><span  class='dhtmlx_button'><input type='button'   value='点击关闭'  style='width:250px;'></span></a>",
		width:"100px",
		height:"150px"
	});
}