<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="navi-content">
	<div class="content-body">
		<div class="section-sort">
			<div class="sort-button">
				<div class="sort-title">
					<span class="sort-id">최신순</span>
				</div>
				<div class="filter-icon">
					<i class="fa fa-chevron-down" aria-hidden="true"></i>
				</div>
			</div>
			<div class="filter-menu">
				<div class="filter-items">
					<ul>
						<li class="filter-item">
							<div class="sort" id="1">
								<span>최신순</span>
							</div>
						</li>
						<li class="filter-item">
							<div class="sort" id="2">
								<span>인기순</span>
							</div>
						</li>
						<li class="filter-item">
							<div class="sort" id="3">
								<span>조회순</span>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="section-price">
			<div class="price-button">
				<div class="price-title">
					<span class="price-id">전체</span>
				</div>
				<div class="filter-icon">
					<i class="fa fa-chevron-down" aria-hidden="true"></i>
				</div>
			</div>
			<div class="filter-menu">
				<div class="filter-items">
					<ul>
						<li class="filter-item"><div class="price" id="0">
								<span>전체</span>
							</div></li>
						<li class="filter-item">
							<div class="price" id="1">
								<span>일반회원</span>
							</div>
						</li>
						<li class="filter-item">
							<div class="price" id="2">
								<span>기업회원</span>
							</div>
						</li>

					</ul>
				</div>
			</div>
		</div>

		<div class="section-search">
			<form class="search-box" action="" method="post">
				<div class="search-content">
					<div class="search-left">
						<input class="search-input" name="search" type="text"
							placeholder="검색어를 입력하세요." />
					</div>
					<div class="search-right">
						<input type="submit"
							style="background-image:url(<c:url value='/resources/static/img/main/search-icon.png' />)"
							value="" class="search-icon" />
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<script>
	$('.sort-button').click(function() {
		var self = this;
		var filter = $('.section-sort').find('.filter-menu');
		filter.slideToggle();

	});

	$('.price-button').click(function() {
		var self = this;
		var filter = $('.section-price').find('.filter-menu');
		filter.slideToggle();

	});
</script>