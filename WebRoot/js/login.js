$(function(){
	
	//验证码图片点击事件
	$("#verifyCodeImg").click(function(){
		$(this).hide().attr("src", base+"/verifyCode?" + Math.floor(Math.random()*100) ).fadeIn();
	});
	
	$.validator.setDefaults({
		submitHandler: function() {
			var currentForm = $(this.currentForm);
			var $btn = $(currentForm).find("button[type='submit']");
			$btn.attr("disabled","disabled");
  			$.ajax({
  				url:base+'/ajaxLogin',
  				type:'POST',
  				data:$(currentForm).serialize(),
  				success:function(date){
  					if(date.success){
  						//登录成功跳转到后台欢迎页
  						location.href = base + "/user/welcome";
  					}else{
  						$.scojs_message(date.errorMsg, $.scojs_message.TYPE_ERROR);
  						//错误后重置表单，重新获取验证码
  						$(currentForm)[0].reset();
  						$("#verifyCodeImg").click();
  					}
  				},
  				error:function (XMLHttpRequest) {
  					$.scojs_message("错误代码："+XMLHttpRequest.status, $.scojs_message.TYPE_ERROR);
				},
				complete:function(){
					//解除按钮
					$btn.removeAttr("disabled");
				}
  			});
  			return false;
		},
		errorElement:"div",
		wrapper:"div",
		errorPlacement:function(error,element) {
			$(error).addClass("popover fade right in").css("left","5px");
			$(error).children().addClass("popover-content");
			$(error).prepend('<div class="arrow"></div>');
			$(error).appendTo(element.parent().parent().parent().find(".col-sm-4"));
		}
	});

	$("#loginForm").validate({
		rules:{
			userName:{required:true},
			passWord:{required:true},
			verifyCode:{required:true}
			},
		messages:{
			userName:{required:"请填写用户名"},
			passWord:{required:"请填写密码"},
			verifyCode:{required:"请填写验证码"}
		}
	});
	
});