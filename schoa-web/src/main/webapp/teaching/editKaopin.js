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
			title : '教学考评信息编辑',
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
