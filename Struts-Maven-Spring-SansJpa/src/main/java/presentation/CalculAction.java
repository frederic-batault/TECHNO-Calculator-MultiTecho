package presentation;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


import domaine.CalculDomaine;
import domaine.Memoire;
import domaine.Operateur;
import service.CalculService;
import service.MemoireService;

public class CalculAction {

	@Autowired
	private CalculDomaine refCalculDomaine;

	@Autowired
	private CalculService refCalculService;

	private List<Operateur> operateurs;

	@Autowired
	private Memoire refMemoire;

	@Autowired
	private MemoireService refMemoireService;

	private int i = 1;
	
	// Constructeurs

	public CalculAction(CalculDomaine refCalculDomaine, CalculService refCalculService, List<Operateur> operateurs,
			Memoire refMemoire, MemoireService refMemoireService, int i) {
		super();
		this.refCalculDomaine = refCalculDomaine;
		this.refCalculService = refCalculService;
		this.operateurs = operateurs;
		this.refMemoire = refMemoire;
		this.refMemoireService = refMemoireService;
		this.i = i;

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

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	// methode de preparation des champs

	public String demarrer() {

		// construction de la liste des operateurs proposes
		this.operateurs = new ArrayList<Operateur>();
		this.operateurs.add(new Operateur(1, "+"));
		this.operateurs.add(new Operateur(2, "-"));
		this.operateurs.add(new Operateur(3, "*"));
		this.operateurs.add(new Operateur(4, "/"));
		
		return "success";

	}

	// methode de calcul
	public String calcul() {
		demarrer();
		CalculDomaine retour = this.refCalculService.choixOperateur(this.refCalculDomaine);
		this.refCalculDomaine.setResultat(retour.getResultat());
		this.refCalculDomaine.setResultatTexte(retour.getResultatTexte());
		return "success";
	}

	// methode pour memoriser un resultat
	public String memoriser() {
		double resultat;
		if (this.refCalculDomaine.getResultatTexte().equals("erreur : division par zero")) {
			resultat = 0;
		} else {
			resultat = Double.valueOf(this.refCalculDomaine.getResultatTexte());
		}
		this.refMemoire.setMemoire(resultat);
		this.refMemoire.setMemoireTexte(this.refCalculDomaine.getResultatTexte());
		boolean retour = refMemoireService.memoriser(refMemoire);
		if (retour == true) {

			return "success";
		} else {

			return "error";
		}
	}

	// methode pour afficher la memoire dans le champ i
	public String afficherMemoire() {
		demarrer();
		Memoire refMem = refMemoireService.afficherMemoire();
		double resultat = refMem.getMemoire();
		switch (this.i) {
		case 1:
			this.refCalculDomaine.setNombre1(resultat);
			this.refCalculDomaine.setNombre2(0);
			break;
		case 2:
			this.refCalculDomaine.setNombre1(0);
			this.refCalculDomaine.setNombre2(resultat);
			break;
		default:
			this.refCalculDomaine.setNombre1(0);
			this.refCalculDomaine.setNombre2(0);
			break;
		}
		return "success";

	}

}
