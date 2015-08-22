<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>在线用户列表</title>
	</head>
	<body>
		<div class="panel panel-default">
  			<div class="panel-heading">在线用户列表</div>
  			<form name="pageForm" action="${base}/user/admin/onlineUserList" method="post" >
  				<input type="hidden" name="toPage" value="1" />
  			</form>
			<!-- 用户列表表格 -->
			<table class="table table-hover">
				<tbody>
					<tr>
						<th width="10%">序号</th>
						<th width="10%">ID</th>
						<th width="25%">用户名</th>
						<th width="20%">真实姓名</th>
						<th width="20%">联系电话</th>
						<th width="15%">角色</th>
					</tr>
					<%-- 后台获取的数据 --%>
					<c:forEach var="user" items="${pageBean.objLists}" varStatus="step">
						<tr>
							<td>${step.count}</td>
							<td>${user.id}</td>
							<td>${user.userName}</td>
							<td>${user.realName}</td>
							<td>${user.tel}</td>
							<td>${user.roleName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="panel-body">
				<c:import url="../../main/page.jsp"></c:import>
			</div>
			<!-- 用户列表表格 -->
  		</div>
	</body>
</html>