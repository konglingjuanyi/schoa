Ext.onReady(function(){
	Ext.QuickTips.init();
	
	var _teacherId = 0;
	var _oldState = 0;
	var _newState = 0;
	var _title = '';
	
	this.searchFunc=function(){
		gridStore.setBaseParam("name", $("name").value);
		gridStore.setBaseParam("type", _getRadioValueJS("type"));
		gridStore.load();
	};
	
	this.teacherInfo=function(teacherId,bianzhi){
		if(bianzhi == 0){
			window.open("initZaibianHuizong.do?teacherId="+teacherId);
		}
		if(bianzhi == 1){
			window.open("initWaipinHuizong.do?teacherId="+teacherId);
		}
	};
	
	this.updateF=function(id){
		location.href = "initEditTeacher.do?id="+id;
	};
	
	this.deleteF = function(id){
		if(confirm("确定要删除该信息吗？删除将不能恢复！")){
			Ext.Ajax.request( {
				url : 'delTeacher.do?id='+id,
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
	    url : 'searchTeachers.do',
	    root : 'data',
	    remoteSort: false, 
	    totalProperty:'total',
	    fields: [
	       {name:'id'},
	       {name:'code'},
	       {name:'readingSchool'},
	       {name:'phone'},
	       {name:'email'},
	       {name:'entryTime'},
	       {name:'lizhiTime'},
	       {name:'type'},
	       {name:'state'},
	       {name:'name'},
	       {name:'cardNumb'},
	       {name:'sex'},
	       {name:'birthday'},
	       {name:'married'},
	       {name:'hometown'},
	       {name:'graduated'},
	       {name:'pro'},
	       {name:'address'},
	       {name:'experience'},
	       {name:'headPic'},
	       {name:'research'}
        ],
	    baseParams : {
	    		limit : PAGESIZE,
	    		name :'',
	    		type :''
		}
    });
	
	var w = 600;
	var h = 400;
	
	var windowStateLog = new com.custom.Window({
        title:'在岗(离职)记录',
        closeAction:'hide',
        width:w,
        height:h,
        items: [{
	        	autoScroll: true,
	        	bodyStyle:"padding-top: 10px;",
	        	//baseCls:"x-plain",
	        	width:w - 20,
	        	height:h - 20 ,
	        	border:false,
	        	contentEl:'logdiv'
        }]
	});
	
	
	//展示在岗(离职)记录，0正常；1在岗；2离职
	this.showStateLogs = function(a,teacherId,tName){
		var url = "showTeacherStateLogs.do?teacherId="+teacherId;
		Ext.Ajax.request( {
			url : url,
			success : function(response){
				var resp = Ext.util.JSON.decode(response.responseText);
				if(resp.success){
					windowStateLog.setTitle(tName+"在岗(离职)记录");
					windowStateLog.show(a);
					document.getElementById("logId").innerHTML = '';
					var str = '';
					var ls = resp.data;
					for(var i=0;i<ls.length;i++){
						var dt = ls[i];
						str += dt.stateUptimeStr + (dt.state == 2?'离职':'在岗') + "&nbsp;原因：" + dt.stateIntro + '<br/>';
					}
					document.getElementById("logId").innerHTML = (str==''?'无记录!':str);
				}else{
					alert("数据读取失败");
				}
			}
		});
	};
	
	this.updateState = function(leaveDate,leaveReason){
		var url = "updateTeacherState.do?leaveDate="+leaveDate
			+"&teacherId="+_teacherId
			+"&leaveReason="+leaveReason
			+"&oldState="+_oldState
			+"&newState="+_newState;
		
		Ext.Ajax.request( {
			url : url,
			success : function(response){
				var resp = Ext.util.JSON.decode(response.responseText);
				if(resp.success){
					alert("操作成功！");
					gridStore.load();
					win.hide();
					win2.hide();
				}
			}
		});
	};

	var _w = 350;
	var _h = 180;
	var win = new com.custom.Window({
				title : '离职',
				closeAction:'hide',
				width : _w,
				height : _h,
				closeAction : 'hide',
				plain : true,
				items : [ new Ext.FormPanel({
					labelWidth : 60,
					frame : false,
					border : false,
					bodyStyle : 'padding:10px 0px 0px 0px',
					width : _w - 10,
					height : _h - 60,
					defaultType : 'datefield',
					items : [ {
						id : 'leaveDate',
						fieldLabel : '离职时间',
						width : 120,
						xtype : "datefield",
						format : "Y-m-d"
					},{
						id : 'leaveReason',
						fieldLabel : '离职原因',
						width : 200,
						xtype : "textfield"
					}]
				}) ],
				buttons : [{
							text : '确定',
							handler : function() {
								var dt = Ext.getCmp("leaveDate").getRawValue();
								if(dt == null || dt == ''){
									alert('请填写离职时间！');
									return;
								}
								updateState(dt,Ext.getCmp("leaveReason").getValue());
							}
						}, {
							text : '取消',
							handler : function() {
								win.hide();
							}
						} ]
			});
	
			win.on('beforeshow',function(){
				Ext.getCmp("leaveDate").setRawValue('');
				Ext.getCmp("leaveReason").setValue('');
			});
			
			//返校窗口
			var win2 = new com.custom.Window({
				title : '返校',
				closeAction:'hide',
				width : _w,
				height : _h,
				closeAction : 'hide',
				plain : true,
				items : [ new Ext.FormPanel({
					labelWidth : 60,
					frame : false,
					border : false,
					bodyStyle : 'padding:10px 0px 0px 0px',
					width : _w - 10,
					height : _h - 60,
					defaultType : 'datefield',
					items : [ {
						id : 'backDate',
						fieldLabel : '返校时间',
						width : 120,
						xtype : "datefield",
						format : "Y-m-d"
					},{
						id : 'backReason',
						fieldLabel : '返校原因',
						width : 200,
						xtype : "textfield"
					}]
				}) ],
				buttons : [{
							text : '确定',
							handler : function() {
								var dt = Ext.getCmp("backDate").getRawValue();
								if(dt == null || dt == ''){
									alert('请填写返校时间！');
									return;
								}
								updateState(dt,Ext.getCmp("backReason").getValue());
							}
						}, {
							text : '取消',
							handler : function() {
								win2.hide();
							}
						} ]
			});
	
			win2.on('beforeshow',function(){
				Ext.getCmp("backDate").setRawValue('');
				Ext.getCmp("backReason").setValue('');
			});
	
	
	//离校返校状态修改
	this.updateTeacherState = function(a,teacherId,oldState,newState){
		_teacherId = teacherId;
		_oldState = oldState;
		_newState = newState;
		
		if(_newState == 2){//离校
			win.show(a);
		}else{//返校
			win2.show(a);
		}
	};
	
	var grid = new com.custom.GridPanel({
		store : gridStore,
		region : 'center',
		frame : false,
		border : false,
		autoHeight:true,
		columns: [ 
				{width:1,header:'编号', salign:'center',sortable:false, dataIndex:'code'},
				{width:0.8,header:'头像', align:'left',sortable:false, dataIndex:'headPic',renderer:function(val,cell,record){
					return showIMG(val);
				}},
				{width:1,header:'教师', align:'left',sortable:false, dataIndex:'name'},
				{width:1,header:'编制', align:'left',sortable:false, dataIndex:'type',renderer:function(val){
					return (val=='1'||val==1)?'外聘':'正编';
				}},
				{width:0.6,header:'性别', align:'left',sortable:false, dataIndex:'sex',renderer:function(val){
					return showSex(val);
				}},
				{width:1,header:'电话', align:'left',sortable:false, dataIndex:'phone'},
				{width:2,header:'身份证号', align:'left',sortable:false, dataIndex:'cardNumb'},
				{width:0.7,header:'状态', align:'left',sortable:false, dataIndex:'state',renderer:function(val,cell,record){
//					0正常；1在岗；2离校
					var t = '';
					if(val == 0){
						t = '正常';
					}
					if(val == 1){
						t = '在岗';
					}
					if(val == 2){
						t = '<span style="color:red;">离职</span>';
					}
					
					return '<a onclick="showStateLogs(this,'+record.data.id+',\''+record.data.name+'\')" href="#" style="text-decoration: none;">' + t + '</a>';
				}},
				{width:2,header:'操作', align:'center',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					var str = '';
					if(record.data.state == 2){
						str += '<input type="button" value="返校" class="Mybotton" onclick="updateTeacherState(this,'+val+','+record.data.state+',1)">' ;
					}else{
						str += '<input type="button" value="离职" class="Mybotton" onclick="updateTeacherState(this,'+val+','+record.data.state+',2)">' ;
					}
					str += '<input type="button" value="修改" class="Mybotton" onclick="updateF('+val+')">' ; 
					str += '<input type="button" value="信息汇总" class="Mybotton" onclick="teacherInfo('+val+','+record.data.type+')">' ; 
					return str;
				}}
		]
	}); 
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
			region : 'north',
			title :  "教师管理",
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
							location.href = "initEditTeacher.do";
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