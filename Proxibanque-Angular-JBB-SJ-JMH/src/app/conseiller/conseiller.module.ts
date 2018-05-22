import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ListeClientComponent } from './liste-client/liste-client.component';
import { ConseillerService } from './conseiller.service';
import { FormClientComponent } from './form-client/form-client.component';
import { FieldComponent } from './field/field.component';
import { ReactiveFormsModule } from '@angular/forms';

const routes: Routes = [
  { path: 'clients', component: ListeClientComponent },
  { path: 'clients/:clientid', component: FormClientComponent }
];

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes)
  ],
  declarations: [
    ListeClientComponent,
    FormClientComponent,
    FieldComponent
  ],
  providers: [
    ConseillerService
  ],
  exports: [
    ReactiveFormsModule
  ]
})
export class ConseillerModule { }
