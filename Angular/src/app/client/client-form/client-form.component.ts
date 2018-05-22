import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ClientService } from '../client.service';
import { Client } from '../client';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';

@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html'
})
export class ClientFormComponent implements OnInit {

  //importe le formulaire crée dans le code HTML
  clientForm: FormGroup;
  clientId;

  constructor(private fb: FormBuilder,
              private cs: ClientService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    //Construction du formulaire toujours à vide
    this.clientForm = this.fb.group({
      clientId: ['',[Validators.required, Validators.maxLength(8)]], //Ce champ sera obligatoire
      clientPrenom: ['',[Validators.required, Validators.maxLength(20)]], //Ce champ sera obligatoire
      clientNom: ['',[Validators.required, Validators.maxLength(20)]], //Ce champ sera obligatoire
    })
    
    // A t'on déjà un quiz avec cet Id ? Oui => Update, Non => Post
    this.route.paramMap.subscribe((param: ParamMap) => {
      this.clientId = Number(param.get('clientId'));
      //Remise des valeurs des champs dans le formulaire 
      if(this.clientId){
        this.cs.loadClient(this.clientId).subscribe(client => {
          this.clientForm.get('clientID').setValue(client.id);
          this.clientForm.get('clientPrenom').setValue(client.prenom);
          this.clientForm.get('clientNom').setValue(client.nom);
        });
      }
    });
  }

  saveClient(){
    const client = new Client(this.clientId,this.clientForm.get('clientPrenom').value,this.clientForm.get('clientNom').value);
    this.cs.saveClient(client).subscribe(() => {
      //Confirmation de modification ou de création
      this.clientId? alert('Client modifié') : alert('Client créé');
      //Redirection
      this.router.navigate(['listeClients']);
    });
}

}
