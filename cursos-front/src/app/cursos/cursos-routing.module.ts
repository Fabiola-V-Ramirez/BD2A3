import { DetailsMenuComponent } from './../shared/components/details-menu/details-menu.component';
import { PanelMenuComponent } from './../shared/components/panel-menu/panel-menu.component';
import { CursosDetailsComponent } from './components/cursos-details/cursos-details.component';
import { CursosPanelComponent } from './components/cursos-panel/cursos-panel.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: PanelMenuComponent, children: [
    { path: '', component: CursosPanelComponent },
  ]},
  { path: '', component: DetailsMenuComponent, children: [
    { path: ':id', component: CursosDetailsComponent },
  ]},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CursosRoutingModule { }
