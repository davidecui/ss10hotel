<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ricerca</title>
<link rel="stylesheet" type="text/css" media="all" href="resources/skins/aqua/theme.css" title="Aqua" />
<script type="text/javascript" src="resources/js/calendar.js"></script>
<script type="text/javascript" src="resources/js/calendar-it.js"></script>
<script type="text/javascript" src="resources/js/calendario.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/custom.css" />
</head>
<body>

	<h1 align="center" style="color:orange;" >Ricerca camere disponibili...</h1>
	<form action="verificaDisponibilita">
	<table border="1" align="center">				
		<tbody>
			<tr>
				<td>Data inizio 
				<input type="text" name="dataInizio" id="dataInizio"/><input type="reset" value=" ... " onclick="return showCalendar('dataInizio', '%d/%m/%Y');"></td>
				<td>Data fine <input type="text" name="dataFine" id="dataFine"/><input type="reset" value=" ... " onclick="return showCalendar('dataFine', '%d/%m/%Y');"></td>
				<td><input type="submit" value="Cerca!"/> </td>				
			</tr>			
		</tbody>
	</table>
	</form>

	<br />
	<c:url var="indirizzo" value="/home"></c:url>
	<a href="${indirizzo}">Go back</a>

</body>
</html>