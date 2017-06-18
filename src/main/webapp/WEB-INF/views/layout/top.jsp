<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="<%= request.getContextPath()%>"></c:set>
<c:set var="cloudFrontUserAvatarPath" value="http://d3fmxlpcykzndk.cloudfront.net/nongjik/images/users/avatars/"></c:set>    

<div class="top-content">
	<div class="content-body">
		<div class="section-logo">
			<img src="<c:url value='/resources/static/img/main/logo.jpg' />"
				class="header-logo">
		</div>

		<c:choose>
			<c:when test="${sessionScope.user != null}">
				<div class="section-session">
					<div class="session-info">
						<img class="session-avatar" src="${cloudFrontUserAvatarPath}${sessionScope.user.avatar}" />
						<div class="session-content">
							<span>${sessionScope.user.name}님</span>
						</div>
						<div class="session-notification">
							<i class="fa fa-bell" aria-hidden="true"></i>
						</div>
						<div class="session-release">
							<span>로그아웃</span>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="section-login">
					<div class="login-left">
						<div class="login-icon">
							<i class="fa fa-user" aria-hidden="true"></i>
						</div>
						<div class="login-button">
							<span>로그인</span>
						</div>
					</div>

					<div class="login-right">
						<div class="login-icon">
							<i class="fa fa-user-plus" aria-hidden="true"></i>
						</div>
						<div class="join-button">
							<span>회원가입</span>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>

	</div>
</div>

<script>
	$('.login-left').click(function() {
		document.location.href = "${pageContext.request.contextPath}/login";
	});

	$('.login-right').click(function() {
		document.location.href = "${pageContext.request.contextPath}/join";
	});
</script>