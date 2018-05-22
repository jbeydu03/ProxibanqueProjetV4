import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
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
    ListeClientComponent
  ],
  providers: [
    ConseillerService
  ]
})
export class ConseillerModule { }
