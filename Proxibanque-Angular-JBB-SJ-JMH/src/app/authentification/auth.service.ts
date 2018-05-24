import { Injectable, Inject } from '@angular/core';

import { Conseiller } from '../model/conseiller';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/mergeMap';
import { DOCUMENT } from '@angular/common';
import { IdentificationCookie } from '../model/identificationCookie';

@Injectable()
export class AuthService {

  constructor(private http: HttpClient,
    @Inject('JSON_SERVER_URL') private baseUrl: string, @Inject(DOCUMENT) private document) { }

    login(userLog: string, userMDP: string): Observable<Conseiller> {
    // TODO: afficher un client à partir de son Id
    //http://192.168.1.44:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/all
    //const userData =  userLog ;
    //this.setCookie('user', JSON.stringify(userData));
    return this.http.get<Conseiller>('http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/auth/conseiller/' + userLog + "/" + userMDP);
  }

  setCookie(name: string, value: string) {
    this.document.cookie = `${name}=${value}`;
  }

  getCookie(name: string = ''): string {
    const allCookiesString = this.document.cookie;
    const index1 = allCookiesString.indexOf(name);
    if (index1 !== -1) {
      let index2 = allCookiesString.indexOf(';', index1);
      index2 = index2 === -1 ? allCookiesString.length : index2;
      const cookieString = allCookiesString.slice(index1, index2);
      return cookieString.split('=')[1];
    }

  }


  deleteCookie() {

  }
}









 /*

  loadClients(): Observable<Client[]> {
    // TODO: afficher la liste de tous les clients
    return this.http.get<Client[]>('http://localhost:3004/clients');
  }



  saveClient(client: Client): Observable<Client> {
    // Si le client existe => Update et sinon => Create
    if (client.id) { // UPDATE
      return this.http.put<Client>('http://localhost:3004/clients/' + client.id, client);
    } else { // INSERT
      return this.http.post<Client>('http://localhost:3004/clients', client);
    }
  }

  }*/

