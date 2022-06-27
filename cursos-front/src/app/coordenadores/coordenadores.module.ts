import { AppMaterialModule } from './../shared/app-material/app-material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CoordenadoresRoutingModule } from './coordenadores-routing.module';
import { CoordenadoresPanelComponent } from './components/coordenadores-panel/coordenadores-panel.component';


@NgModule({
  declarations: [
    CoordenadoresPanelComponent
  ],
  imports: [
    CommonModule,
    CoordenadoresRoutingModule,
    AppMaterialModule
  ]
})
export class CoordenadoresModule { }
