
function addFavorite(id,tag){
 
	  $.get("./addFavorite.do?gid="+id,function(data){
		  	  if(tag==1){
			  alert(data);
			  window.location.reload();  
		  }else{
			  sfAlert(data);
		  }
	   });
}

function checkUserLogInToFavotice(id){
   
	$.get("checkUserIsLogin.do",null,function(data){
  	  if(data==0){
   	    boxH(id);
   	  }else if(data==1){
  		    //收藏
  		  addFavorite(id,0);
  	  }
  	  
    });
}
function boxH(id){
 
	var box = dhtmlx.modalbox({ 
		title:"收藏前记得登陆哦", 
		text:"<div id='form_in_box'><div><label> 账 号  <input class='inform'  id='box_username'"+

       " type='text' ></label></div><div><label> 密 码 <input class='inform'  id='box_password'"+

     "  type='password'></label></div><div id='login_result'></div><div><span class='dhtmlx_button'><input type='button' "+

   "    value='登陆' onclick='logi_callback(\""+id+"\")' style='width:70px;'></span>" +
   "<span class='dhtmlx_button'><input type='button' "+

   "    value='注册' onclick='reg_callback()' style='width:70px;'></span>" +
    "<span class='dhtmlx_button'><input type='button' "+

	   "    value='逛逛' onclick='cancel_callback(this)' style='width:70px;'></span>"+
   "</div>",
		width:"300px"
	});
	//timeout is necessary only in IE
	setTimeout(function(){
		box.getElementsByTagName("input")[0].focus();	
	},1);
	}
function cancel_callback(box){
	  dhtmlx.modalbox.hide(box);
}
function  logi_callback(id){
   //在此写登陆哦
	var    username  = $("#box_username").val();
	var    password  = $("#box_password").val();
       $.get("./login.do?username="+username+"&password="+password,null,function(data){
		  $("#login_result").empty();
		 if(data=="<font color='red'>登录成功(0)!</font>"){
			 $("#login_result").html("<font color='red'>用户被冻结请尽快和管理员联系</font>");
		        }
		 else   if(data=="<font color='red'>登录成功(1)!</font>"){
		  $("#login_result").html(data);
		  //收藏 
		  addFavorite(id,1);
		
		  }else{
			  $("#login_result").html(data); 
		  }
		  });
      
}
function  reg_callback(){
	  window.location="./register.jsp";
}
////////////////////////////

function sfAlert(str){
	var box = dhtmlx.modalbox({ 
		title:"你好", 
		text:""+str+"<div><span class='dhtmlx_button'><input type='button' value='明白' onclick='save_callback(this)' style='width:100px;'></span><span class='dhtmlx_button'><input type='button' value='看收藏' onclick='seeFavority()' style='width:100px;'></span></div>",
		width:"300px"
	});
	//timeout is necessary only in IE
	setTimeout(function(){
		box.getElementsByTagName("input")[0].focus();	
	},1);
 }
function save_callback(box){
  dhtmlx.modalbox.hide(box);
}

function  seeFavority(){
	window.location="./favorite.jsp";
}