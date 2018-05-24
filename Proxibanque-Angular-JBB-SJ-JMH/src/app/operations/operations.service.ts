import { Injectable, Inject } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';


@Injectable()
export class OperationsService {

  constructor(private http: HttpClient, @Inject('JSON_SERVER_URL') private baseUrl: string) { }

  loadAllCompte(): Observable<Compte[]> {
    // TODO: afficher la liste de tous les comptes
    return this.http.get<Compte[]>('http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/comptes/all');
  }

}



