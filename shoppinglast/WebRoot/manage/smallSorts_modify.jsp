<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.shopping.guoguo.pojo.*,com.shopping.guoguo.dao.impl.*"%>
    <%@ include file="../include_head.jsp" %>
    <% Sort sort = (Sort)request.getAttribute("sort"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<link rel="stylesheet" type="tip-yellow/css" href="${pageContext.request.contextPath}/CSS/tip-yellow.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.poshytip.min.js"></script>
<link  href="${pageContext.request.contextPath}/CSS/Button_3D.css"  rel="stylesheet">
<title>小分类信息修改</title>
<link href="${pageContext.request.contextPath}/CSS/style.css" rel="stylesheet">
</head>
  <script type="text/javascript">
	 $(function(){
	  
 	$('.s_sort').poshytip({
				className: 'tip-yellow',
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
 
	} )
	</script>

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
	          <td valign="top" background="${pageContext.request.contextPath}/images/manage_01.gif"><table width="100%" height="118"  border="0" cellpadding="0" cellspacing="0">
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
        <td valign="top" background="${pageContext.request.contextPath}/images/manage_02.gif">
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
        <td valign="top" background="${pageContext.request.contextPath}/images/manage_center_subAdd.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
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
   			  <form action="${pageContext.request.contextPath}/updateSort.do?sid=${sort.sid}" method="post" name="form1">
			    <table width="100%"  border="0" align="center" cellpadding="-2" cellspacing="-2" bordercolordark="#FFFFFF">
                  <tr>
                    <td height="30">小分类名称：</td>
					<td><input class="s_sort" title="分类名称不能为空哦！" name="name" type="text" id="typename" size="60" value="${sort.name}"></td>
                  </tr> 
				  <tr>
                    <td width="16%" >描&nbsp;&nbsp;&nbsp;&nbsp;述</td>
                    <td width="84%" ><textarea title="越详细越好哦！" class="s_sort" name="exp" cols="50" rows="5">${sort.exp }</textarea></td>
                  </tr>
                  <tr align="center">
                    <td height="30" colspan="3">
                   <input name="save" type="submit" class="button white small" value="保存" onClick="mycheck()" >
&nbsp;                        

                        &nbsp;
                        <input name="Submit3" type="button" class="button white small" value="返回" onClick="JScript:history.back(-1)">                    </td>
                    </tr>
                </table>
			  </form>
          </td>
        </tr>
      </table>
      <table width="100%" height="46"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td background="${pageContext.request.contextPath}/images/manage_06.gif">&nbsp;</td>
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
		        <td height="8" align="center"></td>
		        <td height="8" colspan="2"></td>
		      </tr>
		    </table>
		      <!--版权信息结束  --> </td>
  </tr>
</table>
</td>
</tr>
</table>
</body>
</html>