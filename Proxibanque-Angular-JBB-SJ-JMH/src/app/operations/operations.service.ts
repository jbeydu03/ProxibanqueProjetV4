import { Injectable, Inject } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { Virement } from '../model/virement';


@Injectable()
export class OperationsService {

  constructor(private http: HttpClient, @Inject('JSON_SERVER_URL') private baseUrl: string) { }



  sendVirement(virementValide : Virement): Observable<Virement> {
    // TODO: afficher la liste de tous les comptes
    return this.http.get<Virement>('http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/comptes/virement/'+ `${virementValide.compteDebiteur}/${virementValide.compteCrediteur}/${virementValide.montant}`);
  }
  
}

//+ `${virementValide.compteDebiteur}/${virementValide.compteCrediteur}/${virementValide.montant}`
