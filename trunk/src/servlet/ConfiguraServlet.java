package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ParametriStruttura;
import model.Struttura;

public class ConfiguraServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = null;
		Struttura struttura = null;
		ParametriStruttura parametriStruttura = null;
		String url;
		String numeroPianiStr;
		String numeroSingolePerPianoStr;
		String numeroDoppiePerPianoStr;
		String numeroSuitePerPianoStr;
		int numeroPiani;
		int numeroSingolePerPiano;
		int numeroDoppiePerPiano;
		int numeroSuitePerPiano;
		
		url = "/home";
		
		if(!req.getParameter("numeroPiani").equals("") & !req.getParameter("numeroSingolePerPiano").equals("") & !req.getParameter("numeroDoppiePerPiano").equals("") & !req.getParameter("numeroSuitePerPiano").equals("")){
			numeroPianiStr = req.getParameter("numeroPiani");
			numeroSingolePerPianoStr = req.getParameter("numeroSingolePerPiano");
			numeroDoppiePerPianoStr = req.getParameter("numeroDoppiePerPiano");
			numeroSuitePerPianoStr = req.getParameter("numeroSuitePerPiano");
			try {
				numeroPiani = Integer.parseInt(numeroPianiStr);
				numeroSingolePerPiano = Integer.parseInt(numeroSingolePerPianoStr);
				numeroDoppiePerPiano = Integer.parseInt(numeroDoppiePerPianoStr);
				numeroSuitePerPiano = Integer.parseInt(numeroSuitePerPianoStr);
				
				parametriStruttura = new ParametriStruttura();
				parametriStruttura.setNumeroPiani(numeroPiani);
				parametriStruttura.setNumeroSingolePerPiano(numeroSingolePerPiano);
				parametriStruttura.setNumeroDoppiePerPiano(numeroDoppiePerPiano);
				parametriStruttura.setNumeroSuitePerPiano(numeroSuitePerPiano);
				
				struttura = new Struttura();
				struttura.initialize(parametriStruttura);
				struttura.generaPrenotazioni();
				this.getServletContext().setAttribute("struttura", struttura);
				
			} catch (Exception e) {
				url = "/goConfigura";
				req.setAttribute("failedValue", 1);
			}
			
		}else{
			req.setAttribute("failedValue", 1);
			url = "/goConfigura";
		}
		dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		this.doGet(req, resp);
	}
	
}
