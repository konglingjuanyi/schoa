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
	<script type="text/javascript" src="<%=syspath%>/manager/studentInfos.js"></script>
	<script type="text/javascript" src="<%=syspath%>/manager/windowSelectStu.js"></script>
</head>
<body>

		<div id="search_div_id">
			<table class="Mytable" style="width:95%">
				<tr>
					<td class="Myfont">
						选择学生：
						<input value="${student.cname }" type="text" name="sname" id="sname" readonly="readonly" onclick="openWindow(this)" style="cursor: pointer;">
					</td>
					<td class="Myfont" align="right">
						<c:if test="${student.id > 0 }">
							<button onclick="reportLearnZM(${student.id })" class="Printbotton">
								<img src="imgs/print.png" style="margin-right: 5px;">学习证明
							</button>
						</c:if>
					</td>
				</tr>
			</table>
			<hr style="border:0;background-color:#99bbe8;height:2px;"/>
			<div style="display: ${empty student ? 'none' : ''}">
			<h1 style="margin: 15px 20px 10px 5px;color:blue;">
				基本信息
			</h1>
			<table class="infotable">
				<tr>
					<td rowspan="5"><img id="headImg" src="${IMAGEURL }${student.headPic }"  style="max-width: 133px;max-height:103px;"/></td>
					<td>中文名</td>
					<td>${student.cname }</td>
				</tr>
				<tr>
					<td>英文名</td>
					<td>${student.ename }</td>
				</tr>
				<tr>
					<td>国籍</td>
					<td>${student.country.cname }</td>
				</tr>
				<tr>
					<td>学生证号</td>
					<td>${student.code }</td>
				</tr>
				<tr>
					<td>护照ID</td>
					<td>${student.passNumb }</td>
				</tr>
				
				<tr>
					<td>性别</td>
					<td colspan="2">${student.sex == 0 ? '男' : '女' }</td>
				</tr>
				<tr>
					<td>电话</td>
					<td colspan="2">${student.phone }</td>
				</tr>
				<tr>
					<td>email</td>
					<td colspan="2">${student.email }</td>
				</tr>
				<tr>
					<td>出生年月</td>
					<td colspan="2">${student.birthday }</td>
				</tr>
				<tr>
					<td>现住址</td>
					<td colspan="2">${student.address }</td>
				</tr>
				<tr>
					<td>结业日期</td>
					<td colspan="2">${student.closedDate }</td>
				</tr>
				<tr>
					<td>经费来源</td>
					<td colspan="2">${WebUtil.getCostFrom(student.costFrom )}</td>
				</tr>
				<tr>
					<td>状态</td>
					<td colspan="2">${WebUtil.getStudentState(student.state )}</td>
				</tr>
			</table>
		</div>
		<div style="margin-bottom: 20px;display: ${empty student ? 'none' : ''}">
			<c:forEach items="${classesScoreMap }" var="map">
				<h1 style="margin: 30px 20px 10px 5px;color:blue;">
					学期：${map.key.xueqi.name}
					&nbsp;&nbsp;
					班级：${map.key.name}
				</h1>
				<h5 style="margin: 10px 20px 10px 5px;color: gray; font-size: 13px;font: 宋体;">
					${map.key.startDate}到${map.key.endDate} 
					班主任：${map.key.teacher.name}
					<img src="imgs/phone.ico" style="margin-left: 8px">
					${map.key.teacher.phone}
					<c:if test="${map.key.youxiu == 1}">
						<span style="color: red;">优秀学生</span>
					</c:if>
				</h5>
				<table class="infotable" style="width:95%">
					<tr>
						<th rowspan="2">课程</th>
						<th rowspan="2">总成绩</th>
						<th colspan="4">期末成绩</th>
						<th colspan="4">平时成绩</th>
						<th rowspan="2" style="width: 40%">备注</th>
					</tr>
					<tr>
						<th>客观</th>
						<th>主观</th>
						<th>卷面</th>
						<th style="color: red;">40%</th>
						<th>期中</th>
						<th style="color: red;">20%</th>
						<th>出勤</th>
						<th>作业</th>
					</tr>
					<c:forEach items="${map.value }" var="score">
						<tr>
							<td>${score.kecheng.name }</td>
							<td>${score.scAll }</td>
							<td><fmt:formatNumber value="${score.scKeguan }" pattern="##0.##"/></td>
							<td><fmt:formatNumber value="${score.scZhuguan }" pattern="##0.##"/></td>
							<td><fmt:formatNumber value="${score.scJuanmian }" pattern="##0.##"/></td>
							<td style="color: red;"><fmt:formatNumber value="${score.sc40 }" pattern="##0.##"/></td>
							<td><fmt:formatNumber value="${score.scQizhong }" pattern="##0.##"/></td>
							<td style="color: red;"><fmt:formatNumber value="${score.sc20 }" pattern="##0.##"/></td>
							<td><fmt:formatNumber value="${score.scChuqin }" pattern="##0.##"/></td>
							<td><fmt:formatNumber value="${score.scZuoye }" pattern="##0.##"/></td>
							<td>${score.remark }</td>
						</tr>
					</c:forEach>
				</table>
				<button class="Printbotton" onclick="reportJieYeZh(${student.id },${map.key.id })" >
					<img src="imgs/print.png" style="margin-right: 5px;">结业证
				</button>
				<button class="Printbotton" onclick="reportChengJiDan(${student.id },${map.key.id})">
					<img src="imgs/print.png" style="margin-right: 5px;">成绩单
				</button>
				<button class="Printbotton" onclick="reportChuqin(${student.id },${map.key.id})">
					<img src="imgs/print.png" style="margin-right: 5px;">出勤表
				</button>
				<c:if test="${map.key.youxiu == 1}">
					<button class="Printbotton" onclick="reportYouxiu(${student.id })">
						<img src="imgs/print.png" style="margin-right: 5px;">优秀生奖
					</button>
				</c:if>
			</c:forEach>
		</div>
		</div>
</body>
</html>