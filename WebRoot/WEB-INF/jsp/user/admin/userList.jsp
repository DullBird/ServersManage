<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>用户列表</title>
		<script src="${base}/js/user/admin/userDetail.js"></script>
	</head>
	<body>
		<div class="panel panel-default">
  			<div class="panel-heading">用户列表</div>
  			<div class="panel-body">
  				<!-- 搜索的表单 -->
  				<form class="form-inline" name="pageForm" action="${base}/user/admin/userList" method="post" >
  					<input type="hidden" name="toPage" value="1" />
  					<div class="form-group">
  						<div class="input-group">
  							<div class="input-group-addon">真实姓名</div>
					    	<input name="realName" type="text" value="${user.realName}" class="form-control" >
					    </div>
					  </div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">联系电话</div>
					    	<input name="tel" type="text" value="${user.tel}" class="form-control" >
					    </div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">角色</div>
					    	<select name="rId" class="form-control">
					    		<option value="">全部</option>
					    		<c:forEach var="role" items="${roleList}">
					    			<option value="${role.id}" <c:if test="${user.rId==role.id}">selected="selected"</c:if> >${role.name}</option>
					    		</c:forEach>
							</select>
					    </div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">状态</div>
					    	<select name="status" class="form-control">
					    		<option value="">全部</option>
					    		<option <c:if test="${user.status==1}">selected="selected"</c:if> value="1">正常</option>
					    		<option <c:if test="${user.status==0}">selected="selected"</c:if> value="0">删除</option>
							</select>
					    </div>
					</div>
					<button type="submit" class="btn btn-primary">查询</button>
  				</form>
  				<!-- 搜索的表单 -->
  			</div>
			<!-- 用户列表表格 -->
			<table class="table table-hover">
				<tbody>
					<tr>
						<th>序号</th>
						<th>真实姓名</th>
						<th>联系电话</th>
						<th>角色</th>
						<th>状态</th>
						<th>创建时间</th>
						<th>详情</th>
					</tr>
					<%-- 后台获取的数据 --%>
					<c:forEach var="user" items="${pageBean.objLists}" varStatus="step">
						<tr>
							<td>${step.count}</td>
							<td>${user.realName}</td>
							<td>${user.tel}</td>
							<td>${user.roleName}</td>
							<td id="deleteUser-td-${user.id}">
								<c:if test="${user.status==1}">正常</c:if>
								<c:if test="${user.status==0}">删除</c:if>
							</td>
							<td>${user.createDate}</td>
							<td><a href="javascript:showModal('${base}/user/ajax/admin/userDetail?id=${user.id}');">查看</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="panel-body">
				<c:import url="../../main/page.jsp"></c:import>
			</div>
			<!-- 用户列表表格 -->
  		</div>
  		<!-- 详情的弹出框 -->
  		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		    </div>
		  </div>
		</div>
		<!-- 详情的弹出框 -->
	</body>
</html>