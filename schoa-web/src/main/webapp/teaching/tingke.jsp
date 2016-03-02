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
	<script type="text/javascript" src="<%=syspath%>/teaching/tingke.js"></script>
</head>
<body>
		<!-- 是否是管理员 -->
		<input type="hidden" id="isadmin" name="isadmin" value="${admin }">
		
		<div id="search_div_id">
			<table class="Mytable">
				<tr>
					<td class="Myfont">
						学期： 
						<select id="xueqiId"
							onchange="chooseClasses()">
								<option value="0">请选择...
									<c:forEach items="${xueqiList }" var="xq">
										<option
											<c:if test="${xueqiId == xq.id}">selected="selected"</c:if>
											value="${xq.id}">${xq.name}
									</c:forEach>
						</select> 
						班级： 
						<select id="classesId"
							onchange="chooseKecheng()">
								<option value="0">请选择...
									<c:forEach items="${classList }" var="obj">
										<option
											<c:if test="${classesId == obj.id}">selected="selected"</c:if>
											value="${obj.id}">${obj.name}
									</c:forEach>
						</select> 
						被检查课程: 
						<select id="kechengId" >
								<option value="0">请选择...
									<c:forEach items="${kechengList }" var="obj">
										<option
											<c:if test="${kechengId == obj.id}">selected="selected"</c:if>
											value="${obj.id}">${obj.name}
									</c:forEach>
						</select> 
						
						｜
						
						督写教师: 
						<select id="teacherId">
							<option value="0">请选择...
							<c:forEach items="${teachers }" var="obj">
								<option
									<c:if test="${teacherId == obj.id}">selected="selected"</c:if>
									value="${obj.id}">${obj.name}
							</c:forEach>
						</select>
						<input type="button" value="搜索" class="Mybotton" onclick="searchFunc()">	
					</td>
				</tr>
			</table>
		</div>
</body>
</html>