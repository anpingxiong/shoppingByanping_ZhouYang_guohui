<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@include file="./include_head.jsp" %>
 
<c:if test="${empty isPageIn}">
<jsp:forward page="./searchGoods.do"></jsp:forward>
</c:if>

<html>

<head>

<title>奋斗电子商城</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="CSS/style.css" rel="stylesheet">
<script type="text/javascript" src="./js/global_guoguo_showGoodDetail.js"></script>
</head>

<!-- 判断有没有登陆 -->
<body onload="isShowLoginTable('${username}','${state}')">
<!-- 判断 有没有登陆-->
<table width="790"  border="0" cellspacing="0" cellpadding="0" align="center">
 <tr>
 <td class="tableBorder">
<!--导航条-->
<table width="790" height="115"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td bgcolor="#CCCCCC" height="6px"></td>
      </tr>
    </table>
      <table width="100%" height="109"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="25%"><img src="images/shop_02.gif" width="275" height="109"></td>
          <td width="75%"><table width="100%" height="109"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="52" align="right" valign="top"><table width="100%" height="31"  border="0" cellpadding="0" cellspacing="0">
                <tr align="center">
                  <td width="281">&nbsp;</td>
                  <td width="7" valign="top"><img src="images/T_contact.gif" width="42" height="28"></td>
                  <td width="72"><a href="mailto:fendou@fendoujiaoyu.com">联系我们</a></td>
                  <td width="10" valign="top"><img src="images/T_favorite.gif" width="42" height="28"></td>
                  <td width="68"><a href="javascript:window.external.AddFavorite('www.fendoujiaoyu.com','奋斗教育')">收藏本站</a></td>
                  <td width="10" valign="top"><img src="images/T_home.gif" width="42" height="28"></td>
                  <td width="70"><a href="#" onclick="this.style.behavior='url(#default#homepage)';this.sethomepage('http://www.fendoujiaoyu.com')">设为首页</a></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="57" valign="top" background="images/shop_07.gif"><table width="100%" height="53"  border="0" cellpadding="0" cellspacing="0">
                <tr align="center">
                  <td width="9%"><a href="index.html">首页<br>
                    Index</a></td>
                  <td width="2%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="15%"><a href="NewGoods.html">新品上架<br>
                    NewGoods</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="14%"><a href="sale.html">特价商品<br>
                    At a sale</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="14%"><a href="member.html">会员资料修改<br>
                    Member</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="10%"><a href="cart_see.html">购物车<br>
                    Cart</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="15%"><a href="order.html">查看订单<br>
                    Order</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="11%"><a href="SellSort.html">销售排行<br>
                    SellSort</a></td>
                  <td width="2%">&nbsp;</td>
                </tr>
              </table></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
<!--导航条结束-->
<table width="790" height="236"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="182" height="182" valign="top">
	<!--左侧框架-->
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="83" align="center"><img src="images/shop_11.gif" width="182" height="83"></td>
      </tr>
      <tr>
        <td height="98" align="center" background="images/shop_17.gif">		 
           <!-- 会员登陆面板 -->
		  <table width="100%"  border="0" 

cellpadding="0" cellspacing="0">
            <tr>
              <td width="10%">&nbsp;</td>
              <td width="90%" valign="top" 

background="Images/index_09.gif">
			<!-- 这里要设置一个div -->  <div 

class="loginTable"></div>
				</td>
            </tr>
          </table>
          <!-- 会员登陆面板 --></td>
      </tr>
    </table>
      <table width="100%" height="155"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><img src="images/shop_22.gif" width="182" height="58"></td>
        </tr>
        <tr>
          <td height="97" align="center" valign="top" class="tableBorder_l">
          <!-- 给公告表一个id 直接调用global_anping_placardManage.js 

-->
          <table id="showNotice" width="88%"  border="0" 

cellspacing="0" cellpadding="0"></table></td>
        </tr>
      </table>
      <table width="100%" height="151"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="40" background="images/shop_33.gif">&nbsp;</td>
        </tr>
        <tr>
          <td align="center" valign="top" class="tableBorder_lb"> <!-- 销售排行循环开始 -->
           <!-- 给销售排行一个id 直接调用

global_guoguo_goodsale.js -->
          <table id="showGoodSale" width="88%"  border="0" 

cellspacing="0" cellpadding="0">
          </table>
        
           <!-- 销售排行循环结束 -->
            <table width="100%"  border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td>&nbsp;</td>
              </tr>
            </table></td>
        </tr>
      </table>
	
	<!--左侧框架结束-->
	</td>
    <td valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="33" background="images/shop_12.gif"></td>
        <td width="505" height="33" align="right" valign="middle" background="images/shop_12.gif">
          <!-- 滚动显示 -->
        <table width="100%" height="24"  border="0" 

cellpadding="0" cellspacing="0">
          <tr>
            <td height="8"></td>
          </tr><tr>
            <td align="right" class="word_green">
			<marquee direction="left" 

scrollamount="1" scrolldelay="1" onMouseOver="this.stop();" 

onMouseOut="this.start();">
			
			</marquee></td>
          </tr>
        </table>
           <!-- 滚动显示 --></td>
        <td width="10" background="images/shop_12.gif">&nbsp;</td>
      </tr>
      <tr>
        <td width="93" height="50" background="images/shop_15.gif">&nbsp;</td>
        <td colspan="2" background="images/shop_16.gif">
		    
<!--搜索框-->
		<form name="search" method="post" 

action="searchGoods.do">
			<table width="100%" height="23"  

border="0" cellpadding="0" cellspacing="0">
			<tr>
			  <td colspan="2" height="7"></td>
			  </tr>
			<tr>
	      <td width="90%">淘宝去：
				<select name="type_s" 

class="textarea"  id="ptype_s">
			   </select>
		<input type="checkbox" name="bargain_s">特 

价<input type="checkbox" name="newGoods_s">新 品		
		<input type="text" class="txt_grey" 

size="24" name="content_s"> </td>
			  <td width="10%"><input 

type="submit" class="button white small"" value="搜索"></td>
			</tr>
			</table>
			</form>
			<!--搜索框结束-->
		</td>
      </tr>
    </table>
      <table width="100%"  border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="189" valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="80" background="images/center_searchresult.gif">&nbsp;</td>
              </tr>
            <tr valign="top">
              <td height="134" align="center">
                 <table width="90%" height="23"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_B_dashed">
                    <tr>
                      <td height="23"> [商品名为<font color="red">红色</font>：代表你想要的商品][黑色：代表推荐给你的商品]</td>
                      </tr>
                  </table>
			   
			     <c:forEach items="${requestScope.searchResult.list}" var="goods">
			     <c:set var="num" value="${num+1}"></c:set>
			      <table width="524" height="194"  border="0" cellpadding="0" cellspacing="0" class="noborder">			        
                    <tr>
                      <td width="5%" rowspan="4" align="center" valign="top">${num}</td>
                      <td width="45%" height="95" rowspan="4" align="center"><img src="images/goods/${goods.name}.jpg" width="184" height="119"></td>
                      <td width="50%" height="27" class="font2"><a href="showGoodsSale.do?name=${goods.name}">${goods.name}</a></td>
                    </tr>
                    
                    <tr>
                      <td height="27">￥${goods.nowprice}(${goods.discount}折) </td>
                    </tr>
                   
                    <tr>
                      <td height="27"><c:choose><c:when test="${goods.goodsnum<=0}"><font color="blue" size="4">抱歉，等待补货中... </font></c:when>
                      <c:otherwise><font color="red">有货快去抢哦</font></c:otherwise></c:choose></td>
                    </tr>
                    <tr>
                      <td><c:if test="${goods.goodsnum>0}"><input type="button" class="button white small" value="购买" onclick="window.location.href='./cartAdd.do?gid=${goods.gid}'"></c:if>&nbsp;&nbsp;
						 <input type="button" class="button white small" value="收藏">&nbsp;&nbsp;<input type="button" value="查看更多" onclick="showTable('${num}')" class="showTabelButton">
				      </td>
                    </tr>
                  </table>
                <table   width="338" height="102"  border="1"   class="tableHide" id="${num}">
                  <tr><td>${goods.name}市场价:￥${goods.marketprice}</td></tr>
                  <tr><td>内容简介:${goods.exp}</td></tr>
                  </table>
                     --------------------------------------------------------------------------------------------------------
                </c:forEach>
				  <hr align="center" width="92%" size="1">				  
             
                 </td>
            </tr>
            <tr>
              <td height="38" align="right" background="images/center02.gif"></td>
              </tr>
          </table></td>
          </tr>
      </table></td>
  </tr>
</table>
<table width="790"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>
     <!--版权信息-->
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
	
	<!--版权信息结束-->
    </td>
  </tr>
</table>
</td>
</tr>
</table>
</body>
</html>
