<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 수정 페이지</title>
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


<%@ include file="/main/header.jsp"%>




	
	<div class="card-group shadow-lg">
  <div class="card">
    <div class="card-body">

		<div class="alert alert-primary" role="alert"> 
  <a href="/updateuiNotice.do" class="alert-link">공지 수정 화면</a></div>

		<form name="form" action="/updateNotice.do" method="post">
			<input type="hidden" name="num" value="${ndto.num}">
			<div class="form-group">
				<label for="writer">작성자</label> 
				<input class="form-control"
					id="writer" name="writer" value="${ndto.writer}" readonly>
			</div>

			<div class="form-group">
				<label for="title">제목</label> 
				<input class="form-control" id="title"
					name="title" value="${ndto.title}">
			</div>
			<div class="form-group">
				<label for="content">본문</label>
				<textarea name="content" class="form-control" id="content" rows="11">${ndto.content}</textarea>
			</div><br><br>

			<div class="row justify-content-end">
	<button type="submit" class="btn btn-outline-primary" value="작성완료">작성완료</button>
		</div>
		<br>

		</form>
	</div>
	</div>
	</div>
	
	
	




<jsp:include page="/main/footer.jsp"/>
</body>
</html>