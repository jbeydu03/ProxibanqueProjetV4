import { Component, OnInit } from '@angular/core';
import { Client } from '../../model/client';
import { ConseillerService } from '../conseiller.service';

@Component({
  selector: 'app-liste-client',
  templateUrl: './liste-client.component.html'
})
export class ListeClientComponent implements OnInit {

  constructor(private conseillerService: ConseillerService) { }

  listeClients: Client[] = [];

  ngOnInit() {
    this.conseillerService.loadClients().subscribe(data => this.listeClients = data);
  }

  deleteClient(idClient){
    this.conseillerService.deleteClient(idClient).subscribe();

  }

}