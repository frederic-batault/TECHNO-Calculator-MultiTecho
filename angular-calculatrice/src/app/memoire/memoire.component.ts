import {Memoire} from './Memoire';
import {MemoireService} from './memoire.service';
import {Component, OnInit} from '@angular/core';
import {CalcMemoireService} from '../calc-memoire.service';

@Component({
  selector: 'app-memoire',
  templateUrl: './memoire.component.html',
  styleUrls: ['./memoire.component.css']
})
export class MemoireComponent implements OnInit {

  memoire: Memoire;

  constructor(private memoireService: MemoireService, private calcMem: CalcMemoireService) {}

  public memoriser(): void {
    this.memoire = this.calcMem.obtenirResultat();
    this.memoireService.memoriser(this.memoire).subscribe();
  }

  public afficher(): void {
    this.memoireService.afficher().subscribe(memoire => this.memoire = memoire);
    this.calcMem.ecrireNombres(this.memoire);
  }

  ngOnInit() {

  }

}
