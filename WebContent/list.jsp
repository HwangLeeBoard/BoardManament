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



<%
HttpSession sess = request.getSession();
if (sess.getAttribute("mem")==null){ %>
<input type="button" value="회원가입" class="btn btn-primary" onclick="location.href='JoinForm.do'">
<input type="button" value="로그인" class="btn btn-primary" onclick="location.href='LoginForm.do'">
<%}else{ %>
<input type="button" value="로그아웃" class="btn btn-primary" onclick="location.href='Logout.do'">
<%} %>


<br>

<table class="table">
<tr>
<th>번호</th>
<th>제목</th>
<th>작성자</th>
<th>등록일</th>
</tr>
<c:forEach items="${listDTO }" var="list">
<tr>
<td>${list.idx }</td>
<td><a href="View.do?num=${list.idx }">${list.title }</a></td>
<td>${list.writer }</td>
<td>${list.dateTime }</td>
</tr>
</c:forEach>
</table>
<input type="button" value="글쓰기" class="btn btn-primary" onclick="location.href='Write.do'">


</body>
</html>