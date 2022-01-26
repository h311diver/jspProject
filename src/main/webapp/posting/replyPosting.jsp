<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글 작성 페이지</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
	crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="/main/header.jsp"/>
	
	
	
	
	<c:choose>
		<c:when test="${empty login}">
			
			<div class="card-group shadow-sm">
  <div class="card">
    <div class="card-body">


<div class="alert alert-primary" role="alert"> 
  <a href="/loginuiMember.do" class="alert-link">로그인 화면</a></div>

<form action="/loginMember.do" method="post">
	<label>
			회원 아이디<br>
			<input type="text" name="id" placeholder="아이디" >
		</label>
		<br>
		<label>
			회원 비밀번호<br>
			<input type="password" name="pw" placeholder="비밀번호">
		</label>
		<br>
		<br>
		<button type="submit" class="btn btn-outline-primary" value="로그인">로그인</button><br>
		<a href="/doYouRemember.do"><button type="button" class="btn btn-primary btn-sm my-1">비밀번호가 기억나지 않으신가요?</button></a>
		<br><br>
	
</form>
</div>
</div>
	</div>
			
			
		</c:when>
		
		<c:otherwise>
	
	
	
	<div class="card-group shadow-lg">
  <div class="card">
    <div class="card-body">
<div class="alert alert-primary" role="alert"> 
  <a href="/replyuiPosting.do?num=${num}&curPage=${param.curPage}" class="alert-link">답글 작성</a></div>

		

		<form name="form" action="/replyPosting.do" method="post">
			<input type="hidden" name="pnum" value="${num}">
			<input type="hidden" name="curPage" value="${param.curPage}">
		
			<div class="form-group">
				<label for="writer">작성자
				<input class="form-control"
					id="writer" name="writer" placeholder="홍길동" value="${login.id}" readonly>
					</label> 
			</div>

			<div class="form-group">
				<label for="title">제목</label> 
				<input class="form-control" id="title"
					name="title" placeholder="제목">
			</div>
			<div class="form-group">
				<label for="content">본문</label>
				<textarea name="content" class="form-control" id="content" rows="11"></textarea>
			</div><br>
	<div class="row justify-content-end">
			<button type="submit" class="btn btn-outline-primary" value="답글 완료">답글 완료</button>
		</div>
		<br>
		<br>





		</form>
	</div>
	</div>
	</div>


</c:otherwise>
	</c:choose>
<jsp:include page="/main/footer.jsp"/>
</body>
</html>