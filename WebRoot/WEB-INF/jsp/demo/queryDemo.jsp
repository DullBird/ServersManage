<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>条件查询Demo</title>
    <style type="text/css">
    	.tableDiv{
    		margin-top: 20px;
    	}
    </style>
  </head>
  <body>
  	<form class="form-inline" action="${base}/demo/queryDemo" role="form" method="post">
  		<div class="form-group">
  			<div class="input-group">
  				<div class="input-group-addon">管理员</div>
     			<input name="trueName" value="${trueName}" class="form-control" type="text" placeholder="请填写管理员的真实姓名" />
     		</div>
  		</div>
  		<button type="submit" class="btn btn-primary">搜索</button>
  	</form>
  	<div class="tableDiv">
  		<div class="panel panel-primary">
  			<div class="panel-heading">用户详情</div>
	  		<c:if test="${user != null}">
		  		<table class="table table-bordered">
			  		<tbody>
			  			<tr>
			  				<td>登录名</td>
			  				<td>${user.loginName}</td>
			  			</tr>
			  			<tr>
			  				<td>操作员</td>
			  				<td>${user.trueName}</td>
			  			</tr>
			  			<tr>
			  				<td>角色</td>
			  				<td>
			  					<c:if test="${user.roleId==1}">超级管理员</c:if>
			  					<c:if test="${user.roleId!=1}">普通管理员</c:if>
			  				</td>
			  			</tr>
			  			<tr>
			  				<td>状态</td>
			  				<td>
								<c:if test="${user.status==1}">正常</c:if>
			  					<c:if test="${user.status!=1}">冻结</c:if>
							</td>
			  			</tr>
			  		</tbody>
			  	</table>
	  		</c:if>
	  		<c:if test="${user == null}">
	  			<table class="table table-bordered">
			  		<tbody>
			  			<tr>
			  				<td>没有数据</td>
			  			</tr>
			  		</tbody>
			  	</table>
	  		</c:if>
	  	</div>
  	</div>
  </body>
</html>
