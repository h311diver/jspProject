<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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




	
	<div class="card-group shadow-lg">
  <div class="card">
    <div class="card-body">

		<div class="alert alert-primary" role="alert"> 
  <a href="/updateuiInformation.do" class="alert-link">게시글 수정 화면</a></div>

		<form name="form" action="/updateInformation.do" method="post">
			<input type="hidden" name="curPage" value="${param.curPage}">
			<input type="hidden" name="num" value="${idto.num}">
			<div class="form-group">
				<label for="writer">작성자</label> 
				<input class="form-control"
					id="writer" name="writer" value="${idto.writer}" readonly>
			</div>

			<div class="form-group">
				<label for="title">제목</label> 
				<input class="form-control" id="title"
					name="title" value="${idto.title}">
			</div>
			<div class="form-group">
				<label for="content">본문</label>
				<textarea name="content" class="form-control" id="content" rows="5">${idto.content}</textarea>
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