
/**
 * @param url
 *            请求地址
 * @param params
 *            请求参数:key/value形式(可选)
 * @param callback
 *            请求成功后的回调函数(可选)
 */
function getJson(url, params, callback) {
	$.getJSON(url, params, callback);
}
/**
 * [GetFormVal 获取form表单的数据]
 * @author   Devil
 * @blog     http://gong.gg/
 * @version  0.0.1
 * @datetime 2016-12-10T14:31:19+0800
 * @param    {[string]}     element [元素的class或id]
 * @return   {[object]}        		[josn对象]
 */
function GetFormVal(element){
	var object = {};

	// input 常用类型
	$(element).find('input[type="hidden"], input[type="text"], input[type="password"], input[type="email"],input[type="number"], input[type="date"], input[type="radio"]:checked, textarea').each(function(key, tmp)
	{
		object[tmp.name] = tmp.value;
	});

	// select 单选择和多选择
	var tmp_all = [];
	var i = 0;
	$(element).find('select option:selected').each(function(key, tmp){
		// 单选择
		var name = $(this).parent().attr('name');
		if(name != undefined && name != ''){
			object[name] = tmp.value;

			// 多选择
			if($(this).parent().attr('multiple') != undefined)
			{
				if(tmp_all[name] == undefined) tmp_all[name] = [];
				tmp_all[name][i] = tmp.value;
				i++;
			}
		}
	});
	object = ArrayTurnJson(tmp_all, object);

	// input 复选框checkboox
	tmp_all = [];
	i = 0;
	$(element).find('input[type="checkbox"]:checked').each(function(key, tmp){
		if(tmp.name != undefined && tmp.name != ''){
			if(tmp_all[tmp.name] == undefined) tmp_all[tmp.name] = [];
			tmp_all[tmp.name][i] = tmp.value;
			i++;
		}
	});
	object = ArrayTurnJson(tmp_all, object);
	return object;
}
/**
 * [ArrayTurnJson js数组转json]
 * @author   Devil
 * @blog     http://gong.gg/
 * @version  0.0.1
 * @datetime 2016-12-10T14:32:04+0800
 * @param  {[array]} 	all    	[需要被转的数组]
 * @param  {[object]} 	object 	[需要压进去的json对象]
 * @return {[object]} 			[josn对象]
 */
function ArrayTurnJson(all, object){
	for(var name in all)
	{
		var tmp_index = 0;
		for(var index in all[name])
		{
			if(typeof(object[name]) != "object") object[name] = {};
			object[name][tmp_index] = all[name][index];
			tmp_index++;
		}
	}
	return object;
}
 
function jquerySubmit(url,formId,callback1,callback2){ 
    var options = { 
        success: callback1,
        error:callback2,
        url: url,
        formId: formId,
        type: 'post',
        dataType: 'json',
        data:GetFormVal(formId)
    }; 
    //console.log($("#"+formId).serialize());
    $("#"+formId).ajaxForm(options); 
    $("#"+formId).submit();  
}
function jquerySubmit2(url,formId,callback1,callback2){ 
    var options = { 
        success: callback1,
        error:callback2,
        url: url,
        formId: formId,
        type: 'post',
        dataType: 'json'
    }; 
    //console.log($("#"+formId).serialize());
    $("#"+formId).ajaxForm(options); 
    $("#"+formId).submit();  
}
var weekNames = ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'];

Date.prototype.convertDate = function(date) {
	var flag = true;
	var dateArray = date.split("-");
	if (dateArray.length != 3) {
		dateArray = date.split("/");
		if (dateArray.length != 3) {
			return null;
		}
		flag = false;
	}
	var newDate = new Date();
	if (flag) {
		// month从0开始
		newDate.setFullYear(dateArray[0], dateArray[1] - 1, dateArray[2]);
	} else {
		newDate.setFullYear(dateArray[2], dateArray[1] - 1, dateArray[0]);
	}
	newDate.setHours(0, 0, 0);
	return newDate;
};

Date.prototype.dateAdd = function(date, days) {
	var nd = new Date(date);
	nd = nd.valueOf();
	nd = nd + days * 24 * 60 * 60 * 1000;
	nd = new Date(nd);
	var y = nd.getFullYear();
	var m = nd.getMonth() + 1;
	var d = nd.getDate();
	if (m <= 9)
		m = "0" + m;
	if (d <= 9)
		d = "0" + d;
	var cdate = y + "-" + m + "-" + d;
	return cdate;
};

/**
 * 函数：格式化日期
 * 参数：formatStr-格式化字符串
 * ss：将秒显示为带前导零的数字
 * mm：将分钟显示为带前导零的数字
 * HH：使用24小时制将小时显示为带前导零的数字
 * dd：将日显示为带前导零的数字，如01
 * MM：将月份显示为带前导零的数字，如01
 * yyyy：以四位数字格式显示年份
 * 返回：格式化后的日期
 * 
 */
Date.prototype.format = function(formatStr) {
	var date = this;
	var reg = /"[^"]*"|'[^']*'|\b(?:d{1,4}|M{1,4}|yy(?:yy)?|([hHmstT])\1?|[lLZ])\b/g;
	/*
	 * 函数：填充0字符 参数：value-需要填充的字符串, length-总长度 返回：填充后的字符串
	 */
	var zeroize = function(value, length) {
		if (!length) {
			length = 2;
		}
		value = new String(value);
		for ( var i = 0, zeros = ''; i < (length - value.length); i++) {
			zeros += '0';
		}
		return zeros + value;
	};

	function formatSplit($_) {
		switch ($_) {
		case 'dd':
			return zeroize(date.getDate());
		case 'MM':
			return zeroize(date.getMonth() + 1);
		case 'yyyy':
			return date.getFullYear();
		case 'yy':
			var fullYear = date.getFullYear();
			return new String(fullYear).substring(2);
		case 'HH':
			return zeroize(date.getHours());
		case 'mm':
			return zeroize(date.getMinutes());
		case 'ss':
			return zeroize(date.getSeconds());
		}
	}
	return formatStr.replace(reg, formatSplit);
};

//检查图片的格式是否正确,同时实现预览
function setImagePreview(obj, localImagId, imgObjPreview,width,height) {
    var array = new Array('gif', 'jpeg', 'png', 'jpg', 'bmp'); //可以上传的文件类型
    if (obj.value == '') {
        $.messager.alert("让选择要上传的图片!");
        return false;
    }
    else {
        var fileContentType = obj.value.match(/^(.*)(\.)(.{1,8})$/)[3]; //这个文件类型正则很有用 
        ////布尔型变量
        var isExists = false;
        //循环判断图片的格式是否正确
        for (var i in array) {
            if (fileContentType.toLowerCase() == array[i].toLowerCase()) {
                //图片格式正确之后，根据浏览器的不同设置图片的大小
                if (obj.files && obj.files[0]) {
                    //火狐下，直接设img属性 
                    imgObjPreview.style.display = 'block';
                    imgObjPreview.style.width = width+'px';
                    imgObjPreview.style.height = height+'px';
                    //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式 
                    imgObjPreview.src = window.URL.createObjectURL(obj.files[0]);
                }
                else {
                    //IE下，使用滤镜 
                    obj.select();
                    var imgSrc = document.selection.createRange().text;
                    //必须设置初始大小 
                    localImagId.style.width = width+'px';
                    localImagId.style.height = height+'px';
                    //图片异常的捕捉，防止用户修改后缀来伪造图片 
                    try {
                        localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                        localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader=").src = imgSrc;
                    }
                    catch (e) {
                        $.messager.alert("您上传的图片格式不正确，请重新选择!");
                        return false;
                    }
                    imgObjPreview.style.display = 'none';
                    document.selection.empty();
                }
                isExists = true;
                return true;
            }
        }
        if (isExists == false) {
            $.messager.alert("上传图片类型不正确!");
            return false;
        }
        return false;
    }
}

