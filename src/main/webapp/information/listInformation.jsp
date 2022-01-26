<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
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
  <a href="/listInformation.do" class="alert-link">고객문의 목록</a></div>
	<div class="table-responsive">
				<table class="table table-hover">
					<thead class="thead">
						<tr>
							<th scope="col">번호</th>
							<th scope="col">제목</th>
							<th scope="col">작성자</th>
							<th scope="col">작성일</th>
							<th scope="col">조회수</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${listInformation}" var="pdto">
								<tr>
								<td>${pdto.num}</td>
								
								
								<td>
								<c:forEach begin="1" end="${pdto.repIndent}">
										&nbsp;└[답변]
									</c:forEach>
									
								<a href="/readInformation.do?num=${pdto.num}&curPage=${to.curPage}">${pdto.title}</a></td>
								<td><a href="readSimpleMember.do?id=${pdto.writer}"> ${pdto.writer}</a></td>
								<td>${fn:substring(pdto.writeDay, 0, 10)}</td>
								<td>${pdto.readCnt}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>

			</div>


		
		
		
		<c:if test="${login.role=='guest'}">
	<div class="row justify-content-end">
			<a href="/writeuiInformation.do">
			<button type="button" class="btn btn-outline-primary">
			문의하기</button></a>
	</div>
		</c:if>
	<jsp:include page="/information/pageInformation.jsp"/>
	
	<jsp:include page="/information/searchInformation.jsp"/>	
	
	

	</div>
	</div>
	</div>
	
	
	 <jsp:include page="/main/footer.jsp"/>



</body>
</html>