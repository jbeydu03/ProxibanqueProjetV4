import { Person } from "./person";

export class Client implements Person{
    id: number;
    nom: string;
    prenom: string;
    adresse ?: string;
    ville ?: string;
    codePostal ?: string;
    telephone ?: string;

    constructor(idClient: number, nomClient: string, prenomClient: string){
        this.id=idClient;
        this.nom=nomClient;
        this.prenom=prenomClient;
    }

}