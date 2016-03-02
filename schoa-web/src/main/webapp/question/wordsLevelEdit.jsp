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
<title>编辑词汇级别</title>
</head>
<body>
<div id="div_panel_id">
<h3>词汇标准：${standard.name }</h3>
<form name="form1" action="saveWordsLevel.do" method="post" onsubmit="return save()">
	<input type="hidden" id="hideStandardId" name="hideStandardId" value="${standard.id }">
	<input type="hidden" id="hideId" name="hideId" value="${wordsLevel.id }">
	<table class="Mytable">
		<tr>
			<td width="80px">级别名称:<span style="color: red">*</span></td>
			<td>
				<input type="text" class="Mytext" name="name" id="name" value="${wordsLevel.name }">
			</td>
		</tr>
		<tr>
			<td width="80px">级别排序:<span style="color: red">*</span></td>
			<td>
				<select id="levelSort" name="levelSort">
					<option value="0">请选择...
					<c:forEach begin="1" end="10" step="1" var="i">
						<option  value="${i }" <c:if test="${wordsLevel.levelSort == i}">selected="selected"</c:if>>${i}
					</c:forEach>
				</select>
			</td>
		</tr>
		
		<tr>
			<td>匹配百分比:<span style="color: red">*</span></td>
			<td>
				<input id="percent" name="percent" value="${wordsLevel.percent }" style="width: 80px;">%
			</td>
		</tr>
		
		<tr>
			<td>级别内容:<span style="color: red">*</span></td>
			<td>
				<textarea name="content" id="content" rows="27" cols="20" style="width: 500px;">${wordsLevel.content }</textarea>
			</td>
		</tr>
		
		<tr>
			<td>级别说明:</td>
			<td>
				<textarea name="directions" id="directions" rows="5" cols="20" style="width: 500px;">${wordsLevel.directions }</textarea>
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

<script type="text/javascript">
Ext.onReady(function(){
	this.save = function(){
		if(_isNull($("name").value)){
			alert("请填写“级别名称”！");
			$("name").focus();
			return false;
		}
		
		if($("levelSort").value <= 0){
			alert("请选择“级别排序”！");
			$("levelSort").focus();
			return false;
		}
		
		var percent = $("percent").value;
		if(_isNull(percent)){
			alert("请填写“匹配百分比”！");
			$("percent").focus();
			return false;
		}
		
		if(!regexVerify('tingke',percent) || percent > 100 || percent <= 0){
			alert("请正确填写“匹配百分比”！");
			$("percent").focus();
			return false;
		}
		
		if(_isNull($("content").value)){
			alert("请填写“级别内容”！");
			$("content").focus();
			return false;
		}
		
		
	};
	new Ext.Viewport({
		layout : 'fit',
		items : [{
			title : '编辑词汇级别',
			bodyStyle:'padding:5px', 
			border : false,
			frame : false,
			autoScroll : true,
			contentEl : 'div_panel_id'
		}]
	});
});
</script>
</html>