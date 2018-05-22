import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Login } from '../../model/login';
import { AuthService } from '../auth.service';
import { Conseiller } from '../../model/conseiller';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import { DOCUMENT } from '@angular/common';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  // Initialise les données. 
  // Crée un modèle du formulaire.
  // Déclare les méthodes pour traiter le formulaire. 
  private login : string;
  private mdp : string;
  private authService : AuthService;
  private formBuilder : FormBuilder;
  private loginForm: FormGroup;
  private router: Router;
  


  constructor(fb: FormBuilder,aut :AuthService,router : Router, @Inject(DOCUMENT) private document ) {
    this.formBuilder = fb;
    this.authService = aut;
    this.router = router;
   }

   private setCookie(name: string, value: string) {
    this.document.cookie = `${name}=${value}`;
  }

   ngOnInit() {
    // Construit le formulaire toujours à vide
    this.loginForm = this.formBuilder.group({
      login: ['', [Validators.required]],
      mdp: ['', Validators.required],
    });
  }

  validForm() {
    // Envoie le flux dans le backEnd
//   const log = this.loginForm.value.get('login');
//   const mdp = this.loginForm.value.get('mdp');
  
//   const obs : Observable<Conseiller> = this.authService.loadClient(log,mdp); 
   const userData = {id: 1, email: 'bob@bob.com'};
   this.setCookie('id', JSON.stringify(userData));
   this.router.navigate(['/clients/']);
  } 


}
