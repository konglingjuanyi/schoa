Ext.onReady(function(){
	Ext.QuickTips.init();
	
	this.modifyTixing = function(id){
		location.href = "initTixingEdit.do?id="+id;
	};
	
	var gridStore = new Ext.data.JsonStore({
	    url : 'searchQuestionTixing.do',
	    root : 'data',
	    remoteSort: false, 
	    totalProperty:'total',
	    fields: [
	       {name:'id'},
	       {name:'title'},
	       {name:'standardInfo'},
	       {name:'amount'},
	       {name:'sort'},
	       {name:'subtitle'}
        ]
    });
	
	var grid = new com.custom.GridPanel({
		store : gridStore,
		region : 'center',
		frame : false,
		border : false,
		autoHeight:true,
		columns: [ 
				{width:0.5,header:'ID', align:'center',sortable:false, dataIndex:'id'},
				{width:1,header:'标题', align:'left',sortable:false, dataIndex:'title'},
				{width:1,header:'副标题', align:'left',sortable:false, dataIndex:'subtitle'},
				{width:0.5,header:'默认试题数', align:'right',sortable:false, dataIndex:'amount'},
				{width:0.5,header:'试卷中排序', align:'right',sortable:false, dataIndex:'sort'},
				{width:1,header:'评分标准', align:'left',sortable:false, dataIndex:'standardInfo',renderer:function(val,cell,record){
					return "<span title='"+val+"'>"+val+"</span>";
				}},
				{width:0.5,header:'操作', align:'left',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					var str = '';
					str += '<input type="button" value="修改" class="Mybotton" onclick="modifyTixing('+val+')">';
					return str;
				}}
		]
	}); 
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
	        region : 'center',
	        title :  "题型管理",
			frame : false,
			border : true,
			autoScroll : true,
			items : [grid],
			tbar : [{
						text : '新增',
						handler : function(b,e){
							location.href = "initTixingEdit.do";
						}
					}]
		}]
	});
	
	gridStore.load();
});