import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Matiere } from '../models/matiere';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class MatiereService {
  url = 'http://localhost:8080/ajcfinal/api/matiere';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Matiere[]> {
    return this.httpClient.get<Matiere[]>(this.url);
  }

  public getById(id: number): Observable<Matiere> {
    return this.httpClient.get<Matiere>(`${this.url}/${id}`);
  }

  public create(matiere: Matiere): Observable<Matiere> {
    return this.httpClient.post<Matiere>(
      this.url,
      this.matiereToMatiereRequest(matiere)
    );
  }

  public matiereToMatiereRequest(matiere: Matiere): any {
    let obj = {
      id: matiere.id,
      libelle: matiere.libelle,
      duration: matiere.duration,
      objective: matiere.objective,
      prerequisite: matiere.prerequisite,
      content: matiere.content,
    };
    return obj;
  }

  public getWithoutFormateur(id: number): Observable<Matiere[]> {
    return this.httpClient.get<Matiere[]>(`${this.url}/withoutformateur/${id}`);
  }

  public update(matiere: Matiere): Observable<Matiere> {
    return this.httpClient.put<Matiere>(
      `${this.url}/${matiere.id}`,
      this.matiereToMatiereRequest(matiere)
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }
}
