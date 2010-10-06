package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Camera;

import model.RisultatoRicerca;

public class VisualizzaCamereServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		RequestDispatcher dispatcher = null ;
		RisultatoRicerca ricerca = null;
		Integer piano = null ;
		Integer tipologia = null ;
		String url = null ;
		List<Camera> listaCamere = null ;
		
		piano = Integer.parseInt(req.getParameter("piano")) ;
		tipologia = Integer.parseInt(req.getParameter("tipologia")) ;
		ricerca = (RisultatoRicerca) req.getSession().getAttribute("ricerca") ;
		listaCamere = ricerca.getListaLibere().get(piano).get(tipologia) ;
		
		req.setAttribute("listaCamere", listaCamere);
		url = "/WEB-INF/jsp/visualizzaCamere.jsp";
		dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp) ;
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		this.doGet(req, resp);
	}
	
	

}
