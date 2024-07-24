import { Formateur } from './formateur';
import { Gestionnaire } from './gestionnaire';
import { MatiereParFormation } from './matiere-par-formation';
import { Stagiaire } from './stagiaire';

export class Formation {
  constructor(
    public id?: number,
    public nom?: string,
    public dateStart?: Date,
    public gestionnaire?: Gestionnaire,
    public formateur?: Formateur,
    public stagiaires?: Stagiaire[],
    public matiereParFOrmation?: MatiereParFormation[]
  ) {}
}
