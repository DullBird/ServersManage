<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="operationListModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
    	<div class="modal-header">
	      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	      <h4 class="modal-title" id="myModalLabel">请选择更改的人员</h4>
	    </div>
	    <div class="modal-body">
	    	<form id="operationListForm" method="post" autocomplete="off" class="form-horizontal" role="form">
	    		<input type="hidden" name="sId" value="${server.id}">
	    		<div class="radio">
				</div>
				<button type="submit" class="btn btn-default">提交</button>
		  	</form>
	    </div>
	    <div class="modal-footer">
	      <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
	    </div>
	    
    </div>
  </div>
</div>