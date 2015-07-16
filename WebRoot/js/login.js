$(function(){
	
	//验证码图片点击事件
	$("#verifyCodeImg").click(function(){
		$(this).hide().attr("src", base+"/verifyCode?" + Math.floor(Math.random()*100) ).fadeIn();
	});
	
	$.validator.setDefaults({
		submitHandler: function() {
			var currentForm = $(this.currentForm);
  			$.ajax({
  				url:base+'/ajaxLogin',
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
			verifyCode:{required:"请填验证码"}
		}
	});
	
});