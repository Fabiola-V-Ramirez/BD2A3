import { PanelMenuComponent } from './../shared/components/panel-menu/panel-menu.component';
import { CoordenadoresPanelComponent } from './components/coordenadores-panel/coordenadores-panel.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: PanelMenuComponent, children: [
    { path: '', component: CoordenadoresPanelComponent },
  ]},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CoordenadoresRoutingModule { }
