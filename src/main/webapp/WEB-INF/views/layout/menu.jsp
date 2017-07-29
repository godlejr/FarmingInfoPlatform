<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="<%=request.getContextPath()%>"></c:set>
<div class="menu-list" id="menu-list">
	<ul>
		<li class="category" data-id="0">전체보기</li>
		<c:forEach var="category" items="${categories}">
			<li class="category" data-id="${category.id}"><span>${category.name}</span>
		</c:forEach>
	</ul>
</div>
<script type="text/javascript">
	$('.category').click(function() {
		var orderId = ${orderId};
		var userLevel = ${userLevel};
		var search = "${search}";
		var categoryId = $(this).attr('data-id');
		
		var orderIdQuery = "";
		var userLevelQuery = "";
		var searchQuery ="";
		
	 	if(orderId > 0 ){
	 		orderIdQuery =  "&orderId=" + orderId;
	 	}
	 	
	 	if(userLevel > 0 ){
	 		userLevelQuery = "&userLevel=" + userLevel;
	 	}
	 	
	 	if(search != ""){
	 		searchQuery = "&search=" + search;
	 	}
		
		location.href = "${contextPath}/?categoryId=" + categoryId + orderIdQuery + userLevelQuery + searchQuery; 
	});
	
	$('.category').mouseover(function() {
		$(this).css("color", "#672");

	}).mouseout(function() {
		var categoryId = $(this).attr('data-id');
		
		if(categoryId != ${categoryId}){
			$(this).css("color", "#424242");
		}
	});
	
	function updateMenu(){
		var categoryId = ${categoryId};
		$('.category[data-id="'+ categoryId +'"]').addClass('curr');
	}
	
	updateMenu();
</script>
