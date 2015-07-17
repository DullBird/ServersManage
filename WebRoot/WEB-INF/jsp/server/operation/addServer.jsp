<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>添加用户</title>
    <link rel="stylesheet" href="${base}/js/sco.js/css/sco.message.css">
    <script type="text/javascript" src="${base}/js/sco.js/js/sco.message.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${base}/js/server/addServer.js"></script>
  </head>
  <body>
  	<div class="panel panel-default ">
  		<div class="panel-heading">新增服务器</div>
  		<div class="panel-body">
		  	<form id="addForm" method="post" class="form-horizontal" autocomplete="true" role="form">
		  		<div class="form-group">
				    <label class="col-sm-2 control-label">主机名</label>
				    <div class="col-sm-6">
				      <input name="name" id="name" type="text" class="form-control" placeholder="*请填写服务器的主机名" >
				    </div>
				    <%-- 表单验证错误信息div --%>
				    <div class="col-sm-4 my-col-sm-4"></div>
				</div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">cpu参数</label>
				    <div class="col-sm-6">
				      <input name="cpu" id="cpu" type="text" class="form-control" placeholder="*请填写主机的cpu参数，格式：4*4，代表4个4核cpu">
				    </div>
				    <%-- 表单验证错误信息div --%>
				    <div class="col-sm-4 my-col-sm-4"></div>
				</div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">内存参数</label>
				    <div class="col-sm-6">
				      <input name="memory" id="memory" type="text" class="form-control" placeholder="*请填写主机的内存，单位：G">
				    </div>
				    <%-- 表单验证错误信息div --%>
				    <div class="col-sm-4 my-col-sm-4"></div>
				</div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">硬盘参数</label>
				    <div class="col-sm-6">
				      <input name="hardDisk" id="hardDisk" type="text" class="form-control" placeholder="*请填写硬盘空间大小，单位：G">
				    </div>
				    <%-- 表单验证错误信息div --%>
				    <div class="col-sm-4 my-col-sm-4"></div>
				</div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">主机ip</label>
				    <div class="col-sm-6">
				      <input name="ip" id="ip" type="text" class="form-control" placeholder="*填写主机的ip地址">
				    </div>
				    <%-- 表单验证错误信息div --%>
				    <div class="col-sm-4 my-col-sm-4"></div>
				</div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">公网ip</label>
				    <div class="col-sm-6">
				      <input name="publicIp" id="publicIp" type="text" class="form-control" placeholder="填写主机映射的公网ip地址">
				    </div>
				</div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">操作系统</label>
				    <div class="col-sm-6">
				      <input name="os" id="os" type="text" class="form-control" placeholder="*填写主机安装的操作系统">
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
				          		<input id="${serverType.tableName}" name="stidList" value="${serverType.id}" type="checkbox"> ${serverType.name}
				        	</label>
				      	</c:forEach>
				      </div>
				    </div>
				 </div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">是否虚拟机</label>
				    <div class="col-sm-4">
				    	<select name="isVirtual" id="isVirtual" class="form-control">
				    		<option selected="selected" value="0">否</option>
				    		<option value="1">是</option>
						</select>
				    </div>
				</div>
				<%-- 不是虚拟设备需要填写设备型号，服务编码等信息 --%>
				<div id="isVirtualDiv">
					<div class="form-group">
					    <label class="col-sm-2 control-label">型号</label>
					    <div class="col-sm-6">
					      <input name="model" id="model" type="text" class="form-control" placeholder="*填写服务器的型号">
					    </div>
					    <%-- 表单验证错误信息div --%>
				    	<div class="col-sm-4 my-col-sm-4"></div>
					</div>
					<div class="form-group">
					    <label class="col-sm-2 control-label">服务编码</label>
					    <div class="col-sm-6">
					      <input name="services" id="services" type="text" class="form-control" placeholder="*填写服务器的服务编码，或快速服务编码">
					    </div>
					    <%-- 表单验证错误信息div --%>
				    	<div class="col-sm-4 my-col-sm-4"></div>
					</div>
					<div class="form-group">
					    <label class="col-sm-2 control-label">邮政设备号</label>
					    <div class="col-sm-6">
					      <input name="postDeviceCode" id="postDeviceCode" type="text" class="form-control" placeholder="填写服务器的邮政设备号">
					    </div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">协助人员</label>
				    <div class="col-sm-9">
				      <div style="padding-top: 0px;padding-bottom: 5px;" class="checkbox">
				      	<label class="checkbox-inline">
				          <input id="allUser-checkbox" type="checkbox"> 全部
				        </label>
				        <c:forEach var="user" items="${user}">
				        	<label class="checkbox-inline">
				          		<input name="userIdList" value="${user.id}" type="checkbox"> ${user.realName}
				        	</label>
				        </c:forEach>
				      </div>
				    </div>
				 </div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">备注</label>
				    <div class="col-sm-8">
				      <textarea name="remark" id="remark" class="form-control" rows="7"></textarea>
				    </div>
				</div>
				<div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <button type="submit" class="btn btn-default">提交</button>
				      <button type="reset" class="btn btn-default">重置</button>
				    </div>
				 </div>
		  	</form>
		 </div>
  </body>
</html>
