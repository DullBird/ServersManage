<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>欢迎使用</title>
	<link rel="stylesheet" href="${base}/css/welcome.css">
</head>
<body>
	<div class="welcome-main">
		<div class="welcome-main-browser clearfix">
			<img class="col-md-2" src="${base}/images/firefox.jpg">
			<img class="col-md-2" src="${base}/images/chrome.jpg">
		</div>
		<div class="welcome-main-description">
			<p>欢迎使用服务器管理系统，为了给您提供最炫酷的体验，建议使用最新版本的Firefox或chrome浏览器。
			至于Firefox或chrome的介绍，呵呵……这里就不解释啦。功能嘛，呵呵……开发商也是世界上杠杠的开发商啦。</p>
			<p class="welcome-main-description-tips">
				<strong>ps:</strong>
				若界面结构、颜色搭配使您感到不适，很对不起。缺少美工，请勿虐狗。
			</p>
		</div>
	</div>
</body>
</html>
