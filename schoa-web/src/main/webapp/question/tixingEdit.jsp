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
<title>编辑题型</title>
</head>
<body>
<div id="div_panel_id">
<form name="form1" action="saveTixing.do" method="post" onsubmit="return save()">
	<input type="hidden" id="hideId" name="hideId" value="${tixing.id }">
	<table class="Mytable">
		<tr>
			<td width="80px">标题:<span style="color: red">*</span></td>
			<td>
				<input type="text" class="Mytext" name="title" id="title" value="${tixing.title }">
			</td>
		</tr>
		<tr>
			<td>副标题:</td>
			<td>
				<input type="text" class="Mytext" name="subtitle" id="subtitle" value="${tixing.subtitle }">
			</td>
		</tr>
		<tr>
			<td>默认试题数:<span style="color: red">*</span></td>
			<td>
				<select id="amount" name="amount">
					<c:forEach begin="1" end="30" step="1" var="i">
						<option  value="${i }" <c:if test="${tixing.amount == i}">selected="selected"</c:if>>${i}
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>试卷中排序:<span style="color: red">*</span></td>
			<td>
				<select id="sort" name="sort">
					<option value="0">请选择...
					<c:forEach begin="1" end="20" step="1" var="i">
						<option  value="${i }" <c:if test="${tixing.sort == i}">selected="selected"</c:if>>${i}
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>评分标准:</td>
			<td>
				<textarea name="standardInfo" id="standardInfo" rows="15" cols="20" style="width: 500px;">${tixing.standardInfo }</textarea>
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
		if(_isNull($("title").value)){
			alert("请填写“标题”！");
			$("title").focus();
			return false;
		}
		if($('amount').value <= 0){
			alert('生成试卷时的“默认试题数”数量不能为0！');
			$("amount").focus();
			return false;
		}
		if($("sort").value <= 0){
			alert("请选择“试卷中排序”！");
			$("sort").focus();
			return false;
		}
	};
	new Ext.Viewport({
		layout : 'fit',
		items : [{
			title : '编辑题型',
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
