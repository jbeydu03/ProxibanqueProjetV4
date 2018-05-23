import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SimulationCreditComponent } from './simulation-credit/simulation-credit.component';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'credit', component: SimulationCreditComponent }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  declarations: [
    SimulationCreditComponent
  ]
})
export class OperationModule { }
