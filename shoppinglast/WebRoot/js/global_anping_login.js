function deLayUrl(url){
 
  window.location=url;
}

function a() {
 

	var username = $("#username").val();
	var password = $("#password").val();
	if(username==""  ||  password==""){
		$("#longinResult").html("<font color='red'>用户名或密码空了</font>");
	   return ;
	}
	
	
	
	$.get("./login.do?username=" + username + "&password=" + password,
					null,
					function(data) {
						if(data == "<font color='red'>登录成功(0)!</font>"){
							boxD("该用户已被冻结,请尽快和管理员联系!");
							return;
						}
						$("#longinResult").empty();
						$("#longinResult").html(data);
						
						if (data == "<font color='red'>登录成功(1)!</font>") {
							sAlert("登录成功!");
							$(".loginTable").empty();
							$(".loginTable")
									.append(
											"         <table width='100%'  border='0' cellpadding='0' cellspacing='0'>"
													+ "  <tr>"
													+ "    <td width='94%' height='31' align='center' class='word_white'>["
													+ username
													+ "]您好!<br>"
													+ "       您现在可以购物了!</td>"
													+ "     <td width='6%'>&nbsp;</td>"
													+ "   </tr>"
													+ "   <tr>"
													+ "     <td height='24' align='center'><input type='button' class='button blue medium' value='修改资料' onClick='deLayUrl(\"member.jsp\")'></td>"
													+ "     <td>&nbsp;</td>"
													+ "  </tr>"
													+ "  <tr>"
													+ "    <td height='24' align='center'>"
													+ "     <input type='button' class='button blue medium' value='退出登录' onClick='quitLogin()'></td>"
													+ "    <td>&nbsp;</td>"
													+ "  </tr>" + "</table>");
						}
					});

	// 我拿到username by id 来判断用户名是否存在
	// 做到无刷新就是倒时候将div中的东西remove在重加
}

function isShowLoginTable(user,state) { // 用来登录窗口的创建
  
	if (user == '' || state==0) {
		$(".loginTable")
				.append(
						"  <table width='100%'  border='0' cellpadding='0' cellspacing='0'> "
								+ " <tr>"
								+ "  <td width='97%' height='24'>会员名<input name='username' type='text' class='txt_grey' id='username' size='16'  ></td>"
								+ " <td width='3%'>&nbsp;</td>"
								+ " </tr>"
								+ " <tr><td height='24'>密&nbsp; &nbsp;&nbsp;码<input name='password' type='password' class='txt_grey' id='password' size='16'></td>"
								+ "   <td>&nbsp;</td>"
								+ "  </tr>"
								+ "  <tr><td><span id='longinResult'></span></td></tr>"
								+ "  <tr>"
								+ "    <td height='31'>"
								+ "      <input type='button' class='button blue medium' value='注册' onClick='deLayUrl(\"./register.jsp\")'>"
								+ "      &nbsp;"
								+ "      <input type='button' class='button blue medium' value='登录' onClick='a()'>    "
//								+ "      <input type='reset' class='button orange medium' value='重置'>"
								+ "    </td>  " + "    <td>&nbsp;</td> "
								+ "  </tr> " + " </table>");
	} else  if(user!="" && state!=0){
	
		$(".loginTable")
				.append(
						"         <table width='100%'  border='0' cellpadding='0' cellspacing='0'>"
								+ "  <tr>"
								+ "    <td width='94%' height='31' align='center' class='word_white'>["
								+ user
								+ "]您好!<br>"
								+ "       您现在可以购物了!</td>"
								+ "     <td width='6%'>&nbsp;</td>"
								+ "   </tr>"
								+ "   <tr>"
								+ "     <td height='24' align='center'><input type='button' class='button blue medium' value='修改资料' onClick='deLayUrl(\"./member.jsp\")'></td>"
								+ "     <td>&nbsp;</td>"
								+ "  </tr>"
								+ "  <tr>"
								+ "    <td height='24' align='center'>"
								+ "     <input type='button' class='button blue medium' value='退出登录' onClick='quitLogin()'></td>"
								+ "    <td>&nbsp;</td>" + "  </tr>"
								+ "</table>");
	}
}


function quitLogin(){
   $.get("quitLogin.do",null,function(data){
	   sAlert(data);
		$(".loginTable").empty();
		isShowLoginTable('');
	});
}


 


function sAlert(str){
	dhtmlx.modalbox({ 
		title:"消息框", 
		text:""+str+"</br></br> <a href='#' onclick='dhtmlx.modalbox.hide(this)'><span  class='dhtmlx_button'><input type='button'   value='点击关闭'  style='width:250px;'></span></a>",
		width:"100px",
		height:"150px"
	});
}
function boxD(str){
    dhtmlx.modalbox({ 
		type:"alert-error",
		title:"登陆错误", 
		text:"<img src='alert_medium.png'><strong>"+str+"! ",
		buttons:["明白"]
	});
}
/////////////////////////////////////////////////////////提示登陆方法
function checkUserLogInInterface(url){
  
	$.get("checkUserIsLogin.do",null,function(data){
  	  if(data==0){
  
  		  boxC(url);
  		  //show登陆
  	  }else if(data==1){
  		    window.location=url;
  	  }
  	  
    });
}
function boxC(url){

	var box = dhtmlx.modalbox({ 
		title:"请先登陆", 
		text:"<div id='form_in_box'><div><label> 账 号  <input class='inform'  id='box_username'"+

       " type='text' ></label></div><div><label> 密 码 <input class='inform'  id='box_password'"+

     "  type='password'></label></div><div id='login_result'></div><div><span class='dhtmlx_button'><input type='button' "+

   "    value='登陆' onclick='login_callback(\""+url+"\")' style='width:70px;'></span>" +
   "<span class='dhtmlx_button'><input type='button' "+

   "    value='注册' onclick='register_callback()' style='width:70px;'></span>" +
    "<span class='dhtmlx_button'><input type='button' "+

	   "    value='取消' onclick='cancel_callback(this)' style='width:70px;'></span>"+
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
function  login_callback(aa){
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
		   window.location=aa;
		  }else{
			  $("#login_result").html(data); 
		  }
		  });
      
}
function  register_callback(){
	  window.location="./register.jsp";
}
////////////////////////////





function MM_openBrWindow(theURL,winName,features) {window.open(theURL,winName,features);}
