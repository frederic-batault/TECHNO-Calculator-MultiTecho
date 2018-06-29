package domaine;



public class CalculDomaine {

	private double nombre1;
	private int operateur;
	private double nombre2;
	private double resultat;
	private String resultatTexte;

	public double getNombre1() {
		return nombre1;
	}

	public void setNombre1(double nombre1) {
		this.nombre1 = nombre1;
	}

	public int getOperateur() {
		return operateur;
	}

	public void setOperateur(int operateur) {
		this.operateur = operateur;
	}

	public double getNombre2() {
		return nombre2;
	}

	public void setNombre2(double nombre2) {
		this.nombre2 = nombre2;
	}

	public double getResultat() {
		return resultat;
	}

	public void setResultat(double resultat) {
		this.resultat = resultat;
	}

	public String getResultatTexte() {
		return resultatTexte;
	}

	public void setResultatTexte(String resultatTexte) {
		this.resultatTexte = resultatTexte;
	}

	public CalculDomaine(double nombre1, int operateur, double nombre2, double resultat, String resultatTexte) {
		super();
		this.nombre1 = nombre1;
		this.operateur = operateur;
		this.nombre2 = nombre2;
		this.resultat = resultat;
		this.resultatTexte = resultatTexte;
	}

	public CalculDomaine() {
		super();
	}

}
