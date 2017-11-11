<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="user_moneycontroledit_editForm" method="post">
	<table>
		<tr>
			<td><input name="id" readonly="readonly" style="display: none" /></td>
		</tr>
		<tr>
			<th>收支日期</th>
			<td><input class="easyui-datetimebox" name="incomeExpenditureDatetime" editable="false" data-options="required:true,showSeconds:true" style="width: 150px"></td>
		</tr>
		<tr>
			<th>收支大类</th>
			<td><input id="incomeExpenditureCategory" class="easyui-combobox" name="incomeExpenditureCategory" editable="false" data-options="required:true,
				valueField : 'id',
				textField : 'text',
				url : '${pageContext.request.contextPath}/user/moneyIncomeExpenditureAction!getCategorys.action',
				onSelect : function(rec) {
					$('#editForm_incomeExpenditureSubdivision').combobox('clear');
					var url = '${pageContext.request.contextPath}/user/moneyIncomeExpenditureAction!getSubdivisions.action?id=' + rec.id;
					$('#editForm_incomeExpenditureSubdivision').combobox('reload', url);
					$('#incomeExpenditureCategory').combobox('setValue', rec.text);
				}"></td>
			<th>收支小类</th>
			<td><input id="editForm_incomeExpenditureSubdivision" class="easyui-combobox" name="incomeExpenditureSubdivision" editable="false" data-options="required:true,valueField:'id',textField:'text',
				onSelect : function(rec) {
					$('#editForm_incomeExpenditureSubdivision').combobox('setValue', rec.text);
				}"></td>
		</tr>
		<tr>
			<th>收支金额</th>
			<td><input name="incomeExpenditureAmount" class="easyui-validatebox" data-options="required:true, validType: 'verifyIncomeExpenditureAmount'" /></td>
		</tr>
	</table>
</form>