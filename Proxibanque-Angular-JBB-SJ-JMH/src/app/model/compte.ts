abstract class Compte {
    id: number;
    numero: number;
    solde: number;
    date: string;

    constructor(options: {
        id: number;
        numero: number;
        solde: number;
        date: string;
    }) {
        this.id = options.id;
        this.numero = options.numero;
        this.solde = options.solde;
        this.date = options.date;

    }
}