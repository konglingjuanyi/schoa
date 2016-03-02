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
	<script type="text/javascript" src="<%=syspath%>/question/bank.js"></script>
</head>
<body>
<div id="search_div_id">
			<table class="Mytable">
				<tr>
					<td class="Myfont">
						试题内容：
						<input type="text" name="keyword" id="keyword">&nbsp;&nbsp;
						出题人：
						<input type="text" name="user" id="user">&nbsp;&nbsp;
						题型：
						<select id="tixingId" name="tixingId">
							<option value="0">请选择...
							<c:forEach items="${tixingList }" var="obj">
								<option value="${obj.id}">${obj.title}
							</c:forEach>
						</select>&nbsp;&nbsp;
						知识点：
						<select id="kpointId" name="kpointId">
							<option value="0">请选择...
							<c:forEach items="${kpointList }" var="obj">
								<option value="${obj.id}">${obj.name}
							</c:forEach>
						</select>
						<input type="button" value="搜索" class="Mybotton" onclick="searchFunc()">
					</td>
				</tr>
			</table>
		</div>
</body>
</html>