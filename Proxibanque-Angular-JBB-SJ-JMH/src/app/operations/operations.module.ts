import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuditComponent } from './audit/audit.component';
import { ListeOperationsComponent } from './liste-operations/liste-operations.component';
import { SimulationCreditComponent } from './simulation-credit/simulation-credit.component';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'operations', component: ListeOperationsComponent },
  { path: 'operations/credit', component: SimulationCreditComponent },
  { path: 'operations/audit', component: AuditComponent}
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  declarations: [AuditComponent,
                 ListeOperationsComponent,
                 SimulationCreditComponent]
})
export class OperationsModule { }
