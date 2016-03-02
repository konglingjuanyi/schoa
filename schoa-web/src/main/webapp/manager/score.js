Ext.onReady(function(){
	Ext.QuickTips.init();
	
	this.reset = function(){
		$('w_keguan').value = '';
		$('w_zhuguan').value = '';
		$('w_juanmian').innerHTML = '';
		$('w_40').innerHTML = '';
		$('w_qizhong').value = '';
		$('w_20').innerHTML = '';
		$('w_zuoye').value = '';
		$('w_rmark').value = '';
		$('w_zuoye20').innerHTML = '';
		$('w_kaoqin').innerHTML = '';
		$('w_keshi').innerHTML = '';
		$('w_chuqin').innerHTML = '';
		$('w_chengjiAll').innerHTML = '';
	};
	
	this.setValue = function(obj){
		reset();
		$('w_keguan').value = obj.scKeguan;
		$('w_zhuguan').value = obj.scZhuguan;
		calQimo();
		$('w_qizhong').value = obj.scQizhong;
		calQizhong();
		$('w_zuoye').value = obj.scZuoye;
		$('w_rmark').value = _isNull(obj.remark)?'':obj.remark;
		calZuoye();
		$('w_kaoqin').innerHTML = obj.totalKeshi - obj.queqin;
		$('w_keshi').innerHTML = obj.totalKeshi;
		if(obj.totalKeshi != 0){
			$('w_chuqin').innerHTML = 
				formatFloat((obj.totalKeshi-obj.queqin)*100*0.2/obj.totalKeshi);
		}
		
		$('w_chengjiAll').innerHTML = obj.scAll;
	};
	
	this.getParams = function(){
		var w_keguan = $('w_keguan').value;
		var w_zhuguan = $('w_zhuguan').value;
		var w_juanmian = $('w_juanmian').innerHTML;
		var w_40 = $('w_40').innerHTML;
		var w_qizhong = $('w_qizhong').value;
		var w_20 = $('w_20').innerHTML;
		var w_zuoye = $('w_zuoye').value;
		var w_rmark = $('w_rmark').value;
		var w_zuoye20 = $('w_zuoye20').innerHTML;
		var w_kaoqin = $('w_kaoqin').innerHTML;
		var w_keshi = $('w_keshi').innerHTML;
		var w_chuqin = $('w_chuqin').innerHTML;
		var w_chengjiAll = $('w_chengjiAll').innerHTML;
		var kaoqin = $('w_kaoqin').innerHTML;
		var totalKeshi = $('w_chengjiAll').innerHTML;
		return "&keguan="+w_keguan
				+"&zhuguan="+w_zhuguan
				+"&juanmian="+w_juanmian
				+"&w40="+w_40
				+"&qizhong="+w_qizhong
				+"&w20="+w_20
				+"&zuoye="+w_zuoye
				+"&zuoye20="+w_zuoye20
				+"&kaoqin="+w_kaoqin
				+"&keshi="+w_keshi
				+"&chuqin="+w_chuqin
				+"&rmark="+w_rmark
				+"&chengjiAll="+w_chengjiAll;
	};
	
	this.calQimo = function(){
		var w_keguan = getFloatValue('w_keguan');
		var w_zhuguan = getFloatValue('w_zhuguan');
		
		$('w_juanmian').innerHTML = formatFloat(w_keguan + w_zhuguan);
		$('w_40').innerHTML = formatFloat((w_keguan + w_zhuguan)*0.4);
		calAll();
	};
	
	this.calQizhong = function(){
		$('w_20').innerHTML = formatFloat(getFloatValue('w_qizhong')*0.2);
		calAll();
	};
	
	this.calZuoye = function(){
		$('w_zuoye20').innerHTML = formatFloat(getFloatValue('w_zuoye')*0.2);
		calAll();
	};
	
	this.getFloatValue = function(el){
		var tmp = document.getElementById(el).value;
		return (tmp==''||tmp==null)?0:parseFloat(tmp);
	};
	this.getHtmlValue = function(el){
		var tmp = document.getElementById(el).innerHTML;
		return (tmp==''||tmp==null)?0:parseFloat(tmp);
	};
	this.formatFloat = function(src){
	    return Math.round(src*Math.pow(10, 2))/Math.pow(10, 2);
	};
	
	this.calAll = function(){
		var w_40 = getHtmlValue('w_40');
		var w_20 = getHtmlValue('w_20');
		var w_chuqin = getHtmlValue('w_chuqin');
		var w_zuoye20 = getHtmlValue('w_zuoye20');
		$('w_chengjiAll').innerHTML = formatFloat(w_40 + w_20 + w_chuqin + w_zuoye20);
	};
	
	//试卷分析
	this.paperAnalysis = function(){
		var xueqiId = document.getElementById("xueqiId").value;
		var classesId = document.getElementById("classesId").value;
		var kechengId = document.getElementById("kechengId").value;
		if(xueqiId==0){
			alert("请选择学期！");
			return;
		}
		if(classesId==0){
			alert("请选择班级！");
			return;
		}
		if(kechengId==0){
			alert("请选择课程！");
			return;
		}
		var url = 'initPaperAnalysis.do?xueqiId='+xueqiId
							+'&banjiId='+classesId
							+'&kechengId='+kechengId
							+'&t='+new Date().getTime();
		window.open(url,'paper');
	};
	
	
	var editWindow = new com.custom.Window({
		title : '编辑学生成绩',
		width : 600,
		height : 520,
		layout : 'fit',
		plain : false,
		contentEl : 'myWindow',
		buttons : [{
			text : '保存',
			handler : function(){
				var url = "saveScore.do?xueqiId="+$('hidxueqiId').value+
								"&classesId="+$('hidclassesId').value+
								"&kechengId="+$('hidkechengId').value+
								"&studentId="+$('hidstudentId').value+
								getParams();
				Ext.Ajax.request( {
					url : url,
					success : function(response){
						var resp = Ext.util.JSON.decode(response.responseText);
						if(resp.success){
							alert("成绩已保存！");
							editWindow.hide();
							location.href = location.href ;
						}else{
							alert('操作失败');
						}
					}
				});
			}
		},{
			text : '关闭',
			handler : function(){
				editWindow.hide();
			}
		}]
	});
	
	this.updateF = function(bt,studentId,studentName){
		$('hidstudentId').value = studentId;
		Ext.Ajax.request( {
			url : 'getStudentScore.do?classesId='+$('hidclassesId').value
									+"&studentId="+studentId
									+"&xueqiId="+$("xueqiId").value
									+"&kechengId="+$('hidkechengId').value,
			success : function(response){
				var resp = Ext.util.JSON.decode(response.responseText);
				setValue(resp);
				editWindow.setTitle("编辑"+studentName+"成绩");
				editWindow.show(bt);
			}
		});
	};
	
	this.chooseClasses = function(){
		var xueqiId = $("xueqiId").value;
		var classesId = $("classesId");
		_cleanSelect(classesId);
		classesId.options.add(new Option("请选择...",0))
		Ext.Ajax.request( {
			url : 'getClassesByXueqiId.do?privilege=1&xueqiId='+xueqiId,
			success : function(response){
				var resp = Ext.util.JSON.decode(response.responseText);
				if(resp == null){
					return;
				}
				for(var i=0;i<resp.length;i++){
					var ent = resp[i];
					classesId.options.add(new Option(ent.name,ent.id));
				}
			}
		});
	};
	
	this.chooseKecheng = function(){
		var classesId = $("classesId").value;
		var kechengId = $("kechengId");
		_cleanSelect(kechengId);
		kechengId.options.add(new Option("请选择...",0))
		Ext.Ajax.request( {
			url : 'getKechengByClassesId.do?privilege=1&classesId='+classesId,
			success : function(response){
				var resp = Ext.util.JSON.decode(response.responseText);
				if(resp == null){
					return;
				}
				for(var i=0;i<resp.length;i++){
					var ent = resp[i];
					kechengId.options.add(new Option(ent.name,ent.id));
				}
			}
		});
	};
	
	this.commitFunc = function(){
		var xueqiId = document.getElementById("xueqiId").value;
		var classesId = document.getElementById("classesId").value;
		var kechengId = document.getElementById("kechengId").value;
		if(xueqiId==0){
			alert("请选择学期！");
			return;
		}
		if(classesId==0){
			alert("请选择班级！");
			return;
		}
		if(kechengId==0){
			alert("请选择课程！");
			return;
		}
		if(confirm("确定提交吗?提交后本课程成绩将不能修改！")){
			Ext.Ajax.request( {
				url : 'lockScore.do?kechengId='+kechengId+'&xueqiId='+xueqiId+'&classesId='+classesId,
				success : function(response){
					var resp = Ext.util.JSON.decode(response.responseText);
					if(resp.success){
						alert("本课程成绩已锁定！");
						location.href = location.href;
					}else{
						alert("操作失败！");
					}
				}
			});
		}
	};
	
	this.searchFunc=function(){
		var xueqiId = document.getElementById("xueqiId").value;
		var classesId = document.getElementById("classesId").value;
		var kechengId = document.getElementById("kechengId").value;
		if(xueqiId==0){
			alert("请选择学期！");
			return;
		}
		if(classesId==0){
			alert("请选择班级！");
			return;
		}
		if(kechengId==0){
			alert("请选择课程！");
			return;
		}
		location.href = "initScore.do?xueqiId="+xueqiId
				+"&classesId="+classesId
				+"&t="+new Date().getTime()
				+"&kechengId="+kechengId;
	};
	
	this.exportScore = function(){
		var xueqiId = document.getElementById("xueqiId").value;
		var classesId = document.getElementById("classesId").value;
		var kechengId = document.getElementById("kechengId").value;
		if(xueqiId==0){
			alert("请选择学期！");
			return;
		}
		if(classesId==0){
			alert("请选择班级！");
			return;
		}
		if(kechengId==0){
			alert("请选择课程！");
			return;
		}
		location.href = "exportScore.do?xueqiId="+xueqiId
				+"&classesId="+classesId
				+"&kechengId="+kechengId;
	};
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
			region : 'north',
			title :  "成绩管理",
			border : false,
			height : 80,
			contentEl : 'search_div_id'
		},{
			region : 'center',
			border : true,
			bodyStyle: 'border-width:1px 0 0 0;',
			autoScroll : true,
			contentEl : 'grid_div_id'
		}]
	});
	
});