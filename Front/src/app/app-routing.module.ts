import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AsignacionesComponent } from './Asignacion/asignaciones/asignaciones.component';
import { ListarPromocionesComponent } from './Promociones/listar-promociones/listar-promociones.component';
import { PrincipalComponent } from './General/principal/principal.component';
import { CrearPromocionComponent } from './Promociones/crear-promocion/crear-promocion.component';
import { ActualizarPromocionComponent } from './Promociones/actualizar-promocion/actualizar-promocion.component';
import { ReporteComponent } from './Reportes/reporte/reporte.component';

const routes: Routes = [
  {path: '', component: PrincipalComponent},
  {path: 'promos', component: ListarPromocionesComponent},
  {path: 'asignaciones', component: AsignacionesComponent},
  {path: 'crear-promociones', component: CrearPromocionComponent},
  {path: 'actualizar-promociones', component: ActualizarPromocionComponent},
  {path: 'reportes', component: ReporteComponent},
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
