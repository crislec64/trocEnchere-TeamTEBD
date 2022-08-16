package fr.eni.tebd.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tebd.bo.Article;
import fr.eni.tebd.dal.ArticleDAO;
import fr.eni.tebd.dal.DAOFactory;

@WebServlet(urlPatterns = {"/Index",""})
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		ArticleDAO articleDAO = DAOFactory.getArticleDAO();
        List<Article> articles = articleDAO.selectall();
        request.getSession().setAttribute("articles", articles);      
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/article/afficherArticles.jsp");
        rd.forward(request, response);
        
        
	}

}

