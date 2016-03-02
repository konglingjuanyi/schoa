Ext.onReady(function(){
	
	var flag = "";
	
	this.save = function(){
		if(_isNull($("content").value)){
			alert("请填写“试题内容”！");
			$("content").focus();
			return false;
		}
		if(_isNull($("answer").value)){
			alert("请填写“试题答案”！");
			$("answer").focus();
			return false;
		}
		if($("tixingId").value == 0){
			alert("请选择“题型”！");
			return false;
		}
//		if($("knowledgePointId").value == 0){
//			alert("请选择“知识点”！");
//			return false;
//		}
		if(_isNull($("member").value)){
			alert("请填写“出题人”！");
			$("member").focus();
			return false;
		}
		
//		var url =  'searchSameBank.do?id='+$("hideId").value+'&tixingId='+$("tixingId").value +'&knowledgePointId='+$("knowledgePointId").value+'&content='+$("content").value;
//		var b = false;
//		
//		var xmlHttpRequest = null;
//		if(window.ActiveXObject){
//            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
//        }else if(window.XMLHttpRequest){
//            xmlHttpRequest = new XMLHttpRequest();
//        }
//        
//        if(null != xmlHttpRequest){
//            xmlHttpRequest.open("GET", url, false);
//            xmlHttpRequest.onreadystatechange = function(){
//	            	if(xmlHttpRequest.readyState == 4){
//                    if(xmlHttpRequest.status == 200){
//                       	var r = xmlHttpRequest.responseText;
//						if (r == null || r == '') {
//							b = true;
//						}else{
//							if (confirm("包含以下相似试题，是否继续保存？\n\n" + r )) {
//								b = true;
//							} else {
//								b = false;
//							}
//						}
//                    }
//                }
//            };
//            xmlHttpRequest.send();    
//        }
        
//        return b;
	};
	
	this.showImg = function(f, path){
		document.getElementById('img'+f).src = IMAGEURL + path;
		document.getElementById('hideImg'+f).value = path;
		document.getElementById('img'+f).style.display = '';
	};
	
	this.hideImg = function(f){
		document.getElementById('img'+f).src = '';
		document.getElementById('hideImg'+f).value = '';
		document.getElementById('img'+f).style.display = 'none';
	};
	
	var pic = new ImgUpLoadWindow(function(fp, response){
		if(response.result.success){
			var path = response.result.data;
			if(_isNull(path)){
				alert("未接收到图片！");
			}else{
				showImg(flag, path);
			}
			pic.hide();
		}else{
			alert(response.result.msg);
		}
	});
	this.chooseImg = function(f){
		flag = f;
		pic.show();
	};
	
	this.chooseMKecheng = function(callback){
		var material = $("materialId");
		var mKecheng = $("materialKechengId");
		
		_cleanSelect(mKecheng);
		mKecheng.options.add(new Option("请选择...",0))
		Ext.Ajax.request( {
			url : 'getMKechengByMaterialId.do?materialId='+material.value,
			success : function(response){
				var resp = Ext.util.JSON.decode(response.responseText);
				if(resp == null){
					return;
				}
				for(var i=0;i<resp.length;i++){
					var ent = resp[i];
					mKecheng.options.add(new Option(ent.name,ent.id));
				}
				callback();
			}
		});
	};
	
	function init(){
		chooseMKecheng(function(){
			$("materialKechengId").value = $("hideMaterialKechengId").value;
		});
		
	}
	
	this.getWordLevel = function(){
		var content = $("content").value;
		var answer = $("answer").value;
		if(_isNull(content) || _isNull(answer)){
			return;
		}
		Ext.Ajax.request( {
			url : "getWordLevel.do?content="+content+"&answer="+answer,
			success : function(response){
				var resp = Ext.util.JSON.decode(response.responseText);
				if(resp == null){
					return;
				}
				var html = '<ul>';
				for(var i = 0 ; i < resp.length;i++){
					html += '<li style="margin: 5px;padding: 5px;">'+resp[i]+'</li>';
				}
				html += '</ul>';
				document.getElementById("ul_id").innerHTML = html;
			}
		});
	};
	
	new Ext.Viewport({
		layout : 'fit',
		items : [{
			title : '编辑试题',
			bodyStyle:'padding:5px', 
			border : false,
			frame : false,
			autoScroll : true,
			contentEl : 'div_panel_id'
		}]
	});
	
	this.showOrhide = function(f,img){
		if(img == '' || img == null){
			hideImg(f);
		}else{
			showImg(f,img);
		};
	};
	
	showOrhide('',document.getElementById('hideImg').value);
	showOrhide('A',document.getElementById('hideImgA').value);
	showOrhide('B',document.getElementById('hideImgB').value);
	showOrhide('C',document.getElementById('hideImgC').value);
	showOrhide('D',document.getElementById('hideImgD').value);
	showOrhide('E',document.getElementById('hideImgE').value);
	showOrhide('F',document.getElementById('hideImgF').value);
	
	if($("hideId").value > 0){
		init();
	}
});