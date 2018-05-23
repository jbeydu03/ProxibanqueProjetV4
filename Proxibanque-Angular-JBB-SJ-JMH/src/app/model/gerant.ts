import { Person } from "./person";

export class Gerant implements Person{
    id: number;
    nom: string;
    prenom: string;

    constructor(idGerant: number, nomGerant: string, prenomGerant: string){
        this.id=idGerant;
        this.nom=nomGerant;
        this.prenom=prenomGerant;
    }

}