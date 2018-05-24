import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ListeClientComponent } from './liste-client/liste-client.component';
import { ConseillerService } from './conseiller.service';
import { FormClientComponent } from './form-client/form-client.component';
import { FieldComponent } from './field/field.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpErrorHandler } from '../http-error-handler.service';
import { HistoriqueComponent } from './historique/historique.component';

const routes: Routes = [
  { path: 'clients', component: ListeClientComponent },
  { path: 'clients/new', component: FormClientComponent },
  { path: 'clients/:clientid', component: FormClientComponent },
  { path: 'clients/:clientid/historique', component: HistoriqueComponent }
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
    FieldComponent,
    HistoriqueComponent
  ],
  providers: [
    ConseillerService,
  ],
  exports: [
    ReactiveFormsModule
  ]
})
export class ConseillerModule { }
