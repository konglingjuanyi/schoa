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
<title></title>
<link rel="stylesheet" type="text/css" href="<%=syspath%>/utils/fileuploadfield.css" />
<script type="text/javascript" src="<%=syspath%>/utils/FileUploadField.js"></script>
<script type="text/javascript" src="<%=syspath%>/utils/fileUpLoad.js"></script>

	<script type="text/javascript" src="<%=syspath%>/manager/teacherEdit.js"></script>
</head>
<body>
<div id="div_panel_id">
<form name="form1" action="saveTeacher.do" method="post" onsubmit="return save()">
	<input type="hidden" id="hideId" name="hideId" value="${teacher.id }">
	<input type="hidden" id="hideStartDate" name="hideStartDate" value="${teacher.entryTime }">
	<input type="hidden" id="hideEndDate" name="hideEndDate" value="${teacher.lizhiTime }">
	<input type="hidden" id="hideHeadPic" name="hideHeadPic" value="${teacher.headPic }">
	
	<table class="Mytable">
		<tr>
			<td class="Myfont" style="width: 100px">
				头像：<span style="color: red">*</span>
			</td>
			<td class="Myfont">
				<img id="headImg"  style="max-width: 133px;max-height:103px;display:none">
				<input type="button" value="上传" class="Mybotton" onclick="chooseImg()">					
			</td>
		</tr>
		<tr>
			<td width="80px">姓名:<span style="color: red">*</span></td>
			<td>
				<input type="text" class="Mytext" name="name" id="name" value="${teacher.name }">
			</td>
		</tr>
		<tr>
			<td>教师编号:<span style="color: red">*</span></td>
			<td>
				<input type="text" class="Mytext" name="code" id="code" value="${teacher.code }">
			</td>
		</tr>
		<tr>
			<td>电话:<span style="color: red">*</span></td>
			<td>
				<input type="text" class="Mytext" name="phone" id="phone" value="${teacher.phone }">
			</td>
		</tr>
		<tr>
			<td>身份证号:<span style="color: red">*</span></td>
			<td>
				<input type="text" class="Mytext" name="cardNumb" id="cardNumb" value="${teacher.cardNumb }">
			</td>
		</tr>
		<tr>
			<td>编制:<span style="color: red">*</span></td>
			<td>
				<input type="radio"  name="type" value="0" id="type0" <c:if test="${teacher.type == 0 }">checked="checked"</c:if> >正编
				&nbsp;&nbsp;
				<input type="radio" name="type" value="1" id="type1" <c:if test="${teacher == null || teacher.type == 1 }">checked="checked"</c:if> >外聘
			</td>
		</tr>
		<tr>
			<td>性别:</td>
			<td>
				<input type="radio" name="sex" value="0" id="sex0" <c:if test="${teacher.sex == 0 }">checked="checked"</c:if>>男
				&nbsp;&nbsp;
				<input type="radio" name="sex" value="1" id="sex1" <c:if test="${teacher.sex == 1 }">checked="checked"</c:if>>女
			</td>
		</tr>
		<tr>
			<td>入职时间:</td>
			<td>
				<div id="startDateDiv"></div>
			</td>
		</tr>
			<tr>
			<td>离职时间:</td>
			<td>
				<div id="endDateDiv"></div>
			</td>
		</tr>
		<tr>
			<td>生日:</td>
			<td>
				<input type="text" class="Mytext" name="birthday" id="birthday" value="${teacher.birthday }">
			</td>
		</tr>
		<tr>
			<td>在读院校:</td>
			<td>
				<input type="text" class="Mytext" name="readingSchool" id="readingSchool" value="${teacher.readingSchool }">
			</td>
		</tr>
		
		<tr>
			<td>email:</td>
			<td>
				<input type="text" class="Mytext" name="email" id="email" value="${teacher.email }">
			</td>
		</tr>
		<tr>
			<td>婚否:</td>
			<td>
				<input type="radio" name="married" value="0" id="married0" <c:if test="${teacher.married == 0 }">checked="checked"</c:if>>已婚
				&nbsp;&nbsp;
				<input type="radio" name="married" value="1" id="married1" <c:if test="${teacher.married == 1 }">checked="checked"</c:if>>未婚
			</td>
		</tr>
		<tr>
			<td>籍贯:</td>
			<td>
				<input type="text" class="Mytext" name="hometown" id="hometown" value="${teacher.hometown }">
			</td>
		</tr>
		<tr>
			<td>毕业院校:</td>
			<td>
				<input type="text" class="Mytext" name="graduated" id="graduated" value="${teacher.graduated }">
			</td>
		</tr>
		<tr>
			<td>专业背景:</td>
			<td>
				<input type="text" class="Mytext" name="pro" id="pro" value="${teacher.pro }">
			</td>
		</tr>
		<tr>
			<td>住址:</td>
			<td>
				<input type="text" class="Mytext" name="address" id="address" value="${teacher.address }">
			</td>
		</tr>
		<tr>
			<td>教学经历:</td>
			<td>
				<input type="text" class="Mytext" name="experience" id="experience" value="${teacher.experience }">
			</td>
		</tr>
		<tr>
			<td>科研成果:</td>
			<td>
				<input type="text" class="Mytext" name="research" id="research" value="${teacher.research }">
			</td>
		</tr>
		
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
</html>