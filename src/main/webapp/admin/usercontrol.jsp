<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$('#admin_usercontrol_datagrid').datagrid({
		url : '${pageContext.request.contextPath}/user/userAction!datagrid.action',
		fit : true,
		fitColumns : true,
		border : false,
		pagination : true,
		idField : 'id',
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		sortName : 'username',
		sortOrder : 'desc',
		checkOnSelect : false,
		selectOnCheck : false,
		frozenColumns : [ [ {
			field : 'id',
			title : '编号',
			width : 150,
			checkbox : true
		}, {
			field : 'username',
			title : '用户名',
			width : 150,
			sortable : true
		}, {
			field : 'realname',
			title : '真实姓名',
			width : 150,
			sortable : true
		}, {
			field : 'gender',
			title : '性别',
			width : 150,
			sortable : true
		} ] ],
		columns : [ [ {
			field : 'password',
			title : '密码',
			width : 150,
			formatter : function(value, row, index) {
				return '**********************';
			}
		}, {
			field : 'identityId',
			title : '身份证号码',
			width : 150,
			formatter : function(value, row, index) {
				return '**********************';
			}
		}, {
			field : 'telephoneNumber',
			title : '电话号码',
			width : 150,
			formatter : function(value, row, index) {
				return '**********************';
			}
		}, {
			field : 'createDateTime',
			title : '创建时间',
			width : 150,
			sortable : true
		}, {
			field : 'modifyDateTime',
			title : '修改时间',
			width : 150,
			sortable : true
		}, {
			field : 'loginStatus',
			title : '登录状态',
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
		$('#admin_usercontrol_datagrid').datagrid('load', serializeObject($('#admin_usercontrol_searchForm')));
	}
	function clearFun() {
		$('#admin_usercontrol_layout input[name=name]').val('');
		$('#admin_usercontrol_datagrid').datagrid('load', {});
	}
	function append() {
		$('#admin_usercontrol_addForm input').val('');
		$('#admin_usercontrol_addDialog').dialog('open');
	}
	function remove() {
		var rows = $('#admin_usercontrol_datagrid').datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
						url : '${pageContext.request.contextPath}/user/userAction!remove.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(r) {
							$('#admin_usercontrol_datagrid').datagrid('load');
							$('#admin_usercontrol_datagrid').datagrid('unselectAll');
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
		var rows = $('#admin_usercontrol_datagrid').datagrid('getChecked');
		if (rows.length == 1) {
			var d = $('<div/>').dialog({
				width : 500,
				height : 200,
				href : '${pageContext.request.contextPath}/admin/usercontroledit.jsp',
				modal : true,
				title : '编辑用户信息',
				buttons : [ {
					text : '编辑',
					iconCls : 'icon-edit',
					handler : function() {
						$('#admin_usercontroledit_editForm').form('submit', {
							url : '${pageContext.request.contextPath}/user/userAction!edit.action',
							success : function(data) {
								var obj = jQuery.parseJSON(data);
								if (obj.success) {
									d.dialog('close');
									$('#admin_usercontrol_datagrid').datagrid('updateRow', {
										index : $('#admin_usercontrol_datagrid').datagrid('getRowIndex', rows[0]),
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
					$('#admin_usercontroledit_editForm').form('load', rows[0]);
				}
			});
		} else {
			$.messager.alert('提示', '请勾选要编辑的记录！');
		}
	}
</script>
<div id="admin_usercontrol_layout" class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',title:'查询条件',border:false" style="height: 100px;">
		<form id="admin_usercontrol_searchForm">
			检索用户名称(可模糊查询): <input name="name" /> <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a> <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="clearFun();">清空</a>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table id="admin_usercontrol_datagrid"></table>
	</div>
</div>
<div id="admin_usercontrol_addDialog" class="easyui-dialog" data-options="closed:true,modal:true,title:'添加用户',buttons:[{
			text : '增加',
			iconCls : 'icon-add',
			handler : function() {
				$('#admin_usercontrol_addForm').form('submit',{
					url:'${pageContext.request.contextPath}/user/userAction!add.action',
					success:function(data){
						var obj = jQuery.parseJSON(data);
						if (obj.success) {
							$('#admin_usercontrol_datagrid').datagrid('insertRow',{
								index: 0,
								row: obj.obj
							});
							$('#admin_usercontrol_addDialog').dialog('close');
						}
						$.messager.show({
							title : '提示',
							msg : obj.msg
						});
					}
				});
			}
		}]" style="width :500px;height: 300px;" align="center">
	<form id="admin_usercontrol_addForm" method="post">
		<table>
			<tr>
				<th>编号</th>
				<td><input name="id" readonly="readonly" /></td>
				<th>登录名称</th>
				<td><input name="username" class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input name="password" type="password" class="easyui-validatebox" data-options="required:true" /></td>
				<th>创建时间</th>
				<td><input name="createDateTime" readonly="readonly" /></td>
			</tr>
			<tr>
				<th>最后修改时间</th>
				<td><input name="modifyDateTime" readonly="readonly" /></td>
				<th>真实姓名</th>
				<td><input name="realname" class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
			<tr>
				<th>身份证号码</th>
				<td><input name="identityId" class="easyui-validatebox" data-options="required:true" /></td>
				<th>电话号码</th>
				<td><input name="telephoneNumber" class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
			<tr>
				<th>性别</th>
				<td><input name="gender" class="easyui-combobox" data-options="valueField: 'label',textField: 'value',data: [{label: '男',value: '男',},{label: '女',value: '女'}],panelHeight:'auto'"></td>
				<th>登录状态</th>
				<td><input name="loginStatus" readonly="readonly" /></td>
			</tr>
		</table>
	</form>
</div>
