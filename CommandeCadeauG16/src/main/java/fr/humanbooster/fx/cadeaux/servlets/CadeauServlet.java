package fr.humanbooster.fx.cadeaux.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.fx.cadeaux.business.Categorie;
import fr.humanbooster.fx.cadeaux.service.ArticleService;
import fr.humanbooster.fx.cadeaux.service.CategorieService;
import fr.humanbooster.fx.cadeaux.service.impl.ArticleServiceImpl;
import fr.humanbooster.fx.cadeaux.service.impl.CategorieServiceImpl;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet(urlPatterns = { "/Cadeau" }, loadOnStartup = 1)
public class CadeauServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArticleService articleService = new ArticleServiceImpl();
	private static CategorieService categorieService = new CategorieServiceImpl();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadeauServlet() {
		super();
		if (categorieService.recupereCategories().isEmpty()) {
			Categorie gourmet = categorieService.ajouterCategorie("Gourmet");
			Categorie jouet = categorieService.ajouterCategorie("jouet");
			Categorie informatique = categorieService.ajouterCategorie("informatique");
			Categorie electromenager = categorieService.ajouterCategorie("electromenager");
			Categorie telephonie = categorieService.ajouterCategorie("telephonie");
			Categorie jeux = categorieService.ajouterCategorie("jeux");

			articleService.ajouterArticle("Cafetière Bialetti", 20, 10, gourmet);
			articleService.ajouterArticle("AirPods", 40, 97, jouet);
			articleService.ajouterArticle("Thermomix", 100, 22, gourmet);
			articleService.ajouterArticle("Train", 10, 200, jouet);
			articleService.ajouterArticle("MacBook", 1000, 71, informatique);
			articleService.ajouterArticle("Aspirateur Dyson", 500, 100, electromenager);
			articleService.ajouterArticle("OnePlus 6", 500, 73, telephonie);
			articleService.ajouterArticle("HTC VIVE", 750, 58, jeux);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("articles", articleService.recupereArticles());
		
		
		
		
		
		request.getRequestDispatcher("cadeau.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

	}

}
