
/**
 * 选择学生
 */
WindowSelectStu = function(callback){
	
	var self = this;
	
	this.selectStore = new Ext.data.JsonStore({
	    url : 'searchStudents.do',
	    root : 'data',
	    totalProperty:'total',
	    fields: [
				{name:'id'},
				{name:'code'},
				{name:'country'},
				{name:'ename'},
				{name:'passNumb'},
				{name:'cname'},
				{name:'headPic'},
				{name:'nation'}
	    ],
	    baseParams:{  
	    		limit : PAGESIZE,
	    		sname : ''
	    }
	});
//	this.selectStore.load();
	
	//单选
	this.sm = new Ext.grid.CheckboxSelectionModel({header:'',singleSelect:true});
	
	//搜索控件
	this.nameField = new Ext.form.TextField();
	
	this.search = function(){
		var name = self.nameField.getValue();
		if (name == null || name == "") {
			alert("输入姓名查询词！");
			return;
		}
		self.selectStore.setBaseParam("sname", name);
		self.selectStore.load();
	};
	
	//列表
	this.selectGrid = new com.custom.GridPanel({
		border : true,
		store : self.selectStore,
		sm : self.sm,
		cls : 'x-grid-radio-custom', //单选样式
		columns: [
				self.sm,
				{width:2,header:'学生证号', align:'center',sortable:false, dataIndex:'code'},
				{width:1,header:'头像', align:'left',sortable:false, dataIndex:'headPic',renderer:function(val,cell,record){
					return showIMG(val);
				}},
				{width:3,header:'姓名', align:'left',sortable:false, dataIndex:'cname',renderer:function(val,cell,record){
					return val + '<br/>' + record.data.ename;
				}},
				{width:3,header:'国籍', align:'left',sortable:false, dataIndex:'country',renderer:function(val,cell,record){
					return showCountry(val.path) + '<br/>' + val.cname;
				}},
				{width:2,header:'护照号', align:'left',sortable:false, dataIndex:'passNumb'}
		],
		keys:{//回车查询
			key:Ext.EventObject.ENTER,
			fn:function(btn,e){
				self.search();
			}
		},
	    tbar: new Ext.Toolbar({
	        items:[
	            new Ext.form.Label({ text:'姓名(中/英文)： ' }),
	            self.nameField,
			    	{ 
			    		text: '搜索',
			    		handler:function(){
			    			self.search();
			    		}
			    	},'->',
				new Ext.PagingToolbar({
		            pageSize: PAGESIZE,
		            store: self.selectStore,
		            style : {'border' : 0},
		            displayInfo: true
		        })]
	    })
	});
	
	WindowSelectStu.superclass.constructor.call(this, {
		title : '选择学生:',
		width : 680,
		height : 500,
		layout : 'fit',
		items : [self.selectGrid],
		buttons : [{
			text : '确定',
			handler : function(){
				if (self.selectGrid.getSelectionModel().getCount() == 0) {
					alert('请选择一个目标！');
					return;
				}
				//选择的记录
				var record = self.selectGrid.getSelectionModel().getSelected();
				//返回实现方法
				callback(self,record);
			}
		},{
			text : '关闭',
			handler : function(){
				self.hide();
			}
		}]
	});
	
	this.on('beforeshow',function(){
		self.nameField.setValue('');
	});
	
};
Ext.extend(WindowSelectStu, com.custom.Window, {});
