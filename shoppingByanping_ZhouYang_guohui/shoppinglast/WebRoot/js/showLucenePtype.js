$(document).ready{
	selectShow();
 }

function selectShow(){
	 $.getJSON("showPGoods.do",{pid:0},callback);
   }

function callback(data){
   for(var i= 0;i<data.length;i++){
		   var obj = $("<option>");
		 obj.val(data[i]["id"]);
		 obj.text(data[i]["name"]);
		 $("#ptype").append(obj);
	  }
}
 
 