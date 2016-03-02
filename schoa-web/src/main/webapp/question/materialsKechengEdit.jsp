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
<title>编辑教材下课文</title>
</head>
<body>
<div id="div_panel_id">
<h3>教材：${materials.name }</h3>
<form name="form1" action="saveMaterialsKecheng.do" method="post" onsubmit="return save()">
	<input type="hidden" id="hideMaterialsId" name="hideMaterialsId" value="${materials.id }">
	<input type="hidden" id="hideId" name="hideId" value="${kecheng.id }">
	<table class="Mytable">
		<tr>
			<td width="80px">课文名称:<span style="color: red">*</span></td>
			<td>
				<input type="text" class="Mytext" name="name" id="name" value="${kecheng.name }">
			</td>
		</tr>
		<tr>
			<td>课文说明:</td>
			<td>
				<textarea name="directions" id="directions" rows="15" cols="20" style="width: 500px;">${kecheng.directions }</textarea>
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
			alert("请填写“课文名称”！");
			$("name").focus();
			return false;
		}
	};
	new Ext.Viewport({
		layout : 'fit',
		items : [{
			title : '编辑教材下课文',
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