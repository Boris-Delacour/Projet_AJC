import { Formateur } from './formateur';
import { Gestionnaire } from './gestionnaire';

export class Formation {
  constructor(
    public id?: number,
    public nom?: string,
    public dateStart?: Date,
    public gestionnaire?: Gestionnaire,
    public formateur?: Formateur
  ) {}
}
