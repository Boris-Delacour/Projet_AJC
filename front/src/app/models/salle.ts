import { MatiereParFormation } from './matiere-par-formation';
import { Videoprojecteur } from './videoprojecteur';

export class Salle {
  constructor(
    public id?: number,
    public numero?: number,
    public nbPlace?: number,
    public occuper?: boolean,
    public videoprojecteur?: Videoprojecteur,
    public matiereParFormation?: MatiereParFormation
  ) {}
}
