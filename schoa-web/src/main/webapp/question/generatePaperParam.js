Ext.onReady(function(){
	var st =  new Ext.form.DateField({ 
		renderTo : 'startDateDiv',
		format : 'Y-m-d',
		editable:false,
		name : 'startDay',
		id : 'startDay'  
    });
	
	var ed = new Ext.form.DateField({
		renderTo : 'endDateDiv',
		format : 'Y-m-d',
		editable:false,
		name : 'endDay',
		id : 'endDay'
	});
	
	this.chooseLevel = function(){
		var standard = $("standardId");
		var level = $("levelId");
		
		_cleanSelect(level);
		level.options.add(new Option("请选择...",0))
		Ext.Ajax.request( {
			url : 'getLevelByStandardId.do?standardId='+standard.value,
			success : function(response){
				var resp = Ext.util.JSON.decode(response.responseText);
				if(resp == null){
					return;
				}
				for(var i=0;i<resp.length;i++){
					var ent = resp[i];
					level.options.add(new Option(ent.name,ent.id));
				}
			}
		});
	};
	
	this.chooseKewen = function(){
		var str = "<ul>";
		str += '<li>';
		str +=  '<input type="checkbox" id="kw_all" onchange="selectAll(this,\'kewen\')">';
		str += 	'<label for="kw_all" style="color: blue"><b>全选</b></label>';
		str += '</li>';
		
		Ext.Ajax.request( {
			url : 'getMKechengByMaterialId.do?materialId='+$("materId").value,
			success : function(response){
				var resp = Ext.util.JSON.decode(response.responseText);
				if(resp == null){
					return;
				}
				for(var i=0;i<resp.length;i++){
					var ent = resp[i];
					str += '<li><input type="checkbox" name="kewen" value="' + ent.id + '" id="kewen_' + ent.id + '">'
					+ '<label for="kewen_'+ent.id+'">' + ent.name + '</label>'
					+ '</li>';
				}
				str += '</ul>';
				document.getElementById("kewenId").innerHTML = str;
			}
		});
	};
	
	this.save = function(){
		//题型
		var tixings = _getSelectValues("tixing");
		if(tixings.length <= 0){
			alert("请选择题型！");
			return false;
		}
		document.getElementById("tixings").value = tixings;
		
		//知识点
		var kpoints = _getSelectValues("kpoint");
		document.getElementById("kpoints").value = kpoints;
		
		//词汇级别
//		var standardId = document.getElementById("standardId").value;
//		var levelId = document.getElementById("levelId").value;
//		if(standardId <= 0 && levelId <= 0){
//			alert("请选择词汇级别！");
//			return false;
//		};

		//课文
		if(document.getElementById("kewenId")){
			var kewens = _getSelectValues("kewen");
			document.getElementById("kewens").value = kewens;
		}
		
	};
	
	new Ext.Viewport({
		layout : 'fit',
		items : [{
			title : '根据词汇生成试卷',
			bodyStyle:'padding:5px', 
			border : false,
			frame : false,
			autoScroll : true,
			contentEl : 'div_panel_id'
		}]
	});
	
});
