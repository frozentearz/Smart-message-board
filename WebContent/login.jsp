<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="404.jsp" %>
<jsp:useBean id="factory" scope="application" class="com.controller.Factory" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>登录管理</title>
<link href="css/1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/bulma.css" />
<script type="text/javascript" language="javascript">
    function validateForm() {
    var x = document.myform.username.value;
     var y = document.myform.password.value;
    if (x == null || x == "") {
        alert("需要输入名字。");
        return false;
    }
    if (y == null || y == "") {
        alert("需要输入密码。");
        return false;
    }
}
</script>
</head>
<body>
<div style="float: left"  ><a class="button is-primary" href="index.jsp">首页</a></div>
<div style="float: right" ><a class="button is-primary" href="signup.jsp">注册</a></div>
<div style="clear: both"></div>
<div id="login">
<h1 >登录管理</h1>   
    <form  name="myform" action="Login" method="post" onsubmit="return validateForm()" >
        <p><input type="text" name="username" id="user" placeholder="用户名" value=""></p>
        <p><input type="password" name="password" id="pwd" placeholder="密码" value=""></p>
        <p><input type="submit" id="submit" value="登录" ></p>
    </form>
</div>
<!-- 版权层 -->
<div class="CopyRight" id="CopyRight">
	<p align="center">版权声明:此网站仅用于学习使用</p>
	<p align="center">联系我们：<a>frozen_tearz@163.com</a></p>
</div>
</body>
</html>