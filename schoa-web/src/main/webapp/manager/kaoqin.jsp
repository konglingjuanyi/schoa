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
	<script type="text/javascript" src="<%=syspath%>/manager/kaoqin.js"></script>
	
</head>
<body>
	<h1>考勤管理</h1>
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
			<td style="border:0px;">
<%-- 				<c:if test="${canmodifiy == true }"> --%>
<!-- 					<button class="Printbotton" onclick="commitFunc()"> -->
<!-- 						<img src="imgs/upload.png" style="margin-right: 5px;">提交 -->
<!-- 					</button> -->
<%-- 				</c:if> --%>
				<button class="Printbotton" onclick="reportClassEmptyKaoqin()">
					<img src="imgs/print.png" style="margin-right: 5px;">空考勤
				</button>
				<button class="Printbotton" onclick="reportClassWeekKaoqin()">
					<img src="imgs/print.png" style="margin-right: 5px;">周考勤
				</button>
			</td>
		</tr>
	</table>
	
<div style="overflow: auto;" id="div_id">
<c:choose>
<c:when test="${not empty modelMap }">
	<table>
	<tr style="background: #ECECFF;">
		<td rowspan="2">
			序号
		</td>
		<td rowspan="2">
			姓名／时间
		</td>
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
	<%
		int line = 0; 
	%>
	<c:forEach items="${stuList }" var="stu">
	<%
		line++; 
	%>
	<c:choose>
		 <c:when test="${stu.state == 2 }">
		 	<tr style='background-color: #C0C0C0;'>
		 </c:when>
		 <c:otherwise>
			 <%
				if(line%2!=0){
					out.print("<tr style='background-color: #fffff0;'>");
				}else{
					out.print("<tr>");
				}
			%>
		 </c:otherwise>
	</c:choose>
		<td>
			<%out.print(line);%>
		</td>
		<td>
			${stu.cname }
			<c:if test="${stu.state == 2 }">
				(离校)
			</c:if>
		</td>
		<c:forEach items="${modelMap }" var="map">
		<c:set value="${map.value }" var="model"/>
		<c:if test="${(not empty model.ls) && fn:length(model.ls)>0}">
			<c:forEach items="${model.ls }" var="obj">
				<c:set value="k_${stu.id }_${obj.id }" var="key"/>
				<td id="${key }" 
				<c:if test="${canmodifiy == true }">
					onclick="showWindow(this,${stu.id },'${stu.cname }',${obj.id },'${obj.kechengName }','${model.day }')" 
					style="cursor: pointer;"
				</c:if>
				>
					${WebUtil.getMapValue(kaoqinMap,key) }
				</td>
			</c:forEach>
		</c:if>
		</c:forEach>
	</tr>
	</c:forEach>
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
		<input type="hidden" id="hidPaikeId" name="hidPaikeId" value="">
		<input type="hidden" id="hidStuId" name="hidStuId" value="">
		<input type="hidden" id="hidDayId" name="hidDayId" value="">
		<input type="hidden" id="hidTDId" name="hidTDId" value="">
	</h3>
	<table style="border: 0;">
		<tr style="border: 0;">
			<td style="border: 0;">
				选择考勤：
				<select id="winKaoqin">
					<c:forEach items="${kaoqinTypes }" var="item">
					<option value="${item.key }">${item.value}
					</c:forEach>
				</select>
			</td>
			<td style="border: 0;">
				<input type="button" value="确定" class="Mybotton" onclick="saveKaoqin()">
				<input type="button" value="关闭" class="Mybotton" onclick="closeWin()">
			</td>
		</tr>
	</table>
	</div>
</div>
	
<script type="text/javascript">
document.getElementById("div_id").style.height = (document.documentElement.clientHeight - 95) + "px";
</script>	
</body>
</html>