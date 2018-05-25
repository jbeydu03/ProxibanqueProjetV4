import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../authentification/auth.service';
import { IdentificationCookie } from '../../model/identificationCookie';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';

interface NavItem {
  text: string;
  path: string;
  click?: string;
}

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styles: []
})
export class NavbarComponent implements OnInit {
  isLogin = false;
  userCookie: string;

  // Attributes
  logo = "/assets/logo1.PNG";
  navItems: NavItem[] = [
    { text: 'Liste des clients', path: 'clients' },
    { text: 'Opérations bancaires', path: 'operations' },
   

  ];

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {

      // const counter = Observable.interval(1000);
      // counter.subscribe(),() => {
      //     this.isLogin = this.authService.signIn();
      //   }
        this.isLogin = this.authService.signIn();
  

  }




  deconnexion() {
    
    this.authService.setCookie('user', (0).toString());
    const userCookie2 = this.authService.getCookie('user');
    this.router.navigate(['/login']);
  }

  


}
