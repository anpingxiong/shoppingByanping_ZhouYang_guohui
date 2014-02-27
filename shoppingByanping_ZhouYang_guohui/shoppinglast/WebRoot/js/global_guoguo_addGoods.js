
function init(){
	//当点击补货的小图标时，调用replace方法
	$(document).ready(a);
}
function   a(){
	$(".buhuo").click(replace);
	
}
function replace(){
	 //将小图标里面的内容清空，并且将它变为文本框
   $(this).empty();
      var  obj   =  $("<input size='3'>");
	  obj.appendTo($(this));
	  //当按下回车键 代表获得文本框里面输入的值
	  $(this).keypress(function(event){
		  if(event.keyCode==13){
			 //拿到的是4  
			  //先拿到parent
			 
			  var  parent  = $(this).parent().parent();
			  var  brother  = parent.children().eq(4);
			  var  name  = parent.children().eq(1).children().eq(0);
			    var   goodName = name.html();
			  var   goodNum = obj.val();
			   var  nowNum = brother.html();
			   var   addNum  = parseInt(goodNum)+parseInt(nowNum);
		 
			  
			  if(addNum>=0 && addNum<=1000000 ){
				  $.get("../updateNumByName.do",{goodName:goodName,mnum:addNum},function(data){
		              sAlert(data);	
		     });  
				
				  brother.html(addNum+"");
					 
				  //传一些值并且跳转到servlet页面，返回一个data响应
		       
		        	  $(this).empty();
			        var object	 = $("<img  src='../images/add.gif' width='16' height='16' >");
                 object.appendTo($(this));
			  }
			  else{
				  sAlert("你输入的数据不合法,必须为小于1万数字！");
			  }
			 }
		
	  });
	  //解除click绑定
	
     $(this).unbind("click");
}




function sAlert(str){
	dhtmlx.modalbox({ 
		title:"消息框", 
		text:""+str+"</br></br> <a href='#' onclick='dhtmlx.modalbox.hide(this)'><span  class='dhtmlx_button'><input type='button'   value='点击关闭'  style='width:250px;'></span></a>",
		width:"100px",
		height:"150px"
	});
}