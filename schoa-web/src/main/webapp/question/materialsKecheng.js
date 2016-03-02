Ext.onReady(function(){
	Ext.QuickTips.init();
	
	var _materialsId = document.getElementById("hideId").value;
	
	this.modifyKecheng = function(id){
		location.href = "initMaterialsKechengEdit.do?id="+id+'&materialsId=' + _materialsId;
	};
	
	this.deleteKecheng = function(id){
		if (confirm("确认要执行删除操作吗？")) {
			var url = "deleteMaterialKecheng.do?id="+id;
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
	    url : 'searchQuestionMaterialsKecheng.do?materialsId=' + _materialsId,
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
				{width:2,header:'课文名称', align:'left',sortable:false, dataIndex:'name'},
				{width:2,header:'课文说明', align:'left',sortable:false, dataIndex:'directions'},
				{width:1,header:'操作', align:'left',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					var str = '';
					str += '<input type="button" value="修改" class="Mybotton" onclick="modifyKecheng('+val+')">';
					str += '<input type="button" value="删除" class="Mybotton" onclick="deleteKecheng('+val+')">';
					return str;
				}}
		]
	}); 
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
	        region : 'center',
	        title :  "教材\"" + document.getElementById("hideName").value + "\"下的课文",
			frame : false,
			border : true,
			autoScroll : true,
			items : [grid],
			tbar : [{
						text : '新增',
						handler : function(b,e){
							location.href = "initMaterialsKechengEdit.do?materialsId=" + _materialsId;
						}
					}]
		}]
	});
	
	gridStore.load();
});