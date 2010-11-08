<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Prenotazione Camera</title>
<link type="text/css" href="resources/css/ui-lightness/jquery-ui-1.8.5.custom.css" rel="stylesheet" />	
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.5/jquery-ui.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.ui.datepicker-it.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/custom.css" />
<script>
	$(function() {
		$.datepicker.regional[ "it" ];
		$( "#datepicker" ).datepicker({ numberOfMonths: 3, showButtonPanel: true });
		$( "#datepicker2" ).datepicker({ numberOfMonths: 3, showButtonPanel: true });
	});
</script>

<link rel="stylesheet" type="text/css" href="resources/css/custom.css" />
</head>
<body>
	<form method="post" action="prenotaCamera">
		<table>
			<thead>
				<tr>
					<th>
					<b>Prenotazione Camera <c:out value="${numero}"></c:out></b>  
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td align="right">
						Nome:
					</td>
					<td align="left">
						<input type="text" name="nome"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						Cognome:
					</td>
					<td align="left">
						<input type="text" name="cognome"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						Cellulare:
					</td>
					<td align="left">
						<input type="text" name="cellulare"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						Email:
					</td>
					<td align="left">
			
						<input type="text" name="email"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<p>La camera &egrave; libera dal <c:out value="${dataInizio}" /> al  <c:out value="${dataFine}" /></p>
					</td>
				</tr>
				<tr>
					<td align="right">
						Data inizio prenotazione:
					</td>
					<td align="left">
						<input type="text" name="dataInizio" id="datepicker" value=" ${dataInizio}"/>
					</td>				
				</tr>
				<tr>
					<td align="right">
						Data fine prenotazione: 
					</td>
					<td align="left">
						<input type="text" name="dataFine" id="datepicker2" value="${dataFine}"/>
					</td>
				</tr>
				<tr>
					<td align="right" colspan="2">
						<input type="submit" value="Prenota"/>
					</td>	
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>