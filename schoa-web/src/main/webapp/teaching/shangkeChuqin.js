(function() {
	
	this.closeWin = function(){
		$.unblockUI();
	};
	
	this.saveKaoqin = function(){
		var url = "saveTeacherShangkeChuqin.do?teacherId="+ $('#hide_teacherId').val()
				+"&paikeId="+$('#hide_paikeId').val()
				+"&day="+$('#hide_day').val()
				+"&remark="+$('#winRemark').val()
				+"&chuqin="+$('#winKaoqin').val();
		
		var showKaoqin = $('#winKaoqin').find("option:selected").text();
		
		$.get(url, {}, function(data) {
			var resp = eval("("+data+")");
			if(resp.success=='true'||resp.success){
				if($('#winKaoqin').val()==-2){
					showKaoqin = '';
				}else{
					var remark = $('#winRemark').val();
					if(remark!='' && remark!=null){
						showKaoqin += '<br/><span style="color: #999;">' +  remark + '</span>';
					}
				}
				$("#"+$('#hide_TDId').val()).html(showKaoqin);
				
				$.unblockUI();
			}else{
				alert("操作失败，请重试！");
			}
			
			$('#hide_teacherId').val('');
			$('#hide_day').val('');
			$('#hide_TDId').val('');
			$('#winRemark').val('');
			$('#hide_paikeId').val('');
		});
	};
	

	
	this.showWindow = function(td,day,teacherId,teacherName,paikeId){
		$('#winTitle').text("教师"+teacherName + day +"上课出勤");
		$('#hide_teacherId').val(teacherId);
		$('#hide_day').val(day);
		$('#hide_TDId').val(td.id);
		$('#hide_paikeId').val(paikeId);
	
		$.blockUI({ 
            message: $('#box'), 
            css: {
                background:'none'
            } 
        }); 
		
		$('.blockOverlay').css('width','100%');
		$('.blockOverlay').css('height','100%');
	};
	
	this.searchFunc = function(){
		var xueqi = document.getElementById("xueqi").value;
		var classes = document.getElementById("classes").value;
		var weeks = document.getElementById("weeks").value;
		if(xueqi==0){
			alert("请选择学期！");
			return;
		}
		if(classes==0){
			alert("请选择班级！");
			return;
		}
		if(weeks==0){
			alert("请选择周！");
			return;
		}
		location.href = "initShangkeChuqin.do?xueqi="+xueqi
				+"&classes="+classes
				+"&weeks="+weeks;
	};
	
	this.chooseClasses = function(){
		var xueqiId = document.getElementById("xueqi").value;
		var classes = document.getElementById("classes");
		_cleanSelect(classes);
		classes.options.add(new Option("请选择...",0))
		$.get('getClassesByXueqiId.do?privilege=1&xueqiId='+xueqiId, {}, function(data) {
			var resp = eval("("+data+")");
			if(resp == null){
				return;
			}
			for(var i=0;i<resp.length;i++){
				var ent = resp[i];
				classes.options.add(new Option(ent.name,ent.id));
			}
		});
		
		var weeks = document.getElementById("weeks");
		_cleanSelect(weeks);
		weeks.options.add(new Option("请选择...",0))
		$.get('getXueqiWeeks.do?xueqiId='+xueqiId, {}, function(data) {
			var resp = eval("("+data+")");
			if(resp == null){
				return;
			}
			for(var i=0;i<resp.length;i++){
				var name = '第'+(i+1)+'周('+resp[i]+')';
				var value = resp[i];
				weeks.options.add(new Option(name, value));
			}
		});
	};
	
	this._cleanSelect = function(selectObj){
		var len = selectObj.options.length;
		for(var i=0;i<len;i++){
			selectObj.options.remove(selectObj.options[i]);
		}
	};
})();
