import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VirementComponent } from './virement/virement.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';


const routes: Routes = [
  { path: 'clients/:clientId/virement', component: VirementComponent },
];

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes)
  ],
  declarations: [VirementComponent],
  exports: [
    ReactiveFormsModule
  ]
})
export class VirementModule { }
