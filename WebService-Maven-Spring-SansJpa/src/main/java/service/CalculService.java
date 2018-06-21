package service;

import domaine.CalculDomaine;

// classe de calcul simple
public class CalculService {

	// methode qui permet d'effectuer la bonne opération en fonction de la valeur du parametre "operateur"
	// elle appelle l'une des 4 methodes situées en-dessous
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
	
	//methode d'addition
	public CalculDomaine addition(CalculDomaine calculDomaine) {
		//instanciation d'un objet pour le retour
		CalculDomaine retourA = new CalculDomaine();
		//realisation de l'operation : la propriete "resultat" de l'objet en argument est modifiee pour etre la somme des valeurs des proprietes "nombre1" et "nombre2"
		double somme = calculDomaine.getNombre1() + calculDomaine.getNombre2();
		//preparation de la forme texte du resultat : la propriete "resultatTexte" est modifiee pour etre la conversion en texte de la propriete "resultat"
		String sommeTexte = Double.toString(somme);
		//affectation des formes nombre et texte du resultat de l'objet "retourA" prepare pour le retour a partir des valeurs de l'objet "calculDomaine" sur lequel on a travaille
		retourA.setResultat(somme);
		retourA.setResultatTexte(sommeTexte);
		// retour de l'objet
		return retourA;
	}

	//methode de soustraction : meme principe, mais avec une optimisation : pas d'instanciation supplementaire (comme retourA) et pas de declaration de variables intermediaires (comme somme et sommeTexte)
	public CalculDomaine soustraction(CalculDomaine calculDomaine) {
		calculDomaine.setResultat(calculDomaine.getNombre1() - calculDomaine.getNombre2());
		calculDomaine.setResultatTexte(Double.toString(calculDomaine.getResultat()));
		return calculDomaine;
	}
	
	//methode de multiplication
	public CalculDomaine multiplication(CalculDomaine calculDomaine) {
		CalculDomaine retourM = new CalculDomaine();
		double produit = calculDomaine.getNombre1() * calculDomaine.getNombre2();
		String produitTexte = Double.toString(produit);
		retourM.setResultat(produit);
		retourM.setResultatTexte(produitTexte);
		return retourM;
	}

	//methode de division avec prise en compte du cas ou le nombre 2 est egal a zero
	public CalculDomaine division(CalculDomaine calculDomaine) {
		CalculDomaine retourD = new CalculDomaine();
		double quotient;
		String quotientTexte;
		if(calculDomaine.getNombre2()==0) {
			retourD.setResultat(0);
			retourD.setResultatTexte("erreur : div/0 (simple)");
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
