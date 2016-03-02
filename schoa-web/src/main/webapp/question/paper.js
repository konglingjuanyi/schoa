Ext.onReady(function(){
	
	Ext.QuickTips.init();
	
	this.searchFunc = function(){
		gridStore.setBaseParam("title", $("title").value);
		gridStore.setBaseParam("user", $("user").value);
		gridStore.load();
	};
	
	this.viewAnswer = function(id){
		window.open("initViewShowAnswer.do?id="+id);
	};
	
	this.viewPaper = function(id){
		window.open("initViewShowPaper.do?id="+id);
	};
	
	
	this.deletePaper = function(id){
		if (confirm("确认要执行删除操作吗？")) {
			var url = "deleteQuestionPaper.do?id="+id;
			Ext.Ajax.request( {
				url : url,
				success : function(response){
					var resp = Ext.util.JSON.decode(response.responseText);
					if(resp.success){
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
	    url : 'searchQuestionPaper.do',
	    root : 'data',
	    remoteSort: false, 
	    totalProperty:'total',
	    fields: [
	       {name:'id'},
	       {name:'title'},
	       {name:'member'},
	       {name:'createTime'},
	       {name:'createTimeStr'},
	       {name:'createMember'}
        ],
        baseParams : {
        		limit : PAGESIZE
		}
    });
	
	var grid = new com.custom.GridPanel({
		store : gridStore,
		region : 'center',
		frame : false,
		border : false,
		autoHeight:true,
		columns: [ 
				{width:0.5,header:'ID', align:'center',sortable:false, dataIndex:'id'},
				{width:2,header:'试卷名称', align:'left',sortable:false, dataIndex:'title'},
				{width:0.8,header:'创建时间', align:'left',sortable:false, dataIndex:'createTimeStr'},
				{width:1,header:'试卷创建人', align:'left',sortable:false, dataIndex:'member'},
				{width:1,header:'操作', align:'left',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
					var str = '';
					str += '<input type="button" value="试卷预览" class="Mybotton" onclick="viewPaper('+val+')">';
					str += '<input type="button" value="试卷答案" class="Mybotton" onclick="viewAnswer('+val+')">';
					str += '<input type="button" value="删除" class="Mybotton" onclick="deletePaper('+val+')">';
					return str;
				}}
		]
	}); 
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
			region : 'north',
			title :  "试卷管理",
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
			tbar : ['->',
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