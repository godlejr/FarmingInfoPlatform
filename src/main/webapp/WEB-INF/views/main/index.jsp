
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ page session="false"%>

<c:set var="contextPath" value="<%=request.getContextPath()%>"></c:set>
<c:set var="cloudFrontUserAvatarPath"
	value="http://d3fmxlpcykzndk.cloudfront.net/nongjik/images/users/avatars/"></c:set>
<c:set var="cloudFrontStoryImagePath"
	value="http://d3fmxlpcykzndk.cloudfront.net/nongjik/images/stories/"></c:set>


<div class="content-list">
	<div class="story-list">
		<c:forEach var="story" items="${stories}">
			<div class="section-story" data-id="${story.id}">
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
</div>

<script type="text/javascript">
	$('.section-story').hover(function() {
		$(this).find('.story-avatar').css({"opacity": "0.6", "transition": "all 0.3s"});
	}, function() {
		$(this).find('.story-avatar').css("opacity", "1");
	});
</script>