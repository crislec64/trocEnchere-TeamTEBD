package fr.eni.tebd.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tebd.dal.DAOFactory;
import fr.eni.tebd.dal.UtilisateurDAO;

@WebServlet("/Supprimer")
public class Supprimer extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int noUtilisateur = Integer.parseInt(request.getParameter("noUtilisateur"));


		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		
		utilisateurDAO.delete(noUtilisateur);
		request.getSession().removeAttribute("utilisateur");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/page/confirmation.jsp");
		rd.forward(request, response);
	}

}
