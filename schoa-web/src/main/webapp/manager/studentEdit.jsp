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
	<script type="text/javascript" src="<%=syspath%>/manager/studentEdit.js"></script>
</head>
<body>
<script type="text/javascript">
	STOREDATA = [];
</script>
<div id="div_panel_id">
<form name="form1" action="saveStudent.do" method="post" onsubmit="return save()">
	<input type="hidden" id="hideId" name="hideId" value="${student.id }">
	<input type="hidden" id="hideHeadPic" name="hideHeadPic" value="${student.headPic }">
	<input type="hidden" id="hideCountry" name="hideCountry" value="${student.nation }">
	<input type="hidden" id="hideClosedDate" name="hideClosedDate" value="${student.closedDate }">
	<input type="hidden" id="hideClosedDate" name="hideClosedDate" value="${student.closedDate }">
	<input type="hidden" id="hideBirthdayDiv" name="hideBirthdayDiv" value="${student.birthday }">
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
			<td class="Myfont">
				中文名：<span style="color: red">*</span>
			</td>
			<td class="Myfont">
				<input type="text" name="cname" id="cname" class="Mytext"  value="${student.cname }">
			</td>
		</tr>
		<tr>
			<td class="Myfont">
				英文名：<span style="color: red">*</span>
			</td>
			<td class="Myfont">
				<input type="text" name="ename" id="ename" class="Mytext"  value="${student.ename }">
			</td>
		</tr>
		
		<tr>
			<td class="Myfont">
				学生证号：<span style="color: red">*</span>
			</td>
			<td class="Myfont">
				<input type="text" name="code" id="code" class="Mytext"  value="${student.code }">
			</td>
		</tr>
		
		<tr>
			<td class="Myfont">
				国籍：<span style="color: red">*</span>
			</td>
			<td class="Myfont">
				<img id="imgCountry" src="${student.country.path }" style="max-width: 50px;max-height:50px;">
				<input type="text" id="local-states-with-qtip" name="country" size="40px" value="${student.nation}"/>
				<c:forEach items="${countryList }" var="c">
						<script type="text/javascript">
							var item = [];
							item.push("${c.id}");
							item.push("${c.cname}  ${c.ename}");
							item.push("${c.path}");
							STOREDATA.push(item);
						</script>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td class="Myfont">
				护照ID：<span style="color: red">*</span>
			</td>
			<td class="Myfont">
				<input type="text" name="passNumb" id="passNumb" class="Mytext"  value="${student.passNumb }">
			</td>
		</tr>
		
		<tr>
			<td class="Myfont">
				出生年月：<span style="color: red">*</span>
			</td>
			<td class="Myfont">
				<div id="birthdayDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td class="Myfont">
				性别：
			</td>
			<td class="Myfont">
				<input type="radio" name="sex" value="0" id="sex0" <c:if test="${student.sex == 0 }">checked="checked"</c:if>>男
				&nbsp;&nbsp;
				<input type="radio" name="sex" value="1" id="sex1" <c:if test="${student.sex == 1 }">checked="checked"</c:if>>女
			</td>
		</tr>
		
		<tr>
			<td>电话:</td>
			<td>
				<input type="text" class="Mytext" name="phone" id="phone" value="${student.phone }">
			</td>
		</tr>
		<tr>
			<td>email:</td>
			<td>
				<input type="text" class="Mytext" name="email" id="email" value="${student.email }">
			</td>
		</tr>
		<tr>
			<td class="Myfont">
				现住址：
			</td>
			<td class="Myfont">
				<input type="text" name="address" id="address" class="Mytext"  value="${student.address }">
			</td>
		</tr>
		<tr>
			<td class="Myfont">
				结业日期：
			</td>
			<td class="Myfont">
				<div id="closedDateDiv"></div>
			</td>
		</tr>
		<tr>
			<td class="Myfont">
				学生来源：
			</td>
			<td class="Myfont">
				<select id="stuFrom" name="stuFrom">
					<option>请选择...
					<c:forEach items="${stuFromMap }" var="mp">
						<option value="${mp.key}"
							<c:if test="${student.stuFrom == mp.key}">selected="selected"</c:if>
						>${mp.value}
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td class="Myfont">
				经费来源：
			</td>
			<td class="Myfont">
				<select id="costFrom" name="costFrom">
					<c:forEach items="${costFromMap }" var="mp">
						<option value="${mp.key}"
							<c:if test="${student.costFrom == mp.key}">selected="selected"</c:if>
						>${mp.value}
					</c:forEach>
				</select>
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