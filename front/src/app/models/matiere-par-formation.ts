import { Formateur } from './formateur';
import { Formation } from './formation';
import { Matiere } from './matiere';
import { Salle } from './salle';

export class MatiereParFormation {
  constructor(
    public id?: number,
    public start?: Date,
    public end?: Date,
    public matiere?: Matiere,
    public formation?: Formation,
    public formateur?: Formateur,
    public salle?: Salle
  ) {}
}
