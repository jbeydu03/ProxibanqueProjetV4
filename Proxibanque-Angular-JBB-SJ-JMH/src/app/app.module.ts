import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { AppComponent } from './app.component';
import { ConseillerModule } from './conseiller/conseiller.module';

const routes: Routes= [
  {path: '', redirectTo: 'home', pathMatch: 'full'}
]

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    ConseillerModule,
    RouterModule.forRoot(routes)
  ],
  providers: [{provide: 'JSON_SERVER_URL', useValue: 'http://localhost:3004'}],
  bootstrap: [AppComponent]
})
export class AppModule { }
