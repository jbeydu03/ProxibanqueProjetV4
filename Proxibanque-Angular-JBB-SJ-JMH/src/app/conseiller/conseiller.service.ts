import { Injectable, Inject } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/mergeMap';
import { Client } from '../model/client';


@Injectable()
export class ConseillerService {

  constructor(private http: HttpClient,
    @Inject('JSON_SERVER_URL') private baseUrl: string) { }

  loadClients(): Observable<Client[]> {
    // TODO: afficher la liste de tous les clients
    return this.http.get<Client[]>('http://192.168.1.44:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/all');
  }

  loadClient(clientId: number): Observable<Client> {
    // TODO: afficher un client à partir de son Id
    return this.http.get<Client>('http://192.168.1.44:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/' + clientId);
  }

  saveClient(client: Client): Observable<Client> {
    // Si le client existe => Update et sinon => Create
    if (client.id) { // UPDATE
      return this.http.put<Client>('http://192.168.1.44:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/' + client.id, client);
    } else { // INSERT
      return this.http.post<Client>('http://192.168.1.44:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/', client);
    }
  }

  deleteClient(clientId: number): Observable<any> {
    return this.http.delete('http://192.168.1.44:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/2/' + clientId);
  }

}