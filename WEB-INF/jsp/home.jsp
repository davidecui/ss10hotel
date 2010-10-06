<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestionale Hotel</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.5/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/custom.css" />
</head>
<body>
<div align="center">
	<p>Benvenuto in <b>Gestionale Hotel</b>! </p>
	
	<p>Il software del 3000!</p>
	
	<img src="resources/images/gestionale_hotel.jpg"></img>
	
	<p>Sperimenta le nostre funzionalità:</p>
	<br /><br />
	
	<c:url var="indirizzo" value="/goConfigura"></c:url>
	<form action="${indirizzo}" method="post">
		<input type="submit" value="configura struttura"/>
	</form>

<br/>

	<c:url var="indirizzo" value="/goVerificaDisponibilita"></c:url>
	<form action="${indirizzo}" method="post">
		<input type="submit" value="verifica disponibilita'"/>
	</form>
</div>
</body>
</html>
