$(function(){
	
	//添加代理服务器的按钮
	$("#proxyServer-add-btn").click(function(){
		//显示添加代理服务器的表单弹出框
		$("#addProxyModal").modal("show");
	});
	
	//添加应用服务器的按钮
	$("#webAppServer-add-btn").click(function(){
		$("#addWebAppModal").modal("show");
	});
	
	//添加数据库服务器的按钮
	$("#dbServer-add-btn").click(function(){
		$("#addDatabaseModal").modal("show");
	});
	
	
	
	//添加代理服务器的表单验证
	$("#addProxyForm").validate({
		rules:{
			vhostName:{required:true},
			vhostDomain:{required:true},
			vhostRoot:{required:true},
			vhostLogs:{required:true}
		},
		messages:{
			vhostName:{required:"请填写虚拟主机名"},
			vhostDomain:{required:"请填写访问域名"},
			vhostRoot:{required:"请填写根路径"},
			vhostLogs:{required:"请填写日志路径"}
		},
		submitHandler: function() {
			var currentForm = $(this.currentForm);
  			$.ajax({
  				url:base+'/server/ajax/operation/addProxy',
  				type:'POST',
  				data:$(currentForm).serialize(),
  				success:function(date){
  					if(date.success){
  						$.scojs_message('更新成功', $.scojs_message.TYPE_OK);
  						//清空表单，关闭弹出框，刷新代理服务器table
  						$(currentForm)[0].reset();
  						$("#addProxyModal").modal("hide");
  						var proxy = date.resultData;
  						var addProxyHtml = "<tr>"+
  						"<td>"+proxy.vhostName+"</td>"+
  						"<td>"+proxy.vhostDomain+"</td>"+
  						"<td>"+proxy.vhostRoot+"</td>"+
  						"<td>"+proxy.vhostLogs+"</td>"+
  						"<td>"+proxy.createDate+"</td>" +
  						"<td>" +
  							"<a class='proxyServer-del-btn no-text-decoration' proxyId='"+proxy.id+"' title='删除' onfocus='this.blur();' href='javascript:void(0);'><span class='glyphicon glyphicon-minus-sign' aria-hidden='true'></span></a> " +
  							"<a class='proxyServer-edit-btn no-text-decoration' proxyId='"+proxy.id+"' title='编辑' onfocus='this.blur();' href='javascript:void(0);'><span class='glyphicon glyphicon-edit' aria-hidden='true'></span></a>" +
  						"</td></tr>";
  						$("#proxyServer-add-btn").parent().parent().before(addProxyHtml);
  					}else{
  						$.scojs_message(date.errorMsg, $.scojs_message.TYPE_ERROR);
  					}
  				},error:function (XMLHttpRequest) {
  					$.scojs_message("错误代码："+XMLHttpRequest.status, $.scojs_message.TYPE_ERROR);
				}
  			});
  			return false;
		},
		errorElement:"div",
		wrapper:"div",
		errorPlacement:function(error,element) {
	    $(error).addClass("popover fade right in").css("left","-10px").css("top","-3px");
	    $(error).children().addClass("popover-content");
	    $(error).prepend('<div class="arrow"></div>');
			$(error).appendTo(element.parent().parent().find(".my-col-sm-3"));
		}
	});
	
	//修改代理服务器的表单验证
	$("#editProxyForm").validate({
		rules:{
			vhostName:{required:true},
			vhostDomain:{required:true},
			vhostRoot:{required:true},
			vhostLogs:{required:true}
		},
		messages:{
			vhostName:{required:"请填写虚拟主机名"},
			vhostDomain:{required:"请填写访问域名"},
			vhostRoot:{required:"请填写根路径"},
			vhostLogs:{required:"请填写日志路径"}
		},
		submitHandler: function() {
			var currentForm = $(this.currentForm);
  			$.ajax({
  				url:base+'/server/ajax/operation/editProxy',
  				type:'POST',
  				data:$(currentForm).serialize(),
  				success:function(date){
  					if(date.success){
  						$.scojs_message('更新成功', $.scojs_message.TYPE_OK);
  						//清空表单，关闭弹出框，刷新代理服务器table
  						$(currentForm)[0].reset();
  						$("#editProxyModal").modal("hide");
  						var proxy = date.resultData;
  						var $td = $(".proxyTable").find("a[proxyId='"+ proxy.id +"']").parent().parent().find("td");
  						$td.eq(0).text(proxy.vhostName);
  						$td.eq(1).text(proxy.vhostDomain);
  						$td.eq(2).text(proxy.vhostRoot);
  						$td.eq(3).text(proxy.vhostLogs);
  					}else{
  						$.scojs_message(date.errorMsg, $.scojs_message.TYPE_ERROR);
  					}
  				},error:function (XMLHttpRequest) {
  					$.scojs_message("错误代码："+XMLHttpRequest.status, $.scojs_message.TYPE_ERROR);
				}
  			});
  			return false;
		},
		errorElement:"div",
		wrapper:"div",
		errorPlacement:function(error,element) {
	    $(error).addClass("popover fade right in").css("left","-10px").css("top","-3px");
	    $(error).children().addClass("popover-content");
	    $(error).prepend('<div class="arrow"></div>');
			$(error).appendTo(element.parent().parent().find(".my-col-sm-3"));
		}
	});
	
	//添加应用服务器的表单验证
	$("#addWebAppForm").validate({
		rules:{
			appName:{required:true},
			appRoot:{required:true},
			appUrl:{required:true},
			appDatasource:{required:true},
			tomcatRoot:{required:true}
		},
		messages:{
			appName:{required:"请填写应用名称"},
			appRoot:{required:"请填写应用根路径"},
			appUrl:{required:"请填写应用访问路径"},
			appDatasource:{required:"请填写应用数据源"},
			tomcatRoot:{required:"请填写部署的tomcat路径"}
		},
		submitHandler: function() {
			var currentForm = $(this.currentForm);
  			$.ajax({
  				url:base+'/server/ajax/operation/addWebApp',
  				type:'POST',
  				data:$(currentForm).serialize(),
  				success:function(date){
  					if(date.success){
  						$.scojs_message('更新成功', $.scojs_message.TYPE_OK);
  						//清空表单，关闭弹出框，刷新代理服务器table
  						$(currentForm)[0].reset();
  						$("#addWebAppModal").modal("hide");
  						var webApp = date.resultData;
  						var addWebAppHtml = "<tr>"+
  						"<td>"+webApp.appName+"</td>"+
  						"<td>"+webApp.appRoot+"</td>"+
  						"<td>"+webApp.appUrl+"</td>"+
  						"<td>"+webApp.appDatasource+"</td>"+
  						"<td>"+webApp.tomcatRoot+"</td>" +
  						"<td>"+webApp.createDate+"</td>" +
  						"<td>" +
  							"<a class='webAppServer-del-btn no-text-decoration' webAppId='"+webApp.id+"' title='删除' onfocus='this.blur();' href='javascript:void(0);'><span class='glyphicon glyphicon-minus-sign' aria-hidden='true'></span></a> " +
  							"<a class='webAppServer-edit-btn no-text-decoration' webAppId='"+webApp.id+"' title='编辑' onfocus='this.blur();' href='javascript:void(0);'><span class='glyphicon glyphicon-edit' aria-hidden='true'></span></a> " +
  							"<a class='webAppServer-more-btn no-text-decoration' webAppId='"+webApp.id+"' title='更多' onfocus='this.blur();' href='javascript:void(0);'><span class='glyphicon glyphicon-info-sign' aria-hidden='true'></span></a>"+
  						"</td></tr>";
  						$("#webAppServer-add-btn").parent().parent().before(addWebAppHtml);
  					}else{
  						$.scojs_message(date.errorMsg, $.scojs_message.TYPE_ERROR);
  					}
  				},error:function (XMLHttpRequest) {
  					$.scojs_message("错误代码："+XMLHttpRequest.status, $.scojs_message.TYPE_ERROR);
				}
  			});
  			return false;
		},
		errorElement:"div",
		wrapper:"div",
		errorPlacement:function(error,element) {
	    $(error).addClass("popover fade right in").css("left","-10px").css("top","-3px");
	    $(error).children().addClass("popover-content");
	    $(error).prepend('<div class="arrow"></div>');
			$(error).appendTo(element.parent().parent().find(".my-col-sm-3"));
		}
	});
	
	//修改应用服务器的表单验证
	$("#editWebAppForm").validate({
		rules:{
			appName:{required:true},
			appRoot:{required:true},
			appUrl:{required:true},
			appDatasource:{required:true},
			tomcatRoot:{required:true}
		},
		messages:{
			appName:{required:"请填写应用名称"},
			appRoot:{required:"请填写应用根路径"},
			appUrl:{required:"请填写应用访问路径"},
			appDatasource:{required:"请填写应用数据源"},
			tomcatRoot:{required:"请填写部署的tomcat路径"}
		},
		submitHandler: function() {
			var currentForm = $(this.currentForm);
  			$.ajax({
  				url:base+'/server/ajax/operation/editWebApp',
  				type:'POST',
  				data:$(currentForm).serialize(),
  				success:function(date){
  					if(date.success){
  						$.scojs_message('更新成功', $.scojs_message.TYPE_OK);
  						//清空表单，关闭弹出框，刷新代理服务器table
  						$(currentForm)[0].reset();
  						$("#editWebAppModal").modal("hide");
  						var webApp = date.resultData;
  						var $td = $(".webAppTable").find("a[webAppId='"+ webApp.id +"']").parent().parent().find("td");
  						$td.eq(0).text(webApp.appName);
  						$td.eq(1).text(webApp.appRoot);
  						$td.eq(2).text(webApp.appUrl);
  						$td.eq(3).text(webApp.appDatasource);
  						$td.eq(4).text(webApp.tomcatRoot);
  					}else{
  						$.scojs_message(date.errorMsg, $.scojs_message.TYPE_ERROR);
  					}
  				},error:function (XMLHttpRequest) {
  					$.scojs_message("错误代码："+XMLHttpRequest.status, $.scojs_message.TYPE_ERROR);
				}
  			});
  			return false;
		},
		errorElement:"div",
		wrapper:"div",
		errorPlacement:function(error,element) {
	    $(error).addClass("popover fade right in").css("left","-10px").css("top","-3px");
	    $(error).children().addClass("popover-content");
	    $(error).prepend('<div class="arrow"></div>');
			$(error).appendTo(element.parent().parent().find(".my-col-sm-3"));
		}
	});
	
	//添加数据库服务器的表单验证
	$("#addDatabaseForm").validate({
		rules:{
			dbSid:{required:true},
			dbUser:{required:true},
			dbTableSpace:{required:true},
			dbTempTableSpace:{required:true}
		},
		messages:{
			dbSid:{required:"请填数据库的实例名"},
			dbUser:{required:"请填数据库用户"},
			dbTableSpace:{required:"请填默认表空间"},
			dbTempTableSpace:{required:"请填临时表空间"}
		},
		submitHandler: function() {
			var currentForm = $(this.currentForm);
  			$.ajax({
  				url:base+'/server/ajax/operation/addDatabase',
  				type:'POST',
  				data:$(currentForm).serialize(),
  				success:function(date){
  					if(date.success){
  						$.scojs_message('更新成功', $.scojs_message.TYPE_OK);
  						//清空表单，关闭弹出框，刷新代理服务器table
  						$(currentForm)[0].reset();
  						$("#addDatabaseModal").modal("hide");
  						var database = date.resultData;
  						var addDatabaseHtml = "<tr>"+
  						"<td>"+database.dbSid+"</td>"+
  						"<td>"+database.dbUser+"</td>"+
  						"<td>"+database.dbTableSpace+"</td>"+
  						"<td>"+database.dbTempTableSpace+"</td>"+
  						"<td>"+database.createDate+"</td>" +
  						"<td>" +
  							"<a class='dbServer-del-btn no-text-decoration' databaseId='"+database.id+"' title='删除' onfocus='this.blur();' href='javascript:void(0);'><span class='glyphicon glyphicon-minus-sign' aria-hidden='true'></span></a> " +
  							"<a class='dbServer-edit-btn no-text-decoration' databaseId='"+database.id+"' title='编辑' onfocus='this.blur();' href='javascript:void(0);'><span class='glyphicon glyphicon-edit' aria-hidden='true'></span></a>" +
  						"</td></tr>";
  						$("#dbServer-add-btn").parent().parent().before(addDatabaseHtml);
  					}else{
  						$.scojs_message(date.errorMsg, $.scojs_message.TYPE_ERROR);
  					}
  				},error:function (XMLHttpRequest) {
  					$.scojs_message("错误代码："+XMLHttpRequest.status, $.scojs_message.TYPE_ERROR);
				}
  			});
  			return false;
		},
		errorElement:"div",
		wrapper:"div",
		errorPlacement:function(error,element) {
	    $(error).addClass("popover fade right in").css("left","-10px").css("top","-3px");
	    $(error).children().addClass("popover-content");
	    $(error).prepend('<div class="arrow"></div>');
			$(error).appendTo(element.parent().parent().find(".my-col-sm-3"));
		}
	});
	
	//修改数据库服务器的表单验证
	$("#editDatabaseForm").validate({
		rules:{
			dbSid:{required:true},
			dbUser:{required:true},
			dbTableSpace:{required:true},
			dbTempTableSpace:{required:true}
		},
		messages:{
			dbSid:{required:"请填数据库的实例名"},
			dbUser:{required:"请填数据库用户"},
			dbTableSpace:{required:"请填默认表空间"},
			dbTempTableSpace:{required:"请填临时表空间"}
		},
		submitHandler: function() {
			var currentForm = $(this.currentForm);
  			$.ajax({
  				url:base+'/server/ajax/operation/editDatabase',
  				type:'POST',
  				data:$(currentForm).serialize(),
  				success:function(date){
  					if(date.success){
  						$.scojs_message('更新成功', $.scojs_message.TYPE_OK);
  						//清空表单，关闭弹出框，刷新代理服务器table
  						$(currentForm)[0].reset();
  						$("#editDatabaseModal").modal("hide");
  						var database = date.resultData;
  						var $td = $(".databaseTable").find("a[databaseId='"+ database.id +"']").parent().parent().find("td");
  						$td.eq(0).text(database.dbSid);
  						$td.eq(1).text(database.dbUser);
  						$td.eq(2).text(database.dbTableSpace);
  						$td.eq(3).text(database.dbTempTableSpace);
  					}else{
  						$.scojs_message(date.errorMsg, $.scojs_message.TYPE_ERROR);
  					}
  				},error:function (XMLHttpRequest) {
  					$.scojs_message("错误代码："+XMLHttpRequest.status, $.scojs_message.TYPE_ERROR);
				}
  			});
  			return false;
		},
		errorElement:"div",
		wrapper:"div",
		errorPlacement:function(error,element) {
	    $(error).addClass("popover fade right in").css("left","-10px").css("top","-3px");
	    $(error).children().addClass("popover-content");
	    $(error).prepend('<div class="arrow"></div>');
			$(error).appendTo(element.parent().parent().find(".my-col-sm-3"));
		}
	});
	
});