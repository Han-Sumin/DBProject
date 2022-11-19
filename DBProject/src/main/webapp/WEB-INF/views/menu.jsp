<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">


<ul class="nav font-noto border-bottom">
	<ul class="nav font-noto border-bottom">
      <c:if test="${member == null}">
        <li class="nav-item"><a href="/login" class="nav-link link-light pl-5 text-dark" >로그인</a></li>
        <li class="nav-item"><a href="/join" class="nav-link pl-2 text-dark">회원가입</a></li>
      </c:if>
      <c:if test="${member != null}">
        <li class="nav-item"><a href="/logout" class="nav-link pl-2 text-dark">로그아웃</a></li>
      </c:if>
	</ul> 
</ul>