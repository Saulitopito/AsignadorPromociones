import { TestBed } from '@angular/core/testing';

import { PromocionesServiceService } from './promociones-service.service';

describe('PromocionesServiceService', () => {
  let service: PromocionesServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PromocionesServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
