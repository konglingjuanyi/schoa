Ext.onReady(function(){
	Ext.QuickTips.init();
	
	this.modifyWordsStandard = function(id){
		location.href = "initWordsStandardEdit.do?id="+id;
	};
	this.viewWordsStandard = function(id){
		window.open("initViewWordsStandard.do?id="+id,'viewWS');
	};
	
	this.toQuestionWordsLevel = function(id){
		location.href = "initQuestionWordsLevel.do?standardId="+id;
	};
	
	this.deleteWordsStandard = function(id){
		if (confirm("删除该标准，同时也会删除该标准下的所有级别数据，确认要执行删除操作吗？")) {
			var url = "deleteWordsStandard.do?id="+id;
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
	
	var gridStore = new Ext.data.JsonStore({
	    url : 'searchQuestionWordsStandard.do',
	    root : 'data',
	    remoteSort: false, 
	    totalProperty:'total',
	    fields: [
	       {name:'id'},
	       {name:'name'},
	       {name:'directions'}
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
				{width:1,header:'标准名称', align:'left',sortable:false, dataIndex:'name'},
				{width:1,header:'标准说明', align:'left',sortable:false, dataIndex:'directions'},
				{width:1,header:'操作', align:'left',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					var str = '';
					str += '<input type="button" value="修改" class="Mybotton" onclick="modifyWordsStandard('+val+')">';
					str += '<input type="button" value="查看" class="Mybotton" onclick="viewWordsStandard('+val+')">';
					str += '<input type="button" value="词汇级别" class="Mybotton" onclick="toQuestionWordsLevel('+val+')">';
					str += '<input type="button" value="删除" class="Mybotton" onclick="deleteWordsStandard('+val+')">';
					return str;
				}}
		]
	}); 
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
	        region : 'center',
	        title :  "词汇标准",
			frame : false,
			border : true,
			autoScroll : true,
			items : [grid],
			tbar : [{
						text : '新增',
						handler : function(b,e){
							location.href = "initWordsStandardEdit.do";
						}
					},'-',{
						text : '更新题库的词汇级别',
						handler : function(b,e){
							location.href = "initUpdateWordsStandardLevel.do";
						}
					}]
		}]
	});
	
	gridStore.load();
});