<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*;import java.text.*;"%>
<script type="text/javascript">
	$('#user_moneycontrol_datagrid').datagrid({
		url : '${pageContext.request.contextPath}/user/moneyIncomeExpenditureAction!datagrid.action',
		fit : true,
		fitColumns : true,
		border : false,
		pagination : true,
		idField : 'id',
		pageSize : 30,
		pageList : [ 30, 90, 120, 150, 180 ],
		checkOnSelect : false,
		selectOnCheck : false,
		frozenColumns : [ [ {
			field : 'id',
			title : '编号',
			width : 150,
			checkbox : true
		}, {
			field : 'incomeExpenditureDatetime',
			title : '收支日期',
			width : 150,
		} ] ],
		columns : [ [ {
			field : 'incomeExpenditureCategory',
			title : '收支大类',
			width : 150,
		}, {
			field : 'incomeExpenditureSubdivision',
			title : '收支小类',
			width : 150,
		}, {
			field : 'incomeExpenditureAmount',
			title : '收支金额',
			width : 150,
		} ] ],
		toolbar : [ {
			text : '增加',
			iconCls : 'icon-add',
			handler : function() {
				append();
			}
		}, '-', {
			text : '删除',
			iconCls : 'icon-remove',
			handler : function() {
				remove();
			}
		}, '-', {
			text : '修改',
			iconCls : 'icon-edit',
			handler : function() {
				editFun();
			}
		}, '-', {
			text : '求和',
			iconCls : 'icon-sum',
			handler : function() {
				sumFun();
			}
		} ]
	});
	function searchFun() {
		$('#user_moneycontrol_datagrid').datagrid('load', serializeObject($('#user_moneycontrol_searchForm')));
	}
	function clearFun() {
		$('#user_moneycontrol_layout input').val('');
		$('#user_moneycontrol_datagrid').datagrid('load', {});
	}
	function append() {
		$('#user_moneycontrol_addForm input').val('');
		$('#addForm_incomeExpenditureSubdivision').combobox('loadData', []);
		$('#user_moneycontrol_addDialog').dialog('open');
	}
	function remove() {
		var rows = $('#user_moneycontrol_datagrid').datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
				if (r) {
					for (var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
						type : "POST",
						url : '${pageContext.request.contextPath}/user/moneyIncomeExpenditureAction!remove.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(r) {
							$('#user_moneycontrol_datagrid').datagrid('load');
							$('#user_moneycontrol_datagrid').datagrid('unselectAll');
							$.messager.show({
								title : '提示',
								msg : r.msg
							});
						}
					});
				}
			});
		} else {
			$.messager.show({
				title : '提示',
				msg : '请勾选要删除的记录！'
			});
		}
	}
	function editFun() {
		var rows = $('#user_moneycontrol_datagrid').datagrid('getChecked');
		if (rows.length == 1) {
			var d = $('<div/>').dialog({
				width : 500,
				height : 250,
				href : '${pageContext.request.contextPath}/user/moneycontroledit.jsp',
				modal : true,
				title : '编辑用户收支信息',
				buttons : [ {
					text : '编辑',
					iconCls : 'icon-edit',
					handler : function() {
						$('#user_moneycontroledit_editForm').form('submit', {
							url : '${pageContext.request.contextPath}/user/moneyIncomeExpenditureAction!edit.action',
							success : function(data) {
								var obj = jQuery.parseJSON(data);
								if (obj.success) {
									d.dialog('close');
									$('#user_moneycontrol_datagrid').datagrid('updateRow', {
										index : $('#user_moneycontrol_datagrid').datagrid('getRowIndex', rows[0]),
										row : obj.obj
									});
								}
								$.messager.show({
									title : '提示',
									msg : obj.msg
								});
							}
						});
					}
				} ],
				onClose : function() {
					$(this).dialog('destroy');
				},
				onLoad : function() {
					$('#user_moneycontroledit_editForm').form('load', rows[0]);
				}
			});
		} else {
			$.messager.alert('提示', '请勾选要编辑的记录！');
		}
	}
	function sumFun() {
		var rows = $('#user_moneycontrol_datagrid').datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要对所选记录中的收支金额进行求和操作？', function(r) {
				if (r) {
					for (var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
						type : "POST",
						url : '${pageContext.request.contextPath}/user/moneyIncomeExpenditureAction!sum.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(r) {
							$.messager.show({
								title : '提示',
								msg : r.msg
							});
							$('#user_moneycontrol_sumDialog').html('<h2>总和为：￥' + r.obj + '</h2>');
							$('#user_moneycontrol_sumDialog').dialog('open');
							
						}
					});
					$('#user_moneycontrol_sumDialog').dialog({
						onClose : function() {
							$('#user_moneycontrol_datagrid').datagrid('uncheckAll');
						}
					});
				}
				
			});
		} else {
			$.messager.show({
				title : '提示',
				msg : '请勾选要求和的记录！'
			});
		}
	}
</script>
<div id="user_moneycontrol_layout" class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',title:'查询条件',border:false" style="height: 100px;">
		<form id="user_moneycontrol_searchForm">
			按日期检索（查询）：&nbsp;从&nbsp;<input id="incomeExpenditureDatetimeStart" name="incomeExpenditureDatetimeStart" type="text" class="easyui-datebox" data-options="required:true" editable="false">&nbsp;至&nbsp;<input id="incomeExpenditureDatetimeEnd" name="incomeExpenditureDatetimeEnd" type="text" class="easyui-datebox" data-options="required:true" editable="false">&nbsp;<a id="user_moneycontrol_search_btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true,disabled:false" onclick="searchFun();">查询</a>&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="clearFun();">清空</a>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table id="user_moneycontrol_datagrid"></table>
	</div>
</div>
<div id="user_moneycontrol_addDialog" class="easyui-dialog" data-options="closed:true,modal:true,title:'添加收支记录',buttons:[{
			text : '增加',
			iconCls : 'icon-add',
			handler : function() {
				$('#user_moneycontrol_addForm').form('submit',{
					url:'${pageContext.request.contextPath}/user/moneyIncomeExpenditureAction!add.action',
					success:function(data){
						var obj = jQuery.parseJSON(data);
						if (obj.success) {
							$('#user_moneycontrol_datagrid').datagrid('insertRow',{
								index: 0,
								row: obj.obj
							});
							$('#user_moneycontrol_addDialog').dialog('close');
						}
						$.messager.show({
							title : '提示',
							msg : obj.msg
						});
					}
				});
			}
		}]" style="width: 500px; height: 300px;" align="center">
	<form id="user_moneycontrol_addForm" method="post">
		<table>
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
					$('#addForm_incomeExpenditureSubdivision').combobox('clear');
					var url = '${pageContext.request.contextPath}/user/moneyIncomeExpenditureAction!getSubdivisions.action?id=' + rec.id;
					$('#addForm_incomeExpenditureSubdivision').combobox('reload', url);
					$('#incomeExpenditureCategory').combobox('setValue', rec.text);
				}"></td>
				<th>收支小类</th>
				<td><input id="addForm_incomeExpenditureSubdivision" class="easyui-combobox" name="incomeExpenditureSubdivision" editable="false" data-options="required:true,valueField:'id',textField:'text',
				onSelect : function(rec) {
					$('#addForm_incomeExpenditureSubdivision').combobox('setValue', rec.text);
				}"></td>
			</tr>
			<tr>
				<th>收支金额</th>
				<td><input name="incomeExpenditureAmount" class="easyui-validatebox" data-options="required:true, validType: 'verifyIncomeExpenditureAmount'" /></td>
			</tr>
		</table>
	</form>
</div>
<div id="user_moneycontrol_sumDialog" class="easyui-dialog" data-options="closed:true,modal:true,title:'求和'" style="width: 500px; height: 300px;" align="center"></div>
