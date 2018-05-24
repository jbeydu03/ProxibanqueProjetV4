import { Compte } from "./compte";

export class CompteEpargne extends Compte{
    id: number;
    numero: number;
    solde: number;
    date: string;
    taux: number = 0.03;

    constructor(options: {
        id: number;
        numero: number;
        solde: number;
        date: string;
        taux: number;
    }) {
        super(options);
        this.taux = options.taux;
    }

}