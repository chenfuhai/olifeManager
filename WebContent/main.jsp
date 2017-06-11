<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class='no-js' lang='en'>
  <head>
    <meta charset='utf-8'>
    <meta content='IE=edge,chrome=1' http-equiv='X-UA-Compatible'>
    <title>管理员界面</title>
    <meta content='lab2023' name='author'>
    <meta content='' name='description'>
    <meta content='' name='keywords'>
    <link href="assets/stylesheets/application-a07755f5.css" rel="stylesheet" type="text/css" /><link href="http://netdna.bootstrapcdn.com/font-awesome/3.2.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/images/favicon.ico" rel="icon" type="image/ico" />
    
  </head>
  <body class='main page'>
  <c:if test="${sessionScope.userName==null}">
  <c:redirect url="index.jsp"></c:redirect>
  </c:if>
    <!-- Navbar -->
    <div class='navbar navbar-default' id='navbar'>
      <a class='navbar-brand' href='#'>
        <i class='icon-beer'></i>
        	管理员界面
      </a>
      <ul class='nav navbar-nav pull-right'>
        
        <li>
          <a href='#'>
            <i class='icon-cog'></i>
           	 设置
          </a>
        </li>
        <li class='dropdown user'>
          <a class='dropdown-toggle' data-toggle='dropdown' href='#'>
            <i class='icon-user'></i>
            <strong>${userName}</strong>
            <img class="img-rounded" src="http://placehold.it/20x20/ccc/777" />
            <b class='caret'></b>
          </a>
          <ul class='dropdown-menu'>
            
            <li>
             <a href="logout.action">Sign out</a>
            </li>
          </ul>
        </li>
      </ul>
    </div>
    <div id='wrapper' style="margin-bottom: 20px;border-bottom-right-radius: 15px;border-bottom-left-radius: 15px;">
      <!-- Sidebar -->
      <section id='sidebar'>
        <i class='icon-align-justify icon-large' id='toggle'></i>
    <ul id='dock'>
          <li class='active launcher'>
            <i class='icon-dashboard'></i>
            <a href="main.jsp">主界面</a>
          </li>
         
          <li class='launcher'>
            <i class='icon-table'></i>
            <a href="usertables.jsp">用户管理</a>
          </li>
          <li class='launcher'>
            <i class='icon-table'></i>
            <a href="goodstables.jsp">商品管理</a>
          </li>
          <li class='launcher'>
            <i class='icon-table'></i>
            <a href="sharedtables.jsp">分享管理</a>
          </li>
          <li class='launcher'>
            <i class='icon-table'></i>
            <a href="disctables.jsp">评论管理</a>
          </li>
          <li class='launcher'>
            <i class='icon-table'></i>
            <a href="feedbacktables.jsp">查看反馈</a>
        
        </ul>
      </section>
      <!-- Tools -->
      <section id='tools'>
        <ul class='breadcrumb' id='breadcrumb'>
          <li class='title'> </li>
          <li><a href="#"> </a></li>
          <li class='active'> </a></li>
        </ul>
        <div id='toolbar'>
          
        </div>
      </section>
      <!-- Content -->
      <div id='content'>
       
         <div class="col-sm-12 text-center">
  			  <h1>欢迎，请使用左边工具栏</h1>
 		 </div>
  
       	
  

      </div>
    </div>
    <!-- Footer -->
    <!-- Javascripts -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js" type="text/javascript"></script><script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js" type="text/javascript"></script><script src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.6.2/modernizr.min.js" type="text/javascript"></script><script src="assets/javascripts/application-985b892b.js" type="text/javascript"></script>
    <!-- Google Analytics -->
    <script>
      var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
      (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
      g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
      s.parentNode.insertBefore(g,s)}(document,'script'));
    </script>
  </body>
</html>
