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
	font: 12px Verdana, Arial, Helvetica, sans-serif;
} 
table{   
    border:1px solid #99bbe8;   
    border-collapse:collapse; 
    text-align: center;
}   
table td {   
    border:1px solid #ededed;
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
select{
	font: 10px Verdana, Arial, Helvetica, sans-serif;
	width: 140px;
	margin: 10px 0px 10px 0px;
}
img{
	cursor:pointer; 
	margin-left: 5px;
	margin-right: 5px;
}
</style>
<title>
</title>
	<script type="text/javascript" src="<%=syspath%>/utils/jquery.js"></script>
	<script type="text/javascript" src="<%=syspath%>/manager/paike.js"></script>
	
</head>
<body>
	<h1>排课管理</h1>
	<h3>学期：${classes.xueqi.name }</h3>
	<h3>班级：${classes.name }</h3>
	<c:if test="${isHaveKaoqin }">
		<h3>
			<span style="color: red;">注意：该班级已经存在考勤记录，不可以修改！</span>
		</h3>
	</c:if>
	
	<input type="hidden" value="${classes.id }" id="hidenClassesId" name="hidenClassesId">
	<table id="tableId">
		<tr>
			<th>
				Time/Day
			</th>
			<th>
				周一Monday
			</th>
			<th>
				周二Tuesday
			</th>
			<th>
				周三Wednesday
			</th>
			<th>
				周四Thursday
			</th>
			<th>
				周五Friday
			</th>
			<th>
				周六Saturday
			</th>
			<th>
				周日Sunday
			</th>
			<c:if test="${!isHaveKaoqin }">
			<th>
				操作
			</th>
			</c:if>
		</tr>
		<c:forEach items="${paikeMap }" var="map">
		<c:set value="${map.value }" var="paike"/>
		<tr class="row">
			<td>
				<select style="width: 68px;">
					<option value="0">请选择
					<c:forEach items="${timeList }" var="tm">
					<option 
					<c:if test="${paike.startStr == tm}">selected="selected"</c:if>
					value="${tm}">${tm}
					</c:forEach>
				</select>
				-
				<select style="width: 68px;">
					<option value="0">请选择
					<c:forEach items="${timeList }" var="tm">
					<option 
					<c:if test="${paike.endStr == tm}">selected="selected"</c:if>
					value="${tm}">${tm}
					</c:forEach>
				</select>
			</td>
			<td>
				<select>
					<option value="0">请选择
					<c:forEach items="${kechengList }" var="kc">
					<option 
					<c:if test="${kc.id ==  paike.wks[0]}">selected="selected"</c:if>
					value="${kc.id }">${kc.name }-${kc.teacher.name }
					</c:forEach>
				</select>
			</td>
			<td>
				<select>
					<option value="0">请选择
					<c:forEach items="${kechengList }" var="kc">
					<option 
					<c:if test="${kc.id ==  paike.wks[1]}">selected="selected"</c:if>
					value="${kc.id }">${kc.name }-${kc.teacher.name }
					</c:forEach>
				</select>
			</td>
			<td>
				<select>
					<option value="0">请选择
					<c:forEach items="${kechengList }" var="kc">
					<option 
					<c:if test="${kc.id ==  paike.wks[2]}">selected="selected"</c:if>
					value="${kc.id }">${kc.name }-${kc.teacher.name }
					</c:forEach>
				</select>
			</td>
			<td>
				<select>
					<option value="0">请选择
					<c:forEach items="${kechengList }" var="kc">
					<option 
					<c:if test="${kc.id ==  paike.wks[3]}">selected="selected"</c:if>
					value="${kc.id }">${kc.name }-${kc.teacher.name }
					</c:forEach>
				</select>
			</td>
			<td>
				<select>
					<option value="0">请选择
					<c:forEach items="${kechengList }" var="kc">
					<option 
					<c:if test="${kc.id ==  paike.wks[4]}">selected="selected"</c:if>
					value="${kc.id }">${kc.name }-${kc.teacher.name }
					</c:forEach>
				</select>
			</td>
			<td>
				<select>
					<option value="0">请选择
					<c:forEach items="${kechengList }" var="kc">
					<option 
					<c:if test="${kc.id ==  paike.wks[5]}">selected="selected"</c:if>
					value="${kc.id }">${kc.name }-${kc.teacher.name }
					</c:forEach>
				</select>
			</td>
			<td>
				<select>
					<option value="0">请选择
					<c:forEach items="${kechengList }" var="kc">
					<option 
					<c:if test="${kc.id ==  paike.wks[6]}">selected="selected"</c:if>
					value="${kc.id }">${kc.name }-${kc.teacher.name }
					</c:forEach>
				</select>
			</td>
			<c:if test="${!isHaveKaoqin }">
			<td>
				<img src="imgs/erase.ico" alt="删除" onclick="removeRow(this)">
			</td>
			</c:if>
		</tr>
		</c:forEach>
	</table>
	<p>
	<c:if test="${!isHaveKaoqin }">
	<table style="border:0px solid #99bbe8;width:20%;">
		<tr>
			<td style="border:0px solid #99bbe8;">
				<img src="imgs/add.ico" alt="添加" onclick="addRow()"></td>
			<td style="border:0px solid #99bbe8;">
				<img src="imgs/save.png" alt="保存" onclick="save()"></td>
		</tr>
		<tr>
			<td style="border:0px solid #99bbe8;">
				<span style="cursor:pointer;" onclick="addRow()">添加</span></td>
			<td style="border:0px solid #99bbe8;">
				<span style="cursor:pointer;" onclick="save()">保存</span></td>
		</tr>
	</table>
	</c:if>
</body>
</html>