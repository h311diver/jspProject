<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<nav aria-label="페이지 번호가 적혀 있음">
  <ul class="pagination justify-content-center">
  	<li class="page-item">
    		<a class="page-link" href="/listInformation.do?pCurPage=${to.curPage>1?to.curPage-1:1}">&laquo;</a>
    	</li>
  
   	<c:forEach begin="${to.beginPageNum}" end="${to.endPageNum}" var="i" >
    	<li class="page-item ${i==to.curPage?'active':''}">
    		<a class="page-link" href="/listInformation.do?curPage=${i}">${i}</a>
    	</li>
   	</c:forEach>
   	
   <li class="page-item">
    		<a class="page-link" href="/listInformation.do?curPage=${to.curPage < to.totalPage?to.curPage+1:to.totalPage}">&raquo;</a>
    	</li>
  </ul>
</nav>


