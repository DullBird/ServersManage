$(function(){
	//绑定modal的隐藏时间，隐藏后清除缓存
	$("#myModal").on("hidden.bs.modal", function() {
	    $(this).removeData("bs.modal");
	});
	
});

/**
 * 显示提出框
 * 把弹出框的id设为myModal即可
 */
function showModal(url){
	//设置远程加载数据
	$("#myModal").modal({
		remote:url
	});
	//显示弹出框
	$("#myModal").modal("show");
}
