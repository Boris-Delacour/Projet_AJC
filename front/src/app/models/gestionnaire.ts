import { Formation } from "./formation";

export class Gestionnaire {
  constructor(
    public id?: number,
    public lastName?: string,
    public firstName?: string,
    public email?: string,
    public login?: string,
    public password?: string,
    public formations?: Formation[]
  ) {}
}
