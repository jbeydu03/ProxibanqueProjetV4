import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClientListComponent } from './client-list/client-list.component';
import { ClientFormComponent } from './client-form/client-form.component';
import { ClientService } from './client.service';
import { RouterModule, Routes } from '@angular/router';
import { ClientItemComponent } from './client-item/client-item.component';

const routes: Routes= [
  { path: 'listeClients', component: ClientListComponent },
  { path: 'editClient/:clientId', component: ClientFormComponent },
  { path: 'newClient', component: ClientFormComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full'}
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  declarations: [ClientListComponent,
                 ClientFormComponent,
                 ClientItemComponent],
  providers: [ClientService],
  
})

export class ClientModule { 

}
