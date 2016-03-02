Ext.onReady(function(){
	Ext.QuickTips.init();
	
	this.save = function(){
		if(_isNull($("name").value)){
			alert("请填写班级名称！");
			$("name").focus();
			return false;
		}
		if($("xueqiId").value == 0){
			alert("请选择学期！");
			return false;
		}
		if($("teacherId").value == 0){
			alert("请选择班主任！");
			return false;
		}
	};
	
	new Ext.Viewport({
		layout : 'fit',
		items : [{
			title : '班级信息编辑',
			bodyStyle:'padding:5px', 
			border : false,
			frame : false,
			autoScroll : true,
			contentEl : 'div_panel_id'
		}]
	});
});
