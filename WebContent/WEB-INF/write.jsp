<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="BoardInsert.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${mem.id }">
		<table>
			<tr>
				<td>작성자:</td>
				<td><input type="text" name="author" value="${mem.name }"></td>
			</tr>
			<tr>
				<td>제목:</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>파일:</td>
				<td><input type="file" name="file1" multiple="multiple">

				</td>
			</tr>
			<tr>
				<td colspan=2><textarea name="content" style="width: 300px; height: 200px"></textarea></td>

			</tr>
		</table>

		<input type="submit" value="등록">

	</form>

</body>
</html>