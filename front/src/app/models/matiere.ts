import { Formateur } from "./formateur";

export class Matiere {
  constructor(
    public id?: number,
    public libelle?: string,
    public duration?: number,
    public objective?: string,
    public prerequisite?: string,
    public content?: string,
    public formateurs?: Formateur[]
  ) {}
}
