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

	@ManagedProperty(value = "")
	private double nombre1;

	@ManagedProperty(value = "")
	private double nombre2;

	@ManagedProperty(value = "1")
	private int operateur;

	@ManagedProperty(value = "")
	private String resultatTexte;

	@ManagedProperty(value = "1")
	private int i;

	// Constructeurs

	public CalculBean(double nombre1, double nombre2, int operateur, String resultatTexte, int i) {
		super();
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.operateur = operateur;
		this.i = i;
		this.resultatTexte = resultatTexte;
	}

	public CalculBean() {
		super();
	}

	// getters et setters

	public double getNombre1() {
		return nombre1;
	}

	public void setNombre1(double nombre1) {
		this.nombre1 = nombre1;
	}

	public double getNombre2() {
		return nombre2;
	}

	public void setNombre2(double nombre2) {
		this.nombre2 = nombre2;
	}

	public int getOperateur() {
		return operateur;
	}

	public void setOperateur(int operateur) {
		this.operateur = operateur;
	}

	public String getResultatTexte() {
		return resultatTexte;
	}

	public void setResultatTexte(String resultatTexte) {
		this.resultatTexte = resultatTexte;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	// méthode de calcul
	public Object calcul() {
		CalculService service = new CalculService();
		CalculDomaine domaine = new CalculDomaine(nombre1, nombre2, operateur, resultatTexte);
		switch (operateur) {
		case 1:
			resultatTexte = service.addition(nombre1, nombre2);
			break;
		case 2:
			resultatTexte = service.soustraction(nombre1, nombre2);
			break;
		case 3:
			resultatTexte = service.multiplication(nombre1, nombre2);
			break;
		case 4:
			resultatTexte = service.division(nombre1, nombre2);
			break;
		default:
			resultatTexte = "---";
			break;
		}
		domaine.setResultatTexte(resultatTexte);
		return "Reultat";
	}

	// méthode pour memoriser un résultat
	public Object memoriser() {
		double resultat;
		if (this.resultatTexte.equals("erreur : division par zéro")) {
			resultat = 0;
		} else {
			resultat = Double.valueOf(this.resultatTexte);
		}
		MemoireService refMemoireService = new MemoireService();
		Memoire refMemoire = new Memoire(resultat, this.resultatTexte);
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

		context.addMessage(null, new FacesMessage("Enregistré", "valeur: " + this.resultatTexte));
	}

	public void saveMessageKO() {
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage("Erreur : enregistrement échoué"));
	}

	// méthode pour afficher la memoire dans le champ i
	public Object afficherMemoire() {
		MemoireService refMemoireService = new MemoireService();
		Memoire refMemoire = refMemoireService.afficherMemoire();
		double resultat = refMemoire.getMemoire();
		if (this.i == 1) {
			this.nombre1 = resultat;
			this.nombre2 = 0;
		} else {
			this.nombre1 = 0;
			this.nombre2 = resultat;
		}
		return "Rappel";

	}
}
