<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Download manual da lib do JSTL https://caelum-online-public.s3.amazonaws.com/986-servlets-parte1/05/jstl-1.2.jar -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTl - java Standart TagLib</title>
</head>
<body>
	<h1>Lista de empresas:</h1>
	<ul>
		<c:forEach items="${empresas}" var="e">
			<li>${e.nome}</li>
		</c:forEach>
	</ul>
</body>
</html>