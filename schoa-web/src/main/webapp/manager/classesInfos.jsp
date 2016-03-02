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
	<script type="text/javascript" src="<%=syspath%>/manager/classesInfos.js"></script>
</head>
<body>
<script language="javascript">
		var IDS = new Array();	
		var _i = 0;
</script>
<input type="hidden" id="hidClassesId" name="hidClassesId" value="${classesId }">

		<div id="search_div_id">
			<table class="Mytable">
				<tr>
					<td class="Myfont">
						选择学期： 
						<select id="xueqiId"
							onchange="chooseClasses()">
								<option value="0">请选择...
									<c:forEach items="${xueqis }" var="xq">
										<option
											<c:if test="${xueqi == xq.id}">selected="selected"</c:if>
											value="${xq.id}">${xq.name}
									</c:forEach>
						</select> 
						选择班级： 
						<select id="classesId">
								<option value="0">请选择...
									<c:forEach items="${classList }" var="obj">
										<option
											<c:if test="${classesId == obj.id}">selected="selected"</c:if>
											value="${obj.id}">${obj.name}
									</c:forEach>
						</select>
						<input type="button" value="搜索" class="Mybotton" onclick="searchFunc()">
					</td>
					<td class="Myfont" align="center">
						<c:if test="${classes.id > 0 }">
							<button onclick="reportKecheng(${classes.id })" class="Printbotton">
								<img src="imgs/print.png" style="margin-right: 5px;">课程表
							</button>
							<button onclick="reportClassesKaoqin(${classes.id })" class="Printbotton">
								<img src="imgs/print.png" style="margin-right: 5px;">出勤表
							</button>
							<button onclick="reportClassesStudents()" class="Printbotton">
								<img src="imgs/print.png" style="margin-right: 5px;">班级学生名单
							</button>
						</c:if>
					</td>
				</tr>
			</table>
		</div>
		
		
		<div id="main_div" style="margin-bottom: 20px;display: ${classesId > 0?'':'none'}">
			<h1 style="margin: 15px 20px 10px 5px;color:blue;">
				基本信息
			</h1>
			<table class="infotable" style="width: 40%">
				<tr>
					<td>班级：</td>
					<td style="text-align: left;">${classes.name }</td>
				</tr>
				<tr>
					<td>学期：</td>
					<td style="text-align: left;">${classes.xueqi.name }</td>
				</tr>
				<tr>
					<td>班主任：</td>
					<td style="text-align: left;">
						${classes.teacher.name }
						<img src="imgs/phone.ico" style="margin-left:5px" />${classes.teacher.phone }
					</td>
				</tr>
				<tr>
					<td>任课教师：</td>
					<td style="text-align: left;">
						<table style="border: 0;">
							<c:forEach items="${teachers }" var="tch">
								<tr>
									<td style="border: 0;text-align: left">《${tch.kecheng.name }》</td>
									<td style="border: 0;text-align: left">${tch.name }</td>
									<td style="border: 0;text-align: left"><img src="imgs/phone.ico" style="margin-left: 5px"/>${tch.phone }</td>
								</tr>
							</c:forEach>
						</table>
						
					</td>
				</tr>
				<tr>
					<td>备注：</td>
					<td style="text-align: left;">${classes.rmark }</td>
				</tr>
			</table>
			
			<h1 style="margin: 30px 20px 10px 5px;color:blue;">
				课程表
			</h1>
			
			<table class="infotable" style="width: 95%">
				<c:set value="${kechengbiao.weekIndexList }" var="weekIndexList" />
				<c:set value="${kechengbiao.timeList }" var="timeList" />
				<tr style="background:#ECECFF;">
					<td>Time/Day</td>
					<c:forEach items="${weekIndexList }" var="wk">
						<td>${WebUtil.getWeekTitle(wk) }</td>
					</c:forEach>
				</tr>
				<c:forEach items="${timeList }" var="tm">
					<tr>
						<td>${tm }</td>
						<c:forEach items="${weekIndexList }" var="wk">
							<td>${WebUtil.getKechengbiaoKecheng(tm, wk, kechengbiao.paikeMap) }</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</table>
			
			<h1 style="margin: 30px 20px 10px 5px;color:blue;">
				学生信息
			</h1>
			<table class="infotable" style="width: 95%">
				<tr style="background:#ECECFF;">
					<td>学生证号</td>
					<td>头像</td>
					<td>姓名</td>
					<td>电话</td>
					<td>国籍</td>
					<td>护照号</td>
					<td>优秀</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${students }" var="stu">
					<script language="javascript">
					IDS[_i] = ${stu.id };
					_i += 1;
					</script>
				<tr>
					<td>${stu.code }</td>
					<td>
						<c:if test="${not empty  stu.headPic}">
							<img style="max-width: 40px;max-height:40px;" src="${IMAGEURL }${stu.headPic }">
						</c:if>
					</td>
					<td style="text-align: left;">${stu.cname }<br/>${stu.ename }</td>
					<td>${stu.phone }</td>
					<td>${stu.country.cname }</td>
					<td>${stu.passNumb }</td>
					<td>
						<c:if test="${stu.youxiu == 1}">
							<span style="color: red;">优秀</span>
						</c:if>
					</td>
					<td>${WebUtil.getStudentState(stu.state )}</td>
					<td style="text-align: left;">
						<button onclick="reportChengJiDan(${stu.id },${classes.id })" class="Printbotton">
							<img src="imgs/print.png" style="margin-right: 5px;">成绩单
						</button>
						<button onclick="reportJieYeZh(${stu.id },${classes.id })" class="Printbotton">
							<img src="imgs/print.png" style="margin-right: 5px;">结业证
						</button>
						<c:if test="${stu.youxiu == 1}">
							<button class="Printbotton" onclick="reportYouxiu(${stu.id })">
								<img src="imgs/print.png" style="margin-right: 5px;">优秀生奖
							</button>
						</c:if>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		
</body>
</html>