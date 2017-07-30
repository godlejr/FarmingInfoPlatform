<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="<%= request.getContextPath()%>"></c:set>
<div class="navi-content">
	<div class="content-body">
		<div class="section-sort">
			<div class="sort-button">
				<div class="sort-title">
					<c:choose>
						<c:when test="${orderId == 1 }">
							<span class="sort-id">인기순</span>
						</c:when>
						<c:when test="${orderId == 2 }">
							<span class="sort-id">조회순</span>
						</c:when>
						<c:otherwise>
							<span class="sort-id">최신순</span>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="filter-icon">
					<i class="fa fa-chevron-down" aria-hidden="true"></i>
				</div>
			</div>
			<div class="filter-menu">
				<div class="filter-items">
					<ul>
						<li class="filter-item">
							<div class="sort" data-id="0">
								<span>최신순</span>
							</div>
						</li>
						<li class="filter-item">
							<div class="sort" data-id="1">
								<span>인기순</span>
							</div>
						</li>
						<li class="filter-item">
							<div class="sort" data-id="2">
								<span>조회순</span>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="section-level">
			<div class="level-button">
				<div class="level-title">
					<c:choose>
						<c:when test="${userLevel == 1 }">
							<span class="level-id">일반회원</span>
						</c:when>
						<c:when test="${userLevel == 2 }">
							<span class="level-id">기업회원</span>
						</c:when>
						<c:otherwise>
							<span class="level-id">전체</span>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="filter-icon">
					<i class="fa fa-chevron-down" aria-hidden="true"></i>
				</div>
			</div>
			<div class="filter-menu">
				<div class="filter-items">
					<ul>
						<li class="filter-item">
							<div class="level" data-id="0">
								<span>전체</span>
							</div>
						</li>
						<li class="filter-item">
							<div class="level" data-id="1">
								<span>일반회원</span>
							</div>
						</li>
						<li class="filter-item">
							<div class="level" data-id="2">
								<span>기업회원</span>
							</div>
						</li>

					</ul>
				</div>
			</div>
		</div>

		<div class="section-search">
			<div class="search-box" action="" method="post">
				<div class="search-content">
					<div class="search-left">
						<input class="search-input" id="search-text" type="search" name="search" type="text" onKeyDown="onKeyDown()"
							value="${search}" placeholder="검색어를 입력하세요." />
					</div>
					<div class="search-right">
						<input id="search-submit" type="submit"
							style="background-image:url(<c:url value='/resources/static/img/main/search_icon.png' />)"
							value="" class="search-icon" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	$('.sort-button').click(function() {
		var self = this;
		var filter = $('.section-sort').find('.filter-menu');
		filter.slideToggle();

	});

	$('.level-button').click(function() {
		var self = this;
		var filter = $('.section-level').find('.filter-menu');
		filter.slideToggle();

	});

	$('.sort').click(function() {
		var orderId = $(this).attr('data-id');
		var userLevel = ${userLevel};
		var categoryId = ${categoryId};
		var itemCategoryId = ${itemCategoryId};
		var search = "${search}";
		var columnSize = ${columnSize};
		
		navigateToLocationByRequestParams(categoryId, itemCategoryId, orderId, userLevel, search, columnSize);
	});

	$('.level').click(function() {
		var userLevel = $(this).attr('data-id');
		var orderId = ${orderId};
		var categoryId = ${categoryId};
		var itemCategoryId = ${itemCategoryId};
		var search = "${search}";
		var columnSize = ${columnSize};
		
		navigateToLocationByRequestParams(categoryId, itemCategoryId, orderId, userLevel, search, columnSize);
	});
	
	$('#search-submit').click(function(){
		search();
	});
	
	function onKeyDown(){
		if(event.keyCode == 13){
			search();
		}
	}
	
	function search(){
		var search = $(document.getElementById('search-text')).val();
		var userLevel = ${userLevel};
		var orderId = ${orderId};
		var categoryId = ${categoryId};
		var itemCategoryId = ${itemCategoryId};
		var columnSize = ${columnSize};
		
		navigateToLocationByRequestParams(categoryId, itemCategoryId, orderId, userLevel, search, columnSize);
	}
	

</script>