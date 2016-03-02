Ext.onReady(function(){
	Ext.QuickTips.init();
	
	this.searchFunc=function(){
		var classesId = document.getElementById("classesId").value;
		var xueqi = document.getElementById("xueqiId").value;
		if(classesId==null||classesId==0){
			alert("请选择班级！");
			return;
		}
		location.href = "initClassesInfos.do?classesId="+classesId+"&xueqi="+xueqi;
	};
	
	this.updateF = function(id){
		window.open("initEditStudent.do?id="+id,"editstudent");
	};
	
	//打印优秀生
	this.reportYouxiu = function(id){
		forwardExport("initReportYouxiuStudent.do?studentId="+id);
	};
	
	//打印班级学生名单
	this.reportClassesStudents=function(){
		forwardExport("initReportStudents.do?ids="+IDS);
	};
	
	//打印出勤
	this.reportClassesKaoqin=function(classesId){
		window.open('initClassesChuqinPage.do?classesId='+classesId);
	};
	
	//打印课程表
	this.reportKecheng=function(classesId){
		forwardExport("initReportClassKecheng.do?classesId="+classesId);
	};
	
	//打印成绩单
	this.reportChengJiDan=function(studentId,classesId){
		window.open("initChengJiDan.do?studentId="+studentId+"&classesId="+classesId,'ChengJiDan');
	};
	
	//打印结业证
	this.reportJieYeZh=function(studentId,classesId){
		forwardExport("initReportJieYeZh.do?studentId="+studentId+"&classesId="+classesId);
	};
	
	this.chooseClasses = function(callback){
		var xueqiId = $("xueqiId").value;
		var classesId = $("classesId");
		_cleanSelect(classesId);
		classesId.options.add(new Option("请选择...",0))
		Ext.Ajax.request( {
			url : 'getClassesByXueqiId.do?xueqiId='+xueqiId,
			success : function(response){
				var resp = Ext.util.JSON.decode(response.responseText);
				if(resp == null){
					return;
				}
				for(var i=0;i<resp.length;i++){
					var ent = resp[i];
					classesId.options.add(new Option(ent.name,ent.id));
				}
				callback();
			}
		});
	};
	
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
			region : 'north',
			title:'班级信息汇总',
			border : false,
			bodyStyle: 'border-width:0 0 2px 0;',
			height : 80,
			keys : {
				key : Ext.EventObject.ENTER,
				fn : function(btn,e){
					searchFunc();
				}
			},
			contentEl : 'search_div_id'
		},{
	        region : 'center',
			frame : false,
			border : false,
			autoScroll : true,
			contentEl : 'main_div'
		}]
	});

	
	chooseClasses(function(){
		document.getElementById("classesId").value=document.getElementById("hidClassesId").value;
	});
});