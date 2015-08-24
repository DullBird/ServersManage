<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="editDatabaseModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    	<div class="modal-header">
	      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	      <h4 class="modal-title" id="myModalLabel">修改数据库服务器</h4>
	    </div>
	    <div class="modal-body">
	    	<form id="editDatabaseForm" method="post" autocomplete="off" class="form-horizontal" role="form">
	    		<input type="hidden" name="sId" value="${server.id}">
	    		<input type="hidden" name="id" >
				<div class="form-group">
				    <label class="col-sm-3 control-label">实例名</label>
				    <div class="col-sm-6">
				      <input name="dbSid" id="dbSid" type="text" class="form-control" placeholder="*请填数据库的实例名">
				    </div>
				    <%-- 表单验证错误信息div --%>
				    <div class="col-sm-3 my-col-sm-3"></div>
				</div>
				<div class="form-group">
				    <label class="col-sm-3 control-label">数据库用户</label>
				    <div class="col-sm-6">
				      <input name="dbUser" id="dbUser" type="text" class="form-control" placeholder="*请填数据库用户">
				    </div>
				    <%-- 表单验证错误信息div --%>
				    <div class="col-sm-3 my-col-sm-3"></div>
				</div>
				<div class="form-group">
				    <label class="col-sm-3 control-label">表空间</label>
				    <div class="col-sm-6">
				      <input name="dbTableSpace" id="dbTableSpace" type="text" class="form-control" placeholder="*请填默认表空间">
				    </div>
				    <%-- 表单验证错误信息div --%>
				    <div class="col-sm-3 my-col-sm-3"></div>
				</div>
				<div class="form-group">
				    <label class="col-sm-3 control-label">临时表空间</label>
				    <div class="col-sm-6">
				    	<input name="dbTempTableSpace" id="dbTempTableSpace" type="text" class="form-control" placeholder="*请填临时表空间">
				    </div>
				    <%-- 表单验证错误信息div --%>
				    <div class="col-sm-3 my-col-sm-3"></div>
				</div>
				<div class="form-group">
				    <label class="col-sm-3 control-label">项目名称</label>
				    <div class="col-sm-6">
				    	<input name="appName" id="appName" type="text" class="form-control" placeholder="请填写该用户所属的项目">
				    </div>
				    <%-- 表单验证错误信息div --%>
				    <div class="col-sm-3 my-col-sm-3"></div>
				</div>
				<div class="form-group">
				    <div class="col-sm-offset-3 col-sm-10">
				      <button type="submit" class="btn btn-default">提交</button>
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