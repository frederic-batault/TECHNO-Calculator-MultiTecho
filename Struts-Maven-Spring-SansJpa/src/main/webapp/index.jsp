<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de redirection</title>
</head>

<body>

	<s:form action="start">
		<s:submit>Cliquer ici</s:submit>
	</s:form>
	
	<a href="<s:url action="start" method="demarrer"/>">Cliquer ici</a>
	
	<a href="<s:url action="start"/>">Cliquer ici</a>

</body>
</html>