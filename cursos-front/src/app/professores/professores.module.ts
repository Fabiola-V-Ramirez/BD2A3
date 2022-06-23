import { AppMaterialModule } from './../shared/app-material/app-material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfessoresRoutingModule } from './professores-routing.module';
import { ProfessoresDetailsComponent } from './components/professores-details/professores-details.component';
import { ProfessoresPanelComponent } from './components/professores-panel/professores-panel.component';


@NgModule({
  declarations: [
    ProfessoresDetailsComponent,
    ProfessoresPanelComponent
  ],
  imports: [
    CommonModule,
    ProfessoresRoutingModule,
    AppMaterialModule
  ]
})
export class ProfessoresModule { }
