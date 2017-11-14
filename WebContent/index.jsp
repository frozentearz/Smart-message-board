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
  <img src="img\Logo\Logo.PNG" alt="Logo" width="325px" height="260px" />
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
	out.print("<div class='dropdown'><figure class='image is-48x48'> <img src='"+u.getHead()+"' alt='logo' id='img'> </figure><div class='dropdown-content'><p><a href='MyInfo.jsp'>我的信息</a></p><p><a href='#'>我的留言</a></p></div></div>");
	out.print("&nbsp;&nbsp;&nbsp;&nbsp;<p class='level-item'><a href='#'>"+u.getName()+"</a></p>");
	out.print("<form name='Logout' action='Logout' method='post'><input type='submit' class='button is-primary' placeholder='注销' value='注销'></form>");
}
%>
</div>
</nav>
<div class="clear"></div>

<!-- 留言层 -->
<%
	int countPages=factory.countTotalPages();
	int nowPage=1;
	String page_s=request.getParameter("nowPage");
	if(page_s!=null){
		nowPage=Integer.parseInt(page_s);
	}
	List<Message> message = factory.getMessagesAtPage(nowPage);
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
	</article>
    </div>
</div>
<% 	}
%>
<!-- 页码层 -->
<nav class="pagination" role="navigation" aria-label="pagination">
<div style="margin: 0 auto" >
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
<div><hr/></div>
<!-- 发帖层 -->
<% if(u!=null){ %>
<form name="message" action="CreateMsg" method="post" >
<article class="media">
  <figure class="media-left">
    <p class="image is-64x64">
    <%
    	out.print("<img src='"+u.getHead()+"'>");
    %>
    </p>
  </figure>
  <div class="media-content">
    <div class="field">
      <p class="control">
        <textarea name="message" class="textarea" placeholder="添加留言"></textarea>
      </p>
    </div>
    <nav class="level">
      <div class="level-left">
        <div class="level-item">
          <input class="button is-info" type="submit" value="确定" >
        </div>
      </div>
      <div class="level-right">
        <div class="level-item">
          <label class="checkbox">
            <input type="checkbox"> 按Enter提交
          </label>
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
<!-- 版权层 -->
<div class="CopyRight" id="CopyRight">
<p align="center">版权声明:此网站仅用于学习使用</p>
<p align="center">联系我们：<a>frozen_tearz@163.com</a></p>

</div>
</body>
</html>