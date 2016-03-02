<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@include file="../import.jsp"%> --%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
	li{
		margin: 10px;
		padding: 5px;
		font-size:22;
	}
</style>
</head>
<body>
<h2>北京邮电大学${paperAnalysis.xueqi.name }教学试卷分析</h2>
<hr/>
<form action="savePaper.do" id="form1" method="post" onsubmit="return save()">

	<input type="hidden" id="print" name="print" value="0">
	<input type="hidden" id="id" name="id" value="${paperAnalysis.id }">

	<div style="font-size: 14px;font: 宋体;margin-left: 10px;overflow: auto;margin-bottom: 20px;">
		<ul>
			<li>班级名称:${paperAnalysis.banji.name }</li>
			<li>教材名称:${paperAnalysis.kecheng.jiaocai }</li>
			<li>考试课程:${paperAnalysis.kecheng.name }</li>
			<li>
				命题教师:
				<input type="text" id="mingtiTeacher" name="mingtiTeacher" value="${paperAnalysis.mingtiTeacher}" >
			</li>
			<li>
				考试方式:
				<c:set var="css" value="${((paperAnalysis.kaoshiType eq '闭卷') or (paperAnalysis.kaoshiType eq '开卷')) ? 'none':''}"></c:set>
				<select onchange="kaoshifangshi(this)">
					<option value="闭卷" <c:if test="${paperAnalysis.kaoshiType eq '闭卷' }">selected="selected"</c:if>>闭卷
					<option value="开卷" <c:if test="${paperAnalysis.kaoshiType eq '开卷' }">selected="selected"</c:if>>开卷
					<option value="其他" <c:if test="${css eq '' }">selected="selected"</c:if>>其他
				</select>
				<input type="text" id="kaoshiType" name="kaoshiType" value="${paperAnalysis.kaoshiType}" style="display: ${css}" >
			</li>
		</ul>
		<h3>试题质量</h3><hr>
		<ul>
			<li>
				命题规范，符合大纲要求:
				<input type="radio" name="zl01" value="1" <c:if test="${paperAnalysis.zl01 == 1 }">checked="checked"</c:if>>A
				<input type="radio" name="zl01" value="2" <c:if test="${paperAnalysis.zl01 == 2 }">checked="checked"</c:if>>B
				<input type="radio" name="zl01" value="3" <c:if test="${paperAnalysis.zl01 == 3 }">checked="checked"</c:if>>C
				<input type="radio" name="zl01" value="4" <c:if test="${paperAnalysis.zl01 == 4 }">checked="checked"</c:if>>D
			</li>
			<li>
				题量适当:
				<input type="radio" name="zl02" value="1" <c:if test="${paperAnalysis.zl02 == 1 }">checked="checked"</c:if>>A
				<input type="radio" name="zl02" value="2" <c:if test="${paperAnalysis.zl02 == 2 }">checked="checked"</c:if>>B
				<input type="radio" name="zl02" value="3" <c:if test="${paperAnalysis.zl02 == 3 }">checked="checked"</c:if>>C
				<input type="radio" name="zl02" value="4" <c:if test="${paperAnalysis.zl02 == 4 }">checked="checked"</c:if>>D
			</li>
			<li>
				难易程度:
				<input type="radio" name="zl03" value="1" <c:if test="${paperAnalysis.zl03 == 1 }">checked="checked"</c:if>>A
				<input type="radio" name="zl03" value="2" <c:if test="${paperAnalysis.zl03 == 2 }">checked="checked"</c:if>>B
				<input type="radio" name="zl03" value="3" <c:if test="${paperAnalysis.zl03 == 3 }">checked="checked"</c:if>>C
				<input type="radio" name="zl03" value="4" <c:if test="${paperAnalysis.zl03 == 4 }">checked="checked"</c:if>>D
			</li>
			<li>
				覆盖面大:
				<input type="radio" name="zl04" value="1" <c:if test="${paperAnalysis.zl04 == 1 }">checked="checked"</c:if>>A
				<input type="radio" name="zl04" value="2" <c:if test="${paperAnalysis.zl04 == 2 }">checked="checked"</c:if>>B
				<input type="radio" name="zl04" value="3" <c:if test="${paperAnalysis.zl04 == 3 }">checked="checked"</c:if>>C
				<input type="radio" name="zl04" value="4" <c:if test="${paperAnalysis.zl04 == 4 }">checked="checked"</c:if>>D
			</li>
			<li>
				试题中综合性、设计性题目的水平:
				<input type="radio" name="zl05" value="1" <c:if test="${paperAnalysis.zl05 == 1 }">checked="checked"</c:if>>A
				<input type="radio" name="zl05" value="2" <c:if test="${paperAnalysis.zl05 == 2 }">checked="checked"</c:if>>B
				<input type="radio" name="zl05" value="3" <c:if test="${paperAnalysis.zl05 == 3 }">checked="checked"</c:if>>C
				<input type="radio" name="zl05" value="4" <c:if test="${paperAnalysis.zl05 == 4 }">checked="checked"</c:if>>D
			</li>
		</ul>
		
		<h3>卷面分数分布情况</h3><hr>
		
		<ul>
			<li>
				90分以上<span style="color: blue;">${paperAnalysis.fen90}</span>人,
				占参加考试人数比例<span style="color: blue;">${paperAnalysis.fen90Bili}</span>%
			</li>
			<li>
				80-89分<span style="color: blue;">${paperAnalysis.fen8089}</span>人,
				占参加考试人数比例<span style="color: blue;">${paperAnalysis.fen8089Bili}</span>%
			</li>
			<li>
				70-79分<span style="color: blue;">${paperAnalysis.fen7079}</span>人,
				占参加考试人数比例<span style="color: blue;">${paperAnalysis.fen7079Bili}</span>%
			</li>
			<li>
				60-69分<span style="color: blue;">${paperAnalysis.fen6069}</span>人,
				占参加考试人数比例<span style="color: blue;">${paperAnalysis.fen6069Bili}</span>%
			</li>
			<li>
				59分以下<span style="color: blue;">${paperAnalysis.fen59}</span>人,
				占参加考试人数比例<span style="color: blue;">${paperAnalysis.fen59Bili}</span>%
			</li>
			<li>
				总计<span style="color: blue;">${paperAnalysis.total}</span>人,
				占参加考试人数比例<span style="color: blue;">${paperAnalysis.totalBili}</span>%
			</li>
		</ul>
		
		<h3>对学生卷面考试成绩总体评价及原因分析</h3>
				<textarea name="fenxi1" id="fenxi1" cols="80" rows="5" class="Mytextarea" style="width: 600px;height: 100px;">${paperAnalysis.fenxi1 }</textarea>
		
		<h3>学生关于各类题型答题情况及原因分析</h3>
				<textarea name="fenxi2" id="fenxi2" cols="80" rows="5" class="Mytextarea" style="width: 600px;height: 100px;">${paperAnalysis.fenxi2 }</textarea>


		<p>
		<c:if test="${canmodifiy }">
			<input type="submit" value="保存" class="Mybotton">
			<button class="Printbotton" onclick="exportPaperAnalysis()">
				<img src="imgs/print.png" style="margin-right: 5px;">保存并打印
			</button>
		</c:if>
		<input type="button" value="关闭" class="Mybotton" onclick="javascript:window.close();">
	</div>
	
	
	
</form>

<script type="text/javascript">
var kaoshiType = document.getElementById("kaoshiType");
function save(){
	
}
function kaoshifangshi(select){
	if(select.value == '其他'){
		kaoshiType.style.display = '';
		kaoshiType.value = '';
	}else{
		kaoshiType.style.display = 'none';
		kaoshiType.value = select.value;
	}
}
function exportPaperAnalysis(){
	document.getElementById('print').value = 1;  
	document.getElementById('form1').submit();  
}
</script>

</body>
</html>