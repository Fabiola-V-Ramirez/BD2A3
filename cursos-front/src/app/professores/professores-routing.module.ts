import { DetailsMenuComponent } from './../shared/components/details-menu/details-menu.component';
import { PanelMenuComponent } from './../shared/components/panel-menu/panel-menu.component';
import { ProfessoresDetailsComponent } from './components/professores-details/professores-details.component';
import { ProfessoresPanelComponent } from './components/professores-panel/professores-panel.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: PanelMenuComponent, children: [
    { path: '', component: ProfessoresPanelComponent },
  ]},
  { path: '', component: DetailsMenuComponent, children: [
    { path: ':id', component: ProfessoresDetailsComponent },
  ]},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfessoresRoutingModule { }
