import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VirementComponent } from './virement/virement.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { FieldComponent } from './field/field.component';


const routes: Routes = [
  { path: 'clients/:clientId/virement', component: VirementComponent },
];

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes),
    
  ],
  declarations: [VirementComponent,
    FieldComponent],
  exports: [
    ReactiveFormsModule
  ]
})
export class VirementModule { }
