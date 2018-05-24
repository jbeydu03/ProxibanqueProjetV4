import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { OperationsService } from '../operations.service';
import { Compte } from '../../model/compte';
import { ConseillerService } from '../../conseiller/conseiller.service';
import { Client } from '../../model/client';


@Component({
  selector: 'app-audit',
  templateUrl: './audit.component.html',
  styles: []
})
export class AuditComponent implements OnInit {
  auditForm: FormGroup;
  tabAllEpargne =[];
  tabAllCourant = [];
  clients : Client[];

  constructor(private fb: FormBuilder, private route: ActivatedRoute, private conseillerService:ConseillerService,private router: Router )  { }

  ngOnInit() {
    this.auditForm = this.fb.group({
      montant: [''], 
    });
    this.conseillerService.loadClientsConseiller().subscribe(client=>this.clients = client);
      

    
    
  }
  // this.conseillerService.loadClientsConseiller().subscribe(clients => this.listeClients = clients)
  // compteEpargne: CompteEpargne;

  lancerFormCourant(){
    this.tabAllCourant.splice(0,this.tabAllCourant.length)
      this.clients.forEach(function(element : Client, index) {
          if(element.compteCourant)
          {
            this.tabAllCourant.push(element)
          }
         
      }.bind(this)); 

      console.log(this.tabAllCourant);
    }

    lancerFormEpargne(){
      this.tabAllEpargne.splice(0,this.tabAllEpargne.length)
      this.clients.forEach(function(element : Client, index) {
        if(element.compteEpargne)
        {
          this.tabAllEpargne.push(element)
        }
    }.bind(this)); 
      
      console.log(this.tabAllEpargne);

  };

      
  submitClass(compte : Compte, montant = 1000) {
    montant = this.auditForm.get('montant').value;
    return  compte.solde > montant ? 'succes' : 'error';
  }
}
