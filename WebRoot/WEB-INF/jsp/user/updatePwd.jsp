<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>修改密码</title>
		<link rel="stylesheet" href="${base}/js/sco.js/css/sco.message.css">
		<script type="text/javascript" src="${base}/js/sco.js/js/sco.message.js"></script>
    	<script type="text/javascript" src="${base}/js/jquery.validate.min.js"></script>
    	<script type="text/javascript" src="${base}/js/bootstrap3.2.0/js/bootstrap.min.js"></script>
	</head>
	<body>
	<div class="panel panel-default ">
		<div class="panel-heading">我的信息</div>
		<div class="panel-body">
			<form id="updatePwdForm" method="post" class="form-horizontal" role="form">
				<div class="form-group">
					<label class="col-sm-2 control-label">旧密码</label>
					<div class="col-sm-4">
						<input name="oldPwd" id="oldPwd" type="password" class="form-control" placeholder="*请输入旧密码">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">新密码</label>
					<div class="col-sm-4">
						<input name="newPwd" id="newPwd" type="password" class="form-control" placeholder="*请输入新密码">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">再次输入</label>
					<div class="col-sm-4">
						<input name="reNewPwd" id="reNewPwd" type="password" class="form-control" placeholder="*请再次输入新密码">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">提交</button>
						<button type="reset" class="btn btn-default">重置</button>
					</div>
				</div>
			</form>
		</div>
		<script type="text/javascript">
			$.validator.setDefaults({
				submitHandler : function() {
					var currentForm = $(this.currentForm);
					$.ajax({
						url : '${base}/user/ajax/updatePwd',
						type : 'POST',
						data : $(currentForm).serialize(),
						success : function(date) {
							if (date.success) {
								$.scojs_message('修改成功',$.scojs_message.TYPE_OK);
								$(currentForm)[0].reset();
							} else {
								$.scojs_message(date.errorMsg,$.scojs_message.TYPE_ERROR);
							}
						}
					});
					return false;
				},
				showErrors : function(map, list) {
					var focussed = document.activeElement;
					if (focussed && $(focussed).is("input, textarea")) {
						$(focussed).popover('hide');
					}
					$.each(list, function(index, error) {
						$(error.element).popover({
							content : error.message,
							trigger : 'manual',
							placement : 'right',
							container : 'body'
						}).popover('show');
					});
				}
			});

			(function() {
				$("#updatePwdForm").validate({
					rules : {
						oldPwd : "required",
						newPwd : {
							required : true,
							minlength : 6
						},
						reNewPwd : {
							equalTo : "#newPwd"
						}
					},
					messages : {
						oldPwd : {
							required : "请输入旧密码",
						},
						newPwd : {
							required : "新密码不能为空",
							minlength : "至少输入6个数字或字母"
						},
						reNewPwd : {
							equalTo : "两次密码输入不相同"
						}
					}
				});

			})();
		</script>
	</body>
</html>
