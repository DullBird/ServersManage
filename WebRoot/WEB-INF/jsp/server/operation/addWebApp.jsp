<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="addWebAppModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    	<div class="modal-header">
	      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	      <h4 class="modal-title" id="myModalLabel">添加应用服务器</h4>
	    </div>
	    <div class="modal-body">
	    	<form id="addWebAppForm" method="post" autocomplete="off" class="form-horizontal" role="form">
	    		<input type="hidden" name="sId" value="${server.id}">
				<div class="form-group">
				    <label class="col-sm-3 control-label">应用名</label>
				    <div class="col-sm-6">
				      <input name="appName" id="appName" type="text" class="form-control" placeholder="*请填写应用名称">
				    </div>
				    <%-- 表单验证错误信息div --%>
				    <div class="col-sm-3 my-col-sm-3"></div>
				</div>
				<div class="form-group">
				    <label class="col-sm-3 control-label">应用根路径</label>
				    <div class="col-sm-6">
				      <input name="appRoot" id="appRoot" type="text" class="form-control" placeholder="*请填写应用根路径">
				    </div>
				    <%-- 表单验证错误信息div --%>
				    <div class="col-sm-3 my-col-sm-3"></div>
				</div>
				<div class="form-group">
				    <label class="col-sm-3 control-label">应用访问路径</label>
				    <div class="col-sm-6">
				      <input name="appUrl" id="appUrl" type="text" class="form-control" placeholder="*请填写应用访问路径">
				    </div>
				    <%-- 表单验证错误信息div --%>
				    <div class="col-sm-3 my-col-sm-3"></div>
				</div>
				<div class="form-group">
				    <label class="col-sm-3 control-label">应用数据源</label>
				    <div class="col-sm-6">
				    	<input name="appDatasource" id="appDatasource" type="text" class="form-control" placeholder="*请填写应用数据源">
				    </div>
				    <%-- 表单验证错误信息div --%>
				    <div class="col-sm-3 my-col-sm-3"></div>
				</div>
				<div class="form-group">
				    <label class="col-sm-3 control-label">tomcat路径</label>
				    <div class="col-sm-6">
				    	<input name="tomcatRoot" id="tomcatRoot" type="text" class="form-control" placeholder="*请填写部署的tomcat路径">
				    </div>
				    <%-- 表单验证错误信息div --%>
				    <div class="col-sm-3 my-col-sm-3"></div>
				</div>
				<div class="form-group">
				    <div class="col-sm-offset-3 col-sm-10">
				      <button type="submit" class="btn btn-default">提交</button>
				      <button type="reset" class="btn btn-default">重置</button>
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