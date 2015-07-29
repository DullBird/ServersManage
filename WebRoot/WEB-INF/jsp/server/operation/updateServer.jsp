<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${base}/js/server/updateServer.js"></script>
<form id="updateForm" method="post" class="form-horizontal">
	<input type="hidden" value="${server.id}" id="update-sId" />
	<input type="hidden" value="${server.id}" name="id" />
	<div class="form-group">
		<label class="col-sm-2 control-label">主机名</label>
		<div class="col-sm-6">
			<input name="name" id="name" type="text" class="form-control" value="${server.name}">
		</div>
		<%-- 表单验证错误信息div --%>
		<div class="col-sm-4 my-col-sm-4"></div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">cpu参数</label>
		<div class="col-sm-6">
			<input name="cpu" id="cpu" type="text" class="form-control" value="${server.cpu}">
		</div>
		<%-- 表单验证错误信息div --%>
		<div class="col-sm-4 my-col-sm-4"></div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">内存参数</label>
		<div class="col-sm-6">
			<input name="memory" id="memory" type="text" class="form-control" value="${server.memory}">
		</div>
		<%-- 表单验证错误信息div --%>
		<div class="col-sm-4 my-col-sm-4"></div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">硬盘参数</label>
		<div class="col-sm-6">
			<input name="hardDisk" id="hardDisk" type="text" class="form-control" value="${server.hardDisk}">
		</div>
		<%-- 表单验证错误信息div --%>
		<div class="col-sm-4 my-col-sm-4"></div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">主机ip</label>
		<div class="col-sm-6">
			<input name="ip" id="ip" type="text" class="form-control" value="${server.ip}">
		</div>
		<%-- 表单验证错误信息div --%>
		<div class="col-sm-4 my-col-sm-4"></div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">公网ip</label>
		<div class="col-sm-6">
			<input name="publicIp" id="publicIp" type="text" class="form-control" value="${server.publicIp}">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">操作系统</label>
		<div class="col-sm-6">
			<input name="os" id="os" type="text" class="form-control" value="${server.os}" >
		</div>
		<%-- 表单验证错误信息div --%>
		<div class="col-sm-4 my-col-sm-4"></div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">主机类型</label>
		<div class="col-sm-6">
			<div style="padding-top: 0px;padding-bottom: 5px;" class="checkbox">
				<c:forEach var="serverType" items="${serverType}">
					<label class="checkbox-inline"> 
						<input id="${serverType.tableName}" name="stidList"
						value="${serverType.id}" type="checkbox"
						<c:forEach var="myServerType" items="${server.serverTypeList}">
							<c:if test="${myServerType.id==serverType.id}">checked="checked"</c:if>
						</c:forEach>> 
						${serverType.name}
					</label>
				</c:forEach>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">是否虚拟机</label>
		<div class="col-sm-4">
			<select name="isVirtual" id="isVirtual" class="form-control">
				<option <c:if test="${server.isVirtual == 0}">selected="selected"</c:if> value="0">否</option>
				<option <c:if test="${server.isVirtual == 1}">selected="selected"</c:if> value="1">是</option>
			</select>
		</div>
	</div>
	<%-- 不是虚拟设备需要填写设备型号，服务编码等信息 --%>
	<div id="isVirtualDiv">
		<div class="form-group">
			<label class="col-sm-2 control-label">型号</label>
			<div class="col-sm-6">
				<input name="model" id="model" type="text" class="form-control" value="${server.model}">
			</div>
			<%-- 表单验证错误信息div --%>
			<div class="col-sm-4 my-col-sm-4"></div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">服务编码</label>
			<div class="col-sm-6">
				<input name="services" id="services" type="text"
					class="form-control" value="${server.services}">
			</div>
			<%-- 表单验证错误信息div --%>
			<div class="col-sm-4 my-col-sm-4"></div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">邮政设备号</label>
			<div class="col-sm-6">
				<input name="postDeviceCode" id="postDeviceCode" type="text"
					class="form-control" value="${server.postDeviceCode}">
			</div>
		</div>
	</div>
	<%-- 创建人才可以管理可管理人员 --%>
	<c:if test="${sessionUser.realName==server.createUser}">
		<div class="form-group">
			<label class="col-sm-2 control-label">可管理人员</label>
			<div class="col-sm-9">
				<div style="padding-top: 0px;padding-bottom: 5px;" class="checkbox">
					<c:forEach var="user" items="${user}">
						<label class="checkbox-inline"> 
						<input name="userIdList" value="${user.id}" type="checkbox"
							<c:forEach var="userServer" items="${server.userServerList}">
								<c:if test="${userServer.id==user.id}">checked="checked"</c:if>
							</c:forEach>
							<c:if test="${user.id==server.createUid}">disabled="disabled"</c:if>
							>
						${user.realName} 
						</label>
					</c:forEach>
				</div>
			</div>
		</div>
	</c:if>
	<div class="form-group">
		<label class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea name="remark" id="remark" class="form-control" rows="7">${server.remark}</textarea>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">更新</button>
		</div>
	</div>
</form>