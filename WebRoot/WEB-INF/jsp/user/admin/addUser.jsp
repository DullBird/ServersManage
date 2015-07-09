<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>添加用户</title>
    <link rel="stylesheet" href="${base}/js/sco.js/css/sco.message.css">
    <script type="text/javascript" src="${base}/js/sco.js/js/sco.message.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${base}/js/bootstrap3.2.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${base}/js/jQuery.Hz2Py-min.js"></script>
  </head>
  <body>
  	<div class="panel panel-default ">
  		<div class="panel-heading">添加用户</div>
  		<div class="panel-body">
		  	<form id="addForm" method="post" class="form-horizontal" role="form">
		  		<div class="form-group">
				    <label class="col-sm-2 control-label">用户名</label>
				    <div class="col-sm-4">
				      <input name="userName" id="userName" type="text" class="form-control" placeholder="*默认是真实姓名的全拼，用于系统登录" readonly>
				    </div>
				</div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">真实姓名</label>
				    <div class="col-sm-4">
				      <input name="realName" id="realName" type="text" class="form-control" placeholder="*请填写您的真实姓名，用户名会自动补全">
				    </div>
				</div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">密码</label>
				    <div class="col-sm-4">
				      <input name="passWord" id="passWord" type="password" class="form-control" placeholder="*请填写您的登录密码">
				    </div>
				</div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">请再次输入</label>
				    <div class="col-sm-4">
				      <input name="repassWord" id="repassWord" type="password" class="form-control" placeholder="*请再次填写您的登录密码">
				    </div>
				</div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">角色</label>
				    <div class="col-sm-4">
				    	<select name="rId" class="form-control">
				    		<c:forEach var="role" items="${roleList}">
				    			<option value="${role.id}">${role.name}</option>
				    		</c:forEach>
						</select>
				    </div>
				</div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">联系方式</label>
				    <div class="col-sm-4">
				      <input name="tel" type="text" class="form-control" placeholder="填写您的手机号码或座机号">
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
  	<script type="text/javascript">
  		$.validator.setDefaults({
  			submitHandler: function() {
  				var currentForm = $(this.currentForm);
	  			$.ajax({
	  				url:'${base}/user/ajax/admin/addUser',
	  				type:'POST',
	  				data:$(currentForm).serialize(),
	  				success:function(date){
	  					if(date.success){
	  						$.scojs_message('添加成功', $.scojs_message.TYPE_OK);
	  						$(currentForm)[0].reset();
	  					}else{
	  						$.scojs_message('参数异常', $.scojs_message.TYPE_ERROR);
	  					}
	  				}
	  			});
	  			return false;
  			},
  			showErrors: function(map, list) {
  				var focussed = document.activeElement;
  				if (focussed && $(focussed).is("input, textarea")) {
  					$(focussed).popover('hide');
  				}
  				$.each(list, function(index, error) {
  					$(error.element).popover({
  						content:error.message,
  						trigger: 'manual',
  						placement:'right',
  						container:'body'
  					}).popover('show');
  				});
  			}
  		});
  	
  		(function() {
  			$("#addForm").validate({
  				rules:{
  					realName:{
  						required:true,
  						remote: {
						    url: "${base}/user/ajax/admin/checkUserExist",     //后台处理程序
						    type: "post",               //数据发送方式
						    dataType: "json",           //接受数据格式   
						    data: {                     //要传递的数据
						        realName: function() {
						            return $("#realName").val();
						        }
						    }
						}
  					},
  					passWord:{required:true,minlength:6},
  					repassWord:{required:true,equalTo:"#passWord"}
  					},
  				messages:{
  					realName:{required:"真实姓名不能为空",remote:"该人员已经存在"},
  					passWord:{required:"密码不能为空",minlength:"至少输入6个数字或字母"},
  					repassWord:{required:"请再次输入密码",equalTo:"两次密码输入不相同"}
  				}
  			});
  			
  			//转换中文的全拼
  			$("#realName").on("keyup keydown change blur",function (){
  				var username = $(this).toPinyin().toLowerCase();
				$("#userName").val(username.replace(/\s+/g, ""));
			});
  		})();
  		
  	</script>
  </body>
</html>
