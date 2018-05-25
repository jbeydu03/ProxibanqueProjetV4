import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuditComponent } from './audit/audit.component';
import { ListeOperationsComponent } from './liste-operations/liste-operations.component';
import { SimulationCreditComponent } from './simulation-credit/simulation-credit.component';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { OperationsService } from './operations.service';
import { FieldComponent } from '../operations/field/field.component';
import { AuthGuard } from '../authentification/auth.guard';

const routes: Routes = [
  { path: 'operations', canActivate: [AuthGuard],  component: ListeOperationsComponent },
  { path: 'operations/credit', canActivate: [AuthGuard],  component: SimulationCreditComponent },
  { path: 'operations/audit', canActivate: [AuthGuard],  component: AuditComponent }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    ReactiveFormsModule,
  ],
  declarations: [
    ListeOperationsComponent,
    SimulationCreditComponent,
    FieldComponent],
  exports: [
    ReactiveFormsModule,
   
  ],
  providers: [
    OperationsService
  ],
})
export class OperationsModule { }
