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
		<form action="initReportStudyZhM.do" onsubmit="return save()">
			<input type="hidden" id="studentId" name="studentId" value="${studentId }">
			<table class="Mytable" style="width: 30%">
				<tr>
					<td>学习开始时间:<span style="color: red">*</span></td>
					<td>
						<div id="startDateDiv"></div>
					</td>
				</tr>
				<tr>
					<td>学习结束时间:<span style="color: red">*</span></td>
					<td>
						<div id="endDateDiv"></div>
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
			title : '学生证明',
			bodyStyle:'padding:5px', 
			border : false,
			frame : false,
			autoScroll : true,
			contentEl : 'div_panel_id'
		}]
	});
	
	var st = new Ext.form.DateField({
		renderTo : 'startDateDiv',
		format : 'Y-m-d',
		name : 'startDT',
		id : 'startDT'
	});
	var ed = new Ext.form.DateField({
		renderTo : 'endDateDiv',
		format : 'Y-m-d',
		name : 'endDT',
		id : 'endDT'
	}); 
	
	this.save = function(){
		if(_isNull($("startDT").value)){
			alert("请填写学习开始时间！");
			$("startDT").focus();
			return false;
		}
		if(_isNull($("endDT").value)){
			alert("请填写学习结束时间！");
			$("endDT").focus();
			return false;
		}
		if(!isDate($("startDT").value)){
			alert("学习开始时间日期格式错误！");
			$("startDT").focus();
			return false;
		}
		if(!isDate($("endDT").value)){
			alert("学习结束时间日期格式错误！");
			$("endDT").focus();
			return false;
		}
	};
});


</script>

</html>