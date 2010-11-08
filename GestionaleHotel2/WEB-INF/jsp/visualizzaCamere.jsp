<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@page import="model.Camera" %>
<%-- <%@page import="service.search.RisultatoRicerca" --%>--%>
<%@page import="model.RisultatoRicerca" %>
<%@page import="java.util.*" %>    
<%
		RisultatoRicerca risultatoRicerca= (RisultatoRicerca)request.getAttribute("ricerca");		
		String dataInizio= risultatoRicerca.getDataInizio().toLocaleString();
		String dataFine= risultatoRicerca.getDataFine().toLocaleString();
	
		ArrayList<Camera> listaCamere= (ArrayList<Camera>)request.getAttribute("listaCamere");
		String tipologia= listaCamere.get(0).getTipologia();
		int piano= listaCamere.get(0).getPiano();
%>    
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Prenotazione camera</title>
<link rel="stylesheet" type="text/css" href="resources/css/custom.css" />
</head>
<body>
		<h3 align="center">Lista delle camere <b><%= tipologia%></b> per il piano <b><%= piano%></b>, 
		disponibili dal <b><%= dataInizio%></b> al <b><%= dataFine%></b></h3>
		<table border="1" align="center">
			<thead><th style="color: green">Seleziona camera</th></thead>
			<tbody>
				<%
					boolean color= true;
					String stile1= "color:white;background:black;cursor:pointer";
					String stile2= "color:black;background:white;cursor:pointer";
					
					//GoPrenotazioneCameraInput?numero=
					for(Camera c: listaCamere){
						String colore= color?stile1:stile2;
						String link= "location.href='goPrenotazioneCameraInput?numero=" + c.getNumero() + "'";
						out.println("<tr style=\"" + colore + "\"><td width=\"100px\" onclick=\"" + link + "\">" + c.getNumero() + "</td></tr>");
						color= !color;
					}
				%>
			</tbody>
		</table>
		
		<br>
		<c:url var="url" value="home" />
		<a href="${url}">Vai alla home</a>
				
</body>
</html>