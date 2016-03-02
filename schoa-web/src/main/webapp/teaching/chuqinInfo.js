Ext.onReady(function(){
	Ext.QuickTips.init();
	
	this.chooseClasses = function(){
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
			}
		});
	};
	
	this.chooseKecheng = function(){
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
			}
		});
	};
	
	this.searchFunc=function(){
		gridStore.setBaseParam("classesId", $("classesId").value);
		gridStore.setBaseParam("kechengId", $("kechengId").value);
		gridStore.load();
	};
		
	//修改考评
	this.modifyKaopin=function(id){
		location.href = "initEditKaopin.do?id="+id;
	};
	
	//列表数据
	var gridStore = new Ext.data.JsonStore({
	    url : 'searchChuqinInfo.do',
	    root : 'data',
	    remoteSort: false, 
	    totalProperty:'total',
	    fields: [
	       {name:'id'},
	       {name:'classesKecheng'},
	       {name:'dayAndTime'},
	       {name:'banjiName'},
	       {name:'kaoqin'},
	       {name:'kaoqinInfo'},
	       {name:'kaoqinRemark'},
	       {name:'day'}
        ]
    });
	
	var grid = new com.custom.GridPanel({
		store : gridStore,
		region : 'center',
		frame : false,
		border : false,
		autoHeight:true,
		columns: [ 
				{width:1,header:'ID', align:'center',sortable:false, dataIndex:'id'},
				{width:1,header:'班级', align:'center',sortable:false, dataIndex:'banjiName'},
				{width:1,header:'课程', align:'center',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					return record.data.classesKecheng.kechengName;
				}},
				{width:1,header:'教师', align:'center',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					return record.data.classesKecheng.teacherName;
				}},
				{width:1,header:'时间', align:'center',sortable:false, dataIndex:'dayAndTime'},
				{width:1,header:'出勤', align:'center',sortable:false, dataIndex:'kaoqinInfo'},
				{width:1,header:'备注', align:'center',sortable:false, dataIndex:'kaoqinRemark'}
		]
	}); 
	
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
			region : 'north',
			title:'考勤查询',
			border : false,
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
			border : true,
			autoScroll : true,
			items : [grid]
		}]
	});
	
	searchFunc();
});