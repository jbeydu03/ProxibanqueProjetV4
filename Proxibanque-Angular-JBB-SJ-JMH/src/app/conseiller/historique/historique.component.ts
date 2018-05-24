import { Component, OnInit } from '@angular/core';
import { ConseillerService } from '../conseiller.service';
import { Virement } from '../../model/virement';
import { HistoriqueVirement } from '../../model/historiqueVirement';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';

@Component({
  selector: 'app-historique',
  templateUrl: './historique.component.html',
  styles: []
})
export class HistoriqueComponent implements OnInit {
  virements: HistoriqueVirement[];
  clientId: number;
  virementsDebiteurClient: HistoriqueVirement[] = [];
  virementsCrediteurClient: HistoriqueVirement[] = [];

  constructor(private conseillerService: ConseillerService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {

    this.conseillerService.historiqueVirementClient().subscribe(virement => {
      this.virements = virement;


      //recupérer le client et ses comptes

      this.route.paramMap.subscribe((param: ParamMap) => {
        this.clientId = Number(param.get('clientid'));


        //Remise des valeurs des champs dans le formulaire 

        if (this.clientId) {
          this.virements.forEach(function (element: HistoriqueVirement, index) {
            if (element.clientCreditId == this.clientId) {
              this.virementsCrediteurClient.push(element);
            }
            if (element.clientDebitId == this.clientId) {
              this.virementsDebiteurClient.push(element);
            }
          }.bind(this));




        }




      });
    });
  }
}
