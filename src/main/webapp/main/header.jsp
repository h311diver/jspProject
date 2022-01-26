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

<nav class="shadow-lg navbar navbar-expand-lg navbar-light bg-light alert alert-primary">
  <a class="navbar-brand" href="/home.do">3T PROJECT</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/home.do"> 홈 바로가기 <span class="sr-only">(current)</span></a>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" 
        href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
          메뉴
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/listMember.do"> 회원 목록 </a>
          <a class="dropdown-item" href="/listPosting.do"> 자유게시글 목록 </a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="/listInformation.do"> 고객게시글 목록 </a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled"> 접근제한 게시판 </a>
      </li>
    </ul>
    
  </div>
</nav>






 

	<div class="row justify-content-end my-2 mx-2">
	<c:choose>
		<c:when test="${empty login}">
			로그인 후 이용이 가능합니다. &nbsp;&nbsp; <a href="/loginuiMember.do" class="badge badge-secondary"> 로그인 </a> &nbsp; &nbsp;
			<a href="/insertuiMember.do" class="badge badge-secondary"> 회원가입 </a> &nbsp; &nbsp;
		</c:when>
		
		<c:otherwise>
		<div class="text-body">${login.name} (${login.id}) 님, 환영합니다.</div> &nbsp; &nbsp;
			<a href="/myPageMember.do?id=${login.id}" class="badge badge-secondary"> 마이페이지 </a> &nbsp; &nbsp; 
			<a href="/logoutMember.do" class="badge badge-secondary"> 로그아웃 </a> &nbsp; &nbsp;
		</c:otherwise>
	</c:choose>
	<a href="/listInformation.do" class="badge badge-secondary"> 고객센터</a> &nbsp; &nbsp;
</div>







</body>
</html>