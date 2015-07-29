$(function(){
	
	//隐藏id为isVirtualDiv模块
	function hideForIsVirtualDiv(){
		$("#isVirtualDiv").hide();
		$("#model").prop("disabled","disabled");
		$("#services").prop("disabled","disabled");
		$("#postDeviceCode").prop("disabled","disabled");
	}
	
	function showForIsVirtualDiv(){
		$("#isVirtualDiv").show();
		$("#model").removeProp("disabled");
		$("#services").removeProp("disabled");
		$("#postDeviceCode").removeProp("disabled");
	}
	
	//设定是否虚拟机下来选项的改变事件
	$("#isVirtual").change(function(){
		if($(this).val()==1){
			//是虚拟设备隐藏div
			hideForIsVirtualDiv();
		}else{
			//不是虚拟设备显示div
			showForIsVirtualDiv();
		}
		
	});
	
	//isVirtualDiv的初始化
	function isVirtualDivInit(){
		if($("#isVirtual").val()==1){
			//是虚拟设备隐藏div
			hideForIsVirtualDiv();
		}else{
			showForIsVirtualDiv();
		}
	}
	
	//初始化
	isVirtualDivInit();
	
	$("#updateForm").validate({
		rules:{
			name:{required:true},
			cpu:{required:true},
			memory:{required:true},
			hardDisk:{required:true},
			ip:{required:true},
			os:{required:true},
			model:{required:true},
			services:{required:true}
			},
		messages:{
			name:{required:"请填写主机名"},
			cpu:{required:"请填写主机的cpu配置"},
			memory:{required:"请填写主机的内存配置"},
			hardDisk:{required:"请填写主机的硬盘配置"},
			ip:{required:"请填写主机的ip地址"},
			os:{required:"请填写主机安装的操作系统"},
			model:{required:"请填写服务器的型号"},
			services:{required:"请填写服务器的服务编码"}
		},
		submitHandler: function() {
			var currentForm = $(this.currentForm);
  			$.ajax({
  				url:base+'/server/ajax/operation/update',
  				type:'POST',
  				data:$(currentForm).serialize(),
  				success:function(date){
  					if(date.success){
  						$.scojs_message('更新成功', $.scojs_message.TYPE_OK);
  						//重置id，让系统重新加载
  						$("#detail-sId").text("-1");
  						$("#server-detail-btn-"+$("input[name='id']").val()).click();
  						//$(".carousel").carousel('prev');
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
			$(error).appendTo(element.parent().parent().find(".my-col-sm-4"));
		}
	});
});