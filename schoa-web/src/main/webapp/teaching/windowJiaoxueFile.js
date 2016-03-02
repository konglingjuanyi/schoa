
/**
 * kechengId
 */
var WindowJiaoxueFile = function(){
	
	var self = this;
	
	this.search = function(kechengId){
		self.selectStore.setBaseParam("kechengId", kechengId);
		self.selectStore.load();
	};
	
	this.selectStore = new Ext.data.JsonStore({
	    url : 'searchJiaoxueFileForKecheng.do',
	    root : 'data',
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
	    baseParams:{  
	    		kechengId : 0
	    }
	});
	
	//列表
	this.selectGrid = new com.custom.GridPanel({
		border : true,
		store : self.selectStore,
		sm : self.sm,
		columns: [
				{width:0.7,header:'ID', align:'center',sortable:false, dataIndex:'id'},
				{width:1,header:'学期', align:'left',sortable:false, dataIndex:'xueqi',renderer:function(val){
					return val.name;
				}},
				{width:2,header:'课程', align:'left',sortable:false, dataIndex:'kecheng',renderer:function(val,cell,record){
					return val.name + '(' + record.data.teacher.name + ')';
				}},
				{width:2,header:'教学文件', align:'left',sortable:false, dataIndex:'jiaoxueFileScore',renderer:function(val,cell,record){
					return val.name + '(' + val.score +"分)"
				}},
				{width:2,header:'文件名', align:'left',sortable:false, dataIndex:'name'},
				{width:1.5,header:'上传信息', align:'left',sortable:false, dataIndex:'uptime',renderer:function(val,cell,record){
					return record.data.memberName + '<br/>' + Ext.util.Format.date(val,'Y-m-d H:i:s');
				}},
				{width:2,header:'操作', align:'center',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					var str = '';
					if(record.data.quanxian || record.data.quanxian=='true'){
						str += '<input type="button" value="上传" class="Mybotton" onclick="chooseFile('+val+')">' ;
						str += '<input type="button" value="下载" class="Mybotton" onclick="downloadFile('+val+')">' ;
						str += '<input type="button" value="清除文件" class="Mybotton" onclick="clearFile('+val+')">' ;
					}
					return str;
				}}
		]
	});
	
	WindowJiaoxueFile.superclass.constructor.call(this, {
		title : '课程教学文件',
		width :  1000,
		height : 500,
		layout : 'fit',
		items : [self.selectGrid],
		buttons : [{
			text : '关闭',
			handler : function(){
				self.hide();
			}
		}]
	});
	
	
	
	
};
Ext.extend(WindowJiaoxueFile, com.custom.Window, {});
