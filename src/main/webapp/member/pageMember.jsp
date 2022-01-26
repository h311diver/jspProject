<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<nav aria-label="회원 목록의 페이지 번호">
  <ul class="pagination justify-content-center">
  	<li class="page-item">
    		<a class="page-link" href="/listMember.do?curPage=${to1.curPage>1?to1.curPage-1:1}">&laquo;</a>
    	</li>
  
   	<c:forEach begin="${to1.beginPageNum}" end="${to1.endPageNum}" var="i" >
    	<li class="page-item ${i==to1.curPage?'active':''}">
    		<a class="page-link" href="/listMember.do?curPage=${i}">${i}</a>
    	</li>
   	</c:forEach>
   	
   <li class="page-item">
    		<a class="page-link" href="/listMember.do?curPage=${to1.curPage < to1.totalPage?to1.curPage+1:to1.totalPage}">&raquo;</a>
    	</li>
  </ul>
</nav>


