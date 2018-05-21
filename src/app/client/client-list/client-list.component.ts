import { Component, OnInit } from '@angular/core';
import { Client } from '../client';
import { ClientService } from '../client.service';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html'
})
export class ClientListComponent implements OnInit {

  constructor(private clientService: ClientService) { }

  listeClients: Client[] = [];

  ngOnInit() {
    this.clientService.loadClients().subscribe(data => this.listeClients = data);
  }

  deleteClient(idClient){
    this.clientService.deleteClient(idClient).subscribe();

  }

}
