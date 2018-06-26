import {Memoire} from './Memoire';
import {HttpClient} from '@angular/common/http';
import {HttpHeaders} from '@angular/common/http';
import {HttpErrorResponse} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable, throwError} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MemoireService {

  constructor(private http: HttpClient) {}

  private memoirePostUrl = 'http://localhost:8080/WebSerice-Maven-Dao-Spring/memoire/post';
  private memoireGetUrl = 'http://localhost:8080/WebSerice-Maven-Dao-Spring/memoire/get';

  private httpOptions;

  private memoireRetour = new Observable<any>();


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



  public memoriser(memoire: Memoire): Observable<any> {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json', 'Access-Control-Allow-Origin': 'http://localhost:4200'
      })
    };
    return this.http.post<Memoire>(this.memoirePostUrl, memoire, this.httpOptions);
  }



  public afficher(): Observable<any> {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json', 'Access-Control-Allow-Origin': 'http://localhost:4200'
      })
    };
    return this.http.get<Memoire>(this.memoireGetUrl, this.httpOptions);
  }
}
