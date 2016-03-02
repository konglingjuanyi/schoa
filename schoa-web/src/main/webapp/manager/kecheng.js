Ext.onReady(function(){
	Ext.QuickTips.init();
	
	var jiaoxieWindow = new WindowJiaoxueFile();
	
	var upFile = new FileUpLoadWindow(function(fp, response){
		if(response.result.success){
			alert("操作成功");
			jiaoxieWindow.selectStore.reload();
			upFile.hide();
		}else{
			alert(response.result.msg);
		}
	});
	
	upFile.on('beforehide',function(){
		upFile.jiaoxueFileId = 0;
	});
	
	this.chooseFile = function(id){
		upFile.show();
		upFile.jiaoxueFileId = id;
	};
	
	this.clearFile = function(id){
		if(confirm("确定要删除该资料吗？删除将不能恢复！")){
			Ext.Ajax.request( {
				url : 'clearFile.do?id='+id,
				success : function(response){
					var resp = Ext.util.JSON.decode(response.responseText);
					if(resp.success){
						alert("操作成功");
						jiaoxieWindow.selectStore.reload();
					}else{
						alert("操作失败");
					}
				}
			});
		}
	};
	
	//下载资料
	this.downloadFile = function(id){
		window.open("downloadFile.do?id="+id,"downloadFile","");
	};
	
	
	this.searchFunc=function(){
		gridStore.setBaseParam("xueqi", $("xueqi").value);
		gridStore.setBaseParam("teacher", $("teacher").value);
		gridStore.setBaseParam("name", $("name").value);
		gridStore.load();
	};
	
	this.updateF=function(id){
		location.href = "initEditKecheng.do?id="+id;
	};
	
	//教学文件
	this.libraryInfo=function(id){
		jiaoxieWindow.show();
		jiaoxieWindow.search(id);
	};
	
//	this.deleteF = function(id){
//		if(confirm("确定要删除该信息吗？删除将不能恢复！")){
//			Ext.Ajax.request( {
//				url : 'delTeacher.do?id='+id,
//				success : function(response){
//					var resp = Ext.util.JSON.decode(response.responseText);
//					if(resp.success){
//						alert("操作成功");
//						gridStore.reload();
//					}else{
//						alert("操作失败");
//					}
//					win.hide();
//				}
//			});
//		}
//	};
	
	//列表数据
	var gridStore = new Ext.data.JsonStore({
	    url : 'searchKechengs.do',
	    root : 'data',
	    remoteSort: false, 
	    totalProperty:'total',
	    fields: [
	       {name:'id'},
	       {name:'name'},
	       {name:'jiaocai'},
	       {name:'teacher'},
	       {name:'xueqi'},
	       {name:'teacherId'},
	       {name:'xueqiId'},
	       {name:'keshi'},
	       {name:'intro'}
	      
        ],
        baseParams : {
        		limit : PAGESIZE,
        		xueqi :'',
        		teacher :'',
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
				{width:1,header:'课程', align:'left',sortable:false, dataIndex:'name'},
				{width:1,header:'任课教师', align:'left',sortable:false, dataIndex:'teacher',renderer:function(val){
					return val.name;
				}},
				{width:1,header:'学期', align:'left',sortable:false, dataIndex:'xueqi',renderer:function(val){
					return val.name;
				}},
				{width:1,header:'周课时', align:'left',sortable:false, dataIndex:'keshi',renderer:function(val){
					return val==0||val=="0"?'':val;
				}},
				{width:2,header:'教材', align:'left',sortable:false, dataIndex:'jiaocai'},
				{width:1,header:'课程描述', align:'left',sortable:false, dataIndex:'intro'},
				{width:2,header:'操作', align:'center',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					return '<input type="button" value="修改" class="Mybotton" onclick="updateF('+val+')">' 
					+ '<input type="button" value="教学文件" class="Mybotton" onclick="libraryInfo('+val+')">';
				}}
		]
	}); 
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
			region : 'north',
			title :  "课程信息",
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
							location.href = "initEditKecheng.do";
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