<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../CSS/style.css" rel="stylesheet">
<link href="../CSS/Button_3D.css" rel="stylesheet">
<link href="../CSS/date_input.css" rel="stylesheet">



 <script type="text/javascript" src="../js/jquery.js"></script>

  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/message_default.css">
<script type="text/javascript" src="../js/global_anping_placardManage.js"></script>
 
 <script type="text/javascript" src="${pageContext.request.contextPath }/js/message.js"></script>	
 
</head>

<body  onload="init()" >  
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
	          <td valign="top" background="${pageContext.request.contextPath }/images/manage_01.gif"><table width="100%" height="118"  border="0" cellpadding="0" cellspacing="0">
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
                <td valign="top" background="${pageContext.request.contextPath }/images/manage_02.gif"> 
                   <!-- 操作菜单 -->
           <table width="100%" height="350"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="18%" height="61">&nbsp;</td>
            <td width="82%">&nbsp;</td>
          </tr>
          <tr>
            <td height="46">&nbsp;</td>
            <td><a href="GoodsManage.jsp" class="word_white">商品管理<br>
              Goods Manage</a></td>
          </tr>
          <tr>
            <td height="47">&nbsp;</td>
            <td><a href="MemberManage.jsp" class="word_white">会员管理<br>
              Member Manage</a></td>
          </tr>
          <tr>
            <td height="48">&nbsp;</td>
            <td><a href="OrderManage.jsp" class="word_white">订单管理<br>
              Order Manage</a></td>
          </tr>
          <tr>
            <td height="50">&nbsp;</td>
            <td><a href="placardManage.jsp" class="word_white">公告管理<br>
              Placard Manage</a></td>
          </tr>
          <tr>
            <td height="50">&nbsp;</td>
            <td><a href="ParameterManage.jsp" class="word_white">参数管理<br>
              Parameter Manage </a></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><a href="logout.html" class="word_white">退出后台<br>
              Exit Background </a></td>
          </tr>
        </table>
         <!-- 操作菜单结束 --> 
                </td> 
              </tr> 
            </table></td> 
          <td align="center" valign="top"><table width="100%" height="120"  border="0" cellpadding="0" cellspacing="0"> 
              <tr> 
                <td valign="top" background="${pageContext.request.contextPath }/images/manage_center_placardlist.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0"> 
                    <tr> 
                      <td width="98%" align="right"><a href="placard_add.jsp">[ <img src="${pageContext.request.contextPath }/images/list.gif" width="11" height="13">&nbsp;添加公告信息]</a></td> 
                      <td width="2%">&nbsp;</td> 
                    </tr> 
                  </table></td> 
              </tr> 
            </table> 
              <table width="98%" height="192"  border="0" cellpadding="0" cellspacing="0" class= "tableHide">
              <tr><td>垃圾公告扫描并已删除!</td></tr>
              </table>
              <table width="98%" height="192"  border="0" cellpadding="0" cellspacing="0"> 
                <tr> 
                  <td valign="top">                   
                    <table width="100%" height="48"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#CCCCCC" bordercolorlight="#FFFFFF"> 
                      <tr bgcolor="#eeeeee"> 
                        <td width="10%" align="center">编号</td> 
                        <td width="40%" height="24" align="center">公告标题</td> 
                        <td width="20%" align="center">发布时间</td> 
                        <td width="20%" align="center">失效时间</td> 
                        <td width="5%" align="center">修改</td>
                        <td width="5%" align="center">删除</td>
                      </tr> 
                      <tr><td><div id='loadUserImg'><img src='${pageContext.request.contextPath }/images/loading.gif' height='40' width='60'></div></tr>
                      <table id="placardTable"  width="100%" height="48"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#CCCCCC" bordercolorlight="#FFFFFF">
                      </table>                    
                      </table>                   
                    <table id="yueSelect" width="100%"  border="0" cellspacing="0" cellpadding="0">
					 </table>	
                    </td> 
                </tr> 
              </table>            
            <table width="100%" height="46"  border="0" cellpadding="0" cellspacing="0"> 
              <tr> 
                <td background="${pageContext.request.contextPath }/images/manage_06.gif">&nbsp;</td> 
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
		      <!--版权信息结束  -->  
          </td> 
        </tr> 
      </table></td> 
  </tr> 
</table> 
</body>
</html>

 