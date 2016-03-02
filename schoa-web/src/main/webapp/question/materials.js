Ext.onReady(function(){
	Ext.QuickTips.init();
	
	this.modifyMaterials = function(id){
		location.href = "initMaterialsEdit.do?id="+id;
	};
	
	this.toMaterialsKecheng = function(id){
		location.href = "initQuestionMaterialsKecheng.do?materialsId="+id;
	};
	
	this.deleteMaterials = function(id){
		if (confirm("删除该教材，同时也会删除该教材下的所有课文，确认要执行删除操作吗？")) {
			var url = "deleteMaterials.do?id="+id;
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
	    url : 'searchQuestionMaterials.do',
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
				{width:2,header:'教材名称', align:'left',sortable:false, dataIndex:'name'},
				{width:2,header:'教材说明', align:'left',sortable:false, dataIndex:'directions'},
				{width:1,header:'操作', align:'left',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					var str = '';
					str += '<input type="button" value="修改" class="Mybotton" onclick="modifyMaterials('+val+')">';
					str += '<input type="button" value="教材下课文" class="Mybotton" onclick="toMaterialsKecheng('+val+')">';
					str += '<input type="button" value="删除" class="Mybotton" onclick="deleteMaterials('+val+')">';
					return str;
				}}
		]
	}); 
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
	        region : 'center',
	        title :  "教材课文",
			frame : false,
			border : true,
			autoScroll : true,
			items : [grid],
			tbar : [{
						text : '新增',
						handler : function(b,e){
							location.href = "initMaterialsEdit.do";
						}
					}]
		}]
	});
	
	gridStore.load();
});