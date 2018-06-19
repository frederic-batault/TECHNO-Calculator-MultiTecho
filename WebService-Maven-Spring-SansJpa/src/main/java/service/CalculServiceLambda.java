package service;

import domaine.CalculDomaine;

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
	interface IOperation2 {
		public double calculer(double x,double y);
	}

	
	
	//methode commune pour effectuer une operation
	public double calculerOperation(double a,double b, IOperation2 operation) {
		return operation.calculer(a, b);
	}
	
	
	
	
	// methode d'addition avec une expression lambda
	public CalculDomaine addition(CalculDomaine calculAdd) {
		IOperation2 add = (n1,n2) -> n1 + n2;
		double somme = calculerOperation(calculAdd.getNombre1(),calculAdd.getNombre2(),add);
		calculAdd.setResultat(somme);
		calculAdd.setResutatTexte(Double.toString(somme));
		return calculAdd;
	}
	
	
	
	// methode de soustraction avec une expression lambda
	//comme addition mais en ne creant pas la variable somme
	public CalculDomaine soustraction(CalculDomaine calculSous) {
		IOperation2 sous = (n1,n2) -> n1 - n2;
		calculSous.setResultat(calculerOperation(calculSous.getNombre1(),calculSous.getNombre2(),sous));
		calculSous.setResutatTexte(Double.toString(calculSous.getResultat()));
		return calculSous;
	}

	

	
	// methode de multiplication avec une expressionlambda
	public CalculDomaine multiplication(CalculDomaine calculMult) {
		IOperation2 mult = (n1,n2) -> n1 * n2;
		calculMult.setResultat(calculerOperation(calculMult.getNombre1(),calculMult.getNombre2(),mult));
		calculMult.setResutatTexte(Double.toString(calculMult.getResultat()));
		return calculMult;
	}
	

	
	// methode de division avec une expressionlambda
	public CalculDomaine division(CalculDomaine calculDiv) {
		if (calculDiv.getNombre2() == 0) {
			calculDiv.setResultat(0);
			calculDiv.setResutatTexte("erreur : div/0 (lambda)");	
		}
		else {
			IOperation2 mult = (n1,n2) -> n1 / n2;
			calculDiv.setResultat(calculerOperation(calculDiv.getNombre1(),calculDiv.getNombre2(),mult));
			calculDiv.setResutatTexte(Double.toString(calculDiv.getResultat()));	
					}
		return calculDiv;
	}
	
}
