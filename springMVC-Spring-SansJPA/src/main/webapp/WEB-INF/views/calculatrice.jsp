<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calculatrice</title>
</head>
<body>
	<h1>Calculatrice</h1>
	<div class="calcul">
		<form method="post">
			<div class="form-group">
				<label for="nb1">nombre 1:</label> <input id="nb1" name="nombre1"
					class="form-control" />
			</div>
			<div class="form-group">
				<label for="ope">operateur:</label> <input id="ope" name="operateur"
					class="form-control" />
			</div>
			<div class="form-group">
				<label for="nb1">nombre 2:</label> <input id="nb2" name="nombre2"
					class="form-control" />
			</div>
			<button>=</button>
		</form>
		<p>${calculDomaine.resultatTexte}</p>
	</div>


</body>
</html>