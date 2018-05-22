import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { AppComponent } from './app.component';
import { ConseillerModule } from './conseiller/conseiller.module';
import { FooterComponent } from './common/footer/footer.component';
import { NavbarComponent } from './common/navbar/navbar.component';
import { HomeComponent } from './common/home/home.component';
import { HttpClientModule } from '@angular/common/http';

const routes: Routes= [
  {path: 'home', component: HomeComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}
]

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    NavbarComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    ConseillerModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [{provide: 'JSON_SERVER_URL', useValue: 'http://localhost:3004'}],
  bootstrap: [AppComponent]
})
export class AppModule { }
