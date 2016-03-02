Ext.onReady(function(){
	Ext.QuickTips.init();
	
	this.searchFunc=function(){
		gridStore.setBaseParam("name", $("name").value);
		gridStore.load();
	};
	
	this.updateF=function(id){
		location.href = "initEditXueqi.do?id="+id;
	};
	
	//列表数据
	var gridStore = new Ext.data.JsonStore({
	    url : 'searchXueqi.do',
	    root : 'data',
	    remoteSort: false, 
	    totalProperty:'total',
	    fields: [
	       {name:'id'},
	       {name:'name'},
	       {name:'startDateStr'},
	       {name:'endDateStr'},
	       {name:'shuxing'},
	       {name:'startDate'},
	       {name:'endDate'}
        ],
        baseParams : {
	    		name :''
		}
    });
	
	var grid = new com.custom.GridPanel({
		store : gridStore,
		region : 'center',
		frame : false,
		border : false,
		autoHeight:true,
		columns: [ 
				{width:1,header:'ID', align:'center',sortable:false, dataIndex:'id'},
				{width:1,header:'学期名称', align:'left',sortable:false, dataIndex:'name'},
				{width:1,header:'开始日期', align:'left',sortable:false, dataIndex:'startDateStr'},
				{width:1,header:'结束日期', align:'left',sortable:false, dataIndex:'endDateStr'},
				{width:1,header:'属性', align:'left',sortable:false, dataIndex:'shuxing',renderer:function(val,cell,record){
					return val==1?"短期":"长期"; 
				}},
				{width:1,header:'操作', align:'center',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					return '<input type="button" value="修改" class="Mybotton" onclick="updateF('+val+')">' ; 
				}}
		]
	}); 
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
			region : 'north',
			title :  "学期管理",
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
			tbar : [{
						text : '新增',
						handler : function(b,e){
							location.href = "initEditXueqi.do";
						}
					}]
		}]
	});
	
	searchFunc();
});