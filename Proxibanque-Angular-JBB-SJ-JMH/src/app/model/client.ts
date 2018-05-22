import { Person } from "./person";
import { CompteCourant } from "./comptecourant";
import { CompteEpargne } from "./compteepargne";

export class Client implements Person {
    id: number;
    nom: string;
    prenom: string;
    adresse: string;
    ville: string;
    codePostal: string;
    telephone: string;
    compteCourant: CompteCourant;
    compteEpargne: CompteEpargne;

    constructor(options: {
        id: number;
        nom: string;
        prenom: string;
        adresse?: string;
        ville?: string;
        codePostal?: string;
        telephone?: string;
        compteCourant ?: CompteCourant;
        compteEpargne ?: CompteEpargne;
    }) {
        this.id = options.id || null;
        this.nom = options.nom || '';
        this.prenom = options.prenom || '';
        this.adresse = options.adresse || '';
        this.ville = options.ville || '' ;
        this.codePostal = options.codePostal || '';
        this.telephone = options.codePostal || '';
        this.compteCourant = options.compteCourant || null;
        this.compteEpargne= options.compteEpargne || null;
    }

    toJson() {
        return {
          id: this.id,
          nom: this.nom,
          prenom: this.prenom,
          adresse: this.adresse,
          ville: this.ville,
          codePostal: this.codePostal,
          telephone: this.telephone,
          compteCourant: this.compteCourant,
          compteEpargne: this.compteEpargne
        };
    }

}