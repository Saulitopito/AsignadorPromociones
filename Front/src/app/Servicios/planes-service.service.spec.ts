import { TestBed } from '@angular/core/testing';

import { PlanesServiceService } from './planes-service.service';

describe('PlanesServiceService', () => {
  let service: PlanesServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlanesServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
