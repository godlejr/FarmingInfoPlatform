<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title><tiles:insertAttribute name="title" /></title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />


<link href="<c:url value='/resources/static/css/style.css' />"
	rel="stylesheet" type="text/css" />

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
	rel="stylesheet" type="text/css">

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/jquery-ui-i18n.min.js"></script>

</head>
<body>
	<div id="container"
		style="background-image:url(<c:url value='/resources/static/img/main/full_bg.jpg' />); height: 100vh; background-repeat: no-repeat;
    background-size: cover;">
		<tiles:insertAttribute name="content" />

		<footer id="footer">
			<div class="footer-content" style="position:absolute;">
				<tiles:insertAttribute name="footer" />
			</div>
		</footer>
	</div>
</body>
</html>