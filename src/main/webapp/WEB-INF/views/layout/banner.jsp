<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="cloudFrontBannerImagePath"
	value="http://d3fmxlpcykzndk.cloudfront.net/nongjik/images/banners/"></c:set>

<div class="banner-content">
	<div class="content-header">
		<span>소셜 농수산물 직거래, 농사직설에서 소중한 소통을 이루어보세요</span>
	</div>
	<div class="content-body">
		<div class="rolling-section">
			<div class="banner-item"
				style="background-image: url(${cloudFrontBannerImagePath}banner1.jpg)"></div>
			<div class="banner-item"
				style="background-image: url(${cloudFrontBannerImagePath}banner2.jpg)"></div>
			<div class="banner-item"
				style="background-image: url(${cloudFrontBannerImagePath}banner3.jpg)"></div>
		</div>
	</div>
</div>

<script>
	$('.rolling-section').on('init', function() {
		$('.rolling-section .banner-item').css('display', 'block');
	}).slick({
		dots : false,
		speed : 1000,
		arrows : false,
		autoplay : true,
		autoplaySpeed : 2500
	});
</script>