package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PazienteDAO;
import model.Dottore;

@WebServlet("/CercaDottore")
public class CercaDottore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CercaDottore() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String ricerca = request.getParameter("cerca");
		response.sendRedirect("pagRicerca.jsp?ricerca="+ricerca);
		
	}

}