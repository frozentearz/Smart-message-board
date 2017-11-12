<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="factory" scope="application" class="com.controller.Factory" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link  href="css/3.css" rel="stylesheet" type="text/css">
<title>操作失败</title>
</head>
<!-- 代码开始 -->
<div id="container">
  <p>操作失败</p>
  <p>将在<span id="time">10</span>秒后自动转入<a href="index.jsp" class="btn">网站首页</a> </p>
</div>
<div id="cloud"><img src="img/successed/007.jpg" width="220" height="180"></div>
<!-- 代码 结束 --> 
<script type="text/javascript">
function Load(){
for(var i=10;i>=0;i--){
window.setTimeout('doUpdate('+i+')',(10-i)*1000);
}
}
function doUpdate(num){
document.getElementById("time").innerHTML=num;
if(num==0){window.location="index.jsp";}
}
Load();
</script>
<body>
</body>
</html>