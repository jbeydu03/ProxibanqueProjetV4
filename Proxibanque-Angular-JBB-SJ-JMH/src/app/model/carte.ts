export class Carte{
    id: number;
    numero: number;
    active: boolean;
    type: string; // Visa Premier ou Visa Electron

    constructor(id: number, numero: number, active: boolean, type: string){
        this.id=id;
        this.numero=numero;
        this.active=active;
        this.type=type;
    }
}