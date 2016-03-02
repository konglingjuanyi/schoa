(function() {
})();

function _isNull(val) {
	if (val == null || val == 'undefined' || val == 'null' || val == '') {
		return true;
	} else {
		return false;
	}
};

function save(){
	if(_isNull(document.getElementById("title").value)){
		alert("请填写“试卷标题”！");
		document.getElementById("title").focus();
		return false;
	}
	if(_isNull(document.getElementById("user").value)){
		alert("请填写“试卷创建人”！");
		document.getElementById("user").focus();
		return false;
	}
};

function viewAnswer(){
	window.open("initViewShowAnswer.do?ids="+document.getElementById("ids").value);
};

function replaceParamVal(oldUrl, paramName, replaceWith) {
    var re = eval('/(' + paramName + '=)([^&]*)/gi');
    var nUrl = oldUrl.replace(re, paramName + '=' + replaceWith);
    return nUrl;
}

function hasParameter(name){
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
        return null;
}

/**
 * 根据name得到checkbox的所有要提交的值
 */
function _getSelectValues(name){
	 var names = document.getElementsByName(name);
	 var arr = new Array();
	 for(var i =0;i < names.length;i++){
		  if(names[i].checked){
			  arr.push(names[i].value);
		  }
	 }
	 return arr;
}

function getReloadUrl(mustIds){
	var url = "";
	if(hasParameter("mustIds") == null){
		url = window.location.href + "&mustIds=" + mustIds;
	}else{
		url = replaceParamVal(window.location.href,"mustIds", mustIds);
	}
	return url;
}

function reloadPaper(){
	var mustId = _getSelectValues("shiti").toString();
	window.location.href = getReloadUrl(mustId);
}
