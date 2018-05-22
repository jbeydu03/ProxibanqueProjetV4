import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ListeConseillerComponent } from './liste-conseiller/liste-conseiller.component';
import { ListeClientComponent } from './liste-client/liste-client.component';
import { ConseillerService } from './conseiller.service';

const routes: Routes = [
  {path: 'clients', component: ListeClientComponent},
  {path: 'clients/:clientid', component: ListeClientComponent}
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  declarations: [
    ListeClientComponent,
    ListeConseillerComponent
  ],
  providers: [
    ConseillerService
  ]
})
export class ConseillerModule { }
