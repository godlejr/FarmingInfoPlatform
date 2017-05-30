<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content" id="left-menu">
	<ul>
		<li class="category-list" id="0">전체보기</li>
		<c:forEach var="category" items="${categories}">
			<li class="category-list" id="${category.id}">${category.name}</li>
		</c:forEach>
	</ul>
</div>
