<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 목록</title>
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
	
   
			
			<div class=" row alert alert-danger" role="alert">
  <a href="/listNotice.do" class="alert-link">최근에 작성된 순서대로 공지사항 게시글의 3개까지만 표시됩니다.</a>
  </div>
	<div class="table-responsive">
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">제목</th>
							<th scope="col">작성자</th>
							<th scope="col">작성일</th>
							<th scope="col">조회수</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${listNotice}" var="ndto">
							<tr>
								<td>${ndto.num}</td>
								<td><a href="/readNotice.do?num=${ndto.num}">${ndto.title}</a></td>
								<td>${ndto.writer}</td>
								<td>${fn:substring(ndto.writeDay, 0, 10)}</td>
								<td>${ndto.readCnt}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>

			</div>


		
		
		
		<c:if test="${login.role=='admin'||login.role=='manager'}">
	<div class="row justify-content-end">
			<a href="/writeuiNotice.do">
			<button type="button" class="btn btn-outline-primary">
			글쓰기</button></a>
		</div>
		</c:if>
	
	</div>
	</div>
	</div>
	
	
	 <%@ include file="/main/footer.jsp"%>


</body>
</html>