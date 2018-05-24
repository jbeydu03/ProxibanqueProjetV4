import { Compte } from "./compte";

export class Virement{
    compteDebiteur : Compte;
    compteCrediteur : Compte;
    montant : number;

    constructor(compteDebiteur : Compte, compteCrediteur : Compte, montant : number){
        this.compteDebiteur = compteDebiteur;
        this.compteCrediteur = compteCrediteur;
        this.montant = montant;

    }
}
