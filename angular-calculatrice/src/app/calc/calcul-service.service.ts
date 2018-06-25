import {Injectable} from '@angular/core';
import {Calcul} from '../calc/Calcul';
import {HttpErrorResponse} from '@angular/common/http';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map, catchError} from 'rxjs/operators';
import {DomSanitizer, SafeHtml} from '@angular/platform-browser';
import {Observable, throwError} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CalculService {

  private calculPutUrl = 'http://localhost:8080/WebSerice-Maven-Dao-Spring/calcul/put';

  private httpOptions;

  private calculRetour = new Observable<any>();


  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  }



  public calculer(calcul: Calcul): Observable<any> {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json','Access-Control-Allow-Origin': 'http://localhost:4200'
      })
    };

    this.calculRetour = this.http.put<Calcul>(this.calculPutUrl, calcul, this.httpOptions);
    return this.calculRetour;
  }






  constructor(private http: HttpClient) {

  }
}
