(function() {
	
	var tmp;
	
	this.closeWin = function(){
		$.unblockUI();
	};
	
	this.save = function(){
		if(tmp){
			var v = $('#newvalue').val();
			if(regexVerify('num', v)){
				tmp.innerHTML = v;
				closeWin();
			}else{
				alert("请填写正确的数字！");
			}
		}else{
			alert("系统错误！");
		}
	};
	
	this.showWindow = function(td,title){
		tmp = td;
		$('#winTitle').text(title);
		$('#newvalue').val(tmp.innerHTML);
	
		$.blockUI({ 
            message: $('#box'), 
            css: {
                background:'none'
            } 
        }); 
		
		$('.blockOverlay').css('width','100%');
		$('.blockOverlay').css('height','100%');
	};
	
	this.printCur = function(){
		var str = '';
		$('.score').each(function(i){
			var tr = new Array();
			var j = 0;
			$(this).find("td").each(function(){
				tr[j] = $(this).text();
				j++;
			});
			str += tr + ';';
		});
		
		if(str==null||str==''){
			alert("数据错误！");
		}else{
			var url = "initSaveReportChengJiDan.do?str="+str
						+"&studentId="+$('#hide_studentId').val()
						+"&classesId="+$('#hide_classesId').val();
			window.open(url);
		}
	};
	
	this.printHistory = function(historyId){
		var url = "initReportChengJiDanFromHistory.do?historyId="+historyId;
		window.open(url);
	};
	
})();
