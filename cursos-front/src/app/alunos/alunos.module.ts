import { AlunosDetailsComponent } from './components/alunos-details/alunos-details.component';
import { AppMaterialModule } from './../shared/app-material/app-material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AlunosRoutingModule } from './alunos-routing.module';
import { AlunosPanelComponent } from './components/alunos-panel/alunos-panel.component';


@NgModule({
  declarations: [
    AlunosDetailsComponent,
    AlunosPanelComponent
  ],
  imports: [
    CommonModule,
    AlunosRoutingModule,
    AppMaterialModule
  ]
})
export class AlunosModule { }
