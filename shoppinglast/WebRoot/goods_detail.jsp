<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" import="java.util.*,com.shopping.guoguo.pojo.*"%>
<%@ include file="../include_head.jsp" %>

<% Goods good = (Goods)request.getAttribute("good"); %>
<%

 List<Goods> saleGoods = (List<Goods>)request.getAttribute("saleGoods");

%>
<html>
<head>
<title>奋斗电子商城</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="CSS/style.css" rel="stylesheet">
<link  href="./CSS/Button_3D.css"  rel="stylesheet">
<link  href="${pageContext.request.contextPath}/CSS/Button_3D.css"  rel="stylesheet">
<script type="text/javascript"  src="${pageContext.request.contextPath}/js/global_anping_comment.js"> </script>
</head>
<body>
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
              <td height="57" valign="top" background="images/shop_07.gif">
              <table width="100%" height="53"  border="0" cellpadding="0" cellspacing="0">
                <tr align="center">
                  <td width="9%"><a href="index.jsp">首页<br>
                    Index</a></td>
                  <td width="2%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="15%"><a href="NewGoods.jsp">新品上架<br>
                    NewGoods</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="14%"><a href="sale.jsp">特价商品<br>
                    At a sale</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="14%"><a href="javascript:checkUserLoginInterface('member.jsp')">会员资料修改<br>
                    Member</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="10%"><a href="cartShow.do">购物车<br>
                    Cart</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="15%"><a href="javascript:checkUserLoginInterface('showUserOrder.do')">查看订单<br>
                    Order</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="11%"><a href="SellSort.jsp">销售排行<br>
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
         <form name="login" method="post" action="">
		  <table width="100%"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td width="10%">&nbsp;</td>
              <td width="90%" valign="top" background="Images/index_09.gif">
			
			  <table width="100%"  border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="94%" height="24">会员名
                    <input name="username" type="text" class="txt_grey" id="username" size="16"></td>
                  <td width="6%">&nbsp;</td>
                </tr>
                <tr>
                  <td height="24">密&nbsp;&nbsp;码
                    <input name="pwd" type="password" class="txt_grey" id="PWD" size="16" onKeydown="if(event.keyCode==13) form1.submit();"></td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td height="31">
                    <input type="button" class="btn_grey" value="注册" onClick="window.location.href='register.html'">
                    &nbsp;
                    <input type="button" class="btn_grey" value="登录">                    
                    <input type="reset" class="btn_grey" value="重置">
                  </td>
                  <td>&nbsp;</td>
                </tr>
              </table>
			<!-- 登录后的效果
                <table width="100%"  border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="94%" height="31" align="center" class="word_white">[Mary]您好!<br>
                      您现在可以购物了!</td>
                    <td width="6%">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="24" align="center"><input type="button" class="btn_grey" value="修改资料" onClick="window.location.href='member.html';"></td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="24" align="center">
                     <input type="button" class="btn_grey" value="退出登录" onClick="window.location.href='';"></td>
                    <td>&nbsp;</td>
                  </tr>
                </table>
		   -->
				</td>
            </tr>
          </table>
		  </form></td>
      </tr>
    </table>
      <table width="100%" height="155"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><img src="images/shop_22.gif" width="182" height="58"></td>
        </tr>
        <tr>
          <td height="97" align="center" valign="top" class="tableBorder_l"><table width="88%"  border="0" cellspacing="0" cellpadding="0">
           
			<tr>
              <td height="24" class="tableBorder_T_dashed"><a href="placard_detail.html">圣诞购物有奖活动！</a></td>
            </tr>
			<tr>
              <td height="24" class="tableBorder_T_dashed"><a href="#">机会不容错过，快快行动吧！</a></td>
            </tr>
			<tr>
              <td height="24" class="tableBorder_T_dashed"><a href="#">人生感悟</a></td>
            </tr>
			<tr>
              <td height="24" class="tableBorder_T_dashed"><a href="#">全场六折</a></td>
            </tr>
          </table></td>
        </tr>
      </table>
      <table width="100%" height="151"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="40" background="images/shop_33.gif">&nbsp;</td>
        </tr>
        <tr>
          <td align="center" valign="top" class="tableBorder_lb">
          
          
 <!-- 销售排行循环开始 -->
          <c:forEach items="${saleGoods}" var="sGood" begin="0" end="7">
          <table width="88%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="20" class="tableBorder_B_dashed"><a href="./showGdetail.do?gid=${sGood.gid}">${sGood.name}</a></td>
            </tr>
          </table>
          </c:forEach>
           <!-- 销售排行循环结束 -->
        </tr>
      </table>
	
	<!--左侧框架结束-->
	</td>
    <td valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="33" background="images/shop_12.gif"></td>
        <td width="505" height="33" align="right" valign="middle" background="images/shop_12.gif"><table width="100%" height="24"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="8"></td>
          </tr>
          <tr>
            <td align="right" class="word_green">
            <marquee direction="left" scrollamount="1" scrolldelay="1" onMouseOver="this.stop();" onMouseOut="this.start();">
			购买商品请先登录 <a href="register.html" class="word_green">[新用户注册]</a><!-- Mary欢迎您!(如果您不是Mary，<a href="" style="color: #FF0000;">请点击这里退出登录</a>) -->
			</marquee></td>
          </tr>
        </table></td>
        <td width="10" background="images/shop_12.gif">&nbsp;</td>
      </tr>
      <tr>
        <td width="93" height="50" background="images/shop_15.gif">&nbsp;</td>
        <td colspan="2" background="images/shop_16.gif">
		   <!--搜索框-->
			<form name="search" method="post" action="search_deal.html">
			<table width="100%" height="23"  border="0" cellpadding="0" cellspacing="0">
			<tr>
			  <td colspan="2" height="7"></td>
			  </tr>
			<tr>
			  <td width="85%">请输入查询条件：
				<select name="type" class="textarea">
				  <option value="0" selected>全部分类</option>
				  <option value="1" >食品烟酒</option>
				  <option value="2" >健康美容</option>
				  <option value="3" >家居日用</option>
				  <option value="4" >家电通讯</option>
				  <option value="5" >服装鞋帽</option>
				  <option value="6" >IT数码</option>
				</select>
				<input name="key" type="text" class="txt_grey" size="33">                  </td>
			  <td width="15%"><input type="submit" class="btn_grey" value="搜索"></td>
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
              <td height="80" background="images/center01.gif">&nbsp;</td>
              </tr>
            <tr valign="top">
              <td height="134" align="center">
              <c:set value="${good}" var="detailGood"></c:set>
                  <table width="96%" height="79"  border="0" cellpadding="0" cellspacing="0" class="noborder">
                    <tr>
                      <td colspan="2" class="font">${detailGood.name } </td>
                    </tr>
                    <tr>
                      <td width="37%" height="95" rowspan="4" align="center"><img src="images/goods/${detailGood.name}.jpg" width="150" height="100"></td>
                      <td width="63%" style="text-decoration:line-through;">市场价：￥${detailGood.marketprice } </td>
                    </tr>
                    <tr>
                      <td style="color:#FF0000">商城价：￥${detailGood.nowprice } (折扣：<fmt:formatNumber pattern="#.#" value="${detailGood.discount}" ></fmt:formatNumber> ) </td>
                    </tr>
                    <tr>
                      <td>
						 <input type="button" class="button white small" value="购买" onclick="window.location.href='./cartAdd.do?gid=${detailGood.gid}'">&nbsp;&nbsp;
						 <input type="button" class="button white small" value="收藏">
					  </td>
                    </tr>
                    <tr>
                      <td>
						<c:if test="${detailGood.goodsnum<=0}">暂时缺货，请选购其他商品</c:if>
						<c:if test="${detailGood.goodsnum>0}">现在有货</c:if>
					  </td>
                    </tr>
                    </table>
                    <table width="96%" border="0" cellpadding="0" cellspacing="0" class="noborder">
                    <tr>
                       <td colspan="2"><hr align="center" size="1"></td>
                    </tr>
                    <tr>
                      <td colspan="2" class="font1">商品简介</td>                      
                    </tr>
                    <tr>
                      <td colspan="2">&nbsp;&nbsp;${detailGood.exp} </td>
                    </tr>
                    <tr>
                      <td colspan="2"><hr align="center" size="1"></td>
                    </tr>
                    <tr>
                      <td class="font1" width="20%">用户评论 </td>
                      <td>
                        (暂无评论)<input type="button" class="button white small" value="我要评论">
					  </td>
					  
					   
					   
                    </tr>
                  </table>
                 </td>
            </tr>
            <tr>
              <td height="38" align="right" background="images/center02.gif"></td>
              </tr>
          
          </table></td>
          </tr><table><tr><textarea id="textarea_c"  cols="35" rows="3"> </textarea></tr><input type="button"   class="button white small"  value="评论" onclick="submitComment()"></table>
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

 