import { ProfessoresDetailsComponent } from './components/professores-details/professores-details.component';
import { ProfessoresPanelComponent } from './components/professores-panel/professores-panel.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: ProfessoresPanelComponent },
  { path: ':id', component: ProfessoresDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfessoresRoutingModule { }
