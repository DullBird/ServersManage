<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>添加用户</title>
    <link rel="stylesheet" href="${base}/js/sco.js/css/sco.message.css">
    <script type="text/javascript" src="${base}/js/sco.js/js/sco.message.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${base}/js/bootstrap3.2.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${base}/js/jQuery.Hz2Py-min.js"></script>
  </head>
  <body>
  	<div class="panel panel-default ">
  		<div class="panel-heading">新增服务器</div>
  		<div class="panel-body">
		  	<form id="addForm" method="post" class="form-horizontal" role="form">
		  		<div class="form-group">
				    <label class="col-sm-2 control-label">用户名</label>
				    <div class="col-sm-4">
				      <input name="userName" id="userName" type="text" class="form-control" placeholder="*默认是真实姓名的全拼，用于系统登录" readonly>
				    </div>
				</div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">真实姓名</label>
				    <div class="col-sm-4">
				      <input name="realName" id="realName" type="text" class="form-control" placeholder="*请填写您的真实姓名，用户名会自动补全">
				    </div>
				</div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">密码</label>
				    <div class="col-sm-4">
				      <input name="passWord" id="passWord" type="password" class="form-control" placeholder="*请填写您的登录密码">
				    </div>
				</div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">请再次输入</label>
				    <div class="col-sm-4">
				      <input name="repassWord" id="repassWord" type="password" class="form-control" placeholder="*请再次填写您的登录密码">
				    </div>
				</div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">角色</label>
				    <div class="col-sm-4">
				    	<select name="rId" class="form-control">
				    		<c:forEach var="role" items="${roleList}">
				    			<option value="${role.id}">${role.name}</option>
				    		</c:forEach>
						</select>
				    </div>
				</div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">联系方式</label>
				    <div class="col-sm-4">
				      <input name="tel" type="text" class="form-control" placeholder="填写您的手机号码或座机号">
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
