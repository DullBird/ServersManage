<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="webAppInfoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    	<div class="modal-header">
	      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	      <h4 class="modal-title" id="myModalLabel">应用服务器详情</h4>
	    </div>
	    <div class="modal-body">
	    	<table id="webAppInfoTable" class="table table-bordered">
		  		<tbody>
		  			<tr>
		  				<th colspan="2">应用服务器详情</th>
		  			</tr>
		  			<tr>
		  				<th>ID</th>
		  				<td></td>
		  			</tr>
		  			<tr>
		  				<th>应用名</th>
		  				<td></td>
		  			</tr>
		  			<tr>
		  				<th>应用根路径</th>
		  				<td></td>
		  			</tr>
		  			<tr>
		  				<th>应用访问路径</th>
		  				<td></td>
		  			</tr>
		  			<tr>
		  				<th>应用数据源</th>
		  				<td></td>
		  			</tr>
		  			<tr>
		  				<th>部署的tomcat路径</th>
		  				<td></td>
		  			</tr>
		  			<tr>
		  				<th>创建日期</th>
		  				<td></td>
		  			</tr>
		  		</tbody>
		  	</table>
	    </div>
	    <div class="modal-footer">
	      <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
	    </div>
    </div>
  </div>
</div>