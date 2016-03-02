Ext.onReady(function(){
	
	Ext.QuickTips.init();
	console.log(STOREDATA);
	
	var store = new Ext.data.ArrayStore({
        fields: ['id', 'name', 'img'],
        data : STOREDATA
    });
	
    var CountryBox = new Ext.form.ComboBox({
        store: store,
        displayField:'name',
        hiddenName:'country',
        valueField : 'id',
        typeAhead: true,
        forceSelection: true,
        mode: 'local',
        triggerAction: 'all',
        emptyText:'请选择...',
        selectOnFocus:true,
        applyTo: 'local-states-with-qtip',
        listeners:{
        		'select' : function(box,record){
        			showCtyImg(record.data.img);
        		}
        }
    });
	
	var cd = new Ext.form.DateField({
		renderTo : 'closedDateDiv',
		format : 'Y-m-d',
		name : 'closedDate',
		value: $('hideClosedDate').value,
		id : 'closedDate'
	});
	
	var bthd = new Ext.form.DateField({
		renderTo : 'birthdayDiv',
		format : 'Y-m-d',
		name : 'birthday',
		value: $('hideBirthdayDiv').value,
		id : 'birthday'
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
	this.showCtyImg = function(path){
		document.getElementById('imgCountry').src = path;
		document.getElementById('imgCountry').style.display = '';
	};
//	this.hideCtyImg = function(){
//		document.getElementById('imgCountry').src = '';
//		document.getElementById('imgCountry').style.display = 'none';
//	};
	
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
	
	this.save = function(){
		if(_isNull($("hideHeadPic").value)){
			alert("请上传头像！");
			return false;
		}
		
		if(_isNull($("cname").value)){
			alert("请填写中文名！");
			$("cname").focus();
			return false;
		}
		if(_isNull($("ename").value)){
			alert("请填写英文名！");
			$("ename").focus();
			return false;
		}
		if(_isNull($("code").value)){
			alert("请填写学生证号！");
			$("code").focus();
			return false;
		}
		if(!regexVerify('intege1', $("code").value)){
			alert("学生证号请填写正整数！");
			$("code").focus();
			return false;
		}
		
		if(CountryBox.getValue()==''||CountryBox.getValue()==null||CountryBox.getValue() <= 0){
			alert("请选择国籍！");
			return false;
		}
		if(_isNull($("birthday").value)){
			alert("请填写出生年月！");
			$("birthday").focus();
			return false;
		}
		if(!isDate($("birthday").value)){
			alert("出生年月日期格式错误！");
			$("birthday").focus();
			return false;
		}
		if(_isNull($("passNumb").value)){
			alert("请填写护照ID！");
			$("passNumb").focus();
			return false;
		}
		if(!_isNull($("closedDate").value) && !isDate($("closedDate").value)){
			alert("结业日期格式错误！");
			$("closedDate").focus();
			return false;
		}
		
	};
	
	this.chooseImg = function(){
		pic.show();
	};
	
	new Ext.Viewport({
		layout : 'fit',
		items : [{
			title : '学生信息编辑',
			bodyStyle:'padding:5px', 
			border : false,
			frame : false,
			autoScroll : true,
			contentEl : 'div_panel_id'
		}]
	});
	
	var hideHeadPic = document.getElementById('hideHeadPic').value;
	if(hideHeadPic == '' || hideHeadPic == null){
		hideHeadImg();
	}else{
		showHeadImg(hideHeadPic);
	}
});
