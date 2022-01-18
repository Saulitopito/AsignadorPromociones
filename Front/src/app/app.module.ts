import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PrincipalComponent } from './General/principal/principal.component';
import { ListarPromocionesComponent } from './Promociones/listar-promociones/listar-promociones.component';
import { AsignacionesComponent } from './Asignacion/asignaciones/asignaciones.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './General/header/header.component';
import { FooterComponent } from './General/footer/footer.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CrearPromocionComponent } from './Promociones/crear-promocion/crear-promocion.component';
import { ActualizarPromocionComponent } from './Promociones/actualizar-promocion/actualizar-promocion.component';
import { ReporteComponent } from './Reportes/reporte/reporte.component';
import { MaterialModule } from './material/material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DialogoEliminarComponent } from './Promociones/dialogo-eliminar/dialogo-eliminar.component';
import { DialogoCargaComponent } from './Asignacion/dialogo-carga/dialogo-carga.component';
import { DialogoCargaCreacionComponent } from './Promociones/dialogo-carga-creacion/dialogo-carga-creacion.component';
import { DialogoCargaActualizacionComponent } from './Promociones/dialogo-carga-actualizacion/dialogo-carga-actualizacion.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { DialogoCargaQuitarComponent } from './Asignacion/dialogo-carga-quitar/dialogo-carga-quitar.component';

@NgModule({
  declarations: [
    AppComponent,
    PrincipalComponent,
    ListarPromocionesComponent,
    AsignacionesComponent,
    HeaderComponent,
    FooterComponent,
    CrearPromocionComponent,
    ActualizarPromocionComponent,
    ReporteComponent,
    DialogoEliminarComponent,
    DialogoCargaComponent,
    DialogoCargaCreacionComponent,
    DialogoCargaActualizacionComponent,
    DialogoCargaQuitarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    MaterialModule,
    BrowserAnimationsModule,
    NgxPaginationModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule { }
