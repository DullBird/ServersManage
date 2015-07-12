<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %> 
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <title><decorator:title default="服务器管理系统" /></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${base}/js/bootstrap3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${base}/css/dashboard.css">
    <script src="${base}/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript">
    	var base = "${base}";
    </script>
    <decorator:head />
  </head>
  <body>
  	<c:import url="/WEB-INF/jsp/main/top.jsp"></c:import>
  	<div class="container-fluid">
  		<div class="row">
  			<c:import url="/WEB-INF/jsp/main/header.jsp"></c:import>
  			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
  				<decorator:body /> 
  			</div>
  			<c:import url="/WEB-INF/jsp/main/foot.jsp"></c:import>
  		</div>
  	</div>
  	
  </body>
</html>
