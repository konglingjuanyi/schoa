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
<style type="text/css">
	#box{ width:340px; margin:0 auto; background:#fff; border:1px solid #ccc; padding:20px; display:none; -webkit-border-radius: 10px;-moz-border-radius: 10px; display:none; } 
</style>
<title>
</title>
<script type="text/javascript" src="<%=syspath%>/utils/jquery.js"></script>
<script type="text/javascript" src="<%=syspath%>/utils/blockUI.js"></script>
<script type="text/javascript" src="<%=syspath%>/manager/chengjidan.js"></script>
</head>
<body>
<div>
	<h1 style="margin: 15px 20px 10px 5px;color:blue;">
		${normal.studentName }在${normal.classesName }成绩单（${normal.dateCn }）
	</h1>
	<input type="hidden" id="hide_studentId" value="${normal.studentId }">
	<input type="hidden" id="hide_classesId" value="${normal.classesId }">
	<table class="infotable">
		<tr style="background:#ECECFF;">
			<td>课程</td>
			<td>期中</td>
			<td>期末</td>
			<td>总成绩</td>
			<td style="display: none;">课程ID</td>
		</tr>
		<c:forEach items="${normal.subjectMarks }" var="sm">
			<tr class="score">
				<td>${sm.subject }</td>
				<td onclick="showWindow(this,'${sm.subject }期中成绩')" style="cursor: pointer;">${sm.qizhong }</td>
				<td onclick="showWindow(this,'${sm.subject }期末成绩')" style="cursor: pointer;">${sm.qimo }</td>
				<td onclick="showWindow(this,'${sm.subject }总成绩')" style="cursor: pointer;">${sm.total }</td>
				<td style="display: none;">${sm.kechengId }</td>
			</tr>
		</c:forEach>
	</table>
	<button class="Printbotton" onclick="printCur()">
		<img src="imgs/print.png" style="margin-right: 5px;">保存并打印
	</button>
	
	
	<h3 style="margin: 35px 20px 5px 5px;color:blue;">
		打印历史记录
	</h3>
	<hr style="border:0;background-color:#99bbe8;height:2px;"/>
	
	<ul>
		<c:forEach items="${historys }" var="his">
			<li style="margin-top: 20px;">
				<span style="margin: 10px 20px 10px 5px;color: gray; font-size: 13px;font: 宋体;">
					${his.operator }于${his.createTime }
				</span>
				
				<table class="infotable">
					<tr style="background:#ECECFF;">
						<td>课程</td>
						<td>期中</td>
						<td>期末</td>
						<td>总成绩</td>
					</tr>
					<c:forEach items="${his.chengjidan }" var="sm">
						<tr>
							<td>${sm.subject }</td>
							<td>${sm.qizhong }</td>
							<td>${sm.qimo }</td>
							<td>${sm.total }</td>
						</tr>
					</c:forEach>
				</table>
				<button class="Printbotton" onclick="printHistory(${his.id })">
					<img src="imgs/print.png" style="margin-right: 5px;">打印
				</button>
			</li>
		</c:forEach>
	</ul>
</div>	



<div id="box">
	<div>
	<h3>
		<span id="winTitle"></span>
	</h3>
	<table style="border: 0;">
		<tr style="border: 0;">
			<td style="border: 0;">
				<input type="text" id="newvalue">
			</td>
			<td style="border: 0;">
				<input type="button" value="确定" class="Mybotton" onclick="save()">
				<input type="button" value="关闭" class="Mybotton" onclick="closeWin()">
			</td>
		</tr>
	</table>
	</div>
</div>
</body>
</html>