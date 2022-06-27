import { DetailsMenuComponent } from './../shared/components/details-menu/details-menu.component';
import { PanelMenuComponent } from './../shared/components/panel-menu/panel-menu.component';
import { AlunosDetailsComponent } from './components/alunos-details/alunos-details.component';
import { AlunosPanelComponent } from './components/alunos-panel/alunos-panel.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: PanelMenuComponent, children: [
    { path: '', component: AlunosPanelComponent },
  ]},
  { path: '', component: DetailsMenuComponent, children: [
    { path: ':id', component: AlunosDetailsComponent },
  ]},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlunosRoutingModule { }
