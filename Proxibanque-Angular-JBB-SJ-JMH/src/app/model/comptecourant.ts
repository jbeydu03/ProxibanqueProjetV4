import { Carte } from "./carte";
import { Compte } from "./compte";

export class CompteCourant extends Compte {
    id: number;
    numero: number;
    solde: number;
    date: string;
    decouvert: number = -1000;
    carte: Carte;

    constructor(options: {
        id: number;
        numero: number;
        solde: number;
        date: string;
        decouvert: number;
        carte?: Carte;
    }
    ) {
        super(options);
        this.decouvert = options.decouvert;
        this.carte = options.carte;
    }
}