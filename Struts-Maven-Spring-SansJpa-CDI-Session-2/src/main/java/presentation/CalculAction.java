package presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import domaine.CalculDomaine;
import domaine.Operateur;
import service.ICalculService;

@SessionScoped
@Named("calculAction")
public class CalculAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> userSession;

	private CalculDomaine refCalculDomaine;

	@Inject
	private ICalculService refCalculService;

	private List<Operateur> operateurs;

	// Constructeurs

	public CalculAction(CalculDomaine refCalculDomaine, ICalculService refCalculService, List<Operateur> operateurs) {
		super();
		this.refCalculDomaine = refCalculDomaine;
		this.refCalculService = refCalculService;
		this.operateurs = operateurs;

	}

	public CalculAction() {
		super();
	}

	// getters et setters

	public CalculDomaine getRefCalculDomaine() {
		return refCalculDomaine;
	}

	public void setRefCalculDomaine(CalculDomaine refCalculDomaine) {
		this.refCalculDomaine = refCalculDomaine;
	}

	public List<Operateur> getOperateurs() {
		return operateurs;
	}

	public void setOperateurs(List<Operateur> operateurs) {
		this.operateurs = operateurs;
	}

	public void setSession(Map<String, Object> session) {
		this.userSession = session;
	}

	// methode de preparation des champs

	public String demarrer() {
		lister();
		this.userSession.put("operateurs", this.operateurs); // mise en session de la liste des operateurs
		this.refCalculDomaine = (CalculDomaine) this.userSession.get("calcul"); // recuperation en session d'un calcul
		if (this.refCalculDomaine == null) {
			this.refCalculDomaine = new CalculDomaine(0, 1, 0, 0, "0");
			this.userSession.put("calcul", this.refCalculDomaine); // mise en session du calcul contenant des zeros
		}

		return "success";

	}

	public void lister() {
		// construction de la liste des operateurs proposes
		this.operateurs = new ArrayList<Operateur>();
		this.operateurs.add(new Operateur(1, "+"));
		this.operateurs.add(new Operateur(2, "-"));
		this.operateurs.add(new Operateur(3, "*"));
		this.operateurs.add(new Operateur(4, "/"));
	}

	// methode de calcul
	public String calcul() {
		CalculDomaine retour = this.refCalculService.choixOperateur(this.refCalculDomaine);
		this.refCalculDomaine.setResultat(retour.getResultat());
		this.refCalculDomaine.setResultatTexte(retour.getResultatTexte());
		this.userSession.put("calcul", this.refCalculDomaine); // mise en session du calcul avec resultat
		return "success";
	}

}
