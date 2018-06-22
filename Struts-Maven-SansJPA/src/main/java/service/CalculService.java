package service;

import domaine.CalculDomaine;


public class CalculService {

	public CalculDomaine choixOperateur(CalculDomaine calculDomaine) {
		CalculDomaine retour;
		switch (calculDomaine.getOperateur()) {
		case 1:
			retour = addition(calculDomaine);
			break;
		case 2:
			retour = soustraction(calculDomaine);
			break;
		case 3:
			retour = multiplication(calculDomaine);
			break;
		case 4:
			retour = division(calculDomaine);
			break;
		default:
			retour = new CalculDomaine(0, 0, 0, 0, "probleme de choix d'operateur");
			break;
		}
		retour.setNombre1(calculDomaine.getNombre1());
		retour.setNombre2(calculDomaine.getNombre2());
		retour.setOperateur(calculDomaine.getOperateur());
		return retour;
	}

	public CalculDomaine addition(CalculDomaine calculDomaine) {
		CalculDomaine retourA = new CalculDomaine();
		double somme = calculDomaine.getNombre1() + calculDomaine.getNombre2();
		String sommeTexte = Double.toString(somme);
		retourA.setResultat(somme);
		retourA.setResultatTexte(sommeTexte);
		return retourA;
	}

	public CalculDomaine soustraction(CalculDomaine calculDomaine) {
		CalculDomaine retourS = new CalculDomaine();
		double difference = calculDomaine.getNombre1() - calculDomaine.getNombre2();
		String differenceTexte = Double.toString(difference);
		retourS.setResultat(difference);
		retourS.setResultatTexte(differenceTexte);
		return retourS;
	}

	public CalculDomaine multiplication(CalculDomaine calculDomaine) {
		CalculDomaine retourM = new CalculDomaine();
		double produit = calculDomaine.getNombre1() * calculDomaine.getNombre2();
		String produitTexte = Double.toString(produit);
		retourM.setResultat(produit);
		retourM.setResultatTexte(produitTexte);
		return retourM;
	}

	public CalculDomaine division(CalculDomaine calculDomaine) {
		CalculDomaine retourD = new CalculDomaine();
		double quotient;
		String quotientTexte;
		if(calculDomaine.getNombre2()==0) {
			retourD.setResultat(0);
			retourD.setResultatTexte("erreur : div/0");
		}
		else {
			quotient = calculDomaine.getNombre1()/calculDomaine.getNombre2();
			quotientTexte = Double.toString(quotient);
			retourD.setResultat(quotient);
			retourD.setResultatTexte(quotientTexte);
		}
			return retourD;	
}
}
