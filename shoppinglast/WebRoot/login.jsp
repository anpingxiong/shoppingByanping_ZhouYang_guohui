<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.shopping.guoguo.pojo.*"%>
    <%
String action = request.getParameter("action");
if(action != null && action.equals("login")) {
	String username = request.getParameter("username");
	session.setAttribute("username",username);
	String password = request.getParameter("password");
	User user = new User();
	user.setUsername(username);
	user.setPassword(password);
	session.setAttribute("user" , user);
	response.sendRedirect("./manage/GoodsManage.jsp");
}
%>
<html>
<head>
<title>后台管理!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/CSS/style.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/manage.js"></script>
</head>
<body>
      <table width="350" height="210"  border="0" align="center" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/images/login_M.jpg" class="tableBorder">
        <tr>
          <td height="136" align="center"><br></td>
        </tr>	  
              
        <tr>
          <td height="87" align="center" valign="top">
          <form name="form1" method="post"  onsubmit="return loginmange();" action="login.jsp">
           <input type="hidden" name="action" value="login"/>
          <table width="62%" height="87"  border="0" cellpadding="0" cellspacing="0">              
			<tr>
              <td width="95%" align="center">&nbsp;用户名：
              <input name="username" type="text" id="manager" size="20">
              </td>
              </tr>
            <tr>
              <td align="center">&nbsp;密&nbsp;&nbsp;码：
              <input name="password" type="password" id="PWD" size="20">
              </td>          
              </tr>
              <tr>
              <td><center><span id="pwdTip"></span></center> </td> 
              </tr>

            <tr>
              <td align="center"><input type="submit" class="btn_grey" value="登入" > 
              &nbsp;
                <input type="reset" class="btn_grey" value="重置">
              &nbsp;
              <input type="button" class="btn_grey" value="返回" ></td>
              </tr>           
          </table>
          </form>
          </td>
        </tr>
</table>
</body>
</html>