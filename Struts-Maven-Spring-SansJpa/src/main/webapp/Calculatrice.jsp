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
	<div class="container">
		<div class="titre">
			<h1>Calculatrice</h1>
		</div>
		<div class="calcul">
			<s:form action="calculer">
				<s:textfield key="calculAction.refCalculDomaine.nombre1"
					label="nombre1" />
				<s:select key="calculAction.refCalculDomaine.operateur" list="operateurs"
					listKey="code" listValue="symbole" label="operation" />
				<s:textfield key="calculAction.refCalculDomaine.nombre2"
					label="nombre2" />
				<s:submit value="="/>
				
			</s:form>
			
		</div>
		<div class="resultat">
			<h2><s:property value="calculAction.refCalculDomaine.resultatTexte" /></h2>
		</div>
		<div class="memoire">
			<s:form action="memoriser">
				<s:submit>MEM</s:submit>
			</s:form>

			<s:form action="afficher">
				<s:submit>MR</s:submit>
			</s:form>
		</div>
	</div>
</body>
</html>