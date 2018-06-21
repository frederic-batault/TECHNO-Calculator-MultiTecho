package service;

import domaine.CalculDomaine;

//classe de calcul utilisant des expressions lambda (une dans chacune des 4 methodes d'operations +-*/)
//https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html

// les 4 methodes ont la meme structure et la meme logique (juste une optimisation entre l'addition et la soustraction)
public class CalculServiceLambda {

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
	//c'est une interface fonctionnelle : une interface avec une seule methode non implementee
	//elle permet a la JDK de savoir quelle methode de l'interface implemente l'instruction qui est ecrite dans l'expression lambda
	interface IOperation2 {
		public double calculer(double x,double y);
	}

	
	
	//methode commune pour effectuer une operation
	public double calculerOperation(double a,double b, IOperation2 operation) {
		//appel des methodes "calculer" contenues dans les classes anonymes generees par les expressions lambda
		return operation.calculer(a, b);
	}
	
	
	
		// methode d'addition avec une expression lambda
	public CalculDomaine addition(CalculDomaine calculAdd) {
		// expression lambda : raccourcis syntaxique pour une classe anonyme qui implemente l'interface fonctionnelle
		// la JDK cree automatiquement une classe anonyme qui implemente l'interface en implementant la methode "calculer"
		//membre de gauche montre qu'on va instancier à droite une classe qui implemente l'interface
		//membre de droite : expression lambda "->"
			//"(n1,n2)" : arguments de la methode "calculer" qui se trouve dans la classe anonyme et qui permet d'implementer l'interface
			//"n1 + n2" indique que dans la methode "calculer" de la classe anonyme cree automatiquement, il y aura "return n1 + n2 ;"
		IOperation2 add = (n1,n2) -> n1 + n2;
		//appel de le methode calculerOperation, qui elle-meme appelle la methode "calculer" de la classe anonyme generee
		// "add" est passe en argument de la methode "calculerOperation"
			//ce qui permet d'indiquer a cette methode quelle implementation de l'interface utiliser pour faire le calcul
		//l'utilisation de l'interface fonctionelle cree une correspondance entre l'objet anonyme qui implemente l'interface et les instructions qui implementent sa methode "calculer"
			//ainsi, quand on indique "add", on indique en fait "n1+n2" qui se trouve dans la methode "calculer" de l'objet "add"
		double somme = calculerOperation(calculAdd.getNombre1(),calculAdd.getNombre2(),add);
		//modification des proprietes de l'objet "calculAdd" (argument de la methode "addition") pour y ajouter le resultat du calcul
		calculAdd.setResultat(somme);
		calculAdd.setResultatTexte(Double.toString(somme));
		return calculAdd;
	}
	
	
	
	// methode de soustraction avec une expression lambda
	//comme addition mais avec une optimisation : pas de creation de la variable "somme"
	public CalculDomaine soustraction(CalculDomaine calculSous) {
		IOperation2 sous = (n1,n2) -> n1 - n2;
		calculSous.setResultat(calculerOperation(calculSous.getNombre1(),calculSous.getNombre2(),sous));
		calculSous.setResultatTexte(Double.toString(calculSous.getResultat()));
		return calculSous;
	}

	

	
	// methode de multiplication avec une expressionlambda
	//comme soustraction
	public CalculDomaine multiplication(CalculDomaine calculMult) {
		IOperation2 mult = (n1,n2) -> n1 * n2;
		calculMult.setResultat(calculerOperation(calculMult.getNombre1(),calculMult.getNombre2(),mult));
		calculMult.setResultatTexte(Double.toString(calculMult.getResultat()));
		return calculMult;
	}
	

	
	// methode de division avec une expressionlambda
	//même structure que "soustraction" et "multiplication", mais en prenant en compte le cas "/0"
	public CalculDomaine division(CalculDomaine calculDiv) {
		//gestion du cas "/0", elle est separee du calcul de la division
		if (calculDiv.getNombre2() == 0) {
			//pas d'utilisation d'expression lambda dans ce cas
			calculDiv.setResultat(0);
			calculDiv.setResultatTexte("erreur : div/0 (lambda)");	
		}
		else {
			// l'expression lambda n'est utilisee que dans le cas "/non nul"
			IOperation2 div = (n1,n2) -> n1 / n2;
			calculDiv.setResultat(calculerOperation(calculDiv.getNombre1(),calculDiv.getNombre2(),div));
			calculDiv.setResultatTexte(Double.toString(calculDiv.getResultat()));	
					}
		return calculDiv;
	}
	
}
