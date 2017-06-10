<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="menu-list" id="menu-list">
	<ul>
		<li class="category-list" id="0">전체보기</li>
		<c:forEach var="category" items="${categories}">
			<li class="category-list" id="${category.id}"><span>${category.name}</span>

				<div class="item-category-list" hidden="hidden">
					<ul>
						<c:forEach var="itemCategory"
							items="${category.itemCategoryModels}">
							<li id="${itemCategory.id}">${itemCategory.name}</li>
						</c:forEach>
					</ul>
				</div></li>
		</c:forEach>
	</ul>
</div>
<script type="text/javascript">
	$('.category-list').mouseover(function() {
		$(this).find('.item-category-list').toggle();
		$(this).css("color", "#672");

	}).mouseout(function() {
		$(this).find('.item-category-list').toggle();
		$(this).css("color", "#424242");

	});
</script>
