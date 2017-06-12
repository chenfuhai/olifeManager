/**
 * 
 */

$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();

});


var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_departments').bootstrapTable({
            url: '/olifeManager/feedback_show.action',         //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [5,10,15,20],        //可供选择的每页的行数（*）
            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: false,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: [{
                checkbox: true
            }, {
                field: 'id',
                title: '反馈ID'
            }, {
                field: 'userId',
                title: '用户ID'
            }, {
                field: 'userName',
                title: '用户名'
            }, {
                field: 'userAge',
                title: '年龄'
            }, {
                field: 'userSex',
                title: '性别'
            }, {
                field: 'message',
                title: '反馈信息'
            }, {
                field: 'QQ',
                title: 'QQ'
            }, {
                field: 'email',
                title: '电子邮箱'
            }, {
                field: 'phone',
                title: '手机'
            }]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            departmentname: $("#txt_search_departmentname").val(),
            statu: $("#txt_search_statu").val()
        };
        return temp;
    };
    return oTableInit;
};


var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
    	
//    	
//    	$("#btn_add").click(function () {
//            
//            $('#addModal').modal()
//        });
//    	
//    	$("#addModalSubmitBtn").click(function (){
//    		var  userId = $("#userId_edit").val();
//    		var  username = $("#uesrName_edit").val();
//    		var  userfeedback = $("#userfeedback_edit").val();
//    		var  userage = $("#userAge_edit").val();
//    		var  userqq = $("#userQQ_edit").val();
//    		var  userphone = $("#userPhone_edit").val();
//    		var  useremail = $("#userEmail_edit").val();
//    		
//    		var  id = $("#feedbackId_edit").val();
//    		
//    		$.ajax({
//	                type: "POST",
//	                url: "/olifeManager/goods_insert.action",
//	                data: "{'iconurl':'"+imgUrl+"','name':'"+name+"','desc':'"+desc+"','url':'"+url+"'}",
//	                contentType: "application/json",
//	                success: function (data, status) {
//                 
//	                	if (data == "success") {
//	                		$("#addModal").modal('hide');
//	                		 $("#waringModalText").html('添加成功');
//	                		 $("#waringModal").modal();
//	                    }else{
//	                    	alert("添加失败，可能已存在相同商品");
//	                    }
//                     $("#tb_departments").bootstrapTable('refresh');
//	                },
//	                error: function () {
//	                	alert("发生错误");
//	                }
//
//	            });
//    		 
//    		
//    	});
//    	
//    	
//
//
//        $("#btn_edit").click(function () {
//            var arrselections = $("#tb_departments").bootstrapTable('getSelections');
//
//            if (arrselections.length > 1) {
//                $("#waringModalText").html('只能选择一行进行编辑');
//            	$("#waringModal").modal();
//                return;
//            }
//            if (arrselections.length <= 0) {
//            	$("#waringModalText").html('请选择一项数据');
//            	$("#waringModal").modal();
//                return;
//            }
////            alert(arrselections[0].Name);
//            $("#goodId_edit").val(arrselections[0].id);
//            $("#goodName_edit").val(arrselections[0].name);
//            $("#goodUrl_edit").val(arrselections[0].url);
//            $("#goodfile_edit").val();
//            $("#goodDesc_edit").text(arrselections[0].desc);
//           
//            $('#editModal').modal();
//        });
//
//        
//        $("#editModalSubmitBtn").click(function (){
//        	var name =  $("#goodName_edit").val();
//            var url = $("#goodUrl_edit").val();
//            var desc = $("#goodDesc_edit").text();
//        	if (name=="" || url =="" || desc=="") {
//				alert("请填写完整数据");
//				return;
//			}
//        	var file=$('#goodfile_edit').val();
//        	var id = $('#goodId_edit').val();
//        	if (file=="") {
//        		//文件为空就直接上传 忽略文件
//        		$.ajax({
//                    type: "POST",
//                    url: "/olifeManager/goods_update.action",
//                    data: "{'id':'"+id+"','name':'"+name+"','desc':'"+desc+"','url':'"+url+"'}",
//                    contentType: "application/json",
//                    success: function (data, status) {
//                    
//                    	if (data == "success") {
//                    		$("#addModal").modal('hide');
//                    		 $("#waringModalText").html('更新成功');
//                    		 $("#waringModal").modal();
//                        }else{
//                        	alert("更新失败");
//                        }
//                        $("#tb_departments").bootstrapTable('refresh');
//                    },
//                    error: function () {
//                    	alert("发生错误");
//                    }
//
//                });
//			}else{
//				//文件不为空就先上传文件 再更新
//				 $.ajaxFileUpload({
//	    		        url:'/olifeManager/UploadFile.action',//上传图片要提交到的action
//	    		        secureuri:false,//是否用安全提交，默认为false
//	    		        fileElementId:'goodfile_edit',//file选择文件的框的id
//	    		        //dataType:'json',//返回的是JSON数据
//	    		        success: function (data){
//	    		        	var str = $(data).find("body").text();//获取返回的字符串
//	    		        	$.ajax({
//	    	                    type: "POST",
//	    	                    url: "/olifeManager/goods_update.action",
//	    	                    data: "{'id':'"+id+"','iconurl':'"+str+"','name':'"+name+"','desc':'"+desc+"','url':'"+url+"'}",
//	    	                    contentType: "application/json",
//	    	                    success: function (data, status) {
//	    	                    
//	    	                    	if (data == "success") {
//	    	                    		$("#editModal").modal('hide');
//	    	                    		 $("#waringModalText").html('更新成功');
//	    	                    		 $("#waringModal").modal();
//	    	                        }else{
//	    	                        	alert("更新失败");
//	    	                        }
//	    	                        $("#tb_departments").bootstrapTable('refresh');
//	    	                    },
//	    	                    error: function () {
//	    	                    	alert("发生错误");
//	    	                    }
//
//	    	                });
//	    		        },
//	    		 		error:function (data){
//	    		 			alert(data+"error");
//	    		 		}
//	    		        
//	    		    }); 				
//			}//else 
//	
//        	
//        });
        
        $("#btn_delete").click(function () {
        	var arrselections = $("#tb_departments").bootstrapTable('getSelections');
            if (arrselections.length <= 0) {
            	$("#waringModalText").html('请选择一项数据');
            	$("#waringModal").modal();
                return;
            }
            if (arrselections.length > 1) {
                $("#waringModalText").html('只能选择一行进行删除');
            	$("#waringModal").modal();
                return;
            }
            
            $("#confirmModalText").html('您确认删除这一项吗？此操作不可恢复');
        	$("#confirmModal").modal();
           
        });
        
        $("#confirmModalConfirmBtn").click(function (){
        	var arrselections = $("#tb_departments").bootstrapTable('getSelections');
        	var id=arrselections[0].id;
        	$.ajax({
                type: "POST",
                url: "/olifeManager/goods_delete.action",
                data: "{'id':'"+id+"'}",
                contentType: "application/json",
                success: function (data, status) {
                
                	//alert( typeof  data);
                	//alert(data == "success");
                	if (data == "success") {
                		$("#comfirmModal").modal('hide');
                		 $("#waringModalText").html('删除成功');
                		// alert("sdfsdfs");
                		 $("#waringModal").modal();
                    }else{
                    	alert("删除失败");
                    }
                    $("#tb_departments").bootstrapTable('refresh');
                },
                error: function () {
                	alert("发生错误");
                }

            });
        	
        	
        	
        });


    	
    };

    return oInit;
};