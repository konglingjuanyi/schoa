<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${standard.name }</title>
<style type="text/css">
table{   
    border:1px solid #99bbe8;   
    border-collapse:collapse; 
    text-align: center;
    font: 12px Verdana, Arial, Helvetica, sans-serif;
}   
table td {   
    border:1px solid #ededed;
    padding: 5px;
}   
table th {   
    border:1px solid #99bbe8;   
	background-color: #dfe8f6;
	padding: 5px;
} 
.locktop{
  position:relative;
}
</style>
</head>
<body>
	<h3>${standard.name }</h3>

	<table>	
		<tr class="locktop">
			<c:forEach items="${levelList }" var="level">
				<th style="height: 30px;">${level.name }</th>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach items="${levelList }" var="level">
				<td valign="top" align="left"><pre>${level.content }</pre></td>
			</c:forEach>
		</tr>
	</table>
</body>
</html>
