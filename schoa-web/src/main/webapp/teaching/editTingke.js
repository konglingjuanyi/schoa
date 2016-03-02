Ext.onReady(function(){
	Ext.QuickTips.init();
	
	this.chooseClasses = function(callback){
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
				chooseKecheng();
				callback();
			}
		});
	};
	
	this.chooseKecheng = function(callback){
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
				callback();
			}
		});
	};
	
	this.save = function(){
		if($("xueqiId").value == 0){
			alert("请选择学期！");
			return false;
		}
		if($("classesId").value == 0){
			alert("请选择班级！");
			return false;
		}
		if($("kechengId").value == 0){
			alert("请选择课程！");
			return false;
		}
		if($("duxieTeacherId").value == 0){
			alert("请选择督写教师！");
			return false;
		}
		if(!regexVerify('tingke', $("score").value) || $("score").value < 0 || $("score").value > 10){
			alert("得分格式错误，只能输入0-10之间的数字，如果是小数请保留两位小数点！");
			return false;
		}
		
		if($("tingkeTime").value == '' || $("tingkeTime").value == null){
			alert("请填写听课时间！");
			return false;
		}
		
		if(!regexVerify('dateTime', $("tingkeTime").value)){
			alert("听课时间格式错误！");
			return false;
		}
	};
	
	function init(){
		chooseClasses(function(){
			$("classesId").value = $("hideBanji").value;
			chooseKecheng(function(){
				$("kechengId").value = $("hideKecheng").value;
			});
		});
		
	}
	
	new Ext.Viewport({
		layout : 'fit',
		items : [{
			title : '听课情况编辑',
			bodyStyle:'padding:5px', 
			border : false,
			frame : false,
			autoScroll : true,
			contentEl : 'div_panel_id'
		}]
	});
	
	if($("hideId").value > 0){
		init();
	}
});
