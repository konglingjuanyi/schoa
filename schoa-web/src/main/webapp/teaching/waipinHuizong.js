Ext.onReady(function(){
	
	Ext.QuickTips.init();
	var w = 650,h=450;
	
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
			url : 'getWaipinTeacherJixiaoInfo.do?xueqiId='+xueqiId+"&teacherId="+teacherId,
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
					str += '<tr><td>开会出勤:</td><td>'+obj.scKaihui+show(obj.scKaihuiReason)+'</td></tr>';
					str += '<tr><td>学生活动:</td><td>'+obj.scHuodong+show(obj.scHuodongReason)+'</td></tr>';
					str += '<tr><td>教案:</td><td>'+obj.scYinxiang+show(obj.scYinxiangReason)+'</td></tr>';
					str += '<tr><td>特殊贡献:</td><td>'+obj.scGongxian+show(obj.scGongxianReason)+'</td></tr>';
					str += '<tr><td>优秀:</td><td>'+(obj.youxiu==1?'优秀':'')+'</td></tr>';
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
					
					var t = 0;
					if(obj.total==null || typeof(obj.total)=='undefined'){
						t = 0;
					}else{
						t = obj.total;
					}
					document.getElementById("total").innerHTML = t;
					
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
			return '分&nbsp;'+v;
		}
	}
	var store = new Ext.data.ArrayStore({
        fields: ['id', 'name'],
        data : STOREDATA
    });
	
	var box = new Ext.form.ComboBox({
        store: store,
        displayField:'name',
        hiddenName:'id',
        valueField : 'id',
        typeAhead: true,
        forceSelection: true,
        mode: 'local',
        triggerAction: 'all',
        emptyText:'请选择外聘教师',
        selectOnFocus:true,
        applyTo: 'local-states-with-qtip',
        listeners:{
        		'select' : function(box,record){
        			location.href = "initWaipinHuizong.do?teacherId=" + record.data.id;
        		}
        }
    });
	
	
	
	new Ext.Viewport({
		layout : 'border',
		items : [{
	        region : 'center',
	        title :  "外聘教师信息汇总",
			frame : false,
			border: false,
			autoScroll : true,
			contentEl : 'search_div_id'
		}]
	});
	
});
