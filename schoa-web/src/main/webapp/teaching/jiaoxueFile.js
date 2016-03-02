Ext.onReady(function(){
	Ext.QuickTips.init();
	
	var upFile = new FileUpLoadWindow(function(fp, response){
		if(response.result.success){
			alert("操作成功");
			gridStore.reload();
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
	
	
	this.chooseKecheng = function(){
		var xueqiId = $("xueqi").value;
		var kecheng = $("kecheng");
		_cleanSelect(kecheng);
		kecheng.options.add(new Option("请选择...",0))
		Ext.Ajax.request( {
			url : 'getKechengByXueqiId.do?pri=1&xueqiId='+xueqiId,
			success : function(response){
				var resp = Ext.util.JSON.decode(response.responseText);
				if(resp == null){
					return;
				}
				for(var i=0;i<resp.length;i++){
					var ent = resp[i];
					kecheng.options.add(new Option(ent.name,ent.id));
				}
			}
		});
	};
	
	this.searchFunc=function(){
		gridStore.setBaseParam("xueqi", $("xueqi").value);
		gridStore.setBaseParam("kecheng", $("kecheng").value);
		gridStore.load();
	};
	
	//下载资料
	this.downloadFile = function(id){
		window.open("downloadFile.do?id="+id,"downloadFile","");
	};
	
	this.clearFile = function(id){
		if(confirm("确定要删除该资料吗？删除将不能恢复！")){
			Ext.Ajax.request( {
				url : 'clearFile.do?id='+id,
				success : function(response){
					var resp = Ext.util.JSON.decode(response.responseText);
					if(resp.success){
						alert("操作成功");
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
	    url : 'searchJiaoxueFile.do',
	    root : 'data',
	    remoteSort: false, 
	    totalProperty:'total',
	    fields: [
	       {name:'kecheng'},
	       {name:'jiaoxueFileScore'},
	       {name:'teacher'},
	       {name:'xueqi'},
	       {name:'id'},
	       {name:'name'},
	       {name:'saveName'},
	       {name:'kechengId'},
	       {name:'intro'},
	       {name:'fileSize'},
	       {name:'memberName'},
	       {name:'quanxian'},
	       {name:'uptime'}
	      
        ],
        baseParams : {
        		limit : PAGESIZE,
        		xueqi :'',
        		kecheng :''
		}
    });
	
	var grid = new com.custom.GridPanel({
		store : gridStore,
		region : 'center',
		frame : false,
		border : false,
		autoHeight:true,
		columns: [ 
				{width:0.7,header:'ID', align:'center',sortable:false, dataIndex:'id'},
				{width:1,header:'学期', align:'left',sortable:false, dataIndex:'xueqi',renderer:function(val){
					return val.name;
				}},
				{width:1.8,header:'课程', align:'left',sortable:false, dataIndex:'kecheng',renderer:function(val,cell,record){
					return val.name + '(' + record.data.teacher.name + ')';
				}},
				{width:2.3,header:'教学文件', align:'left',sortable:false, dataIndex:'jiaoxueFileScore',renderer:function(val,cell,record){
					return val.name + '(' + val.score +"分)"
				}},
				{width:2,header:'文件名', align:'left',sortable:false, dataIndex:'name'},
				{width:1.3,header:'上传信息', align:'left',sortable:false, dataIndex:'uptime',renderer:function(val,cell,record){
					return record.data.memberName + '<br/>' + Ext.util.Format.date(val,'Y-m-d H:i:s');
				}},
				{width:2,header:'操作', align:'left',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					var str = '';
					if(record.data.quanxian || record.data.quanxian=='true'){
						str += '<input type="button" value="上传" class="Mybotton" onclick="chooseFile('+val+')">' ;
						if(!_isNull(record.data.name)){
							str += '<input type="button" value="下载" class="Mybotton" onclick="downloadFile('+val+')">' ;
							str += '<input type="button" value="清除文件" class="Mybotton" onclick="clearFile('+val+')">' ;
						}
					}
					return str;
				}}
		]
	}); 
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
			region : 'north',
			title :  "教学文件",
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
			tbar : ['->',new Ext.PagingToolbar({
			            pageSize: PAGESIZE,
			            store: gridStore,
			            style : {'border' : 0},
			            displayInfo: true
			        })]
		}]
	});
	
	searchFunc();
});