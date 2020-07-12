<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧导航menu</title>
<link href="${pageContext.request.contextPath }/css/css.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/sdmenu.js"></script>
<script type="text/javascript">
	// <![CDATA[
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};
	// ]]>
</script>
<style type=text/css>
html {
	SCROLLBAR-FACE-COLOR: #538ec6;
	SCROLLBAR-HIGHLIGHT-COLOR: #dce5f0;
	SCROLLBAR-SHADOW-COLOR: #2c6daa;
	SCROLLBAR-3DLIGHT-COLOR: #dce5f0;
	SCROLLBAR-ARROW-COLOR: #2c6daa;
	SCROLLBAR-TRACK-COLOR: #dce5f0;
	SCROLLBAR-DARKSHADOW-COLOR: #dce5f0;
	overflow-x: hidden;
}

body {
	overflow-x: hidden;
	background:
		url(${pageContext.request.contextPath }/images/main/leftbg.jpg) left
		top repeat-y #f2f0f5;
	width: 194px;
}
</style>
</head>
<body onselectstart="return false;" ondragstart="return false;"
	oncontextmenu="return false;">
	<div id="left-top">
		<div>
			<img src="${pageContext.request.contextPath }/images/main/member.gif"
				width="44" height="44" />
		</div>
		<span>用户：${aduser.adminame }<br>
		角色：<c:if test="${aduser.power == 1 }">信息录入员</c:if>
		<c:if test="${aduser.power == 2 }">超级管理员</c:if>
		</span>
		
	</div>
	
	<div style="float: left" id="my_menu" class="sdmenu">
		<div class="collapsed">
			<span>首页</span> 
			<a href="${pageContext.request.contextPath }/aduser?method=findMain" target="mainFrame" onFocus="this.blur()">后台首页</a>
		</div>
		<div class="collapsed">
			<span>分类管理</span> 
			<a href="javascript:;" target="mainFrame"onFocus="this.blur()">分类管理</a> 
		</div>
		<div class="collapsed">
			<span>商品管理</span> 
			<a href="javascript:;" target="mainFrame"onFocus="this.blur()">已上架商品</a> 
		</div>
		<div class="collapsed">
			<span>订单管理</span> 
			<a href="javascript:;" target="mainFrame"onFocus="this.blur()">未付款订单</a> 
			<a href="javascript:;" target="mainFrame"onFocus="this.blur()">已付款订单</a> 
			<a href="javascript:;" target="mainFrame"onFocus="this.blur()">在途订单</a> 
			<a href="javascript:;" target="mainFrame"onFocus="this.blur()">已完成订单</a> 
		</div>
		<div class="collapsed">
			<span>人员管理</span> 
			<a href="${pageContext.request.contextPath }/aduser?method=findAllUser" target="mainFrame" onFocus="this.blur()">用户管理</a>
			<a href="${pageContext.request.contextPath }/aduser?method=findAll" target="mainFrame" onFocus="this.blur()">管理人员</a> 
		</div>
	</div>
</body>
</html>