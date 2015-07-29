$(function(){
	$('.carousel').carousel({
		//初始化，不自动轮播
		interval: false
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
					$(".myServer-detail").find(".panel").find("table").remove();
					//翻页
					$(".carousel").carousel(1);
					$(".myServer-detail").find(".panel").append(date);
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
	
});