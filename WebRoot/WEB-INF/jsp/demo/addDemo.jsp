<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>添加Demo</title>
    <link rel="stylesheet" href="${base}/js/sco.js/css/sco.message.css">
    <script type="text/javascript" src="${base}/js/sco.js/js/sco.message.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${base}/js/bootstrap3.2.0/js/bootstrap.min.js"></script>
  </head>
  <body>
  	<form id="addForm" method="post" class="form-horizontal" role="form">
  		<div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">日志</label>
		    <div class="col-sm-4">
		      <input name="log" type="text" class="form-control">
		    </div>
		</div>
		<div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">角色</label>
		    <div class="col-sm-4">
		      <input name="roleName" type="text" class="form-control">
		    </div>
		</div>
		<div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">服务器名</label>
		    <div class="col-sm-4">
		      <input name="serverName" type="text" class="form-control">
		    </div>
		</div>
		<div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">操作员</label>
		    <div class="col-sm-4">
		      <input name="trueName" type="text" class="form-control">
		    </div>
		</div>
		<div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">提交</button>
		      <button type="reset" class="btn btn-default">重置</button>
		    </div>
		 </div>
  	</form>
  	<script type="text/javascript">
  		$.validator.setDefaults({
  			submitHandler: function() {
  				var currentForm = $(this.currentForm);
	  			$.ajax({
	  				url:'${base}/demo/add',
	  				type:'POST',
	  				data:$(currentForm).serialize(),
	  				success:function(date){
	  					if(date.success){
	  						$.scojs_message('添加成功', $.scojs_message.TYPE_OK);
	  						$(currentForm)[0].reset();
	  					}else{
	  						$.scojs_message('参数异常', $.scojs_message.TYPE_ERROR);
	  					}
	  				}
	  			});
	  			return false;
  			},
  			showErrors: function(map, list) {
  				var focussed = document.activeElement;
  				if (focussed && $(focussed).is("input, textarea")) {
  					$(focussed).popover('hide');
  				}
  				$.each(list, function(index, error) {
  					$(error.element).popover({
  						content:error.message,
  						trigger: 'manual',
  						placement:'right',
  						container:'body'
  					}).popover('show');
  				});
  			}
  		});
  	
  		(function() {
  			$("#addForm").validate({
  				rules:{
  					roleName:"required",
  					trueName:"required"
  					},
  				messages:{
  					roleName:"角色名不能为空",
  					trueName:"真实姓名不能为空"
  				}
  			});
  		})();
  		
  	</script>
  </body>
</html>
