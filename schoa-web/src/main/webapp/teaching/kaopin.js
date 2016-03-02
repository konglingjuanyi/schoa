Ext.onReady(function(){
	Ext.QuickTips.init();
	
	this.chooseClasses = function(){
		var xueqiId = $("xueqiId").value;
		var classesId = $("classesId");
		_cleanSelect(classesId);
		classesId.options.add(new Option("请选择...",0))
		Ext.Ajax.request( {
			url : 'getClassesByXueqiId.do?privilege=1&xueqiId='+xueqiId,
			success : function(response){
				var resp = Ext.util.JSON.decode(response.responseText);
				if(resp == null){
					return;
				}
				for(var i=0;i<resp.length;i++){
					var ent = resp[i];
					classesId.options.add(new Option(ent.name,ent.id));
				}
				chooseKecheng();
			}
		});
	};
	
	this.chooseKecheng = function(){
		var classesId = $("classesId").value;
		var kechengId = $("kechengId");
		_cleanSelect(kechengId);
		kechengId.options.add(new Option("请选择...",0))
		Ext.Ajax.request( {
			url : 'getKechengByClassesId.do?privilege=1&classesId='+classesId,
			success : function(response){
				var resp = Ext.util.JSON.decode(response.responseText);
				if(resp == null){
					return;
				}
				for(var i=0;i<resp.length;i++){
					var ent = resp[i];
					kechengId.options.add(new Option(ent.name,ent.id));
				}
			}
		});
	};
	
	this.searchFunc=function(){
		gridStore.setBaseParam("xueqiId", $("xueqiId").value);
		gridStore.setBaseParam("classesId", $("classesId").value);
		gridStore.setBaseParam("kechengId", $("kechengId").value);
		gridStore.load();
	};
	
	//打印班级空白考评表
	this.printEmptyKaopin=function(){
		var xueqiId = document.getElementById("xueqiId").value;
		var classesId = document.getElementById("classesId").value;
		if(xueqiId==0){
			alert("请选择学期！");
			return;
		}
		if(classesId==0){
			alert("请选择班级！");
			return;
		}
		
		window.open('initPrintClassKaopin.do?xueqiId=' + xueqiId + "&classesId="+classesId);
	};
	
	//打印教师考评结果表
	this.printTeacherKaopin=function(kaopinId){
		window.open('initPrintTeacherKaopin.do?kaopinId=' + kaopinId);
	};
	
	//考评信息
	this.kaopinInfo=function(id){
		location.href = 'initTeacherKaopinList.do?kaopinId=' + id;
	};
	
	//修改考评
	this.modifyKaopin=function(id){
		location.href = "initEditKaopin.do?id="+id;
	};
	
	//删除考评
	this.deleteKaopin=function(id){
		if(confirm("确定要删除该考评吗？该考评下录入的成绩列表也将删除，删除后将不能恢复！")){
			Ext.Ajax.request( {
				url : 'deleteKaopin.do?id='+id,
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
	    url : 'searchTeachingKaopin.do',
	    root : 'data',
	    remoteSort: false, 
	    totalProperty:'total',
	    fields: [
	       {name:'id'},
	       {name:'xueqiId'},
	       {name:'banjiId'},
	       {name:'kechengId'},
	       {name:'teacherId'},
	       {name:'name'},
	       {name:'score'},
	       {name:'teacher'},
	       {name:'banji'},
	       {name:'xueqi'},
	       {name:'kecheng'}
        ],
        baseParams : {
        		limit : PAGESIZE
		}
    });
	
	//是否是管理员
	var isadmin = document.getElementById("isadmin").value;
	
	var grid = new com.custom.GridPanel({
		store : gridStore,
		region : 'center',
		frame : false,
		border : false,
		autoHeight:true,
		columns: [ 
				{width:1,header:'ID', align:'center',sortable:false, dataIndex:'id'},
				{width:1,header:'学期', align:'center',sortable:false, dataIndex:'xueqi',renderer:function(val,cell,record){
					return record.data.xueqi.name;
				}},
				{width:1,header:'班级', align:'center',sortable:false, dataIndex:'banji',renderer:function(val,cell,record){
					return record.data.banji.name;
				}},
				{width:1,header:'课程', align:'center',sortable:false, dataIndex:'kecheng',renderer:function(val,cell,record){
					return record.data.kecheng.name + '<br/><span style="color:#999;">' + record.data.teacher.name + '</span>';
				}},
				{width:1.5,header:'考评名称', align:'center',sortable:false, dataIndex:'name'},
				{width:1,header:'得分', align:'right',sortable:false, dataIndex:'score'},
				{width:3,header:'操作', align:'center',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					var str = '';
					if(isadmin=='true' || isadmin==true){
						str += '<input type="button" value="修改" class="Mybotton" onclick="modifyKaopin('+val+')">';
						str += '<input type="button" value="删除" class="Mybotton" onclick="deleteKaopin('+val+')">';
					}
					str += '<input type="button" value="考评成绩列表" class="Mybotton" onclick="kaopinInfo('+val+')">';
					str += '<button class="Printbotton" onclick="printTeacherKaopin('+val+')"><img src="imgs/print.png" style="margin-right: 5px;">考评</button>';
					return str;
				}}
		]
	}); 
	
	var addbar = '';
	if(isadmin=='true' || isadmin==true){
		addbar = {
				text : '新增考评',
				handler : function(b,e){
					location.href = "initEditKaopin.do";
				}
			};
	}
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
			region : 'north',
			title:'教学考评',
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
			tbar : [addbar,'->',
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