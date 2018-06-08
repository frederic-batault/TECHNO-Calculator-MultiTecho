import { Injectable } from '@angular/core';
import {Calcul} from '../calc/Calcul';
@Injectable({
  providedIn: 'root'
})
export class CalculService {

	calculer (calcul: Calcul): Calcul {

		calcul.resultatTexte= '42';
		

		return calcul;
	}

	constructor() { }
}
