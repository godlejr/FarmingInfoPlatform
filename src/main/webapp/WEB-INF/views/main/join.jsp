<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="content">
	<div class="content-body">
		<div class="join-header">
			<img src="<c:url value='/resources/static/img/main/logo.jpg' />"
				class="header-logo">
		</div>

		<div class="join-content">
			<div class="join-content-body">
				<form:form class="join-form" method="post"
					modelAttribute="user">
					<div class="form-radio">
						<form:radiobutton id="basic" path="level" value="0" label="개인회원" />
						<form:radiobutton id="business" path="level" value="1"
							label="기업회원" />
					</div>

					<div class="from-text" id="business-div">
						<form:input class="member-input" id="join-business" type="text"
							path="avatar" placeholder="사업가 등록번호" />
						<input class="business-button" type="button" value="인증" />
					</div>

					<div class="from-text">
						<form:input class="member-input" id="join-email" type="text"
							path="email" placeholder="email" name = "email"/>
						<form:errors path="email" class="error" />
					</div>
					<div class="from-text">
						<form:input class="member-input" id="join-password" name="password"
							type="password" path="password" placeholder="비밀번호" />
						<form:errors path="password" class="error" />
					</div>
					<div class="from-text">
						<form:input class="member-input" id="join-password-confirm"
							name="joinPasswordConfirm" type="password" path="passwordConfirm"
							placeholder="비밀번호 확인" />
						<form:errors path="passwordConfirm" class="error"
							id="confirm-password-error" />
					</div>
					<div class="from-text">
						<form:input class="member-input" id="join-name" type="text"
							path="name" placeholder="이름" name="name"/>
						<form:errors path="name" class="error" />
					</div>


					<div class="form-button">
						<input class="join-button" type="submit" value="회원가입" />
					</div>

				</form:form>
			</div>
		</div>
	</div>
</div>



<script type="text/javascript">
	$('input:radio[name=level]').change(function() {
		var businessDiv = $("#business-div");

		if ($('#business').prop("checked")) {
			businessDiv.css("display", "block");
		} else {
			businessDiv.css("display", "none");
		}
	});

	
	$('.business-button').click(function(){
		
	});


</script>

