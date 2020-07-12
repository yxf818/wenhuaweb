function imgPreview(fileDom){
    //判断是否支持FileReader
    if (window.FileReader) {
        var reader = new FileReader();
    } else {
        alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
    }
    //获取文件
    var file = fileDom.files[0];
    var imageType = /^image\//;
    //是否是图片
    if (!imageType.test(file.type)) {
        alert("请选择图片！");
        return;
    }
    //读取完成
    reader.onload = function(e) {
        //获取图片dom
        var img = document.getElementById("pic");
        //图片路径设置为读取的图片
        img.src = e.target.result;
    };
    reader.readAsDataURL(file);
}
/*
 * 用户操作js
 */
function deleteUser(id){
	var url = "aduser?method=deleteUser";
	if(confirm("确定要损失此用户？")){
			$.ajax({
				url:url,
				type:"post",
				data:{"uid" :id},
				dataType: "json",
				 success: function (data) {
	                if (data.msg == "ok") {
	                    $("#" + id).remove();
	                }
				 }
			})
	}
}
function updateState(id){
	var url = "aduser?method=updateState";
		$.ajax({
			url:url,
			type:"post",
			data:{"uid" :id},
			dataType: "json",
			 success: function (data) {
                if (data.msg == "ok") {
                	 $("#td4_"+id).text("已激活");
                }
			 }
		})
	}


	var w,h,className;
	function getSrceenWH(){
		w = $(window).width();
		h = $(window).height();
		$('#dialogBg').width(w).height(h);
	}
	
	window.onresize = function(){  
		getSrceenWH();
	}  
	$(window).resize();  

	function edit(uid){
		getSrceenWH();
		
		//显示弹框
		//$('.bounceIn').click(function(){
			
			className = $(this).attr('class');
			$('#dialogBg').fadeIn(300);
			$("#dialog_"+uid).removeAttr('class').addClass('animated bounceIn mydialog').fadeIn();
			
		//});
			//关闭弹窗
    		$('.claseDialogBtn').click(function(){
    			$('#dialogBg').fadeOut(300,function(){
    				$("#dialog_"+uid).addClass('bounceOutUp').fadeOut();
    				
    			});
    		});
	}
	function formSubmit(id){
		var url = "aduser?method=update";
		$.ajax({
			url:url,
			type:"post",
			data:$("#editForm_"+id).serialize(),
			dataType: "json",
			 success: function (data) {
	            if (data.msg == "200") {
	            	$('#dialogBg').fadeOut(300,function(){
	    				$("#dialog_"+id).addClass('bounceOutUp').fadeOut();
	    			});
	                $("#td1_"+id).text($("#li1_"+id).val());
	                $("#td2_"+id).text($("#li2_"+id).val());
	                $("#td3_"+id).text($("#li3_"+id).val());
	            }
			 }
		})
	}	
	
	//<---------------------------------------------->
	/*
	 * 管理员
	 */
	function deleteAdmin(id,power){
		var url = "aduser?method=deleteAdmin";
		if(confirm("确定要删除此人所有信息？")){
			if(power == 2){
				$.ajax({
					url:url,
					type:"post",
					data:{"adminid" :id},
					dataType: "json",
					
					 success: function (data) {
		                if (data.msg == "删除成功") {
		                    $("#" + id).remove();
		                }
		            }
				})
			}else{
				alert("对不起，您的操作权限不够！！");
			}
		}
	}

	function adedit(id){
		getSrceenWH();
		
		//显示弹框
			$("#dialogBg").fadeIn(300);
			$("#dialog_"+id).removeAttr('animated').addClass('animated flipInX dialog').fadeIn();
		
		//关闭弹窗
		$('.claseDialogBtn').click(function(){
			$('#dialogBg').fadeOut(300,function(){
				$("#dialog_"+id).addClass('bounceOutUp ').fadeOut();
			});
		});
	}
	function formSub(id) {
		var url = "aduser?method=updataAdmin";
		$.ajax({
			url:url,
			type:"post",
			data:$("#editForm_"+id).serialize(),
			dataType:"json",
				success : function (data) {
					if(data.msg == "200"){
						$('#dialogBg').fadeOut(300,function(){
							$("#dialog_"+id).addClass('bounceOutUp').fadeOut();
						});
		                $("#td1_"+id).text($("#in1_"+id).val());
		                $("#td2_"+id).text($("#in2_"+id).val());
					}
				}
		})
	}
	
	//-------------------------------------------
	//分类管理
	
	function delCategory(id,power){
		var url = "adcategory?method=delCategory";
		if(confirm("确定要删除此分类信息？")){
			if(power == 2){
				$.ajax({
					url:url,
					type:"post",
					data:{"cid" :id},
					dataType: "json",
					 success: function (data) {
		                if (data.msg == "200") {
		                    $("#" + id).remove();
		                }
		            }
				})
			}else{
				alert("对不起，您没有此操作的权限！！");
			}
		}
	}
	function formCaSubmit(id){
		var url = "adcategory?method=updateCategory";
		$.ajax({
			url:url,
			type:"post",
			data:$("#editForm_"+id).serialize(),
			dataType: "json",
			 success: function (data) {
	            if (data.msg == "200") {
	            	$('#dialogBg').fadeOut(300,function(){
	    				$("#dialog_"+id).addClass('bounceOutUp ').fadeOut();
	    			});
	                $("#td1_"+id).text($("#in1_"+id).val());
	            }
			 }
		})
	}	
	
	//-------------------------------------------
	//商品管理
	function adedit(id){
		getSrceenWH();
		
		//显示弹框
			$("#dialogBg").fadeIn(300);
			$("#dialog_"+id).removeAttr('animated').addClass('animated flipInX dialog').fadeIn();
		
		//关闭弹窗
		$('.claseDialogBtn').click(function(){
			$('#dialogBg').fadeOut(300,function(){
				$("#dialog_"+id).addClass('bounceOutUp ').fadeOut();
			});
		});
	}
			var objUrl;
			$(function() {
				$("#pic").click(function() {
					$("#previewImg").on("change", function() {
						objUrl = getObjectURL(this.files[0]); //获取图片的路径，该路径不是图片在本地的路径
						if (objUrl) {
							$("#pic").attr("src", objUrl); //将图片路径存入src中，显示出图片
						}
					});
				});
			});

			//建立一個可存取到該file的url
			function getObjectURL(file) {
				var url = null;
				if (window.createObjectURL != undefined) { // basic
					url = window.createObjectURL(file);
				} else if (window.URL != undefined) { // mozilla(firefox)
					url = window.URL.createObjectURL(file);
				} else if (window.webkitURL != undefined) { // webkit or chrome
					url = window.webkitURL.createObjectURL(file);
				}
				return url;
			}
	
	
	
	
	
	