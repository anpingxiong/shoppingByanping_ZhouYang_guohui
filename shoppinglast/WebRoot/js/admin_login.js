var AdminNameResult=false,AdminPasswordResult=false;
function chenckIsAdmin(){
 
	AdminNameResult=false;
	var   manager  =   $("#admin").html();
	 alert(manager);
       if(manager!="bod" || manger!="admin"){
    	   AdminNameResult=false;
		$("#checkNameResult").html("<font color='red'>权限不足!</font>");
		$("#buttonforsubmit").hide();
	 
	} else{
		AdminNameResult=true;
	}
		
}

function checkPassword (){
	alert("11111111111");
	AdminPasswordResult=false;
	var   password  =   $("#password").val();
    if(password!="12345"){
    	AdminPasswordResult=false;
		$("#checkNameResult").html("<font color='red'>密码错误!</font>");
	 } 
	if(password=="12345"){
		AdminPasswordResult=true;
	}
}

function login(){
       if((AdminPasswordResult && AdminNameResult)==false ){
    	   return false;
       }
}








