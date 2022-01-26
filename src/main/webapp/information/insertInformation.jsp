<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성 페이지</title>
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
	
	
	
	
		
		
	
	<div class="card-group shadow-lg">
  <div class="card">
    <div class="card-body">
<div class="alert alert-primary" role="alert"> 
  <a href="/writeuiInformation.do" class="alert-link">문의글 작성</a></div>
		
			
		<form name="form" action="/insertInformation.do" method="post">
			<div class="form-group">
				<label for="writer">작성자 
				
				<input class="form-control"
					id="writer" name="writer" value="${login.id}" readonly>
					</label>
			</div>

			<div class="form-group">
				<label for="title">문의 제목</label> 
				<input class="form-control" id="title"
					name="title" value="[문의]  ${idto.title}">
				
				
			</div>
			<br>
		
			<div class="form-group">
				<label for="content">문의 본문</label>
				<textarea name="content" class="form-control" id="content" rows="11"></textarea>
			</div><br><br>
<div class="row justify-content-end">
	<button type="submit" id="submit" name="submit" class="btn btn-outline-primary" value="작성완료">작성완료</button>
		</div>
		<br>

		</form>
	</div>
</div>
	</div>
<jsp:include page="/main/footer.jsp"/>








</body>
</html>