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
    text-align: left;
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

</style>
<title>
</title>
	<script type="text/javascript" src="<%=syspath%>/utils/jquery.js"></script>
	<script type="text/javascript" src="<%=syspath%>/utils/blockUI.js"></script>
</head>
<body>
	<h1>外聘教师工作绩效</h1>
	<table style="border:0px; width:100%" >
		<tr>
			<td style="border:0px;" align="left">
				学期：
				<select id="xueqiId">
					<option value="0">请选择...
					<c:forEach items="${xueqiList }" var="xq">
						<option 
						<c:if test="${xq.id == xueqiId }">selected="selected"</c:if>
						value="${xq.id}">${xq.name}
					</c:forEach>
				</select>
				
				<input type="button" value="搜索" class="Mybotton" onclick="searchFunc()">
			</td>
		</tr>
	</table>
	
<div style="overflow: auto;" id="div_id">
	<table>
		<tr style="background: #ECECFF;">
			<td>教师</td>
<!-- 			<td>学期</td> -->
			<td>班级</td>
			<td>课程</td>
			<td>教学考评(30分)</td>
			<td>上课出勤(15分)</td>
			<td>教学文件(20分)</td>
			<td>听课情况(10分)</td>
			<td>开会出勤(10分)</td>
			<td>学生活动(5分)</td>
			<td>教案(10分)</td>
			<td>特殊贡献</td>
			<td>优秀</td>
			<td>总分</td>
			<td>操作</td>
		</tr>
		
		<c:choose>
			<c:when test="${not empty map }">
					
				<%int i=0; String color = "";%>
				<c:forEach var="entry" items="${map }">
				<c:set var="item" value="${entry.value }"/>
				<c:set var="size" value="${fn:length(item.jixiao)}"/>
				<%color=i%2!=0?"#fffff0":"";i++;%>
			
				<tr style="background-color: <%=color%>;">
					<td rowspan="${size}">${item.teacherName}</td>
		<%-- 			<td rowspan="${size}">${item.xueqiName}</td> --%>
					
					<c:forEach begin="0" end="0" items="${item.jixiao }" var="obj">
						<td>${obj.banjiName }</td>
						<td>${obj.kechengName }</td>
						<td><fmt:formatNumber value="${obj.scKaopin}" pattern="##.##" minFractionDigits="2" /></td>
						<td><fmt:formatNumber value="${obj.scChuqin}" pattern="##.##" minFractionDigits="2" /></td>
						<td><fmt:formatNumber value="${obj.scJiaoxuefile}" pattern="##.##" minFractionDigits="2" /></td>
						<td><fmt:formatNumber value="${obj.scTingke}" pattern="##.##" minFractionDigits="2" /></td>
					</c:forEach>
		
					<td  rowspan="${size}"><fmt:formatNumber value="${item.scKaihui}" pattern="##.##" minFractionDigits="2" /></td>
					<td  rowspan="${size}"><fmt:formatNumber value="${item.scHuodong}" pattern="##.##" minFractionDigits="2" /></td>
					<td  rowspan="${size}"><fmt:formatNumber value="${item.scYinxiang}" pattern="##.##" minFractionDigits="2" /></td>
					<td  rowspan="${size}"><fmt:formatNumber value="${item.scGongxian}" pattern="##.##" minFractionDigits="2" /></td>
					<td  rowspan="${size}">${item.youxiu==1?'<span style="color:red;">√</span>':''}</td>
					<td  rowspan="${size}"><fmt:formatNumber value="${item.total }" pattern="##.##" minFractionDigits="2" /></td>
					<td  rowspan="${size}">
						<input type="button" onclick="modifyItem(${item.xueqiId},${item.teacherId})" value="修改">
					</td>
				</tr>
					<c:forEach begin="1" end="${size}" items="${item.jixiao }" var="obj">
					<tr style="background-color: <%=color%>;">
						<td>${obj.banjiName }</td>
						<td>${obj.kechengName }</td>
						<td><fmt:formatNumber value="${obj.scKaopin}" pattern="##.##" minFractionDigits="2" /></td>
						<td><fmt:formatNumber value="${obj.scChuqin}" pattern="##.##" minFractionDigits="2" /></td>
						<td><fmt:formatNumber value="${obj.scJiaoxuefile}" pattern="##.##" minFractionDigits="2" /></td>
						<td><fmt:formatNumber value="${obj.scTingke}" pattern="##.##" minFractionDigits="2" /></td>
					</tr>
					</c:forEach>
				</c:forEach>
			</c:when>
			<c:otherwise>
			<tr><td colspan="14" style="text-align: center;">暂无数据</td></tr>
			</c:otherwise>
		</c:choose>
		
	</table>
	
</div>
</body>
<script type="text/javascript">
(function() {
	
	this.searchFunc = function(){
		var xueqiId = document.getElementById("xueqiId").value;
		if(xueqiId==0){
			alert("请选择学期！");
			return;
		}
		location.href = "initWaipinJixiao.do?xueqiId="+xueqiId;
	};
	
	this.modifyItem = function(xueqiId,teacherId){
		location.href = "initEditWaipinJixiao.do?xueqiId="+xueqiId+"&teacherId="+teacherId;
	};
	
})();

document.getElementById("div_id").style.height = (document.documentElement.clientHeight - 90) + "px";
</script>
</html>