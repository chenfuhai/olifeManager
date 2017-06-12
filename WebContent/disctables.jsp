<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class='no-js' lang='en'>

  <head>
    <meta charset='utf-8'>
    <meta content='IE=edge,chrome=1' http-equiv='X-UA-Compatible'>
    <title>评论管理</title>
    <meta content='lab2023' name='author'>
    <meta content='' name='description'>
    <meta content='' name='keywords'>

 
   	<script src="http://code.jquery.com/jquery-latest.js"></script>
   <script src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.6.2/modernizr.min.js" type="text/javascript"></script>
   <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/bootstrap-table.js"></script>
	<script type="text/javascript" src="js/bootstrap-table-zh-CN.js"></script>
	<link href="css/bootstrap-table.css" rel="stylesheet"/>
   <script src="assets/javascripts/application-985b892b.js" type="text/javascript"></script>
    <link href="assets/stylesheets/application-a07755f5.css" rel="stylesheet" type="text/css" />
    <link href="http://netdna.bootstrapcdn.com/font-awesome/3.2.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/images/favicon.ico" rel="icon" type="image/ico" />
	<script type="text/javascript" src="js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="js/disctables.js"></script>

    
  </head>
  <body class='main page'>
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
          <li class='launcher'>
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
          <li class='active launcher'>
            <i class='icon-table'></i>
            <a href="disctables.jsp">评论管理</a>
          </li>
          <li class='launcher'>
            <i class='icon-table'></i>
            <a href="feedbacktables.jsp">查看反馈</a>
          </li>
         
        </ul>
       
      </section>
      <!-- Tools -->
     <section id='tools'>
        <ul class='breadcrumb' id='breadcrumb'>
          <li class='title'> </li>
          <li><a href="#"> </a></li>
          <li class='active'> </a></li>
        </ul>
        <div id='toolbar1'>
          
        </div>
      </section>
      <!-- Content -->
      <div id='content'>
		<div class="panel-body" style="padding-bottom:0px;">

	        <div id="toolbar" class="btn-group">
	            <!--  <button id="btn_add" type="button" class="btn btn-default" data-target="#addModal">
	                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
	            </button> 
	            <button id="btn_edit" type="button" class="btn btn-default" data-target="#editModal">
	                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
	            </button>-->
	            <button id="btn_delete" type="button" class="btn btn-default" data-target="#waringModal">
	                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
	            </button>
	            
	        </div>
	        <table id="tb_departments"></table>
	    </div>
   	 </div>
    </div>
    
    
        <!-- ===============确认框=========== -->
<div class="modal fade" id="confirmModal" tabindex="-1"  role="dialog" aria-labelledby="waringModalLable" aria-hidden="true">
	<div class="modal-dialog" style="width: 20%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="comfirmModalLable">提示</h4>
			</div>
			<div class="modal-body" id="confirmModalText">这是个确认框</div>
            <div class="modal-footer">
                 <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="confirmModalConfirmBtn" data-dismiss="modal">确认</button>
            </div>
		</div>
	</div>
</div>
<!-- ===============警告框=========== -->
<div class="modal fade" id="waringModal" tabindex="-1"  role="dialog" aria-labelledby="waringModalLable" aria-hidden="true">
	<div class="modal-dialog" style="width: 20%;">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="waringModalLable">提示</h4>
			</div>
			<div class="modal-body" id="waringModalText">这是个警告框</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
            </div>
		</div>
	</div>
</div>
  </body>
</html>
