package controllerClinica;

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

@WebServlet("/loginClinica")
public class LoginClinica extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int idClinica;

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
			ClinicaDAO cdao = new ClinicaDAO(con.getCon());
			Clinica clinica = cdao.loginClinica(email, password);
			if (clinica != null) {
				request.getSession().setAttribute("utenteC", clinica);
				request.getSession().setAttribute("idClinica", clinica.getIdClinica());
				idClinica = (Integer) request.getSession().getAttribute("idClinica");
				response.sendRedirect("home.jsp");
			} else {
				response.sendRedirect("errore.jsp");//pagina di errore
			}

		}
	}

}