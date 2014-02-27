
//1.首先注册一个click事件
//2.拿到当前点击的值，保存，将页面设为null
//3.插入一个文本框，放入值，相应enter键桥下
function init() {
	
	selectShow();
    
}


//前提是页面上有两个下拉列表 其中一个id为ptype另一个 的id为 ctype
//1.先进入后台将大类查出来
//2.
function selectShow(){
	 $.getJSON("./loadAllSort.do",{pid:0},callback);
	 $.getJSON("./loadAllSort.do",{pid:1},callback_2);
	 //ptye是页面上的bigsortselect的id
	 $("#ptype").change(function(){
     var id = $("#ptype").val();
	 $.getJSON("./loadAllSort.do",{pid:id},callback_2);//dsds.do?pid=id ,大括弧里面的值代表传入页面的参数
	 });
 }

function callback(data){//当在servlet中处理完后 实现回调函数
   for(var i= 0;i<data.length;i++){
		 var obj = $("<option>");
		 obj.val(data[i]["sid"]);
		 obj.text(data[i]["name"]);
		 $("#ptype").append(obj);
	  }
}
function callback_2(data){
	     $("#ctype").empty();
	    for(var i= 0;i<data.length;i++){
		 var obj = $("<option>"); 
		 obj.val(data[i]["sid"]);   //
		 obj.text(data[i]["name"]);
		 $("#ctype").append(obj);
	 }
}


