<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../include_head.jsp" %>
<html>

<head>

<title>后台管理</title>
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/global_zhouyang.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<link href="${pageContext.request.contextPath}/CSS/style.css" rel="stylesheet">

<script src="onclock.JS"></script>

</head>

<body  onLoad="clockon(bgclock)"> 

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

            <td><a href="GoodsManage.html" class="word_white">商品管理<br>

              Goods Manage</a></td>

          </tr>

          <tr>

            <td height="47">&nbsp;</td>

            <td><a href="MemberManage.html" class="word_white">会员管理<br>

              Member Manage</a></td>

          </tr>

          <tr>

            <td height="48">&nbsp;</td>

            <td><a href="OrderManage.html" class="word_white">订单管理<br>

              Order Manage</a></td>

          </tr>

          <tr>

            <td height="50">&nbsp;</td>

            <td><a href="PlacardManage.html" class="word_white">公告管理<br>

              Placard Manage</a></td>

          </tr>

          <tr>

            <td height="50">&nbsp;</td>

            <td><a href="ParameterManage.html" class="word_white">参数管理<br>

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

        <td valign="top" background="${pageContext.request.contextPath}/images/manage_center_orderdetail.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">

          <tr>

            <td width="98%" align="right">&nbsp;</td>

            <td width="2%">&nbsp;</td>

          </tr>

        </table></td>

      </tr>

    </table>

      <table width="95%" height="192"  border="0" cellpadding="0" cellspacing="0">

        <tr>

          <td valign="top">

           <table width="100%" height="272"  border="0" cellpadding="0" cellspacing="0">

            <tr>

              <td width="100%" height="220" align="center" valign="top">

				 <table width="97%" height="131"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_LTR_dashed">

                   <tr>

                     <td width="16%" style="padding:5px;" align="center">订单时间：</td>

                     <td>${requestScope.orderVo.order.odate}</td>

                   </tr>

                   <tr>

                     <td width="16%" style="padding:5px;" align="center">订 单 号：</td>

                     <td>${requestScope.orderVo.order.oid}</td>

                   </tr>

                   <tr>

                     <td width="16%" style="padding:5px;" align="center">订单总计：</td>

                     <td>￥${requestScope.orderVo.order.total}(元)</td>

                   </tr>

                   <tr>

                     <td colspan="2"><hr align="center" width="92%" size="1"></td>

                   </tr>

                      <tr>

                          <td style="padding:5px;" align="center">付款方式：</td>

                          <td>
                          <c:choose>
                          		<c:when test="${requestScope.orderVo.order.payway==1}">邮政付款 </c:when>
                          		<c:when test="${requestScope.orderVo.order.payway==2}">网银付款</c:when>
                          		<c:otherwise>货到付款 </c:otherwise>
                          </c:choose>
                          </td>

                        </tr>

                   <tr>

                          <td style="padding:5px;" align="center">开具发票：</td>

                          <td>-
                          <c:choose>
                          		<c:when test="${requestScope.orderVo.order.billinfo==1}">是</c:when>
                          		<c:otherwise>否</c:otherwise>
                          </c:choose> 
                          </td>

                        </tr>

                   <tr>

                     <td colspan="2"><hr align="center" width="92%" size="1"></td>

                   </tr>

                   <tr>

                     <td style="padding:5px;" align="center">配送地址：</td>

                     <td>- ${requestScope.orderVo.address.getname}</td>

                   </tr>

                   <tr>

                     <td style="padding:5px;" align="center"></td>

                     <td>- ${requestScope.orderVo.address.address}</td>

                   </tr>


                   <tr>

                     <td style="padding:5px;" align="center"></td>

                     <td>- 邮编：${requestScope.orderVo.address.post}</td>

                   </tr>

                   <tr>

                     <td style="padding:5px;" align="center"></td>

                     <td>- 电话：${requestScope.orderVo.address.tel}</td>

                   </tr>

                  <tr>

                          <td style="padding:5px;" align="center">收货方式：</td>

                          <td>-
                          <c:choose>
                          			<c:when test="${requestScope.orderVo.order.getmethod==1}">EMS</c:when>
                          			<c:when test="${requestScope.orderVo.order.getmethod==2}">圆通快递</c:when>
                          			<c:when test="${requestScope.orderVo.order.getmethod==3}">顺丰快递</c:when>
                          			<c:otherwise>中通快递</c:otherwise>
                          </c:choose>
                          </td>

                        </tr>
                         <tr>

                          <td style="padding:5px;" align="center">时间要求</td>

                          <td>-
                          <c:choose>
                          				<c:when test="${requestScope.orderVo.order.timereq==1}">工作日、双休日与假日均可送货</c:when>
                          				<c:when test="${requestScope.orderVo.order.timereq==2}">只双休日、假日送货(工作日不用送)</c:when>
                          				<c:when test="${requestScope.orderVo.order.timereq==3}">只工作日送货(双休日、假日不用送) (注：写字楼/商用地址客户请选择)</c:when>
                          				<c:otherwise>学校地址/地址白天没人，请尽量安排其他时间送货 (注：特别安排可能会超出预计送货天数)</c:otherwise>
                          </c:choose>    
                           </td>

                        </tr>

                   <tr>

                     <td style="padding:5px;" align="center">备&nbsp;&nbsp;&nbsp;&nbsp;注：</td>

                     <td>- ${requestScope.orderVo.order.exp}</td>

                   </tr>                       

                 </table>	  

				 <table width="97%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#CCCCCC" class="tableBorder_dashed">

                   <tr align="center" bgcolor="#eeeeee">

                     <td width="50%" height="24">商品名称</td>                          

                     <td width="20%">数量</td>

                     <td width="30%">单价</td>

                   </tr>						

                 <c:forEach items="${orderVo.orderitems}" var="orderitem">
                        <tr align="center">

                          <td height="24">${orderitem.goods.name}</td>                                                   

                          <td>${orderitem.num}</td>

                          <td>￥${orderitem.goods.nowprice}(元)</td> 

                        </tr>
				</c:forEach>

	               <tr align="center">

                     <td colspan="2" align="right">总计：</td>

                     <td>￥${requestScope.orderVo.order.total}(元)</td> 

                   </tr>

                 </table>	 

			     <table width="100%" height="49"  border="0" cellpadding="0" cellspacing="0">

                    <tr>

                      <td align="center">
									<c:choose>
										<c:when test="${requestScope.orderVo.order.state==1}"><input type="submit" class="btn_grey" value="发货" onclick="deliverOrder('${orderVo.order.oid}',0)"></c:when>
                          				<c:otherwise></c:otherwise>
									</c:choose>
									<input type="button" class="btn_grey" value="删除" onClick="deleteOrder('${orderVo.order.oid}')">
                          <input type="button" class="btn_grey" value="返回" onClick="history.back(-1)">
                          

                      </td>

                    </tr>

                  </table>

                </td>

              <td width="3%" valign="top">&nbsp;</td>

            </tr>

          </table>		 

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

      <!--版权信息结束  --> 

    </td>

  </tr>

</table>

</td>

</tr>

</table>

</body>

</html>



 