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
<title>试卷预览</title>
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
<script type="text/javascript" src="<%=syspath%>/question/viewPaper.js"></script>
</head>
<body>
<h1>试卷预览</h1>
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
							${tixing.subtitle }<hr>
						</td>
					</tr>
				</c:if>
				
				<tr>
					<td style="width: 55px;" valign="top">
						<!-- 多选框 -->
						<c:set var="flg" value="${tixing.id }-${bank.id }"/>
						<input type="checkbox" value="${flg }"  name="shiti" title="重新生成时，保留此题" <c:if test="${WebUtil.getIsCheckBank(mustIdArray, flg) }">checked="checked"</c:if>>
					
						<!-- 试题序号 -->
						${j}、
					</td>
					
					<!-- 题干 -->
					<td valign="top">
						<pre>${bank.content }</pre>
					</td>
				</tr>
				
				<!-- 插图 -->
				<c:if test="${not empty  bank.img}">
					<tr>
						<td valign="bottom"></td>
						<td valign="bottom"><img id="img" src="${IMAGEURL }${bank.img }" style="max-width: 150px;max-height:150px;"></td>
					</tr>
				</c:if>
				<!-- 选项图 -->
				<tr>
					<td valign="bottom"></td>
					<td valign="bottom">
						<c:if test="${not empty  bank.imgA}">
							A.<img id="img" src="${IMAGEURL }${bank.imgA }" style="max-width: 150px;max-height:150px;">
						</c:if>
						<c:if test="${not empty  bank.imgB}">
							B.<img id="img" src="${IMAGEURL }${bank.imgB }" style="max-width: 150px;max-height:150px;">
						</c:if>
						<c:if test="${not empty  bank.imgC}">
							C.<img id="img" src="${IMAGEURL }${bank.imgC }" style="max-width: 150px;max-height:150px;">
						</c:if>
						<c:if test="${not empty  bank.imgD}">
							D.<img id="img" src="${IMAGEURL }${bank.imgD }" style="max-width: 150px;max-height:150px;">
						</c:if>
						<c:if test="${not empty  bank.imgE}">
							E.<img id="img" src="${IMAGEURL }${bank.imgE }" style="max-width: 150px;max-height:150px;">
						</c:if>
						<c:if test="${not empty  bank.imgF}">
							F.<img id="img" src="${IMAGEURL }${bank.imgF }" style="max-width: 150px;max-height:150px;">
						</c:if>
					</td>
				</tr>
				
			</c:forEach>
		</table>
		
		<hr>
		<form name="form1" action="saveQuestionPaper.do" method="post" onsubmit="return save()">
			<table>
				<tr>
					<td style="width: 80px;height: 30px;">试卷标题:<span style="color: red">*</span></td>
					<td><input type="text" id="title" name="title" style="width: 300px"></td>
				</tr>
				<tr>
					<td style="width: 80px;height: 30px;">试卷创建人:<span style="color: red">*</span></td>
					<td><input type="text" id="user" name="user" style="width: 300px"></td>
				</tr>
				<tr>
					<td colspan="2" style="height: 50px;">
						<!-- 试题ID，有序 -->
						<input type="hidden" id="ids" name="ids" value="${ids }">
						<input type="button" value="重新生成" class="Mybotton" onclick="reloadPaper()">
						<input type="button" value="试卷答案" class="Mybotton" onclick="viewAnswer()">
						<input type="submit" value="保存试卷" class="Mybotton">
						<input type="button" value="关闭" class="Mybotton" onclick="javascript:window.close();">
					</td>
				</tr>
			</table>
		</form>
	</div>
	
</body>
<script type="text/javascript">
var height = $(window).height()-90;
document.getElementById('m_div_id').style.height=height+"px";
</script>
</html>