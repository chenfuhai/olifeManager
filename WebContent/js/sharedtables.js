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
            url: '/olifeManager/Share_show.action',         //请求后台的URL（*）
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
            },{
                field: 'id',
                title: '分享ID'
            }, {
                field: 'resultMark',
                title: '检测分数'
            }, {
                field: 'ben',
                title: '苯分数'
            }, {
                field: 'pm2_5',
                title: 'PM2.5分数'
            }, {
                field: 'suggest',
                title: '科学建议'
            },{
                field: 'lng',
                title: '地点经度'
            },{
                field: 'lat',
                title: '地点纬度'
            },{
                field: 'province',
                title: '省份'
            },{
                field: 'district',
                title: '地区'
            },{
                field: 'city',
                title: '城市'
            },{
                field: 'street',
                title: '街道'
            },{
                field: 'StreetNum',
                title: '街道门号'
            },{
                field: 'userId',
                title: '用户ID'
            },{
                field: 'username',
                title: '用户名'
            },{
                field: 'userImgUrl',
                title: '用户头像地址'
            },{
                field: 'userphone',
                title: '手机号'
            },{
                field: 'useremail',
                title: '邮箱'
            },{
                field: 'usersex',
                title: '性别'
            },{
                field: 'userage',
                title: '年龄'
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
                url: "/olifeManager/share_delete.action",
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