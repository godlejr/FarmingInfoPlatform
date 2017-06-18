<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<div class="container-content">
	<div class="content-body">

		<div class="section-login">
			<div class="login-header">
				<a href="${contextPath}/"><img
					src="<c:url value='/resources/static/img/main/logo.jpg' />"
					class="header-logo"></a>
			</div>

			<div class="login-container">
				<form:form class="login-form" method="post" modelAttribute="user">
					<div class="form-text">
						<form:input class="user-input" type="text" path="email"
							placeholder="email" />
					</div>
					<div class="form-text">
						<form:input class="user-input" type="password" path="password"
							placeholder="password" />
					</div>

					<div class="form-button">
						<input class="login-button" type="submit" value="로그인" />
					</div>

					<c:if test="${message != null}">
						<c:choose>
							<c:when test="${isJoined == true}">
								<div class="login-message join">
									<span>${message}</span>
								</div>

							</c:when>
							<c:otherwise>
								<div class="login-message">
									<span>${message}</span>
								</div>
							</c:otherwise>
						</c:choose>
					</c:if>
				</form:form>
			</div>

			<div class="login-join">
				<span>회원가입</span>
			</div>

			<div class="login-sns">
				<div class="facebook-button">
					<span>페이스북으로 로그인</span>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$('.login-join').click(function() {
		document.location.href = "${contextPath}/join";
	});

	$('.login-join').hover(function() {
		$(this).css("color", "#555");
	}, function() {
		$(this).css("color", "#bbb");
	});
</script>