<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$('#user_productamountcontrol_datagrid').datagrid({
		url : '${pageContext.request.contextPath}/user/productAction!productAmountDatagrid.action',
		fit : true,
		fitColumns : true,
		border : true,
		pagination : false,
		idField : 'id',
		checkOnSelect : false,
		selectOnCheck : false,
		frozenColumns : [ [ {
			field : 'id',
			title : '编号',
			width : 50,
		},{
			field : 'currentDatetime',
			title : '日期',
			width : 150,
		}, {
			field : 'userRealName',
			title : '姓名',
			width : 50,
		}] ],
		columns : [ [ {
			field : 'productName',
			title : '产品名称',
			width : 150,
		}, {
			field : 'productIncomeAmounts',
			title : '存入总数',
			width : 150,
		} , {
			field : 'productExpenseAmounts',
			title : '取出总数',
			width : 150,
		}, {
			field : 'productRemainingAmounts',
			title : '剩余总数',
			width : 150,
		}] ]
	});
</script>
<div id="user_productamountcontrol_layout" class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',title:'查询条件',border:false" style="height: 100px;">
		<form id="user_productamountcontrol_searchForm">
			检索用户名称(可模糊查询): <input name="name" /> <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a> <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="clearFun();">清空</a>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table id="user_productamountcontrol_datagrid"></table>
	</div>
</div>
