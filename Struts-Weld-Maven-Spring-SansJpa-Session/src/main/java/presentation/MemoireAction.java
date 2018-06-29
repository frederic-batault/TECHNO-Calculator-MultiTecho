package presentation;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import domaine.CalculDomaine;
import domaine.Memoire;
import service.IMemoireService;
import service.MemoireService;

@SessionScoped @Named("memoireAction")
public class MemoireAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> userSession;

	
	private CalculDomaine refCalculDomaine;

	
	private Memoire refMemoire;

	@Inject
	private IMemoireService refMemoireService;

	// Constructeurs

	public MemoireAction(CalculDomaine refCalculDomaine, Memoire refMemoire, MemoireService refMemoireService) {
		super();
		this.refMemoire = refMemoire;
		this.refMemoireService = refMemoireService;
		this.refCalculDomaine = refCalculDomaine;

	}

	public MemoireAction() {
		super();
	}

	// getters et setters

	public CalculDomaine getRefCalculDomaine() {
		return refCalculDomaine;
	}

	public void setRefCalculDomaine(CalculDomaine refCalculDomaine) {
		this.refCalculDomaine = refCalculDomaine;
	}

	public Memoire getRefMemoire() {
		return refMemoire;
	}

	public void setRefMemoire(Memoire refMemoire) {
		this.refMemoire = refMemoire;
	}

	public void setSession(Map<String, Object> session) {
		this.userSession = session;
	}
	
	
	
	public void init() {

		this.refCalculDomaine = (CalculDomaine) this.userSession.get("calcul");
	}


	
	// methode pour memoriser un resultat
	public String memoriser() {
		init();
		double resultat;
		try {
			resultat = Double.valueOf(this.refCalculDomaine.getResultatTexte());
		} catch (NumberFormatException e) {
			resultat = 0;
		}
		this.refMemoire = new Memoire(resultat, this.refCalculDomaine.getResultatTexte());
		boolean retour = refMemoireService.memoriser(refMemoire);
		if (retour == true) {

			return "success";
		} else {

			return "error";
		}
	}

	// methode pour afficher la memoire dans le champ i
	public String afficherMemoire() {
		init();
		Memoire refMem = refMemoireService.afficherMemoire();
		if (refMem.equals(null)) {
			return "error";
		} else {
			this.refCalculDomaine.setNombre1(refMem.getMemoire());
			this.refCalculDomaine.setNombre2(refMem.getMemoire());
			this.userSession.put("calcul", this.refCalculDomaine);
			return "success";
		}

	}

}
