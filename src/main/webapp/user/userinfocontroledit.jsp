<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="user_userinfocontroledit_editForm" method="post">
	<table>
		<tr>
			<td><input name="id" readonly="readonly" style="display: none" /></td>
		</tr>
		<tr>
			<th>体检日期</th>
			<td><input class="easyui-datetimebox" name="createDatetime" editable="false" data-options="required:true,showSeconds:true" style="width: 150px"></td>
			<th>年龄（岁）</th>
			<td><input name="age" class="easyui-validatebox" data-options="required:true" /></td>
		</tr>
		<tr>
			<th>身高（厘米cm）</th>
			<td><input name="stature" class="easyui-validatebox" data-options="required:true" /></td>
			<th>体重(公斤kg)</th>
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
			<th>脏器年龄(岁)</th>
			<td><input name="organAge" class="easyui-validatebox" data-options="required:true" /></td>
		</tr>
	</table>
</form>