import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { AppComponent } from './app.component';
import { ConseillerModule } from './conseiller/conseiller.module';
import { FooterComponent } from './common/footer/footer.component';
import { NavbarComponent } from './common/navbar/navbar.component';
import { HomeComponent } from './common/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './authentification/login/login.component';
import { AuthentificationModule } from './authentification/authentification.module';
import { VirementModule } from './virement/virement.module';
import { OperationsModule } from './operations/operations.module';
import { AuditComponent } from './operations/audit/audit.component';
import { HttpErrorHandler } from './http-error-handler.service';
import { MessageService } from './message.service';

const routes: Routes= [
  {path: 'home', component: HomeComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}
]

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    NavbarComponent,
    HomeComponent,
    LoginComponent,
    AuditComponent,
  ],
  imports: [
    BrowserModule,
    ConseillerModule,
    OperationsModule,
    AuthentificationModule,
    HttpClientModule,
    VirementModule,
    RouterModule.forRoot(routes)
  ],
  providers: [
    {provide: 'JSON_SERVER_URL', useValue: 'http://localhost:8080'},
    HttpErrorHandler,
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
