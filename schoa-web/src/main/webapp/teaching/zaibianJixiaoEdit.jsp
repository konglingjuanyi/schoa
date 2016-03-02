<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在编教师工作绩效编辑</title>
<style type="text/css">
		li {
			padding: 5px;
			color: #428bca;
		}
		dl dd{
			float:left;
			padding: 15px;
		}
		div {
			padding: 5px;
		}
		img{
			max-width: 150px;
			height: auto;
		}
		td{
			font-size: 14px;
			padding: 5px;
			height: 30px;
		}
	
	</style>
	<%
	String syspath = request.getContextPath();
%>
<script type="text/javascript" src="<%=syspath%>/utils/myUtil.js"></script>
</head>
<body>

<h3>在编教师工作绩效编辑</h3>

<div id="div_id" style="overflow: auto;">
	<div>
		<ul>
			<li> 学期：${xueqi.name } </li>
			<li> 教师：${teacher.name } </li>
		</ul>
	</div>

<form name="form1" action="saveZaibianTeacherJixiao.do" method="post" enctype="multipart/form-data">
	
	<input type="hidden" id="xueqiId" name="xueqiId" value="${xueqi.id }">
	<input type="hidden" id="teacherId" name="teacherId" value="${teacher.id }">
	
	<table class="Mytable">
		<tr>
			<td width="110px">开会出勤：</td>
			<td>
				<input id="scKaihuiReason" name="scKaihuiReason" value="${jixiao.scKaihuiReason }" style="width: 300px">
			</td>
		</tr>
		<tr>
			<td width="110px">班主任工作：</td>
			<td>
				<input id="scBanzhuren" name="scBanzhuren" value="${jixiao.scBanzhuren }" style="width: 300px">
			</td>
		</tr>
		<tr>
			<td width="110px">兼任工作：</td>
			<td>
				<input id="scJianren" name="scJianren" value="${jixiao.scJianren }" style="width: 300px">
			</td>
		</tr>
		<tr>
			<td width="110px">其他工作：</td>
			<td>
				<input id="scOther" name="scOther" value="${jixiao.scOther }" style="width: 300px">
			</td>
		</tr>
		<tr>
			<td width="110px">年终得奖情况：</td>
			<td>
				<input id="scJiang" name="scJiang" value="${jixiao.scJiang }" style="width: 300px">
			</td>
		</tr>
		<tr>
			<td width="110px">教学工作量：</td>
			<td>
				<input id="scGongzuoliang" name="scGongzuoliang" value="${jixiao.scGongzuoliang }" style="width: 300px">
			</td>
		</tr>
		<tr>
			<td width="110px">学校考核：</td>
			<td>
				<input type="file" value="上传" id="scKaoheFile" name="scKaoheFile">	
				
				<c:if test="${not empty jixiao.scKaoheFile }">
					<a target="_blank" href="downloadZaibianJixiaoFile.do?id=${jixiao.id }">下载《${ jixiao.scKaoheFilename }》</a>
				</c:if>
			</td>
		</tr>
		
		<tr>
			<td width="110px">备注：</td>
			<td>
				<textarea name="remark" id="remark" rows="10" cols="10" style="width: 500px;">${jixiao.remark }</textarea>
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

<script type="text/javascript">
document.getElementById("div_id").style.height = (document.documentElement.clientHeight - 80) + "px";
</script>
</html>