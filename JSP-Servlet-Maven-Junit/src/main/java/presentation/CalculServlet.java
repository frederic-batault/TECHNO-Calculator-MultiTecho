package presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domaine.CalculDomaine;
import service.CalculService;

@WebServlet("/CalculServlet")
public class CalculServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CalculServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// récupération des infos du formulaire
		String nombre1Texte = request.getParameter("nombre1");
		double nombre1 = Double.parseDouble(nombre1Texte);
		String operateur = request.getParameter("operateur");
		String nombre2Texte = request.getParameter("nombre2");
		double nombre2 = Double.parseDouble(nombre2Texte);

		// instanciation et appel des méthodes service
		CalculService refService = new CalculService();
		String resultatTexte = "";
		if (operateur.equals("+")) {
			resultatTexte = refService.addition(nombre1, nombre2);
		} else {
			if (operateur.equals("-")) {
				resultatTexte = refService.soustraction(nombre1, nombre2);
			} else {
				if (operateur.equals("*")) {
					resultatTexte = refService.multiplication(nombre1, nombre2);
				} else {
					if (operateur.equals("/")) {
						resultatTexte = refService.division(nombre1, nombre2);
					}
				}
			}
		}

		// création d'un objet avec nombres entrés et résultat
		CalculDomaine refDomaine = new CalculDomaine(nombre1, nombre2, operateur, resultatTexte);

		// mise en session de l'objet
		HttpSession refSession = request.getSession();
		refSession.setAttribute("resultat", refDomaine);

		// renvoi de la page
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
