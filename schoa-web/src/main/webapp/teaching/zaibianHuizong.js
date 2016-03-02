Ext.onReady(function(){
	
	Ext.QuickTips.init();
	var w = 650,h=470;
	
	var store = new Ext.data.ArrayStore({
        fields: ['id', 'name'],
        data : STOREDATA
    });
	
	var infoWindow = new com.custom.Window({
        title:'绩效信息',
        closeAction:'hide',
        width:w,
        height:h,
        items: [{
	        	autoScroll: true,
	        	bodyStyle:"padding-top: 10px;",
	        	width:w - 20,
	        	height:h - 20 ,
	        	border:false,
	        	contentEl:'infoWindow'
        }]
	});
	this.showWindow = function(xueqiId,teacherId){
		Ext.Ajax.request({
			url : 'getZaibianTeacherJixiaoInfo.do?xueqiId='+xueqiId+"&teacherId="+teacherId,
			success : function(response){
				var resp = Ext.util.JSON.decode(response.responseText);
				if(resp.success){
					document.getElementById("info_div").innerHTML='';
					document.getElementById("info_div2").innerHTML='';
					var obj = resp.data;
					console.log(resp.data);
					
					if(obj==null || typeof(obj)=='undefined'){
						alert("数据加载失败!");
						return;
					}
					
					var str = '<table class="infoWin">';
					str += '<tr><td width="20%">教师:</td><td>'+obj.teacherName+'</td></tr>';
					str += '<tr><td>学期:</td><td>'+obj.xueqiName+'</td></tr>';
					str += '<tr><td>开会出勤:</td><td>'+show(obj.scKaihuiReason)+'</td></tr>';
					str += '<tr><td>班主任工作:</td><td>'+show(obj.scBanzhuren)+'</td></tr>';
					str += '<tr><td>兼任工作:</td><td>'+show(obj.scJianren)+'</td></tr>';
					str += '<tr><td>其他工作:</td><td>'+show(obj.scOther)+'</td></tr>';
					str += '<tr><td>得奖情况:</td><td>'+show(obj.scJiang)+'</td></tr>';
					str += '<tr><td>教学工作量:</td><td>'+show(obj.scGongzuoliang)+'</td></tr>';
					str += '<tr><td>学校考核:</td><td>'+showFiel(obj.id,obj.scKaoheFilename)+'</td></tr>';
					str += '<tr><td>备注:</td><td>'+((obj.remark==null || typeof(obj.remark)=='undefined')?'':obj.remark)+'</td></tr>';
					
					str += '</table>';
					document.getElementById("info_div").innerHTML=str;
					
					if(obj.jixiao==null || typeof(obj.jixiao)=='undefined'){
						return;
					}
					
					var jxhtml = '<table class="infoWin2">';
					jxhtml += '<tr><td>班级</td><td>课程</td><td>教学考评</td><td>上课出勤</td><td>教学文件</td><td>听课情况</td></tr>';
					for(var i=0;i<obj.jixiao.length;i++){
						var jx = obj.jixiao[i];
						
						jxhtml += '<tr><td>'+jx.banjiName
						+'</td><td>'+jx.kechengName
						+'</td><td>'+tofixedFunc(jx.scKaopin)
						+'</td><td>'+tofixedFunc(jx.scChuqin)
						+'</td><td>'+tofixedFunc(jx.scJiaoxuefile)
						+'</td><td>'+tofixedFunc(jx.scTingke)+'</td></tr>';
						
					}
					jxhtml += '</table>';
					document.getElementById("info_div2").innerHTML=jxhtml;
					
					infoWindow.show();
				}else{
					alert("数据加载失败!");
				}
			}
		});
	};
	
	function show(v){
		if(v==null || typeof(v)=='undefined'){
			return '';
		}else {
			return ''+v;
		}
	}
	function showFiel(id,fileName){
		if(fileName==null || typeof(fileName)=='undefined' || fileName==''){
			return '';
		}
		return '<a target="_blank" href="downloadZaibianJixiaoFile.do?id='+id+'">下载《'+fileName+'》</a>';
	}
	
	var box = new Ext.form.ComboBox({
        store: store,
        displayField:'name',
        hiddenName:'id',
        valueField : 'id',
        typeAhead: true,
        forceSelection: true,
        mode: 'local',
        triggerAction: 'all',
        emptyText:'请选择在编教师',
        selectOnFocus:true,
        applyTo: 'local-states-with-qtip',
        listeners:{
        		'select' : function(box,record){
        			location.href = "initZaibianHuizong.do?teacherId=" + record.data.id;
        		}
        }
    });
	
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
	        region : 'center',
	        title :  "在编教师信息汇总",
			frame : false,
			border: false,
			autoScroll : true,
			contentEl : 'search_div_id'
		}]
	});
	
});
