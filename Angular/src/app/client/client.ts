import { Conseiller } from "./conseiller";

export interface Client{
  id: number;
  prenom: string;
  nom: string;
  login: string;
  password: string;
  conseiller: Conseiller;
  
  constructor()
}
