<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	$(function() {
		$('#user_login_loginForm').form({
			url : '${pageContext.request.contextPath}/user/userAction!login.action',
			success : function(data) {
				var obj = jQuery.parseJSON(data);
				if (obj.success) {
					$('#user_login_loginDialog').dialog('close');
				}
				$.messager.show({
					title : '提示',
					msg : obj.msg
				});
			}
		});
		$('#user_login_loginForm input').bind('keyup', function(event) {
			if (event.keyCode == '13') {
				$('#user_login_loginForm').submit();
			}
		});
		window.setTimeout(function() {
			$('#user_login_loginForm input[name=username]').focus();
		}, 0);
	});
</script>
<div id="user_login_loginDialog" class="easyui-dialog" data-options="title:'登录',closable:false,modal:true,
			buttons:[{
				text:'注册',
				iconCls:'icon-edit',
				handler:function(){
					$('#user_regist_regDialog input').val('');
					$('#user_regist_regDialog').dialog('open');
				}
			},{
				text:'登录',
				iconCls:'icon-help',
				handler:function(){
					$('#user_login_loginForm').submit();
				}
			}]">
	<form id="user_login_loginForm" method="post">
		<table>
			<tr>
				<th>登录名</th>
				<td><input id="username" type="text" name="username" class="easyui-validatebox" data-options="required:true,missingMessage:'用户名为必填项'" /></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input id="password" type="password" name="password" class="easyui-validatebox" data-options="required:true,missingMessage:'密码为必填项'" /></td>
			</tr>
		</table>
	</form>
</div>
