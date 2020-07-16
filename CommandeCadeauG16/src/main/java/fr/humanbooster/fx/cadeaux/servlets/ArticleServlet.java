package fr.humanbooster.fx.cadeaux.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.fx.cadeaux.business.Article;
import fr.humanbooster.fx.cadeaux.service.ArticleService;
import fr.humanbooster.fx.cadeaux.service.impl.ArticleServiceImpl;

/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet(urlPatterns = { "/article" }, loadOnStartup = 1)
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArticleService articleService = new ArticleServiceImpl();
	
	private static Article article = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticleServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long idArticle = Long.parseLong(request.getParameter("ID"));
		article = articleService.recupererArticleByID(idArticle);
		request.setAttribute("article", article);

		request.getRequestDispatcher("article.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
