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
	<script type="text/javascript" src="<%=syspath%>/manager/teacher.js"></script>
</head>
<body>
<div id="search_div_id">
			<table class="Mytable">
				<tr>
					<td class="Myfont">
						教师姓名：
						<input style="margin-right: 20px;" type="text" name="name" id="name">
						
						编制：
						<input type="radio" name="type" value="－1" checked="checked" id="type9"><label for="type9">所有</label>
						<input type="radio" name="type" value="0" id="type0"><label for="type0">正编</label>
						<input type="radio" name="type" value="1" id="type1"><label for="type1">外聘</label>
				
						<input style="margin-left: 50px;" type="button" value="搜索" class="Mybotton" onclick="searchFunc()">
					</td>
				</tr>
			</table>
		</div>
		
		
		<div id="logdiv">
			<span id="logId"></span>
		</div>
</body>
</html>