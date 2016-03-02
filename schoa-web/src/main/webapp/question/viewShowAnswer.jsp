<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String syspath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试卷答案</title>
<style type="text/css">
	hr{
		border-top:1px dashed gray;height:1px; border-bottom: 0px;
	}
	pre{
		margin-top: 0px;
	}
	table{
		width: 90%;
		margin-left: 5px;
	}
	table td{
		padding: 3px;
		margin: 3px;
	}
	pre{
		white-space: pre-wrap;       
		white-space: -moz-pre-wrap;  
		white-space: -pre-wrap;      
		white-space: -o-pre-wrap;    
		word-wrap: break-word;       
	}
</style>
<script type="text/javascript" src="<%=syspath%>/utils/jquery.js"></script>
</head>
<body>
	<h1>
		试卷《${paper.title }》答案，试卷创建人：${paper.member }
	</h1>
	<div style="font-size:14px;font: 宋体;margin-left: 10px;overflow: auto;margin-bottom: 40px;" id="m_div_id">
		
		<c:set var="flag" value="0"/>
		<c:set var="i" value="0" />
		<c:set var="j" value="0" />
		<c:set var="tixing" />
		
		<table>
			<c:forEach items="${bankList }" var="bank">
			<c:set var="j" value="${j+1}"/>
			
			<!-- 题型 -->
			<c:if test="${bank.tixingId != flag }">
				<c:set var="i" value="${i+1}"/>
				<c:set var="tixing" value="${WebUtil.getTixingObj(tixingMap, bank.tixingId) }"/>
				<c:set var="flag" value="${tixing.id}"/>

				<tr>
					<td colspan="2">
						<h3>${WebUtil.outCh(i)}、${tixing.title }</h3>
						<hr>
					</td>
				</tr>
			</c:if>
			
			<!-- 试题序号 + 答案-->
			<tr>
				<td style="width: 25px;" valign="top">${j}、</td>
				<td valign="top"><pre>${bank.answer }</pre></td>
			</tr>
			</c:forEach>
		</table>
		
		<hr>
		<table>
			<tr>
				<td colspan="2" style="height: 50px;">
					<input type="button" value="关闭" class="Mybotton" onclick="javascript:window.close();">
				</td>
			</tr>
		</table>
	</div>
	
</body>
<script type="text/javascript">
(function() {
})();
var height = $(window).height()-90;
document.getElementById('m_div_id').style.height=height+"px";
</script>
</html>