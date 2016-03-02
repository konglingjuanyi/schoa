<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../import.jsp"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
	<script type="text/javascript" src="<%=syspath%>/manager/classesEdit.js"></script>
</head>
<body>
<div id="div_panel_id">
<form name="form1" action="saveClasses.do" method="post" onsubmit="return save()">
	<input type="hidden" id="hideId" name="hideId" value="${clazz.id }">
	<table class="Mytable">
		<tr>
			<td width="80px">班级名称:<span style="color: red">*</span></td>
			<td>
				<input type="text" class="Mytext" name="name" id="name" value="${clazz.name }">
			</td>
		</tr>
		<tr>
			<td>学期:<span style="color: red">*</span></td>
			<td>
				<select id="xueqiId" name="xueqiId">
					<option value="0">请选择...
					<c:forEach items="${xueqis }" var="xq">
						<option <c:if test="${xq.id == clazz.xueqiId }">selected="selected"</c:if>  value="${xq.id}">${xq.name}
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>班主任:<span style="color: red">*</span></td>
			<td>
				<select id="teacherId" name="teacherId">
					<option value="0">请选择...
					<c:forEach items="${teacherIds }" var="tc">
						<option <c:if test="${tc.id == clazz.teacherId }">selected="selected"</c:if> value="${tc.id}">${tc.name}
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>备注:</td>
			<td>
				<textarea name="rmark" id="rmark" cols="80" rows="3" class="Mytextarea">${clazz.rmark }</textarea>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td colspan="2">
				<input type="submit" value="确定" class="Mybotton">
				<input type="button" value="取消" class="Mybotton" onclick="_back()">
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>