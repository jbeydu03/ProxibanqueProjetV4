import { Injectable, Inject } from '@angular/core';

import { Conseiller } from '../model/conseiller';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/mergeMap';











@Injectable()
export class AuthService {

  constructor(private http: HttpClient,
    @Inject('JSON_SERVER_URL') private baseUrl: string) { }

    loadClient(userLog: string,userMDP: string): Observable<Conseiller> {
      // TODO: afficher un client à partir de son Id
      //http://192.168.1.44:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/all
      return this.http.get<Conseiller>('http://192.168.1.44:8080/ProxiBanqueSI_JMH_JBB_SJ/auth/conseiller/' + userLog +"/" + userMDP);
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

  deleteClient(clientId: number): Observable<any> {
    return this.http.delete('http://localhost:3004/clients/' + clientId);
  }*/

