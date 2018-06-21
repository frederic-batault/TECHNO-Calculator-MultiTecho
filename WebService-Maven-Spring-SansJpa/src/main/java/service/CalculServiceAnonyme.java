package service;

import domaine.CalculDomaine;

//classe avec des methodes de calcul utilisant des classes anonymes (4 methodes avec les memes logique et structure)
//https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html
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

	// interface contenant une methode pour faire une operation (non implementee)
	interface IOperation {
		public CalculDomaine calculer(CalculDomaine calcul);
	}

	// methode d'addition avec une classe anonyme
	public CalculDomaine addition(CalculDomaine calculAdd) {
		// classe anonyme: une classe locale mais avec une syntaxe qui ne fait pas apparaitre le declaration de la classe "class [nom de la classe]" (d'ou "anonyme")
			// syntaxe : new sur l'interface + corps de la classe locale "{...}"
			// cette syntaxe revient a creer une classe locale qui implemente l'interface
			//elle permet de declarer la classe et de l'instancier en même temps
		IOperation ref = new IOperation() {
			// methode de calcul dans la classe anonyme
			//son nom et sa signature permettent a la classe anonyme d'implementer l'interface
			public CalculDomaine calculer(CalculDomaine calculIn) {
				//ici est realise le traitement voulu (comme pour la classe locale)
				calculIn.setResultat(calculIn.getNombre1() + calculIn.getNombre2());
				calculIn.setResultatTexte(Double.toString(calculIn.getResultat()));
				return calculIn;
			//fin de la methode de la classe anonyme
			}
		//"}" : fin de la classe anonyme
		//";" : l'instanciation de la classe anonyme est une instruction de la methode "addition", elle finit ici
		};
		// apres la classe locale, autres instructions de la méthode "addition":
		// appel de la methode de la classe anonyme
		//retour de la methode "addition"
		return ref.calculer(calculAdd);
	}

	
	
	// methode de soustraction avec une classe anonyme (même principe que l'addition)
	public CalculDomaine soustraction(CalculDomaine calculSous) {
		// classe anonyme : instanciation et contenu de la classe en meme temps (dans une seule instruction jusqu'a la ligne 75 ";")
		IOperation ref = new IOperation() {
			// methode de calcul dans la classe anonyme
			public CalculDomaine calculer(CalculDomaine calculIn) {
				calculIn.setResultat(calculIn.getNombre1() - calculIn.getNombre2());
				calculIn.setResultatTexte(Double.toString(calculIn.getResultat()));
				return calculIn;
			}
		};
		// apres la classe locale, autres instructions de la méthode "soustraction":
		// appel de la methode de la classe anonyme
		return ref.calculer(calculSous);
	}
	
	
	
	// methode de multiplication avec une classe anonyme (même principe que l'addition)
	public CalculDomaine multiplication(CalculDomaine calculMult) {
		// classe anonyme : instanciation et contenu de la classe en meme temps 
		IOperation ref = new IOperation() {
			// methode de calcul dans la classe anonyme
			public CalculDomaine calculer(CalculDomaine calculIn) {
				calculIn.setResultat(calculIn.getNombre1() * calculIn.getNombre2());
				calculIn.setResultatTexte(Double.toString(calculIn.getResultat()));
				return calculIn;
			}
		};
		// apres la classe locale, autres instructions de la méthode "multiplication":
		// appel de la methode de la classe anonyme
		return ref.calculer(calculMult);
	}
	
	
	
	// methode de division avec une classe anonyme (même principe que l'addition, avec en plus la gestion du cas "/0")
	public CalculDomaine division(CalculDomaine calculDiv) {
		// classe anonyme : instanciation et implementation en meme temps
		IOperation ref = new IOperation() {
			// methode de calcul dans la classe locale
			public CalculDomaine calculer(CalculDomaine calculIn) {
				//cas de division par zero
				if (calculIn.getNombre2() == 0) {
					calculIn.setResultat(0);
					// precision de la classe utilisée
					calculIn.setResultatTexte("erreur : div/0 (anonyme)");
				} else {
				//cas de division par un nombre non nul
					calculIn.setResultat(calculIn.getNombre1() / calculIn.getNombre2());
					calculIn.setResultatTexte(Double.toString(calculIn.getResultat()));
				}
				return calculIn;
			//fin de la methode "calculer"
			}
		//fin de la classe anonyme + fin de l'instruction qui instancie la classe
		};
		// apres la classe locale, autres instructions de la méthode "division":
		// appel de la methode de la classe anonyme
		return ref.calculer(calculDiv);
	}

}
