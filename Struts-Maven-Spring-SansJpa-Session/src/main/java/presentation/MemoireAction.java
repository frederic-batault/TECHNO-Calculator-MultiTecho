package presentation;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import domaine.CalculDomaine;
import domaine.Memoire;
import domaine.Operateur;
import service.MemoireService;

public class MemoireAction implements SessionAware{

	private Map<String, Object> userSession ;
	
	private List<Operateur> operateurs;
	
	@Autowired
	private CalculDomaine refCalculDomaine;

	@Autowired
	private Memoire refMemoire;

	@Autowired
	private MemoireService refMemoireService;

	// Constructeurs

	public MemoireAction(CalculDomaine refCalculDomaine, Memoire refMemoire, MemoireService refMemoireService, List<Operateur> operateurs) {
		super();
		this.refMemoire = refMemoire;
		this.refMemoireService = refMemoireService;
		this.refCalculDomaine = refCalculDomaine;
		this.operateurs = operateurs;

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

	public MemoireService getRefMemoireService() {
		return refMemoireService;
	}

	public void setRefMemoireService(MemoireService refMemoireService) {
		this.refMemoireService = refMemoireService;
	}

	@PostConstruct
	public void init() {
		this.operateurs = (List<Operateur>) this.userSession.get("operateurs");
		this.refCalculDomaine = (CalculDomaine) this.userSession.get("calcul");
	}
	
	
	
	public void setSession(Map<String, Object> session) {
		   this.userSession = session ;
		}
	
	
	
	// methode pour memoriser un resultat
	public String memoriser() {
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
		Memoire refMem = refMemoireService.afficherMemoire();
		if (refMem.equals(null)) {
			return "error";
		} else {
			this.refCalculDomaine.setNombre1(refMem.getMemoire());
			this.refCalculDomaine.setNombre2(refMem.getMemoire());
			this.userSession.put("calcul",this.refCalculDomaine);
			return "success";
		}

	}

}
