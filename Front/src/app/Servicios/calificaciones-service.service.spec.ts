import { TestBed } from '@angular/core/testing';

import { CalificacionesServiceService } from './calificaciones-service.service';

describe('CalificacionesServiceService', () => {
  let service: CalificacionesServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CalificacionesServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
