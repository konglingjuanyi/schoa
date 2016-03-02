Ext.onReady(function(){
	Ext.QuickTips.init();
	
	//是否是管理员
	var isadmin = document.getElementById("isadmin").value;
	
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
		gridStore.setBaseParam("xueqiId", $("xueqiId").value);
		gridStore.setBaseParam("classesId", $("classesId").value);
		gridStore.setBaseParam("kechengId", $("kechengId").value);
		gridStore.setBaseParam("teacherId", $("teacherId").value);
		gridStore.load();
	};
	
	
	
	//修改
	this.modifyTingke=function(id){
		location.href = "initEditTingke.do?id="+id;
	};
	
	//删除
	this.deleteTingke=function(id){
		if(confirm("确定要删除该听课记录吗？删除后将不能恢复！")){
			Ext.Ajax.request( {
				url : 'deleteTingke.do?id='+id,
				success : function(response){
					var resp = Ext.util.JSON.decode(response.responseText);
					if(resp.success){
						alert("操作成功");
						gridStore.reload();
					}else{
						alert("操作失败");
					}
				}
			});
		}
	};
	
	//列表数据
	var gridStore = new Ext.data.JsonStore({
	    url : 'searchTingke.do',
	    root : 'data',
	    remoteSort: false, 
	    totalProperty:'total',
	    fields: [
	       {name:'id'},
	       {name:'xueqiId'},
	       {name:'banjiId'},
	       {name:'kechengId'},
	       {name:'teacherId'},
	       {name:'teacherName'},
	       {name:'duxieTeacherId'},
	       {name:'duxieTeacherName'},
	       {name:'tingkeTime'},
	       {name:'score'},
	       {name:'teacher'},
	       {name:'banji'},
	       {name:'xueqi'},
	       {name:'remark'},
	       {name:'kecheng'}
        ],
        baseParams : {
        		limit : PAGESIZE
		}
    });
	
	var grid = new com.custom.GridPanel({
		store : gridStore,
		region : 'center',
		frame : false,
		border : false,
		autoHeight:true,
		columns: [ 
				{width:0.5,header:'ID', align:'center',sortable:false, dataIndex:'id'},
				{width:1,header:'学期', align:'center',sortable:false, dataIndex:'xueqi',renderer:function(val,cell,record){
					return val.name;
				}},
				{width:2,header:'被检查课程', align:'center',sortable:false, dataIndex:'kecheng',renderer:function(val,cell,record){
					return val.name + "("+record.data.teacherName+")";
				}},
				{width:1,header:'督写教师', align:'center',sortable:false, dataIndex:'duxieTeacherName',renderer:function(val,cell,record){
					return val;
				}},
				{width:1.5,header:'听课时间', align:'center',sortable:false, dataIndex:'tingkeTime',renderer:function(val,cell,record){
					return val;
				}},
				{width:0.5,header:'得分', align:'right',sortable:false, dataIndex:'score'},
				{width:3,header:'备注', align:'left',sortable:false, dataIndex:'remark',renderer:function(val){
					return '<span title="'+val+'">'+val+'</span>';
				}},
				{width:1,header:'操作', align:'center',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					var str = '';
					if(isadmin=='true' || isadmin==true){
						str += '<input type="button" value="修改" class="Mybotton" onclick="modifyTingke('+val+')">';
						str += '<input type="button" value="删除" class="Mybotton" onclick="deleteTingke('+val+')">';
					}
					return str;
				}}
		]
	}); 
	
	var addbar = '';
	if(isadmin=='true' || isadmin==true){
		addbar = {
				text : '新增听课',
				handler : function(b,e){
					location.href = "initEditTingke.do";
				}
			};
	}
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
			region : 'north',
			title:'听课情况',
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
			items : [grid],
			tbar : [addbar,'->',
					new Ext.PagingToolbar({
			            pageSize: PAGESIZE,
			            store: gridStore,
			            style : {'border' : 0},
			            displayInfo: true
			        })]
		}]
	});
	
	searchFunc();
});