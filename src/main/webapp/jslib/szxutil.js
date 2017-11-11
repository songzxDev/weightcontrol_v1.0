/**
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI
 * 
 * 扩展validatebox，添加验证两次密码功能
 */
$.extend($.fn.validatebox.defaults.rules, {
			eqPwd : {
				validator : function(value, param) {
					return value == $(param[0]).val();
				},
				message : '密码不一致！'
			},
			verifyIncomeExpenditureAmount : {
				validator : function(value, param) {
					var exp = "^(-?\\d+)(\\.\\d+)?$";
					return value.match(exp);
				},
				message : '请输入数字类型.'
			},
			verifyPurchaseAmount : {
				validator : function(value, param) {
					var exp = "^\\d+$";
					return value.match(exp);
				},
				message : '请输入正整数类型的数值.'
			},
			verifyIncomeExpenditureDatetimeStart : {
				validator : function(value, param) {
					if (value != null && typeof(value) != 'undefined' && value != 0 && typeof(value) != '') {
						$('#incomeExpenditureDatetimeEnd').datebox({
									disabled : false
								});
						return true;
					} else {
						$('#incomeExpenditureDatetimeEnd').datebox({
									disabled : true
								});
						return false;
					}
				},
				message : '请选择结束日期之前的日期.'
			},
			verifyIncomeExpenditureDatetimeEnd : {
				validator : function(value, param) {
					if (value != null && typeof(value) != 'undefined' && value != 0 && typeof(value) != '' && value >= $(param[0]).val() == true) {
						$('#user_moneycontrol_search_btn').linkbutton('enable');
					} else {
						$('#user_moneycontrol_search_btn').linkbutton('disable');
					}
					return value >= $(param[0]).val();
				},
				message : '请选择起始日期之后的日期.'
			}
		});

$.fn.tree.defaults.loadFilter = function(data, parent) {
	var opt = $(this).data().tree.options;
	var idFiled, textFiled, parentField;
	if (opt.parentField) {
		idFiled = opt.idFiled || 'id';
		textFiled = opt.textFiled || 'text';
		parentField = opt.parentField;
		var i, l, treeData = [], tmpMap = [];
		for (i = 0, l = data.length; i < l; i++) {
			tmpMap[data[i][idFiled]] = data[i];
		}
		for (i = 0, l = data.length; i < l; i++) {
			if (tmpMap[data[i][parentField]] && data[i][idFiled] != data[i][parentField]) {
				if (!tmpMap[data[i][parentField]]['children'])
					tmpMap[data[i][parentField]]['children'] = [];
				data[i]['text'] = data[i][textFiled];
				tmpMap[data[i][parentField]]['children'].push(data[i]);
			} else {
				data[i]['text'] = data[i][textFiled];
				treeData.push(data[i]);
			}
		}
		return treeData;
	}
	return data;
};

/**
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI
 * 
 * 防止panel/window/dialog组件超出浏览器边界
 * @param left
 * @param top
 */
var easyuiPanelOnMove = function(left, top) {
	var l = left;
	var t = top;
	if (l < 1) {
		l = 1;
	}
	if (t < 1) {
		t = 1;
	}
	var width = parseInt($(this).parent().css('width')) + 14;
	var height = parseInt($(this).parent().css('height')) + 14;
	var right = l + width;
	var buttom = t + height;
	var browserWidth = $(window).width();
	var browserHeight = $(window).height();
	if (right > browserWidth) {
		l = browserWidth - width;
	}
	if (buttom > browserHeight) {
		t = browserHeight - height;
	}
	$(this).parent().css({/* 修正面板位置 */
		left : l,
		top : t
	});
};
$.fn.dialog.defaults.onMove = easyuiPanelOnMove;
$.fn.window.defaults.onMove = easyuiPanelOnMove;
$.fn.panel.defaults.onMove = easyuiPanelOnMove;

/**
 * @author 孙宇
 * 
 * @requires jQuery
 * 
 * 将form表单元素的值序列化成对象
 * 
 * @returns object
 */
serializeObject = function(form) {
	var o = {};
	$.each(form.serializeArray(), function(index) {
				if (o[this['name']]) {
					o[this['name']] = o[this['name']] + "," + this['value'];
				} else {
					o[this['name']] = this['value'];
				}
			});
	return o;
};
