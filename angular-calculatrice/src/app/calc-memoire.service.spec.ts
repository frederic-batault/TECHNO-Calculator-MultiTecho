import { TestBed, inject } from '@angular/core/testing';

import { CalcMemoireService } from './calc-memoire.service';

describe('CalcMemoireService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CalcMemoireService]
    });
  });

  it('should be created', inject([CalcMemoireService], (service: CalcMemoireService) => {
    expect(service).toBeTruthy();
  }));
});
