
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<c:set var="contextPath" value="<%= request.getContextPath()%>"></c:set>
<c:set var="cloudFrontUserAvatarPath" value="http://d3fmxlpcykzndk.cloudfront.net/nongjik/images/users/avatars/"></c:set>    
<c:set var="cloudFrontStoryImagePath" value="http://d3fmxlpcykzndk.cloudfront.net/nongjik/images/stories/"></c:set>    


<div class="content-list">
	<div class="story-list">
		<c:forEach var="story" items="${stories}">
			${story.files[0].name}
			${story.files[0].ext}
			${story.title}
		</c:forEach>
	</div>
</div>