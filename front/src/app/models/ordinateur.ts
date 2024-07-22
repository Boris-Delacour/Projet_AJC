import { Stagiaire } from './stagiaire';

export class Ordinateur {
  constructor(
    public id?: number,
    public marque?: string,
    public fonctionnel?: boolean,
    public os?: string,
    public stagiaire?: Stagiaire
  ) {}
}
