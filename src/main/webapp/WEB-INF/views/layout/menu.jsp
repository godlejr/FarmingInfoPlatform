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
		var categoryId = $(this).attr('data-id');
		var itemCategoryId = 0;
		var orderId = ${orderId};
		var userLevel = ${userLevel};
		var search = "${search}";
		var columnSize = ${columnSize};
		
		navigateToLocationByRequestParams(categoryId, itemCategoryId, orderId, userLevel, search, columnSize);
	});
	
	
	function navigateToLocationByRequestParams(categoryId, itemCategoryId, orderId, userLevel, search, columnSize){
		var categoryIdQuery = "";
		var orderIdQuery = "";
		var userLevelQuery = "";
		var searchQuery ="";
		var itemCategoryQuery = "";
		var columnSizeQuery ="";
		
		if(categoryId > 0 ){
	 		categoryIdQuery =  "&categoryId=" + categoryId;
	 	}

		if(itemCategoryId > 0){
	 		itemCategoryQuery = "&itemCategoryId=" + itemCategoryId;
	 	}
		
	 	if(orderId > 0 ){
	 		orderIdQuery =  "&orderId=" + orderId;
	 	}
	 	
	 	if(userLevel > 0 ){
	 		userLevelQuery = "&userLevel=" + userLevel;
	 	}
	 	
	 	if(search != ""){
	 		searchQuery = "&search=" + search;
	 	}
	 	
	 	if(columnSize > 3){
	 		columnSizeQuery = "&columnSize=" + columnSize;
	 	}
		
		location.href = "${contextPath}/?" + categoryIdQuery + orderIdQuery + userLevelQuery + searchQuery + itemCategoryQuery + columnSizeQuery; 
	}
	
	$('.category').mouseover(function() {
		$(this).css("color", "#672");

	}).mouseout(function() {
		var categoryId = $(this).attr('data-id');
		
		if(categoryId != ${categoryId}){
			$(this).css("color", "#424242");
		}
	});
	
	function updateMenuView(){
		var categoryId = ${categoryId};
		$('.category[data-id="'+ categoryId +'"]').addClass('curr');
	}
	
	updateMenuView();
</script>
