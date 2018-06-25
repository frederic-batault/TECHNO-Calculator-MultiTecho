import {Memoire} from './Memoire';
import {MemoireService} from './memoire.service';
import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-memoire',
  templateUrl: './memoire.component.html',
  styleUrls: ['./memoire.component.css']
})
export class MemoireComponent implements OnInit {

  memoire: Memoire;

  constructor(private memoireService: MemoireService) {}

  public memoriser(): void {

  }

  public afficher(): void {

  }

  ngOnInit() {
    this.memoire = {
      memoire: 100,
      memoireTexte: '100',
    };
  }

}
