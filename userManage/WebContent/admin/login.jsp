<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>后台管理登录界面</title>
   
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/reset.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/text.css">
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
</head>
<script type="text/javascript">  
function change(){
	 var verifyId=document.getElementById("yzm");
	 verifyId.src="${pageContext.request.contextPath }/CodeServlet?a="+new Date().getTime();

}

function login(){
	 var user_blanknum=$('#textfield').val();
	 var user_password=$('#textfield1').val();
	 var vcode=$('#textfield2').val();
	
	
	 $.ajax({   
        url:"${pageContext.request.contextPath }/aduser", //请求验证页面   
        type:"post", //请求方式 可换为post 注意验证页面接收方式   
        data:{"method":"login","login":user_blanknum,"pwd":user_password,"vcode":vcode},//取得表文本框数据，作为提交数据 注意前面的 user 此处格式 key=value 其他方式请参考ajax手册  
        dataType:"json",  
        success: function(data)   
                { //请求成功时执行操作   
        	var iscode=data.msg;
        	 if($.trim(iscode) == $.trim("登录成功") ){
        		 	
        		 location='${pageContext.request.contextPath }/admin/index.jsp';
        	 }else{
        		 alert(iscode);
        		 change();
        	 }
        			
                	
               	
                  
                },   
        error:function(){  
                return false;  
        }  
            });   		
	
	
	
}
</script>
<body>

    <div class="main">
        <h2>后台管理系统</h2>
        <div class="inputGroup">
        
            <p>文华学院</p>
            <div><img src="./img/personal_.png" alt="" class="inputIcon"><input type="text"  id="textfield" placeholder="请输入用户名"></div>
            <div><img src="./img/password.png" alt="" class="inputIcon"><input type="text" id="textfield1" placeholder="请输入密码"></div>
            <div class="verifyCode"><img src="./img/safe.png" alt="" class="inputIcon"><input type="text" id="textfield2" placeholder="请输入验证码 "><img id="yzm" src="${pageContext.request.contextPath}/CodeServlet"  onclick="javascript:change();" class="verifyPic"></div>
            <div class="btn" onclick="javascript:login();">登录</div>
        </div>
    
    
    
</body>
</html>