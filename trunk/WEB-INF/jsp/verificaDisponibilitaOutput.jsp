<%@page import="model.Struttura"%>
<%@page import="model.RisultatoRicerca"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ricerca</title>
<link rel="stylesheet" type="text/css" media="all" href="skins/aqua/theme.css" title="Aqua" />
<script type="text/javascript" src="WEB-INF/js/calendar.js"></script>
<script type="text/javascript" src="WEB-INF/js/calendar-it.js"></script>
<script type="text/javascript" src="WEB-INF/js/calendario.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/custom.css" />
</head>
<body>

	<table border="1">				
		<tbody>
			<tr>
				<td>Piano</td>
				<%
					Struttura struttura = (Struttura) application.getAttribute("struttura");
					RisultatoRicerca result = (RisultatoRicerca)request.getAttribute("result");
					for(int j=0;j<struttura.getTipiCamera().size();j++) {
				%>					
				<td> <%= struttura.getTipiCamera().get(j) %> </td>
				<% } %>
			</tr>
			<%
				for(int i=0;i<struttura.getNumeroPiani();i++) {
			%>
				<tr>
					<td> <%=i+1%> </td>
					<% for(int j=0;j<struttura.getTipiCamera().size();j++) { %>
					<td>
					<c:url var="url" value="/visualizzaCamere">
						<c:param name="piano"><%=i+1%></c:param>
						<c:param name="tipologia"><%=j%></c:param>
					</c:url>
					
					<a href="${url}"><%= result.getListaLibere().get(i).get(j).size() %></a> ( <%= result.getListaOccupate().get(i).get(j).size() %> )
					</td>
					<% } %>
				</tr>
			<% } %>
						
		</tbody>
	</table>

</body>
</html>