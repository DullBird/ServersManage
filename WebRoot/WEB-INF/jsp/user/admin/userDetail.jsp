<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>用户详情</title>
    <link rel="stylesheet" href="${base}/js/sco.js/css/sco.message.css">
    <script type="text/javascript" src="${base}/js/sco.js/js/sco.message.js"></script>
  </head>
  <script type="text/javascript">
  	//重置密码
  	function resetPwd(userId){
  		$("#resetPwd-btn").attr("contenteditable",true);
		$.ajax({
			url:'${base}/user/ajax/admin/resetPwd',
			type:'POST',
			data:'id='+userId,
			success:function(date){
				if(date.success){
					$.scojs_message('密码重置成功', $.scojs_message.TYPE_OK);
				}else{
					$.scojs_message(date.errorMsg, $.scojs_message.TYPE_ERROR);
				}
				//$("#resetPwd-btn").removeAttr("contenteditable");
			},
			error:function (XMLHttpRequest) {
				$.scojs_message("错误代码："+XMLHttpRequest.status, $.scojs_message.TYPE_ERROR);
			}
		});
	}
	
	//删除用户
	function deleteUser(userId){
		$.ajax({
			url:'${base}/user/ajax/admin/deleteUser',
			type:'POST',
			data:'id='+userId,
			success:function(date){
				if(date.success){
					$.scojs_message('用户删除成功', $.scojs_message.TYPE_OK);
					$("#deleteUser-td").html("删除");
					$("#deleteUser-td-"+userId).html("删除");
				}else{
					$.scojs_message(date.errorMsg, $.scojs_message.TYPE_ERROR);
				}
			},
			error:function (XMLHttpRequest) {
				$.scojs_message("错误代码："+XMLHttpRequest.status, $.scojs_message.TYPE_ERROR);
			}
		});
	}
  </script>
  <body>
  	<div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      <h4 class="modal-title" id="myModalLabel">详情</h4>
    </div>
    <div class="modal-body">
    <div style="margin-bottom: 20px;"><span class="label label-info">提示：重置的密码为dg11185；删除用户后，不能恢复</span></div>
  	<table class="table table-bordered">
  		<tbody>
  			<tr>
  				<th colspan="4">用户详情</th>
  			</tr>
  			<tr>
  				<th>ID</th><td>${user.id}</td>
  				<th>用户名</th><td>${user.userName}</td>
  			</tr>
  			<tr>
  				<th>真实姓名</th><td>${user.realName}</td>
  				<th>联系方式</th><td>${user.tel}</td>
  			</tr>
  			<tr>
  				<th>角色</th><td>${user.roleName}</td>
  				<th>状态</th>
  				<td id="deleteUser-td">
  					<c:if test="${user.status==1}">正常<a href="javascript:deleteUser(${user.id});">（删除）</a></c:if>
					<c:if test="${user.status==0}">删除</c:if>
  				</td>
  			</tr>
  			<tr>
  				<th>创建时间</th><td>${user.createDate}</td>
  				<th>重置密码</th>
  				<td>
  					<c:if test="${user.status==1}">
  						<a id="resetPwd-btn" href="javascript:resetPwd(${user.id});">重置</a>
  					</c:if>
  				</td>
  			</tr>
  		</tbody>
  	</table>
  	
  	<c:if test="${not empty serverDetail}">
	  	<table class="table table-bordered">
	  		<tbody>
	  			<!-- 用户的服务器关联信息 -->
	  			<tr>
	  				<th>用户能管理的服务器</th>
	  			</tr>
	  			<tr>
	  				<th>主机名</th>
	  				<th>创建人</th>
	  				<th>创建时间</th>
	  			</tr>
	  			<tr>
	  				<td>proxy1.dyw.com</td>
	  				<td>赖永钊</td>
	  				<td>2015-7-8</td>
	  			</tr>
	  		</tbody>
	  	</table>
  	</c:if>
  	</div>
    <div class="modal-footer">
      <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
    </div>
  </body>
</html>
