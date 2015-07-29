$(function(){
	
	//添加代理服务器的按钮
	$("#proxyServer-add-btn").click(function(){
		//显示添加代理服务器的表单弹出框
		$("#addProxyModal").modal("show");
	});
	
	//代理服务器的表单验证
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
  					}else{
  						$.scojs_message('更新失败，请重新更新，若再次失败请联系相关技术人员', $.scojs_message.TYPE_ERROR);
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