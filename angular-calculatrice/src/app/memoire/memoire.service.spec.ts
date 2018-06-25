import { TestBed, inject } from '@angular/core/testing';

import { MemoireService } from './memoire.service';

describe('MemoireService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MemoireService]
    });
  });

  it('should be created', inject([MemoireService], (service: MemoireService) => {
    expect(service).toBeTruthy();
  }));
});
