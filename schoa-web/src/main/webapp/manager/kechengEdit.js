Ext.onReady(function(){
	Ext.QuickTips.init();
	
	this.save = function(){
		if(_isNull($("name").value)){
			$("name").focus();
			alert("请填写课程名称！");
			return false;
		}
		if($("xueqiId").value == 0){
			alert("请选择学期！");
			return false;
		}
		if($("teacherId").value == 0){
			alert("请选择任课教师！");
			return false;
		}
		if(!_isNull($("keshi").value) && $("keshi").value !=0 && !regexVerify('intege1', $("keshi").value)){
			alert("周课时需填写正整数！");
			$("keshi").focus();
			return false;
		}
		
		var fileFlags = _getSelectValues("fileFlag");
		if(fileFlags.length < 8){
			alert("请最少选择8个需上传的教学文件！");
			return false;
		}
		
		
		$("fileFlags").value = fileFlags;
		
		
	};
	
	new Ext.Viewport({
		layout : 'fit',
		items : [{
			title : '课程信息编辑',
			bodyStyle:'padding:5px', 
			border : false,
			frame : false,
			autoScroll : true,
			contentEl : 'div_panel_id'
		}]
	});
});
