package service;

import domaine.CalculDomaine;

public class CalculServiceLambda2 implements ICalculService {

	public CalculDomaine choixOperateur(CalculDomaine calculDomaine) {
		
		IOperation2 calc =null;
		IOperation2 add = (n1,n2) -> n1 + n2;
		IOperation2 sous = (n1,n2) -> n1 - n2;
		IOperation2 mult = (n1,n2) -> n1 * n2;
		IOperation2 div = (n1,n2) -> n1 / n2;
		IOperation2 div0 = (n1,n2) -> 0;
		IOperation3 txt = n -> Double.toString(n);
		switch (calculDomaine.getOperateur()) {
		case 1:
			calc = add;
			break;
		case 2:
			calc = sous;
			break;
		case 3:
			calc = mult;
			break;
		case 4:
			if (calculDomaine.getNombre2()==0) {
				calc = div0;
			}
			else {
				calc = div;	
			}
			
			break;
		default:
			calculDomaine.setResutatTexte("probleme de choix d'operateur");
			break;
		}
		calculDomaine.setResultat(calculerOperation(calculDomaine.getNombre1(),calculDomaine.getNombre2(),calc));
		calculDomaine.setResutatTexte(texte(calculDomaine.getNombre2(),calculDomaine.getOperateur(),calculDomaine.getResultat(),txt));
		return calculDomaine;
	}


	
	// interface contenant une methode abstraite pour faire une operation
	interface IOperation2 {
		public double calculer(double x,double y);
	}

	interface IOperation3 {
		public String texte(double r);
	}
	
	//methode commune pour effectuer une operation
	public double calculerOperation(double a,double b, IOperation2 operation) {
		return operation.calculer(a, b);
	}
	
	//méthode pour generer la reponse texte
	public String texte(double b, double o, double r, IOperation3 operation) {
		if (o == 4 && r==0) {
			return "erreur: div/0 (lambda2)";
		}
		else {
			return operation.texte(r);
		}
	}
		
}
