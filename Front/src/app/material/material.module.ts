import { NgModule } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSliderModule } from '@angular/material/slider';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatSnackBarModule } from '@angular/material/snack-bar'
import { MatDialogModule } from '@angular/material/dialog';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';

const material = [
  MatInputModule,
  MatButtonModule,
  MatSliderModule,
  MatProgressSpinnerModule,
  MatToolbarModule,
  MatFormFieldModule,
  MatSelectModule,
  MatDatepickerModule,
  MatSnackBarModule,
  MatDialogModule,
  MatTableModule,
  MatPaginatorModule
];

@NgModule({
  imports: [material],
  exports: [material]
})
export class MaterialModule { }
