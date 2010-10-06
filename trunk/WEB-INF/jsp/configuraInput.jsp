<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Configurazione Struttura</title>
<link rel="stylesheet" type="text/css" href="resources/css/custom.css" />
</head>
<body>

<c:url var="indirizzo" value="/configura"></c:url>

<form method="post" action='${indirizzo}'>
	<table border="1">
	<tr>
		<td>Numero Piani</td>
		<td><input size="3" type="text" name="numeroPiani" value="12"/></td>
	</tr>
	<tr>
		<td>Numero Singole per piano</td>
		<td> <input size="3" type="text" name="numeroSingolePerPiano" value="34"/></td>
	</tr>
	<tr>
		<td>Numero Doppie per piano</td>
		<td><input size="3" type="text" name="numeroDoppiePerPiano" value="34"/></td>
	</tr>
	<tr>
		<td>Numero Suite per piano</td>
		<td><input size="3" type="text" name="numeroSuitePerPiano" value="34"/></td>
	</tr>
	</table>
	<br />
	<input type="submit" value="Configura"></input>
</form>

<br />
<c:url var="indirizzo" value="/home"></c:url>
<a href="${indirizzo}">Go back</a>

<c:if test="${failedValue == 1}">
	<div align="center">
		<i>I parametri non sono stati inseriti o sono stati inseriti non come interi. Riprova!</i>
	</div>
</c:if>

</body>
</html>
