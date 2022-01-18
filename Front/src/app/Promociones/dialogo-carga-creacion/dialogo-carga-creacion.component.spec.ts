import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogoCargaCreacionComponent } from './dialogo-carga-creacion.component';

describe('DialogoCargaCreacionComponent', () => {
  let component: DialogoCargaCreacionComponent;
  let fixture: ComponentFixture<DialogoCargaCreacionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogoCargaCreacionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogoCargaCreacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
