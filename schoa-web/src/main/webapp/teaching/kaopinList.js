Ext.onReady(function(){
	Ext.QuickTips.init();
	
	var isadmin = document.getElementById("isadmin").value;
	
	var kaopinId = document.getElementById("hide_kaopinId").value;
	var kaopinTeacherName = document.getElementById("hide_kaopinTeacherName").value;
	var kaopinName = document.getElementById("hide_kaopinName").value;
	
	//修改
	this.modifyItem=function(id){
		location.href = "initKaopinItem.do?kaopinId="+kaopinId+"&itemId="+id;
	};
	
	//删除
	this.deleteItem=function(id){
		if(confirm("确定要删除该考评成绩吗？删除将不能恢复！")){
			Ext.Ajax.request( {
				url : 'deleteKaopinItem.do?id='+id,
				success : function(response){
					var resp = Ext.util.JSON.decode(response.responseText);
					if(resp.success){
						alert("操作成功");
						location.href = location.href;
					}else{
						alert("操作失败");
					}
				}
			});
		}
	};
	
	
	//列表数据
	var gridStore = new Ext.data.JsonStore({
	    url : 'searchKaopinPingfenList.do?kaopinId='+kaopinId,
	    root : 'data',
	    remoteSort: false, 
	    totalProperty:'total',
	    fields: [
	       {name:'id'},
	       {name:'updateTime'},
	       {name:'sumScore'},
	       {name:'manName'}
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
				{width:1,header:'考评名称', align:'center',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					return kaopinName;
				}},
				{width:1,header:'考评教师', align:'center',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					return kaopinTeacherName;
				}},
				{width:1,header:'总分数', align:'center',sortable:false, dataIndex:'sumScore',renderer:function(val,cell,record){
					return val;
				}},
				{width:1,header:'操作人', align:'center',sortable:false, dataIndex:'manName',renderer:function(val,cell,record){
					return val;
				}},
				{width:3,header:'操作', align:'center',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					var str = '';
					if(isadmin=='true' || isadmin==true){
						str += '<input type="button" value="修改" class="Mybotton" onclick="modifyItem('+val+')">';
						str += '<input type="button" value="删除" class="Mybotton" onclick="deleteItem('+val+')">';
					}else{
						str += '<input type="button" value="查看" class="Mybotton" onclick="modifyItem('+val+')">';
					}
					return str;
				}}
		]
	}); 
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
			region : 'north',
			border : false,
			height : 80,
			contentEl : 'search_div_id'
		},{
	        region : 'center',
			frame : false,
			border : true,
			autoScroll : true,
			items : [grid]
		}]
	});
	
	gridStore.load();
});

//打印教师考评结果表
function printTeacherKaopin(kaopinId){
	window.open('initPrintTeacherKaopin.do?kaopinId=' + kaopinId);
};