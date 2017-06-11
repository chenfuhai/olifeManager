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
            url: '/LWD/test2.action',         //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
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
                title: '商品ID'
            }, {
                field: 'name',
                title: '商品名称'
            }, {
                field: 'iconurl',
                title: '配图地址'
            }, {
                field: 'url',
                title: '链接地址'
            }, {
                field: 'desc',
                title: '详细介绍'
            },]
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
    	
    	
    	$("#btn_add").click(function () {
            
            $('#addModal').modal()
        });
    	//先上传文件 再上传其他内容 并把文件的地址包括在里面
    	$("#addModalSubmitBtn").click(function (){

    		 $.ajaxFileUpload({
    		        url:'/LWD/test3.action',//上传图片要提交到的action
    		        secureuri:false,//是否用安全提交，默认为false
    		        fileElementId:'exampleInputFile',//file选择文件的框的id
    		        dataType:'json',//返回的是JSON数据
    		        success: function (data){
    		           alert(data.result);
    		           //接下去上传其他信息 以JSON形式 依照类的内容来传方便Gson解析
    		           
    		           
    		           
    		           
    		        },
    		 		error:function (data){
    		 			alert(data+"error");
    		 		}
    		        
    		    }); 
    		
    		 
    		
    	});
    	
    	


        $("#btn_edit").click(function () {
            var arrselections = $("#tb_departments").bootstrapTable('getSelections');

            if (arrselections.length > 1) {
                $("#waringModalText").html('只能选择一行进行编辑');
            	$("#waringModal").modal();
                return;
            }
            if (arrselections.length <= 0) {
            	$("#waringModalText").html('请选择一项数据');
            	$("#waringModal").modal();
                return;
            }
//            alert(arrselections[0].Name);
            $("#goodID_edit").val(arrselections[0].id);
            $("#goodName_edit").val(arrselections[0].name);
            $("#goodUrl_edit").val(arrselections[0].url);
            $("#goodfile_edit").val();
            $("#goodDesc_edit").text(arrselections[0].desc);
           
            $('#editModal').modal();
        });

        $("#btn_delete").click(function () {
            var arrselections = $("#tb_departments").bootstrapTable('getSelections');
            if (arrselections.length <= 0) {
                toastr.warning('请选择有效数据');
                return;
            }

            Ewin.confirm({ message: "确认要删除选择的数据吗？" }).on(function (e) {
                if (!e) {
                    return;
                }
                $.ajax({
                    type: "post",
                    url: "/Home/Delete",
                    data: { "": JSON.stringify(arrselections) },
                    success: function (data, status) {
                        if (status == "success") {
                            toastr.success('提交数据成功');
                            $("#tb_departments").bootstrapTable('refresh');
                        }
                    },
                    error: function () {
                        toastr.error('Error');
                    },
                    complete: function () {
                    }
                });
            });
        });

        $("#btn_submit").click(function () {
            postdata.DEPARTMENT_NAME = $("#txt_departmentname").val();
            postdata.PARENT_ID = $("#txt_parentdepartment").val();
            postdata.DEPARTMENT_LEVEL = $("#txt_departmentlevel").val();
            postdata.STATUS = $("#txt_statu").val();
            $.ajax({
                type: "post",
                url: "/Home/GetEdit",
                data: { "": JSON.stringify(postdata) },
                success: function (data, status) {
                    if (status == "success") {
                        toastr.success('提交数据成功');
                        $("#tb_departments").bootstrapTable('refresh');
                    }
                },
                error: function () {
                    toastr.error('Error');
                },
                complete: function () {

               }

            });
        });

        $("#btn_query").click(function () {
           $("#tb_departments").bootstrapTable('refresh');
        });
    	
    	
    	
    	
    	
    };

    return oInit;
};