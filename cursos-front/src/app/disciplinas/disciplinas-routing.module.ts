import { DetailsMenuComponent } from './../shared/components/details-menu/details-menu.component';
import { PanelMenuComponent } from './../shared/components/panel-menu/panel-menu.component';
import { DisciplinasDetailsComponent } from './components/disciplinas-details/disciplinas-details.component';
import { DisciplinasPanelComponent } from './components/disciplinas-panel/disciplinas-panel.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: PanelMenuComponent, children: [
    { path: '', component: DisciplinasPanelComponent },
  ]},
  { path: '', component: DetailsMenuComponent, children: [
    { path: ':id', component: DisciplinasDetailsComponent },
  ]},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DisciplinasRoutingModule { }
