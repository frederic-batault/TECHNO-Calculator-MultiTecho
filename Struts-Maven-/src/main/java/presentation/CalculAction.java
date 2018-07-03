package presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Container;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.inject.Scope.Strategy;

import domaine.CalculDomaine;
import domaine.Memoire;
import domaine.Operateur;
import service.CalculService;
import service.MemoireService;

public class CalculAction extends ActionSupport implements ICalculAction {

	private static final long serialVersionUID = 1L;

	private CalculDomaine refCalculDomaine;

	@Inject("calculService")
	private CalculService refCalculService;

	private List<Operateur> operateurs;

	private Memoire refMemoire;

	private MemoireService refMemoireService;

	@Inject
	private Container container;
	
	// Constructeurs

	public CalculAction(CalculDomaine refCalculDomaine, List<Operateur> operateurs, Memoire refMemoire) {
		super();
		this.refCalculDomaine = refCalculDomaine;
		this.operateurs = operateurs;
		this.refMemoire = refMemoire;
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

	public Memoire getRefMemoire() {
		return refMemoire;
	}

	public void setRefMemoire(Memoire refMemoire) {
		this.refMemoire = refMemoire;
	}

	
	// methode de preparation des champs

	public String demarrer() {
		lister();
		this.refCalculDomaine = new CalculDomaine(0, 1, 0, 0, "0");
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
		lister();

		CalculDomaine retour = this.refCalculService.choixOperateur(this.refCalculDomaine);
		this.refCalculDomaine.setResultat(retour.getResultat());
		this.refCalculDomaine.setResultatTexte(retour.getResultatTexte());
		return "success";
	}

	// methode pour memoriser un resultat
	public String memoriser() {
		lister();
		this.refMemoireService = new MemoireService();
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
		lister();
		this.refMemoireService = new MemoireService();
		Memoire refMem = refMemoireService.afficherMemoire();
		if (refMem.equals(null)) {
			return "error";
		} else {
			this.refCalculDomaine.setNombre1(refMem.getMemoire());
			this.refCalculDomaine.setNombre2(refMem.getMemoire());
			return "success";
		}

	}

}
