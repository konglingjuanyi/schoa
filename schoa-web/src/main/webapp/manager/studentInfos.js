Ext.onReady(function(){
	
	Ext.QuickTips.init();
	
	var win = new WindowSelectStu(function(win,rec){
		location.href = "initStudentInfos.do?id="+rec.data.id;
	});
	
	//打印出勤表
	this.reportChuqin = function(studentId,classesId){
		window.open("initStudentChuqinPage.do?studentId="+studentId+"&classesId="+classesId);
	};
	
	//打印学习证明
	this.reportLearnZM = function(id){
		forwardExport("initReportStudyZhMPage.do?studentId="+id);
	};
	
	//打印优秀生
	this.reportYouxiu = function(id){
		forwardExport("initReportYouxiuStudent.do?studentId="+id);
	};
	
	//打印成绩单
	this.reportChengJiDan=function(studentId,classesId){
		window.open("initChengJiDan.do?studentId="+studentId+"&classesId="+classesId,'ChengJiDan');
	};
	
	//打印结业证
	this.reportJieYeZh=function(studentId,classesId){
		forwardExport("initReportJieYeZh.do?studentId="+studentId+"&classesId="+classesId);
	};
	
	this.openWindow = function(btn){
		win.show(btn);
	};
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
	        region : 'center',
	        title :  "学生信息汇总",
			frame : false,
			border: false,
			autoScroll : true,
			contentEl : 'search_div_id'
		}]
	});
	
});