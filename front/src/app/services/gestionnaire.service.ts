import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Gestionnaire } from '../models/gestionnaire';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GestionnaireService {
  url = 'http://localhost:8080/ajcfinal/api/gestionnaire';
  constructor(private httpClient: HttpClient) {}

  private gestionnaireToGestionnaireRequest(gestionnaire: Gestionnaire): any {
    let obj = {
      lastName: gestionnaire.lastName,
      firstName: gestionnaire.firstName,
      email: gestionnaire.email,
      login: gestionnaire.login,
      password: gestionnaire.password,
    };
    return obj;
  }

  public getById(id: number): Observable<Gestionnaire> {
    return this.httpClient.get<Gestionnaire>(`${this.url}/${id}`);
  }

  public getAll(): Observable<Gestionnaire[]> {
    return this.httpClient.get<Gestionnaire[]>(this.url);
  }

  public create(gestionnaire: Gestionnaire): Observable<Gestionnaire> {
    return this.httpClient.post<Gestionnaire>(
      this.url,
      this.gestionnaireToGestionnaireRequest(gestionnaire)
    );
  }

  public update(gestionnaire: Gestionnaire): Observable<Gestionnaire> {
    return this.httpClient.put<Gestionnaire>(
      `${this.url}/${gestionnaire.id}`,
      this.gestionnaireToGestionnaireRequest(gestionnaire)
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

}
