<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<script type="text/javascript" src="jslib/jquery-easyui-1.3.1/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="jslib/jquery-easyui-1.3.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jslib/jquery-easyui-1.3.1/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="jslib/jquery-easyui-1.3.1/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="jslib/jquery-easyui-1.3.1/themes/icon.css" type="text/css"></link>
<script type="text/javascript" src="jslib/szxutil.js"></script>
</head>

<body class="easyui-layout">
	<div data-options="region:'north'" style="height: 60px;">
		<jsp:include page="layout/north.jsp"></jsp:include>
	</div>
	<div data-options="region:'south'" style="height: 20px;"></div>
	<div data-options="region:'west'" style="width: 200px;">
		<jsp:include page="layout/west.jsp"></jsp:include>
	</div>
	<div data-options="region:'east',title:'east',split:true" style="width: 200px;"></div>
	<div data-options="region:'center',title:'center'" style="overflow: hidden;">
		<jsp:include page="layout/center.jsp"></jsp:include>
	</div>
	<jsp:include page="user/login.jsp"></jsp:include>
	<jsp:include page="user/regist.jsp"></jsp:include>
</body>
</html>
