import { Salle } from './salle';

export class Videoprojecteur {
  constructor(
    public id?: number,
    public marque?: string,
    fonctionnel?: boolean,
    public salle?: Salle
  ) {}
}
