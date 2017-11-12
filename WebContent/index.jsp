<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.models.*,java.util.List,com.controller.Factory" %>
<jsp:useBean id="factory" scope="application" class="com.controller.Factory" />
<% 
	session = request.getSession();
	User u= (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="css/bulma.css" />
<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
<title>留言板</title>
<style>
.dropdown {
  position: relative;
  display: inline-block;
}
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  padding: 12px 16px;
}
.dropdown:hover .dropdown-content {
  display: block;
}
</style>

</head>
<body>

<div class="container" style="margin:35px auto auto auto;">
<!-- Main container -->
<nav class="level" >
  <!-- Left side -->
  <div class="level-left" >
  <figure class='image is-96x96'>
  <img src="https://avatars0.githubusercontent.com/u/18512486?s=460&v=4" alt="logo" />
  </figure>
  </div>
  <div style="-webkit-box-align: center;" >
  <div class="level-left" >
    <div class="level-item">
      <p class="subtitle is-5">
        <strong>Smart</strong> 留言板
      </p>
    </div>
    <div class="level-item">
      <div class="field has-addons">
        <p class="control">
          <input class="input" type="text" placeholder="搜索用户或话题">
        </p>
        <p class="control">
          <button class="button is-success">
            Search
          </button>
        </p>
      </div>
    </div>
  </div>
</div>
  <!-- Right side -->
  <div class="level-right">
        <% if(u==null){
    		out.print("<p class='level-item'><a class='button is-small' href='login.jsp' style='background-color: #09C;''>登录</a></p>");
   		}else{
   			out.print("<div class='dropdown'><figure class='image is-48x48'> <img src='"+u.getHead()+"alt='Image' id='img'> </figure><div class='dropdown-content'><p><a href='#'>用户信息</a></p><p><a href='#'>修改资料</a></p><p><a href='#'>查看留言</a></p></div></div>");
   			out.print("<p class='level-item'><a  href='#'>"+u.getName()+"</a></p>");
        }
        %>
    <p class="level-item"><form name="LogOut" action="LogOut" method="post" ><input class="button is-small" style="background-color: #09C;" type="submit" value="注销"></form></p>
    <p class="level-item"><a  class="button is-small" href="signup.jsp" style="background-color: #09C;" >注册</a></p>
  </div>
</nav>
<div class="clear"></div>
<%
	List<Message> message = factory.getMessagesAtPage(1);
	Message m=new Message();
	User user=new User();
	for(int i=0; i<message.size();i++){
		m=(Message)message.get(i);
		user=(User)m.getCreator();
		%>
<div class="clear"></div>
<div style="-webkit-box-align: center; width:800px;height:100px;margin:auto auto auto auto;">
<div class="box">
  <article class="media">
    <div class="media-left">
      <figure class="image is-16x16">
      <%=("<img src='"+user.getHead()+"' alt='Image'>")%>     
      </figure>
    </div>
    <div class="media-content">
      <div class="content">
        <p> 
        <%=("<strong>"+user.getName()+"</strong>")%>
          <small>/..状态</small> <small><%=m.getCreatetime() %></small>
          <br>
          <% out.print(m.getMessage()); %>
          </p>
       </div>
     </div>
     <nav class="level is-mobile">
        <div class="level-left">
          <a class="level-item">
            <span class="icon is-small"><i class="fa fa-reply"></i></span>
          </a>
          <a class="level-item">
            <span class="icon is-small"><i class="fa fa-retweet"></i></span>
          </a>
          <a class="level-item">
            <span class="icon is-small"><i class="fa fa-heart"></i></span>
          </a>
        </div>
      </nav>
	</article>
    </div>
</div>
<% 	}
%>
<!--  
      <nav class="level is-mobile">
        <div class="level-left">
          <a class="level-item">
            <span class="icon is-small"><i class="fa fa-reply"></i></span>
          </a>
          <a class="level-item">
            <span class="icon is-small"><i class="fa fa-retweet"></i></span>
          </a>
          <a class="level-item">
            <span class="icon is-small"><i class="fa fa-heart"></i></span>
          </a>
        </div>
      </nav>
    </div>
  </article>
</div>

-->
<% int countMessage= factory.countTotalMessages();
	int countPage=factory.countTotalPages();
	List list=factory.getMessagesAtPage(countPage);
%>


<nav class="pagination" role="navigation" aria-label="pagination">
  <a class="pagination-previous" title="This is the first page" disabled>null</a>
  <a class="pagination-next">null</a>
  <ul class="pagination-list">
    <li>
      <a class="pagination-link is-current" aria-label="Page 1" aria-current="page">1</a>
    </li>
  </ul>
</nav>
<div><hr/></div>
<article class="media">
  <figure class="media-left">
    <p class="image is-64x64">
    <% if(u==null){ 
    out.print("<img src='https://bulma.io/images/placeholders/128x128.png'>");
    }else{
    	out.print("<img src='"+u.getHead()+"'>");	
    } %>
    </p>
  </figure>
  <div class="media-content">
    <div class="field">
      <p class="control">
        <textarea class="textarea" placeholder="Add a comment..."></textarea>
      </p>
    </div>
    <nav class="level">
      <div class="level-left">
        <div class="level-item">
          <a class="button is-info">Submit</a>
        </div>
      </div>
      <div class="level-right">
        <div class="level-item">
          <label class="checkbox">
            <input type="checkbox"> Press enter to submit
          </label>
        </div>
      </div>
    </nav>
  </div>
</article>
</div>
<hr/>
<div class="CopyRight" id="CopyRight">
<p align="center">版权声明:此网站仅用于学习使用</p>
<p align="center">联系我们：<a>1234567</a></p>

</div>
</body>
</html>