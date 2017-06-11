<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class='no-js' lang='en'>
  <head>
    <meta charset='utf-8'>
    <meta content='IE=edge,chrome=1' http-equiv='X-UA-Compatible'>
    <title>商品管理</title>
    <meta content='lab2023' name='author'>
    <meta content='' name='description'>
    <meta content='' name='keywords'>
    
    
    
    <link href="assets/stylesheets/application-a07755f5.css" rel="stylesheet" type="text/css" /><link href="http://netdna.bootstrapcdn.com/font-awesome/3.2.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/images/favicon.ico" rel="icon" type="image/ico" />

   <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js" type="text/javascript"></script>
   <script src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.6.2/modernizr.min.js" type="text/javascript"></script>
   <script src="assets/javascripts/application-985b892b.js" type="text/javascript"></script>


	
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	
	
	<script type="text/javascript" src="js/bootstrap-table.js"></script>
	<script type="text/javascript" src="js/bootstrap-table-zh-CN.js"></script>
	<link href="css/bootstrap-table.css" rel="stylesheet"/>
	<script type="text/javascript" src="js/ajaxfileupload.js"></script>
	
	<script type="text/javascript" src="js/goodstables.js"></script>







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
          <li class='launcher'>
            <i class='icon-dashboard'></i>
            <a href="main.jsp">主界面</a>
          </li>
         
          <li class='launcher'>
            <i class='icon-table'></i>
            <a href="usertables.jsp">用户管理</a>
          </li>
          <li class='active launcher'>
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
	            <button id="btn_add" type="button" class="btn btn-default" data-target="#addModal">
	                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
	            </button>
	            <button id="btn_edit" type="button" class="btn btn-default">
	                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
	            </button>
	            <button id="btn_delete" type="button" class="btn btn-default">
	                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
	            </button>
	            
	        </div>
	        <table id="tb_departments"></table>
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
<!-- ==================添加数据框============== -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLable" aria-hidden="true">
	<div class="modal-dialog" >
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="addModalLable">添加商品</h4>
			</div>
			<div class="modal-body" >
				<form id="addForm" >
					<div class="form-group">
					 <label for="goodName_add">商品名称</label>
					 <input type="text" class="form-control" id="goodName_add" name="name" placeholder="商品名称">
					</div>
					<div class="form-group">
				    <label for="goodfile_add">配图文件</label>
				    <input type="file" id="goodfile_add" name="img">
				    <p class="help-block">在文件框中选择商品的配图文件</p>
				  </div>
				  <div class="form-group">
					 <label for="goodUrl_add">商品链接</label>
					 <input type="text" class="form-control" id="goodUrl_add" name="goodUrl" placeholder="商品点击链接的URL">
					</div>
					<div class="form-group">
					 <label for="goodDesc_add">详细介绍</label>
					 <textarea class="form-control" rows="5" id="goodDesc_add" name="name" placeholder="填写商品详细介绍"></textarea>
					</div>	 		
				</form>
			</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="addModalSubmitBtn">保存提交</button>
            </div>
		</div>
	</div>
</div>
<!-- ==================编辑数据框============== -->
 <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLable" aria-hidden="true">
	<div class="modal-dialog" >
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="editModalLable">编辑商品</h4>
			</div>
			<div class="modal-body" >
				<form id="editForm" >
					<div class="form-group">
					
					 <input type="hidden" class="form-control" id="goodId_edit" >
					</div>
					<div class="form-group">
					 <label for="goodName_edit">商品名称</label>
					 <input type="text" class="form-control" id="goodName_edit"  placeholder="商品名称">
					</div>
					<div class="form-group">
				    <label for="goodfile_edit">配图文件</label>
				    <input type="file" id="goodfile_edit" name="img">
				    <p class="help-block">在文件框中选择商品的配图文件</p>
				  </div>
				  <div class="form-group">
					 <label for="goodUrl_edit">商品链接</label>
					 <input type="text" class="form-control" id="goodUrl_edit"  placeholder="商品点击链接的URL">
					</div>
					<div class="form-group">
					 <label for="goodDesc_edit">详细介绍</label>
					 <textarea class="form-control" rows="5" id="goodDesc_edit"  placeholder="填写商品详细介绍"></textarea>
					</div>	 		
				</form>
			</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="editModalSubmitBtn">确认更改</button>
            </div>
		</div>
	</div>
</div>
   
    
  
  </body>
 
</html>
