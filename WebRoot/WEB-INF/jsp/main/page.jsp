<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageBean.begin }" var="begin"></c:set>
<c:set value="${pageBean.end }" var="end"></c:set>
<div data-toPage="${pageBean.toPage }">
	<small>第${pageBean.toPage}页/共${pageBean.totalPage}页</small>
	<ul class="pagination pull-right">
		<c:if test="${pageBean.toPage>1}">
			<li><a href="javascript:void(0);" onclick="return pageGo(1);">第一页</a></li>
			<li><a href="javascript:void(0);" onclick="return pageGo(${pageBean.toPage-1});">&laquo;</a></li>
		</c:if>
		<c:forEach begin="${begin}" end="${end}" varStatus="status">
			<c:choose>
				<c:when test="${status.index==pageBean.toPage}">
					<li class="active"><a href="javascript:void(0);">${status.index}</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="javascript:void(0);" onclick=" return pageGo(${status.index})">${status.index}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${pageBean.toPage<pageBean.totalPage}">
			<li><a href="javascript:void(0);" onclick="return pageGo(${pageBean.toPage+1})">&raquo;</a></li>
			<li><a href="javascript:void(0);" onclick="return pageGo(${pageBean.getTotalPage()});" >最后一页</a></li>
		</c:if>
	</ul>
</div>
<script type="text/javascript">
function pageGo(pageNo){
		if(!/^[1-9][0-9]*$/.test(pageNo)) {
			alert("请输入合法的页码！");
		} else {
			<c:if test="${!empty functionName}">
				${functionName}(pageNo);
				return false;
			</c:if>
			document.pageForm.toPage.value=pageNo;
			document.pageForm.submit();
		}
		return false;
	}
</script>