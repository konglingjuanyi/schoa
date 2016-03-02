
/**
 * classesId 班级id
 * 选择学生到班级
 */
WindowStu = function(classesId,callback){
	
	var self = this;
	
	this.sm = new Ext.grid.CheckboxSelectionModel();
	
	this.selectStore = new Ext.data.JsonStore({
	    url : 'searchOtherStu.do',
	    root : 'data',
	    totalProperty:'total',
	    fields: [
				{name:'id'},
				{name:'code'},
				{name:'country'},
				{name:'ename'},
				{name:'cname'},
				{name:'headPic'},
				{name:'passNumb'},
				{name:'nation'}
	    ],
	    baseParams:{  
	    		classesId : classesId,
	    		name : '',
	    		huzhao : ''
	    }
	});
	this.selectStore.load();
	
	//搜索控件
	this.nameField = new Ext.form.TextField();
	this.huzhaoField = new Ext.form.TextField();
	
	this.search = function(){
		self.selectStore.setBaseParam("name", self.nameField.getValue());
		self.selectStore.setBaseParam("huzhao", self.huzhaoField.getValue());
		self.selectStore.load();
	};
	
	//列表
	this.selectGrid = new com.custom.GridPanel({
		border : true,
		store : self.selectStore,
		sm : self.sm,
		columns: [
				self.sm,
				{width:1,header:'学生证号', align:'center',sortable:false, dataIndex:'code'},
				{width:1,header:'头像', align:'left',sortable:false, dataIndex:'headPic',renderer:function(val,cell,record){
					return showIMG(val);
				}},
				{width:2,header:'姓名', align:'left',sortable:false, dataIndex:'cname',renderer:function(val,cell,record){
					return val + '<br/>' + record.data.ename;
				}},
				{width:2,header:'国籍', align:'left',sortable:false, dataIndex:'country',renderer:function(val,cell,record){
					return showCountry(val.path) + '<br/>' + val.cname;
				}},
				{width:1.5,header:'护照号', align:'left',sortable:false, dataIndex:'passNumb'}
		],
		keys:{//回车查询
			key:Ext.EventObject.ENTER,
			fn:function(btn,e){
				self.search();
			}
		},
	    tbar: new Ext.Toolbar({
	        items:[
	            new Ext.form.Label({ text:'姓名(中/英文)：' }),
	            self.nameField,
	            	new Ext.form.Label({ text:'护照号：' }),
	            	self.huzhaoField,
			    	{ 
			    		text: '搜索',
			    		handler:function(){
			    			self.search();
			    		}
			    	}]
	    })
	});
	
	WindowStu.superclass.constructor.call(this, {
		title : '选择学生:',
		width : 680,
		height : 500,
		layout : 'fit',
		items : [self.selectGrid],
		buttons : [{
			text : '确定',
			handler : function(){
				if (self.selectGrid.getSelectionModel().getCount() == 0) {
					alert('请至少选择一个目标！');
					return;
				}
//				this.disabled=true;
				//返回实现方法
				callback(classesId,_getGridSelectedIds(self.selectGrid));
//				this.disabled=false;
			}
		},{
			text : '关闭',
			handler : function(){
				self.hide();
			}
		}]
	});
	
	this.on('beforeshow',function(){
//		self.xxx.setValue('<span style="color:red;padding-left:20px;">已选商圈:'+ self.str+'</span>');
//		self.cityField.setValue(self.alias);
		self.search();
	});
	
	
};
Ext.extend(WindowStu, com.custom.Window, {});
