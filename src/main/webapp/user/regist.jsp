<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	$(function() {
		$('#user_regist_regForm').form({
			url : '${pageContext.request.contextPath}/user/userAction!regist.action',
			success : function(data) {
				var obj = jQuery.parseJSON(data);
				if (obj.success) {
					$('#user_regist_regDialog').dialog('close');
				}
				$.messager.show({
					title : '提示',
					msg : obj.msg
				});
			}
		});
		$('#user_regist_regForm input').bind('keyup', function(event) {
			if (event.keyCode == '13') {
				$('#user_regist_regForm').submit();
			}
		});
	});
</script>
<div id="user_regist_regDialog" style="width: 240px;" class="easyui-dialog" data-options="title:'注册',closed:true,modal:true,
			buttons:[{
				text:'注册',
				iconCls:'icon-edit',
				handler:function(){
					$('#user_regist_regForm').submit();
				}
			}]">
	<form id="user_regist_regForm" method="post">
		<table>
			<tr>
				<th>登录名</th>
				<td><input type="text" id="username" name="username" class="easyui-validatebox" data-options="required:true,missingMessage:'用户名为必填项'" /></td>
			</tr>
			<tr>
				<th>姓名</th>
				<td><input type="text" id="name" name="name" class="easyui-validatebox" data-options="required:true,missingMessage:'姓名为必填项'" /></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input type="password" id="pwd" name="password" class="easyui-validatebox" data-options="required:true,missingMessage:'密码为必填项'" /></td>
			</tr>
			<tr>
				<th>重复密码</th>
				<td><input type="password" id="repwd" name="repwd" class="easyui-validatebox" data-options="required:true,validType:'eqPwd[\'#user_regist_regForm input[name=password]\']'" /></td>
			</tr>
			<tr>
				<th>性别</th>
				<td><input name="sex" class="easyui-combobox" data-options="valueField: 'label',textField: 'value',data: [{label: 'm',value: '男性',},{label: 'f',value: '女性'},{label: 'l',value: '中性'}],panelHeight:'auto'"></td>
			</tr>
		</table>
	</form>
</div>
