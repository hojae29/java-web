<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String userId = request.getParameter("user_id");
	String userPw = request.getParameter("user_pw");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과출력창</title>
</head>
<body>
<%
	if(userId == null || userId.length() == 0) {
%>
아이디를 입력하세요 <br>
<a href="/pro12/login.html">로그인하기</a>
<%
	} else {
		if(userId.equals("admin")) {
%>
<h1>관리자로 로그인했습니다.</h1>
<form>
	<input type="button" value="회원정보 삭제하기"/>
	<input type="button" value="회원정보 수정하기"/>
</form>
<%
		}else {
%>
<h1>환영합니다. <%=userId %>님!!!</h1>
<%
		}
	}
%>
</body>
</html>