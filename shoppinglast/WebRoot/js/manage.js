$(document).ready();
function loginmange(){
	$("#userTip").empty();
	$("#pwdTip").empty();
	if($("#manager").val()==""||$("#PWD").val()==""){
		$("#pwdTip").html("<font color=red>请完整输入</font>");
		return false;
	}
	if($("#manager").val()!="bod"){
		$("#pwdTip").html("<font color=red>用户不存在</font>");
		return false;
	}
	if($("#PWD").val()!="12345"){
		$("#pwdTip").html("<font color=red>密码错误</font>");
		return false;
	}
	return true;
}