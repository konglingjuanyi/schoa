<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../import.jsp"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建试卷</title>
<script type="text/javascript" src="<%=syspath%>/question/generatePaperParam.js"></script>
<style type="text/css">
	.Mytable ul li{
		margin: 5px 5px 5px 0px;
	}
	hr{
		border-top:1px dashed gray;height:1px; border-bottom: 0px;
	}
</style>
</head>
<body>
<div id="div_panel_id">
<form name="form1" action="generatePaper.do" method="get" onsubmit="return save()" target="_blank">
	<input type="hidden" name="kpoints" id="kpoints"> 
	<input type="hidden" name="tixings" id="tixings">
	<input type="hidden" name="kewens" id="kewens">

	<table class="Mytable">	
		<tr>
			<td width="110px">题型:<span style="color: red">*</span></td>
			<td> 
			<div style="border:dotted 1px black; background-color:#FFE4E1; overflow: auto;max-height: 300px;width: 700px;">
					<ul>
						<li>
							<input type="checkbox" id="tixing_all" onchange="selectAll(this,'tixing')">
							<label for="tixing_all" style="color: blue"><b>全选</b></label>
						</li>
						<c:forEach items="${tixingList }" var="tixing">
							<li>
								<input type="checkbox" name="tixing" value="${tixing.id }" id="tixing_${tixing.id }">
								<label for="tixing_${tixing.id }">${tixing.title },创建试题数:</label>
								<select id="tixing_${tixing.id }" name="tixing_${tixing.id }">
									<c:forEach begin="1" end="30" step="1" var="i">
										<option  value="${i }" <c:if test="${tixing.amount == i}">selected="selected"</c:if>>${i}
									</c:forEach>
								</select>
							</li>
						</c:forEach>
					</ul>
			</div>
			</td>
		</tr>
		
		<c:if test="${not empty standardList }">
			<tr>
				<td>词汇级别:</td>
				<td>
					<select id="standardId" name="standardId" onchange="chooseLevel()">
						<option value="0">请选择...
						<c:forEach items="${standardList }" var="obj">
							<option value="${obj.id}">${obj.name}
						</c:forEach>
					</select>
					<select id="levelId" name="levelId">
						<option value="0">请选择...
					</select>
				</td>
			</tr>
		</c:if>
		
		<c:if test="${not empty materList }">
			<tr>
				<td>教材:</td>
				<td>
					<select id="materId" name="materId" onchange="chooseKewen()">
						<option value="0">请选择...
						<c:forEach items="${materList }" var="obj">
							<option value="${obj.id}">${obj.name}
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>课文:</td>
				<td>
					<div id="kewenId" style="border:dotted 1px black; background-color:#FFF0F5; overflow: auto;max-height: 300px;width: 700px;">
					</div>
				</td>
			</tr>
		</c:if>
		
		<tr>
			<td  width="110px">知识点:</td>
			<td>
				<div style="border:dotted 1px black; background-color:#fffff0; overflow: auto;max-height: 300px;width: 700px;">
				<ul>
					<li>
						<input type="checkbox" id="kpoint_all" onchange="selectAll(this,'kpoint')">
						<label for="kpoint_all" style="color: blue"><b>全选</b></label>
					</li>
					<c:forEach items="${kpointList }" var="kpoint">
						<li>
							<input type="checkbox" name="kpoint" value="${kpoint.id }" id="kpoint_${kpoint.id }">
							<label for="kpoint_${kpoint.id }">${kpoint.name }</label>
						</li>
					</c:forEach>
				</ul>
				</div>
			</td>
		</tr>
		
		<tr>
			<td>试题创建时间:</td>
			<td>
				<table>
					<tr>
						<td>从</td><td><div id="startDateDiv"></div></td>
						<td>到</td><td><div id="endDateDiv"></div></td>
					</tr>
				</table>
				
			</td>
		</tr>
		
		<tr>
			<td>标签:</td>
			<td>
				<textarea name="tags" id="tags" rows="8" cols="20" style="width: 700px;"></textarea>
			</td>
		</tr>
		
		<tr>
			<td>关键字:</td>
			<td>
				<input type="text" name="keyword" id="keyword">
			</td>
		</tr>
	</table>	
	<hr>
	<table class="Mytable">	
		
		<tr>
			<td>&nbsp;</td>
			<td colspan="2">
				<input type="submit" value="确定" class="Mybotton">
				<input type="button" value="取消" class="Mybotton" onclick="_back()">
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>
