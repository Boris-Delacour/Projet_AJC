export class Technicien {
  constructor(
    public id?: number,
    public firstName?: string,
    public lastName?: string,
    public email?: string,
    public login?: string,
    public password?: string
  ) {}

  public get infos(): string {
    return `${this.id} ${this.firstName} ${this.lastName} ${this.email} ${this.login} ${this.password}`;
  }
}
