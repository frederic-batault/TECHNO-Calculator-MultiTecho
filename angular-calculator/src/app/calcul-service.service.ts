import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CalculService {

calculer (Calcul calculIn): Calcul {
Calcul calculOut = new Calcul(calculIn.nombre1,calculIn.operateur,calculIn.nombre2,42,"42");
return calculOut;
}

  constructor() { }
}
