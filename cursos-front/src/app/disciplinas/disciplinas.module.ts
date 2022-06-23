import { AppMaterialModule } from './../shared/app-material/app-material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DisciplinasRoutingModule } from './disciplinas-routing.module';
import { DisciplinasDetailsComponent } from './components/disciplinas-details/disciplinas-details.component';
import { DisciplinasPanelComponent } from './components/disciplinas-panel/disciplinas-panel.component';


@NgModule({
  declarations: [
    DisciplinasDetailsComponent,
    DisciplinasPanelComponent
  ],
  imports: [
    CommonModule,
    DisciplinasRoutingModule,
    AppMaterialModule
  ]
})
export class DisciplinasModule { }
