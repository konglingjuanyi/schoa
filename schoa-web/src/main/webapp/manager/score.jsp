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
<script type="text/javascript" src="<%=syspath%>/manager/score.js"></script>
</head>
<body>
	
	<input type="hidden" id="hidxueqiId" name="hidxueqiId" value="${xueqiId }">
	<input type="hidden" id="hidclassesId" name="hidclassesId" value="${classesId }">
	<input type="hidden" id="hidkechengId" name="hidkechengId" value="${kechengId }">
	<input type="hidden" id="hidstudentId" name="hidstudentId" value="">
	
	
	<div id="search_div_id">
		<table class="Mytable">
			<tr>
				<td class="Myfont">
				学期： 
				<select id="xueqiId"
					onchange="chooseClasses()">
						<option value="0">请选择...
							<c:forEach items="${xueqiList }" var="xq">
								<option
									<c:if test="${xueqiId == xq.id}">selected="selected"</c:if>
									value="${xq.id}">${xq.name}
							</c:forEach>
				</select> 
				班级： 
				<select id="classesId"
					onchange="chooseKecheng()">
						<option value="0">请选择...
							<c:forEach items="${classList }" var="obj">
								<option
									<c:if test="${classesId == obj.id}">selected="selected"</c:if>
									value="${obj.id}">${obj.name}
							</c:forEach>
				</select> 
				课程: 
				<select id="kechengId" >
						<option value="0">请选择...
							<c:forEach items="${kechengList }" var="obj">
								<option
									<c:if test="${kechengId == obj.id}">selected="selected"</c:if>
									value="${obj.id}">${obj.name}
							</c:forEach>
				</select> 
				<input type="button" value="搜索" class="Mybotton" onclick="searchFunc()">
				</td>
				<td>
					<c:if test="${canmodifiy == true }">
						<button class="Printbotton" onclick="commitFunc()">
							<img src="imgs/upload.png" style="margin-right: 5px;">提交
						</button>
					</c:if>
					<button class="Printbotton" onclick="exportScore()">
						<img src="imgs/print.png" style="margin-right: 5px;">成绩单
					</button>
				</td>
			</tr>
		</table>
	</div>
	
	<div id="grid_div_id">
		<div>
			<table class="table3">
				<tr>
					<th rowspan="2">序号</th>
					<th rowspan="2">姓名</th>
					<th rowspan="2">总成绩</th>
					<th colspan="4">期末成绩</th>
					<th colspan="4">平时成绩</th>
					<th rowspan="2" width="20%">备注</th>
					
					<c:if test="${canmodifiy == true }">
						<th rowspan="2">操作</th>
					</c:if>
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
				<%int index = 0; %>
				<c:forEach items="${studentList }" var="stu">
				<c:set var="score" value="${stu.score }"/>
				<%
					index++; 
				%>
				<c:choose>
					 <c:when test="${stu.state == 2 }">
					 	<tr style='background-color: #C0C0C0;'>
					 </c:when>
					 <c:otherwise>
						 <%
							if(index%2!=0){
								out.print("<tr style='background-color: #fffff0;'>");
							}else{
								out.print("<tr>");
							}
						%>
					 </c:otherwise>
				</c:choose>
					<td><%=index%></td>
					<td>
						${stu.cname }
						<c:if test="${stu.state == 2 }">
							(离校)
						</c:if>
					</td>
					<td><fmt:formatNumber value="${score.scAll }" pattern="##0.##"/></td>
					<td><fmt:formatNumber value="${score.scKeguan }" pattern="##0.##"/></td>
					<td><fmt:formatNumber value="${score.scZhuguan }" pattern="##0.##"/></td>
					<td><fmt:formatNumber value="${score.scJuanmian }" pattern="##0.##"/></td>
					<td style="color: red;"><fmt:formatNumber value="${score.sc40 }" pattern="##0.##"/></td>
					<td><fmt:formatNumber value="${score.scQizhong }" pattern="##0.##"/></td>
					<td style="color: red;"><fmt:formatNumber value="${score.sc20 }" pattern="##0.##"/></td>
					<td><fmt:formatNumber value="${score.scChuqin }" pattern="##0.##"/></td>
					<td><fmt:formatNumber value="${score.scZuoye }" pattern="##0.##"/></td>
					<td>${score.remark }</td>
					<c:if test="${canmodifiy == true }">
						<td>
							<input type="button" value="修改" class="Mybotton" onclick="updateF(this,${stu.id },'${stu.cname }')">
						</td>
					</c:if>
				</tr>
				</c:forEach>
				
			</table>
		</div>	
		<input type="button" value="试卷分析" class="Mybotton" onclick="paperAnalysis()">	
	</div>

	
	
	<div id="myWindow" class="Myfont" style="background-color: white;height: 800px;">
			<span style="font-size: 16px;"><b>期末成绩</b></span><hr>
			<table>
				<tbody>
					<tr style="height: 30px;">
						<td width="65px" align="right">客观:</td>
						<td>
							<input id="w_keguan" name="w_keguan" type="text" value="" style="width: 70px" onblur="calQimo()">
						</td>
						<td width="165px" align="right">主观:</td>
						<td>
							<input id="w_zhuguan" name="w_zhuguan" type="text" value="" style="width: 70px" onblur="calQimo()">
						</td>
					</tr>
					<tr style="height: 30px;">
						<td width="65px" align="right">卷面:</td>
						<td>
							<span id="w_juanmian"></span>
						</td>
						<td width="165px" align="right" style="color:red">卷面(40%):</td>
						<td>
							<span id="w_40"></span>
						</td>
					</tr>
				</tbody>
			</table>
			
			<br/>
			<span style="font-size: 16px;"><b>平时成绩</b></span><hr>
			<table>
				<tbody>
					<tr style="height: 30px;">
						<td width="65px" align="right">期中:</td>
						<td>
							<input id="w_qizhong" name="w_qizhong" type="text" style="width: 70px" value="" onblur="calQizhong()">
						</td>
						<td width="165px" align="right" style="color:red">期中(20%):</td>
						<td>
							<span id="w_20"></span>
						</td>
					</tr>
					<tr style="height: 30px;">
						<td width="65px" align="right">作业:</td>
						<td>
							<input id="w_zuoye" name="w_zuoye" type="text" style="width: 70px" value="" onblur="calZuoye()">
						</td>
						<td width="165px" align="right" style="color:red">作业(20%):</td>
						<td>
							<span id="w_zuoye20"></span>
						</td>
					</tr>
					<tr style="height: 30px;">
						<td width="65px" align="right">考勤:</td>
						<td>
							<span id="w_kaoqin"></span>
						</td>
						<td width="165px" align="right">总课时:</td>
						<td>
							<span id="w_keshi"></span>
						</td>
					</tr>
					
					<tr style="height: 30px;">
						<td colspan="4">
							<span style="color:red">出勤(20%)：</span>
							<span id="w_chuqin"></span>
						</td>
					</tr>
				</tbody>
			</table>
			
			<br/>
			<hr>
			<table>
				<tbody>
				<tr style="height: 30px;">
					<td width="65px" align="right">总成绩：</td>
					<td>
						<span id="w_chengjiAll"></span>
					</td>
				</tr>
				<tr style="height: 30px;">
					<td align="right">备注：</td>
					<td>
						<textarea name="w_rmark" id="w_rmark" cols="50" rows="3" class="Mytextarea"></textarea>
					</td>
				</tr>
			</tbody></table>
	</div>
</body>
</html>