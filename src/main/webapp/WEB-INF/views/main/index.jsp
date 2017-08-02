
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false"%>

<c:set var="contextPath" value="<%=request.getContextPath()%>"></c:set>
<c:set var="cloudFrontUserAvatarPath"
	value="http://d3fmxlpcykzndk.cloudfront.net/nongjik/images/users/avatars/"></c:set>
<c:set var="cloudFrontStoryImagePath"
	value="http://d3fmxlpcykzndk.cloudfront.net/nongjik/images/stories/"></c:set>

<c:choose>
	<c:when test="${columnSize == 3}">
			<c:set var="columSizeView" value="4" />
	</c:when>
	<c:otherwise>
			<c:set var="columSizeView" value="3" />
	</c:otherwise>
	
</c:choose>

<div class="content-list" id="content-list">
	<c:if test="${itemCategories != null }">
		<div class="item-category-list">
			<ul>
				<li class="section-item-category" data-id="0">
						<span>전체보기</span>
				</li>	
				<c:forEach var="itemCategory" items="${itemCategories}"  varStatus="status" >
					<c:choose>
						<c:when test="${!status.last}">
							<li class="section-item-category" data-id="${itemCategory.id}">
								<span>${itemCategory.name}</span>
							</li>		
						</c:when>
						<c:otherwise>
							<li class="section-item-category last" data-id="${itemCategory.id}">
								<span>${itemCategory.name}</span>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
		</div>
	</c:if>
	
	<div class="option-list">
		<div class="section-view-option">
			<div class="view-col-${columSizeView}">
				<img src="<c:url value='/resources/static/img/main/col_${columSizeView}.png' />" />
				<span>${columSizeView}줄 보기</span>
			</div>
			<span></span>
		</div>
	</div>

	<div class="story-list" >
		<c:forEach var="story" items="${stories}">
			<div class="section-story col-${columnSize}" data-id="${story.id}">
				<div class="story-avatar"
					style="background-image:url(${cloudFrontStoryImagePath}${story.files[0].name}.${story.files[0].ext})">

					<div class="story-value">
						<div class="value-count">
							<div class="count-check">
								<i class="fa fa-eye" aria-hidden="true"></i><span>${story.hits}</span>
							</div>
							<div class="count-like">
								<i class="fa fa-heart-o" aria-hidden="true"></i><span>${fn:length(story.storyLikes)}</span>
							</div>
							<div class="count-comment">
								<i class="fa fa-commenting-o" aria-hidden="true"></i><span>${fn:length(story.storyComments)}</span>
							</div>
						</div>
					</div>
				</div>

				<div class="story-info">
					<div class="info-content">
						<div class="content-title">
							<span>${story.title}</span>
						</div>
						<div class="content-user">
							<img class="user-avatar" data-id="${story.user.id}" alt=""
								src="${cloudFrontUserAvatarPath}${story.user.avatar}"> <span
								class="user-name" data-id="${story.user.id}">${story.user.name}</span>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="section-loader" >
		<img class="loader-image" src="<c:url value='/resources/static/img/main/loader.gif' />">
	</div>
</div>

<script type="text/javascript">
	function updateItemCategoryView(){
		var itemCategoryId = ${itemCategoryId};
		$('.section-item-category[data-id="'+ itemCategoryId +'"]').addClass('curr');
	}
	
	updateItemCategoryView();
	
	$('.view-col-${columSizeView}').click(function(){
		var itemCategoryId = ${itemCategoryId};
		var orderId = ${orderId};
		var categoryId = ${categoryId};
		var userLevel = ${userLevel};
		var search = "${search}";
		var columnSize;
		
		if(${columSizeView} == 3){
			columnSize = 3;
		}else{
			columnSize = 4;
		}
		
		navigateToLocationByRequestParams(categoryId, itemCategoryId, orderId, userLevel, search, columnSize);
	
	});
	
	$('.section-item-category').click(function(){
		var itemCategoryId = $(this).attr('data-id');
		var orderId = ${orderId};
		var categoryId = ${categoryId};
		var userLevel = ${userLevel};
		var search = "${search}";
		var columnSize = ${columnSize};
		
		navigateToLocationByRequestParams(categoryId, itemCategoryId, orderId, userLevel, search, columnSize);
	
	});
	
	$(".story-list").delegate(".section-story", "mouseover mouseout", function ( event ) {
	    if (event.type == "mouseover") {
	    	$(this).find('.story-avatar').css({
				"opacity" : "0.6",
				"transition" : "all 0.3s"
			});
	    } else {
			$(this).find('.story-avatar').css("opacity", "1");
	    }
	});
	

	var page = 1;
	var isEndOfStories = false;
	var isSync = true;
		
	function infiniteScrollDown(){
		isSync = false;

		var categoryId = "${categoryId}";
		var itemCategoryId = "${itemCategoryId}";
		var orderId = "${orderId}";
		var userLevel  = "${userLevel}";
		var search = "${search}";
		var storyList = $('.section-story:last');
		var loader = $('.section-loader');
		
		$.ajax({
			type : "POST",
			url : "${contextPath}/infiniteScrollDown",
			data:{
				categoryId: (categoryId!="")? categoryId : 0,
				itemCategoryId: (itemCategoryId!="")? itemCategoryId : 0,
				orderId: (orderId!="")? orderId : 0,
				userLevel: (userLevel!="")? userLevel : 0,
				search: search,
				page: page
	        },
	        success:function(data){
	        	if(data.length == 0){
					isEndOfStories = true;
				}else{
					$(data).each(function(){
						var storyTemplate = '<div class="section-story col-'+ ${columnSize} +'" data-id="' + this.id + '">' +
							'<div class="story-avatar" style="background-image:url(http://d3fmxlpcykzndk.cloudfront.net/nongjik/images/stories/' + this.fileAvatar + ')">' +
							'<div class="story-value"> <div class="value-count">' +
							'<div class="count-check"><i class="fa fa-eye" aria-hidden="true"></i><span>' + this.hits + '</span></div>'+
							'<div class="count-like"><i class="fa fa-heart-o" aria-hidden="true"></i><span>' + this.storyLikeCount + '</span></div>'+
							'<div class="count-comment"><i class="fa fa-commenting-o" aria-hidden="true"></i><span>' + this.storyCommentCount + '</span></div>'+
							'</div></div></div>'+
							'<div class="story-info"><div class="info-content">'+
							'<div class="content-title"><span>' + this.title + '</span></div>'+
							'<div class="content-user"><img class="user-avatar" data-id="' + this.user.id + '" alt=""src="http://d3fmxlpcykzndk.cloudfront.net/nongjik/images/users/avatars/' + this.user.avatar + '">'+ 
							'<span class="user-name" data-id="' + this.user.id + '">' + this.user.name + '</span></div></div></div></div>';
							
						storyList.after(storyTemplate);
					});
		            ++page;
				}
	        	setTimeout(function(){isSync = true;},500) 
	        },
	        beforeSend:function(){
	        	loader.css('display','inline-block');
	        },
	        complete: function(){
	        	loader.css('display','none');
	        }
		});
	}
		
	$(document).scroll(function() {
		if ($(window).scrollTop() == ($(document).height() - $(window).height()) ){
			if(!isEndOfStories){
				if(isSync){
					infiniteScrollDown();
				}
			}
		}
	});
</script>