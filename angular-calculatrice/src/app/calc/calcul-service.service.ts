import { Injectable } from '@angular/core';
import { Calcul } from '../calc/Calcul';
import { HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class CalculService {

	private calculGetUrl = 'localhost:8080/WebSerice-Maven-Dao/rest/calcul/get';
	private calculPutUrl = 'localhost:8080/WebSerice-Maven-Dao/rest/calcul/put';

	
	
	calculer (calcul: Calcul): Calcul {
		getCalc().subscribe((data: Calcul) => calculWS = {calculGetUrl: data['calculGetUrl']});
		calcul.resultatTexte = calculWS.resultatTexte;
		
		return calcul;
	}
	
	getCalc(){
		return this.http.get<Calcul>(this.calculGetUrl);
	}
	
	

	constructor(private http HttpClient) { }
}
