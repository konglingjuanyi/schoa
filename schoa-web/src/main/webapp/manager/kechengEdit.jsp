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
	<script type="text/javascript" src="<%=syspath%>/manager/kechengEdit.js"></script>
</head>
<body>
<div id="div_panel_id">
<form name="form1" action="saveKecheng.do" method="post" onsubmit="return save()">
	<input type="hidden" id="hideId" name="hideId" value="${kecheng.id }">
	<input type="hidden" id="fileFlags" name="fileFlags" value="${kecheng.fileUploadFlags }">
	<table class="Mytable">
		<tr>
			<td width="80px">课程名称:<span style="color: red">*</span></td>
			<td>
				<input type="text" class="Mytext" name="name" id="name" value="${kecheng.name }">
			</td>
		</tr>
		<tr>
			<td>选择学期:<span style="color: red">*</span></td>
			<td>
				<select id="xueqiId" name="xueqiId">
					<option value="0">请选择...
					<c:forEach items="${xueqis }" var="xq">
						<option <c:if test="${xq.id == kecheng.xueqiId }">selected="selected"</c:if>  value="${xq.id}">${xq.name}
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>任课教师:<span style="color: red">*</span></td>
			<td>
				<select id="teacherId" name="teacherId">
					<option value="0">请选择...
					<c:forEach items="${teachers }" var="tc">
						<option <c:if test="${tc.id == kecheng.teacherId }">selected="selected"</c:if> value="${tc.id}">${tc.name}
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>周课时:</td>
			<td>
				<input type="text" name="keshi" id="keshi" class="Mytext"  value="${kecheng.keshi }">
			</td>
		</tr>
		<tr>
			<td>教材:</td>
			<td>
				<input type="text" name="jiaocai" id="jiaocai" class="Mytext"  value="${kecheng.jiaocai }">
			</td>
		</tr>

		<tr>
			<td>教学文件:<span style="color: red">*</span></td>
			<td>
			<% int tmp = 0; %>
				<c:forEach items="${fileFlagMap }" var="map">
				<label>
					<input type="checkbox" 
						<c:if test="${WebUtil.isContains(kecheng.fileFlags, map.key) }">checked="checked"</c:if> 
						name="fileFlag" value="${map.key }" style="margin: 5px">
						${map.value.name },分数：<span style="color: red;">${map.value.score }</span>
				</label>
						<br />
						<% 
							tmp++;
							if(tmp % 2 == 0){
								out.print("<br/>");
							}
						%>
				</c:forEach>
			</td>
		</tr>
	
		<tr>
			<td>课程描述:</td>
			<td>
				<textarea name="intro" id="intro" cols="80" rows="3" class="Mytextarea">${kecheng.intro }</textarea>
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
