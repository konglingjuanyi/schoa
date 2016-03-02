<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<h2>导入学生学号</h2>
	<form action="readStudentCodeExcel.do" method="post" enctype="multipart/form-data" onsubmit="return save()">
		<h4>
			选择学生学号文件：
			<input type="file" id="numbFile" name="numbFile">
		</h4>
		<h4>
			<input type="submit" value="导入" class="Mybotton">
			<input type="button" value="取消" class="Mybotton" onclick="_back()">
		</h4>
	</form>
</body>
</html>