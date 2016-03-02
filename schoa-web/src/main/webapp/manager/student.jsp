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
	<script type="text/javascript" src="<%=syspath%>/manager/student.js"></script>
</head>
<body>
		<div id="search_div_id">
			<table class="Mytable">
				<tr>
					<td class="Myfont">
						姓名(中/英文)：
						<input type="text" name="sname" id="sname">
						护照号：
						<input type="text" name="huzhao" id="huzhao">
						<input type="button" value="搜索" class="Mybotton" onclick="searchFunc()">
					</td>
					<td class="Myfont">
						选择学期：
						<select id="xueqi">
							<option value="0">请选择...
							<c:forEach items="${xueqis }" var="xq">
								<option value="${xq.id}">${xq.name}
							</c:forEach>
						</select>
						<input type="button" value="搜索" class="Mybotton" onclick="searchFunc2()">
					</td>
				</tr>
			</table>
		</div>
		
		<div id="logdiv">
			<span id="logId"></span>
		</div>
		
</body>
</html>