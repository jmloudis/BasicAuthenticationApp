export class User {

  public id!: number;
  public username: string;
  public password: string;
  public role: string;
  public enabled: boolean;

  constructor()
  {
    this.role = '';
    this.username = '';
    this.password = '';
    this.enabled = false;
  }

}
