import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuditComponent } from './audit/audit.component';
import { ListeOperationsComponent } from './liste-operations/liste-operations.component';
import { SimulationCreditComponent } from './simulation-credit/simulation-credit.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [AuditComponent,
                 ListeOperationsComponent,
                 SimulationCreditComponent]
})
export class OperationsModule { }
