export class Employee{

  public constructor(init?: Partial<Employee>) {
    Object.assign(this, init);
  }

  id: number;
  firstName: string;
  lastName: string;
  email: string;
}
