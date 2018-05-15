package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import domaine.CalculDomaine;
import domaine.Memoire;
import service.CalculService;
import service.MemoireService;

@ManagedBean(name = "calculbean")
@SessionScoped
public class CalculBean {

	private CalculDomaine refCalculDomaine = new CalculDomaine(0, 0, 1, "");

	private Memoire refMemoire = new Memoire(0, "");

	private CalculService refCalculService = new CalculService();

	private MemoireService refMemoireService = new MemoireService();

	private int i;

	// Constructeurs

	public CalculBean() {
		super();
	}

	public CalculBean(CalculDomaine refCalculDomaine, Memoire refMemoire, int i) {
		super();
		this.refCalculDomaine = refCalculDomaine;
		this.refMemoire = refMemoire;
		this.i = i;
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

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	// methode de calcul
	public Object calcul() {
		String resultatTxt;
		switch (this.refCalculDomaine.getOperateur()) {
		case 1:
			resultatTxt = this.refCalculService.addition(this.refCalculDomaine.getNombre1(),
					this.refCalculDomaine.getNombre2());
			break;
		case 2:
			resultatTxt = this.refCalculService.soustraction(this.refCalculDomaine.getNombre1(),
					this.refCalculDomaine.getNombre2());
			break;
		case 3:
			resultatTxt = this.refCalculService.multiplication(this.refCalculDomaine.getNombre1(),
					this.refCalculDomaine.getNombre2());
			break;
		case 4:
			resultatTxt = this.refCalculService.division(this.refCalculDomaine.getNombre1(),
					this.refCalculDomaine.getNombre2());
			break;
		default:
			resultatTxt = "---";
			break;
		}
		this.refCalculDomaine.setResultatTexte(resultatTxt);
		return "Reultat";
	}

	// methode pour memoriser un resultat
	public Object memoriser() {
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
			saveMessageOK();
			return "Calculatrice";
		} else {
			saveMessageKO();
			return "Calculatrice";
		}
	}

	public void saveMessageOK() {
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage("Enregistre", "valeur: " + this.refMemoire.getMemoireTexte()));
	}

	public void saveMessageKO() {
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage("Erreur : enregistrement echoue"));
	}

	// methode pour afficher la memoire dans le champ i
	public Object afficherMemoire() {

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
		return "Calculatrice";

	}
}
