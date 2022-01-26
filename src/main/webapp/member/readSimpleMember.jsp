<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

</head>
<body>

<jsp:include page="/main/header.jsp"/>

<div class="alert alert-info"> 
  <a href="/readMember.do?id=${mdto.id}" class="alert-link">${mdto.name} (${mdto.id}) 님의 정보</a></div>

<div class="table-responsive">
				<table class="table table-hover">
		<thead class="thead-dark"><tr>
				<th scope="col">아이디</th>
				<th scope="col">이름</th>
			<th scope="col">이메일</th>	
				<th scope="col">회원등급</th>
						</tr></thead><tbody><tr>
				<td>${mdto.id}</td>
				<td>${mdto.name}</td>	
				<td>${mdto.email}</td>	
				<td>${mdto.role}</td></tr></tbody></table></div>
				
<jsp:include page="/main/footer.jsp"/>

</body>
</html>