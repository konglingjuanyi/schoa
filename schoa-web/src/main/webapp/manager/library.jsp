<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../import.jsp"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
</title>
	<script type="text/javascript" src="<%=syspath%>/manager/library.js"></script>
</head>
<body>
<input type="hidden" id="hidkechengId" name="hidkechengId" value="${kecheng.id}">
<div id="search_div_id">
			<table class="Mytable">
				<tr>
					<td class="Myfont">
						选择学期：
						<select id="xueqi" onchange="chooseKecheng()">
							<option value="0">请选择...
							<c:forEach items="${xueqis }" var="xq">
								<option  
								<c:if test="${kecheng.xueqiId == xq.id}">selected="selected"</c:if>
								value="${xq.id}">${xq.name}
							</c:forEach>
						</select>
						选择课程:
						<select id="kecheng">
							<option value="0">请选择...
						</select>
						资料名称：
						<input type="text" name="keyword" id="keyword">
						<input type="button" value="搜索" class="Mybotton" onclick="searchFunc()">
					</td>
				</tr>
			</table>
		</div>
</body>
</html>