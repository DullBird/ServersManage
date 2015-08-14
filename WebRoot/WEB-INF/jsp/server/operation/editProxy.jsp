<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="editProxyModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    	<div class="modal-header">
	      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	      <h4 class="modal-title" id="myModalLabel">修改代理服务器</h4>
	    </div>
	    <div class="modal-body">
	    	<form id="editProxyForm" method="post" autocomplete="off" class="form-horizontal" role="form">
	    		<input type="hidden" name="sId" value="${server.id}">
	    		<input type="hidden" name="id" >
				<div class="form-group">
				    <label class="col-sm-3 control-label">虚拟主机名</label>
				    <div class="col-sm-6">
				      <input name="vhostName" id="vhostName" type="text" class="form-control" placeholder="*请填写虚拟主机名">
				    </div>
				    <%-- 表单验证错误信息div --%>
				    <div class="col-sm-3 my-col-sm-3"></div>
				</div>
				<div class="form-group">
				    <label class="col-sm-3 control-label">访问域名</label>
				    <div class="col-sm-6">
				      <input name="vhostDomain" id="vhostDomain" type="text" class="form-control" placeholder="*请填写访问的域名">
				    </div>
				    <%-- 表单验证错误信息div --%>
				    <div class="col-sm-3 my-col-sm-3"></div>
				</div>
				<div class="form-group">
				    <label class="col-sm-3 control-label">根路径</label>
				    <div class="col-sm-6">
				      <input name="vhostRoot" id="vhostRoot" type="text" class="form-control" placeholder="*请填写虚拟主机的根路径">
				    </div>
				    <%-- 表单验证错误信息div --%>
				    <div class="col-sm-3 my-col-sm-3"></div>
				</div>
				<div class="form-group">
				    <label class="col-sm-3 control-label">日志路径</label>
				    <div class="col-sm-6">
				    	<input name="vhostLogs" id="vhostLogs" type="text" class="form-control" placeholder="*请填写日志路径">
				    </div>
				    <%-- 表单验证错误信息div --%>
				    <div class="col-sm-3 my-col-sm-3"></div>
				</div>
				<div class="form-group">
				    <div class="col-sm-offset-3 col-sm-10">
				      <button type="submit" class="btn btn-default">修改</button>
				    </div>
				 </div>
		  	</form>
	    </div>
	    <div class="modal-footer">
	      <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
	    </div>
	    
    </div>
  </div>
</div>