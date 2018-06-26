import { TestBed, inject } from '@angular/core/testing';

import { CalculServiceService } from '../calc/calcul-service.service';

describe('CalculServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CalculServiceService]
    });
  });

  it('should be created', inject([CalculServiceService], (service: CalculServiceService) => {
    expect(service).toBeTruthy();
  }));
});
