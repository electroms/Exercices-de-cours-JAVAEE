package fr.humanbooster.fx.cadeaux.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.fx.cadeaux.business.Commande;
import fr.humanbooster.fx.cadeaux.business.Utilisateur;
import fr.humanbooster.fx.cadeaux.service.CommandeService;
import fr.humanbooster.fx.cadeaux.service.impl.CommandeServiceImpl;

/**
 * Servlet implementation class ListeCommande
 */
@WebServlet(urlPatterns = {"/listeCommande"}, loadOnStartup = 1)
public class ListeCommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CommandeService commandeService = new CommandeServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeCommandeServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		List<Commande> commandes = commandeService.recupererCommandesUtilisateur(utilisateur);
		request.setAttribute("commandes", commandes);
		
		
		
		request.getRequestDispatcher("listeCommande.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
