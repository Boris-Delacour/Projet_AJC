import { Formateur } from './formateur';

export class Indisponibilite {
  constructor(
    public id?: number,
    public start?: Date,
    public end?: Date,
    public formateur?: Formateur
  ) {}
}
