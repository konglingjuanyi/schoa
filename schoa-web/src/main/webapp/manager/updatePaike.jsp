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
<style type="text/css">
body{
	font: 10px Verdana, Arial, Helvetica, sans-serif;
} 
table{   
    border:1px solid #99bbe8;   
    border-collapse:collapse; 
	width:100%;
    text-align: center;
}   
table td {   
    border:1px solid #99bbe8; 
    padding: 5px;
}   
table th {   
    border:1px solid #99bbe8;   
	background-color: #dfe8f6;
    padding: 5px;
}   
a{
	text-decoration:none;
}
.Mybotton{
	 padding: 5px 10px 5px 10px;
	 margin: 2px 0px 2px 5px;
}
#box{ width:340px; margin:0 auto; background:#fff; border:1px solid #ccc; padding:20px; display:none; -webkit-border-radius: 10px;-moz-border-radius: 10px; display:none; } 
</style>
<title>
</title>
	<script type="text/javascript" src="<%=syspath%>/utils/jquery.js"></script>
	<script type="text/javascript" src="<%=syspath%>/utils/blockUI.js"></script>
	
</head>
<body>
	<h1>变更排课</h1>
	<table style="border:0px; width:100%" >
		<tr>
			<td style="border:0px;" align="left">
				学期：
				<select id="xueqi" onchange="chooseClasses()">
					<option value="0">请选择...
					<c:forEach items="${xuqiList }" var="xq">
						<option 
						<c:if test="${xq.id == xueqiId }">selected="selected"</c:if>
						value="${xq.id}">${xq.name}
					</c:forEach>
				</select>
				班级：
				<select id="classes">
					<option value="0">请选择...
					<c:forEach items="${banjiList }" var="cs">
						<option 
						<c:if test="${cs.id == banjiId }">selected="selected"</c:if>
						value="${cs.id}">${cs.name}
					</c:forEach>
				</select>
				<input type="button" value="搜索" class="Mybotton" onclick="searchFunc()">
			</td>
		</tr>
	</table>
	
<div style="overflow: auto;" id="div_id">
<table>
	<tbody>
		<tr>
			<th>Time/Day</th>
			<th>周一Monday</th>
			<th>周二Tuesday</th>
			<th>周三Wednesday</th>
			<th>周四Thursday</th>
			<th>周五Friday</th>
			<th>周六Saturday</th>
			<th>周日Sunday</th>
		</tr>
	<c:choose>
		<c:when test="${empty paikeMap }">
			<tr>
				<td colspan="8">无数据！</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${paikeMap }" var="map">
			<c:set value="${map.value }" var="paike"/>
			<tr>
				<td>
					${paike.startStr}-${paike.endStr}
				</td>
				<td>
					<c:forEach items="${kechengList }" var="kc">
					<c:if test="${kc.id ==  paike.wks[0]}">
						<a href="javascript:void(0)"
						 onclick="openWindow(${kc.id},${paike.paiKeId[0]},'${paike.startStr}','${paike.endStr}','${kc.name }-${kc.teacher.name }')">
						 ${kc.name }-${kc.teacher.name }
						</a>
					</c:if>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${kechengList }" var="kc">
					<c:if test="${kc.id ==  paike.wks[1]}">
						<a href="javascript:void(0)"
						 onclick="openWindow(${kc.id},${paike.paiKeId[1]},'${paike.startStr}','${paike.endStr}','${kc.name }-${kc.teacher.name }')">
						 ${kc.name }-${kc.teacher.name }
						</a>
					</c:if>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${kechengList }" var="kc">
					<c:if test="${kc.id ==  paike.wks[2]}">
						<a href="javascript:void(0)"
							 onclick="openWindow(${kc.id},${paike.paiKeId[2]},'${paike.startStr}','${paike.endStr}','${kc.name }-${kc.teacher.name }')">
							 ${kc.name }-${kc.teacher.name }
							</a>
		
					</c:if>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${kechengList }" var="kc">
					<c:if test="${kc.id ==  paike.wks[3]}">
						<a href="javascript:void(0)"
							 onclick="openWindow(${kc.id},${paike.paiKeId[3]},'${paike.startStr}','${paike.endStr}','${kc.name }-${kc.teacher.name }')">
							 ${kc.name }-${kc.teacher.name }
							</a>
		
					</c:if>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${kechengList }" var="kc">
					
						<c:if test="${kc.id ==  paike.wks[4]}">
						<a href="javascript:void(0)"
							 onclick="openWindow(${kc.id},${paike.paiKeId[4]},'${paike.startStr}','${paike.endStr}','${kc.name }-${kc.teacher.name }')">
							 ${kc.name }-${kc.teacher.name }
							</a>
						</c:if>
						
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${kechengList }" var="kc">
					
						
						<c:if test="${kc.id ==  paike.wks[5]}">
						<a href="javascript:void(0)"
							 onclick="openWindow(${kc.id},${paike.paiKeId[5]},'${paike.startStr}','${paike.endStr}','${kc.name }-${kc.teacher.name }')">
							 ${kc.name }-${kc.teacher.name }
							</a>
						</c:if>
						
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${	kechengList }" var="kc">
					
						<c:if test="${kc.id ==  paike.wks[6]}">
						<a href="javascript:void(0)"
							 onclick="openWindow(${kc.id},${paike.paiKeId[6]},'${paike.startStr}','${paike.endStr}','${kc.name }-${kc.teacher.name }')">
							 ${kc.name }-${kc.teacher.name }
							</a>
						</c:if>
						
					</c:forEach>
				</td>
			</tr>
			</c:forEach>
			</c:otherwise>
		</c:choose>
		
	</tbody>
</table>
</div>	

<c:if test="${isHaveKaoqin }">
<h3>
	<span style="color: red;">注意：该班级已经存在考勤记录，修改后考勤数据将转移为新排课程的考勤，请慎重修改！</span>
</h3>
</c:if>


<div id="box">
	<div>
	<h3>
		<span id="winTitle"></span>
	</h3>
	<table style="border: 0;">
		<tr style="border: 0;">
			<td style="border: 0;">
				<select id="new_kecheng_id">
					<option value="0">选择新课程...
					<c:forEach items="${kechengList }" var="kc">
						<option value="${kc.id }">${kc.name }-${kc.teacher.name }
					</c:forEach>
				</select>
			</td>
			<td style="border: 0;">
				<input type="button" value="确定" class="Mybotton" onclick="save()">
				<input type="button" value="关闭" class="Mybotton" onclick="closeWin()">
			</td>
		</tr>
	</table>
	</div>
</div>

<script type="text/javascript">
(function() {
	var _paikeId = 0;
	var _oldKechengId = 0;
	
	this.closeWin = function(){
		$.unblockUI();
	};
	
	this.save = function(){
		var newKechengId = document.getElementById('new_kecheng_id').value;
		if(newKechengId <=0){
			alert("请选择新的课程");
			return;
		}
		var _xueqiId  = "${xueqiId}";
		var _banjiId  = "${banjiId}";
		
		if(_paikeId > 0){
			if(confirm('确定修改排课吗？修改后考勤数据将转移为新排课程的考勤！')){
				location.href = "saveUpdatePaike.do?xueqiId="+_xueqiId
						+"&banjiId="+_banjiId
						+"&paikeId="+_paikeId
						+"&oldKechengId="+_oldKechengId
						+"&newKechengId="+newKechengId;
			}
		}else{
			alert("数据错误，请刷新页面重新操作！或联系管理员！");
		};
	};
	
	this.openWindow = function(oldKechengId,paikeId,startTime,endTime,kcInfo){
		_paikeId = paikeId;
		_oldKechengId = oldKechengId;
		var str = "修改排课ID＝" + paikeId + "的记录,";
		str += startTime + '-' + endTime;
		str += ',排课信息：' + kcInfo ;
		
		$('#winTitle').text(str);
	
		$.blockUI({ 
            message: $('#box'), 
            css: {
                background:'none'
            } 
        }); 
		
		$('.blockOverlay').css('width','100%');
		$('.blockOverlay').css('height','100%');
	};
	
	
	this.searchFunc = function() {
			var xueqiId = document.getElementById("xueqi").value;
			var banjiId = document.getElementById("classes").value;
			if (xueqiId == 0) {
				alert("请选择学期！");
				return;
			}
			if (banjiId == 0) {
				alert("请选择班级！");
				return;
			}
			location.href = "initUpdatePaike.do?xueqiId="+xueqiId+"&banjiId="+banjiId;
		};

		
	this.chooseClasses = function() {
			var xueqiId = document.getElementById("xueqi").value;
			var classes = document.getElementById("classes");
			_cleanSelect(classes);
			classes.options.add(new Option("请选择...", 0))
			$.get('getClassesByXueqiId.do?privilege=1&xueqiId=' + xueqiId, {},
					function(data) {
						var resp = eval("(" + data + ")");
						if (resp == null) {
							return;
						}
						for ( var i = 0; i < resp.length; i++) {
							var ent = resp[i];
							classes.options.add(new Option(ent.name, ent.id));
						}
					});
		};

	this._cleanSelect = function(selectObj) {
			var len = selectObj.options.length;
			for ( var i = 0; i < len; i++) {
				selectObj.options.remove(selectObj.options[i]);
			}
		};
	})();
</script>	
</body>
</html>