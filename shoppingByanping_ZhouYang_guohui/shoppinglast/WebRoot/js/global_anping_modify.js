function showOkButton(){
	$("#modifyB1").hide();
	$("#modifyB2").show();
	   $(".text_m").show();
	   $(".text_value").hide();
	   
}
function checkstrHaveEmpty(str){
	for(var i=  0 ;i<str.length;i++){
		if(str[i]==" "){
	  return  1;
			break;
		}
	}
}

function   showModifyButton(){
 
	checkAllModify();
	//判断用户名和密码是否重复真确  判断email手机邮编是否合法
   //在此我们拿到所有的值去修改我们信息
	//弹窗提示修改信息确认修改???修改成功跳转如index重新登录
	
}
var  checkUserNameTrue=true,checkEmailTrue=true,checkPasswordTrue=true,checkPsw=true;
function checkUserName( name){
	  
     var  username = $("#username_m").val();
     
     var   haveKongGe =  checkstrHaveEmpty(username);
	   if(haveKongGe==1){
		   checkUserNameTrue=false;
		  $("#checkUsernameResult").html("不能包含空格！");
		return;
	   }  	
  
     if(username==name){
    	 checkUserNameTrue=true;
    	 $("#checkUsernameResult").empty();
         return;
	   }
	 	   	   $.get("CheckName.do?username="+username,null,function(data){
	 	      $("#checkUsernameResult").html(data);
	 	       if(data=="用户已存在"){
	 	    	  checkUserNameTrue=false;
	 	       }else{
	 	    	  checkUserNameTrue=true;
	 	       }
	 	   	   });	
	 	   	  
  }
 

function checkEmail(){
 
	var  email = $("#me").val();
	   var   haveKongGe =  checkstrHaveEmpty(email);
	   if(haveKongGe==1){
		   checkEmailTrue=false;
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
	 
		checkEmailTrue=false;
	}
	else{
 
		checkEmailTrue=true;
	}
}

var  oldPassword ;
function checkOldPassword(password){
	 
	  var    password2=  $("#password_m").val();
 oldPassword = password2;
	  if(password!=password2){
		  checkPasswordTrue=false;
	    $("#checkOldPasswordResult").html("密码错误，请重新输入");
		  return;
	  }
	  checkPasswordTrue=true;
 
	  $("#checkOldPasswordResult").html("输入正确");
}

var checkPsw= false;
function checkPassword(){
	 
	var password  = $("#modify_password").val();
    
	   var   haveKongGe =  checkstrHaveEmpty(password);
	   if(haveKongGe==1){
		   checkPsw=false;
		   $("#showCheckPasswordResult").html("密码不弄包含空格" );
		  return;
	   }  	
  if(password==""){
    	  checkPsw=true;
    	  return;
       }
	if(password.length<6){
		 
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
 
		if(dz==false){
			$("#showCheckPasswordResult").html("至少包含一个字母");
		}else if(ds==false){
			
			$("#showCheckPasswordResult").html("至少包含一个数字");
		}else {
			 $("#showCheckPasswordResult").html("须包含数字和字母 ");
		} 
		 
	}else{
		 
		$("#showCheckPasswordResult").html("√");
		checkPsw=true;
	 }
}
///////////////////////checkPost方法
var   checkStr   = false ;
function checkPostOrEmail(id,rid){
	checkStr=false;
 	 
	$("#"+rid).empty();   
  var  str = $("#"+id).val();
  var   haveKongGe =  checkstrHaveEmpty(str);
  if(haveKongGe==1){
	  checkStr=false;
	  $("#"+rid).html("不能包含空格" );
	  return;
  }  	
    if(str==""){
         
    	 $("#"+rid).html("<font color='green'>warn不能为空!</font>");
        	 checkStr  = false ;
        	 return;
         }
	if(id=="postcode_m"  &&  str.length>7){
	  	 $("#"+rid).html("<font color='green'>warn6个数字内!</font>");
		 checkStr  = false ;
	  	 return;
	  	 
     }
	if(id=="telephone_m"  &&  str.length!=11){
		 $("#"+rid).html("<font color='green'>warn号码11位的!</font>");
		 checkStr  = false ;
		 return ;
	}
         for(var i = 0 ;i<str.length;i++){
        	 
        	 if((str[i]>='0' && str[i]<='9')==false){
        		checkStr= false;
        		 $("#"+rid).html("<font color='green'>warn只能为数字!</font>");
        		 return;
        	 }
         }
        
         checkStr=true;
        
         $("#"+rid).html("<font color='orange'>√</font>");
     
}

function  checkAllModify(){
	 
	checkEmail();
	checkPostOrEmail('telephone_m','telephoneResult_m');
	 
  var username   =  $("#username_m").val();
     var  email    = $("#me").val();
     var  password =   $("#modify_password").val();
 
 if($("#password_m").val()==""){
	 boxD("输入密码验证");
	   return;
 }
 if(password==""){
 
	    checkPsw=true;
 }
     var   truename_m=  $("#truename_m").val();
     var address_m   = $("#address_m").val();
     var  province  =$("#province").val();
     var  city1  =$("#city1").val();
     var  city2  =$("#city2").val();
     var  postcode_m  = $("#postcode_m").val();
     var  telephone_m  = $("#telephone_m").val();
     
   if((checkStr&&checkUserNameTrue  && checkEmailTrue  && checkPasswordTrue  &&checkPsw)==false){
	    var    r    ;
	    if (checkUserNameTrue==false){r ="用户";}
	    else if(checkEmailTrue==false){r="邮箱";}
	    else   if(checkPasswordTrue==false){r="密码";}
	    else if (checkPsw==false){r="修改密码";} 
		  else  if(checkStr==false){r="邮编或电话不合法";}
	    boxD(r);
	   return  ;
   }
   boxB(username,email,truename_m,address_m,province,city1,city2,postcode_m,telephone_m);
       
 }

function goModify(){
	 var username   =  $("#username_m").val();
     var  email    = $("#me").val();
     var  password =   $("#modify_password").val();
 
     if(password  ==""){
     
    	 password= oldPassword;
    	      }
     var   truename_m=  $("#truename_m").val();
     var address_m   = $("#address_m").val();
     var  province  =$("#province").val();
     var  city1  =$("#city1").val();
     var  city2  =$("#city2").val();
     var  postcode_m  = $("#postcode_m").val();
     var  telephone_m  = $("#telephone_m").val();
     $.get("./modifyUser.do",{username:username,email:email,password:password,truename:truename_m,address:address_m,province:province,city1:city1,city2:city2,post:postcode_m,telephone:telephone_m},function(data){
    	 alert(data);
    	 window.location="./index.jsp";
     });
}


//////////////////////////////纳呆
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
 


///////////////////////////////////////Box类型
function boxA(str){
dhtmlx.modalbox({ 
title:"消息框", 
text:""+str+"</br> <a href='#' onclick='dhtmlx.modalbox.hide(this)'>click to close</a>",
width:"200px",
height:"200px"
});
}


function boxB(a,b,c,d,e,f,g,h,i){
dhtmlx.modalbox({ 
text:
   " <table align='center'>"+
   "  <caption>修改信息如下</caption>"+
   " <tr><td>用户名:</td><td>"+a+"</td></tr>"+
   " <tr><td>E-mail:</td><td>"+b+"</td></tr>"+
   " <tr><td>姓名:</td><td>"+c+"</td></tr>"+
   " <tr><td>地址:</td><td>"+d+"</td></tr>"+
   " <tr><td>地区:</td><td>"+e+"+"+f+"+"+g+"</td></tr>"+
   " <tr><td>邮编:</td><td>"+h+"</td></tr>"+
   " <tr><td>联系电话:</td><td>"+i+"</td></tr>"+
   " </table>",
width:"450px",
position:"center",
buttons:["确认", "取消" ],
callback:function(index){

	if(index==0){
		//跳转修改并跳转
		goModify();
		
	}else{
	 //取消
	}
	
}
});
}
function boxC(){
var box = dhtmlx.modalbox({ 
title:"修改信息如下:", 
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



//////////////////////////////////

 