package fr.humanbooster.fx.burger.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommandeServlet
 * Une servlet est une clzasse Java capable de traiter une requete HTTP et de formuler une réponse
 * Les servlets ont été créer en 1997 par SUN
 * L'annotation @WebServlet permet entre autre de préciser la ou les URL que la servlet prend en charge
 */
@WebServlet("/commande")
public class CommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Cette méthode est invoquée lorsque la servlet reçoit une requeste HTTP ayant la méthode GET
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Cette méthode est invoquée lorsque la servlet reçoit une requeste HTTP ayant la méthode POST
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("quelqu'un souhaite passer commande");
		//On redirige vers la JSP traitementCommande.jsp en lui faisant suivre les objets request et response
		request.getRequestDispatcher("traitementCommande.jsp").forward(request, response);
	}

}
