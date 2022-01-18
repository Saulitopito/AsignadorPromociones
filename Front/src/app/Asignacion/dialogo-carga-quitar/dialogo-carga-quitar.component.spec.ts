import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogoCargaQuitarComponent } from './dialogo-carga-quitar.component';

describe('DialogoCargaQuitarComponent', () => {
  let component: DialogoCargaQuitarComponent;
  let fixture: ComponentFixture<DialogoCargaQuitarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogoCargaQuitarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogoCargaQuitarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
