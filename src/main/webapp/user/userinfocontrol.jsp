<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$('#user_userinfocontrol_datagrid').datagrid({
		url : '${pageContext.request.contextPath}/user/userinfoAction!datagrid.action',
		fit : true,
		fitColumns : true,
		border : false,
		pagination : true,
		idField : 'id',
		pageSize : 15,
		pageList : [ 15, 30 ],
		checkOnSelect : false,
		selectOnCheck : false,
		frozenColumns : [ [ {
			field : 'id',
			title : '编号',
			width : 150,
			checkbox : true
		}, {
			field : 'createDatetime',
			title : '体检日期',
			width : 150,
			sortable : true
		}, {
			field : 'name',
			title : '姓名',
			width : 50,
			sortable : true
		}, {
			field : 'age',
			title : '年龄（岁）',
			width : 50,
			sortable : true
		}, {
			field : 'sex',
			title : '性别（男/女）',
			width : 50,
			sortable : true
		}, {
			field : 'stature',
			title : '身高（厘米cm）',
			width : 50,
			sortable : true
		} ] ],
		columns : [ [ {
			field : 'weight',
			title : '体重（公斤kg）',
			width : 150,
			sortable : true
		}, {
			field : 'bodyFat',
			title : '体脂肪',
			width : 180,
			sortable : true
		}, {
			field : 'muscleMass',
			title : '肌肉量',
			width : 150,
			sortable : true
		}, {
			field : 'boneMass',
			title : '骨量',
			width : 150,
			sortable : true
		}, {
			field : 'internalFat',
			title : '内脏脂肪',
			width : 150,
			sortable : true
		}, {
			field : 'bodyWater',
			title : '体水分',
			width : 150,
			sortable : true
		}, {
			field : 'bmi',
			title : 'BMI',
			width : 150,
			sortable : true
		}, {
			field : 'bmr',
			title : '基础代谢率',
			width : 180,
			sortable : true
		}, {
			field : 'organAge',
			title : '脏器年龄（岁）',
			width : 150,
			sortable : true
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
		}, '-' ]
	});
	function searchFun() {
	}
	function clearFun() {
	}
	function append() {
		$('#user_userinfocontrol_addForm input').val('');
		$('#user_userinfocontrol_addDialog').dialog('open');
	}
	function remove() {
		var rows = $('#user_userinfocontrol_datagrid').datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
				if (r) {
					for (var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
						type : "POST",
						url : '${pageContext.request.contextPath}/user/userinfoAction!remove.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(r) {
							$('#user_userinfocontrol_datagrid').datagrid('load');
							$('#user_userinfocontrol_datagrid').datagrid('unselectAll');
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
		var rows = $('#user_userinfocontrol_datagrid').datagrid('getChecked');
		if (rows.length == 1) {
			var d = $('<div/>').dialog({
				width : 500,
				height : 250,
				href : '${pageContext.request.contextPath}/user/userinfocontroledit.jsp',
				modal : true,
				title : '编辑用户信息',
				buttons : [ {
					text : '编辑',
					iconCls : 'icon-edit',
					handler : function() {
						$('#user_userinfocontroledit_editForm').form('submit', {
							url : '${pageContext.request.contextPath}/user/userinfoAction!edit.action',
							success : function(data) {
								var obj = jQuery.parseJSON(data);
								if (obj.success) {
									d.dialog('close');
									$('#user_userinfocontrol_datagrid').datagrid('updateRow', {
										index : $('#user_userinfocontrol_datagrid').datagrid('getRowIndex', rows[0]),
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
					$('#user_userinfocontroledit_editForm').form('load', rows[0]);
				}
			});
		} else {
			$.messager.alert('提示', '请勾选要编辑的记录！');
		}
	}
</script>
<div id="user_userinfocontrol_layout" class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',title:'查询条件',border:false" style="height: 100px;">
		<form id="user_userinfocontrol_searchForm">
			检索用户名称(可模糊查询): <input name="name" /> <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a> <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="clearFun();">清空</a>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table id="user_userinfocontrol_datagrid"></table>
	</div>
</div>
<div id="user_userinfocontrol_addDialog" class="easyui-dialog" data-options="closed:true,modal:true,title:'添加用户',buttons:[{
			text : '增加',
			iconCls : 'icon-add',
			handler : function() {
				$('#user_userinfocontrol_addForm').form('submit',{
					url:'${pageContext.request.contextPath}/user/userinfoAction!add.action',
					success:function(data){
						var obj = jQuery.parseJSON(data);
						if (obj.success) {
							$('#user_userinfocontrol_datagrid').datagrid('insertRow',{
								index: 0,
								row: obj.obj
							});
							$('#user_userinfocontrol_addDialog').dialog('close');
						}
						$.messager.show({
							title : '提示',
							msg : obj.msg
						});
					}
				});
			}
		}]" style="width: 500px; height: 300px;" align="center">
	<form id="user_userinfocontrol_addForm" method="post">
		<table>
			<tr>
				<th>体检日期</th>
				<td><input class="easyui-datetimebox" name="createDatetime" editable="false" data-options="required:true,showSeconds:true" style="width: 150px"></td>
				<th>年龄</th>
				<td><input name="age" class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
			<tr>
				<th>身高</th>
				<td><input name="stature" class="easyui-validatebox" data-options="required:true" /></td>
				<th>体重</th>
				<td><input name="weight" class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
			<tr>
				<th>体脂肪</th>
				<td><input name="bodyFat" class="easyui-validatebox" data-options="required:true" /></td>
				<th>肌肉量</th>
				<td><input name="muscleMass" class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
			<tr>
				<th>骨量</th>
				<td><input name="boneMass" class="easyui-validatebox" data-options="required:true" /></td>
				<th>内脏脂肪</th>
				<td><input name="internalFat" class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
			<tr>
				<th>体水分</th>
				<td><input name="bodyWater" class="easyui-validatebox" data-options="required:true" /></td>
				<th>BMI</th>
				<td><input name="bmi" class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
			<tr>
				<th>基础代谢率</th>
				<td><input name="bmr" class="easyui-validatebox" data-options="required:true" /></td>
				<th>脏器年龄</th>
				<td><input name="organAge" class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
		</table>
	</form>
</div>
