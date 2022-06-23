import { DisciplinasDetailsComponent } from './components/disciplinas-details/disciplinas-details.component';
import { DisciplinasPanelComponent } from './components/disciplinas-panel/disciplinas-panel.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: DisciplinasPanelComponent },
  { path: ':id', component: DisciplinasDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DisciplinasRoutingModule { }
