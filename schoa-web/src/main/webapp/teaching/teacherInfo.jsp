<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div style="display: ${empty teacher ? 'none' : ''}">
			<h1 style="margin: 15px 20px 10px 5px;color:blue;">
				基本信息
			</h1>
			<table class="infotable">
				<tr>
					<td rowspan="5"><img id="headImg" src="${IMAGEURL }${teacher.headPic}"  style="max-width: 133px;max-height:103px;"/></td>
					<td>姓名</td>
					<td>${teacher.name}</td>
				</tr>
				<tr>
					<td>性别</td>
					<td>${teacher.sex==1?'女':'男'}</td>
				</tr>
				<tr>
					<td>教师编号</td>
					<td>${teacher.code}</td>
				</tr>
				<tr>
					<td>电话</td>
					<td>${teacher.phone}</td>
				</tr>
				<tr>
					<td>身份证号</td>
					<td>${teacher.cardNumb}</td>
				</tr>
				
				<tr>
					<td>入职时间</td>
					<td colspan="2">${teacher.entryTime}</td>
				</tr>
				<tr>
					<td>离职时间</td>
					<td colspan="2">${teacher.lizhiTime}</td>
				</tr>
				<tr>
					<td>生日</td>
					<td colspan="2">${teacher.birthday}</td>
				</tr>
				<tr>
					<td>在读院校</td>
					<td colspan="2">${teacher.readingSchool}</td>
				</tr>
				<tr>
					<td>Email</td>
					<td colspan="2">${teacher.email}</td>
				</tr>
				<tr>
					<td>婚否</td>
					<td colspan="2">${teacher.married==0?'已婚':'未婚'}</td>
				</tr>
				<tr>
					<td>籍贯</td>
					<td colspan="2">${teacher.hometown}</td>
				</tr>
				<tr>
					<td>毕业院校</td>
					<td colspan="2">${teacher.graduated}</td>
				</tr>
				<tr>
					<td>专业背景</td>
					<td colspan="2">${teacher.pro}</td>
				</tr>
				<tr>
					<td>住址</td>
					<td colspan="2">${teacher.address}</td>
				</tr>
				<tr>
					<td>教学经历</td>
					<td colspan="2">${teacher.experience}</td>
				</tr>
				<tr>
					<td>科研成果</td>
					<td colspan="2">${teacher.research}</td>
				</tr>
				
			</table>
	</div>