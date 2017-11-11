<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="factory" scope="application" class="com.controller.Factory" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link href="css/2.css" rel="stylesheet" type="text/css" />

<title>注册</title>
</head>
<div id="signup">
<h1>注册管理</h1>   
    <form action="Register" method="post">
        <p><input type="text" name="username" id="user" placeholder="用户名"></p>
   
        <p><input type="password" name="password" class="pwd" placeholder="密码"></p>
        <p><input type="password" name="passw0rd" class="pwd" placeholder="确认密码"></p>
         <p><img src="img/register/sex1.png" /><input type="radio" name="sex" value="M">男 &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
           <img src="img/register/sex2.png" /><input type="radio" name="sex" value="F">女</p><br />
        <p><input type="submit" id="submit" value="注册" > &nbsp; &nbsp;&nbsp; &nbsp;<input type="reset" id="reset" value="重置"> </p>
    </form>
</div>
<body>
</body>
</html>