(function() {
	
	this.addRow = function() {
		var tr = $("#tableId tr").eq(1).clone();
		tr.appendTo("#tableId");
		
		var row = $("#tableId tr").eq($('.row').length);
		row.find("select").each(function() {
			$(this).val(0);
		});
	};

	this.removeRow = function(img) {
		if(confirm("确定要删除该记录吗！")){
			if ($('.row').length == 1) {
				alert("最少排一节课!");
				return;
			}
			var row = $(img).parent().parent('.row');
			row.remove();
		}
		
	};
	
	this.getRowStr = function(row){
		var str = document.getElementById("hidenClassesId").value;
		row.find("select").each(function() {
			str += "|";
			str += $(this).val();
		});
		return str;
	};
	
	this.save = function() {
//		var reg = /^([0-1]\d|[2][0-3])\:([0-5]\d)$/;
////		alert(reg.test("28:18"));
//		var verification = true;
//		$("input:text").each(function(){
//			var val = $(this).val();
//			if(!reg.test(val)){
//				verification = false;
//			}
//		});
//		if(!verification){
//			alert("时间格式填写有误，请检查！");
//			return;
//		}
		
		var index = 0;
		var params = '';
		$('.row').each(function(){
			var str = getRowStr($(this));
			if(index != 0){
				params += ',';
			}
			params += str;
			index++;
		});
		
//		alert(params);
//		return;
		
		$.get("savePaike.do?classesId="+document.getElementById("hidenClassesId").value+"&params="+params, {}, function(data) {
			var dataobj = eval("("+data+")");
			if(dataobj.success=='false'||dataobj.success==false){
				alert(dataobj.msg);
			}else{
				alert("排课成功！");
				location.href = location.href ;
			}
		});
		
	};

	function isnull(val) {
		if (val == null || val == 'undefined' || val == 'null' || val == '') {
			return true;
		} else {
			return false;
		}
	};
	
})();
