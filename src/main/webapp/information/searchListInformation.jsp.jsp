<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색결과 게시글 목록 페이지</title>
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
	<input type="hidden" name="criteria" value="${param.criteria}">
<input type="hidden" name="keyword" value="${param.keyword}">
   
			
			<div class="alert alert-primary" role="alert">
  <a href="/searchInformation.do?curPage=${to.curPage}&criteria=${param.criteria}&keyword=${param.keyword}" class="alert-link">검색결과 게시글 목록</a></div>
	<div class="table-responsive">
				<table class="table table-hover">
					<thead class="thead-dark">
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
										&nbsp;└
									</c:forEach>
								<a href="/readInformation.do?num=${pdto.num}&curPage=${to.curPage}">${pdto.title}</a></td>
								<td>${pdto.writer}</td>
								<td>${fn:substring(pdto.writeDay, 0, 10)}</td>
								<td>${pdto.readCnt}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>

			</div>


		
		
		
		
	<div class="row justify-content-end">
			<a href="/writeuiInformation.do">
			<button type="button" class="btn btn-outline-primary">
			글쓰기</button></a>
		</div>
		
	<jsp:include page="searchPageInformation.jsp"/>	
			
	
	<div class="container"><jsp:include page="/information/searchInformation.jsp"/></div>

	</div>
	</div>
	</div>
	
	
	<jsp:include page="/main/footer.jsp"/>

</body>
</html>