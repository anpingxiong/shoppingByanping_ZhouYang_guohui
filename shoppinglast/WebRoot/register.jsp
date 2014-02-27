<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include_head.jsp"%>

 
 <html>
<head>
<title>奋斗电子商城</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="CSS/style.css" rel="stylesheet">
<link href="CSS/global.css" rel="stylesheet">
<link href="CSS/tip-yellow.css" rel="stylesheet">
<link  href="./CSS/Button_3D.css"  rel="stylesheet">

 
 <link rel="stylesheet" type="text/css" href="./CSS/message_default.css">
	
 
<script language='JavaScript' src='js/jquery.js'></script>

<script language='JavaScript' src='js/jquery-1.4.min.js'></script>
<script language='JavaScript' src='js/menutree.js'></script>
 
<script type="text/javascript" src="js/global_anping_register.js"></script>


<script type="text/javascript" src="js/provincesdata.js"></script>
<script type="text/javascript" src="js/jquery.provincesCity.js"></script>
 
<script type="text/javascript" src="js/jquery.poshytip.min.js"></script>
	 <script type="text/javascript" src="./js/message.js"></script>	

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
                  <td width="14%"><a href="javascript:checkUserLogInInterface('./member.jsp');">会员资料修改<br>
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
        <td height="83" align="center"><img src="images/shop_10.gif" width="182" height="83"></td>
      </tr>
      <tr>
        <td height="98" align="center" background="images/shop_17.gif">		 
         <form name="login" method="post" action="">
		  <table width="100%"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td width="10%">&nbsp;</td>
              <td width="90%" valign="top" background="Images/index_09.gif">
			
			 <div class="loginTable" ></div>
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
          <td height="97" align="center" valign="top" class="tableBorder_l"><table  id="showNotice" width="88%"  border="0" cellspacing="0" cellpadding="0">
           
          </table></td>
        </tr>
      </table>
      <table width="100%" height="151"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="40" background="images/shop_33.gif">&nbsp;</td>
        </tr>
        <tr>
          <td align="center" valign="top" class="tableBorder_lb"><table width="88%"  border="0" cellspacing="0" cellpadding="0" id="showGoodSale">
       
		

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
        <td width="93" height="33" background="images/shop_12.gif"></td>
        <td width="505" height="33" align="right" valign="middle" background="images/shop_12.gif"><table width="100%" height="24"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="8"></td>
          </tr>
          <tr>
            <td align="right" class="word_green"><marquee direction="left" scrollamount="1" scrolldelay="1" onMouseOver="this.stop();" onMouseOut="this.start();">
		    BOD电子商城,信誉度高，商品齐全，种类繁多！后台开发团队强大，安全无顾虑!
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
			  <td width="15%"><input type="submit" class="button white medium" value="搜索"></td>
			</tr>
			</table>
			</form>
			<!--搜索框结束-->
		</td>
      </tr>
    </table>
      <table width="100%"  border="0" cellspacing="0" cellpadding="0">
        <tr>
              <td height="80" background="images/center_register.jpg">&nbsp;</td>
              </tr>
        <tr>
          <td height="189" align="center" >
		  <form action="register.do" method="post" name="myform" onsubmit="return checkAll();">
		  <table  border="0" cellspacing="-2" cellpadding="-2"  >
            <tr>              
              <td width="18%" height="30" align="center">用 户 名：</td>
              <td width="82%" class="word_grey"><input name="username" type="text" maxlength="20" id="username_2" onblur="showImage()"  title="输入用户名">
                 <span class="word_orange" id="showCheckUsernameresult">*</span>  <span id="wait"><img src="images/loading.gif" height="20" width="35"></span></td>
            </tr>
            <tr>
              <td height="28" align="center">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
              <td height="28"><input name="pwd" type="password" size="20" maxlength="20" id="password1" onblur="checkPassword()" title="注意需6字符以上,需要包含字母和数字">
                <span class="word_orange" id="showCheckPasswordResult"  >* </span></td>
            </tr>
            <tr>
              <td height="28" align="center">确认密码:</td>
              <td height="28"><input name="pwd1" type="password" size="20" maxlength="20" id="password2" onblur="checkTwoPassword()">
                <span class="word_orange" id="showCheckPasswordEquel">*</span> </td>
            </tr>
            <tr>
              <td height="28" align="center">E-mail：</td>
              <td height="28"><input  name="email"  id="me"  type="text"      title="email是含@的哦"> 
                <span class="word_orange" id="showCheckEmailResult">*</span></td>
            </tr>
            <tr>
              <td height="28" align="center">验 证 码：</td>
              <td height="28"><input name="validate"  type="text"  size="20"  id="validate"  onblur="checkValidate()">
                <span class="word_orange" id="checkVaildateResult">*</span><span id="image"><img src="CheckNum.do"></span><a  onclick="changImage()"> [看不清]</a></td>
            </tr>
            <tr>
              <td height="28" colspan="2"><hr align="center" size="1"></td>
            </tr>
            
            <tr>
              <td height="28" align="center">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
              <td height="28"><input name="truename" type="text" maxlength="10" id="truename">
                <span class="word_orange">*</span></td>
            </tr>  
            <tr>
              <td height="28" align="center">地&nbsp;&nbsp;&nbsp;&nbsp;址：</td>
              <td class="word_grey"><input name="address" type="text"size="45" id="address"  title="地址是你所在地哦">  <span class="word_orange">*</span></td>
            </tr>               
            <tr>
              <td height="28" align="center">地&nbsp;&nbsp;&nbsp;&nbsp;区：</td>
              <td><div id="uboxstyle"> <span id="test"></span><span class="word_orange">*</span></div>
                    </td>
            </tr>            
            <tr>
              <td height="28" align="center">邮&nbsp;&nbsp;&nbsp;&nbsp;编：</td>
              <td class="word_grey"><input name="postcode" type="text" size="20" id="postcode" onblur="checkPostOrEmail('postcode','postResult')">
                       <span class="word_orange" id="postResult">*</span></td>
            </tr>
            <tr>
              <td height="28" align="center">联系电话：</td>
              <td><input name="telephone" type="text" id="telephone" title="非常重要哦,请留心填写" onblur="checkPostOrEmail('telephone','checkTelephoneResult')"> <span class="word_orange" id="checkTelephoneResult">*</span></td>
            </tr> 
        
            <tr>
              <td height="34">&nbsp;</td>
              <td class="word_grey"><input  type="submit" class="button white medium"  value="确定保存"  >
                  <input type="reset"  class="button white medium" value="重新填写">
                  <input type="button" class="button white medium" value="返回" onClick="window.location.href='index.jsp'">
              </td>
            </tr>
          </table>
		  </form>
		  </td>
          </tr>
          <tr>
              <td height="38" align="right" background="images/center02.gif"></td>
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

 