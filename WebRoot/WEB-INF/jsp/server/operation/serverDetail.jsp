<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${base}/js/sco.js/css/sco.message.css">
<script type="text/javascript" src="${base}/js/sco.js/js/sco.message.js"></script>
<script type="text/javascript" src="${base}/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${base}/js/server/serverDetail.js"></script>
<table class="table">
	<tbody>
		<%-- 基本信息 --%>
		<tr class="info">
			<th class="server-detail-type-add" style="text-align: center;" colspan="8">基本信息
				<a id="server-edit-btn" style="margin-left: 5px;" title="修改基本信息" onfocus="this.blur();" href="javascript:void(0);">
					<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
				</a>
			</th>
		</tr>
		<tr>
			<th colspan="2">主机名</th>
			<td colspan="2">${server.name}</td>
			<th colspan="2">ID</th>
			<td id="detail-sId" colspan="2">${server.id}</td>
		</tr>
		<tr>
			<th colspan="2">cpu</th>
			<td colspan="2">${server.cpu}</td>
			<th colspan="2">内存</th>
			<td colspan="2">${server.memory}</td>
		</tr>
		<tr>
			<th colspan="2">硬盘</th>
			<td colspan="2">${server.hardDisk}</td>
			<th colspan="2">录入时间</th>
			<td colspan="2">${server.createDate}</td>
		</tr>
		<tr>
			<th colspan="2">录入人ID</th>
			<td colspan="2">${server.createUid}</td>
			<th colspan="2">录入人</th>
			<td colspan="2">${server.createUser}</td>
		</tr>
		<tr>
			<th colspan="2">ip</th>
			<td colspan="2">${server.ip}</td>
			<th colspan="2">公网ip</th>
			<td colspan="2">${server.publicIp}</td>
		</tr>
		<tr>
			<th colspan="2">操作系统</th>
			<td colspan="2">${server.os}</td>
			<th colspan="2">主机类型</th>
			<td colspan="2">
				<c:choose>
					<c:when test="${not empty server.stName}">${server.stName}</c:when>
					<c:otherwise>无</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th colspan="2">是否虚拟机</th>
			<td colspan="2">
				<c:if test="${server.isVirtual == 1}">是</c:if>
				<c:if test="${server.isVirtual == 0}">否</c:if>
			</td>
			<th colspan="2">服务器型号</th>
			<td colspan="2">${server.model}</td>
		</tr>
		<tr>
			<th colspan="2">服务编码</th>
			<td colspan="2">${server.services}</td>
			<th colspan="2">邮政设备号</th>
			<td colspan="2">${server.postDeviceCode}</td>
		</tr>
		<tr>
			<th colspan="8">备注</th>
		</tr>
		<tr>
			<td colspan="8">
				<c:choose>
					<c:when test="${not empty server.remark}">
						${server.remark}
					</c:when>
					<c:otherwise>
						无
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<%-- 可管理人员 --%>
		<tr class="info">
			<th style="text-align: center;" colspan="8">可管理人员</th>
		</tr>
		<tr>
			<td colspan="8">
				<c:forEach var="userServer" items="${server.userServerList}">
					${userServer.realName}【${userServer.roleName}】&nbsp;&nbsp;
				</c:forEach>
			</td>
		</tr>
		<%-- 服务器类型 --%>
		<c:forEach var="serverType" items="${server.serverTypeList}">
			<%-- 代理服务器 --%>
			<c:if test="${serverType.tableName == 'tb_server_proxy'}">
				<tr class="info">
					<th style="text-align: center;" colspan="8">${serverType.name}</th>
				</tr>
				<tr>
					<td colspan="1">序号</td>
					<td colspan="1">虚拟主机名</td>
					<td colspan="1">访问域名</td>
					<td colspan="2">日志路径</td>
					<td colspan="2">项目根路径</td>
					<td colspan="1">创建时间</td>
				</tr>
				<c:forEach var="proxy" items="${server.proxyList}" varStatus="step">
					<tr>
						<td colspan="1">${step.count}</td>
						<td colspan="1">${proxy.vhostName}</td>
						<td colspan="1">${proxy.vhostDomain}</td>
						<td colspan="2">${proxy.vhostLogs}</td>
						<td colspan="2">${proxy.vhostRoot}</td>
						<td colspan="1">${proxy.createDate}</td>
					</tr>
				</c:forEach>
				<tr>
					<td class="server-detail-type-add" colspan="8">
						<a id="proxyServer-add-btn" onfocus="this.blur();" href="javascript:void(0);">
							<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
							添加
						</a>
					</td>
				</tr>
			</c:if>
			
			<%-- 应用服务器 --%>
			<c:if test="${serverType.tableName == 'tb_server_webapp'}">
				<tr class="info">
					<th style="text-align: center;" colspan="8">${serverType.name}</th>
				</tr>
				<tr>
					<td colspan="1">序号</td>
					<td colspan="1">应用名</td>
					<td colspan="1">应用根路径</td>
					<td colspan="1">应用访问路径</td>
					<td colspan="2">应用数据源</td>
					<td colspan="1">部署的tomcat路径</td>
					<td colspan="1">创建日期</td>
				</tr>
				<c:forEach var="webApp" items="${server.webAppList}" varStatus="step">
					<tr>
						<td colspan="1">${step.count}</td>
						<td colspan="1">${webApp.appName}</td>
						<td colspan="1">${webApp.appRoot}</td>
						<td colspan="1">${webApp.appUrl}</td>
						<td colspan="2">${webApp.appDatasource}</td>
						<td colspan="1">${webApp.tomcatRoot}</td>
						<td colspan="1">${webApp.createDate}</td>
					</tr>
				</c:forEach>
				<tr>
					<td class="server-detail-type-add" colspan="8">
						<a id="webAppServer-add-btn" onfocus="this.blur();" href="javascript:void(0);">
							<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
							添加
						</a>
					</td>
				</tr>
			</c:if>
			
			<%-- 数据库服务器 --%>
			<c:if test="${serverType.tableName == 'tb_server_database'}">
				<tr class="info">
					<th style="text-align: center;" colspan="8">${serverType.name}</th>
				</tr>
				<tr>
					<td colspan="1">序号</td>
					<td colspan="1">实例名</td>
					<td colspan="1">数据库用户</td>
					<td colspan="2">表空间</td>
					<td colspan="2">临时表空间</td>
					<td colspan="1">创建时间</td>
				</tr>
				<c:forEach var="database" items="${server.dbList}" varStatus="step">
					<tr>
						<td colspan="1">${step.count}</td>
						<td colspan="1">${database.dbSid}</td>
						<td colspan="1">${database.dbUser}</td>
						<td colspan="2">${database.dbTableSpace}</td>
						<td colspan="2">${database.dbTempTableSpace}</td>
						<td colspan="1">${database.createDate}</td>
					</tr>
				</c:forEach>
				<tr>
					<td class="server-detail-type-add" colspan="8">
						<a id="dbServer-add-btn" onfocus="this.blur();" href="javascript:void(0);">
							<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
							添加
						</a>
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</tbody>
</table>
<c:import url="addProxy.jsp" />