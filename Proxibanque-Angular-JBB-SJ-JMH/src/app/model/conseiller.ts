import { Person } from "./person";

export class Conseiller implements Person{
    id: number;
    nom: string;
    prenom: string;

    constructor(idConseiller: number, nomConseiller: string, prenomConseiller: string){
        this.id=idConseiller;
        this.nom=nomConseiller;
        this.prenom=prenomConseiller;
    }
}