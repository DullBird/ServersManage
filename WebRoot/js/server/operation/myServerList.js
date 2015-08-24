$(function(){
	$('.carousel').carousel({
		//初始化
		interval: false,	//不自动播放
		keyboard: false		//禁止键盘
	});
	
	//返回按钮
	$(".server-detail-return").click(function(){
		$(".carousel").carousel("prev");
	});
	
	//ajax加载服务器详情
	$(".server-detail-btn").click(function(){
		var id = $(this).attr("sId");
		var $btn = $(".server-detail-btn");
		$btn.attr("disabled","disabled");
		//若加载是上次的服务器，避免重复加载
		if($("#detail-sId").text() == id){
			$(".carousel").carousel(1);
			$btn.removeAttr("disabled");
		}else{
			$.ajax({
				url:base+'/server/ajax/operation/serverDetail',
				type:'POST',
				data:"sId="+id,
				success:function(date){
					//清空留下来的页面
					$(".myServer-detail").find(".panel").find(".panel-myServer-detail").empty();
					//翻页
					$(".carousel").carousel(1);
					$(".myServer-detail").find(".panel").find(".panel-myServer-detail").append(date);
				},
				error:function (XMLHttpRequest) {
					alert("错误代码："+XMLHttpRequest.status);
				},
				complete:function(){
					//解除按钮
					$btn.removeAttr("disabled");
				}
			});
		}
	});
	
	//删除服务器
	$("body").on("click","#server-del-btn",function(){
		var sId = $("#detail-sId").text();
		if(confirm("删除后将不能管理和查看该服务器，确定要删除吗？")){
			$.ajax({
				url:base+'/server/ajax/operation/delServer',
				type:"POST",
				data:"sId="+sId,
				success:function(data){
					$.scojs_message('删除成功', $.scojs_message.TYPE_OK);
					$("input[sId='"+ sId +"']").parent().parent().remove();
					//翻页
					$(".carousel").carousel(0);
				},
				error:function (XMLHttpRequest) {
					alert("错误代码："+XMLHttpRequest.status);
				}
			});
		}
	});
	
	//修改服务器基本信息按钮，因为详情页面的内容是后来append的，所以要用on来绑定事件
	$("body").on("click","#server-edit-btn", function() {
		$("#server-edit-btn").attr("disabled","disabled");
		if($("#detail-sId").text() == $("#update-sId").val()){
			$(".carousel").carousel(2);
			$("#server-edit-btn").removeAttr("disabled");
		}else{
			$.ajax({
				url:base+'/server/ajax/operation/updateServer',
				type:'POST',
				data:"sId="+$("#detail-sId").text(),
				success:function(date){
					//清空留下来的页面
					$(".myServer-detail-update").find(".panel-body").find("form").remove();
					//翻页
					$(".carousel").carousel(2);
					$(".myServer-detail-update").find(".panel-body").append(date);
				},
				error:function (XMLHttpRequest) {
					alert("错误代码："+XMLHttpRequest.status);
				},
				complete:function(){
					//解除按钮
					$("#server-edit-btn").removeAttr("disabled");
				}
			});
		}
	});
	
	//删除代理服务器的按钮
	$("body").on("click",".proxyServer-del-btn", function() {
		var $a = $(this);
		if(confirm("确定要删除该条记录吗？")){
			$.ajax({
  				url:base+'/server/ajax/operation/delProxy',
  				type:'POST',
  				data:"id="+$a.attr("proxyId"),
  				success:function(date){
  					if(date.success){
  						$.scojs_message('删除成功', $.scojs_message.TYPE_OK);
  						//清空行
  						$a.parent().parent().remove();
  					}
  				},error:function (XMLHttpRequest) {
  					$.scojs_message("错误代码："+XMLHttpRequest.status, $.scojs_message.TYPE_ERROR);
				}
			});
		}
	});
	
	//编辑代理服务器的按钮
	$("body").on("click",".proxyServer-edit-btn", function() {
		var $a = $(this);
		$.ajax({
				url:base+'/server/ajax/findProxy',
				type:'POST',
				data:"id="+$a.attr("proxyId"),
				success:function(date){
					if(date.success){
						var proxy = date.resultData;
						$("#editProxyForm").find("input[name='vhostName']").val(proxy.vhostName);
						$("#editProxyForm").find("input[name='vhostDomain']").val(proxy.vhostDomain);
						$("#editProxyForm").find("input[name='vhostRoot']").val(proxy.vhostRoot);
						$("#editProxyForm").find("input[name='vhostLogs']").val(proxy.vhostLogs);
						$("#editProxyForm").find("input[name='id']").val(proxy.id);
						//显示编辑代理服务器的表单弹出框
						$("#editProxyModal").modal("show");
					}
				},error:function (XMLHttpRequest) {
					$.scojs_message("错误代码："+XMLHttpRequest.status, $.scojs_message.TYPE_ERROR);
			}
		});
	});
	
	//删除应用服务器的按钮
	$("body").on("click",".webAppServer-del-btn", function() {
		var $a = $(this);
		if(confirm("确定要删除该条记录吗？")){
			$.ajax({
  				url:base+'/server/ajax/operation/delWebApp',
  				type:'POST',
  				data:"id="+$a.attr("webAppId"),
  				success:function(date){
  					if(date.success){
  						$.scojs_message('删除成功', $.scojs_message.TYPE_OK);
  						//清空行
  						$a.parent().parent().remove();
  					}
  				},error:function (XMLHttpRequest) {
  					$.scojs_message("错误代码："+XMLHttpRequest.status, $.scojs_message.TYPE_ERROR);
				}
			});
		}
	});
	
	//编辑应用服务器的按钮
	$("body").on("click",".webAppServer-edit-btn", function() {
		var $a = $(this);
		$.ajax({
				url:base+'/server/ajax/findWebApp',
				type:'POST',
				data:"id="+$a.attr("webAppId"),
				success:function(date){
					if(date.success){
						var webApp = date.resultData;
						$("#editWebAppForm").find("input[name='appName']").val(webApp.appName);
						$("#editWebAppForm").find("input[name='appRoot']").val(webApp.appRoot);
						$("#editWebAppForm").find("input[name='appUrl']").val(webApp.appUrl);
						$("#editWebAppForm").find("input[name='appDatasource']").val(webApp.appDatasource);
						$("#editWebAppForm").find("input[name='tomcatRoot']").val(webApp.tomcatRoot);
						$("#editWebAppForm").find("input[name='id']").val(webApp.id);
						//显示编辑代理服务器的表单弹出框
						$("#editWebAppModal").modal("show");
					}
				},error:function (XMLHttpRequest) {
					$.scojs_message("错误代码："+XMLHttpRequest.status, $.scojs_message.TYPE_ERROR);
			}
		});
	});
	
	//删除数据库服务器的按钮
	$("body").on("click",".dbServer-del-btn", function() {
		var $a = $(this);
		if(confirm("确定要删除该条记录吗？")){
			$.ajax({
  				url:base+'/server/ajax/operation/delDatabase',
  				type:'POST',
  				data:"id="+$a.attr("databaseId"),
  				success:function(date){
  					if(date.success){
  						$.scojs_message('删除成功', $.scojs_message.TYPE_OK);
  						//清空行
  						$a.parent().parent().remove();
  					}
  				},error:function (XMLHttpRequest) {
  					$.scojs_message("错误代码："+XMLHttpRequest.status, $.scojs_message.TYPE_ERROR);
				}
			});
		}
	});
	
	//编辑数据库服务器的按钮
	$("body").on("click",".dbServer-edit-btn", function() {
		var $a = $(this);
		$.ajax({
				url:base+'/server/ajax/findDatabase',
				type:'POST',
				data:"id="+$a.attr("databaseId"),
				success:function(date){
					if(date.success){
						var database = date.resultData;
						$("#editDatabaseForm").find("input[name='dbSid']").val(database.dbSid);
						$("#editDatabaseForm").find("input[name='dbUser']").val(database.dbUser);
						$("#editDatabaseForm").find("input[name='dbTableSpace']").val(database.dbTableSpace);
						$("#editDatabaseForm").find("input[name='dbTempTableSpace']").val(database.dbTempTableSpace);
						$("#editDatabaseForm").find("input[name='appName']").val(database.appName);
						$("#editDatabaseForm").find("input[name='id']").val(database.id);
						//显示编辑代理服务器的表单弹出框
						$("#editDatabaseModal").modal("show");
					}
				},error:function (XMLHttpRequest) {
					$.scojs_message("错误代码："+XMLHttpRequest.status, $.scojs_message.TYPE_ERROR);
			}
		});
	});
	
	//更换创建人的按钮
	$("body").on("click",".update-Server-CreateUser",function(){
		$.ajax({
			url:base+'/server/ajax/operation/operationList',
			data:"sId="+$("#detail-sId").text(),
			type:'POST',
			success:function(date){
				var $radio = $("#operationListForm").find(".radio");
				if(date.success){
					var operationLis = date.resultData;
					var appendHtml = '';
					for(var i=0;i<operationLis.length;i++){
						appendHtml += '<div class="radio"><label><input type="radio" name="userId" value="'+ operationLis[i].id +'" />'+ operationLis[i].realName +'</label></div>';
					}
					$radio.empty();
					$radio.append(appendHtml);
					//显示编辑代理服务器的表单弹出框
					$("#operationListModal").modal("show");
				}
				
			},
			error:function (XMLHttpRequest) {
				$.scojs_message("错误代码："+XMLHttpRequest.status, $.scojs_message.TYPE_ERROR);
			}
		});
	});
	
});