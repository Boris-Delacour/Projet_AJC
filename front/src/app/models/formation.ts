import { Formateur } from './formateur';
import { Gestionnaire } from './gestionnaire';
import { Matiere } from './matiere';
import { Stagiaire } from './stagiaire';

export class Formation {
  constructor(
    public id?: number,
    public nom?: string,
    public dateStart?: Date,
    public gestionnaire?: Gestionnaire,
    public formateur?: Formateur,
    public stagiaires?: Stagiaire[],
    public matieres?: Matiere[]
  ) {}
}
