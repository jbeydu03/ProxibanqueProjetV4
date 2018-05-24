import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../authentification/auth.service';
import { IdentificationCookie } from '../../model/identificationCookie';
import { Router } from '@angular/router';

interface NavItem{
  text: string;
  path: string;
  click ?:string;
}

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styles: []
})
export class NavbarComponent implements OnInit {
  isLogin = false;
  user: IdentificationCookie;
  userCookie: string;

  // Attributes
  logo = "/assets/logo-PB.jpg";
  navItems: NavItem[] = [
    {text:'Liste des clients', path:'clients'},
    {text:'Opérations bancaires', path:'operations'},
    {text:'Gestion agence', path:'gerant'},
  
  ];
  
  constructor(private authService: AuthService,private router: Router ) { }

  ngOnInit() {

    this.userCookie = this.authService.getCookie();
    this.user = new IdentificationCookie(JSON.parse(this.userCookie));
    if(this.user){
      this.isLogin=true;

    }


    
}
deconnexion(){
  console.log(this.user);
  this.authService.deleteCookie(this.user);

 // this.router.navigate(['/login']);
}

}
