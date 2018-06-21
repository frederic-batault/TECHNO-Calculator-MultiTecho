<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calculatrice</title>
<link rel="stylesheet" href="css/calculatrice.css">
</head>
<body>
	<div class="container">
		<h1>Calculatrice</h1>
		<jsp:include page="calcul.jsp"></jsp:include>
		<jsp:include page="memoire.jsp"></jsp:include>
		
	</div>
</body>
</html>