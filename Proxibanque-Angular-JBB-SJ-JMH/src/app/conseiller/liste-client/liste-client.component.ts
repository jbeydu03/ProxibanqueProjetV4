import { Component, OnInit, Inject } from '@angular/core';
import { Client } from '../../model/client';
import { ConseillerService } from '../conseiller.service';
import { DOCUMENT } from '@angular/common';
import { IdentificationCookie } from '../../model/identificationCookie';
import { Cookie } from '../../model/cookie';
import { AuthService } from '../../authentification/auth.service';

@Component({
  selector: 'app-liste-client',
  templateUrl: './liste-client.component.html'
})
export class ListeClientComponent implements OnInit {

  constructor(private conseillerService: ConseillerService,private authService: AuthService) { }

  listeClients: Client[] = [];
  user : IdentificationCookie;
 
  ngOnInit() {
    this.conseillerService.loadClients().subscribe(data => this.listeClients = data);
    const userCookie = this.authService.getCookie();
    this.user = new IdentificationCookie(JSON.parse(userCookie));
    alert(this.user._name);
  }



  deleteClient(idClient){
    this.conseillerService.deleteClient(idClient).subscribe();

  }



  

}