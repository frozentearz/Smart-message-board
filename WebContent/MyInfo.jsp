<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.models.*"  %>
<jsp:useBean id="factory" scope="application" class="com.controller.Factory" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
	session = request.getSession();
	User u= (User) session.getAttribute("user");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bulma.css" />
<title>我的信息</title>
</head>
<body bgcolor="	#BFEFFF">
<!-- 顶层 -->
<div style="wdith: 500px; margin: auto 200px;" >
<nav class="level">
  <!-- Left side -->
  <div class="level-left" style="margin-left: 90px">
    <div class="level-item">
  <figure class='image is-128x128'>
  <img src="img\Logo\Logo.PNG" alt="Logo" width="325px" height="260px" />
  </figure>
    </div>
  </div>

  <!-- Right side -->
  <div class="level-right" style="margin-right: 150px;">
    <p class="level-item"><a class="button is-success" href="index.jsp">首页</a></p>
  </div>
</nav>
</div>
 <!-- 信息层 -->
 <div style="margin:auto 300px; width: 600px; height: 700px;">
 <div style="float: left; width: 200px; height: 200px;">
<div class="card" style=" width: 200px; height: 200px;">
  <div class="card-image" style="width: 200px; height: 200px;" >
      <img src="<%=u.getHead() %>" alt="img" style="width: 200px; height: 200px;" >
  </div>
  <div class="card-content" style="width:200px; heoght: 500px">
    <div class="media" style="width: 130px; height: 50px;">
      <div class="media-content" style="width: 50px; height: 50px;" >
        <p class="title is-5" align="center" ><%=u.getName() %></p>
      </div>
    </div>
  </div>
</div>
</div>
<div style=" width: 400px; height: 400px; float: right; ">
    <div class="content" >
    <%  String re="0";
        String re_s=request.getParameter("re");
   		if("1".equals(re_s)){
   			re="1";
   		}else{
   			re="0";
   		}
    	if(re=="0"){
    %>
	<table>
		<tr><td>用户名</td><td><%=u.getName() %></td></tr>
		<tr><td>性别</td>
		   <td>
			<% if(u.getSex().equals("M")){
				out.print("<img src='img/register/sex1.png' width='30px' height='30px' />");
			}else{
				out.print("<img src='img/register/sex2.png' width='30px' height='30px' />");
			} %>
		   </td>
		</tr>
		<tr><td col=2 align="right"><a href="MyInfo.jsp?re=1" class="button is-success is-inverted"  >点击修改</a></td></tr>
	</table>
	<%}else{ %>
		<form action="Update" name="update" method="post">
		<table>
		<tr><td>用户名</td><td><input type="text" name="updatename" id="user" value="<%=u.getName() %>" /></td></tr>
		<tr>
		   <td>性别</td>
		   <td>
		      <img src="img/register/sex1.png" width="30px" height="30px" />
		      <input type="radio" name="updatesex" value="M">男 &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
              <img src="img/register/sex2.png" width="30px" height="30px" />
              <input type="radio" name="updatesex" value="F">女
            </td>
        </tr>
		<tr>
		   <td>
		      <input class="button is-success is-inverted" type="submit" value="确定" />
		   </td>
		   	<td>
		      <a href="MyInfo.jsp?re=0" class="button is-success is-inverted" >取消</a> 
		   </td>
		 </tr>
	</table>
	</form> 
	<%} %>
    </div>
  </div>
</div>
<div style="clear:both"></div>
 <hr>
<!-- 版权层 -->
<div class="CopyRight" id="CopyRight">
<p align="center">版权声明:此网站仅用于学习使用</p>
<p align="center">联系我们：<a>frozen_tearz@163.com</a></p>
</div>
</body>
</html>