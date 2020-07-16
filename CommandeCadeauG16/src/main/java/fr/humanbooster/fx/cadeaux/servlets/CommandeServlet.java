package fr.humanbooster.fx.cadeaux.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.fx.cadeaux.business.Article;
import fr.humanbooster.fx.cadeaux.business.Commande;
import fr.humanbooster.fx.cadeaux.business.Utilisateur;
import fr.humanbooster.fx.cadeaux.exceptions.StockInsuffisantException;
import fr.humanbooster.fx.cadeaux.service.ArticleService;
import fr.humanbooster.fx.cadeaux.service.CommandeService;
import fr.humanbooster.fx.cadeaux.service.impl.ArticleServiceImpl;
import fr.humanbooster.fx.cadeaux.service.impl.CommandeServiceImpl;

/**
 * Servlet implementation class CommandeServlet
 */
@WebServlet(urlPatterns = {"/commande"}, loadOnStartup = 1)
public class CommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CommandeService commandeService = new CommandeServiceImpl();
	private static ArticleService articleService = new ArticleServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Commande commande = (Commande) request.getSession().getAttribute("commande");
		request.setAttribute("commande", commande);
		
		request.getRequestDispatcher("commande.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("utilisateur") != null) {
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");

		Commande commande = null;
		Article article = articleService.recupererArticleByID(Long.parseLong(request.getParameter("ID")));

		try {
			commande = commandeService.ajouterCommande(new Date(), quantite, article, utilisateur);
			
		} catch (StockInsuffisantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("commande", commande);
		request.getSession().setAttribute("commande", commande);
		}
		doGet(request, response);
		
	}

}
