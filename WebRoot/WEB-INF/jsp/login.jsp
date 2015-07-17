<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${base}/js/bootstrap3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${base}/js/sco.js/css/sco.message.css">
    <link rel="stylesheet" href="${base}/css/login.css">
    <script type="text/javascript" src="${base}/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${base}/js/sco.js/js/sco.message.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${base}/js/bootstrap3.2.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${base}/js/login.js"></script>
   	<script type="text/javascript">
    	var base = "${base}";
    </script>
  </head>
  <body class="login">
  	<section>
  		<h1>用户登录</h1>
  		<form id="loginForm" action="${base}/ajaxLogin" method="post">
  			<div class="form-group">
  				<div class="form-group-indiv">
	  				<div class="input-group" >
	  					<span class="input-group-addon glyphicon glyphicon-user" aria-hidden="true"></span>
	  					<input name="userName" class="form-control input-lg" type="text" placeholder="用户名" />
	  				</div>
  				</div>
  				<%-- 存放错误信息 --%>
  				<div class="col-sm-4"></div>
		    </div>
  			<div class="form-group">
  				<div class="form-group-indiv">
	  				<div class="input-group" >
	  					<span class="input-group-addon glyphicon glyphicon-lock" aria-hidden="true"></span>
	  					<input name="passWord" class="form-control input-lg" type="password" placeholder="密码" />
	  				</div>
	  			</div>
	  			<%-- 存放错误信息 --%>
	  			<div class="col-sm-4"></div>
		    </div>
		    <div class="form-group">
		    	<div class="form-group-indiv">
		    		<%-- 保持结构一致，多添加一个无用的div --%>
		    		<div>
		    			<input name="verifyCode" maxlength="4" class="form-control input-lg verifyCode" type="text" placeholder="验证码" />
		    			<img id="verifyCodeImg" src="${base}/verifyCode" />
		    		</div>
		    	</div>
		    	<%-- 存放错误信息 --%>
		    	<div class="col-sm-4"></div>
		    </div>
		    <div class="form-group">
		    	<div class="form-group-indiv">
  					<button type="submit" class="btn btn-primary btn-lg login-btn">登录</button>
  				</div>
		    </div>
  		</form>
  	</section>
  </body>
</html>
