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
	<link rel="stylesheet" type="text/css" href="<%=syspath%>/utils/fileuploadfield.css" />
	<script type="text/javascript" src="<%=syspath%>/utils/FileUploadField.js"></script>
	<script type="text/javascript" src="<%=syspath%>/utils/fileUpLoad2.js"></script>
	
	<script type="text/javascript" src="<%=syspath%>/teaching/windowJiaoxueFile.js"></script>
	<script type="text/javascript" src="<%=syspath%>/manager/kecheng.js"></script>
</head>
<body>
<div id="search_div_id">
			<table class="Mytable">
				<tr>
					<td class="Myfont">
						选择学期：
						<%int _x = 0; %>
						<select id="xueqi">
							<option value="0">请选择...
							<c:forEach items="${xueqis }" var="xq">
								<option value="${xq.id}" <%if(_x==0){out.print("selected='selected'");_x++;} %>>${xq.name}
							</c:forEach>
						</select>
						任课教师:
						<select id="teacher">
							<option value="0">请选择...
							<c:forEach items="${teachers }" var="tc">
								<option value="${tc.id}">${tc.name}
							</c:forEach>
						</select>
						课程名：
						<input type="text" name="name" id="name">
						<input type="button" value="搜索" class="Mybotton" onclick="searchFunc()">
					</td>
				</tr>
			</table>
		</div>
</body>
</html>