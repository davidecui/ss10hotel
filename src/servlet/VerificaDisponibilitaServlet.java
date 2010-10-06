package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RisultatoRicerca;
import model.Struttura;
import model.VerificaDisponibilitaService;

public class VerificaDisponibilitaServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher dispatcher= null;
		String url = null;
		HttpSession session = null;
		
		Date checkin = null;
		Date checkout = null;
		
		try {
			checkin = (Date) new SimpleDateFormat("dd/mm/yyyy").parse((String)req.getParameter("dataInizio"));
			checkout = (Date) new SimpleDateFormat("dd/mm/yyyy").parse((String)req.getParameter("dataFine"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Struttura struttura = (Struttura) this.getServletContext().getAttribute("struttura");
		VerificaDisponibilitaService service = new VerificaDisponibilitaService(struttura);
		
		RisultatoRicerca result = service.verificaDisponibilita(checkin,checkout);
		req.setAttribute("result",result);
		session = req.getSession();
		session.setAttribute("ricerca", result);
		
		url = "/WEB-INF/jsp/verificaDisponibilitaOutput.jsp";
		dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}

