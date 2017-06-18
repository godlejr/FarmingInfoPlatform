<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>


<div class="container-content">
	<div class="content-body">
		<div class="section-join">
			<div class="join-header">
				<a href="${contextPath}/"><img
					src="<c:url value='/resources/static/img/main/logo.jpg' />"
					class="header-logo"></a>
			</div>

			<div class="join-container">
				<form:form class="join-form" method="post" modelAttribute="user">
					<div class="form-radio">
						<div class="left-radio">
							<form:radiobutton id="basic" path="level" value="1"
								checked="checked" />
							<span class="radio-text">개인회원</span>
						</div>
						<div class="right-radio">
							<form:radiobutton id="business" path="level" value="2" />
							<span class="radio-text">기업회원</span>
						</div>
					</div>

					<div class="form-text" id="business-no" hidden="hidden">
						<form:input class="user-input" type="text" path="businessNo"
							placeholder="사업자 등록번호('-' 없이 입력)" />
					</div>
					<form:errors id="business-no-error" path="businessNo" class="error" />

					<div class="form-text">
						<form:input class="user-input" type="text" path="email"
							placeholder="email" />
					</div>
					<form:errors path="email" class="error" />

					<div class="form-text">
						<form:input class="user-input" type="text" path="name"
							placeholder="이름" />
					</div>
					<form:errors path="name" class="error" />

					<div class="form-text">
						<form:input class="user-input" type="password" path="password"
							placeholder="비밀번호" />
					</div>
					<form:errors path="password" class="error" />

					<div class="form-text">
						<form:input class="user-input" type="password"
							path="passwordConfirm" placeholder="비밀번호 확인" />
					</div>
					<form:errors path="passwordConfirm" class="error" />

					<div class="form-button">
						<input class="join-button" type="submit" value="회원가입" />
					</div>

				</form:form>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	if ($('input:radio[name="level"]:radio:checked').val() == 2) {
		$('#business-no').show();
	} else {
		$('#business-no').hide();
		$('#business-no-error').hide();
	}

	$('input:radio[name="level"]').change(function() {
		$('.error').hide();
		if ($(this).val() == 2) {
			$('#business-no').show();

		} else {
			$('#business-no').hide();

		}
	});
	
	
</script>
