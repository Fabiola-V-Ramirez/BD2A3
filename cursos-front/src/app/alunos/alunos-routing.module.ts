import { AlunosDetailsComponent } from './components/alunos-details/alunos-details.component';
import { AlunosPanelComponent } from './components/alunos-panel/alunos-panel.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: AlunosPanelComponent },
  { path: ':id', component: AlunosDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlunosRoutingModule { }
