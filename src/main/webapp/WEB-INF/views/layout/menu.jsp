<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="<%=request.getContextPath()%>"></c:set>

<div class="menu-list" id="menu-list">
	<ul>
		<li class="category" data-id="0">전체보기</li>
		<c:forEach var="category" items="${categories}">
			<li class="category" data-id="${category.id}"><span>${category.name}</span>

				<%-- <div class="item-category-list" hidden="hidden">
					<ul>
						<c:forEach var="itemCategory" items="${category.itemCategories}">
							<li class="item-category" data-id="${itemCategory.id}" parent-id="${category.id}">${itemCategory.name}</li>
						</c:forEach>
					</ul>
				</div></li> --%>
		</c:forEach>
	</ul>
</div>
<script type="text/javascript">
	$('.category').click(function() {
		var orderId = ${orderId};
		var userLevel = ${userLevel};
		var categoryId = $(this).attr('data-id');
		
		var orderIdQuery = "";
		var userLevelQuery = "";
		
	 	if(orderId > 0 ){
	 		orderIdQuery =  "&orderId=" + orderId;
	 	}
	 	
	 	if(userLevel > 0 ){
	 		userLevelQuery = "&userLevel=" + userLevel;
	 	}
		
		location.href = "${contextPath}/?categoryId=" + categoryId + orderIdQuery + userLevelQuery; 
	});
	
	$('.category').mouseover(function() {
		$(this).find('.item-category-list').toggle();
		$(this).css("color", "#672");

	}).mouseout(function() {
		$(this).find('.item-category-list').toggle();
		$(this).css("color", "#424242");

	});
</script>
