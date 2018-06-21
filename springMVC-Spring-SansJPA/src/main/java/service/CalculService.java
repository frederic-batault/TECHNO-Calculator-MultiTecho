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
		calculDomaine.setResultat(calculDomaine.getNombre1() + calculDomaine.getNombre2());
		calculDomaine.setResultatTexte(Double.toString(calculDomaine.getResultat()));
		return calculDomaine;
	}

	public CalculDomaine soustraction(CalculDomaine calculDomaine) {
		calculDomaine.setResultat(calculDomaine.getNombre1() - calculDomaine.getNombre2());
		calculDomaine.setResultatTexte(Double.toString(calculDomaine.getResultat()));
		return calculDomaine;
	}

	public CalculDomaine multiplication(CalculDomaine calculDomaine) {
		calculDomaine.setResultat(calculDomaine.getNombre1() * calculDomaine.getNombre2());
		calculDomaine.setResultatTexte(Double.toString(calculDomaine.getResultat()));
		return calculDomaine;
	}

	public CalculDomaine division(CalculDomaine calculDomaine) {
		if (calculDomaine.getNombre2() == 0) {
			calculDomaine.setResultat(0);
			calculDomaine.setResultatTexte("erreur : div/0");
		} else {
			calculDomaine.setResultat(calculDomaine.getNombre1() / calculDomaine.getNombre2());
			calculDomaine.setResultatTexte(Double.toString(calculDomaine.getResultat()));
		}
		return calculDomaine;
	}
	
	
	
}
