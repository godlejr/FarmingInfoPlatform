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
<c:set var="cloudFrontStoryVideoPath"
	value="http://d3fmxlpcykzndk.cloudfront.net/nongjik/videos/stories/"></c:set>
<c:set var="cloudFrontStoryVr360Path"
	value="https://s3.ap-northeast-2.amazonaws.com/djunderworld/nongjik/vr360/stories/"></c:set>

<div class="container-content">
	<div class="content-body">
		<div class="section-story-detail">
			<div class="story-left">
				<div class="story-info">
					<div class="info-header">
						<div class="header-left">
							<div class="left-content">
								<div class="story-title">
									<span>${story.title}</span>
								</div>
								<div class="story-description">
									<span>${story.getCustomCreatedAt()} /
										${story.itemCategory.name}</span>
								</div>
							</div>
						</div>
						<div class="header-right">
							<div class="right-content">
								<div class="story-hits">
									<i class="fa fa-eye" aria-hidden="true"></i><br> <span>${story.hits}</span>
								</div>
								<div class="story-like-count">
									<i class="fa fa-heart-o" aria-hidden="true"></i><br> <span>${fn:length(story.storyLikes)}</span>
								</div>
								<div class="story-comment-count">
									<i class="fa fa-commenting-o" aria-hidden="true"></i><br>
									<span>${fn:length(story.storyComments)}</span>
								</div>
							</div>
						</div>
					</div>

					<div class="info-body">
						<ul class="file-list">
							<c:forEach var="file" items="${story.files}">
								<li>
									<div class="story-file" data-id="${files.id}">
										<c:choose>
											<c:when test="${file.type == 1}">
												<img class="photo-file" align="middle"
													src="${cloudFrontStoryImagePath}${file.name}.${file.ext}"
													alt="" />
											</c:when>
											<c:when test="${file.type == 2}">
												<video class="video-file" controls>
													<source class="video-source"
														src="${cloudFrontStoryVideoPath}${file.name}.${file.ext}"
														type="video/mp4">
													<source class="video-source"
														src="${cloudFrontStoryVideoPath}${file.name}.${file.ext}"
														type="video/avi">
												</video>
											</c:when>
											<c:when test="${file.type == 3}">
												<div id="vr360-file" ></div>
												<script>
													new Carousel().viewer("vr360-file",{
														action : true,
														panorama : "${cloudFrontStoryVr360Path}${file.name}.${file.ext}"
													});
												</script>
											</c:when>
										</c:choose>
									</div>
								</li>
							</c:forEach>
						</ul>

						<div class="story-content"></div>
					</div>

					<div class="info-bottom"></div>
				</div>
			</div>
			<div class="story-right">
				<div class="user-info"></div>
			</div>
		</div>
	</div>

	<script>
		
	</script>
</div>