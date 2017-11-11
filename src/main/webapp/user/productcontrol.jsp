<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$('#user_productcontrol_datagrid').datagrid({
		url : '${pageContext.request.contextPath}/user/productAction!datagrid.action',
		fit : true,
		fitColumns : true,
		border : false,
		pagination : true,
		idField : 'id',
		pageSize : 15,
		pageList : [ 15, 30, 45 ],
		checkOnSelect : false,
		selectOnCheck : false,
		frozenColumns : [ [ {
			field : 'id',
			title : '编号',
			width : 150,
			checkbox : true
		}, {
			field : 'userRealName',
			title : '姓名',
			width : 50,
		}, {
			field : 'purchaseDatatime',
			title : '存取日期',
			width : 150,
		} ] ],
		columns : [ [ {
			field : 'productName',
			title : '产品名称',
			width : 150,
		}, {
			field : 'productStatus',
			title : '存取状态',
			width : 150,
		}, {
			field : 'purchaseAmount',
			title : '存取数量',
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
		}, '-' ]
	});
	function searchFun() {
		$('#user_productcontrol_datagrid').datagrid('load', serializeObject($('#user_productcontrol_searchForm')));
	}
	function clearFun() {
		$('#user_productcontrol_layout input[name=name]').val('');
		$('#user_productcontrol_datagrid').datagrid('load', {});
	}
	function append() {
		$('#user_productcontrol_addForm input').val('');
		$('#user_productcontrol_addDialog').dialog('open');
	}
	function remove() {
		var rows = $('#user_productcontrol_datagrid').datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
				if (r) {
					for (var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
						type : "POST",
						url : '${pageContext.request.contextPath}/user/productAction!remove.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(r) {
							$('#user_productcontrol_datagrid').datagrid('load');
							$('#user_productcontrol_datagrid').datagrid('unselectAll');
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
		var rows = $('#user_productcontrol_datagrid').datagrid('getChecked');
		if (rows.length == 1) {
			var d = $('<div/>').dialog({
				width : 500,
				height : 250,
				href : '${pageContext.request.contextPath}/user/productcontroledit.jsp',
				modal : true,
				title : '编辑用户信息',
				buttons : [ {
					text : '编辑',
					iconCls : 'icon-edit',
					handler : function() {
						$('#user_productcontroledit_editForm').form('submit', {
							url : '${pageContext.request.contextPath}/user/productAction!edit.action',
							success : function(data) {
								var obj = jQuery.parseJSON(data);
								if (obj.success) {
									d.dialog('close');
									$('#user_productcontrol_datagrid').datagrid('updateRow', {
										index : $('#user_productcontrol_datagrid').datagrid('getRowIndex', rows[0]),
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
					$('#user_productcontroledit_editForm').form('load', rows[0]);
				}
			});
		} else {
			$.messager.alert('提示', '请勾选要编辑的记录！');
		}
	}
</script>
<div id="user_productcontrol_layout" class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',title:'查询条件',border:false" style="height: 100px;">
		<form id="user_productcontrol_searchForm">
			检索存取状态（查询）: <input name="productStatus" class="easyui-combobox" editable="false" data-options="valueField: 'label',textField: 'value',data: [{label: 'i',value: '存入'},{label: 'e',value: '取出'}],panelHeight:'auto',panelWidth:'150'"><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table id="user_productcontrol_datagrid"></table>
	</div>
</div>
<div id="user_productcontrol_addDialog" class="easyui-dialog" data-options="closed:true,modal:true,title:'添加用户',buttons:[{
			text : '增加',
			iconCls : 'icon-add',
			handler : function() {
				$('#user_productcontrol_addForm').form('submit',{
					url:'${pageContext.request.contextPath}/user/productAction!add.action',
					success:function(data){
						var obj = jQuery.parseJSON(data);
						if (obj.success) {
							$('#user_productcontrol_datagrid').datagrid('insertRow',{
								index: 0,
								row: obj.obj
							});
							$('#user_productcontrol_addDialog').dialog('close');
						}
						$.messager.show({
							title : '提示',
							msg : obj.msg
						});
					}
				});
			}
		}]" style="width: 500px; height: 300px;" align="center">
	<form id="user_productcontrol_addForm" method="post">
		<table>
			<tr>
				<th>存取日期</th>
				<td><input class="easyui-datetimebox" name="purchaseDatatime" editable="false" data-options="required:true,showSeconds:true" style="width: 150px"></td>
				<th>产品名称</th>
				<td><input name="productName" class="easyui-combobox" editable="false" data-options="valueField: 'label',textField: 'value',data: [
				{label: '蛋白混合饮料',value: '蛋白混合饮料',},
				{label: '普莱乐奶昔伴侣',value: '普莱乐奶昔伴侣'},
				{label: '蔓越莓蓝莓越橘胶囊',value: '蔓越莓蓝莓越橘胶囊'},
				{label: 'B族维生素片',value: 'B族维生素片'},
				{label: '维生素C含片',value: '维生素C含片'},
				{label: '田园蔬果营养片',value: '田园蔬果营养片'},
				{label: '燃脂美维康宝片',value: '燃脂美维康宝片'},
				{label: '科迪赛胶囊',value: '科迪赛胶囊'},
				{label: '芦荟营养粉',value: '芦荟营养粉'},
				{label: '奈沃科粉',value: '奈沃科粉'},
				{label: '葡萄籽灵芝孢子粉胶囊',value: '葡萄籽灵芝孢子粉胶囊'},
				{label: '营养蛋白粉',value: '营养蛋白粉'},
				{label: '纤维素片-燃脂美美纤宝',value: '纤维素片-燃脂美美纤宝'},
				{label: '维迪片',value: '维迪片'},
				{label: '草本浓缩速溶茶饮',value: '草本浓缩速溶茶饮'},
				{label: '草本膳食纤维粉',value: '草本膳食纤维粉'},
				{label: '强力大蒜素片',value: '强力大蒜素片'}
				],panelHeight:'auto',panelWidth:'150'"></td>
			</tr>
			<tr>
				<th>存取状态</th>
				<td><input name="productStatus" class="easyui-combobox" editable="false" data-options="valueField: 'label',textField: 'value',data: [{label: 'i',value: '存入'},{label: 'e',value: '取出'}],panelHeight:'auto',panelWidth:'150'" /></td>
				<th>存取数量</th>
				<td><input name="purchaseAmount" class="easyui-validatebox" data-options="required:true, validType: 'verifyPurchaseAmount'" /></td>
			</tr>
		</table>
	</form>
</div>
