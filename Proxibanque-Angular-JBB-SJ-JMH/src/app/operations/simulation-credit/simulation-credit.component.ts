import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-simulation-credit',
  templateUrl: './simulation-credit.component.html',
  styles: []
})
export class SimulationCreditComponent implements OnInit {

  creditForm: FormGroup;
  menusalite: number = 0;
  montant: number = 0;
  duree: number = 0;
  taux: number = 0;

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.creditForm = this.fb.group({
      champMontant: ['', Validators.required],
      champDuree: ['', Validators.required],
      champTaux: ['', [Validators.required, Validators.max(100), Validators.min(0)]]
    })
  }

  calculerCredit() {
    //Recupération des données
    this.montant = this.creditForm.get('champMontant').value;
    this.duree = this.creditForm.get('champDuree').value;
    this.taux = this.creditForm.get('champTaux').value;

    this.menusalite = (this.montant * (1 + this.taux / 100)) / this.duree;
    alert('Pour un credit de ' + this.montant + ' € sur ' + this.duree + ' mois au taux de ' + this.taux + ' %. La mensualité corrspondante est de ' + Math.round(this.menusalite) + ' € par mois');
  }

}
