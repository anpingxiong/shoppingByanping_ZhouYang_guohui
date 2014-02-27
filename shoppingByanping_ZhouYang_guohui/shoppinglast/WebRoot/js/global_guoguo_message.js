//黑色的消息提示框
function sAlert(str){
	dhtmlx.modalbox({ 
		title:"消息框", 
		text:""+str+"</br></br> <a href='#' onclick='dhtmlx.modalbox.hide(this)'><span  class='dhtmlx_button'><input type='button'   value='点击关闭'  style='width:250px;'></span></a>",
		width:"100px",
		height:"150px"
	});
}
//红色的提示注意框！
function boxD(str){
    dhtmlx.modalbox({ 
		type:"alert-error",
		title:"登陆错误", 
		text:"<img src='alert_medium.png'><strong>"+str+"! ",
		buttons:["明白"]
	});
}