package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import domaine.CalculDomaine;
import service.CalculService;

/**
 * @author www.objis.com
 */

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

	// Constructeurs

	public CalculBean(double nombre1, double nombre2, int operateur, String resultatTexte) {
		super();
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.operateur = operateur;
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
}
