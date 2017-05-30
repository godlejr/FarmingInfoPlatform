<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div id="content">
		<div class="content-body">
			<div class="login-header">
				<img src="<c:url value='/resources/static/img/main/logo.jpg' />" class = "header-logo">
			</div>
			<div class="login-content">
				<div class="login-content-body">
					<form:form class="login-form" method="post" modelAttribute="user">
						<div class="form-text">
							<div class="login-row" id="login-email">
								<form:input class = "member-input" type="text" path="email" placeholder="id"  />
								<form:errors path="email" class="error" />
							</div>
							<div class="login-row" id="login-password">
								<form:input class = "member-input" type="password" path="password" placeholder="password" />
								<form:errors path="password" class="error" />
							</div>
						</div>

						<div class="form-button">
							<input class="login-button" type="submit" value="로그인"/>
						</div>
						
					</form:form>
				</div>
					
				<div class="join-content">
					<span>회원가입</span>
				</div>
					
				<div class="login-sns-content">
					<div class="login-facebook">
						<span>페이스북으로 로그인</span>
					</div>
					<div class="login-facebook">
						<span>페이스북으로 로그인</span>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	
<script type="text/javascript">
	$('.join-content').click(
		function(){
			document.location.href="${pageContext.request.contextPath}/join";
		}	
	);
	
	$('.join-content').hover(
		function(){
			$(this).css("color","#555");
		},
		function(){
			$(this).css("color","#bbb");
		}
	);
	
	
</script>