<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <link href="CSS/style.css" rel="stylesheet">
<link  href="./CSS/Button_3D.css"  rel="stylesheet">
<link  href="./CSS/message_default.css"  rel="stylesheet">
<link href ="./CSS/global.css" rel="stylesheet">
<link href ="./CSS/data_input.css" rel="stylesheet">

<script type="text/javascript" src="js/jquery.js"></script>
 <script type="text/javascript" src="js/jquery-1.4.min.js"></script>
 <script type="text/javascript" src="js/global_anping_login.js"></script>
<script type="text/javascript" src="js/global_anping_showPlacard.js"></script> 
<script type="text/javascript" src="js/global_guoguo_getPtype.js"></script> 
<script type="text/javascript" src="js/global_guoguo_goodsale.js"></script>
<script type="text/javascript" src="./js/global_zhouyang.js"></script>
<script type="text/javascript" src="js/message.js"></script>

<script type="text/javascript" src="js/global_anping_addFavorite.js"></script>
 <c:if test="${not empty sessionScope.user}" >
  <c:set var="username" value="${sessionScope.user.username}"></c:set>
  <c:set var="state"  value="${sessionScope.user.state}"> </c:set>
</c:if>