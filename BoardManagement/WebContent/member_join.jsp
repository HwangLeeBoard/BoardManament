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
</head>
<body style="padding: 30px;">
	<form action="MemberInsert.do" method="post" >
		<div class="form-group">
			<label for="exampleInputEmail1">이메일</label> <input type="text"
				name="email" class="form-control" value="${mem.name }">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">패스워드</label> <input type="password"
				name="passwd" class="form-control">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">이름</label> <input type="text"
				name="name" class="form-control">
		</div>
		<div class="form-group">
			 <label class="radio-inline">
    <input type="radio" name="gender" value="남자">
	남자
  </label> 
   <label class="radio-inline">
    <input type="radio" name="gender" value="여자">
    여자
  </label>
			
		</div>
		
		<div class="form-group">
			<label for="exampleInputEmail1">핸드폰번호</label> 
			<input type="text"
				name="pnum" class="form-control">
		</div>
		
		
		<input type="submit" class="btn btn-success" value="등록">


	</form>

</body>
</html>