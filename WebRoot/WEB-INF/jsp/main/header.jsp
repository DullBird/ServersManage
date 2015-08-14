<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-sm-3 col-md-2 sidebar">
	<ul id="myHeader" class="nav nav-sidebar">
		<%-- <li class="active"><a href="#">Overview</a></li>
		<li id="queryDemo"><a href="${base}/demo/queryDemo">表单查询Demo</a></li>
		<li id="pageDemo"><a href="${base}/demo/pageDemo">分页Demo</a></li>
		<li id="addDemo"><a href="${base}/demo/addDemo">添加Demo</a></li> --%>
		<%-- 管理员导航 --%>
		<c:if test="${sessionUser.rId == 1}">
			<li id="addUser"><a href="${base}/user/admin/addUser">添加用户</a></li>
			<li id="userList"><a href="${base}/user/admin/userList">用户列表</a></li>
			<li id="allServerList"><a href="${base}/server/admin/allServerList">服务器列表</a></li>
		</c:if>
		<%-- 运维人员导航 --%>
		<c:if test="${sessionUser.rId == 2}">
			<li id="addServer"><a href="${base}/server/operation/addServer">新增服务器</a></li>
			<li id="myServerList"><a href="${base}/server/operation/myServerList">我的服务器</a></li>
		</c:if>
		<%-- 观察者导航 --%>
		<c:if test="${sessionUser.rId == 3}">
			<li id="myServerList"><a href="${base}/server/watcher/myServerList">我的服务器</a></li>
		</c:if>
		<li id="myInfo"><a href="${base}/user/myInfo">我的信息</a></li>
		<li id="updatePwd"><a href="${base}/user/updatePwd">修改密码</a></li>
	</ul>
</div>
<script>
	$("#myHeader").children("li").removeClass("active");
	$("#${height_light}").addClass("active");
</script>