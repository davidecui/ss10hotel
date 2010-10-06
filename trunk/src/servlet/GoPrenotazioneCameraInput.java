package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoPrenotazioneCameraInput extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher dispatcher= null;
		String url = null;
		
		String numero = req.getParameter("numero");//To get chamber number 
		req.setAttribute("numero", numero);
		
		url = "/WEB-INF/jsp/prenotazioneCameraInput.jsp";
		dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		this.doGet(req, resp);
	}

}
