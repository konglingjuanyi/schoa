<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String syspath = request.getContextPath();
%>
<html>
	<head>
		<style type="text/css">
			/* grid可以被复制选中的样式 */
			.x-selectable, .x-selectable * {   
			    user-select: text! important;  
			    -o-user-select: text! important;  
			    -moz-user-select: text! important;  
			    -khtml-user-select: text! important;  
			    -webkit-user-select: text! important;  
			} 
			/* grid单选radio样式 */ 		
			.x-grid-radio-custom .x-grid3-row-checker, .x-grid-radio-custom .x-grid3-hd-checker {
			    background-image:url(ext-3.2.1/resources/images/default/grid/row-radio-sprite.gif);
			}
			
			.Myfont{
				 font-size: 13px;
			 	 font: 宋体;
			}
			.Myfont2{
				 font-size: 13px;
			 	 font: 宋体;
			 	 color: red;
			 	 padding-right:7px;
			}
			.Mytable{
				padding:5px;
				border: 0;
				width: 100%;
			}
			.Mytable2{
				border-color: #d8d8d8;
				width: 100%;
			}
			.Mytable tr{
				 font-size: 13px;
			 	 font: 宋体;
			 	 height : 40px;
			}
			.Mytable2 tr{
				 font-size: 13px;
			 	 font: 宋体;
			 	 height : 40px;
			}
			.table3{
				    border:1px solid #99bbe8;   
				    border-collapse:collapse; 
					width:100%;
			}
			.table3 td {   
			    border:1px solid #99bbe8; 
			    text-align: center;
			}   
			.table3 th {   
			    border:1px solid #99bbe8;   
				background-color: #ECECFF;
			    text-align: center;
			} 
			.table3 tr{
				 font-size: 13px;
			 	 font: 宋体;
			 	 height : 25px;
			}
			.table4{
				    border:1px solid #99bbe8;   
				    border-collapse:collapse; 
					width:100%;
			}
			.table4 td {   
			    border:1px solid #99bbe8; 
			    text-align: left;
			}   
			.table4 th {   
			    border:1px solid #99bbe8;   
				background-color: #ECECFF;
			    text-align: left;
			} 
			.table4 tr{
				 font-size: 13px;
			 	 font: 宋体;
			 	 height : 25px;
			}
			.infotable{
			    border:1px solid #99bbe8;   
			    border-collapse:collapse; 
				width:60%;
				margin-left: 5px;
			}
			.infotable td {   
			    border:1px solid #99bbe8; 
			    text-align: center;
			}   
			.infotable th {   
			    border:1px solid #99bbe8;   
				background-color: #ECECFF;
			    text-align: center;
			} 
			.infotable tr{
				 font-size: 13px;
			 	 font: 宋体;
			 	 height : 25px;
			}
			.Mytextarea{
				height: 70px;
				padding: 5px;
				width:250px;
			}
			.Mytext{
				padding: 5px;
				width:250px;
			}
			.Myselect{
				 font-size: 13px;
			}
			.Mybotton{
				 padding: 5px 10px 5px 10px;
				 margin: 2px 0px 2px 5px;
			}
			.Printbotton{
				 padding: 2px 10px 4px 10px;
				 margin: 2px 0px 2px 5px;
			}
			select{
				margin-right: 20px;
			}
		</style>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<!-- EXT -->
		<link rel="stylesheet" type="text/css" href="<%=syspath%>/ext-3.2.1/resources/css/ext-all.css" />
		<script type="text/javascript" src="<%=syspath%>/ext-3.2.1/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="<%=syspath%>/ext-3.2.1/ext-all.js"></script>
		<script type="text/javascript" src="<%=syspath%>/ext-3.2.1/ext-lang-zh_CN.js"></script>
		<script type="text/javascript" src="<%=syspath%>/ext-3.2.1/ext-copy.js"></script>
		
		<script type="text/javascript" src="<%=syspath%>/utils/custom.js"></script>
		<script type="text/javascript" src="<%=syspath%>/utils/myUtil.js"></script>
		<script type="text/javascript" src="<%=syspath%>/utils/validatorRegex.js"></script>
		
		<script type="text/javascript">
		var syspath = '<%=syspath%>';
		var IMAGEURL = '${IMAGEURL}'; //图片服务器地址
		var PAGESIZE = 20;
		
		function showSex(val){
			return (val == 1||val =='1') ? '女' : '男';
		}
		function showCountry(src){
			return _isNull(src)?'':'<img style="max-width: 40px;max-height:40px;" src="'+ src +'">';
		}
		function showIMG(src){
			return _isNull(src)?'':'<img style="max-width: 40px;max-height:40px;" src="'+ IMAGEURL + src +'">';
		}
		function tofixedFunc(d){
			if(_isNull(d)){
				return 0;
			}
			return d.toFixed(2);
		}
		
		</script>
	</head>
</html>