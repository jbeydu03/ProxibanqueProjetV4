import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { ClientModule } from './client/client.module';



@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    ClientModule,
    HttpClientModule,
    RouterModule.forRoot([])
  ],
  providers: [{provide: 'JSON_SERVER_URL', useValue: 'http://localhost:3004'}],
  bootstrap: [AppComponent]
})
export class AppModule { }
