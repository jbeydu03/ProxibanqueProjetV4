import { Component, OnInit } from '@angular/core';
import { Client } from '../../model/client';
import { ConseillerService } from '../conseiller.service';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';

@Component({
  selector: 'app-liste-client',
  templateUrl: './liste-client.component.html'
})
export class ListeClientComponent implements OnInit {

  constructor(private conseillerService: ConseillerService, private router: Router) { }

  listeClients: Client[] = [];

  ngOnInit() {
    this.loadClients();
  }

  loadClients(): void {
    this.conseillerService.loadClients()
      .subscribe(clients => this.listeClients = clients);
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

    return false;  // Pas d'action sur le bouton
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