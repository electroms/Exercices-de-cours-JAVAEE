package fr.humanbooster.fx.cadeaux.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.fx.cadeaux.business.Utilisateur;
import fr.humanbooster.fx.cadeaux.service.UtilisateurService;
import fr.humanbooster.fx.cadeaux.service.impl.UtilisateurServiceImpl;

/**
 * Servlet implementation class connexionServlet
 */
@WebServlet(urlPatterns = {"/connexion"}, loadOnStartup = 1)
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UtilisateurService utilisateurService = new UtilisateurServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		request.getRequestDispatcher("connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur utilisateur = utilisateurService.recupererUtilisateurParEmailEtMDP(request.getParameter("EMAIL"), request.getParameter("MOT_DE_PASSE"));
		if (utilisateur == null) {
			request.getRequestDispatcher("connexion.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("utilisateur", utilisateur);
			response.sendRedirect("Cadeau");
		}
		
		
	}

}
