import { TestBed } from '@angular/core/testing';

import { CoordenadoresService } from './coordenadores.service';

describe('CoordenadoresService', () => {
  let service: CoordenadoresService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CoordenadoresService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
