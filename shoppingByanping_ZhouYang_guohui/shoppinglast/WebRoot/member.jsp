<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="./include_head.jsp" %>  
<html>
<head>
<title>奋斗电子商城</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="CSS/style.css" rel="stylesheet">
<link href="CSS/global.css" rel="stylesheet">
<link href="CSS/tip-yellow.css" rel="stylesheet">
<link  href="./CSS/Button_3D.css"  rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="./CSS/message_default.css">
<style type="text/css">
<!--
	@import url(./CSS/select2css.css);
-->
</style>
 
<script type="text/javascript" src="js/select2css.js"></script>
  <script type="text/javascript" src="js/global_anping_modify.js"></script>
 <script type="text/javascript" src="js/provincesdata.js"></script>
<script type="text/javascript" src="js/jquery.provincesCity.js"></script>
<script type="text/javascript" src="js/jquery.poshytip.min.js"></script>
 <script type="text/javascript" src="./js/message.js"></script>
 
<script>
$(function(){
	$("#test").ProvinceCity();

$("#username_m").poshytip({
			className: 'tip-yellow',
			showOn: 'focus',
			alignTo: 'target',
			alignX: 'right',
			alignY: 'center',
			offsetX: 5
		});
	 $("#modify_password").poshytip({
			className: 'tip-yellow',
			showOn: 'focus',
			alignTo: 'target',
			alignX: 'right',
			alignY: 'center',
			offsetX: 5
		});
	 $('#me').poshytip({
			className: 'tip-yellow',
			showOn: 'focus',
			alignTo: 'target',
			alignX: 'right',
			alignY: 'center',
			offsetX: 5
		});
			 $('#password_m').poshytip({
			className: 'tip-yellow',
			showOn: 'focus',
			alignTo: 'target',
			alignX: 'right',
			alignY: 'center',
			offsetX: 5
		});
	 $('#address').poshytip({
			className: 'tip-yellow',
			showOn: 'focus',
			alignTo: 'target',
			alignX: 'right',
			alignY: 'center',
			offsetX: 5
		});
	 $('#telephone_m').poshytip({
			className: 'tip-yellow',
			showOn: 'focus',
			alignTo: 'target',
			alignX: 'right',
			alignY: 'center',
			offsetX: 5
		});
		});
</script>

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
                  <td width="9%"><a href="index.jsp">首页<br>
                    Index</a></td>
                  <td width="2%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="15%"><a href="NewGoods.jsp">新品上架<br>
                    NewGoods</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="14%"><a href="sale.jsp">特价商品<br>
                    At a sale</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="14%"><a href="member.jsp">会员资料修改<br>
                    Member</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="10%"><a href="cart_see.jsp">购物车<br>
                    Cart</a></td>
                  <td width="1%"><img src="images/shop_09.gif" width="3" height="57"></td>
                  <td width="15%"><a href="order.jsp">查看订单<br>
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
          <td align="center" valign="top" class="tableBorder_lb"><table width="88%"  border="0" cellspacing="0" cellpadding="0" id="showGoodSale">
         </table>
             <!-- 销售排行循环开始 -->
           <!-- 给销售排行一个id 直接调用

global_guoguo_goodsale.js -->
          <table id="showGoodSale" width="88%"  border="0" 

cellspacing="0" cellpadding="0">
          </table>
        
           <!-- 销售排行循环结束 --></td>
        </tr>
      </table>
	
	<!--左侧框架结束-->
	</td>
    <td valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="93" height="33" background="images/shop_12.gif"></td>
        <td width="505" height="33" align="right" valign="middle" background="images/shop_12.gif">
              <table width="100%" height="24"  border="0" 

cellpadding="0" cellspacing="0">
          <tr>
            <td height="8"></td>
          </tr><tr>
            <td align="right" class="word_green">
			<marquee direction="left" scrollamount="1" scrolldelay="1" onMouseOver="this.stop();" onMouseOut="this.start();">
			
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
              <td height="80" background="images/center_member.jpg">&nbsp;</td>
              </tr>
        <tr>
          <td height="189" align="center" >
	 
		  <table width="80%" border="0" cellspacing="-2" cellpadding="-2" class="tableBorder_B_dashed" >
		   <tr>              
              <td height="28" class="font2">修改密码</td>
              <td height="28" align="right"><input type="button" value="修改"  id="modifyB1"  onclick="showOkButton()"  class="button white small"> <input type="button" id="modifyB2" value="完成修改" onclick="showModifyButton()" class="button"> 
             
            
            </tr>
            <tr>              
              <td width="18%" height="30" align="center">用 户 名：</td>
              <td width="82%" class="word_grey"  ><input type="text"  class="text_m"  value="${sessionScope.user.username }"  id="username_m"  onblur="checkUserName('${sessionScope.user.username}')" title="修改不一定通过哦"><p class="text_value">${sessionScope.user.username }</p>
              <span  id="checkUsernameResult"></span>
              </td>
           
            </tr>
            <tr>
              <td height="28" align="center">E-mail：</td>
              <td height="28"  ><input type="text"  class="text_m"  value="${sessionScope.user.email }" id="me" title="注意填写哦"><p class="text_value">${sessionScope.user.email }</p>
              <span  id="checkEmailResult"></span>
              </td>
            </tr>  
            <tr>
              <td height="28" align="center">原始密码：</td>
              <td height="28"><input name="oldpwd" type="password" size="20" maxlength="20" id="password_m"  title="请输入密码验证" onblur="checkOldPassword('${sessionScope.user.password}')">
                <span class="word_orange" id="checkOldPasswordResult">*</span></td>
            </tr>
            <tr>
              <td height="28" align="center">修改密码：</td>
              <td height="28"><input name="newpwd" type="password" size="20" maxlength="20" id="modify_password"  title="你可以不修改密码哦，修改要记住！"  onblur="checkPassword()">
                <span class="word_orange"  id="showCheckPasswordResult">*</span> </td>
            </tr>              
           </table>
            
          
		   <table width="80%"  border="0" cellspacing="-2" cellpadding="-2" class="tableBorder_B_dashed" > 
            <tr>              
              <td height="28" class="font2">修改地址簿</td>
              <td height="28" align="right"  ></td>
            </tr>
            <tr>
              <td height="28" align="center">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
              <td height="28"><input name="truename" type="text" maxlength="10" value="${sessionScope.user.name }" id="truename_m" class="text_m" >
           
                <span class="word_orange"  > <span class="text_value"  >${sessionScope.user.name }</span>*</span></td>
            </tr>  
            <tr>
              <td height="28" align="center">地&nbsp;&nbsp;&nbsp;&nbsp;址：</td>
              <td class="word_grey"><input name="address" type="text"size="50" value="${sessionScope.user.address }" id="address_m"  class="text_m"><span class="word_orange">  <span class="text_value"  >${sessionScope.user.address }</span>*</span></td>
            </tr>               
            <tr>
               <td height="28" align="center">地&nbsp;&nbsp;&nbsp;&nbsp;区：</td>
              <td><span id="test"></span> <span class="word_orange">*</span> 
                   </td>
            </tr>            
            <tr>
              <td height="28" align="center">邮&nbsp;&nbsp;&nbsp;&nbsp;编：</td>
              <td class="word_grey"><input name="postcode" type="text" size="20" value="${sessionScope.user.post }" id="postcode_m" class="text_m" onblur="checkPostOrEmail('postcode_m','postResult_m')">
                       <span class="word_orange" id="postResult_m"><span class="text_value"  >${sessionScope.user.post }</span>*</span></td>
            </tr>
            <tr>
              <td height="28" align="center">联系电话：</td>
              <td><input name="telephone" type="text" value="${sessionScope.user.tel }"  id="telephone_m"  class="text_m" title="手机号码非常重要的咧" onblur="checkPostOrEmail('telephone_m','telephoneResult_m')"> <span class="word_orange" id="telephoneResult_m"><span class="text_value"  >${sessionScope.user.tel }</span>*</span></td>
            </tr>       
            <tr>
            
              <td height="28" align="center">会员：</td>
              <td></span  id="level"><c:choose><c:when test="${sessionScope.user.level ==0}">普通会员</c:when><c:otherwise>VIP 1级</c:otherwise></c:choose></span><a href="#" target="_self" onClick="MM_openBrWindow('VipInform.html','','width=300,height=250')" width="550" height="380" border="0">会员升级详情</a></td></td>
            </tr>       
          </table>
		   
		  <table width="80%" border="0" cellspacing="-2" cellpadding="-2" class="tableBorder_B_dashed" >
		   <tr>              
              <td height="28" class="font2">查看收藏夹</td>
              <td height="28" align="right"><input type="button" value="查看" onClick="window.location.href='favorite.jsp'"   class="button white small"></td>
            </tr>
          </table>
          
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

 