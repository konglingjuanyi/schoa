Ext.onReady(function(){
	Ext.QuickTips.init();
	
	this.searchFunc=function(){
		gridStore.setBaseParam("classesId", $("classesId").value);
		gridStore.load();
	};
	
	var window = new WindowStu($("classesId").value,function(classesId,ids){
		var url = 'addClassesStudent.do?classesId='+classesId
										+"&studentIds="+ids ;
		Ext.Ajax.request( {
			url : url,
			success : function(response){
				var resp = Ext.util.JSON.decode(response.responseText);
				if(resp.success){
					alert("操作成功");
					gridStore.reload();
					window.hide();
				}else{
					alert("操作失败");
				}
			}
		});
	});
	
	//移出本班
	this.moveOut=function(studentId){
		if(confirm("确定要将该学生移出本班吗？")){
			var url = "stuMoveoutClass.do?studentId="+studentId
										+ '&classesId='+$("classesId").value;
			Ext.Ajax.request( {
				url : url,
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
		};
	};
	
	//设置优秀生状态
	this.studentYouxiu = function(studentId, youxiu) {
		var url = "studentYouxiu.do?youxiu=" + youxiu + "&studentId=" + studentId + '&classesId=' + $("classesId").value;
		Ext.Ajax.request({
			url : url,
			success : function(response) {
				var resp = Ext.util.JSON.decode(response.responseText);
				if (resp.success) {
					alert("操作成功");
					gridStore.reload();
				} else {
					alert("操作失败");
				}
			}
		});
	};
	this.studentJinbu = function(studentId, jinbu) {
		var url = "studentJinbu.do?jinbu=" + jinbu + "&studentId=" + studentId + '&classesId=' + $("classesId").value;
		Ext.Ajax.request({
			url : url,
			success : function(response) {
				var resp = Ext.util.JSON.decode(response.responseText);
				if (resp.success) {
					alert("操作成功");
					gridStore.reload();
				} else {
					alert("操作失败");
				}
			}
		});
	};
	
	//列表数据
	var gridStore = new Ext.data.JsonStore({
	    url : 'searchClasseStudentGrid.do',
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
	       {name:'youxiu'},
	       {name:'jinbu'},
	       {name:'state'},
	       {name:'passNumb'}
        ],
        baseParams : {
        		classesId :''
		}
    });
	
	//打印优秀生
	this.reportYouxiu = function(id){
		forwardExport("initReportYouxiuStudent.do?studentId="+id);
	};
	this.reportJinbu = function(id){
		forwardExport("initPrintJinbu.do?studentId="+id);
	};
	
	var grid = new com.custom.GridPanel({
		store : gridStore,
		region : 'center',
		frame : false,
		border : false,
		autoHeight:true,
		columns: [ 
					new	Ext.grid.RowNumberer(),
					{width:1,header:'学生证号', align:'center',sortable:false, dataIndex:'code'},
					{width:1,header:'头像', align:'left',sortable:false, dataIndex:'headPic',renderer:function(val,cell,record){
						return showIMG(val);
					}},
					{width:2,header:'姓名', align:'left',sortable:false, dataIndex:'cname',renderer:function(val,cell,record){
						return '<a style="text-decoration: none;" href="initEditStudent.do?id='+record.data.id+'" target="view_window">'+val+'<br/>'+record.data.ename+'</a>';
					}},
					{width:1.5,header:'电话', align:'left',sortable:false, dataIndex:'phone'},
					{width:1.5,header:'国籍', align:'left',sortable:false, dataIndex:'country',renderer:function(val,cell,record){
						return showCountry(val.path) + '<br/>' + val.cname;
					}},
					{width:1.5,header:'是否优秀生', align:'left',sortable:false, dataIndex:'youxiu',renderer:function(val,cell,record){
						var str = '';
						if(val == 1){
							str += '<span style="color:red;">是</span>';
							str += '<button class="Printbotton" onclick="reportYouxiu('+record.data.id+')"><img src="imgs/print.png" style="margin-right: 5px;">优秀奖</button>';
						}
						return str;
					}},
					{width:1.5,header:'是否进步生', align:'left',sortable:false, dataIndex:'jinbu',renderer:function(val,cell,record){
						var str = '';
						if(val == 1){
							str += '<span style="color:red;">是</span>';
							str += '<button class="Printbotton" onclick="reportJinbu('+record.data.id+')"><img src="imgs/print.png" style="margin-right: 5px;">进步奖</button>';
						}
						return str;
					}},
					{width:0.5,header:'状态', align:'left',sortable:false, dataIndex:'state',renderer:function(val,cell,record){
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
						return t;
					}},
					{width:4,header:'操作', align:'left',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
						var str = '<input type="button" value="移出本班" class="Mybotton" onclick="moveOut('+val+')">' ;
						if(record.data.youxiu == 1){
							str += '<input type="button" value="取消优秀" class="Mybotton" onclick="studentYouxiu('+val+',0)">' ;
						}else{
							str += '<input type="button" value="优秀生" class="Mybotton" onclick="studentYouxiu('+val+',1)">' ;
						}
						
						if(record.data.jinbu == 1){
							str += '<input type="button" value="取消进步" class="Mybotton" onclick="studentJinbu('+val+',0)">' ;
						}else{
							str += '<input type="button" value="进步生" class="Mybotton" onclick="studentJinbu('+val+',1)">' ;
						}
						return str;
					}}
		]
	}); 
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
	        region : 'center',
	        title: '班级“'+$("classesName").value + '”学生信息',
			frame : false,
			border : true,
			autoScroll : true,
			items : [grid],
			tbar : [{
						text : '添加学生',
						handler : function(b,e){
							window.show(b.getEl());
						}
					}]
		}]
	});
	
	searchFunc();
});