import { Conseiller } from "./conseiller";

export class Client {
  id: number;
  prenom: string;
  nom: string;
  login?: string;
  password?: string;
  conseiller?: Conseiller;

  constructor(id: number, prenom: string, nom: string) {
    this.id = id;
    this.prenom = prenom;
    this.nom = nom;
  }
}
