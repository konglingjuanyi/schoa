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
	<script type="text/javascript" src="<%=syspath%>/manager/xueqiEdit.js"></script>
</head>
<body>
<div id="div_panel_id">
<form name="form1" action="saveXueqi.do" method="post" onsubmit="return save()">
	<input type="hidden" id="hideId" name="hideId" value="${xueqi.id }">
	<input type="hidden" id="hideStartDate" name="hideStartDate" value="${xueqi.startDateStr }">
	<input type="hidden" id="hideEndDate" name="hideEndDate" value="${xueqi.endDateStr }">
	<input type="hidden" id="hideShuxing" name="hideShuxing" value="${xueqi.shuxing }">
	<input type="hidden" id="haveKaoqin" name="haveKaoqin" value="${haveKaoqin }">
	<table class="Mytable">
		<tr>
			<td width="80px">学期名称:<span style="color: red">*</span></td>
			<td>
				<input type="text" class="Mytext" name="name" id="name" value="${xueqi.name }">
			</td>
		</tr>
		<tr>
			<td>开始日期:<span style="color: red">*</span></td>
			<td>
				<div id="startDateDiv"></div>
			</td>
		</tr>
		<tr>
			<td>结束日期:<span style="color: red">*</span></td>
			<td>
				<div id="endDateDiv"></div>
			</td>
		</tr>
		<tr>
			<td>属性</td>
			<td>
				<input type="radio" id="shuxing_0" name="shuxing" value="0" <c:if test="${xueqi.shuxing == 0}">checked="checked"</c:if>>长期
				<input type="radio" id="shuxing_1" name="shuxing" value="1" <c:if test="${xueqi.shuxing == 1}">checked="checked"</c:if>>短期
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
</html>