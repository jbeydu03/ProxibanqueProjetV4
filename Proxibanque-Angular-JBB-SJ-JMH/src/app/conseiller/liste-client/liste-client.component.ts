import { Component, OnInit, Inject } from '@angular/core';
import { Client } from '../../model/client';
import { ConseillerService } from '../conseiller.service';
import { DOCUMENT } from '@angular/common';
import { IdentificationCookie } from '../../model/identificationCookie';
import { Cookie } from '../../model/cookie';
import { AuthService } from '../../authentification/auth.service';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';

@Component({
  selector: 'app-liste-client',
  templateUrl: './liste-client.component.html'
})
export class ListeClientComponent implements OnInit {

  constructor(private conseillerService: ConseillerService, private router: Router, private authService: AuthService) { }

  listeClients: Client[] = [];
  user: IdentificationCookie;

  ngOnInit() {
    this.loadClients();
    const userCookie = this.authService.getCookie();
    this.user = new IdentificationCookie(JSON.parse(userCookie));

  }


  loadClients(): void {
    this.conseillerService.loadClients().subscribe(clients => this.listeClients = clients)


  }


  addClient() {
    this.router.navigate(['new']);
  }

  deleteClient(client: Client): boolean {
    // Supprime le client après confirmation
    this.showConfirmationModal()
      .subscribe({
        complete: () => this.conseillerService.deleteClient(client.id).subscribe(() => this.loadClients()),
        error: () => { }
      });
    return false;
  }

  // Affichage de la confirmation de la suppression du client
  showConfirmationModal(): Observable<any> {
    return Observable.create(observer => {
      if (confirm('Êtes-vous certain de vouloir effacer ce client de notre agence ?')) {
        observer.complete();
      } else {
        observer.error();
      }
    });
  }

}