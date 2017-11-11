<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$('#admin_rolecontrol_datagrid').datagrid({
		url : '${pageContext.request.contextPath}/role/roleAction!datagrid.action',
		fit : true,
		fitColumns : true,
		border : false,
		pagination : true,
		idField : 'id',
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		sortName : 'roleName',
		sortOrder : 'desc',
		checkOnSelect : false,
		selectOnCheck : false,
		columns : [ [ {
			field : 'id',
			title : '编号',
			width : 150
		}, {
			field : 'roleName',
			title : '角色名称',
			width : 150
		}, {
			field : 'roleText',
			title : '角色描述',
			width : 150,
		} ] ],
		toolbar : [ {
			text : '增加',
			iconCls : 'icon-add',
			handler : function() {
			}
		}, '-', {
			text : '删除',
			iconCls : 'icon-remove',
			handler : function() {
			}
		}, '-', {
			text : '修改',
			iconCls : 'icon-edit',
			handler : function() {
			}
		}, '-' ]
	});
</script>
<div id="admin_rolecontrol_layout" class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',title:'查询条件',border:false" style="height: 100px;">
		<form id="admin_rolecontrol_searchForm">
			检索角色名称(可模糊查询): <input name="roleName" /> <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="">查询</a> <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="">清空</a>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table id="admin_rolecontrol_datagrid"></table>
	</div>
</div>