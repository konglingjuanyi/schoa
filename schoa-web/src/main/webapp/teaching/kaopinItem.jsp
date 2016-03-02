<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>北京邮电大学教师评分标准</title>
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
		}
		.thumbnail{
			display: inline-block;
			display: block;
			height: auto;
			max-width: 150px;
			padding: 4px;
			line-height: 1.428571429;
			background-color: #fff;
			border: 1px solid #ddd;
			border-radius: 4px;
			-webkit-transition: all .2s ease-in-out;
			transition: all .2s ease-in-out;
		}
		.info{
			font-weight: normal;
			line-height: 1;
			font-size: 14px;
		}
		.shuoming{
			font-weight: normal;
			line-height: 1;
			color: #999;
			font-size: 12px;
		}
		.redioDiv{
			border-top:1px solid #f1f1f1;
			height: 75px;
		}
		.Mybotton{
			 padding: 5px 10px 5px 10px;
			 margin: 2px 0px 2px 5px;
		}
	</style>
</head>
<body>

<h5>
	<a href="initTeachingKaopin.do" style="text-decoration: none;">教学考评</a> >
	<a href="initTeacherKaopinList.do?kaopinId=${kaopin.id }" style="text-decoration: none;">${kaopin.teacher.name }考评列表</a> 
	>${kaopin.teacher.name }评分
</h5>

<div style="overflow: auto;" id="div_id">
	<form action="saveTeacherPingfen.do" method="post">
		<input type="hidden" id="hide_kaopin_id" name="hide_kaopin_id" value="${kaopin.id }">
		<input type="hidden" id="hide_kaopinInfo_id" name="hide_kaopinInfo_id" value="${kaopinInfo.id }">
		
		<input type="hidden" id="hide_title" name="hide_title" value="${kaopin.teacher.name }考评列表">
		
		<table style="width: 95%;overflow: auto;" align="center" id="table_id">
			<tr>
				<td style="width: 150px;">
					<div class="thumbnail">
					   <img alt="${kaopin.teacher.name }" src="${IMAGEURL }${kaopin.teacher.headPic }">
					</div>
				</td>
				<td valign="bottom">
					<div class="info">
						<ul>
							<li>名称：${kaopin.name }</li>
							<li>学期：${kaopin.xueqi.name }</li>
							<li>班级：${kaopin.banji.name }</li>
							<li>课程：${kaopin.kecheng.name }</li>
							<li>教师：${kaopin.teacher.name } </li>
						</ul>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="shuoming">
						说明：请认真填写评分
					</div>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
				
					<c:forEach var="map" items="${questionMap }">
					<c:set var="selected" value="${kaopinInfo[map.key]}" />
					<div class="redioDiv">
						<dl>
							<dt>${map.value }</dt>
							<dd>
								<input type="radio" name="${map.key }" value="1"  id="${map.key }_1" <c:if test="${selected == 1 }">checked="checked"</c:if>>
								<label for="${map.key }_1">
									<strong>不好</strong>
								</label>
							</dd>
							<dd>
								<input type="radio" name="${map.key }" value="2" id="${map.key }_2" <c:if test="${selected == 2 }">checked="checked"</c:if>>
								<label for="${map.key }_2">
									<strong>一般</strong>
								</label>
							</dd>
							<dd>
								<input type="radio" name="${map.key }" value="3" id="${map.key }_3" <c:if test="${selected == 3 }">checked="checked"</c:if>>
								<label for="${map.key }_3">
									<strong>好</strong>
								</label>
							</dd>
							<dd>
								<input type="radio" name="${map.key }" value="4" id="${map.key }_4" <c:if test="${selected == 4 }">checked="checked"</c:if>>
								<label for="${map.key }_4">
									<strong>很好</strong>
								</label>
							</dd>
							<dd>
								<input type="radio" name="${map.key }" value="5" id="${map.key }_5" <c:if test="${selected == 5 }">checked="checked"</c:if>>
								<label for="${map.key }_5">
									<strong>非常好</strong>
								</label>
							</dd>
						</dl>
					</div>
					</c:forEach>
					
					<div class="redioDiv" style="height: 200px">
						<dl>
							<dt>18.你对每门任课老师总的评价。 Please write down your personal opinions toward every teacher below.</dt>
							<dd>
								<textarea name="pingjia" id="pingjia" rows="10" cols="20" style="width: 500px;">${kaopinInfo.pingjia }</textarea>
							</dd>
						</dl>
					</div>
					
					<div style="border-top:  1px solid #f1f1f1;"></div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div>
						<c:if test="${admin }">
							<input type="submit" value="保存" class="Mybotton">
						</c:if>
					</div>
					
				</td>
			</tr>
		
		</table>
	</form>

</div>
 
<script type="text/javascript">
	document.getElementById("div_id").style.height = (document.documentElement.clientHeight - 80)+"px";
</script>
 
</body>
</html>