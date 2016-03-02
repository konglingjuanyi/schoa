<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../import.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

	<div id="div_panel_id">
		<form action="initReportStudentChuqin.do" onsubmit="return save()">
			<input type="hidden" id="classesId" name="classesId" value="${classesId }">
			<input type="hidden" id="studentId" name="studentId" value="${studentId }">
			<table class="Mytable" style="width: 50%">
				<tr>
					<td colspan="2">
						<b>学生：${student.cname }</b>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<b>班级：${banji.name }</b>
					</td>
				</tr>
				<tr>
					<td>开始时间:<span style="color: red">*</span></td>
					<td>
						<span style="color: red" id="startDT_show"></span>
						<select id="startDT" name="startDT" onchange="showStartValue(this)">
							<%int i = 1; %>
							<c:forEach items="${weekList }" var="wk">
								<option value="${fn:split(wk,'~')[0]}">第<%=(i++) %>周(${wk})
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>结束时间:<span style="color: red">*</span></td>
					<td>
						<span style="color: red" id="endDT_show"></span>
						<select id="endDT" name="endDT" onchange="showEndValue(this)">
							<%int j = 1; %>
							<c:forEach items="${weekList }" var="wk">
								<option value="${fn:split(wk,'~')[1]}">第<%=(j++) %>周(${wk})
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="确定" class="Mybotton">
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
<script type="text/javascript">
Ext.onReady(function(){
	
	new Ext.Viewport({
		layout : 'fit',
		items : [{
			title : '打印学生出勤情况',
			bodyStyle:'padding:5px', 
			border : false,
			frame : false,
			autoScroll : true,
			contentEl : 'div_panel_id'
		}]
	});
	
	this.showStartValue = function(select){
		document.getElementById("startDT_show").innerHTML=select.value;
	}
	this.showEndValue = function(select){
		document.getElementById("endDT_show").innerHTML=select.value;
	}
	
	document.getElementById("startDT_show").innerHTML=document.getElementById("startDT").value;
	document.getElementById("endDT_show").innerHTML=document.getElementById("endDT").value;
	

	this.save = function(){
		if(_isNull($("startDT").value)){
			alert("请选择开始时间！");
			$("startDT").focus();
			return false;
		}
		if(_isNull($("endDT").value)){
			alert("请选择结束时间！");
			$("endDT").focus();
			return false;
		}
	};
});


</script>

</html>