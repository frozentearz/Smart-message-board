<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="404.jsp" %>
<%@ page import="com.models.*,java.util.List,com.controller.Factory" %>
<jsp:useBean id="factory" scope="application" class="com.controller.Factory" />
<% 
	session = request.getSession();
	User u= (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width,initial-scale=1" />
		<meta http-equiv="charset"  content="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/bulma.css" />
		<title>留言板</title>
		<script src="js/vue.js" ></script>
		<style>
		  	body{
		      	font-family:"Segoe UI";
		    }
		    li{
		      	list-style:none;
		    }
		    a{
		     	text-decoration:none;
		    }
		    .pagination {
		        position: relative;
		    }
		    .pagination li{
		        display: inline-block;
		        margin:0 5px;
		    }
		    .pagination li a{
		    	padding:.5rem 1rem;
		        display:inline-block;
		        border:1px solid #ddd;
		        background:#fff;
		        color:#0E90D2;
		    }
		    .pagination li a:hover{
		        background:#eee;
		    }
		    .pagination li.active a{
		        background:#0E90D2;
		        color:#fff;
		    }
		</style>
		<style>
			img {
				border-radius:50%;
			}
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

<div class="container" style="margin:15px auto;">
<!-- Main container -->
<nav class="level" >
  <!-- Left side -->
  <div class="level-left" style="margin-left: 150px" >
  <figure class='image is-128x128'>
  <a href="index.jsp"><img src="img\Logo\LOGO.gif" alt="Logo" width="325px" height="260px" /></a>
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
<% if(u == null) {
	out.print("<p class='level-item'><a class='button is-primary' href='login.jsp'>登录</a></p>");
	out.print("<p class='level-item'><a class='button is-primary' href='signup.jsp'>注册</a></p>");
	} else {
	out.print("<div class='dropdown'><figure class='image is-48x48'> <img src='"+u.getHead()+"' alt='logo' id='img'> </figure><div class='dropdown-content'><p><a href='MyInfo.jsp'>我的信息</a></p><p><a href='MyMsg.jsp'>我的留言</a></p></div></div>");
	out.print("&nbsp;&nbsp;&nbsp;&nbsp;<p class='level-item'><a href='MyInfo.jsp'>"+u.getName()+"</a></p>");
	out.print("<form name='Logout' action='Logout' method='post'><input type='submit' class='button is-primary' placeholder='注销' value='注销'></form>");
}
%>
</div>
</nav>
<div class="clear"></div>

<!-- 留言层 -->
<%
	int countPages = factory.countTotalPages();
	int nowPage = 1;
	String page_s = request.getParameter("nowPage");
	if(page_s != null){
		nowPage = Integer.parseInt(page_s);
	}
	List<Message> message = factory.getMessagesAtPage(nowPage);
	Message m = new Message();
	User user = new User();
	if(message.size() != 0) {
	for(int i = 0; i < message.size(); i ++){
		m = (Message)message.get(i);
		user = (User)m.getCreator();
		%>
<div class="clear"></div>
<div style="-webkit-box-align: center; width:800px;height:100px;margin:auto auto auto auto;">
<div class="box">
  <article class="media">
    <div class="media-left">
      <figure class="image is-24x24">
      <%=("<img src='"+user.getHead()+"' alt='Image'>")%>     
      </figure>
    </div>
    <div class="media-content">
      <div class="content">
        <p> 
        <%=("<strong>"+user.getName()+"</strong>")%>
          <small class="tag" style="float:right"><%=m.getCreatetime() %></small>
          <br>
          <% out.print(m.getMessage()); %>
          </p>
       </div>
     </div>
	</article>
    </div>
</div>
<% 	}
%>
<!-- 页码层 -->
<nav class="pagination" role="navigation" aria-label="pagination">
<div style="margin: 10px auto" >
	<script type="text/x-template" id="page">
        <ul class="pagination" >
            <li ><a :href="'index.jsp?nowPage='+<%=1%>"class="pagination-previous" >首页</a></li>
            <li v-show="current != 1" @click="current-- && goto(current)" ><a :href="'index.jsp?nowPage='+<%=(nowPage-1)%>" class="pagination-next" >上一页</a></li>
            <li v-for="index in pages" @click="goto(index)" :class="{'active':current == index}" :key="index">
              <a :href="'index.jsp?nowPage='+index" >{{index}}</a>
            </li>
            <li v-show="allpage != current && allpage != 0 " @click="current++ && goto(current++)"><a :href="'index.jsp?nowPage='+<%=(nowPage+1)%>" class="pagination-next" >下一页</a></li>
            <li><a :href="'index.jsp?nowPage='+<%=countPages%>" class="pagination-previous" >末页</a></li>
        </ul>
	</script>
<div id="app" class="pagination">
          <page></page>
     </div>
 </div>
</nav>
<script>
  Vue.component("page",{
      template:"#page",
        data:function(){
          return{
            current: <%=nowPage%>,
            showItem:5,
            allpage:<%=countPages%>
          }
        },
        computed:{
          pages:function(){
                var pag = [];
                  if( this.current < this.showItem ){ //如果当前的激活的项 小于要显示的条数
                       //总页数和要显示的条数那个大就显示多少条
                       var i = Math.min(this.showItem,this.allpage);
                       while(i){
                           pag.unshift(i--);
                       }
                   }else{ //当前页数大于显示页数了
                       var middle = this.current - Math.floor(this.showItem / 2 ),//从哪里开始
                           i = this.showItem;
                       if( middle >  (this.allpage - this.showItem)  ){
                           middle = (this.allpage - this.showItem) + 1
                       }
                       while(i--){
                           pag.push( middle++ );
                       }
                   }
                 return pag
               }
      },
      methods:{
        goto:function(index){
          if(index == this.current) return;
            this.current = index;           
            //这里可以发送ajax请求
        }
      }
    })

var vm = new Vue({
  el:'#app',
})

</script>
<% }else {%>
	<div class="box" style="text-align: center;" >
	   <p>欢迎来到Smart留言板</p>
	   <p>目前无任何留言</p>
	</div>
<% } %>
<div><hr/></div>
<!-- 发帖层 -->
<% if(u!=null){ %>
<form name="message" action="CreateMsg" method="post" onSubmit="sendTime();" >
<article class="media">
  <figure class="media-left">
    <p class="image is-24x24">
    <%
    	out.print("<img src='"+u.getHead()+"'>");
    %>
    </p>
  </figure>
  <div class="media-content">
    <div class="field">
      <p class="control">
        <textarea name="message" class="textarea" style="resize:none; width:80px; height:20px;"  placeholder="添加留言"></textarea>
      </p>
    </div>
    <nav class="level">
      <div class="level-left">
        <div class="level-item">
          <input name="time" value="" type="hidden" id="time" style="width:250px" />
          <input class="button is-info" type="submit" value="确定" >
        </div>
      </div>
    </nav>
  </div>
</article>
</form>
</div>
<hr/>
<%
}
%>
    <script language="javascript">
      function sendTime(){
		var newDate=new Date();
		
		var year=newDate.getFullYear();
		var month=(newDate.getMonth()+1)<10?"0"+(newDate.getMonth()+1):newDate.getMonth()+1;
		var day=newDate.getDate()<10?"0"+newDate.getDate():newDate.getDate();
		var hours=newDate.getHours()<10?"0"+newDate.getHours():newDate.getHours();
		var minuts=newDate.getMinutes()<10?"0"+newDate.getMinutes():newDate.getMinutes();
		var seconds=newDate.getSeconds()<10?"0"+newDate.getSeconds():newDate.getSeconds();
		var str=year+"-"+month+"-"+day+" "+hours+":"+minuts+":"+seconds;
		document.getElementById("time").value=str;
      } 
    </script>
</script>
<!-- 版权层 -->
<div class="CopyRight" id="CopyRight">
	<p align="center">版权声明:此网站仅用于学习使用</p>
	<p align="center">联系我们：<a>frozen_tearz@163.com</a></p>
</div>
</body>
</html>