<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>服务器列表</title>
	<link rel="stylesheet" href="${base}/css/server.css" />
	<script type="text/javascript" src="${base}/js/server/admin/allServerList.js"></script>
	<script type="text/javascript" src="${base}/js/server/server.js"></script>
</head>
<body>
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<div class="panel panel-default">
		  			<div class="panel-heading">服务器列表</div>
		  			<div class="panel-body">
		  				<!-- 搜索的表单 -->
		  				<form class="form-inline" name="pageForm" action="${base}/server/admin/allServerList" method="post" >
		  					<input type="hidden" name="toPage" value="1" />
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">服务器类型</div>
							    	<select name="stId" class="form-control">
							    		<option value="">全部</option>
							    		<c:forEach var="serverType" items="${serverType}">
							    			<option value="${serverType.id}" <c:if test="${stId == serverType.id}">selected="selected"</c:if> >${serverType.name}</option>
							    		</c:forEach>
									</select>
							    </div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">服务器状态</div>
							    	<select name="status" class="form-control">
							    		<option value="">全部</option>
							    		<option value="1" <c:if test="${status == 1}">selected="selected"</c:if> >显示</option>
							    		<option value="0" <c:if test="${status == 0}">selected="selected"</c:if> >已删除</option>
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
								<th>主机名</th>
								<th>cpu配置</th>
								<th>内存大小</th>
								<th>硬盘大小</th>
								<th>ip</th>
								<th>状态</th>
								<th>服务器类型</th>
								<th>详情</th>
							</tr>
							<%-- 后台获取的数据 --%>
							<c:forEach var="server" items="${pageBean.objLists}" varStatus="step">
								<tr>
									<td>${step.count}</td>
									<td>${server.name}</td>
									<td>${server.cpu}</td>
									<td>${server.memory}</td>
									<td>${server.hardDisk}</td>
									<td>${server.ip}</td>
									<td>
										<c:if test="${server.status == 1}">显示</c:if>
										<c:if test="${server.status == 0}">已删除</c:if>
									</td>
									<td>${server.stName}</td>
									<td><input class="btn btn-default btn-xs server-detail-btn" sId="${server.id}" type="button" value="查看" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="panel-body">
						<c:import url="../../main/page.jsp"></c:import>
					</div>
					<!-- 用户列表表格 -->
		  		</div>
			</div>
		  	<div class="item myServer-detail">
		  		<div class="panel panel-default">
		  			<div class="panel-heading">
		  				服务器详情
		  				<a style="text-decoration: none;" href="javascript:void(0);" class="server-detail-return pull-right" ><span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span> 返回</a>
		  			</div>
		  			<div class="panel-myServer-detail"></div>
		  		</div>
		  	</div>
		</div>
	</div>
</body>
</html>