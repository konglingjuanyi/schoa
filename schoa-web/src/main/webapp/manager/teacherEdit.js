Ext.onReady(function(){
	
	Ext.QuickTips.init();
	
	var pic = new ImgUpLoadWindow(function(fp, response){
		if(response.result.success){
			var path = response.result.data;
			if(_isNull(path)){
				alert("未接收到图片！");
			}else{
				showHeadImg(path);
			}
			pic.hide();
		}else{
			alert(response.result.msg);
		}
	});
	
	this.chooseImg = function(){
		pic.show();
	};
	
	var st = new Ext.form.DateField({
		renderTo : 'startDateDiv',
		format : 'Y-m-d',
		name : 'startDate',
		value: $('hideStartDate').value,
		id : 'startDateID'
	});
	
	var ed = new Ext.form.DateField({
		renderTo : 'endDateDiv',
		format : 'Y-m-d',
		name : 'endDate',
		value: $('hideEndDate').value,
		id : 'endDateID'
	});
	
	this.save = function(){
		if(_isNull($("name").value)){
			$("name").focus();
			alert("请填写教师姓名！");
			return false;
		}
		if(_isNull($("code").value)){
			$("code").focus();
			alert("请填写教师编号！");
			return false;
		}
		if(!regexVerify('intege1', $("code").value)){
			alert("教师编号请填写正整数！");
			$("code").focus();
			return false;
		}
		if(!_isNull($("startDateID").value) && !isDate($("startDateID").value)){
			alert("入职日期格式错误！");
			$("startDateID").focus();
			return false;
		}
		if(!_isNull($("endDateID").value) && !isDate($("endDateID").value)){
			alert("离职日期格式错误！");
			$("endDateID").focus();
			return false;
		}
		if(_isNull($("phone").value)){
			$("phone").focus();
			alert("请填写教师电话！");
			return false;
		}
		
		var cardResult = isCardID($("cardNumb").value);
		if(cardResult==true || cardResult=='true'){
		}else{
			alert(cardResult);
			$("cardNumb").focus();
			return false;
		}
	};
	
	new Ext.Viewport({
		layout : 'fit',
		items : [{
			title : '教师信息编辑',
			bodyStyle:'padding:5px', 
			border : false,
			frame : false,
			autoScroll : true,
			contentEl : 'div_panel_id'
		}]
	});
	
	this.showHeadImg = function(path){
		document.getElementById('headImg').src = IMAGEURL + path;
		document.getElementById('hideHeadPic').value = path;
		document.getElementById('headImg').style.display = '';
	};
	this.hideHeadImg = function(){
		document.getElementById('headImg').src = '';
		document.getElementById('hideHeadPic').value = '';
		document.getElementById('headImg').style.display = 'none';
	};
	
	var hideHeadPic = document.getElementById('hideHeadPic').value;
	if(hideHeadPic == '' || hideHeadPic == null){
		hideHeadImg();
	}else{
		showHeadImg(hideHeadPic);
	}
});
