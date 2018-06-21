<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Calculatrice</title>
<s:head />
</head>
<body>
	<h1>Calculatrice</h1>

	<s:form action="calculer">
		<s:textfield key="{calculAction.refCalculDomaine.nombre1}" />
		<s:select key="{calculAction.operateur" list="operateurs" listKey="code" listValue="symbole" />
		<s:textfield key="{calculAction.refCalculDomaine.nombre2}" />
		<p>${calculAction.refCalculDomaine.resultatTexte}<p>
		<s:submit>=</s:submit>
	</s:form>
	
	<s:form action="memoriser">
		<s:submit>MEM</s:submit>
	</s:form>
	
	<s:form action="afficher">
		<s:submit>MR</s:submit>
	</s:form>
	
</body>
</html>