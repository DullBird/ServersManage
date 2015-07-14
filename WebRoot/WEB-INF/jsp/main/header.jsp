<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="col-sm-3 col-md-2 sidebar">
	<ul id="myHeader" class="nav nav-sidebar">
		<%-- <li class="active"><a href="#">Overview</a></li>
		<li id="queryDemo"><a href="${base}/demo/queryDemo">表单查询Demo</a></li>
		<li id="pageDemo"><a href="${base}/demo/pageDemo">分页Demo</a></li>
		<li id="addDemo"><a href="${base}/demo/addDemo">添加Demo</a></li> --%>
		<li id="addUser"><a href="${base}/user/admin/addUser">添加用户</a></li>
		<li id="userList"><a href="${base}/user/admin/userList">用户列表</a></li>
		<li id="addServer"><a href="${base}/server/operation/addServer">新增服务器</a></li>
		<li id="allServerList"><a href="${base}/server/admin/allServerList">服务器列表</a></li>
		<li id="myServerList"><a href="${base}/server/operation/myServerList">我的服务器</a></li>
		<li id="myInfo"><a href="${base}/user/myInfo">我的信息</a></li>
		<li id="updatePwd"><a href="${base}/user/updatePwd">修改密码</a></li>
		<li><a href="#">Overview</a></li>
		<li><a href="#">Overview</a></li>
		<li><a href="#">Overview</a></li>
	</ul>
</div>
<script>
	//左边导航栏的高亮js
	/* $("#myHeader").children("li").each(function(){
		$(this).click(function(){
			$(this).siblings().removeClass("active");
			$(this).addClass("active");
		});
	}); */
	$("#myHeader").children("li").removeClass("active");
	$("#${height_light}").addClass("active");
</script>