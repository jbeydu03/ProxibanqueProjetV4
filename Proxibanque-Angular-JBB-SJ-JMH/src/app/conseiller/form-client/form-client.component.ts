import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ConseillerService } from '../conseiller.service';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';

@Component({
  selector: 'app-form-client',
  templateUrl: './form-client.component.html',
  styles: []
})
export class FormClientComponent implements OnInit {

  clientForm: FormGroup;
  clientId;

  constructor(private fb: FormBuilder, conseillerService: ConseillerService, route: ActivatedRoute, router: Router) { }

  ngOnInit() {
    this.clientForm = this.fb.group({
      clientNom: [''],
      clientPrenom: [''],
      clientAdresse: [''],
      clientVille: [''],
      clientCodePostal: [''],
      clientTelephone: ['']
    });

    this.route.paramMap.subscribe((param: ParamMap) => {
      this.clientId = Number(param.get('clientId'));
      //Remise des valeurs des champs dans le formulaire 
      if (this.clientId) {
        this.conseillerService.loadClient(clientId).subscribe(client => {
          this.clientForm.get('clientNom').setValue(client.nom);
          this.clientForm.get('clientPrenom').setValue(client.prenom);
          this.clientForm.get('clientAdresse').setValue(client.adresse);
          this.clientForm.get('clientVille').setValue(client.ville);
          this.clientForm.get('clientCodePostal').setValue(client.codePostal);
          this.clientForm.get('clientTelephone').setValue(client.telephone);
          //De manière plus générique, possibilité de passer par un patchValue()
        });
      }
    });
  }


}
