<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="factory" scope="application" class="com.controller.Factory" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="css/bulma.css" />
<title>留言板</title>
</head>
<body>
<!-- 下面这句是用来测试的，可以删掉 -->
<%=factory.countTotalMessages() %>

<div class="container">
<!-- Main container -->
<nav class="level">
  <!-- Left side -->
  <div class="level-left">
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
          <button class="button">
            Search
          </button>
        </p>
      </div>
    </div>
  </div>

  <!-- Right side -->
  <div class="level-right">
    <p class="level-item"><strong>All</strong></p>
    <p class="level-item"><a href="login.jsp">Login</a></p>
    <p class="level-item"><a href="signup.jsp">SignUp</a></p>
    <p class="level-item"><a>LogOut</a></p>
    <p class="level-item"><a class="button is-success">New</a></p>
  </div>
</nav>
<div class="box">
  <article class="media">
    <div class="media-left">
      <figure class="image is-64x64">
        <img src="<%=factory.getUserProfile(1).getHead() %>" alt="Image">
      </figure>
    </div>
    <div class="media-content">
      <div class="content">
        <p>
          <strong><%=factory.getUserProfile(1).getName() %></strong> <small>@johnsmith</small> <small>31m</small>
          <br>
          <%=factory.getMessage(1).getMessage() %>
        </p>
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
    </div>
  </article>
</div>
<div class="box">
              <p class="title has-text-centered">Digital Literacy Primer</p>
              <hr>
              <div class="content">
                <p class="subtitle has-text-centered">
                  Small businesses, libraries, public institutions, teachers and classrooms
                </p>
                <p>
                  2 hour crash course in all things relevant to digital literacy. Begins with the question "What's a computer anyway?" and culminates with practical strategies for disarming the threats facing modern web users.
                </p>
                <p>
                  Designed to answer all the most fundamental questions around how the internet works and how to empower individuals and collectives with the tools and knowledge required to stay safe online.
                </p>
              </div>
              <p class="subtitle has-text-centered">
                <a class="subtitle plain-link inTriggerLit" href="#literacy-outline">View Course Outline</a>
              </p>
            </div> 
<div class="box">
              <p class="title has-text-centered">Digital Literacy Primer</p>
              <hr>
              <div class="content">
                <p class="subtitle has-text-centered">
                  Small businesses, libraries, public institutions, teachers and classrooms
                </p>
                <p>
                  2 hour crash course in all things relevant to digital literacy. Begins with the question "What's a computer anyway?" and culminates with practical strategies for disarming the threats facing modern web users.
                </p>
                <p>
                  Designed to answer all the most fundamental questions around how the internet works and how to empower individuals and collectives with the tools and knowledge required to stay safe online.
                </p>
              </div>
              <p class="subtitle has-text-centered">
                <a class="subtitle plain-link inTriggerLit" href="#literacy-outline">View Course Outline</a>
              </p>
            </div> 
<div class="box">
              <p class="title has-text-centered">Digital Literacy Primer</p>
              <hr>
              <div class="content">
                <p class="subtitle has-text-centered">
                  Small businesses, libraries, public institutions, teachers and classrooms
                </p>
                <p>
                  2 hour crash course in all things relevant to digital literacy. Begins with the question "What's a computer anyway?" and culminates with practical strategies for disarming the threats facing modern web users.
                </p>
                <p>
                  Designed to answer all the most fundamental questions around how the internet works and how to empower individuals and collectives with the tools and knowledge required to stay safe online.
                </p>
              </div>
              <p class="subtitle has-text-centered">
                <a class="subtitle plain-link inTriggerLit" href="#literacy-outline">View Course Outline</a>
              </p>
            </div> 
<nav class="pagination" role="navigation" aria-label="pagination">
  <a class="pagination-previous" title="This is the first page" disabled>ä¸ä¸é¡µ</a>
  <a class="pagination-next">ä¸ä¸é¡µ</a>
  <ul class="pagination-list">
    <li>
      <a class="pagination-link is-current" aria-label="Page 1" aria-current="page">1</a>
    </li>
    <li>
      <a class="pagination-link" aria-label="Goto page 2">2</a>
    </li>
    <li>
      <a class="pagination-link" aria-label="Goto page 3">3</a>
    </li>
      <li><a class="pagination-link" aria-label="Goto page 4">4</a></li>
  <li><a class="pagination-link" aria-label="Goto page 5">5</a></li>
    <li><span class="pagination-ellipsis">&hellip;</span></li>
    <li><a class="pagination-link" aria-label="Goto page 45">45</a></li>
    <li><a class="pagination-link t" aria-label="Page 46" >46</a></li>
    <li><a class="pagination-link" aria-label="Goto page 47">47</a></li>
    <li><span class="pagination-ellipsis">&hellip;</span></li>
    <li><a class="pagination-link" aria-label="Goto page 86">86</a></li>
  </ul>
</nav>
<article class="media">
  <figure class="media-left">
    <p class="image is-64x64">
      <img src="https://bulma.io/images/placeholders/128x128.png">
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
</body>
</html>