<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../include_head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${empty isPageIn}">
<jsp:forward page="../showOrderManage.do?currentPage=1"></jsp:forward>
</c:if>

<html>
<head>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/global_zhouyang.js"></script>
<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="${pageContext.request.contextPath}/CSS/style.css" rel="stylesheet">
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
        <td valign="top" background="${pageContext.request.contextPath}/images/manage_center_orderlist.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="98%" align="right">
            
            
              <!--搜索框form开始-->
				
				<table width="100%" height="23"  border="0" cellpadding="0" cellspacing="0">
				<tr>
				  <td height="7"></td>
				  <form name="search" method="post" action="../findOrder.do">
				  订单号： 
					<input name="oid" type="text" class="txt_grey" size="10" >
					<input type="submit" class="btn_grey" value="搜索" >
				</form>    
				</tr>
				<tr>
				
				  <td width="85%">
   
                    </td>
                    
                    <form name="search" method="post" action="${pageContext.request.contextPath}/findOrdersByState.do">	 
					订单状态： 
					<select name="state"  id = "state" class="textarea" >
					    
					    <option value="1" >新订单</option>
					    <option value="0" >已配送</option>
					</select> 
					<input type="submit" class="btn_grey" value="搜索" >
					</form>
				</tr>
				</table>
			

				
				<!--搜索框form结束-->
            </td>
            <td width="2%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="95%" height="192"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign="top">
            <table width="100%" height="48"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#CCCCCC" bordercolorlight="#FFFFFF">
              <tr align="center">
                <td width="10%">编号</td>
                <td width="15%" height="30">订单号</td>
                <td width="10%">订单金额</td>                                
                <td width="30%">订单商品</td>                
                <td width="25%">订单时间</td>
                <td width="10%">订单状态</td>
              </tr>
              
         <c:forEach items="${requestScope.orderVos}" var="orderVo"> 
           <c:set var="num" value="${num+1}"></c:set>
			  <tr align="center">
			    <td>${num}.</td>
                <td height="20"><a href="${pageContext.request.contextPath}/showManageOrderDetail.do?oid=${orderVo.order.oid}"><span id="oid${orderVo.order.oid}">${orderVo.order.oid}</span></a></td> 
                <td>￥${orderVo.order.total}</td>
                <td>
                <c:forEach items="${orderVo.orderitems}" var="orderitem">
                 ${orderitem.goods.name}(${orderitem.num})<br>
                 </c:forEach>
                 <br>

                </td>                
                <td>${orderVo.order.odate}</td>
                <td>
                <c:choose>
                				<c:when test="${orderVo.order.state==1}">                     		
                      新订单   
                      		</c:when>
                      		<c:otherwise>     		
                      已配送
                      		</c:otherwise>
                </c:choose>
                </td>
              </tr>
              
             </c:forEach> 
             
            </table>
            <!-- 分页开始 -->

            <table width="100%"  border="0" cellspacing="0" cellpadding="0">
			  <tr>
			    <td align="right">当前页数：[${pageVo.currentPage}/${pageVo.totalPage}]&nbsp;
			
				
				<a href="${pageContext.request.contextPath}/showOrderManage.do?currentPage=1">第一页</a>
			
				<a href="${pageContext.request.contextPath}/showOrderManage.do?currentPage=${pageVo.currentPage-1}">上一页</a>
			<!-- 判断如果currentPage等于totalPage，那么currentPage就等于totalPage -->
			<c:choose>
			<c:when test="${pageVo.currentPage == pageVo.totalPage}">
			<a href="${pageContext.request.contextPath}/showOrderManage.do?currentPage=${pageVo.totalPage}">下一页</a>
			</c:when>
			<c:otherwise>
			<a href="${pageContext.request.contextPath}/showOrderManage.do?currentPage=${pageVo.currentPage+1}">下一页</a>
			</c:otherwise>
			</c:choose>

				<a href="${pageContext.request.contextPath}/showOrderManage.do?currentPage=${pageVo.totalPage}">最后一页&nbsp;</a>
				
				</td>
			  </tr>
			</table>	
			     <!-- 分页结束-->
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

 