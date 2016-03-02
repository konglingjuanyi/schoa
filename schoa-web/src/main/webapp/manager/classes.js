Ext.onReady(function(){
	Ext.QuickTips.init();
	
	this.searchFunc=function(){
		gridStore.setBaseParam("xueqi", $("xueqi").value);
		gridStore.load();
	};
	
	this.updateF=function(id){
//		window.open("initEditTeacher.do?id="+id,"EditTeacher","");
		location.href = "initEditClasses.do?id="+id;
	};
	
	//学生信息
	this.studentInfo=function(id){
		window.open("initClassesStudents.do?classesId="+id);
	};
	
	//排课
	this.planInfo=function(id){
		window.open("initPaike.do?classesId="+id+"&t="+new Date().getTime());
	};
	
	//列表数据
	var gridStore = new Ext.data.JsonStore({
	    url : 'searchClasses.do',
	    root : 'data',
	    remoteSort: false, 
	    totalProperty:'total',
	    fields: [
	       {name:'id'},
	       {name:'name'},
	       {name:'xueqiId'},
	       {name:'teacherId'},
	       {name:'startDate'},
	       {name:'endDate'},
	       {name:'teacher'}, //object
	       {name:'xueqi'},//object
	       {name:'rmark'}
        ],
        baseParams : {
        		limit : PAGESIZE,
        		xueqi :''
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
				{width:1.5,header:'班级', align:'left',sortable:false, dataIndex:'name'},
				{width:1.5,header:'学期', align:'left',sortable:false, dataIndex:'xueqi',renderer:function(val){
					return val.name;
				}},
				{width:1,header:'班主任', align:'left',sortable:false, dataIndex:'teacher',renderer:function(val){
					return val.name;
				}},
				{width:3,header:'备注', align:'left',sortable:false, dataIndex:'rmark'},
				{width:3,header:'操作', align:'center',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					var str = '<input type="button" value="修改" class="Mybotton" onclick="updateF('+val+')">';
//						'<input type="button" value="删除" class="Mybotton" onclick="deleteF('+val+')">';
					str += '<input type="button" value="学生信息" class="Mybotton" onclick="studentInfo('+val+')">';
					str += '<input type="button" value="排课" class="Mybotton" onclick="planInfo('+val+')">';
					return str;
				}}
		]
	}); 
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
			region : 'north',
			title:'班级管理',
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
							location.href = "initEditClasses.do";
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