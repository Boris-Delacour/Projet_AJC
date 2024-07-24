import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Technicien } from '../models/technicien';

@Injectable({
  providedIn: 'root',
})
export class TechnicienService {
  url = 'http://localhost:8080/ajcfinal/api/technicien';
  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Technicien[]> {
    return this.httpClient.get<Technicien[]>(this.url);
  }

  public create(technicien: Technicien): Observable<Technicien> {
    console.log(this.technicienToTechnicienRequest(technicien));
    return this.httpClient.post<Technicien>(
      this.url,
      this.technicienToTechnicienRequest(technicien)
    );
  }

  private technicienToTechnicienRequest(technicien: Technicien): any {
    let obj = {
      firstName: technicien.firstName,
      lastName: technicien.lastName,
      email: technicien.email,
      login: technicien.login,
      password: technicien.password,
    };
    return obj;
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  public getById(id: number): Observable<Technicien> {
    return this.httpClient.get<Technicien>(`${this.url}/${id}`);
  }

  public update(technicien: Technicien): Observable<Technicien> {
    return this.httpClient.put<Technicien>(
      `${this.url}/${technicien.id}`,
      this.technicienToTechnicienRequest(technicien)
    );
  }
}
