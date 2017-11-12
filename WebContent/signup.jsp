<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="factory" scope="application" class="com.controller.Factory" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link href="css/2.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/bulma.css" />
<title>注册</title>
<script type="text/javascript" language="javascript">
    function validateForm() {
    var x = document.register.username.value;
     var y = document.register.password.value;
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
<div style="float: left" ><a class="button is-primary" href="index.jsp">首页</a></div>
<div style="float: right" ><a class="button is-primary" href="login.jsp">登录</a></div>
<div style="clear: both"></div>
<div id="signup">
<h1>注册管理</h1>   
    <form name="register" action="Register" method="post" onSubmit="return validateForm()">
        <p><input type="text" name="username" id="user" placeholder="用户名"></p>
   
        <p><input type="password" name="password" class="pwd" placeholder="密码"></p>
        <p><input type="password" name="repassword" class="pwd" placeholder="确认密码"></p>
         <p><img src="img/register/sex1.png" width="30px" height="30px" /><input type="radio" name="sex" value="M">男 &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
           <img src="img/register/sex2.png" width="30px" height="30px" /><input type="radio" name="sex" value="F">女</p><br />
        <p><input type="submit" id="submit" value="注册" > &nbsp; &nbsp;&nbsp; &nbsp;<input type="reset" id="reset" value="重置"> </p>
    </form>
</div>
<body>
</body>
</html>