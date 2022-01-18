import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogoCargaActualizacionComponent } from './dialogo-carga-actualizacion.component';

describe('DialogoCargaActualizacionComponent', () => {
  let component: DialogoCargaActualizacionComponent;
  let fixture: ComponentFixture<DialogoCargaActualizacionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogoCargaActualizacionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogoCargaActualizacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
