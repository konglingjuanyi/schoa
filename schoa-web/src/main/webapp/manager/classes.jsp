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
	<script type="text/javascript" src="<%=syspath%>/manager/classes.js"></script>
</head>
<body>
		<div id="search_div_id">
			<table class="Mytable">
				<tr>
					<td class="Myfont">
						选择学期：<%int i=0; %>
						<select id="xueqi">
							<option value="0">请选择...
							<c:forEach items="${xueqis }" var="xq">
								<option value="${xq.id}" <%if(i==0){out.print("selected=\"selected\"");};i++; %>>${xq.name}
							</c:forEach>
						</select>
						<input type="button" value="搜索" class="Mybotton" onclick="searchFunc()">
					</td>
				</tr>
			</table>
		</div>
</body>
</html>