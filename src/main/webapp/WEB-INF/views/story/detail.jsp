<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="contextPath" value="<%=request.getContextPath()%>"></c:set>
<c:set var="cloudFrontUserAvatarPath"
	value="http://d3fmxlpcykzndk.cloudfront.net/nongjik/images/users/avatars/"></c:set>
<c:set var="cloudFrontUserCoverPath"
	value="http://d3fmxlpcykzndk.cloudfront.net/nongjik/images/users/covers/"></c:set>
<c:set var="cloudFrontStoryImagePath"
	value="http://d3fmxlpcykzndk.cloudfront.net/nongjik/images/stories/"></c:set>
<c:set var="cloudFrontStoryVideoPath"
	value="http://d3fmxlpcykzndk.cloudfront.net/nongjik/videos/stories/"></c:set>
<c:set var="cloudFrontStoryVr360Path"
	value="https://s3.ap-northeast-2.amazonaws.com/djunderworld/nongjik/vr360/stories/"></c:set>


<c:choose>
	<c:when test='${isLiked}'> 
		<c:set value="activity-like active" var="likeCssClass"></c:set>
	</c:when> 
	<c:otherwise>
		<c:set value="activity-like" var="likeCssClass"></c:set>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test='${isScraped}'> 
  		<c:set value="activity-scrap active" var="scrapCssClass"></c:set>
	</c:when> 
	<c:otherwise>
		<c:set value="activity-scrap" var="scrapCssClass"></c:set>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test='${isFollowed}'> 
  		<c:set value="activity-follow active" var="followCssClass"></c:set>
	</c:when> 
	<c:otherwise>
		<c:set value="activity-follow" var="followCssClass"></c:set>
	</c:otherwise>
</c:choose>



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
									<i class="fa fa-heart-o" aria-hidden="true"></i><br> <span id="story-like-count">${fn:length(story.storyLikes)}</span>
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
												<div id="vr360-file"></div>
												<script>
													new Carousel().viewer("vr360-file",
															{
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

						<div class="story-content">${story.content}</div>
					</div>

					<div class="info-bottom">
						<div id="comment-more-button">
							<span>댓글 더 보기 +</span>
						</div>
					
						<ul class="comment-list">
							<c:forEach var="comment"  items="${storyComments}" varStatus="status" >
								
								<c:choose>
									<c:when test="${comment.depth == 0}">
										<c:set value="story-comment" var="commentCssClass"></c:set>
									</c:when>
									<c:otherwise>
										<c:set value="story-comment reply" var="commentCssClass"></c:set>
									</c:otherwise>
								</c:choose>
								
								<li>
									<div class="${commentCssClass}" data-id="${comment.id}">
										<div class="comment-left">
											<img class="user-avatar" alt="" src="${cloudFrontUserAvatarPath}${comment.user.avatar}">	
										</div>
										<div class="comment-right">
											<div class="comment-description">
												<span class="user-name">${comment.user.name}</span>
												<span class="comment-date">${comment.getCustomCreatedAt()}</span>
												
												<c:choose>
													<c:when test="${comment.user.id == sessionScope.user.id}">
														<span id="comment-edit-button">수정</span>
														<span id="comment-delete-button">삭제</span>
													</c:when>
													
													<c:otherwise>
														<c:if test="${story.user.id == sessionScope.user.id && comment.depth == 0}">
															<c:choose>															
																<c:when test="${comment.groupIdCount == 1}">
																	<span id="comment-reply-button">답변</span>
																</c:when>
																
																<c:otherwise>
																	<span id="comment-reply-complete-button">답변완료</span>
																</c:otherwise>
															</c:choose>
															
														</c:if>
													</c:otherwise>
												</c:choose>
												
											</div>
											<div class="comment-content">
												${comment.content}
											</div>
										</div>
									</div>
								</li>
							</c:forEach>
						</ul>
						<c:if test="${sessionScope.user != null }">
							<div class="section-comment-write">
								<div class="comment-write-left">
									<img class="user-avatar" alt="" src="${cloudFrontUserAvatarPath}${sessionScope.user.avatar}">	
								</div>
								<div class="comment-write-right">
									<textarea id="comment-text" placeholder="댓글을 입력해주세요" ></textarea>
									<div class="comment-write-actvity">
										<span class="comment-write-button">									
											<i class="fa fa-pencil" aria-hidden="true"></i>
										</span>
									</div>
								</div>
							</div>
						</c:if>
					</div>
				</div>
			</div>
			<div class="story-right">
				<div class="description-info">
					<div class="info-header">
						<div class="user-cover"
							style="background-image:url(${cloudFrontUserCoverPath}${story.user.cover})">
							<div class="user-avatar"
								style="background-image:url(${cloudFrontUserAvatarPath}${story.user.avatar})"></div>
							<div class="user-name">
								<span>${story.user.name}</span>
							</div>
							<c:if test="${sessionScope.user.id != story.user.id}">
								<div class="user-follow">
									<span class="${followCssClass}" data-id="${story.user.id}">Follow
										+</span>
								</div>
							</c:if>
						</div>
					</div>
					<div class="info-body">
						<div class="story-title">
							<span>${story.title}</span>
						</div>
						<div class="story-description">
							<span>${story.itemCategory.name}</span>
						</div>
						<div class="share-title">
							<span>공유하기</span>
						</div>
						<div class="share-description">
							<span class="facebook-icon"> <a
								href="https://www.facebook.com/sharer/sharer.php?u=http://not-yet/nongjik/stories/${story.id}"
								target="_blank"><i class="fa fa-facebook" aria-hidden="true"></i></a></span>
							<span class="twitter-icon"><a
								href="https://twitter.com/intent/tweet?url=http://not-yet/nongjik/stories/${story.id}&text=${story.user.name}"
								target="_blank"><i class="fa fa-twitter"
								aria-hidden="true"></i></a></span>
						</div>
					</div>
					<c:if test="${sessionScope.user.id != story.user.id}">
						<div class="info-bottom">
							<div class="story-activity">
								<div class="${likeCssClass}">
									<i class="fa fa-heart-o" aria-hidden="true"></i><span>좋아요</span>
								</div>
								<div class="${scrapCssClass}">
									<i class="fa fa-share-square-o" aria-hidden="true"></i><span>스크랩</span>
								</div>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>

	<script>
		var page = 1;
	
		var storyCommentTotalCount = ${fn:length(story.storyComments)};
		var storyCommentCount = ${fn:length(storyComments)};
		var commentMoreButtom = $('#comment-more-button');
		
		storyCommentViewUpdate();
		
		function storyCommentViewUpdate(){
			if(storyCommentCount == storyCommentTotalCount){
				commentMoreButtom.hide();
			}
		}
		
		$('#comment-more-button').click(function(){
			var storyId = ${story.id};
			var commentList =$('.comment-list:first');
			$.ajax({
				type : "GET",
				url : "${contextPath}/stories/"+ storyId + "/comments.json",
				data:{
					page: page
		        },
		        success:function(data){
		        	if(data.length == 0){
		    			commentMoreButtom.hide();
					}else{
						$(data).each(function(){
							
							var userAvatarUrl ="http://d3fmxlpcykzndk.cloudfront.net/nongjik/images/users/avatars/";
							var commentCssClass = this.depth == 0 ? "story-comment" : "story-comment reply";
							
							var sessionUserId =  "${sessionScope.user.id}";
							
							var storyCommentActvityTemplate = "";
							
							if(sessionUserId != ""){
								if(sessionUserId == this.user.id){
									storyCommentActvityTemplate = '<span id="comment-edit-button">수정</span><span id="comment-delete-button">삭제</span>';
								}else{
									var storyUserId = ${story.user.id};
									if(storyUserId == sessionUserId && this.depth == 0){
										if(this.groupIdCount == 1){
											storyCommentActvityTemplate = '<span id="comment-reply-button">답변</span>';
										}else{
											storyCommentActvityTemplate = '<span id="comment-reply-complete-button">답변완료</span>';
										}
									}
								}
							}
							
							var storyCommentTemplate = '<li><div class="' + commentCssClass + '" data-id="' + this.id + '">' +
									'<div class="comment-left"><img class="user-avatar" alt="" src="' + userAvatarUrl + this.user.avatar + '"></div>' + 
									'<div class="comment-right"><div class="comment-description"><span class="user-name">' + this.user.name + '</span><span class="comment-date">' + this.customCreatedAt + '</span>' +
									storyCommentActvityTemplate + '</div><div class="comment-content">' + this.content + '</div></div></div></li>';

							commentList.prepend(storyCommentTemplate);
						});
			            ++page;
			            storyCommentCount += data.length;
					}
		        },
		        complete: function(){
		        	storyCommentViewUpdate();
		        }
			});
		});
	
	
		$('.activity-like').click(function(){
			var userId = "${sessionScope.user.id}";
			if(userId != ""){
				var self = this;
				var storyId = "${story.id}";
				var storyUserId = "${story.user.id}";
				
				$.ajax({
					type : "POST",
					url : "${contextPath}/stories/" + storyId + "/like",
					data:{
						userId: userId,
						storyUserId: storyUserId
				   	},
			      	success:function(data){
				      	var preCount = parseInt($('#story-like-count').text());
				      	$('#story-like-count').text(preCount + data);
			      	},
			      	beforeSend:function(){
			      		$(self).toggleClass('active');
			      	},
			      	error:function(request, status, error){
			      		$(self).toggleClass('active');
			      	}
				});
			}else{
				navigateToLogin();
			}
		});
		
		$('.activity-scrap').click(function(){
			var userId = "${sessionScope.user.id}";
			if(userId != ""){
				var self = this;
				var storyId = "${story.id}";
				var storyUserId = "${story.user.id}";
				
				$.ajax({
					type : "POST",
					url : "${contextPath}/stories/" + storyId + "/scrap",
					data:{
						userId: userId,
						storyUserId: storyUserId
				   	},
			      	success:function(data){
				      	//not yet
			      	},
			      	beforeSend:function(){
			      		$(self).toggleClass('active');
			      	},
			      	error:function(request, status, error){
			      		$(self).toggleClass('active');
			      	}
				});
			}else{
				navigateToLogin();
			}
		});
		
		$('.activity-follow').click(function(){
			var userId = "${sessionScope.user.id}";
			if(userId != ""){
				var self = this;
				var storyUserId = "${story.user.id}";
				
				$.ajax({
					type : "POST",
					url : "${contextPath}/users/" + storyUserId + "/follow",
					data:{
						userId: userId,
						storyUserId: storyUserId
				   	},
			      	success:function(data){
				      	//not yet
			      	},
			      	beforeSend:function(){
			      		$(self).toggleClass('active');
			      	},
			      	error:function(request, status, error){
			      		$(self).toggleClass('active');
			      	}
				});
			}else{
				navigateToLogin();
			}
		});
		
		$('.comment-write-button').click(function(){
			var contentTag = $(document.getElementById('comment-text'));
			var content = contentTag.val();
			
			if(content.length > 0){
				var storyId = "${story.id}";
				var storyUserId = "${story.user.id}";
				var userId = "${sessionScope.user.id}";
				var commentList =$('.comment-list:last');

				
				$.ajax({
					type : "POST",
					url : "${contextPath}/stories/" + storyId + "/comment",
					data:{
						userId: userId,
						storyUserId: storyUserId,
						content:content
				   	},
			      	success:function(data){
			      		var userAvatarUrl ="http://d3fmxlpcykzndk.cloudfront.net/nongjik/images/users/avatars/";
						var commentCssClass = "story-comment";
												
						var storyCommentActvityTemplate = '<span id="comment-edit-button">수정</span><span id="comment-delete-button">삭제</span>';
						
						var storyCommentTemplate = '<li><div class="' + commentCssClass +  '" data-id="' + this.id + '">' +
								'<div class="comment-left"><img class="user-avatar" alt="" src="' + userAvatarUrl + this.user.avatar + '"></div>' + 
								'<div class="comment-right"><div class="comment-description"><span class="user-name">' + this.user.name + '</span><span class="comment-date">방금</span>' +
								storyCommentActvityTemplate + '</div><div class="comment-content">' + this.content + '</div></div></div></li>';

						commentList.after(storyCommentTemplate);
			      	},
			      	beforeSend:function(){
			      		contentTag.empty();
			      	},
			      	error:function(request, status, error){
			      		contentTag.val(content);
			      	}
				});
			}
		});
		
		function navigateToLogin(){
			location.href = "${contextPath}/login"; 
		}
	</script>
</div>