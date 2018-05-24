import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Login } from '../../model/login';
import { AuthService } from '../auth.service';
import { Conseiller } from '../../model/conseiller';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import { DOCUMENT } from '@angular/common';
import { IdentificationCookie } from '../../model/identificationCookie';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  // Initialise les données. 
  // Crée un modèle du formulaire.
  // Déclare les méthodes pour traiter le formulaire. 
  private login: string;
  private mdp: string;
  private authService: AuthService;
  private formBuilder: FormBuilder;
  private loginForm: FormGroup;
  private router: Router;
  private conseiller : Conseiller;
  user: IdentificationCookie;



  constructor(fb: FormBuilder, aut: AuthService, router: Router,) {
    this.formBuilder = fb;
    this.authService = aut;
    this.router = router;
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
    const log = this.loginForm.get('login').value;
    const mdp = this.loginForm.get('mdp').value;
    this.authService.login(log, mdp).subscribe(conseiller => 
       {this.conseiller = conseiller;
        this.authService.setCookie('user', JSON.stringify(this.conseiller.id));
        const userCookie = this.authService.getCookie('user');
       // this.user = new IdentificationCookie(userCookie);
        console.log(userCookie);
       });
        this.router.navigate(['/clients']);
    }
    

    


}



