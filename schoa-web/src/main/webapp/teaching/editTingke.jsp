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
	<script type="text/javascript" src="<%=syspath%>/teaching/editTingke.js"></script>
</head>
<body>
<div id="div_panel_id">
<form name="form1" action="saveTingke.do" method="post" onsubmit="return save()">
	<input type="hidden" id="hideId" name="hideId" value="${tingke.id }">
	<input type="hidden" id="hideBanji" name="hideBanji" value="${tingke.banjiId }">
	<input type="hidden" id="hideKecheng" name="hideKecheng" value="${tingke.kechengId }">
	<table class="Mytable">
		<tr>
			<td>学期:<span style="color: red">*</span></td>
			<td>
				<select id="xueqiId" name="xueqiId" onchange="chooseClasses()">
					<option value="0">请选择...
					<c:forEach items="${xueqiList }" var="xq">
						<option <c:if test="${xq.id == tingke.xueqiId }">selected="selected"</c:if>  value="${xq.id}">${xq.name}
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>班级:<span style="color: red">*</span></td>
			<td>
				<select id="classesId" name="classesId" onchange="chooseKecheng()">
					<option value="0">请选择...
				</select>
			</td>
		</tr>
		<tr>
			<td>被检查课程:<span style="color: red">*</span></td>
			<td>
				<select id="kechengId" name="kechengId">
					<option value="0">请选择...
				</select>
			</td>
		</tr>
		<tr>
			<td>督写教师:<span style="color: red">*</span></td>
			<td>
				<select id="duxieTeacherId" name="duxieTeacherId">
					<option value="0">请选择...
					<c:forEach items="${teachers }" var="tc">
						<option <c:if test="${tc.id == tingke.duxieTeacherId }">selected="selected"</c:if>  value="${tc.id}">${tc.name}
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td width="80px">得分:<span style="color: red">*</span></td>
			<td>
				<input type="text" style="width: 70px" id="score" name="score" value="${tingke.score }">
				不大于10，且如果是小数请保留两位小数点
<!-- 				<select name="score" id="score"> -->
<%-- 					<c:forEach begin="0" end="10" step="1" var="sc"> --%>
<%-- 					<option value="${sc }" <c:if test="${tingke.score - sc == 0 }">selected="selected"</c:if>>${sc } --%>
<%-- 					</c:forEach> --%>
<!-- 				</select> -->
			</td>
		</tr>
		<tr>
			<td width="80px">听课时间:<span style="color: red">*</span></td>
			<td>
				<input type="text" class="Mytext" name="tingkeTime" id="tingkeTime" value="${tingke.tingkeTime}">
				格式如：2014-05-01 10:00-12:00
			</td>
		</tr>
		<tr>
			<td width="80px">备注:</td>
			<td>
				<textarea name="remark" id="remark" rows="15" cols="20" style="width: 500px;">${tingke.remark }</textarea>
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