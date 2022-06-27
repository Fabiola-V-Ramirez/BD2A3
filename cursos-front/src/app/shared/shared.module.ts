import { PanelMenuComponent } from './components/panel-menu/panel-menu.component';
import { RouterModule } from '@angular/router';
import { AppMaterialModule } from './app-material/app-material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavigationComponent } from './components/navigation/navigation.component';
import { DetailsMenuComponent } from './components/details-menu/details-menu.component';

@NgModule({
  declarations: [
    NavigationComponent,
    DetailsMenuComponent,
    PanelMenuComponent,
  ],
  imports: [
    CommonModule,
    AppMaterialModule,
    RouterModule
  ],
  exports: [
    AppMaterialModule,
  ]
})
export class SharedModule { }
