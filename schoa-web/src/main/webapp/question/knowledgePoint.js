Ext.onReady(function(){
	Ext.QuickTips.init();
	
	this.searchFunc=function(){
		gridStore.setBaseParam("name", $("name").value);
		gridStore.load();
	};
	
	this.modifyKPoint=function(id){
		location.href = "initKnowledgePointEdit.do?id="+id;
	};
	
	this.deleteKPoint=function(id){
		if (confirm("确认要执行删除操作吗？")) {
			var url = "deleteKnowledgePoint.do?id="+id;
			Ext.Ajax.request( {
				url : url,
				success : function(response){
					var resp = Ext.util.JSON.decode(response.responseText);
					if(resp.success){
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
	    url : 'searchQuestionKnowledgePoint.do',
	    root : 'data',
	    remoteSort: false, 
	    totalProperty:'total',
	    fields: [
	       {name:'id'},
	       {name:'name'},
	       {name:'content'}
        ],
        baseParams : {
        		limit : PAGESIZE,
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
				{width:0.5,header:'ID', align:'center',sortable:false, dataIndex:'id'},
				{width:2,header:'知识点名称', align:'left',sortable:false, dataIndex:'name'},
				{width:2,header:'知识点内容', align:'left',sortable:false, dataIndex:'content'},
				{width:1,header:'操作', align:'left',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					var str = '';
					str += '<input type="button" value="修改" class="Mybotton" onclick="modifyKPoint('+val+')">';
					str += '<input type="button" value="删除" class="Mybotton" onclick="deleteKPoint('+val+')">';
					return str;
				}}
		]
	}); 
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
			region : 'north',
			title :  "知识点",
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
							location.href = "initKnowledgePointEdit.do";
						}
					},'->',
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