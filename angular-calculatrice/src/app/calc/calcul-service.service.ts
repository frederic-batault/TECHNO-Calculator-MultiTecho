import { Injectable } from '@angular/core';
import { Calcul } from '../calc/Calcul';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { map } from 'rxjs/operators';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';

@Injectable({
  providedIn: 'root'
})
export class CalculService {

	private calculGetUrl = 'http://localhost:8080/WebSerice-Maven-Dao-Spring/calcul/get';
	private calculPutUrl = 'http://localhost:8080/WebSerice-Maven-Dao-Spring/calcul/put';
	private headers: HttpHeaders;
	
	private calculRetour = new Calcul();
		
	calculer (calcul: Calcul): Calcul {
		
		
		
		
		this.http.put<Calcul>(this.calculPutUrl, calcul, { headers: this.headers}).subscribe(data => {console.log(data);});
		
		
		return this.calculRetour
		
	}
	
	constructor(private http: HttpClient) {this.headers = new HttpHeaders({'Access-Control-Allow-Origin': '*'});}
}
