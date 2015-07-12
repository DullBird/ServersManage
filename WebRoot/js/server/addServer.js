$(function(){
	myInit();
	
	//协助人员全选事件
	$("#allUser-checkbox").click(function(){
		if($("#allUser-checkbox").is(":checked")){
			$("input[name='userIdList']").prop("checked","checked");
		}else{
			$("input[name='userIdList']").removeProp("checked");
		}
	});
	
	//为所有协助人员checkbox绑定点击事件，避免取消一个选项，全选依然选中
	$("input[name='userIdList']").each(function(index,domEle) {
		$(domEle).click(function(){
			if(!$(this).is(":checked")){
				$("#allUser-checkbox").removeProp("checked");
			}
		});
	});
	
	//隐藏id为isVirtualDiv模块
	function hideForIsVirtualDiv(){
		$("#isVirtualDiv").hide();
		$("#model").prop("disabled","disabled");
		$("#services").prop("disabled","disabled");
	}
	
	function showForIsVirtualDiv(){
		$("#isVirtualDiv").show();
		$("#model").removeProp("disabled");
		$("#services").removeProp("disabled");
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
	
	//初始化，防止选了是虚拟机，F5刷新页面依然显示型号，服务编号，邮政设备号的div
	function myInit(){
		isVirtualDivInit();
	}
	
	$.validator.setDefaults({
			submitHandler: function() {
				var currentForm = $(this.currentForm);
	  			$.ajax({
	  				url:base+'/server/ajax/operation/addServer',
	  				type:'POST',
	  				data:$(currentForm).serialize(),
	  				success:function(date){
	  					if(date.success){
	  						$.scojs_message('添加成功，请到服务器列表查看详情', $.scojs_message.TYPE_OK);
	  						$(currentForm)[0].reset();
	  					}else{
	  						$.scojs_message('参数异常', $.scojs_message.TYPE_ERROR);
	  					}
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
	
	$("#addForm").validate({
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
		}
	});
	
});

