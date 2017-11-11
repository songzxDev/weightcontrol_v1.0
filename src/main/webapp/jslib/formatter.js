function formatter() {
	$('#user_moneycontrol_addForm').form('submit', {
				valueField : 'id',
				textField : 'text',
				url : '${pageContext.request.contextPath}/user/moneyIncomeExpenditureAction!getCategorys.action',
				onBeforeLoad : function(param) {
					$('#incomeExpenditureSubdivision').combobox('clear');
				},
				onSelect : function(rec) {
					$('#incomeExpenditureSubdivision').combobox('clear');
					var url = '${pageContext.request.contextPath}/user/moneyIncomeExpenditureAction!getSubdivisions.action?id=' + rec.id;
					$('#incomeExpenditureSubdivision').combobox('reload', url);
					$('#incomeExpenditureCategory').combobox('setValue', rec.text);
					$('#incomeExpenditureSubdivision').removeAttr('disabled');
				}
			});
}