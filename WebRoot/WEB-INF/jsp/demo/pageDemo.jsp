<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>分页Demo</title>
  </head>
  <body>
  	<form name="pageForm" action="${base}/demo/pageDemo" method="post">
  		<input type="hidden" name="toPage" />
  	</form>
  	<div class="panel panel-primary">
  		<div class="panel-heading">分页Demo</div>
	  	<table class="table table-bordered">
	  		<thead>
	  			<tr>
	  				<th>序号</th>
	  				<th>日志id</th>
	  				<th>操作员</th>
	  				<th>操作员角色</th>
	  				<th>日志</th>
	  				<th>记录时间</th>
	  				<th>操作的服务器</th>
	  				<th>操作</th>
	  			</tr>
	  		</thead>
	  		<tbody>
	  			<c:forEach items="${pageBean.objLists}" var="log" varStatus="step">
		  			<tr>
		  				<td>${step.count}</td>
		  				<td>${log.logId}</td>
		  				<td>${log.trueName}</td>
		  				<td>${log.roleName}</td>
		  				<td>${log.log}</td>
		  				<td>${log.createDate}</td>
		  				<td>${log.serverName}</td>
		  				<td><a href="#">冻结</a>/<a href="#">详情</a></td>
		  			</tr>
	  			</c:forEach>
	  		</tbody>
	  	</table>
  	</div>
  	<c:import url="../main/page.jsp"></c:import>
  </body>
</html>
