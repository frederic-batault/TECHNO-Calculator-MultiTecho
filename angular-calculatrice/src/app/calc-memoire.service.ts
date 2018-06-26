import {Memoire} from './memoire/Memoire';
import {Injectable} from '@angular/core';
import {CalcComponent} from './calc/calc.component';

@Injectable({
  providedIn: 'root'
})
export class CalcMemoireService {

  mem: Memoire;

  public obtenirResultat(): Memoire {
    this.mem = new Memoire();
    this.mem = {memoire: this.calc.calcul.resultat, memoireTexte: this.calc.calcul.resultatTexte};
    return this.mem;
  }



  public ecrireNombres(memoire: Memoire): void {
    this.calc.calcul.nombre1 = memoire.memoire;
    this.calc.calcul.nombre2 = memoire.memoire;
  }

  constructor(private calc: CalcComponent) {}
}
