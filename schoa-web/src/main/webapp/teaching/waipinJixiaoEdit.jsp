<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>外聘教师工作绩效编辑</title>
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

<h3>外聘教师工作绩效编辑</h3>

<div id="div_id" style="overflow: auto;">
	<div>
		<ul>
			<li> 学期：${xueqi.name } </li>
			<li> 教师：${teacher.name } </li>
		</ul>
	</div>
	
<form name="form1" action="saveWaipinTeacherJixiao.do" method="post">
	
	<input type="hidden" id="xueqiId" name="xueqiId" value="${xueqi.id }">
	<input type="hidden" id="teacherId" name="teacherId" value="${teacher.id }">
	
	<table class="Mytable">
		<tr>
			<td width="110px">开会出勤：</td>
			<td>
				<select id="scKaihui" name="scKaihui">
					<c:forEach begin="0" step="1" end="10" var="x">
						<option value="${x }" <c:if test="${jixiao.scKaihui == x }">selected="selected"</c:if>>${x }
					</c:forEach>
				</select>分，
				<input id="scKaihuiReason" name="scKaihuiReason" value="${jixiao.scKaihuiReason }" style="width: 300px">
			</td>
		</tr>
		<tr>
			<td width="110px">参加学生活动：</td>
			<td>
				<select id="scHuodong" name="scHuodong">
					<c:forEach begin="0" step="1" end="5" var="x">
						<option value="${x }" <c:if test="${jixiao.scHuodong == x }">selected="selected"</c:if>>${x }
					</c:forEach>
				</select>分，
				<input id="scHuodongReason" name="scHuodongReason" value="${jixiao.scHuodongReason }" style="width: 300px">
			</td>
		</tr>
		<tr>
			<td width="110px">教案：</td>
			<td>
				<select id="scYinxiang" name="scYinxiang">
					<c:forEach begin="0" step="1" end="10" var="x">
						<option value="${x }" <c:if test="${jixiao.scYinxiang == x }">selected="selected"</c:if>>${x }
					</c:forEach>
				</select>分，
				<input id="scYinxiangReason" name="scYinxiangReason" value="${jixiao.scYinxiangReason}" style="width: 300px">
			</td>
		</tr>
		<tr>
			<td width="110px">特殊贡献：</td>
			<td>
				<select id="scGongxian" name="scGongxian">
					<c:forEach begin="0" step="1" end="10" var="x">
						<option value="${x }" <c:if test="${jixiao.scGongxian == x }">selected="selected"</c:if>>${x }
					</c:forEach>
				</select>分，
				<input id="scGongxianReason" name="scGongxianReason" value="${jixiao.scGongxianReason}" style="width: 300px">
				<span style="color: #999;">注：此项为附加分</span>
			</td>
		</tr>
		<tr>
			<td width="110px">优秀教师：</td>
			<td>
				<input type="radio" id="youxiu_1" name="youxiu" value="1" <c:if test="${jixiao.youxiu == 1}">checked="checked"</c:if>><label for="youxiu_1">是</label>
				<input type="radio" id="youxiu_0" name="youxiu" value="0" <c:if test="${jixiao.youxiu == 10}">checked="checked"</c:if>><label for="youxiu_0">否</label>
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