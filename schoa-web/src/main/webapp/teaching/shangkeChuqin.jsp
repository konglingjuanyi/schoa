<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String syspath = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body{
	font: 10px Verdana, Arial, Helvetica, sans-serif;
} 
table{   
    border:1px solid #99bbe8;   
    border-collapse:collapse; 
	width:100%;
    text-align: center;
}   
table td {   
    border:1px solid #99bbe8; 
    padding: 5px;
}   
table th {   
    border:1px solid #99bbe8;   
	background-color: #dfe8f6;
    padding: 5px;
}   
h3{
	color: blue;
}
h5{
	color: red;
}
.time{
	width: 40px;
}
img{
	cursor:pointer; 
	margin-left: 5px;
	margin-right: 5px;
}
.Mybotton{
	 padding: 5px 15px 5px 15px;
	 margin: 10px;
}
.Mybotton{
	padding: 5px 10px 5px 10px;
	margin: 2px 0px 2px 5px;
}
.Printbotton{
	 padding: 2px 10px 4px 10px;
	 margin: 2px 0px 2px 5px;
}
select{
				margin-right: 20px;
			}
#box{ width:340px; margin:0 auto; background:#fff; border:1px solid #ccc; padding:20px; display:none; -webkit-border-radius: 10px;-moz-border-radius: 10px; display:none; } 

</style>
<title>
</title>
	<script type="text/javascript" src="<%=syspath%>/utils/jquery.js"></script>
	<script type="text/javascript" src="<%=syspath%>/utils/blockUI.js"></script>
	<script type="text/javascript" src="<%=syspath%>/teaching/shangkeChuqin.js"></script>
	
</head>
<body>
		<!-- 是否是管理员 -->
		<input type="hidden" id="isadmin" name="isadmin" value="${admin }">
		
	<h1>教师上课出勤</h1>
	<table style="border:0px; width:100%" >
		<tr>
			<td style="border:0px;" align="left">
				学期：
				<select id="xueqi" onchange="chooseClasses()">
					<option value="0">请选择...
					<c:forEach items="${xueqiList }" var="xq">
						<option 
						<c:if test="${xq.id == xueqi }">selected="selected"</c:if>
						value="${xq.id}">${xq.name}
					</c:forEach>
				</select>
				班级：
				<select id="classes">
					<option value="0">请选择...
					<c:forEach items="${classList }" var="cs">
						<option 
						<c:if test="${cs.id == classes }">selected="selected"</c:if>
						value="${cs.id}">${cs.name}
					</c:forEach>
				</select>
				周：
				<select id="weeks">
					<option value="0">请选择...
					<%int i = 1; %>
					<c:forEach items="${weekList }" var="wk">
						<option 
						<c:if test="${fn:contains(weeks, wk) }">selected="selected"</c:if>
						value="${wk}">第<%=(i++) %>周(${wk})
					</c:forEach>
				</select>
				<input type="button" value="搜索" class="Mybotton" onclick="searchFunc()">
			</td>
		</tr>
	</table>
	
<div style="overflow: auto;height:470px;">
<c:choose>
<c:when test="${not empty modelMap }">
	<table>
		<tr style="background: #ECECFF;">
			<c:forEach items="${modelMap }" var="map">
			<c:set value="${map.value }" var="model"/>
			<c:if test="${(not empty model.ls) && fn:length(model.ls)>0}">
				<td colspan="${fn:length(model.ls) }">
					${model.weekName }
				</td>
			</c:if>
			</c:forEach>
		</tr>
		
		<tr style="background: #ECECFF;">
			<c:forEach items="${modelMap }" var="map">
			<c:set value="${map.value }" var="model"/>
			<c:if test="${(not empty model.ls) && fn:length(model.ls)>0}">
				<c:forEach items="${model.ls }" var="obj">
					<td>
						${obj.start }-${obj.end }<br/>
						${obj.kechengName }&nbsp;
						${obj.teacherName }
					</td>
				</c:forEach>
				
			</c:if>
			</c:forEach>
		</tr>
		
		<tr>
			<c:forEach items="${modelMap }" var="map">
			<c:set value="${map.value }" var="model"/>
			<c:if test="${(not empty model.ls) && fn:length(model.ls)>0}">
				<c:forEach items="${model.ls }" var="obj">
					<c:set value="k_${obj.teacherId }_${obj.id }" var="key"/>
					<td id="${key }" 
					<c:if test="${admin }">
					onclick="showWindow(this,'${model.day }',${obj.teacherId },'${obj.teacherName }',${obj.id })" 
					</c:if>
					style="<c:if test="${admin }">cursor: pointer;</c:if>height: 20px;" >
						${WebUtil.getMapValue(kaoqinMap,key) }
					</td>
				</c:forEach>
				
			</c:if>
			</c:forEach>
		</tr>
		
		
	</table>
	</c:when>
	<c:otherwise>
		<hr style="border:0;background-color:#99bbe8;height:2px;"/>
	</c:otherwise>
</c:choose>
</div>
	
<div id="box">
	<div>
	<h3>
		<span id="winTitle"></span>
		
		<input type="hidden" id="hide_paikeId" name="hide_paikeId" value="">
		<input type="hidden" id="hide_teacherId" name="hide_teacherId" value="">
		<input type="hidden" id="hide_day" name="hide_day" value="">
		<input type="hidden" id="hide_TDId" name="hide_TDId" value="">
		
		
	</h3>
	<table style="border: 0;">
		<tr style="border: 0;">
			<td style="border: 0;" align="left">
				选择：
				<select id="winKaoqin">
					<c:forEach items="${kaoqinTypes }" var="item">
					<option value="${item.key }">${item.value}
					</c:forEach>
				</select>
			</td>
			</tr>
			<tr style="border: 0;">
			<td style="border: 0;" align="left"> 
				备注：
				<input type="text" id="winRemark" value="">
			</td>
			</tr>
			<tr style="border: 0;">
			<td style="border: 0;" align="left">
				<input type="button" value="确定" class="Mybotton" onclick="saveKaoqin()">
				<input type="button" value="关闭" class="Mybotton" onclick="closeWin()">
			</td>
		</tr>
	</table>
	</div>
</div>
	
	
</body>
</html>