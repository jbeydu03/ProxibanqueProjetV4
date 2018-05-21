import { Injectable, Inject } from '@angular/core';
import { Client } from './client';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/mergeMap';


@Injectable()
export class ClientService {

  constructor(private http: HttpClient,
    @Inject('JSON_SERVER_URL') private baseUrl: string) { }

  loadClients(): Observable<Client[]> {
    // TODO: afficher la liste de tous les clients
    return this.http.get<Client[]>('http://localhost:3004/clients');
  }

  loadClient(clientId: number): Observable<Client> {
    // TODO: afficher un client à partir de son Id
    return this.http.get<Client>('http://localhost:3004/clients/' + clientId);
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
  }

}

