
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <html>
<head>
<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 
<link href="../CSS/style.css" rel="stylesheet">
 
<link href="../CSS/Button_3D.css" rel="stylesheet">
<link href="../CSS/date_input.css" rel="stylesheet">
 <link rel="stylesheet" type="tip-yellow/css" href="../CSS/tip-yellow.css">
   <link rel="stylesheet" type="text/css" href="../CSS/message_default.css">
<script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery-1.4.min.js"></script>
<script type="text/javascript" src="../js/jquery.poshytip.min.js"></script>
<script type="text/javascript" src="../js/global_anping_addPlcard.js"></script>
 <script type="text/javascript" src="../js/jquery.date_input.js"></script>
  <script type="text/javascript" src="../js/message.js"></script>	
<script type="text/javascript">
jQuery.extend(DateInput.DEFAULT_OPTS, {  month_names: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],  short_month_names: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"],  short_day_names: ["一", "二", "三", "四", "五", "六", "日"],  
dateToString : function(date) {  
    var month = (date.getMonth() + 1).toString();  
    var dom = date.getDate().toString();  
    if (month.length == 1) month = "0" + month;  
    if (dom.length == 1) dom = "0" + dom;  
    return date.getFullYear() + "-" + month + "-" + dom;  
  }  
  
});   
  
$(function() {   
$(".biuuu1").date_input();   
$(".biuuu2").date_input();   
 
 $('#overdate').poshytip({
				className: 'tip-yellow',
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
			 
	} )
	</script>
</head>
<body> 
<table width="777" height="192"  border="0" align="center" cellpadding="0" cellspacing="0" class="tableBorder">
<tr>
  <td>
<!-- LOGO -->
	<table width="777" height="115"  border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr>
	    <td valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td bgcolor="#CCCCCC" height="6px"></td>
	      </tr>
	    </table>
	      <table width="100%" height="123"  border="0" cellpadding="0" cellspacing="0">
	        <tr>
	          <td valign="top" background="../images/manage_01.gif"><table width="100%" height="118"  border="0" cellpadding="0" cellspacing="0">
	            <tr>
	              <td height="98" colspan="2">&nbsp;</td>
	            </tr>
	            <tr>
	              <td width="25%">&nbsp;</td>
	              <td width="75%" class="word_green" id="bgclock"></td>
	            </tr>
	          </table></td>
	        </tr>
	      </table></td>
	  </tr>
	</table>
<!-- LOGO结束-->
<table width="777" height="288"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="182" valign="top"><table width="100%" height="431"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top" background="../images/manage_02.gif">
          <!-- 操作菜单 -->
           <table width="100%" height="350"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="18%" height="61">&nbsp;</td>
            <td width="82%">&nbsp;</td>
          </tr>
          <tr>
            <td height="46">&nbsp;</td>
            <td><a href="../GoodsManage.jsp" class="word_white">商品管理<br>
              Goods Manage</a></td>
          </tr>
          <tr>
            <td height="47">&nbsp;</td>
            <td><a href="../MemberManage.jsp" class="word_white">会员管理<br>
              Member Manage</a></td>
          </tr>
          <tr>
            <td height="48">&nbsp;</td>
            <td><a href="../OrderManage.jsp" class="word_white">订单管理<br>
              Order Manage</a></td>
          </tr>
          <tr>
            <td height="50">&nbsp;</td>
            <td><a href="../PlacardManage.jsp" class="word_white">公告管理<br>
              Placard Manage</a></td>
          </tr>
          <tr>
            <td height="50">&nbsp;</td>
            <td><a href="../ParameterManage.jsp" class="word_white">参数管理<br>
              Parameter Manage </a></td>
          </tr>
           <tr>
            <td height="50">&nbsp;</td>
            <td><a href="../ad.jsp" class="word_white">广告管理<br>
              Parameter Manage </a></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><a href="../logout.jsp" class="word_white">退出后台<br>
              Exit Background </a></td>
          </tr>
        </table>
         <!-- 操作菜单结束 --> 
        </td>
      </tr>
    </table></td>
    <td align="center" valign="top"><table width="100%" height="120"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top" background="../images/manage_center_placardadd.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="98%" align="right">&nbsp;</td>
            <td width="2%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="92%" height="192"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign="top">
   			  <form action="../addAd.do" method="post" name="form1"  enctype="multipart/form-data" onsubmit="return checkOverDateToPdate();">
			   
			    <table width="100%"  border="0" align="center" cellpadding="-2" cellspacing="-2" bordercolordark="#FFFFFF">
                  <tr>
                    <td >广告标题：</td>
					<td><input name="exp" type="text" id="title" size="60"  ></td>
                  </tr> 
				  <tr>
                    <td width="14%" >&nbsp;广告链接：</td>
                    <td width="86%">
                        <input type="text" name="aURL" size="60" id="content"  ></td>
                  </tr> 
                 
                <!-- 商品图片上传 -->
                 <tr>
                <td>上传图片：</td>
                    <td colspan="3"><span class="style5">&nbsp;</span><input title="图片格式一定要为jpg哦！" class="add" type="file" name="pricute" size=46>
                    </td>
                         </tr>
                    <!-- 商品图片上传 -->
               
                  <tr>
                    <td height="30">失效时间：</td>
					<td>
					   <input type="text" class="biuuu2" name="overdate"  size="60" id="overDate" title="注意时间不要超过当前时间"/>   
                    </td>
                  </tr>                  
                  <tr>
                    <td height="25" colspan="2" align="center">
                        <input name="Button" type="submit" class="button white  small " value="保存"  >
                        &nbsp;                        
                        <input name="Submit3" type="button" class="button white  small " value="返回" onClick="JScript:history.back()">
                    </td>
                  </tr>
                </table>
			  </form>
          </td>
        </tr>
      </table>
      <table width="100%" height="46"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td background="../images/manage_06.gif">&nbsp;</td>
        </tr>
      </table></td>
  </tr>
</table>
<table width="777"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="54" align="center"><!--版权信息  -->
		      <table width="100%" height="78"  border="0" align="center" cellpadding="-2" cellspacing="-2">
		      <tr>
		        <td height="13" colspan="5"></td>
		        </tr>
		      <tr>
		        <td width="124" height="13">&nbsp;</td>
		        <td height="13" colspan="3" align="center">奋斗子商城客户服务热线：0791-3881060，3881061 传真：0791-3881063</td>
		        <td width="141">&nbsp;</td>
		      </tr>
		      <tr>
		        <td height="15" colspan="2">&nbsp;</td>
		        <td width="464" valign="bottom" align="center"> CopyRight &copy; 2009 www.fendoujiaoyu.com 奋斗教育</td>
		        <td colspan="2">&nbsp;</td>
		      </tr>
		      <tr>
		        <td colspan="2">&nbsp;</td>
		        <td align="center">本站请使用IE6.0或以上版本 1024*768为最佳显示效果</td>
		        <td colspan="2">&nbsp;</td>
		      </tr>
		      <tr bgcolor="#cccccc">
		        <td height="8" colspan="2"></td>
		        <td height="8" align="center"></td>
		        <td height="8" colspan="2"></td>
		      </tr>
		    </table>
		      <!--版权信息结束  -->  </td>
  </tr>
</table>
</td>
</tr>
</table>
</body>
</html>

 