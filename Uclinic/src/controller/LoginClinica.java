package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConnessioneDB;
import dao.ClinicaDAO;
import model.Clinica;

@WebServlet("/LoginClinica")
public class LoginClinica extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Clinica clinique;
    
	public LoginClinica() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		ConnessioneDB con = new ConnessioneDB();
		try (PrintWriter out = response.getWriter()) {
			String email = request.getParameter("login-emailC");
			String password = request.getParameter("login-passwordC");	
			Clinica clinica = ClinicaDAO.loginClinica(email, password);
			if (clinica != null) {
				request.getSession().setAttribute("utenteC", clinica);
				clinique = (Clinica) request.getSession().getAttribute("utenteC");
				response.sendRedirect("profiloClinica.jsp?id="+clinica.getIdClinica());
			} else {
				response.sendRedirect("LoginErrore.jsp");//pagina di errore
			}

		}
	}

}