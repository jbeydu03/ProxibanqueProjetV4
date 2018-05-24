import { Component, OnInit } from '@angular/core';
import { ConseillerService } from '../../conseiller/conseiller.service';
import { Client } from '../../model/client';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Virement } from '../../model/virement';
import { Compte } from '../../model/compte';
import { OperationsService } from '../../operations/operations.service';

@Component({
  selector: 'app-virement',
  templateUrl: './virement.component.html',
  styles: []
})
export class VirementComponent implements OnInit {
  clientForm: FormGroup;
  listeClients: Client[] = [];
  listeCompteCrediteur: Compte[] = [];
  listeCompteDebiteur: Compte[] = [];
  clientId: number;
  clientNom: string;

  constructor(private fb: FormBuilder, private conseillerService: ConseillerService, private operationsService: OperationsService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.clientForm = this.fb.group({
      clientNom: [''],
      compteDebiteur: ['', Validators.required],
      nomCrediteur: [''],
      compteCrediteur: ['', Validators.required],
      montant: ['', Validators.required],

    });


    //recupérer le client et ses comptes
    this.route.paramMap.subscribe((param: ParamMap) => {
      this.clientId = Number(param.get('clientId'));

      //Remise des valeurs des champs dans le formulaire 
      if (this.clientId) {
        this.conseillerService.loadClient(this.clientId).subscribe(client => {

          this.clientForm.get('clientNom').setValue(client.nom);



          if (client.compteCourant !== null) {
            this.listeCompteDebiteur.push(client.compteCourant);
          }
          if (client.compteEpargne !== null) {
            this.listeCompteDebiteur.push(client.compteEpargne);
          }
          //this.clientForm.get('compteDebiteur').setValue(this.listeCompteDebiteur);
        });
      }
    });

    //recupére la liste des clients à créditer
    this.conseillerService.loadClients().subscribe(data => this.listeClients = data);

  }

  selectCrediteur(id) {

    this.listeCompteCrediteur.splice(0, this.listeCompteCrediteur.length);
    this.conseillerService.loadClient(id).subscribe(client => {
      if (client.compteCourant !== null) {
        this.listeCompteCrediteur.push(client.compteCourant);
      }
      if (client.compteEpargne !== null) {
        this.listeCompteCrediteur.push(client.compteEpargne);
      }



      //De manière plus générique, possibilité de passer par un patchValue()
    });
  }

  validerVirement() {
    // alert("Virement effectué");

    const dCompteDebiteur = this.clientForm.get('compteDebiteur').value;
    const dCompteCrediteur = this.clientForm.get('compteCrediteur').value;
    const dMontant = this.clientForm.get('montant').value;

    const virementValide = new Virement(dCompteDebiteur, dCompteCrediteur, dMontant);
    this.operationsService.sendVirement(virementValide).subscribe();
    console.log(virementValide);

  }
}

