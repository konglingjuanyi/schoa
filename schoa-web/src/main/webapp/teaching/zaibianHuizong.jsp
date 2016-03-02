<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../import.jsp"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
</title>
	<script type="text/javascript" src="<%=syspath%>/teaching/zaibianHuizong.js"></script>
	
	<style type="text/css">
		.jxtable{
			padding:5px;
			border: 0;
			margin:5px;
			width: 80%;
			border-collapse:collapse;
		}
		.jxtable tr{
			 font-size: 13px;
		 	 font: 宋体;
		 	 height : 30px;
		}
		.jxtable td {   
		    border:1px solid #99bbe8; 
		    text-align: left;
		} 
		
	.infoWin{
		border:1px solid #99bbe8;   
	    border-collapse:collapse; 
		width:98%;
	}
	
	.infoWin td {   
	    border:1px dashed #99bbe8; 
	    text-align: left;
	    padding: 5px;
	} 
	.infoWin2{
		border:1px solid #999;   
	    border-collapse:collapse; 
		width:98%;
	}
	
	.infoWin2 td {   
	    border:1px dashed #999; 
	    text-align: left;
	    padding: 5px;
	} 
	
	</style> 
</head>
<body>
<script type="text/javascript">
	STOREDATA = [];
</script>
<div id="search_div_id">
	<table class="Mytable" style="width:95%">
		<tr>
			<td class="Myfont">
				<input type="text" id="local-states-with-qtip" name="country" size="40px" value="${teacher.name}"/>
				<c:forEach items="${teacherList }" var="t">
						<script type="text/javascript">
							var item = [];
							item.push('${t.id}');
							item.push('${t.name}');
							STOREDATA.push(item);
						</script>
				</c:forEach>
			</td>
		</tr>
	</table>
	<hr style="border:0;background-color:#99bbe8;height:2px;"/>
	
		<jsp:include page="teacherInfo.jsp" />	
	
		<h1 style="margin: 15px 20px 10px 5px;color:blue;">
					${teacher.name}绩效信息
		</h1>

		<div style="overflow: auto;" id="div_id">
	
		
			<div style="overflow: auto;margin-bottom: 20px;margin-right: 10px;" id="div_id">
				<table class="infotable Myfont" style="width: 90%">
				<tr style="background: #ECECFF;">
					<td>学期</td>
					<td>班级</td>
					<td>课程</td>
					<td>教学考评</td>
					<td>上课出勤</td>
					<td>教学文件</td>
					<td>听课情况</td>
					
					<td></td>
				</tr>
				
				<c:choose>
					<c:when test="${not empty map }">
							
						<%int i=0; String color = "";%>
						<c:forEach var="entry" items="${map }">
						<c:set var="item" value="${entry.value }"/>
						<c:set var="size" value="${fn:length(item.jixiao)}"/>
						<%color=i%2!=0?"#fffff0":"";i++;%>
					
						<tr style="background-color: <%=color%>;">
							<td rowspan="${size}">${item.xueqiName}</td>
							<c:forEach begin="0" end="0" items="${item.jixiao }" var="obj">
								<td>${obj.banjiName }</td>
								<td>${obj.kechengName }</td>
								<td><fmt:formatNumber value="${obj.scKaopin}" pattern="##.##" minFractionDigits="2" /></td>
								<td><fmt:formatNumber value="${obj.scChuqin}" pattern="##.##" minFractionDigits="2" /></td>
								<td><fmt:formatNumber value="${obj.scJiaoxuefile}" pattern="##.##" minFractionDigits="2" /></td>
								<td><fmt:formatNumber value="${obj.scTingke}" pattern="##.##" minFractionDigits="2" /></td>
							</c:forEach>
							<td rowspan="${size}">
								<a href="javascript:void(0)" onclick="showWindow(${item.xueqiId},${item.teacherId})">详细</a>
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
					<tr><td colspan="8" style="text-align: center;">暂无数据</td></tr>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>

</div>

<div id="infoWindow">
	<div id="info_div">
	</div>
	<div id="info_div2" style="margin-top: 20px;margin-bottom: 20px;">
		<table class="infoWin2">
			<tr><td>课程</td><td>教学考评</td><td>上课出勤</td><td>教学文件</td><td>听课情况</td></tr>
		</table>
	</div>
</div>
</body>
</html>
