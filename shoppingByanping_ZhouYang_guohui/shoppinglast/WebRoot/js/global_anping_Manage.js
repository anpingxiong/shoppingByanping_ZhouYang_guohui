function init(page) {
	showTable();
	showUsers(page);
}
var pageMax = 2000;
function showTable() {
	$("#createUserTable")
			.append(
					" "
							+ " <table width='100%' height='48'  border='1' cellpadding='0' cellspacing='0' bordercolor='#FFFFFF' bordercolordark='#CCCCCC' bordercolorlight='#FFFFFF'>"
							+ "<tr>"
							+ " <td width='5%' align='center'>编号</td>  "
							+ "<td width='10%' height='27' align='center'>用户名</td>  "
							+ "<td width='15%' align='center'>真实姓名</td>  "
							+ " <td width='30%' align='center'>Email</td>   "
							+ " <td width='10%' align='center'>销费额</td>  "
							+ "  <td width='10%' align='center'>会员等级</td>  "
							+ "  <td width='15%' align='center'>创建时间</td>  "
							+ "  <td width='5%' align='center'>冻结</td>  "
							+ "  <tr><td><div id='loadUserImg'><img src='../images/loading.gif' height='40' width='60'></div></tr>"
							+ "   <table id='tableTr'  width='100%' height='48'  border='1' cellpadding='0' cellspacing='0' bordercolor='#FFFFFF' bordercolordark='#CCCCCC' bordercolorlight='#FFFFFF'></table>"
							+ "</table>"
							+ "  <table  id='pageMa' width='100%'  border='0' cellspacing='0' cellpadding='0'></table>");

}

function showUsers(page) {
	if (page < 1) {
		page = 1;
	}

	if (page > pageMax) {
		page = page - 1;
		sAlert("温馨提示:到底了!");
	}
	$("#loadUserImg").show();
	$("#loadUserImg").fadeOut(500);

	$("#tableTr").empty();
	$("#pageMa").empty();
	$
			.getJSON(
					"../showUser.do",
					{
						page : page
					},
					function(data) {

						for ( var i = 0; i < data.length; i++) {

							var gif = data[i]["state"] == 1 ? 'thaw.gif'
									: 'freeze.gif';

							$("#tableTr")
									.append(
											" "
													+ " <tr style='padding:5px;'> "
													+ " <td align='center' width='5%'>"
													+ data[i]["uid"]
													+ "</td> "
													+ " <td   align='center' width='10%'><a href='../showUserDetail.do?uid="
													+ data[i]["uid"]
													+ "'>"
													+ data[i]["username"]
													+ "</a></td> "
													+ " <td align='center' width='15%'>"
													+ data[i]["name"]
													+ "</td> "
													+ " <td align='center' width='30%'> "
													+ data[i]["email"]
													+ "</td> "
													+ " <td align='center' width='10%'>"
													+ data[i]["expense"]
													+ "</td> "
													+ " <td align='center' width='10%'>"
													+ data[i]["level"]
													+ "</td> "
													+ " <td align='center' width='15%'>"
													+ data[i]["pdate"]
													+ "</td> "
													+ " <td align='center' width='5%'><span onclick='changUserState("
													+ data[i]["uid"]
													+ ")' class='showHand' id="
													+ data[i]["uid"]
													+ " state='"
													+ data[i]["state"]
													+ "'><img src='../images/"
													+ gif
													+ "' alt='"
													+ data[i]["state"]
													+ "'  "
													+ "  width='13' height='15'></span> "
													+ " </td> " + " </tr> ");
						}

						pageMax = data[0]["totolPage"];

						$("#pageMa")
								.append(
										""
												+ "	  <tr>"
												+ "    <td align='right'>当前页数：["
												+ page
												+ "/"
												+ data[0]["totolPage"]
												+ "]&nbsp;"
												+ "	<a class='showHand' onclick='showUsers(1)'>第一页</a> <a   class='showHand' onclick='showUsers("
												+ (parseInt(page) - 1)
												+ ")'>上一页</a>"
												+ "	<a  class='showHand' onclick='showUsers("
												+ (parseInt(page) + 1)
												+ ")'>下一页</a> <a class='showHand'  onclick='showUsers("
												+ data[0]["totolPage"]
												+ ")'>最后一页&nbsp;</a>"
												+ "	</td>" + "	  </tr >");
					});

};

function changUserState(id) {
	var state = $("#" + id).attr("state");

	var gif = state == 0 ? 'thaw.gif' : 'freeze.gif';
	state = state == 0 ? 1 : 0;

	// 进入后台我去修该它！
	$.get("../changeUserState.do?uid=" + id + "&state=" + state, null,
			function(data) {
				sAlert(data);
			});
	// 现将页面上的图片修改一下

	// alert(("#"+id).html());
	$("#" + id).empty();
	$("#" + id).append(
			"<img src='../images/" + gif + "' alt='" + state + "'  "
					+ "  width='13' height='15'>");

	$("#" + id).removeAttr("state");
	$("#" + id).attr("state", state);

}

function sAlert(str) {
	dhtmlx
			.modalbox({
				title : "消息框",
				text : ""
						+ str
						+ "</br></br> <a href='#' onclick='dhtmlx.modalbox.hide(this)'><span   class='dhtmlx_button'><input type='button'   value='点击关闭'  style='width:250px;'></span></a>",
				width : "100px",
				height : "150px"
			});
}

function getUserByOrder() {
	var uid = $("#uid_se").val();
	var username = $("#username_se").val();

	if (username == '') {
		username = 1;
	}
	// 在JSON中我们来删除两个table的东西
	$
			.getJSON(
					"../selectUserByOrder.do",
					{
						id : uid,
						username : username
					},
					function(data) {
						$("#tableTr").empty();
						if (data[0]["uid"] == "") {
							$("#tableTr")
							.append("------------------NULL-----------------------");
							sAlert("检索的用户数量为空!");
							return;
						}

						$("#tableTr").empty();
						var gif = data[0]["state"] == 1 ? 'thaw.gif'
								: 'freeze.gif';

						$("#tableTr")
								.append(
										" "
												+ " <tr style='padding:5px;'> "
												+ " <td align='center' width='5%'>"
												+ data[0]["uid"]
												+ "</td> "
												+ " <td   align='center' width='10%'><a href='../showUserDetail.do?uid="
												+ data[0]["uid"]
												+ "'>"
												+ data[0]["username"]
												+ "</a></td> "
												+ " <td align='center' width='15%'>"
												+ data[0]["name"]
												+ "</td> "
												+ " <td align='center' width='30%'> "
												+ data[0]["email"]
												+ "</td> "
												+ " <td align='center' width='10%'>"
												+ data[0]["expense"]
												+ "</td> "
												+ " <td align='center' width='10%'>"
												+ data[0]["level"]
												+ "</td> "
												+ " <td align='center' width='15%'>"
												+ data[0]["pdate"]
												+ "</td> "
												+ " <td align='center' width='5%'><span onclick='changUserState("
												+ data[0]["uid"]
												+ ")' class='showHand' id="
												+ data[0]["uid"]
												+ " state='"
												+ data[0]["state"]
												+ "'><img src='../images/"
												+ gif
												+ "' alt='"
												+ data[0]["state"]
												+ "'  "
												+ "  width='13' height='15'></span> "
												+ " </td> " + " </tr> ");

					});
}
