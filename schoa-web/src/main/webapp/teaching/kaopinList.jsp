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
	<script type="text/javascript" src="<%=syspath%>/teaching/kaopinList.js"></script>
</head>
<body>
	<!-- 是否是管理员 -->
		<input type="hidden" id="isadmin" name="isadmin" value="${admin }">

	<input type="hidden" id="hide_kaopinId" name="hide_kaopinId" value="${kaopin.id }">
	<input type="hidden" id="hide_kaopinName" name="hide_kaopinName" value="${kaopin.name }">
	<input type="hidden" id="hide_kaopinTeacherName" name="hide_kaopinTeacherName" value="${kaopin.teacher.name}">
	<div id="search_div_id" style="padding: 10px;">
		<h5>
			<a href="initTeachingKaopin.do" style="text-decoration: none;">教学考评</a> 
			>
			${kaopin.teacher.name }考评列表 
		</h5>
		
		<br/>
		
		<table width="98%">
			<tr>
				<td>
					<span style="font-weight: normal;line-height: 1;color: #999;font-size: 12px;margin: 10px;">
						学期：${kaopin.xueqi.name };
					</span>
					<span style="font-weight: normal;line-height: 1;color: #999;font-size: 12px;margin: 10px;">
						班级：${kaopin.banji.name };
					</span>
					<span style="font-weight: normal;line-height: 1;color: #999;font-size: 12px;margin: 10px;">
						课程：${kaopin.kecheng.name };
					</span>
					<span style="font-weight: normal;line-height: 1;color: #999;font-size: 12px;margin: 10px;">
						教师：${kaopin.teacher.name }
					</span>
					<span style="font-weight: normal;line-height: 1;color: red;font-size: 12px;margin: 10px;">
						本次考评得分：${kaopin.score }
					</span>
				</td>
				<td align="right">
					<c:if test="${admin }">
						<input type="button" value="新增" onclick="modifyItem(0)" class="Mybotton">
					</c:if>
						<button class="Printbotton" onclick="printTeacherKaopin(${kaopin.id })">
							<img src="imgs/print.png" style="margin-right: 5px;">考评
						</button>
				</td>
			</tr>
		</table>
		
	</div>
</body>
</html>