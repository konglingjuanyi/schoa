(function() {
	
	this.closeWin = function(){
		$.unblockUI();
	};
	this.saveKaoqin = function(){
		$('#hidPaikeId').val();
		$('#hidStuId').val();
		$('#hidDayId').val();
		var url = "saveKaoqin.do?paikeId="+ $('#hidPaikeId').val()
				+"&studentId="+$('#hidStuId').val()
				+"&kaoqin="+$('#winKaoqin').val()
				+"&day="+$('#hidDayId').val();
		
		var showKaoqin = $('#winKaoqin').find("option:selected").text();
		showKaoqin = showKaoqin.substring(showKaoqin.indexOf(":")+1);
		
		$.get(url, {}, function(data) {
			var resp = eval("("+data+")");
			if(resp.success=='true'||resp.success){
				$("#"+$('#hidTDId').val()).text(showKaoqin);
				$.unblockUI();
			}else{
				alert("操作失败，请重试！");
			}
		});
	};
	
	this.commitFunc = function(){
		var xueqiId = document.getElementById("xueqi").value;
		var classesId = document.getElementById("classes").value;
		var weeks = document.getElementById("weeks");
		if(classesId==null || classesId<1){
			alert("请选择班级");
			return;
		}
		if(weeks.value==null || weeks.value<1){
			alert("请选择周");
			return;
		}
		if(confirm("确定提交吗?提交后本周考勤将不能修改！")){
			var url = 'lockKaoqin.do?weeks='+weeks.value+'&xueqiId='+xueqiId+'&classesId='+classesId;
			$.get(url, {}, function(data) {
				var resp = eval("("+data+")");
				if(resp.success=='true'||resp.success){
					alert("本周考勤已锁定！");
					location.href = location.href;
				}else{
					alert("操作失败！");
				}
			});
		}
	};
	
	//打印班级空考勤
	this.reportClassEmptyKaoqin=function(){
		var classesId = document.getElementById("classes").value;
		var weeks = document.getElementById("weeks");
		if(classesId==null || classesId<1){
			alert("请选择班级");
			return;
		}
		if(weeks.value==null || weeks.value<1){
			alert("请选择周");
			return;
		}
		var zhou = weeks.options[weeks.selectedIndex].text.split('(')[0];
		window.open("initReportClassEmptyKaoqin.do?classesId="+classesId+"&weeks="+weeks.value+"&zhou="+zhou,'report');
	};
	
	//打印班级本周考勤
	this.reportClassWeekKaoqin=function(){
		var classesId = document.getElementById("classes").value;
		var weeks = document.getElementById("weeks");
		if(classesId==null || classesId<1){
			alert("请选择班级");
			return;
		}
		if(weeks.value==null || weeks.value<1){
			alert("请选择周");
			return;
		}
		var zhou = weeks.options[weeks.selectedIndex].text.split('(')[0];
		window.open("initReportClassWeekKaoqin.do?weeks="+weeks.value+"&classesId="+classesId+"&zhou="+zhou,'report');
	};
	
	this.showWindow = function(td,stuId,stuName,paikeId,kechengName,day){
		$('#winTitle').text("学生"+stuName+day+kechengName+"考勤");
		$('#hidPaikeId').val(paikeId);
		$('#hidStuId').val(stuId);
		$('#hidDayId').val(day);
		$('#hidTDId').val(td.id);
	
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
		location.href = "initKaoqin.do?xueqi="+xueqi
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
