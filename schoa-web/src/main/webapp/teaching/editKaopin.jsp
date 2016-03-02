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
	<script type="text/javascript" src="<%=syspath%>/teaching/editKaopin.js"></script>
</head>
<body>
<div id="div_panel_id">
<form name="form1" action="saveJiaoxueKaopin.do" method="post" onsubmit="return save()">
	<input type="hidden" id="hideId" name="hideId" value="${kaopin.id }">
	<input type="hidden" id="hideBanji" name="hideBanji" value="${kaopin.banjiId }">
	<input type="hidden" id="hideKecheng" name="hideKecheng" value="${kaopin.kechengId }">
	<table class="Mytable">
		<tr>
			<td width="80px">考评名称:<span style="color: red">*</span></td>
			<td>
				<input type="text" class="Mytext" name="name" id="name" value="${kaopin.name }">
			</td>
		</tr>
		<tr>
			<td>学期:<span style="color: red">*</span></td>
			<td>
				<select id="xueqiId" name="xueqiId" onchange="chooseClasses()" <c:if test="${not empty kaopin }">disabled="disabled"</c:if>>
					<option value="0">请选择...
					<c:forEach items="${xueqiList }" var="xq">
						<option <c:if test="${xq.id == kaopin.xueqiId }">selected="selected"</c:if>  value="${xq.id}">${xq.name}
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>班级:<span style="color: red">*</span></td>
			<td>
				<select id="classesId" name="classesId" onchange="chooseKecheng()" <c:if test="${not empty kaopin }">disabled="disabled"</c:if>>
					<option value="0">请选择...
				</select>
			</td>
		</tr>
		<tr>
			<td>课程:<span style="color: red">*</span></td>
			<td>
				<select id="kechengId" name="kechengId" <c:if test="${not empty kaopin }">disabled="disabled"</c:if>>
					<option value="0">请选择...
				</select>
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