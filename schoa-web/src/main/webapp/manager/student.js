Ext.onReady(function(){
	Ext.QuickTips.init();
	
	var _studentId = 0;
	var _oldState = 0;
	var _newState = 0;
	var _title = '';
	
	this.closeWin = function(){
		$.unblockUI();
	};
	
	this.searchFunc=function(){
		gridStore.proxy.conn.url = "searchStudents.do?huzhao="+$("huzhao").value+"&sname="+$("sname").value;
		gridStore.load();
	};
	
	this.searchFunc2=function(){
		var xueqi = document.getElementById("xueqi").value;
		if(xueqi==null||xueqi==0){
			alert("请选择学期！");
			return;
		}
		gridStore.proxy.conn.url = "searchStudentsByXueqi.do?xueqiId="+xueqi;
		gridStore.load();
	};
	
	this.updateF = function(id){
		location.href = "initEditStudent.do?id="+id;
	};
	
	var w = 600;
	var h = 400;
	
	var windowStudentStateLog = new com.custom.Window({
        title:'离校(返校)记录',
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
	
	var _w = 350;
	var _h = 180;
	var win = new com.custom.Window({
				title : '离校',
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
						fieldLabel : '离校时间',
						width : 120,
						xtype : "datefield",
						format : "Y-m-d"
					},{
						id:'combox',
						fieldLabel:"离校原因",
						xtype:"combo",
						forceSelection: true,
						displayField:"depart",
						mode:"local",
						allowBlank : false,
						editable: false,
						triggerAction:"all",
						selectOnFocus : true,
						value:'',
				        listeners:{
				        		'select' : function(box,record){
				        			if(box.getValue() == '其他'){
				        				Ext.getCmp("leaveReason").show();
				        				Ext.getCmp("leaveReason").setValue('');
				        			}else{
				        				Ext.getCmp("leaveReason").hide();
				        				Ext.getCmp("leaveReason").setValue(box.getValue());
				        			}
				        		} 
				        },
						store: new Ext.data.SimpleStore({
							fields:["depart"],
							data:[["结业"],["转学"],["退学"],["回国"],["其他"]]
						})
					},{
						id : 'leaveReason',
						fieldLabel : '',
						width : 200,
						xtype : "textfield"
					}]
				}) ],
				buttons : [{
							text : '确定',
							handler : function() {
								var dt = Ext.getCmp("leaveDate").getRawValue();
								if(dt == null || dt == ''){
									alert('请填写离校时间！');
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
				Ext.getCmp("combox").setValue('结业');
				Ext.getCmp("leaveReason").setValue('结业');
				Ext.getCmp("leaveReason").hide();
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
	
	
	//展示学生离校记录
	this.showStudentStateLogs = function(a,studentId,studentName){
		var url = "showStudentStateLogs.do?studentId="+studentId;
		Ext.Ajax.request( {
			url : url,
			success : function(response){
				var resp = Ext.util.JSON.decode(response.responseText);
				if(resp.success){
					windowStudentStateLog.setTitle(studentName+"离校(返校)记录");
					windowStudentStateLog.show(a);
					document.getElementById("logId").innerHTML = '';
					var str = '';
					var ls = resp.data;
					for(var i=0;i<ls.length;i++){
						var dt = ls[i];
						str += dt.stateUptimeStr + (dt.state == 2?'离校':'返校') + "&nbsp;原因：" + dt.stateIntro + '<br/>';
					}
					document.getElementById("logId").innerHTML = (str==''?'无记录!':str);
				}else{
					alert("数据读取失败");
				}
			}
		});
	};
	
	
	//离校返校状态修改
	this.updateStudentState = function(a,studentId,oldState,newState){
		_studentId = studentId;
		_oldState = oldState;
		_newState = newState;
		
		if(_newState == 2){//离校
			win.show(a);
		}else{//返校
			win2.show(a);
		}
	};
	
	this.updateState = function(leaveDate,leaveReason){
		var url = "updateStudentState.do?leaveDate="+leaveDate
			+"&studentId="+_studentId
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
	
	//打印学习证明
	this.reportLearnZM = function(id){
		forwardExport("initReportStudyZhMPage.do?studentId="+id);
	};
	
	//列表数据
	var gridStore = new Ext.data.JsonStore({
	    url : 'searchStudents.do',
	    root : 'data',
	    remoteSort: false, 
	    totalProperty:'total',
	    fields: [
	       {name:'id'},
	       {name:'code'},
	       {name:'phone'},
	       {name:'email'},
	       {name:'country'},
	       {name:'ename'},
	       {name:'cname'},
	       {name:'headPic'},
	       {name:'sex'},
	       {name:'birthday'},
	       {name:'nation'},
	       {name:'address'},
	       {name:'closedDate'},
	       {name:'costFrom'},
	       {name:'state'},
	       {name:'stateUptime'},
	       {name:'stateIntro'},
	       {name:'passNumb'}
        ],
        baseParams : {
        		limit : 100,
        		sname :''
		}
    });
	
	var sm = new Ext.grid.CheckboxSelectionModel({singleSelect:false});
	var grid = new com.custom.GridPanel({
		store : gridStore,
		region : 'center',
		frame : false,
		border : false,
		sm : sm,
		autoHeight:true,
		columns: [ 
		         sm,
				{width:1.5,header:'学生证号', align:'center',sortable:false, dataIndex:'code'},
				{width:0.8,header:'头像', align:'left',sortable:false, dataIndex:'headPic',renderer:function(val,cell,record){
					return showIMG(val);
				}},
				{width:3,header:'姓名', align:'left',sortable:false, dataIndex:'cname',renderer:function(val,cell,record){
					var tip = val + "(" + (showSex(record.data.sex)) + ")<br/>" + record.data.ename;
					return '<a href="initStudentInfos.do?id='+record.data.id+'" target="_blank" style="text-decoration: none;">' + tip + '</a>';
				}},
				{width:1.5,header:'电话', align:'left',sortable:false, dataIndex:'phone'},
				{width:1.5,header:'国籍', align:'left',sortable:false, dataIndex:'country',renderer:function(val,cell,record){
					return showCountry(val.path) + '<br/>' + (_isNull(val.cname)?'':val.cname);
				}},
				{width:1.5,header:'护照号', align:'left',sortable:false, dataIndex:'passNumb'},
				{width:0.7,header:'状态', align:'left',sortable:false, dataIndex:'state',renderer:function(val,cell,record){
//					学生状态：0正常；1返校；2离校
					var t = '';
					if(val == 0){
						t = '正常';
					}
					if(val == 1){
						t = '返校';
					}
					if(val == 2){
						t = '<span style="color:red;">离校</span>';
					}
					
					return '<a onclick="showStudentStateLogs(this,'+record.data.id+',\''+record.data.cname+'\')" href="#" style="text-decoration: none;">' + t + '</a>';
				}},
				{width:3.5,header:'操作', align:'left',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					var str = '';
					if(record.data.state == 2){
						str += '<input type="button" value="返校" class="Mybotton" onclick="updateStudentState(this,'+val+','+record.data.state+',1)">' ;
					}else{
						str += '<input type="button" value="离校" class="Mybotton" onclick="updateStudentState(this,'+val+','+record.data.state+',2)">' ;
					}
					str += '<input type="button" value="修改" class="Mybotton" onclick="updateF('+val+')">' ;
					str += '<button class="Printbotton" onclick="reportLearnZM('+val+')"><img src="imgs/print.png" style="margin-right: 5px;">学习证明</button>';
					return str;
				}}
		]
	}); 
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
			region : 'north',
			title :  "学生管理",
			border : false,
			height : 75,
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
							location.href = "initEditStudent.do";
						}
					},'|',{
						text : '导入学生信息',
						handler : function(b,e){
							window.open("initImportStudents.do","ImportStudents");
						}
					},'|',{
						text : '导入学生证号',
						handler : function(b,e){
							window.open("initImportStudentsCode.do","ImportStudentsCode");
						}
					},'|',{
						text : '学生名单',
						icon : 'imgs/print.png',
						handler : function(b,e){
							var arr = _getGridSelectedIds(grid);
				        		if(arr.length == 0){
				        			alert("请选择要操作的记录！");
				        			return;
				        		};
							window.open("initReportStudents.do?ids="+arr,"reports_window","");
						}
					},'->',
					new Ext.PagingToolbar({
			            pageSize: 100,
			            store: gridStore,
			            style : {'border' : 0},
			            displayInfo: true
			        })]
		}]
	});
	
	searchFunc();
});