 
$(document).ready(function(){
	$("#test").ProvinceCity();
	$('#username_2').poshytip({
			className: 'tip-yellow',
			showOn: 'focus',
			alignTo: 'target',
			alignX: 'right',
			alignY: 'center',
			offsetX: 5
		});
	 $('#password1').poshytip({
			className: 'tip-yellow',
			showOn: 'focus',
			alignTo: 'target',
			alignX: 'right',
			alignY: 'center',
			offsetX: 5
		});
	 $('#me').poshytip({
			className: 'tip-yellow',
			showOn: 'focus',
			alignTo: 'target',
			alignX: 'right',
			alignY: 'center',
			offsetX: 5
		});
	 $('#address').poshytip({
			className: 'tip-yellow',
			showOn: 'focus',
			alignTo: 'target',
			alignX: 'right',
			alignY: 'center',
			offsetX: 5
		});
	 $('#telephone').poshytip({
			className: 'tip-yellow',
			showOn: 'focus',
			alignTo: 'target',
			alignX: 'right',
			alignY: 'center',
			offsetX: 5
		});
	 
});

function checkstrHaveEmpty(str){
	for(var i=  0 ;i<str.length;i++){
		if(str[i]==" "){
	  return  1;
			break;
		}
	}
}


var i =2,checkUserName=false,checkPsw=false,checkPswEqu=false,checkEmailResult=false,yanZhen=false;
function deLayUrl_2(){
	window.setInterval("time()",1000);
}
function time(){
     i--;
 	if(i==0){
 	   var  username = $("#username_2").val();
 	 var   haveKongGe =  checkstrHaveEmpty(username);
 	   if(haveKongGe==1){
 		  checkUserName=false;
 		  $("#showCheckUsernameresult").html("不能包含空格！");
 		return;
 	   }  	   
 	 $.get("CheckName.do?username="+username,null,function(data){
 	      $("#showCheckUsernameresult").html(data);
 	       if(data=="用户已存在"){
 	    	  checkUserName=false;
 	       }else{
 	    	  checkUserName=true;
 	       }
 	   	   });	
     }
 }
function showImage(){   //显示动态图片
	if( isEmpty('username_2','showCheckUsernameresult')==1){
		return;
	}
	 $("#wait").show();
     $("#wait").fadeOut(2000);
     deLayUrl_2();
     i=2;   //归位
     }




function isEmpty(id_1,id_2){ //判断非空
	 
    var  object=	$("#"+id_1).val();
    
    if(object==""){
    	$("#"+id_2+"").html("不能为空!");
    	return  1;
    }
} 
function  modifColor(id,color){
	$("#"+id).css("color",color);
}

function checkPassword(){
	  if(isEmpty('password1','showCheckPasswordResult')==1){
		 
		  return;
	 }
	var password  = $("#password1").val();
	 var   haveKongGe =  checkstrHaveEmpty(password);
	   if(haveKongGe==1){
		   checkPsw=false;
		  $("#showCheckPasswordResult").html("不能包含空格！");
		return;
	   }  	   
	 
	if(password.length<6){
		modifColor('showCheckPasswordResult','green');
		$("#showCheckPasswordResult").html("长度<6,请重新输入!");
		return;
	}
	var   dz= false,ds=false;
	for(var p= 0;p<password.length;p++){
		if(password[p]>='a' && password[p]<='z' || password[p]>='A' && password[p]<='Z'){
			 dz=true;
		}
		if(password[p]<=9 &&password[p]>=0){
			ds=true;
		}
	}
	if((dz==true && ds==true)==false){
		checkPsw=false;
		modifColor('showCheckPasswordResult','green');
		if(dz==false){
			$("#showCheckPasswordResult").html("至少包含一个字母");
		}else if(ds==false){
			
			$("#showCheckPasswordResult").html("至少包含一个数字");
		}else {
			 $("#showCheckPasswordResult").html("须包含数字和字母 ");
		} 
		 
	}else{
		modifColor('showCheckPasswordResult','#FF6600');
		$("#showCheckPasswordResult").html("√");
		checkPsw=true;
	 }
}
 
function checkTwoPassword(){
	var password1= $("#password1").val();
	var  password2=$("#password2").val();
	
	if(password1 != password2){
		modifColor('showCheckPasswordEquel','green');
		$("#showCheckPasswordEquel").html("两次密码不一致");
		checkPswEqu=false;
	}else{
		modifColor('showCheckPasswordEquel','#FF6600');
		$("#showCheckPasswordEquel").html("√");
		checkPswEqu=true;
 
	}
	
}


function checkEmail(){
 
	var  email = $("#me").val();
	 var   haveKongGe =  checkstrHaveEmpty(email);
	   if(haveKongGe==1){
		   checkEmailResult=false;
		  $("#showCheckPasswordResult").html("不能包含空格！");
		return;
	   }  	  
	var eg=false;
	for(var e= 0;e<email.length;e++){
		if(email[e]=='@'){
			eg=true;
			break;
		}
	}
	if(eg==false){
		modifColor('showCheckPasswordEquel','green');
		$("#showCheckEmailResult").html("格式错误");
		checkEmailResult=false;
	}
	else{
		modifColor('showCheckPasswordResult','#FF6600');
		$("#showCheckEmailResult").html("√");
		checkEmailResult=true;
	}
}

/////////////////////////email验证   left  top 手动修改
 
var nowid;
var totalid;
var can1press = false;
var emailafter;
var emailbefor;

$(document).ready(function(){ 
	 
    $("#me").focus(function(){ //文本框获得焦点，插入Email提示层
        $("#myemail").remove();  //"+$(this).get(0).offsetLeft+"     "+($(this).get(0).offsetTop+$(this).height()+2)+"
        var position =    mousePosition(this);
   $(this).after("<div id='myemail' style='width:200px; height:auto; background:#fff; color:#6B6B6B; position:absolute; left:"+position.x+"px; top:"+(position.y)+"; border:1px solid #ccc;z-index:5px; '></div>");
  if($("#myemail").html()){
             $("#myemail").css("display","block");
 $(".newemail").css("width",$("#myemail").width());
  can1press = true;
        } else {
             $("#myemail").css("display","none");
  can1press = false;
        }  
    }).keyup(function(){ //文本框输入文字时，显示Email提示层和常用Email
  var press = $("#me").val();
  if (press!="" || press!=null){
  var emailtxt = "";   
  var emailvar = new Array("@163.com","@126.com","@yahoo.com","@qq.com","@sina.com","@gmail.com","@hotmail.com","@foxmail.com");
  totalid = emailvar.length;
   var emailmy = "<div class='newemail' style='width:200px; color:#6B6B6B; overflow:hidden;'><font color='#D33022'>" + press + "</font></div>";
   if(!(isEmail(press))){
       for(var i=0; i<emailvar.length; i++) {
        emailtxt = emailtxt + "<div class='newemail' style='width:200px; color:#6B6B6B; overflow:hidden;'><font color='#D33022'>" + press + "</font>" + emailvar[i] + "</div>"
       }
   } else {
       emailbefor = press.split("@")[0];
       emailafter = "@" + press.split("@")[1];
       for(var i=0; i<emailvar.length; i++) {
            var theemail = emailvar[i];
            if(theemail.indexOf(emailafter) == 0)
            {
             emailtxt = emailtxt + "<div class='newemail' style='width:200px; color:#6B6B6B; overflow:hidden;'><font color='#D33022'>" + emailbefor + "</font>" + emailvar[i] + "</div>"
         }
       }
   }
    
   $("#myemail").html(emailmy+emailtxt);
   if($("#myemail").html()){
     $("#myemail").css("display","block");
     $(".newemail").css("width",$("#myemail").width());
     can1press = true;
   } else {
     $("#myemail").css("display","none");
     can1press = false;
   }
   beforepress = press;
  }
  if (press=="" || press==null){
      $("#myemail").html("");  
       $("#myemail").css("display","none");    
  }    
    })
 $(document).click(function(){ //文本框失焦时删除层
        if(can1press){
   $("#myemail").remove();
   can1press = false; 
   if($("#me").focus()){
       can1press = false;
   }
  }
    })
    $(".newemail").live("mouseover",function(){ //鼠标经过提示Email时，高亮该条Email
        $(".newemail").css("background","#FFF");
        $(this).css("background","#CACACA");  
  $(this).focus();
  nowid = $(this).index();
    }).live("click",function(){ //鼠标点击Email时，文本框内容替换成该条Email，并删除提示层
        var newhtml = $(this).html();
        newhtml = newhtml.replace(/<.*?>/g,"");
        $("#me").val(newhtml); 
        $("#myemail").remove();
    })
 $(document).bind("keydown",function(e)  
 {     
  if(can1press){
   switch(e.which)     
   {            
    case 38:
    if (nowid > 0){  
     $(".newemail").css("background","#FFF");
     $(".newemail").eq(nowid).prev().css("background","#CACACA").focus();
     nowid = nowid-1;  
    }
    if(!nowid){
     nowid = 0;
     $(".newemail").css("background","#FFF");
     $(".newemail").eq(nowid).css("background","#CACACA");  
     $(".newemail").eq(nowid).focus();    
    }
    break;       
  
    case 40:
    if (nowid < totalid){    
     $(".newemail").css("background","#FFF");
     $(".newemail").eq(nowid).next().css("background","#CACACA").focus(); 
     nowid = nowid+1;   
    }
    if(!nowid){
     nowid = 0;
     $(".newemail").css("background","#FFF");
     $(".newemail").eq(nowid).css("background","#CACACA");  
     $(".newemail").eq(nowid).focus();    
    }
    break;  
  
    case 13:
    var newhtml = $(".newemail").eq(nowid).html();
    newhtml = newhtml.replace(/<.*?>/g,"");
    $("#me").val(newhtml); 
    $("#myemail").remove();
   }
  }   
 })
 
 function mousePosition(ev)
{
 
if(ev.pageX || ev.pageY)
{
return {x:ev.pageX, y:ev.pageY};
}
return {
x:ev.clientX + document.body.scrollLeft - document.body.clientLeft,y:ev.clientY + document.body.scrollTop - document.body.clientTop
};
}
}) 
//检查email邮箱
function isEmail(str){
    if(str.indexOf("@") > 0)     
    {     
        return true;
    } else {
        return false;
    }
}
////////////////////////////检查验证码
function checkValidate( ){
	 
 
	var   validate  = $("#validate").val();
	 
	$.get("CheckValidate.do",null,function(data){
	 	if(validate!=data){
	 		modifColor('checkVaildateResult','green');
	 		   $("#checkVaildateResult").html("验证码错误");
	 		  yanZhen=false;
	 		  changImage();
	 	}else{
			   $("#checkVaildateResult").empty();
				  yanZhen=true;
	 	}
	});
}
///////////////////////////换图
function changImage(){
	  $("#image").empty();
	$("#image").append("<img src='CheckNum.do'>");
}

///////////////////////checkPost方法
var   checkStr   = false ;
function checkPostOrEmail(id,rid){
	 
	$("#"+rid).empty();   
 
	var  str = $("#"+id).val();
	 var   haveKongGe =  checkstrHaveEmpty(str);
 
	if(haveKongGe==1){
		  checkStr=false;
		  $("#"+rid).html("不能包含空格！");
		return;
	   }  	  
    if(str==""){
         
    	 $("#"+rid).html("<font color='green'>warn不能为空!</font>");
        	 checkStr  = false ;
        	 return;
         }
	if(id=="postcode"  &&  str.length>7){
	  	 $("#"+rid).html("<font color='green'>warn6个数字内!</font>");
		 checkStr  = false ;
	  	 return;
     }
	if(id=="telephone"  &&  str.length!=11){
		 $("#"+rid).html("<font color='green'>warn号码11位的!</font>");
		 checkStr  = false ;
		 return ;
	}
         for(var i = 0 ;i<str.length;i++){
        	 
        	 if((str[i]>='0' && str[i]<='9')==false){
        		checkStr= false;;
        		 $("#"+rid).html("<font color='green'>warn只能为数字!</font>");
                  return;
        	 }
         }
         
         checkStr=true;
        
         $("#"+rid).html("<font color='orange'>√</font>");
}

function checkAll(){
	checkEmail();
	checkPostOrEmail('telephone','checkTelephoneResult');
	 if( (checkStr &&checkUserName && checkPsw  && checkPswEqu&& checkEmailResult && yanZhen)==false) {
		  var   checkR  ;
		  if(checkUserName==false){checkR="用户名";}
		  else if(checkPsw==false){checkR="密码填写错误";}
		  else if(checkPswEqu==false){checkR="密码不一致";}
		  else  if(yanZhen==false){checkR="验证码错误";}
		  else  if(checkEmailResult==false){checkR="email不合法";}
		  else  if(checkStr==false){checkR="邮编或电话不合法";}
		  boxD(checkR);
		 	 return false;
	}
}


///////////////////////////////////////Box类型
function boxA(str){
	dhtmlx.modalbox({ 
		title:"消息框", 
		text:""+str+" <a href='#' onclick='dhtmlx.modalbox.hide(this)'>click to close</a>",
		width:"450px",
		height:"300px"
	});
}
function boxB(){
	dhtmlx.modalbox({ 
		text:"Some text here",
		width:"450px",
		position:"top",
		buttons:["Ignore", "Confirm", "Deny"],
		callback:function(index){
			dhtmlx.message("Button "+index+" was pressed")
		}
	});
}
function boxC(){
	var box = dhtmlx.modalbox({ 
		title:"Configuration", 
		text:"<div id='form_in_box'><div><label> Input width <input class='inform' type='text'></label></div><div><label> Input height <input class='inform' type='text'></label></div><div><label> Input details <textarea class='inform'></textarea></label></div><div><span class='dhtmlx_button'><input type='button' value='save' onclick='save_callback(this)' style='width:250px;'></span></label></div></div>",
		width:"300px"
	});
	//timeout is necessary only in IE
	setTimeout(function(){
		box.getElementsByTagName("input")[0].focus();	
	},1);
	

}
function save_callback(box){
	dhtmlx.message("Saving...");
	dhtmlx.modalbox.hide(box);
}
 
function boxD(str){
     dhtmlx.modalbox({ 
		type:"alert-error",
		title:"注册错误", 
		text:"<img src='alert_medium.png'><strong>"+str+"等信息填写错误,请仔细检查! ",
		buttons:["明白"]
	});
}
boxC();




////////////////////////////
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
		$
				.get(
						"./login.do?username=" + username + "&password=" + password,
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
//									+ "      <input type='reset' class='button orange medium' value='重置'>"
									+ "    </td>  " + "    <td>&nbsp;</td> "
									+ "  </tr> " + " </table>");
		} else  if(user != ''&& state!=0){
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
			text:""+str+"</br></br> <a href='#' onclick='dhtmlx.modalbox.hide(this)'><span class='dhtmlx_button'><input type='button'    value='点击关闭'  style='width:250px;'></span></a>",
			width:"100px",
			height:"150px"
		});
	}
//////////////////////////////////////////
	
	
/////////////////////////////////////////////////////////提示登陆方法
	function checkUserLogInInterface(url){
	 
	    $.get("checkUserIsLogin.do",null,function(data){
	  	  if(data==0){
	  
	  		  boxS(url);
	  		  //show登陆
	  	  }else if(data==1){
	  		    window.location=url;
	  	  }
	  	  
	    });
	}
	function boxS(url){

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



