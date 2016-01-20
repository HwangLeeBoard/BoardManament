<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.js"></script>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" charset="utf-8">
<title>게시판</title>
</head>
<body style="padding:30px">

	${BoardDto.title }
	<br> ${BoardDto.content }
	<br> ${BoardDto.idx }
	<br>
	<c:forEach items="${Filelist }" var="f">
		<a href="FileDown.do?filename=${f.filename }">${f.filename }</a>
		<br>
		<img src="file1/${f.filename }" width="150">
	</c:forEach>
	<br><br>
	<input type="button"
		onclick="location.href='ReplyView.do?idx=${BoardDto.idx}'"  class="btn btn-primary" value="답변">
	<input type="button"
		onclick="location.href='UpdateView.do?idx=${BoardDto.idx}'" class="btn btn-primary" value="수정">
	<input type="button"
		onclick="location.href='Delete.do?idx=${BoardDto.idx}'" class="btn btn-primary" value="삭제">
	<input type="button" onclick="location.href='List.do'" class="btn btn-primary" value="리스트">
</body>
</html>