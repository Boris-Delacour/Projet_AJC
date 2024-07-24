import { Formation } from "./formation";
import { Indisponibilite } from "./indisponibilite";
import { Matiere } from "./matiere";

export class Formateur {
  constructor(
    public id?: number,
    public lastname?: string,
    public firstname?: string,
    public email?: string,
    public login?: string,
    public password?: string,
    public formations?: Formation[],
    public indisponibilites?: Indisponibilite[],
    public matieres?: Matiere[],
  ) {}
}
