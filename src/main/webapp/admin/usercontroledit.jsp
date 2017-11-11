<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="admin_usercontroledit_editForm" method="post">
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
			<td><input name="gender" class="easyui-validatebox" data-options="required:true" />
			</td>
			<th>登录状态</th>
			<td><input name="loginStatus" readonly="readonly" />
			</td>
		</tr>
	</table>
</form>
