package fr.humanbooster.fx.cadeaux.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.fx.cadeaux.business.Utilisateur;
import fr.humanbooster.fx.cadeaux.business.Ville;
import fr.humanbooster.fx.cadeaux.service.UtilisateurService;
import fr.humanbooster.fx.cadeaux.service.VilleService;
import fr.humanbooster.fx.cadeaux.service.impl.UtilisateurServiceImpl;
import fr.humanbooster.fx.cadeaux.service.impl.VilleServiceImpl;

/**
 * Servlet implementation class inscriptionServlet
 */
@WebServlet(urlPatterns = { "/inscription" }, loadOnStartup = 1)
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static VilleService villeService = new VilleServiceImpl();
	private static UtilisateurService utilisateurService = new UtilisateurServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InscriptionServlet() {
		super();
		if (villeService.recupererVilles().isEmpty()) {
			villeService.ajouterVille("Grenoble");
			villeService.ajouterVille("Lyon");
			villeService.ajouterVille("Marseille");
			villeService.ajouterVille("Paris");
		}

	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// on enrichie l'objet request avec la liste des villes
		request.setAttribute("villes", villeService.recupererVilles());

		// on redirige vers la jsp en passant par le response et request
		request.getRequestDispatcher("inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Ville ville = villeService.recupererVilleParId(Long.parseLong(request.getParameter("ID_VILLE")));

		Utilisateur utilisateur = utilisateurService.creerUtilisateur(request.getParameter("NOM"), request.getParameter("PRENOM"),
				request.getParameter("EMAIL"), request.getParameter("MOT_DE_PASSE"), ville);
		
		//on place l'utilisateur dans la session HTTP, il sera connecté après l'inscription.
		request.getSession().setAttribute("utilisateur", utilisateur);
		request.getRequestDispatcher("merciInscription.jsp").forward(request, response);
	}

}
