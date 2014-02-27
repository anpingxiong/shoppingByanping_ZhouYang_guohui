<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.shopping.guoguo.pojo.*"%>
<%@ include file="./include_head.jsp" %>  
  <c:if test="${not empty sessionScope.user}" >
  <c:set var="username" value="${sessionScope.user.username}"></c:set>
  <c:set  var  ="state"  value="${sessionScope.user.state}"> </c:set>
  </c:if>
 
<html>
<head>
<title>奋斗电子商城</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="CSS/style.css" rel="stylesheet">
<link href="CSS/global.css" rel="stylesheet">
<link  href="./CSS/Button_3D.css"  rel="stylesheet">
<link rel="stylesheet" type="text/css" href="./CSS/message_default.css">
	
<script language='JavaScript' src='js/jquery.js'></script>
 <script language='JavaScript' src='js/jquery-1.4.min.js'></script>
<script language='JavaScript' src='js/menutree.js'></script>
 <script type="text/javascript" src="./js/message.js"></script>	
<script type="text/javascript" src="js/global_anping_login.js"></script>
<script type="text/javascript" src="js/global_anping_showPlacard.js"></script>
	
</head>
<body onload="isShowLoginTable('${username}','${state}')">
       
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
                  <td width="9%"><a href="index.jsp">首页<br>
                    Index</a></td>
                  <td width="2%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="15%"><a href="NewGoods.jsp">新品上架<br>
                    NewGoods</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="14%"><a href="sale.jsp">特价商品<br>
                    At a sale</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="14%"><a   href="javascript:checkUserLogInInterface('./member.jsp');"  >会员资料修改<br>
                    Member</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="10%"><a href="cart_see.jsp">购物车<br>
                    Cart</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="15%"><a    href="javascript:checkUserLogInInterface('./order.jsp');" >查看订单<br>
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
      <!-- ----------登录表单------------- -->
     
        <td height="98" align="center" background="images/shop_17.gif">		 
         <table width="100%"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td width="10%">&nbsp;</td>
              <td width="90%" valign="top" background="Images/index_09.gif">
			<div class="loginTable" ></div>

			</td>
            </tr>
          </table>
		  </td>
      </tr>
    </table>
      <table width="100%" height="155"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><img src="images/shop_22.gif" width="182" height="58"></td>
        </tr>
        <tr>
          <td height="97" align="center" valign="top" class="tableBorder_l"><table  id="showNotice" width="88%"  border="0" cellspacing="0" cellpadding="0">
           
          </table></td>
        </tr>
      </table>
      <table width="100%" height="151"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="40" background="images/shop_33.gif">&nbsp;</td>
        </tr>
        <tr>
          <td align="center" valign="top" class="tableBorder_lb"><table id="showGoodSale"   width="88%"  border="0" cellspacing="0" cellpadding="0">
            
         

          </table>
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
        <table width="100%" height="24"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="8"></td>
          </tr>
          <tr>
            <td align="right" class="word_green">
			<marquee direction="left" scrollamount="1" scrolldelay="1" onMouseOver="this.stop();" onMouseOut="this.start();">
		    BOD电子商城,信誉度高，商品齐全，种类繁多！后台开发团队强大，安全无顾虑!
		 </marquee></td>
          </tr>
        </table></td>
        <td width="10" background="images/shop_12.gif">&nbsp;</td>
      </tr>
      <tr>
        <td width="93" height="50" background="images/shop_15.gif">&nbsp;</td>
        <td colspan="2" background="images/shop_16.gif" valign="top">
			<!--搜索框-->
			<form name="search" method="post" action="searchGoods.do">
			<table width="100%" height="23"  border="0" cellpadding="0" cellspacing="0">
			<tr>
			  <td colspan="2" height="7"></td>
			  </tr>
			<tr>
	 <td width="90%">查询商品：
				<select name="type" class="textarea"  id="ptype">
			   </select>
		<input type="checkbox" name="bargain_s">特 价<input type="checkbox" name="newGoods_s">新 品		
				<input name="key" type="text" class="txt_grey" size="27"> </td>
			  <td width="10%"><input type="submit" class="button white medium"" value="搜索"  ></td>
			</tr>
			</table>
			</form>
			<!--搜索框结束-->
		</td>
      </tr>
    </table>
      <table width="100%"  border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="69%" height="189" valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="98%" height="80" background="images/shop_18.gif">&nbsp;</td>
              <td width="2%"><img src="images/shop_19.gif" width="10" height="80"></td>
            </tr>
            <tr align="center" valign="top">
              <td height="134" colspan="2"><table width="100%" height="162"  border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="49%" height="162" valign="top">
				  <table width="100%"  border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td height="95" align="center"><img src="images/goods/fdg0003.jpg" width="150" height="88"></td>
                    </tr>
                    <tr>
                      <td height="22" align="center" class="font2"><a href="#">小天使电视</a></td>
                    </tr>
                    <tr>
                      <td height="20" align="center" style="text-decoration:line-through;">市场价：￥3980.0 </td>
                    </tr>
                    <tr>
                      <td height="20" align="center" style="color:#FF0000">商城价：￥2680.0</td>
                    </tr>
                    <tr>
                      <td height="22" align="center">
                      <input type="button" class="button white medium"" value="购买">
                      &nbsp;<input type="button" class="button white medium"" value="收藏">
                      </td>
                    </tr>
                  </table>
				  </td>
                  <td width="2%" align="center" valign="top"><table width="3" height="160"  border="0" cellpadding="0" cellspacing="0" background="images/point.gif">
                    <tr>
                      <td></td>
                    </tr>
                  </table></td>
                  <td width="49%" valign="top">
				    <table width="100%"  border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td height="95" align="center"><img src="images/goods/fdg0016.jpg" width="150" height="88"></td>
                      </tr>
                      <tr>
                        <td height="22" align="center" class="font2"><a href="#">可达电视</a></td>
                      </tr>
                      <tr>
                        <td height="20" align="center" style="text-decoration:line-through;">市场价：￥2560.0 </td>
                      </tr>
                      <tr>
                        <td height="20" align="center" style="color:#FF0000">商城价：￥1389.0</td>
                      </tr>
                      <tr>
                        <td height="22" align="center">
                           <input type="button" class="btn_grey" value="购买" onClick="window.location.href='cartAdd.do?gid=2'">
                           &nbsp;<input type="button" class="btn_grey" value="收藏">
                        </td>
                      </tr>
                    </table>
				    </td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="42" align="right" background="images/shop_24.gif"><a href="sale.html"><img src="images/MORE.GIF" width="50" height="20" border="0"></a>
                <br><br>
              </td>
              <td height="42" background="images/shop_25.gif">&nbsp;</td>
            </tr>
          </table>
            <table width="100%" height="76"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="361" background="images/shop_28.gif">&nbsp;</td>
                <td width="46" height="35" background="images/shop_29.gif">&nbsp;</td>
              </tr>
              <tr>
                <td colspan="2">
				
				<table width="100%" height="79"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_B_dashed">
                  <tr>
                    <td width="33%" height="95" rowspan="2" align="center"><img src="images/goods/fdg0012.jpg" width="99" height="61"></td>
                    <td width="67%" class="font2"><a href="goods_detail.html">新新人类电视</a></td>
                  </tr>                  
                  <tr>
                    <td>￥2900.0(69折) <input type="button" class="button white medium"" onClick="window.location.href='cart_add.html'" value="购买">
                      &nbsp;<input type="button" class="button white medium"" value="收藏">
					</td>
                  </tr>
                </table>
                
                <table width="100%" height="79"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_B_dashed">
                  <tr>
                    <td width="33%" height="95" rowspan="2" align="center"><img src="images/goods/fdg0010.jpg" width="99" height="61"></td>
                    <td width="67%" class="font2"><a href="#">小圣歌冰箱</a></td>
                    </tr>
                  <tr>
                    <td>￥1860.0(34折) <input type="button" class="btn_grey" value="购买">
                      &nbsp;<input type="button" class="btn_grey" value="收藏">
					</td>
                  </tr>
                </table>
                
                <table width="100%" height="79"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_B_dashed">
                  <tr>
                    <td width="33%" height="95" rowspan="2" align="center"><img src="images/goods/fdg0002.jpg" width="99" height="61"></td>
                    <td width="67%"  class="font2"><a href="#">三维电视</a></td>
                    </tr>
                  <tr>
                    <td>￥2950.0(78折) <input type="button" class="btn_grey" value="购买">
                           &nbsp;<input type="button" class="btn_grey" value="收藏">  
                    </td>
                  </tr>
                </table>
                
                <table width="100%" height="79"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_B_dashed">
                  <tr>
                    <td width="33%" height="95" rowspan="2" align="center"><img src="images/goods/fdg0001.jpg" width="99" height="61"></td>
                    <td width="67%" class="font2"><a href="#">同创电视</a></td>
                    </tr>
                  <tr>
                    <td>￥2950.0(55折) <input type="button" class="btn_grey" value="购买">
                      &nbsp;<input type="button" class="btn_grey" value="收藏">
					</td>
                  </tr>
                </table>
                
				<table width="100%" height="30"  border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="98%" align="right"><a href="NewGoods.html"><img src="images/MORE.GIF" width="50" height="20" border="0"></a></td>
                    <td width="2%">&nbsp;</td>
                  </tr>
                </table>
                </td>
              </tr>
            </table></td>
          <td width="31%" valign="top">
		  
		 <!--右侧框架-->
		  <table width="100%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><img src="images/shop_20.gif" width="201" height="80"></td>
            </tr>
            <tr>
              <td height="90" valign="top"><table width="100%" height="40"  border="0" cellpadding="0" cellspacing="0">
                <!--DWLayoutTable-->
            <tr>
			  <td width="29" height="90" valign="top"><!--DWLayoutEmptyCell-->&nbsp;</td>
              <td width="172" valign="top">
			
			    <script language='JavaScript'>
			
			addtree('<B>食品烟酒</B>');
			addtree('-素食区','type.html','_self');
			addtree('-熟食区','');
			addtree('-香烟区','');
			addtree('-酒水区','');
			
			addtree('<B>健康美容</B>');
			addtree('-护肤区','');
			addtree('-彩妆区','');
			addtree('-美发区','');
			addtree('-香水区','');
			addtree('-瘦身区','');
			
			addtree('<B>家居日用</B>');
			addtree('-洗涤用品','');
			
			addtree('<B>家电通讯</B>');
			addtree('-电视区','');
			addtree('-冰箱区','');
			addtree('-电话区','');
			addtree('-手机区','');
			
			addtree('<B>服装鞋帽</B>');
			addtree('-女装区','');
			addtree('-男装区','');
			addtree('-童装区','');
			addtree('-鞋帽区','');
			
			addtree('<B>IT数码</B>');
			addtree('-数码相机区','');
			addtree('-摄影器材','');
			addtree('-摄像器材','');
			addtree('-MP3/MP4','');
			addtree('-U盘/移动硬盘','');
			createtree();
			    </script>			  </td>
            </table></td>
            </tr>
            <tr>
              <td height="30" valign="bottom"><img src="images/shop_31.gif" width="201" height="30"></td>
            </tr>
          </table>
            <table width="100%" height="119"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td height="70" align="center"><img src="images/ggzs1.gif" width="150" height="60"></td>
              </tr>
              <tr>
                <td height="70" align="center"><img src="images/ggzs1.gif" width="150" height="60"></td>
              </tr>
              <tr>
                <td height="70" align="center"><img src="images/ggzs1.gif" width="150" height="60"></td>
              </tr>
            </table>
		 <!--右侧框架结束-->
		  </td>
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
        <td height="13" colspan="3" align="center">B.O.D商城客户服务热线：0791-3881060传真：0791-3881063</td>
        <td width="141">&nbsp;</td>
      </tr>
      <tr>
        <td height="15" colspan="2">&nbsp;</td>
        <td width="464" valign="bottom" align="center"> CopyRight &copy; 2009 www.fendoujiaoyu.com B.O.D工作室</td>
        <td colspan="2">&nbsp;</td>
      </tr>
	  <tr>
        <td colspan="2">&nbsp;</td>
        <td ><img src="images/bod1.gif" width="85" height="32">
             <img src="images/bod2.gif" width="85" height="32">
        <img src="images/bod1.gif" width="85" height="32">
             <img src="images/bod2.gif" width="85" height="32">
        <img src="images/bod1.gif" width="85" height="32">
             
             </td>
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


 