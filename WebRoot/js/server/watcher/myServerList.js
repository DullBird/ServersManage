$(function(){
	$('.carousel').carousel({
		//初始化
		interval: false,	//不自动播放
		keyboard:false		//禁止键盘
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
				url:base+'/server/ajax/watcher/serverDetail',
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
	
});