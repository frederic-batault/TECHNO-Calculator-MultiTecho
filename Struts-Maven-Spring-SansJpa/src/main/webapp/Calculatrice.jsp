<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="css/style.css">
<title>Calculatrice</title>
</head>
<s:head />

<body>
	<div class="container">
		<div class="titre">
			<h1>Calculatrice</h1>
		</div>
		<div class="entree">
			<s:form action="calculer">
				<s:textfield key="refCalculDomaine.nombre1" label="nombre1"
					type="number" />
				<s:select key="refCalculDomaine.operateur" list="operateurs"
					listKey="code" listValue="symbole" label="operation" type="number" />
				<s:textfield key="refCalculDomaine.nombre2" label="nombre2"
					type="number" />
				<s:submit value="=" />

			</s:form>

		</div>
		<div class="resultat">
			<p><s:property value="refCalculDomaine.resultatTexte" /></p>
		</div>
		<div class="memoire">
			<s:form action="memoriser">
				<s:submit value="MEM" />
			</s:form>

			<s:form action="afficher">
				<s:submit value="MR" />
			</s:form>
		</div>
	</div>
</body>
</html>