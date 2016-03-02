Ext.onReady(function(){
	Ext.QuickTips.init();
	
	var _standardId = document.getElementById("hideId").value;
	
	this.modifyWordsLevel = function(id){
		location.href = "initWordsLevelEdit.do?id="+id+'&standardId=' + _standardId;
	};
	
	this.deleteWordsLevel = function(id){
		if (confirm("确认要执行删除操作吗？")) {
			var url = "deleteWordsLevel.do?id="+id;
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
	    url : 'searchQuestionWordsLevel.do?standardId=' + _standardId,
	    root : 'data',
	    remoteSort: false, 
	    totalProperty:'total',
	    fields: [
	       {name:'id'},
	       {name:'name'},
	       {name:'content'},
	       {name:'levelSort'},
	       {name:'percent'},
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
				{width:1,header:'级别名称', align:'left',sortable:false, dataIndex:'name'},
				{width:1,header:'级别说明', align:'left',sortable:false, dataIndex:'directions'},
				{width:1,header:'级别排序', align:'right',sortable:false, dataIndex:'levelSort'},
				{width:1,header:'匹配百分比', align:'right',sortable:false, dataIndex:'percent'},
				{width:1,header:'操作', align:'left',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					var str = '';
					str += '<input type="button" value="修改" class="Mybotton" onclick="modifyWordsLevel('+val+')">';
					str += '<input type="button" value="删除" class="Mybotton" onclick="deleteWordsLevel('+val+')">';
					return str;
				}}
		]
	}); 
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
	        region : 'center',
	        title :  "词汇标准\"" + document.getElementById("hideName").value + "\"下的词汇级别",
			frame : false,
			border : true,
			autoScroll : true,
			items : [grid],
			tbar : [{
						text : '新增',
						handler : function(b,e){
							location.href = "initWordsLevelEdit.do?standardId=" + _standardId;
						}
					}]
		}]
	});
	
	gridStore.load();
});