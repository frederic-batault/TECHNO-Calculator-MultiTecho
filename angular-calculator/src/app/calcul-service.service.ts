import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CalculService {

	calculer (calculIn: Calcul): Calcul {

		calculOut: Calcul = {
			nombre1: calculIn.nombre1,
			nombre2: calculIn.nombre2,
			operateur: calculIn.operateur,
			resultat:42,
			resultatTexte: '42',
		};

		return calculOut;
	}

	constructor() { }
}
