<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.js"></script>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css"
	charset="utf-8">
	
<title>게시판</title>
<script type="text/javascript">

$(document).ready(function() {
	$('#button1').click(function() { 
		var formData = $("#form1").serialize();
			$.ajax({
				type : "post",
				url : "Test.do",
				data: formData,
				success : function(data) {
					
					if (data==2) {
						$("#inputpasswd").removeAttr("style");
						$("#inputemail").removeAttr("style");
						$("#inputpasswd").focus();
						$("#inputpasswd").css("border","red solid 3px");
						$("#inputpasswd").val("");
						$("#inputpasswd").attr("placeholder","패스워드가 틀립니다.");
						//alert("패스워드가 틀립니다.");
					} else if(data==0){
						$("#inputpasswd").removeAttr("style");
						$("#inputemail").removeAttr("style");
						$("#inputemail").focus();
						$("#inputemail").css("border","red solid 3px");
						$("#inputemail").val("");
						$("#inputemail").attr("placeholder","회원정보가 없습니다.");
						//alert("회원정보가 없습니다.");
					}else{
						location.href='List.do';
					}
					
				},
				complete : function(data) {
				},
				error : function(xhr, status, error) {
					alert("에러발생");
				}
			});
		});
});
</script>
</head>
<body style="padding: 30px;">
	<form action="Login.do" method="post" id="form1">
		<div class="form-group">
			<label>이메일</label> <input type="text"
				name="inputemail" id="inputemail" class="form-control" >
		</div>
		<div class="form-group">
			<label>패스워드</label> <input type="password"
				name="inputpasswd" id="inputpasswd"  class="form-control">
		</div>
		
		
		<input type="submit" class="btn btn-success" value="로그인">


	</form>
<input type="button" value="로그인테스트" class="btn btn-success" id="button1">

</body>
</html>