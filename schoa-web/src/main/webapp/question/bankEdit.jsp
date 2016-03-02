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
<title>编辑试题</title>
<link rel="stylesheet" type="text/css" href="<%=syspath%>/utils/fileuploadfield.css" />
<script type="text/javascript" src="<%=syspath%>/utils/FileUploadField.js"></script>
<script type="text/javascript" src="<%=syspath%>/utils/fileUpLoad.js"></script>
<script type="text/javascript" src="<%=syspath%>/question/bankEdit.js"></script>
<style type="text/css">
hr{
		border-top:1px dashed gray;
		height:1px; 
		border-bottom: 0px;
	}
img{
	max-width: 133px;
	max-height:103px;
}
</style>
</head>
<body>
<div id="div_panel_id">
<form name="form1" action="saveBank.do" method="post" onsubmit="return save()">
	<input type="hidden" id="hideId" name="hideId" value="${bank.id }">
	<input type="hidden" id="hideMaterialKechengId" name="hideMaterialKechengId" value="${bank.materialKechengId }">
	<table class="Mytable">
		<tr>
			<td width="80px">试题内容:<span style="color: red">*</span></td>
			<td>
				<textarea name="content" id="content" rows="13" cols="20" style="width: 600px;" onblur="getWordLevel()">${bank.content }</textarea>
			</td>
		</tr>
		
		<tr>
			<td>试题答案:<span style="color: red">*</span></td>
			<td>
				<textarea name="answer" id="answer" rows="5" cols="20" style="width: 600px;" onblur="getWordLevel()">${bank.answer }</textarea>
			</td>
		</tr>
		
		<tr>
			<td>试题配图:</td>
			<td>
				<input type="hidden" id="hideImg" name="hideImg" value="${bank.img }">
				<img id="img"  style="display:none">
				<input type="button" value="上传" class="Mybotton" onclick="chooseImg('')">	
			</td>
		</tr>
		
		
		
		<tr>
			<td>选项图:</td>
			<td>
				A.
				<input type="hidden" id="hideImgA" name="hideImgA" value="${bank.imgA }">
				<img id="imgA"  style="display:none">
				<input type="button" value="上传" class="Mybotton" onclick="chooseImg('A')" style="margin-right: 10px;">	 
				B.
				<input type="hidden" id="hideImgB" name="hideImgB" value="${bank.imgB }">
				<img id="imgB"  style="display:none">
				<input type="button" value="上传" class="Mybotton" onclick="chooseImg('B')" style="margin-right: 10px;">	 
				C.
				<input type="hidden" id="hideImgC" name="hideImgC" value="${bank.imgC }">
				<img id="imgC"  style="display:none">
				<input type="button" value="上传" class="Mybotton" onclick="chooseImg('C')" style="margin-right: 10px;">	 
				D.
				<input type="hidden" id="hideImgD" name="hideImgD" value="${bank.imgD }">
				<img id="imgD"  style="display:none">
				<input type="button" value="上传" class="Mybotton" onclick="chooseImg('D')" style="margin-right: 10px;">	 
				E.
				<input type="hidden" id="hideImgE" name="hideImgE" value="${bank.imgE }">
				<img id="imgE"  style="display:none">
				<input type="button" value="上传" class="Mybotton" onclick="chooseImg('E')" style="margin-right: 10px;">	 
				F.
				<input type="hidden" id="hideImgF" name="hideImgF" value="${bank.imgF }">
				<img id="imgF"  style="display:none">
				<input type="button" value="上传" class="Mybotton" onclick="chooseImg('F')" style="margin-right: 10px;">	 
			</td>
		</tr>
	</table>	
	<hr>
	<table class="Mytable">	
		<tr>
			<td width="80px">题型:<span style="color: red">*</span></td>
			<td>
				<select id="tixingId" name="tixingId">
					<option value="0">请选择...
					<c:forEach items="${tixingList }" var="obj">
						<option <c:if test="${obj.id == bank.tixingId }">selected="selected"</c:if>  value="${obj.id}">${obj.title}
					</c:forEach>
				</select>
			</td>
		</tr>
		
		
		<tr>
			<td>知识点:</td>
			<td>
				<select id="knowledgePointId1" name="knowledgePointId1">
					<option value="0">请选择...
					<c:forEach items="${kpointList }" var="obj">
						<option <c:if test="${obj.id == bank.k1 }">selected="selected"</c:if>  value="${obj.id}">${obj.name}
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>知识点2:</td>
			<td>
				<select id="knowledgePointId2" name="knowledgePointId2">
					<option value="0">请选择...
					<c:forEach items="${kpointList }" var="obj">
						<option <c:if test="${obj.id == bank.k2 }">selected="selected"</c:if>  value="${obj.id}">${obj.name}
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td width="80px">出题人:<span style="color: red">*</span></td>
			<td>
				<input type="text" name="member"  id="member" <c:if test="${not empty bank }">readonly="readonly"</c:if> value="${bank.member }">
			</td>
		</tr>
		
		<tr>
			<td>词汇级别:</td>
			<td>
				<div id="ul_id" style="border:dotted 1px black; background-color:#FFF0F5; overflow: auto;max-height: 100px;width: 600px;">
					<ul>
						<c:forEach items="${bank.standardLevelList }" var="str">
							<li style="margin: 5px;padding: 5px;">${str }</li>
						</c:forEach>
					</ul>
				</div>
			</td>
		</tr>
		<tr>
			<td>教材:</td>
			<td>
				<select id="materialId" name="materialId" onchange="chooseMKecheng()">
					<option value="0">请选择...
					<c:forEach items="${materialList }" var="obj">
						<option <c:if test="${obj.id == bank.materialId }">selected="selected"</c:if>  value="${obj.id}">${obj.name}
					</c:forEach>
				</select>
				<select id="materialKechengId" name="materialKechengId">
					<option value="0">请选择...
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
		
		<tr>
			<td>试题标签:</td>
			<td>
				<textarea name="tags" id="tags" rows="10" cols="20" style="width: 600px;">${bank.tags }</textarea>
			</td>
		</tr>
	</table>	
	<table class="Mytable">	
		<tr>
			<td width="80px">备注:</td>
			<td>
				<textarea name="remark" id="remark" rows="5" cols="20" style="width: 600px;">${bank.remark }</textarea>
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
</body>
</html>