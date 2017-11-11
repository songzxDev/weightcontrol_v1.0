<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	function addTab(opts) {
		var t = $('#layout_center_tabs');
		if (t.tabs('exists', opts.title)) {
			t.tabs('select', opts.title);
		} else {
			t.tabs('add', opts);
		}
	}
</script>
<style>
.demo {
	font-size: 30px;
	font-weight: bold;
	font-family: monospace;
	color: green;
}
</style>
<div id="layout_center_tabs" class="easyui-tabs" data-options="fit:true,border:false" style="overflow: hidden;">
	<div title="首页" data-options="closable:true" style="padding: 10px">
		<p style="font-size: 45px">健康的六大要素.</p>
		<p style="font-size: 25px; color: green;">今天你喝奶昔了吗.</p>
		<ul>
			<li class="demo">一、均衡营养.</li>
			<li class="demo">二、标准的体脂肪.</li>
			<li class="demo">三、充足水分.</li>
			<li class="demo">四、充足睡眠.</li>
			<li class="demo">五、适当运动.</li>
			<li class="demo">六、愉悦的心情.</li>
		</ul>
		<p style="font-size: 25px; color: green;">今天你喝奶昔了吗.</p>
	</div>
</div>
