Ext.onReady(function(){
	Ext.QuickTips.init();
	
	this.searchFunc=function(){
		gridStore.setBaseParam("keyword", $("keyword").value);
		gridStore.setBaseParam("tixingId", $("tixingId").value);
		gridStore.setBaseParam("user", $("user").value);
		gridStore.setBaseParam("kpointId", $("kpointId").value);
		gridStore.load();
	};
	
	this.modifyBank=function(id){
		location.href = "initBankEdit.do?id="+id;
	};
	
	this.deleteBank=function(id){
		if (confirm("确认要执行删除操作吗？")) {
			var url = "deleteBank.do?id="+id;
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
	    url : 'searchQuestionBank.do',
	    root : 'data',
	    remoteSort: false, 
	    totalProperty:'total',
	    fields: [
	       {name:'id'},
	       {name:'tixingId'},
	       {name:'tixingStr'},
	       {name:'member'},
	       {name:'answer'},
	       {name:'usedTimes'},
	       {name:'content'}
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
				{width:1,header:'题型', align:'left',sortable:false, dataIndex:'tixingStr'},
				{width:3,header:'试题内容', align:'left',sortable:false, dataIndex:'content',renderer:function(val,cell,record){
					var str = '<span title="'+val+'">'+val+'</span>';
					return str;
				}},
				{width:2,header:'试题答案', align:'left',sortable:false, dataIndex:'answer',renderer:function(val,cell,record){
					var str = '<span title="'+val+'">'+val+'</span>';
					return str;
				}},
				{width:0.5,header:'出题人', align:'left',sortable:false, dataIndex:'member'},
				{width:0.7,header:'被使用次数', align:'right',sortable:false, dataIndex:'usedTimes'},
				{width:1,header:'操作', align:'left',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					var str = '';
					str += '<input type="button" value="修改" class="Mybotton" onclick="modifyBank('+val+')">';
					str += '<input type="button" value="删除" class="Mybotton" onclick="deleteBank('+val+')">';
					return str;
				}}
		]
	}); 
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
			region : 'north',
			title :  "试题库",
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
						text : '添加试题',
						handler : function(b,e){
							location.href = "initBankEdit.do";
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