import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ConseillerService } from '../conseiller.service';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';

import { Client } from '../../model/client';
import { Compte } from '../../model/compte';
import { CompteCourant } from '../../model/comptecourant';
import { CompteEpargne } from '../../model/compteepargne';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-form-client',
  templateUrl: './form-client.component.html',
  styles: []
})
export class FormClientComponent implements OnInit {

  clientForm: FormGroup;
  clientCompteCourant: FormGroup;
  clientCompteEpargne: FormGroup;
  clientId;

  constructor(private fb: FormBuilder, private conseillerService: ConseillerService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.clientForm = this.fb.group({
      clientNom: ['', [Validators.required, Validators.maxLength(20)]],
      clientPrenom: ['', [Validators.required, Validators.maxLength(20)]],
      clientAdresse: ['', [Validators.required, Validators.maxLength(60)]],
      clientVille: ['', [Validators.required, Validators.maxLength(30)]],
      clientCodePostal: ['', [Validators.maxLength(5)]],
      clientTelephone: ['', [Validators.maxLength(14)]]
    });

    this.clientCompteCourant = this.fb.group({
      idCompteCourant: [''],
      numeroCompteCourant: [''],
      soldeCompteCourant: [''],
      dateCompteCourant: [''],
      decouvertCompteCourant: [-1000]
    });

    this.clientCompteEpargne = this.fb.group({
      idCompteEpargne: [''],
      numeroCompteEpargne: [''],
      soldeCompteEpargne: [0],
      dateCompteEpargne: [''],
      tauxCompteEpargne: [3]
    });

    this.route.paramMap.subscribe((param: ParamMap) => {
      this.clientId = Number(param.get('clientid'));
      //Remise des valeurs des champs dans le formulaire 
      if (this.clientId) {
        this.conseillerService.loadClient(this.clientId).subscribe(client => {
          //Champs données client
          this.clientForm.get('clientNom').setValue(client.nom);
          this.clientForm.get('clientPrenom').setValue(client.prenom);
          this.clientForm.get('clientAdresse').setValue(client.adresse);
          this.clientForm.get('clientVille').setValue(client.ville);
          this.clientForm.get('clientCodePostal').setValue(client.codePostal);
          this.clientForm.get('clientTelephone').setValue(client.telephone);

          // Champs compte courant client
          this.clientCompteCourant.get('idCompteCourant').setValue(client.compteCourant.id);
          this.clientCompteCourant.get('numeroCompteCourant').setValue(client.compteCourant.numero);
          this.clientCompteCourant.get('soldeCompteCourant').setValue(client.compteCourant.solde);
          this.clientCompteCourant.get('dateCompteCourant').setValue(client.compteCourant.date);
          this.clientCompteCourant.get('decouvertCompteCourant').setValue(client.compteCourant.decouvert);

          //Champs compte Epargne client
          if (client.compteEpargne) {
            this.clientCompteEpargne.get('idCompteEpargne').setValue(client.compteEpargne.id);
            this.clientCompteEpargne.get('numeroCompteEpargne').setValue(client.compteEpargne.numero);
            this.clientCompteEpargne.get('soldeCompteEpargne').setValue(client.compteEpargne.solde);
            this.clientCompteEpargne.get('dateCompteEpargne').setValue(client.compteEpargne.date);
            this.clientCompteEpargne.get('tauxCompteEpargne').setValue(client.compteEpargne.taux);
          }
        });
      }
    });
  }

  saveClient() {
    alert('couocu');
    const compteCourantSave: CompteCourant = new CompteCourant({
      id: this.clientCompteCourant.get('idCompteCourant').value,
      numero: this.clientCompteCourant.get('numeroCompteCourant').value,
      solde: this.clientCompteCourant.get('soldeCompteCourant').value,
      date: this.clientCompteCourant.get('dateCompteCourant').value,
      decouvert: this.clientCompteCourant.get('decouvertCompteCourant').value,
    });

    const compteEpargneSave: CompteEpargne = new CompteEpargne({
      id: this.clientCompteEpargne.get('idCompteEpargne').value,
      numero: this.clientCompteEpargne.get('numeroCompteEpargne').value,
      solde: this.clientCompteEpargne.get('soldeCompteEpargne').value,
      date: this.clientCompteEpargne.get('dateCompteEpargne').value,
      taux: this.clientCompteEpargne.get('tauxCompteEpargne').value,
    });

    const client = new Client({
      id: this.clientId,
      nom: this.clientForm.get('clientNom').value,
      prenom: this.clientForm.get('clientPrenom').value,
      adresse: this.clientForm.get('clientAdresse').value,
      ville: this.clientForm.get('clientVille').value,
      codePostal: this.clientForm.get('clientCodePostal').value,
      telephone: this.clientForm.get('clientTelephone').value,
      compteCourant: compteCourantSave,
      compteEpargne: compteEpargneSave
    });
    this.conseillerService.saveClient(client).subscribe(() => {
      //Confirmation de modification ou de création
      this.clientId ? alert('Client édité avec succés') : alert('Client ajouté à la banque');
      //Redirection
      this.router.navigate(['clients']);
    });
  }

  addCompteEpargne() {
    this.conseillerService.addCompteEpargne(this.clientId).subscribe(() => {
      this.clientId ? alert('Compte épargne ajouté au client'): alert('Sélectionner un client afin de lui affecter un compte épargne');
    })
  }

  deleteCompteEpargne(): boolean {
    // Supprime le client après confirmation
    this.showConfirmationModal()
      .subscribe({
        complete: () => this.conseillerService.deleteCompteEpargne(this.clientId).subscribe(() => this.conseillerService.loadClients()),
        error: () => { }
      });
    return false;
  }

  // Affichage de la confirmation de la suppression du client
  showConfirmationModal(): Observable<any> {
    return Observable.create(observer => {
      if (confirm('Êtes-vous certain de vouloir effacer ce compte épargne ?')) {
        observer.complete();
      } else {
        observer.error();
      }
    });
  }


}
