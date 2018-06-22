package presentation;


import java.util.ArrayList;
import java.util.List;

import domaine.CalculDomaine;
import domaine.Memoire;
import domaine.Operateur;
import service.CalculService;
import service.MemoireService;

public class CalculAction {

	
	private CalculDomaine refCalculDomaine;

	
	private CalculService refCalculService;

	private List<Operateur> operateurs;

	
	private Memoire refMemoire;

	
	private MemoireService refMemoireService;

	// Constructeurs

	public CalculAction(CalculDomaine refCalculDomaine, CalculService refCalculService, List<Operateur> operateurs,
			Memoire refMemoire, MemoireService refMemoireService) {
		super();
		this.refCalculDomaine = refCalculDomaine;
		this.refCalculService = refCalculService;
		this.operateurs = operateurs;
		this.refMemoire = refMemoire;
		this.refMemoireService = refMemoireService;

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

	public CalculService getRefCalculService() {
		return refCalculService;
	}

	public void setRefCalculService(CalculService refCalculService) {
		this.refCalculService = refCalculService;
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

	public MemoireService getRefMemoireService() {
		return refMemoireService;
	}

	public void setRefMemoireService(MemoireService refMemoireService) {
		this.refMemoireService = refMemoireService;
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
		double resultat;
		try {
			resultat = Double.valueOf(this.refCalculDomaine.getResultatTexte());
		}
		catch (NumberFormatException e){
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
