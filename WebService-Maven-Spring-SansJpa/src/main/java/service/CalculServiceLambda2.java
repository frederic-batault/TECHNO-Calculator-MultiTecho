package service;

import domaine.CalculDomaine;

//classe de calcul utilisant des expressions lambda
//https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html

//meme logique que la classe "CalculServiceLambda", mais structure differemment
	//toutes les expressions lambda et les instructions d'affectation des proprietes de resultat se trouvent dans la methode "choixOperateur"
//2 interfaces fonctionnelles : 1 pour calculer le resultat sous forme de nombre, 1 pour creer la chaine texte indiquant le resultat
	//permet de faciliter la gestion du cas "/0" qui concerne surtout la generation du texte
//dans cette classe, on doit tester 2 fois le cas "/0", une fois pour le calcul du resultat en nombre et une fois pour la generation du texte
public class CalculServiceLambda2 implements ICalculService {
	//methode qui realise des calculs differents en fonction de l'operateur
	//les expressions lambda ont ete placées dans cette methode, ce qui permet de factoriser du code
	public CalculDomaine choixOperateur(CalculDomaine calculDomaine) {
		//initialisation de l'objet "calc"
			//(assimilable a une expression lambda ? : objet nul anonyme qui implemente "IOperation2")
		IOperation2 calc =null;
		//expressions lambda qui permettent de creer des classes anonymes qui implementent l'interface IOperation2
		//ces classes anonymes contiennent chacune une methode "calculer" dont l'impementation est donne par la partie droite de l'expression lambda correspondante
		IOperation2 add = (n1,n2) -> n1 + n2;
		IOperation2 sous = (n1,n2) -> n1 - n2;
		IOperation2 mult = (n1,n2) -> n1 * n2;
		IOperation2 div = (n1,n2) -> n1 / n2;
		IOperation2 div0 = (n1,n2) -> 0;
		//expression lambda qui permettent de creer une classe anonyme qui implemente l'interface IOperation3
		//cette classe anonyme contient une methode "texte" dont l'impementation est donne par la partie droite de l'expression lambda ci-dessous
		IOperation3 txt = n -> Double.toString(n);
		switch (calculDomaine.getOperateur()) {
		//cas des 4 operateurs
		//a chaque fois, affectation de "calc" par l'objet anonyme cree par l'une des expression lambda
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
			//division : 2 cas ("/0" ou pas) avec chacun une expression lambda differente
			if (calculDomaine.getNombre2()==0) {
				calc = div0;
			}
			else {
				calc = div;	
			}
			
			break;
		default:
			calculDomaine.setResultatTexte("probleme de choix d'operateur");
			break;
		}
		//ces deux lignes sont factorisees au lieu d'apparaitre 4 fois dans des methodes differentes
		calculDomaine.setResultat(calculerOperation(calculDomaine.getNombre1(),calculDomaine.getNombre2(),calc));
		calculDomaine.setResultatTexte(texte(calculDomaine.getNombre2(),calculDomaine.getOperateur(),calculDomaine.getResultat(),txt));
		return calculDomaine;
	//fin de la methode "choixOperateur"
	}


	
	// interface fonctionnelle pour calculer le resultat (differement en fonction des implementations)
	interface IOperation2 {
		public double calculer(double x,double y);
	}

	
	
	//interface fonctionelle pour convertir le resultat chiffre en texte (1 seule implementation)
	interface IOperation3 {
		public String texte(double r);
	}
	
	
	
	//methode commune pour effectuer une operation
	//appelle la methode "calculer" de l'une des classes anonymes qui implementent "IOperation2", en fonction de l'argument "operation"
	public double calculerOperation(double a,double b, IOperation2 operation) {
		return operation.calculer(a, b);
	}
	
	
	
	//méthode pour generer la reponse texte
	//ici on doit tester le cas "/0" separement du premier test effectue sur ce cas (pour le calcul du resultat en nombre)
	public String texte(double b, double o, double r, IOperation3 operation) {
		//cas "/0"
		if (o == 4 && r==0) {
			// renvoit d'un texte fixe
			return "erreur: div/0 (lambda2)";
		}
		//autres cas
		else {
			// appel de la methode "texte" se trouvant dans la classe anonyme generee par l'expression lambda
			//qui indique comment cette la classe anonyme implemente cette methode
			return operation.texte(r);
		}
	// fin de la methode "texte"
	}
// fin de la classe		
}
