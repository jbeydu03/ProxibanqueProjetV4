export class HistoriqueVirement{

id : number;
date;
clientDebitId : number;
clientDebitInfo : string;
compteDebitInfo : string;
clientCreditId : number;
clientCreditInfo : string;
compteCreditInfo : string;
montant : number;

   constructor(id : number,date,clientDebitId : number,clientDebitInfo : string, compteDebitInfo : string,clientCreditId : number,clientCreditInfo : string,compteCreditInfo : string,montant : number){
        this.id = id;
        this.date = date;
        this.clientDebitId = clientDebitId
        this.clientDebitInfo = clientDebitInfo;
        this.compteDebitInfo = compteDebitInfo;
        this.clientCreditId =clientCreditId;
        this.clientCreditInfo = clientCreditInfo;
        this.compteCreditInfo = compteCreditInfo;
        this.montant = montant;

    }
}