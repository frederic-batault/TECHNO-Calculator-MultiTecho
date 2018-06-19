package service;

import domaine.CalculDomaine;

// Classe de calcul utilisant des classes locales
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

	// methode d'addition avec une classe locale sans implementer l'interface
	// et en utilisant le constructeur de la classe locale
	public CalculDomaine addition(CalculDomaine calculAdd) {
		// classe locale
		class AdditionLocal {
			// propriété de la classe locale
			private CalculDomaine calcul;

			// getteur de la classe locale
			public CalculDomaine getCalcul() {
				return calcul;
			}

			// constructeur de la classe locale qui affecte la propriété avec l'argument du
			// constructeur et fait le calcul
			public AdditionLocal(CalculDomaine calculIn) {
				this.calcul = calculIn;
				double somme = this.calcul.getNombre1() + this.calcul.getNombre2();
				String sommeTexte = Double.toString(somme);
				this.calcul.setResultat(somme);
				this.calcul.setResutatTexte(sommeTexte);
			}
		}
		// apres la classe locale, autres instructions de la méthode "addition":
		// instanciation de la classe locale et appel de son getteur
		AdditionLocal ref = new AdditionLocal(calculAdd);
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
				calculIn.setResutatTexte(differenceTexte);
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
				calculIn.setResutatTexte(Double.toString(calculIn.getResultat()));
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
					calculIn.setResutatTexte("erreur : div/0 (local)");
				} else {
					calculIn.setResultat(calculIn.getNombre1() / calculIn.getNombre2());
					calculIn.setResutatTexte(Double.toString(calculIn.getResultat()));
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
