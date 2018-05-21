import { Component, OnInit, Input } from '@angular/core';
import { Client } from '../client';
import { ClientService } from '../client.service';

@Component({
  selector: 'app-client-item',
  templateUrl: './client-item.component.html',
  styles: []
})
export class ClientItemComponent implements OnInit {

  @Input() client: Client;
  @Input() cs: ClientService;
  
  constructor(clientService: ClientService) { }

  ngOnInit() {
  }

  deleteClient(idClient){
    this.cs.deleteClient(idClient).subscribe;

  }

}
