$(function(){
	
	$("body").on("click",".webAppServer-more-btn",function(){
		var $a = $(this);
		$.ajax({
				url:base+'/server/ajax/findWebApp',
				type:'POST',
				data:"id="+$a.attr("webAppId"),
				success:function(date){
					if(date.success){
						var webApp = date.resultData;
						var $tr = $("#webAppInfoTable").find("tr");
						$tr.eq(1).find("td").text(webApp.id);
						$tr.eq(2).find("td").text(webApp.appName);
						$tr.eq(3).find("td").text(webApp.appRoot);
						$tr.eq(4).find("td").text(webApp.appUrl);
						$tr.eq(5).find("td").text(webApp.appDatasource);
						$tr.eq(6).find("td").text(webApp.tomcatRoot);
						$tr.eq(7).find("td").text(webApp.createDate);
						//显示编辑代理服务器的表单弹出框
						$("#webAppInfoModal").modal("show");
					}
				},error:function (XMLHttpRequest) {
					$.scojs_message("错误代码："+XMLHttpRequest.status, $.scojs_message.TYPE_ERROR);
			}
		});
		
	});
	
});