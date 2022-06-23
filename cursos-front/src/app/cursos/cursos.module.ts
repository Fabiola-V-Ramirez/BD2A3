import { AppMaterialModule } from './../shared/app-material/app-material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CursosRoutingModule } from './cursos-routing.module';
import { CursosDetailsComponent } from './components/cursos-details/cursos-details.component';
import { CursosPanelComponent } from './components/cursos-panel/cursos-panel.component';


@NgModule({
  declarations: [
    CursosDetailsComponent,
    CursosPanelComponent
  ],
  imports: [
    CommonModule,
    CursosRoutingModule,
    AppMaterialModule
  ]
})
export class CursosModule { }
