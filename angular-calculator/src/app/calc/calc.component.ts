import { Component, OnInit } from '@angular/core';
import { Calcul } from '../calc/Calcul';
import { CalculService} from '../calcul-service.service';
@Component({
  selector: 'app-calc',
  templateUrl: './calc.component.html',
   styleUrls: ['./calc.component.css']
})
export class CalcComponent implements OnInit {

calculIn: Calcul = {
nombre1: 0,
nombre2: 0,
operateur: 1,
resultat:0,
resultatTexte: '0',
};

calculOut: Calcul = {
nombre1: 0,
nombre2: 0,
operateur: 1,
resultat:0,
resultatTexte: 'ici votre resultat',
};

  constructor(private calculService: CalculService) { }
  
  calculer(): void {
  this.calculOut = this.calculService.calculer(calculIn);
  }
  
  ngOnInit() {
  }

}
