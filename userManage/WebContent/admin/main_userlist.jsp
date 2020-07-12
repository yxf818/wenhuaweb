<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主要内容区main</title>
<link href="${pageContext.request.contextPath }/css/css.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/css/main.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css"/>
<link rel="shortcut icon" href="${pageContext.request.contextPath }/images/main/favicon.ico" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/main.js" type="text/javascript"></script>
<style>
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
#searchmain{ font-size:12px;}
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF; float:left}
#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(${pageContext.request.contextPath }/images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
#search a.add{ background:url(${pageContext.request.contextPath }/images/main/add.jpg) no-repeat -3px 7px #548fc9; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF; float:right}
#search a:hover.add{ text-decoration:underline; color:#d2e9ff;}
#main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
#main-tab th{ font-size:12px; background:url(${pageContext.request.contextPath }/images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
#main-tab td{ font-size:12px; line-height:40px;}
#main-tab td a{ font-size:12px; color:#548fc9;}
#main-tab td a:hover{color:#565656; text-decoration:underline;}
.bordertop{ border-top:1px solid #ebebeb}
.borderright{ border-right:1px solid #ebebeb}
.borderbottom{ border-bottom:1px solid #ebebeb}
.borderleft{ border-left:1px solid #ebebeb}
.gray{ color:#dbdbdb;}
.mydialog{ width: 300px; height: 300px; margin: 0 auto; display: none; background-color: #ffffff; position: fixed; top: 40%; left: 50%; margin: -120px 0 0 -150px; z-index: 10000; border: 1px solid #ccc; border-radius: 10px; -webkit-border-radius: 10px; box-shadow: 3px 2px 4px rgba(0,0,0,0.2); -webkit-box-shadow: 3px 2px 4px rgba(0,0,0,0.2); }
td.fenye{position:fixed; bottom:10px;right:10px; padding:10px 0 0 0; text-align:right;}
.bggray{ background:#f9f9f9}

</style>
</head>
<body>

<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：用户管理</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
         </td>
  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="${pageContext.request.contextPath }/admin/main_adduser.jsp" target="mainFrame" onFocus="this.blur()" class="add">新增用户       </a></td>
  		</tr>
	</table>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
      <div class="box">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
  
      <tr>
        <th align="center" valign="middle" class="borderright">编号</th>
        <th align="center" valign="middle" class="borderright">帐号</th>
        <th align="center" valign="middle" class="borderright">密码</th>
        <th align="center" valign="middle" class="borderright">昵称</th>
        <th align="center" valign="middle" class="borderright">联系方式</th>
        <th align="center" valign="middle" class="borderright">激活状态</th>
        <th align="center" valign="middle">操作</th>
      </tr>
      
      <c:forEach items="${usee }" var="user">
	   
      <tr id="${user.uid }" onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">${fn:substring(user.uid,26,32)}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${user.username }</td>
        <td id="td1_${user.uid }" align="center" valign="middle" class="borderright borderbottom">${user.password }</td>
        <td id="td2_${user.uid }" align="center" valign="middle" class="borderright borderbottom">${user.name }</td>
        <td id="td3_${user.uid }" align="center" valign="middle" class="borderright borderbottom">${user.telephone }</td>
        <td id="td4_${user.uid }" align="center" valign="middle" class="borderright borderbottom"><c:if test="${user.state == 0}"><a href="javascript:updateState('${user.uid }')"  title="点击激活">未激活</a></c:if><c:if test="${user.state == 1}">已激活</c:if></td>
        <td align="center" valign="middle" class="borderbottom"><a href="javascript:edit('${user.uid }');" target="mainFrame" class="bounceIn">编辑</a><span class="gray">&nbsp;|&nbsp;</span><a href="javascript:deleteUser('${user.uid }')" target="mainFrame" onFocus="this.blur()" class="add">删除</a></td>
      </tr>
      <div id="dialogBg"></div>
		<div id="dialog_${user.uid }" class="mydialog" >
			<img class="dialogIco" width="50" height="50" src="${pageContext.request.contextPath }/images/ico.png" alt="" />
			<div class="dialogTop">
				<a href="javascript:;" class="claseDialogBtn">关闭</a>
			</div>
			<form id="editForm_${user.uid }">
				<input type="hidden" name="uid" value="${user.uid }">
				<ul class="editInfos">
					<li><label><font color="#ff0000">* </font>用户名：<input type="text" name="username" required disabled value="${user.username }" class="ipt" /></label></li>
					<li><label><font color="#ff0000">* </font>密码：<input type="text" id="li1_${user.uid }" name="password" required value="${user.password }" class="ipt" /></label></li>
					<li><label><font color="#ff0000">* </font>昵称：<input type="text" id="li2_${user.uid }" name="name" required value="${user.name }" class="ipt" /></label></li>
					<li><label><font color="#ff0000">* </font>出生日期：<input type="date" name="birthday" required value="${user.birthday }" class="ipt" /></label></li>
					<li><label><font color="#ff0000">* </font>手机号：<input type="text" id="li3_${user.uid }" name="telephone" required value="${user.telephone }" class="ipt" /></label></li>
					<li><input type="button" value="确认修改" onclick="formSubmit('${user.uid }')" class="submitBtn" /></li>
				</ul>
			</form>
		</div>
      </c:forEach>
     
    </table>
     </div>
    </td>
    </tr>
  <tr>
    <td align="left" valign="top" class="fenye">11 条数据 1/1 页&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">首页</a>&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">尾页</a></td>
  </tr>
</table>
</body>
</html>