<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.shopping.guoguo.pojo.*"%>
<%@ include file="../include_head.jsp" %>

<%
 List<Goods> pgoods = (List<Goods>)request.getAttribute("pgoods");
 if(pgoods == null){
 //因为这里要实现分类 所以我们调用的不再是以前的方法了 而是DAO中新的方法
 request.getRequestDispatcher("../showGoodsPage.do?currentPage=1&tag=0").forward(request, response);
}
%>

<html>
<head>
<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/CSS/style.css" rel="stylesheet">
<link  href="${pageContext.request.contextPath}/CSS/Button_3D.css"  rel="stylesheet">
<link rel="stylesheet" type="tip-yellow/css" href="${pageContext.request.contextPath}/CSS/tip-yellow.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/message_default.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/global_guoguo_addGoods.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/global_guoguo_sort.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/message.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.poshytip.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/global_guoguo_showAllGoods.js"></script>

</head>
<script type="text/javascript">
	 $(function(){
	  
 	$('.buhuo').poshytip({
				className: 'tip-yellow',
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
 
	} )
	</script>
<body onload="init()" >

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
            <td><a href="logout.jsp" class="word_white">退出后台<br>
              Exit Background </a></td>
          </tr>
        </table>
         <!-- 操作菜单结束 --> 
        </td>
      </tr>
    </table></td>
    <td align="center" valign="top"><table width="100%" height="120"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top" background="${pageContext.request.contextPath}/images/manage_03.gif"><table width="100%" height="36"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="70%">
	            <!--搜索框-->
				<form name="search" method="post" action="${pageContext.request.contextPath}/searchGoodsByOrder.do">
				<table width="100%" height="23"  border="0" cellpadding="0" cellspacing="0">
				<tr>
				  <td height="7"></td>
				</tr>
				<tr>
				  <td width="85%">&nbsp;&nbsp;&nbsp;&nbsp;商品类别：
				<select   name="bigSort" class="textarea" id="ptype" >					  
					  <option value=""></option>					  
                      </select>
					<input name="content" type="text" class="txt_grey" size="15">              
                    <input type="submit" class="button white small" value="搜索"></td>
				</tr>
				</table>
				</form>
				<!--搜索框结束-->
            </td>
            <td width="28%" align="right"><a href="${pageContext.request.contextPath}/manage/goods_add.jsp">[ <img src="${pageContext.request.contextPath}/images/list.gif" width="11" height="13">&nbsp;添加商品信息]</a></td>     
            <td width="2%">&nbsp;</td>       
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="98%" height="192"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign="top">
            <table width="100%" height="14"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td height="13" align="center">&nbsp;</td>
              </tr>
            </table>
            <table width="100%" height="48"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#CCCCCC" bordercolorlight="#FFFFFF">
              <tr bgcolor="#eeeeee">
                <td width="5%" align="center">编号</td>
                <td width="25%" height="24" align="center">商品名称</td>
                <td width="13%" align="center">所属类型</td>                
                <td width="13%" align="center">价格</td>                
                <td width="12%" align="center">商品数量(件)</td>
                <td width="12%" align="center">订购数量(件)</td>
                <td width="5%" align="center">特价</td>
                <td width="5%" align="center">补货</td>
                <td width="5%" align="center">修改</td>
                <td width="5%" align="center">失效</td>
              </tr>
              </table>
              <table   id="goodsTable"   width="100%" height="48"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#CCCCCC" bordercolorlight="#FFFFFF">
              </table>
 
              <!-- start goodList -->
<!--        <c:set var="num" value="0"></c:set> -->
       
<!--         <c:set var="tejia" value="是"></c:set> -->
<!--        <c:forEach items="${pgoods}" var="pgood"> -->
<!--        <%--<c:set value="${good.sort}" var="sort"></c:set> --%> -->
<!--               <tr style="padding:5px;"> -->
<!--             <c:set value= "${num+1}" var="num"></c:set> -->
<!--            <td align="center">${num}</td> -->
                
<!--           <td height="20" align="center"><a href="${pageContext.request.contextPath}/showGoodsDetails.do?gid=${pgood.gid}" >${pgood.name}</a></td>                  -->
<!--                 <td align="center">${pgood.sort.name}</td> -->
<!--                 <td align="center">￥${pgood.marketprice}</td>                 -->
<!--                 <td align="center">${pgood.goodsnum}</td> -->
<!--                 <td align="center">${pgood.ordernum}</td> -->
<!--                 <td align="center"> -->
               
<!--                 <c:if test="${pgood.bargain==1}"><c:out value="是"></c:out></c:if> -->
<!--                 <c:if test="${pgood.bargain==0}"><c:out value="否"></c:out></c:if> -->
                
<!--                 </td> -->
<!--                 <td align="center"><span title="每件商品库存数量不能大于1万哦！你心里有数的！" class="buhuo" onclick="a()"><img  src="${pageContext.request.contextPath}/images/add.gif" width="16" height="16" ></span></td> -->
<!--                 <td align="center"><a href="${pageContext.request.contextPath}/showModifiedGoods.do?gid=${pgood.gid}"><img src="${pageContext.request.contextPath}/images/modify.gif" width="15" height="15"></a></td> -->
<!--                 <td align="center"><a href="${pageContext.request.contextPath}/deleteGoods.do?gid=${pgood.gid}"><img src="${pageContext.request.contextPath}/images/del.gif" width="16" height="16"></a></td> -->
<!--               </tr> -->
<!--              </c:forEach> -->
              <!-- end goodList -->
            </table>
          <!-- 分页标示开始 -->
            
              <c:set value="${vo}" var="vo"></c:set>
           
           <table  id="pageTable"   width="100%"  border="0" cellspacing="0" cellpadding="0">
<!-- 			  <tr> -->
<!-- 			    <td align="right">当前页数：[${vo.currentPage}/${vo.totalPage}]&nbsp; -->
				
<!-- 				<a href="${pageContext.request.contextPath}/showGoodsPage.do?currentPage=1&tag=0">第一页</a>　<a href="${pageContext.request.contextPath}/showGoodsPage.do?currentPage=${vo.currentPage-1}&tag=0">上一页</a> -->
				<!-- 判断 如果currentPage已经等于otalpage那么 currentpage就等于totalpage -->
<!-- 					 <c:if test="${vo.currentPage!=vo.totalPage}" > -->
<!-- 				<a href="${pageContext.request.contextPath}/showGoodsPage.do?currentPage=${vo.currentPage+1}&tag=0">下一页</a>　 -->
<!-- 				</c:if> -->
<!-- 				 <c:if test="${vo.currentPage==vo.totalPage}" > -->
<!-- 				<a href="${pageContext.request.contextPath}/showGoodsPage.do?currentPage=${vo.totalPage}&tag=0">下一页</a>　 -->
<!-- 				</c:if> -->
<!-- 				<a href="${pageContext.request.contextPath}/showGoodsPage.do?currentPage=${vo.totalPage}&tag=0">最后一页&nbsp;</a> -->
				
<!-- 				</td> -->
<!-- 			  </tr> -->
			</table>
			 <!-- 分页标示结束 -->	
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
        <td height="8" colspan="2">&quot;</td>
        <td height="8" align="center">&lt;</td>
        <td height="8" colspan="2">&nbsp;</td>
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

 

