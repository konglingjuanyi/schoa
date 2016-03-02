Ext.onReady(function(){
	Ext.QuickTips.init();
	
	this.save = function(){
		if(_isNull($("name").value)){
			alert("请填写学期名称！");
			$("name").focus();
			return false;
		}
		if($("startDateID").value == 0){
			alert("请选择开始日期！");
			$("startDateID").focus();
			return false;
		}
		if(!isDate($("startDateID").value)){
			alert("开始日期格式错误！");
			$("startDateID").focus();
			return false;
		}
		if($("endDateID").value == 0){
			alert("请选择结束日期！");
			return false;
		}
		if(!isDate($("endDateID").value)){
			alert("结束日期格式错误！");
			$("endDateID").focus();
			return false;
		}
		document.getElementById("hideShuxing").value = _getRadioValueJS("shuxing");
	};
	
	var st = new Ext.form.DateField({
		renderTo : 'startDateDiv',
		format : 'Y-m-d',
		name : 'startDate',
		readOnly:$("haveKaoqin").value==1?true:false,
		value: $('hideStartDate').value,
		id : 'startDateID'
	});
	var ed = new Ext.form.DateField({
		renderTo : 'endDateDiv',
		format : 'Y-m-d',
		name : 'endDate',
		readOnly:$("haveKaoqin").value==1?true:false,
		value: $('hideEndDate').value,
		id : 'endDateID'
	}); 
	
	new Ext.Viewport({
		layout : 'fit',
		items : [{
			title : '学期信息编辑',
			bodyStyle:'padding:5px', 
			border : false,
			frame : false,
			autoScroll : true,
			contentEl : 'div_panel_id'
		}]
	});
});
