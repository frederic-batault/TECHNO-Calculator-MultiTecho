package service;

import domaine.CalculDomaine;

public class CalculServiceAnonyme {

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

	// interface contenant une methode abstraite pour faire une operation
	interface IOperation {
		public CalculDomaine calculer(CalculDomaine calcul);
	}

	// methode d'addition avec une classe anonyme
	public CalculDomaine addition(CalculDomaine calculAdd) {
		// classe anonyme : instanciation et implementation en meme temps
		IOperation ref = new IOperation() {
			// methode de calcul dans la classe locale
			public CalculDomaine calculer(CalculDomaine calculIn) {
				calculIn.setResultat(calculIn.getNombre1() + calculIn.getNombre2());
				calculIn.setResutatTexte(Double.toString(calculIn.getResultat()));
				return calculIn;
			}
		};
		// apres la classe locale, autres instructions de la méthode "addition":
		// appel de la methode de la classe anonyme
		return ref.calculer(calculAdd);
	}

	
	
	// methode de soustraction avec une classe anonyme
	public CalculDomaine soustraction(CalculDomaine calculSous) {
		// classe anonyme : instanciation et implementation en meme temps
		IOperation ref = new IOperation() {
			// methode de calcul dans la classe locale
			public CalculDomaine calculer(CalculDomaine calculIn) {
				calculIn.setResultat(calculIn.getNombre1() - calculIn.getNombre2());
				calculIn.setResutatTexte(Double.toString(calculIn.getResultat()));
				return calculIn;
			}
		};
		// apres la classe locale, autres instructions de la méthode "soustraction":
		// appel de la methode de la classe anonyme
		return ref.calculer(calculSous);
	}
	
	
	
	// methode de multiplication avec une classe anonyme
	public CalculDomaine multiplication(CalculDomaine calculMult) {
		// classe anonyme : instanciation et implementation en meme temps
		IOperation ref = new IOperation() {
			// methode de calcul dans la classe locale
			public CalculDomaine calculer(CalculDomaine calculIn) {
				calculIn.setResultat(calculIn.getNombre1() * calculIn.getNombre2());
				calculIn.setResutatTexte(Double.toString(calculIn.getResultat()));
				return calculIn;
			}
		};
		// apres la classe locale, autres instructions de la méthode "multiplication":
		// appel de la methode de la classe anonyme
		return ref.calculer(calculMult);
	}
	
	
	
	// methode de division avec une classe anonyme
	public CalculDomaine division(CalculDomaine calculDiv) {
		// classe anonyme : instanciation et implementation en meme temps
		IOperation ref = new IOperation() {
			// methode de calcul dans la classe locale
			public CalculDomaine calculer(CalculDomaine calculIn) {
				if (calculIn.getNombre2() == 0) {
					calculIn.setResultat(0);
					calculIn.setResutatTexte("erreur : div/0 (anonyme)");
				} else {
					calculIn.setResultat(calculIn.getNombre1() / calculIn.getNombre2());
					calculIn.setResutatTexte(Double.toString(calculIn.getResultat()));
				}
				return calculIn;
			}
		};
		// apres la classe locale, autres instructions de la méthode "division":
		// appel de la methode de la classe anonyme
		return ref.calculer(calculDiv);
	}

}
