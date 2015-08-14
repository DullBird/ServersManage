<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="${base}/js/sco.js/css/sco.message.css">
<script type="text/javascript" src="${base}/js/sco.js/js/sco.message.js"></script>
<script type="text/javascript" src="${base}/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${base}/js/server/operation/serverDetail.js"></script>
<table class="table serverTable">
	<tbody>
		<%-- 基本信息 --%>
		<tr class="info">
			<th class="server-detail-type-add" style="text-align: center;" colspan="4">基本信息
				<c:if test="${sessionUser.id == server.createUid}">
					<a id="server-del-btn" style="margin-left: 5px;" title="删除" onfocus="this.blur();" href="javascript:void(0);">
						<span class="glyphicon glyphicon-minus-sign" aria-hidden="true"></span>
					</a>
				</c:if>
				<a id="server-edit-btn" style="margin-left: 5px;" title="修改基本信息" onfocus="this.blur();" href="javascript:void(0);">
					<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
				</a>
			</th>
		</tr>
		<tr>
			<th width="25%">主机名</th>
			<td width="25%">${server.name}</td>
			<th width="25%">ID</th>
			<td width="25%" id="detail-sId">${server.id}</td>
		</tr>
		<tr>
			<th>cpu</th>
			<td>${server.cpu}</td>
			<th>内存</th>
			<td>${server.memory}</td>
		</tr>
		<tr>
			<th>硬盘</th>
			<td>${server.hardDisk}</td>
			<th>录入时间</th>
			<td>
				<fmt:formatDate value="${server.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
		</tr>
		<tr>
			<th>录入人ID</th>
			<td>${server.createUid}</td>
			<th>录入人</th>
			<td>${server.createUser}</td>
		</tr>
		<tr>
			<th>ip</th>
			<td>${server.ip}</td>
			<th>公网ip</th>
			<td>${server.publicIp}</td>
		</tr>
		<tr>
			<th>操作系统</th>
			<td>${server.os}</td>
			<th>主机类型</th>
			<td>
				<c:choose>
					<c:when test="${not empty server.stName}">${server.stName}</c:when>
					<c:otherwise>无</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th>是否虚拟机</th>
			<td>
				<c:if test="${server.isVirtual == 1}">是</c:if>
				<c:if test="${server.isVirtual == 0}">否</c:if>
			</td>
			<th>服务器型号</th>
			<td>${server.model}</td>
		</tr>
		<tr>
			<th>服务编码</th>
			<td>${server.services}</td>
			<th>邮政设备号</th>
			<td>${server.postDeviceCode}</td>
		</tr>
		<tr>
			<th colspan="4">备注</th>
		</tr>
		<tr>
			<td colspan="4">
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
			<th style="text-align: center;" colspan="4">可管理人员</th>
		</tr>
		<tr>
			<td colspan="4">
				<c:forEach var="userServer" items="${server.userServerList}">
					${userServer.realName}【${userServer.roleName}】&nbsp;&nbsp;
				</c:forEach>
			</td>
		</tr>
	</tbody>
</table>

<%-- 服务器类型 --%>
<c:forEach var="serverType" items="${server.serverTypeList}">
	<%-- 代理服务器 --%>
	<c:if test="${serverType.tableName == 'tb_server_proxy'}">
		<table class="table proxyTable">
			<tbody>
				<tr class="info" >
					<th colspan="6" style="text-align: center;">${serverType.name}</th>
				</tr>
				<tr>
					<td>虚拟主机名</td>
					<td>访问域名</td>
					<td>项目根路径</td>
					<td>日志路径</td>
					<td>创建时间</td>
					<td>操作</td>
				</tr>
				<c:forEach var="proxy" items="${server.proxyList}" varStatus="step">
					<tr>
						<td>${proxy.vhostName}</td>
						<td>${proxy.vhostDomain}</td>
						<td>${proxy.vhostRoot}</td>
						<td>${proxy.vhostLogs}</td>
						<td>
							<fmt:formatDate value="${proxy.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td>
							<a class="proxyServer-del-btn no-text-decoration" proxyId="${proxy.id}" title="删除" onfocus="this.blur();" href="javascript:void(0);">
								<span class="glyphicon glyphicon-minus-sign" aria-hidden="true"></span>
							</a>
							<a class="proxyServer-edit-btn no-text-decoration" proxyId="${proxy.id}" title="编辑" onfocus="this.blur();" href="javascript:void(0);">
								<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
							</a>
							<%-- <a class="proxyServer-more-btn no-text-decoration" proxyId="${proxy.id} title="更多" onfocus="this.blur();" href="javascript:void(0);">
								<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
							</a> --%>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td class="server-detail-type-add" colspan="6">
						<a id="proxyServer-add-btn" title="添加" onfocus="this.blur();" href="javascript:void(0);">
							<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
							添加
						</a>
					</td>
				</tr>
			</tbody>
		</table>
	</c:if>
	
	<%-- 应用服务器 --%>
	<c:if test="${serverType.tableName == 'tb_server_webapp'}">
		<table class="table webAppTable">
			<tbody>
				<tr class="info">
					<th style="text-align: center;" colspan="7">${serverType.name}</th>
				</tr>
				<tr>
					<td>应用名</td>
					<td>应用根路径</td>
					<td>应用访问路径</td>
					<td>应用数据源</td>
					<td>部署的tomcat路径</td>
					<td>创建日期</td>
					<td>操作</td>
				</tr>
				<c:forEach var="webApp" items="${server.webAppList}" varStatus="step">
					<tr>
						<td>${webApp.appName}</td>
						<td>${webApp.appRoot}</td>
						<td>${webApp.appUrl}</td>
						<td>${webApp.appDatasource}</td>
						<td>${webApp.tomcatRoot}</td>
						<td>
							<fmt:formatDate value="${webApp.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td>
							<a class="webAppServer-del-btn no-text-decoration" webAppId="${webApp.id}" title="删除" onfocus="this.blur();" href="javascript:void(0);">
								<span class="glyphicon glyphicon-minus-sign" aria-hidden="true"></span>
							</a>
							<a class="webAppServer-edit-btn no-text-decoration" webAppId="${webApp.id}" title="编辑" onfocus="this.blur();" href="javascript:void(0);">
								<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
							</a>
							<a class="webAppServer-more-btn no-text-decoration" webAppId="${webApp.id}" title="更多" onfocus="this.blur();" href="javascript:void(0);">
								<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
							</a>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td class="server-detail-type-add" colspan="7">
						<a id="webAppServer-add-btn" onfocus="this.blur();" href="javascript:void(0);">
							<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
							添加
						</a>
					</td>
				</tr>
			</tbody>
		</table>
	</c:if>
	
	<%-- 数据库服务器 --%>
	<c:if test="${serverType.tableName == 'tb_server_database'}">
		<table class="table databaseTable">
			<tbody>
				<tr class="info">
					<th style="text-align: center;" colspan="6">${serverType.name}</th>
				</tr>
				<tr>
					<td>实例名</td>
					<td>数据库用户</td>
					<td>表空间</td>
					<td>临时表空间</td>
					<td>创建时间</td>
					<td>操作</td>
				</tr>
				<c:forEach var="database" items="${server.dbList}" varStatus="step">
					<tr>
						<td>${database.dbSid}</td>
						<td>${database.dbUser}</td>
						<td>${database.dbTableSpace}</td>
						<td>${database.dbTempTableSpace}</td>
						<td>
							<fmt:formatDate value="${database.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td>
							<a class="dbServer-del-btn no-text-decoration" databaseId="${database.id}" title="删除" onfocus="this.blur();" href="javascript:void(0);">
								<span class="glyphicon glyphicon-minus-sign" aria-hidden="true"></span>
							</a>
							<a class="dbServer-edit-btn no-text-decoration" databaseId="${database.id}" title="编辑" onfocus="this.blur();" href="javascript:void(0);">
								<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
							</a>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td class="server-detail-type-add" colspan="6">
						<a id="dbServer-add-btn" onfocus="this.blur();" href="javascript:void(0);">
							<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
							添加
						</a>
					</td>
				</tr>
			</tbody>
		</table>
	</c:if>
</c:forEach>
<c:import url="addProxy.jsp" />
<c:import url="editProxy.jsp" />
<c:import url="addWebApp.jsp" />
<c:import url="editWebApp.jsp" />
<c:import url="../webAppInfo.jsp" />
<c:import url="addDatabase.jsp" />
<c:import url="editDatabase.jsp" />