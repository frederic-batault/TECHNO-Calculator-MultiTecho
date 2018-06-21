package service;

import domaine.CalculDomaine;

// Classe de calcul utilisant des classes locales
//https://docs.oracle.com/javase/tutorial/java/javaOO/localclasses.html

//1-methode "addition" utilisant une classe locale
	//technique 1 : les instructions de traitement sont dans le constructeur de la classe locale
	//(le constructeur modifie la propriete de la classe locale en faisant le calcul, lors de l'instanciation de la classe locale. On recupere la propriete modifiee avec le getteur)

//2-methode "soustraction" utilisant une classe locale, 2 changements par rapport a l'addition
	//a) technique 2 : les instructions de traitement sont sont dans une methode de traitement appartenant a la classe locale
	//b) la classe locale implemente l'interface IOperation (mais pas vraiment utilise)

//3-methode "multiplication" sur le même principe que la methode "soustraction"
	//optimisation dans le traitement evitant de creer des variables

//4-methode "division" sur la même structure que "multiplication", avec la prise en compte du cas "/0"

public class CalculServiceLocal  {

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

	
	
	// methode d'addition avec une classe interne locale
	// il s'agit d'une classe se trouvant a l'interieur d'une methode
	// les differentes sortes de classes se trouvant dans d'autres classes sont expliques ici https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
	public CalculDomaine addition(CalculDomaine calculAdd) {
		// debut de la classe locale
		class AdditionLocal {
			// propriété de la classe locale
			private CalculDomaine calcul;

			// getteur de la propriete de la classe locale
			public CalculDomaine getCalcul() {
				return calcul;
			}

			// constructeur de la classe locale
			//affecte la propriété avec l'argument du constructeur, puis fait le calcul
			public AdditionLocal(CalculDomaine calculIn) {
				// propriete
				this.calcul = calculIn;
				//le traitement se fait ici
				//modifications des proprietes de l'objet "calcul" qui est une propriete de la classe locale
				double somme = this.calcul.getNombre1() + this.calcul.getNombre2();
				String sommeTexte = Double.toString(somme);
				this.calcul.setResultat(somme);
				this.calcul.setResultatTexte(sommeTexte);
			// fin du constructeur de la classe locale
			}
		// fin de la classe locale
		}
		// apres la fin de la classe locale, on se trouve toujours dans la méthode "addition":
		//on a donc d'autes autres instructions de la méthode
		
		// instanciation de la classe locale
		AdditionLocal ref = new AdditionLocal(calculAdd);
		//appel du getteur de la classe locale
		CalculDomaine retourA = ref.getCalcul();
		return retourA;
	}

	
	
	// methode de soustraction avec une classe locale qui implemente l'interface
	// IOperation
	// et appel de la methode de la classe locale sans passer par le constructeur
	public CalculDomaine soustraction(CalculDomaine calculSous) {
		// classe locale
		class SoustractionLocal implements IOperation {
			// methode de calcul dans la classe locale
			public CalculDomaine calculer(CalculDomaine calculIn) {
				double difference = calculIn.getNombre1() - calculIn.getNombre2();
				String differenceTexte = Double.toString(difference);
				calculIn.setResultat(difference);
				calculIn.setResultatTexte(differenceTexte);
				return calculIn;
			}
		}
		// apres la classe locale, autres instructions de la méthode "soustraction":
		// instanciation de la classe locale et appel de sa methode
		SoustractionLocal ref = new SoustractionLocal();
		CalculDomaine retourS = ref.calculer(calculSous);
		return retourS;
	}

	
	
	// methode de multiplication avec une classe locale qui implemente l'interface
	// IOperation
	// et appel de la methode de la classe locale sans passer par le constructeur
	// sans creer des variables dans la methode (comme "difference" dans la methode
	// soustraction)
	public CalculDomaine multiplication(CalculDomaine calculMult) {
		// classe locale
		class MultiplicationLocal implements IOperation {
			// methode de calcul dans la classe locale
			public CalculDomaine calculer(CalculDomaine calculIn) {
				calculIn.setResultat(calculIn.getNombre1() * calculIn.getNombre2());
				calculIn.setResultatTexte(Double.toString(calculIn.getResultat()));
				return calculIn;
			}
		}
		// apres la classe locale, autres instructions de la méthode "multiplication":
		// instanciation de la classe locale et appel de sa methode
		MultiplicationLocal ref = new MultiplicationLocal();
		return ref.calculer(calculMult);
	}

	
	
	// methode de division fonctionnant comme celle de multiplication, avec une
	// condition dans le traitement
	public CalculDomaine division(CalculDomaine calculDiv) {
		// classe locale
		class DivisionLocal implements IOperation {
			// methode de calcul dans la classe locale
			public CalculDomaine calculer(CalculDomaine calculIn) {
				if (calculIn.getNombre2() == 0) {
					calculIn.setResultat(0);
					calculIn.setResultatTexte("erreur : div/0 (local)");
				} else {
					calculIn.setResultat(calculIn.getNombre1() / calculIn.getNombre2());
					calculIn.setResultatTexte(Double.toString(calculIn.getResultat()));
				}
				return calculIn;
			}
		}
		// apres la classe locale, autres instructions de la méthode "division":
		// instanciation de la classe locale et appel de sa methode
		DivisionLocal ref = new DivisionLocal();
		return ref.calculer(calculDiv);
	}
}
