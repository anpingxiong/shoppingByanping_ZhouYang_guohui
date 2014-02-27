<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../include_head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../CSS/style.css" rel="stylesheet">
<link  href="../CSS/Button_3D.css"  rel="stylesheet">
<link rel="stylesheet" type="tip-yellow/css" href="${pageContext.request.contextPath}/CSS/tip-yellow.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/message_default.css">
<!-- 导入两个js文件 用来实现大类小类的方法 -->


<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/global_guoguo_sort.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.min.js"></script>
 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/message.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.poshytip.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/global_guoguo_yanzheng.js"></script>

</head>
<script type="text/javascript">
	 $(function(){
	  
 	$('.add').poshytip({
				className: 'tip-yellow',
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
 
	} )
	</script>
<body onload="init()"><!-- 调用global_guoguo_sort.js文件中的init()方法 -->
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
            <td><a href="${pageContext.request.contextPath}/manage/GoodsManage.jsp" class="word_white">商品管理<br>
              Goods Manage</a></td>
          </tr>
          <tr>
            <td height="47">&nbsp;</td>
            <td><a href="${pageContext.request.contextPath}/manage/MemberManage.jsp" class="word_white">会员管理<br>
              Member Manage</a></td>
          </tr>
          <tr>
            <td height="48">&nbsp;</td>
            <td><a href="${pageContext.request.contextPath}/manage/OrderManage.jsp" class="word_white">订单管理<br>
              Order Manage</a></td>
          </tr>
          <tr>
            <td height="50">&nbsp;</td>
            <td><a href="${pageContext.request.contextPath}/manage/PlacardManage.jsp" class="word_white">公告管理<br>
              Placard Manage</a></td>
          </tr>
          <tr>
            <td height="50">&nbsp;</td>
            <td><a href="${pageContext.request.contextPath}/manage/ParameterManage.jsp" class="word_white">参数管理<br>
              Parameter Manage </a></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><a href="${pageContext.request.contextPath}/manage/logout.jsp" class="word_white">退出后台<br>
              Exit Background </a></td>
          </tr>
        </table>
         <!-- 操作菜单结束 --> 
        </td>
      </tr>
    </table></td>
    <td align="center" valign="top"><table width="100%" height="120"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top" background="${pageContext.request.contextPath}/images/manage_center_goodsadd.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="98%" align="right"></td>
            <td width="2%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="92%" height="192"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign="top">
          <!-- 表单的开头 -->
   			 <form action="../upLoad.do" method="post" name="form1" enctype="multipart/form-data" onSubmit="return checkSubmit()">
			    <table width="100%"  border="0" align="center" cellpadding="-2" cellspacing="-2" bordercolordark="#FFFFFF">
                  <tr>
                    <td height="30">&nbsp;所属大类：</td>
                    <td width="31%">&nbsp;
					  <select name="bigSort" class="textarea" id="ptype" onChange="F_super(this.value)">					  
					  <option value=""></option>					  
                      </select></td>
                    <td width="13%"> &nbsp;所属小类：</td>
                    <td width="42%">&nbsp;
                      <select name="smallSort" class="textarea" id="ctype">					  
					   <option value=""></option>					 
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <td width="14%" height="30">&nbsp;商品名称：</td>
                    <td colspan="3">&nbsp;
                      <input title="以下信息都不能为空哦！" name="name" type="text" class="add" id="goodsName" size="50" onblur="not_null('goodsName','商品名称')"><span id="checkGoodsName"></span>                  </td>
                    </tr>
                  <tr>
                    <td height="30">&nbsp;市场价格：</td>
                    <td>&nbsp;
                          <input title="一定要是数字哦！"  name="marketprice" type="text" class="add" id="price1" onblur="not_null('price1','市场价格')">(元)
                    </td>
                    <td>&nbsp;商城价格：</td>
                    <td>&nbsp;
                          <input title="不能大于市场价格哦，也要数字呢！"  name="nowprice" type="text" class="add" id="price2" onblur="not_null('price2','商城价格')">(元)
                    </td>
                  </tr>
                  <tr>                    
                    <td height="30">&nbsp;折 扣 率：</td>
                    <td>&nbsp;
                          <input  title="自动生成哦！"  readonly="readonly" name="discount" type="text" class="add" id="price">
                    </td>
                    <td>&nbsp;是否特价：</td>
                    <td><input name="bargain" type="radio" class="noborder" value="1" checked>是<input name="bargain" type="radio" class="noborder" value="0">否
                    </td>
                  </tr>                 
                  <tr>
                    <td height="30">&nbsp;商品图片：</td>
                    <!-- 商品图片上传 -->
                    <td colspan="3"><span class="style5">&nbsp; </span>
                       <input title="图片格式一定要为jpg哦！" class="add" type="file" name="pricute" size=50>
                    </td>
                    <!-- 商品图片上传 -->
                  </tr>
                  <tr>
                    <td height="103">&nbsp;商品简介：</td>
                    <td colspan="3"><span class="style5">&nbsp; </span>
                        <textarea name="exp" cols="60" rows="5" class="textarea" id="introduce" onblur="not_null('introduce','商品简介')"></textarea></td>
                  </tr>
                  <tr>
                    <td height="38" colspan="4" align="center">
                        <input name="save" type="submit" class="button white small" value="保存">
                        <input name="Submit3" type="button" class="button white small" value="返回" onClick="JScript:history.back(-1)">
                    </td>
                  </tr>
                </table>
			  </form>
			   <!-- 表单的结尾 -->
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
    <td height="54" align="center">
<!--版权信息  -->
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
        <td height="8" align="center">&nbsp;</td>
        <td height="8" colspan="2">ag</td>
      </tr>
    </table>
      <!--版权信息结束  --> 
    </td>
  </tr>
</table>
</td>
</tr>
</table>
</body>
</html>

 