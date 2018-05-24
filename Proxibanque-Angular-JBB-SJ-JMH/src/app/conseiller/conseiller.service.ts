import { Injectable, Inject } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/mergeMap';
import { Client } from '../model/client';
import { DOCUMENT } from '@angular/common';
import { HttpErrorHandler, HandleError } from '../http-error-handler.service';
import { catchError } from 'rxjs/operators';
import { Virement } from '../model/virement';
import { HistoriqueVirement } from '../model/historiqueVirement';



@Injectable()
export class ConseillerService {

  private errorHandler: HandleError

  constructor(@Inject(DOCUMENT) private document,private http: HttpClient,
    @Inject('JSON_SERVER_URL') private baseUrl: string, private httpErrorHandler: HttpErrorHandler) {
      this.errorHandler=httpErrorHandler.createHandleError('ConseillerService');
    }

    historiqueVirementClient(): Observable<HistoriqueVirement[]> {
      // TODO: afficher la liste de tous les clients
      return this.http.get<HistoriqueVirement[]>('http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/comptes/virement/all');
    }


  loadClients(): Observable<Client[]> {
    // TODO: afficher la liste de tous les clients
    return this.http.get<Client[]>('http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/all').pipe(catchError(this.errorHandler('loadClients', [])));
  }

  loadClientsConseiller(): Observable<Client[]> {
    const idConseiller = this.getCookie();
    // TODO: afficher la liste de tous les clients
    return this.http.get<Client[]>('http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/conseiller/' + idConseiller ).pipe(catchError(this.errorHandler('loadClientsConseiller', [])));
  }


  loadClient(clientId: number): Observable<Client> {
    // TODO: afficher un client à partir de son Id
    return this.http.get<Client>('http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/' + clientId);
  }

  saveClient(client: Client): Observable<Client> {
    const idConseiller = this.getCookie();
    // Si le client existe => Update et sinon => Create
    if (client.id) { // UPDATE
      // TODO: Ne pas oublier de modifier l'Id conseiller
      return this.http.put<Client>('http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/conseiller/' + idConseiller + '/', client).pipe(catchError(this.errorHandler('saveClient', client)));
    } else { // INSERT
      return this.http.post<Client>('http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/conseiller/'+ idConseiller + '/', client).pipe(catchError(this.errorHandler('saveClient', client)));
    }
  }

  deleteClient(clientId: number): Observable<any> {
    return this.http.delete('http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/' + clientId).pipe(catchError(this.errorHandler('deleteClient')));
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

}