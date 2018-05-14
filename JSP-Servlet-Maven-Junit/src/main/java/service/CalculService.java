package service;

public class CalculService {

	public String addition(double nombre1, double nombre2) {
		String resultat = Double.toString(nombre1 + nombre2);
		return resultat;
	}

	public String soustraction(double nombre1, double nombre2) {
		String resultat = Double.toString(nombre1 - nombre2);
		return resultat;
	}

	public String multiplication(double nombre1, double nombre2) {
		String resultat = Double.toString(nombre1 * nombre2);
		return resultat;
	}

	public String division(double nombre1, double nombre2) {
		String resultat;
		if (nombre2 == 0) {
			resultat = "erreur : division par zéro";
		} else {
			resultat = Double.toString(nombre1 / nombre2);
		}
		return resultat;
	}
}
