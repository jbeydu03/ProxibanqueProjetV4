import { Component, OnInit } from '@angular/core';

interface NavItem{
  text: string;
  path: string;
}

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styles: []
})
export class NavbarComponent implements OnInit {

  // Attributes
  logo = "/assets/logo-PB.jpg";
  navItems: NavItem[] = [
    {text:'Liste des clients', path:'clients'},
    {text:'Opérations bancaires', path:'operations'},
    {text:'Gestion agence', path:'gerant'},
    {text:'Login', path:'login'}
  ];
  
  constructor() { }

  ngOnInit() {
}

}
