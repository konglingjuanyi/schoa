Ext.onReady(function(){
	Ext.QuickTips.init();
	
	this.searchFunc=function(){
		gridStore.load();
	};
	
//	var fromStore = new Ext.data.ArrayStore({
//        data: [['1', 'One'], ['2', 'Two'], ['3', 'Three'], ['4', 'Four'], ['5', 'Five']],
//        fields: ['value','text']
//    });
	
	var fromStore = new Ext.data.JsonStore({
	    url : 'searchPrivilegesWithoutRoles.do',
	    root : 'data',
	    remoteSort: false, 
	    totalProperty:'total',
	    fields: [
	       {name:'id'},
	       {name:'name'}
        ]
    });
	
	var toStore = new Ext.data.JsonStore({
		url : 'searchRolePrivileges.do',
		root : 'data',
		remoteSort: false, 
		totalProperty:'total',
		fields: [
		         {name:'id'},
		         {name:'name'}
		       ]
	});
	
	
	var isForm = new Ext.form.FormPanel({
        items:[{
            xtype: 'itemselector',
            name:'itemselector',
            anchor : '100%',
            hideLabel : true,
            style : 'margin:20px;',
	        imagePath: 'ext-3.2.1/ux/images/',
            multiselects: [{
            	legend : "待选择",
                width: 200,
                height: 250,
                store: fromStore,
                displayField: 'name',
                valueField: 'id'
            },{
            		legend : "已选择",
                width: 200,
                height: 250,
                store: toStore,
                displayField: 'name',
                valueField: 'id'
            }]
        }],

        buttons: [{
            text: '保存',
            handler: function(){
            		var priIds = isForm.getForm().findField('itemselector').getValue();
            		Ext.Ajax.request( {
    					url : 'saveRolePrivileges.do?priIds='+priIds+'&role='+$('hidRoleId').value,
    					success : function(response){
    						var resp = Ext.util.JSON.decode(response.responseText);
    						if(resp.success){
    							alert("操作成功！");
    							window.hide();
    						}else{
    							alert('操作失败');
    						}
    					}
    				});
            }
        },{
            text: '取消',
            handler: function(){
            		window.hide();
            }
        }]
    });
	
	var window = new com.custom.Window({
		title : '选择权限',
		width : 480,
		height : 370,
		layout : 'fit',
		items : [isForm]
	});
	
	window.on('beforeshow',function(){
		fromStore.proxy=new Ext.data.HttpProxy({url: 'searchPrivilegesWithoutRoles.do?role=' + $('hidRoleId').value});
		toStore.proxy=new Ext.data.HttpProxy({url: 'searchRolePrivileges.do?role=' + $('hidRoleId').value});
		
		fromStore.reload();
		toStore.reload();
	});
	
	this.assignRolePrivileges = function(id){
		$('hidRoleId').value = id;
		window.show();
	};
	
	//列表数据
	var gridStore = new Ext.data.JsonStore({
	    url : 'searchRoles.do',
	    root : 'data',
	    remoteSort: false, 
	    totalProperty:'total',
	    fields: [
	       {name:'id'},
	       {name:'name'},
	       {name:'intro'}
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
				{width:1,header:'角色', align:'center',sortable:false, dataIndex:'name'},
				{width:3,header:'角色描述', align:'left',sortable:false, dataIndex:'intro'},
				{width:2,header:'操作', align:'center',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					var str = '<input type="button" value="分配权限" class="Mybotton" onclick="assignRolePrivileges('+val+')">';
					return str;
				}}
		]
	}); 
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
			title:'角色管理',
	        region : 'center',
			frame : false,
			border : true,
			autoScroll : true,
			items : [grid]
		}]
	});
	
	searchFunc();
});