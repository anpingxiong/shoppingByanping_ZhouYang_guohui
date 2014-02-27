function replace(o) {
	var str = $("#num" + o).html();
	var name = $("#name" + o).html();
	
	$("#num" + o).empty();// 单元格里面清空

	var objInput = $("<input>");

	objInput.val(str);
	$("#num" + o).append(objInput);
	$(this).unbind("click");// 单击后click事件要解除掉
	objInput.keypress(function(event) {
		if (event.keyCode == 13) {
			var num = $(this).val();
		 		for(var p= 0;p<num.length;p++){
				if(num[p]>='a' && num[p]<='z' || num[p]>='A' && num[p]<='Z'){
					alert("您输入的不能有数字！");
					return false;
				break;
				}else if
				(num[p]<=9 &&num[p]>=0){
				continue;
				}
			  }
			 	var objDiv = $(this).parent();
				  objDiv.empty();
			   	objDiv.html(num);
	   		objDiv.click(replace);
			$.get("updateCartNumber.do", {
				name : name,
				num : num
		                                 	}, function(data) {
				alert(data);
				 window.location.reload();
			});
		
		
			
		}
	});

}

function back(b) {

	var name = $("#name" + b).html();
	$.get("backCart.do", {
		name : name
	}, function(data) {
		alert("取消商品成功");
		window.location.reload();
		// 重新刷新一下本界面
	});
}

function removeOrder(a){

	var oid = $("#oid"+a).html();
	$.get("removeOrder.do",{oid:oid},function(data){
		alert("取消订单成功！");
		window.location.reload();
	});
}



function deliverOrder(a,tag){
	
	var oid = $("#oid"+a).html();
	
	if(tag==1){
		$.get("../deliverOrder.do",{oid:oid},function(data){
			alert("发货成功！");
			
				window.location.reload();
		
			
		});
	}
	else{
	 
		$.get("./deliverOrder.do",{oid:a},function(data){
			alert("发货成功！");
			window.location="./manage/OrderManage.jsp";
		});
	 
	}

	
}



function deleteOrder(o){
	var oid = o;
	$.get("./removeOrder.do",{oid:oid},function(data){
		alert("删除订单成功!");
		window.location="./manage/OrderManage.jsp";
	});
}

function checkName(){
	var a = $("#getname").val();
	if(a.length>15){
		$("#checkName").html("<font color='red'>您输入的名字不合法！</font>");
	}else if(a == ""){
		$("#checkName").html("<font color='red'>不能为空！</font>");
	}else{
	$("#checkName").html("<font color='red'>√</font>");
	}
}
function checkAddress(){
	var a =$("#getaddress").val();
	
	if(a ==""){
		$("#checkAddress").html("<font color='red'>不能为空！</font>");
	}else{
		$("#checkAddress").html("<font color='red'>√</font>");
	}
}

function checkPost(){ 
	var a = $("#post").val();
	if(a.length<6||a.length>6){
	$("#checkPost").html("<font color='red'>邮编不符合</font>");
	}else{
		for(var p= 0;p<a.length;p++){
			if(a[p]>='a' && a[p]<='z' || a[p]>='A' && a[p]<='Z'){
				$("#checkPost").html("<font color='red'>邮编必须是数字！</font>");
			}else
			if(a[p]<=9 &&a[p]>=0){
				$("#checkPost").html("<font color='red'>√</font>");
			}
	}
}
		 }


function checkTel(){
	var a =$("#tel").val();
	if(a.length<11||a.length>11){
		$("#checkTel").html("<font color='red'>电话号码长度不一致</font>");
	}else{
		for(var p= 0;p<a.length;p++){
			if(a[p]>='a' && a[p]<='z' || a[p]>='A' && a[p]<='Z'){
				$("#checkTel").html("<font color='red'>电话必须是数字！</font>");
			}else
			if(a[p]<=9 &&a[p]>=0){
				$("#checkTel").html("<font color='red'>√</font>");
			}
	}
	}
}




