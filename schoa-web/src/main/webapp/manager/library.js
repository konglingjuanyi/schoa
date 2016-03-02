Ext.onReady(function(){
	Ext.QuickTips.init();
	
	this.chooseKecheng = function(callback){
		var xueqiId = $("xueqi").value;
		var kecheng = $("kecheng");
		_cleanSelect(kecheng);
		kecheng.options.add(new Option("请选择...",0))
		Ext.Ajax.request( {
			url : 'getKechengByXueqiId.do?xueqiId='+xueqiId,
			success : function(response){
				var resp = Ext.util.JSON.decode(response.responseText);
				if(resp == null){
					return;
				}
				for(var i=0;i<resp.length;i++){
					var ent = resp[i];
					kecheng.options.add(new Option(ent.name,ent.id));
				}
				callback();
			}
		});
	};
	
	this.searchFunc=function(){
		gridStore.setBaseParam("xueqi", $("xueqi").value);
		gridStore.setBaseParam("kecheng", $("kecheng").value);
		gridStore.setBaseParam("keyword", $("keyword").value);
		gridStore.load();
	};
	
	//下载资料
	this.downloadFile = function(id){
		window.open("downloadFile.do?id="+id,"downloadFile","");
	};
	
	this.deleteF = function(id){
		if(confirm("确定要删除该资料吗？删除将不能恢复！")){
			Ext.Ajax.request( {
				url : 'delFile.do?id='+id,
				success : function(response){
					var resp = Ext.util.JSON.decode(response.responseText);
					if(resp.success){
						alert("操作成功");
						gridStore.reload();
					}else{
						alert("操作失败");
					}
					win.hide();
				}
			});
		}
	};
	
	//列表数据
	var gridStore = new Ext.data.JsonStore({
	    url : 'searchLibrarys.do',
	    root : 'data',
	    remoteSort: false, 
	    totalProperty:'total',
	    fields: [
	       {name:'kecheng'},
	       {name:'id'},
	       {name:'name'},
	       {name:'saveName'},
	       {name:'kechengId'},
	       {name:'intro'},
	       {name:'fileSize'},
	       {name:'man'},
	       {name:'uptime'}
	      
        ],
        baseParams : {
        	limit : PAGESIZE,
    		xueqi :'',
    		kecheng :'',
    		keyword :''
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
				{width:1,header:'学期', align:'left',sortable:false, dataIndex:'kecheng',renderer:function(val){
					return val.xueqi.name;
				}},
				{width:1,header:'课程', align:'left',sortable:false, dataIndex:'kecheng',renderer:function(val){
					return val.name;
				}},
				{width:1.7,header:'文件名称', align:'left',sortable:false, dataIndex:'name'},
				{width:0.6,header:'上传人', align:'left',sortable:false, dataIndex:'man'},
				{width:1.2,header:'上传时间', align:'left',sortable:false, dataIndex:'uptime',renderer:function(val){
					return Ext.util.Format.date(val,'Y-m-d H:i:s');
				}},
				{width:2,header:'文件描述', align:'left',sortable:false, dataIndex:'intro'},
				{width:1,header:'操作', align:'center',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					return '<input type="button" value="下载" class="Mybotton" onclick="downloadFile('+val+')">' +
					 '<input type="button" value="删除" class="Mybotton" onclick="deleteF('+val+')">' ; 
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
			tbar : [{
						text : '上传教学文件',
						handler : function(b,e){
							location.href = "initUploadLibrary.do";
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
	
	
	chooseKecheng(function(){
		var hid = $("hidkechengId").value;
		if(_isNull(hid) || hid == 0){
			
		}else{
			$("kecheng").value = $("hidkechengId").value;
		}
	});
	
	searchFunc();
});