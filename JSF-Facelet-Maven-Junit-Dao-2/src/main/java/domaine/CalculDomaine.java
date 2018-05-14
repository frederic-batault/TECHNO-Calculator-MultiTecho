package domaine;

public class CalculDomaine {
	private double nombre1;
	private double nombre2;
	private int op�rateur;
	private String resultatTexte;

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

	public int getOp�rateur() {
		return op�rateur;
	}

	public void setOp�rateur(int op�rateur) {
		this.op�rateur = op�rateur;
	}

	public String getResultatTexte() {
		return resultatTexte;
	}

	public void setResultatTexte(String resultatTexte) {
		this.resultatTexte = resultatTexte;
	}

	public CalculDomaine(double nombre1, double nombre2, int op�rateur, String resultatTexte) {
		super();
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.op�rateur = op�rateur;
		this.resultatTexte = resultatTexte;
	}

	public CalculDomaine() {
		super();
	}

	public String toString() {
		return this.nombre1 + this.op�rateur + this.nombre2 + "=" + resultatTexte;
	}
}
