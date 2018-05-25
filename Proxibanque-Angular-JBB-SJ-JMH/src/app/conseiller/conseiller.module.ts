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
import { AuthGuard } from '../authentification/auth.guard';

const routes: Routes = [
  { path: 'clients', canActivate: [AuthGuard], component: ListeClientComponent },
  { path: 'clients/new', canActivate: [AuthGuard],  component: FormClientComponent },
  { path: 'clients/:clientid', canActivate: [AuthGuard], component: FormClientComponent },
  { path: 'clients/:clientid/historique', canActivate: [AuthGuard], component: HistoriqueComponent }
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
