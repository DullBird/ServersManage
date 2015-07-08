<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>我的信息</title>
</head>
<body>
	<div class="panel panel-default ">
		<div class="panel-heading">我的信息</div>
		<div class="panel-body">
			<form id="addForm" method="post" class="form-horizontal" role="form">
				<div class="form-group">
					<label class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-4">
					<input type="text" class="form-control" value="${user.userName}" disabled>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">真实姓名</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" value="${user.realName}" disabled>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">角色</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" value="${user.roleName}" disabled>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">联系方式</label>
					<div class="col-sm-4">
						<input name="tel" type="text" class="form-control"
							value="${user.tel}" disabled>
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
</body>
</html>
