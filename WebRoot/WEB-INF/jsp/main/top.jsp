<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div role="navigation" class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"><strong>服务器管理系统</strong></a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${base}/user/welcome" onfocus="this.blur();" title="重新载入页面"><span class="glyphicon glyphicon-refresh"></span></a></li>
				<li>
					<a href="javascript:void(0);" title="用户信息" onfocus="this.blur();" data-toggle="dropdown" ><span class="glyphicon glyphicon-user"></span></a>
					<ul class="dropdown-menu dropdown-menu-right" >
				    	<li><a href="javascript:void(0);" onfocus="this.blur();">用户名：${sessionUser.userName}</a></li>
				    	<li><a href="javascript:void(0);" onfocus="this.blur();">真实姓名：${sessionUser.realName}</a></li>
				    	<li><a href="javascript:void(0);" onfocus="this.blur();">角色：${sessionUser.roleName}</a></li>
				    	<li><a href="javascript:void(0);" onfocus="this.blur();">联系方式：${sessionUser.tel}</a></li>
				  	</ul>
				</li>
				<li><a href="${base}/logout" onfocus="this.blur();" title="注销"><span class="glyphicon glyphicon-log-out"></span></a></li>
			</ul>
		</div>
	</div>
</div>