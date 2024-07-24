import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Formation } from '../models/formation';

@Injectable({
  providedIn: 'root'
})
export class FormationService {
  url = 'http://localhost:8080/ajcfinal/api/formation';
  constructor(private httpClient: HttpClient) {}

  private formationToFormationRequest(formation: Formation): any {
    let obj = {
      nom: formation.nom,
      dateStart: formation.dateStart,
      idGestionnaire: formation.gestionnaire?.id,
      idFormateur: formation.formateur?.id,
    };
    return obj;
  }

  public getById(id: number): Observable<Formation> {
    return this.httpClient.get<Formation>(`${this.url}/${id}`);
  }

  public getAll(): Observable<Formation[]> {
    return this.httpClient.get<Formation[]>(this.url);
  }

  public getWithAll(id: number): Observable<Formation> {
    return this.httpClient.get<Formation>(`${this.url}/${id}/infos`);
  }

  public create(formation: Formation): Observable<Formation> {
    return this.httpClient.post<Formation>(
      this.url,
      this.formationToFormationRequest(formation)
    );
  }

  public getWithoutFormateur(id: number): Observable<Formation[]> {
    return this.httpClient.get<Formation[]>(`${this.url}/withoutformateur/${id}`);
  }

  public update(formation: Formation): Observable<Formation> {
    return this.httpClient.put<Formation>(
      `${this.url}/${formation.id}`,
      this.formationToFormationRequest(formation)
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  

  
}