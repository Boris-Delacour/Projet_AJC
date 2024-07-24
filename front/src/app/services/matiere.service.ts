import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Matiere } from '../models/matiere';
import { Observable } from 'rxjs';
import { Formateur } from '../models/formateur';
import { FormateurService } from './formateur.service';

@Injectable({
  providedIn: 'root',
})
export class MatiereService {
  url = 'http://localhost:8080/ajcfinal/api/matiere';

  constructor(
    private httpClient: HttpClient
  ) {}

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

  private matiereToMatiereRequest(matiere: Matiere): any {
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

  private formateurToFormateurRequest(formateur: Formateur): any {
    let obj = {
      id: formateur.id,
      firstname: formateur.firstname,
      lastname: formateur.lastname,
      email: formateur.email,
      login: formateur.login,
      password: formateur.password
    };
    return obj;
  }

  public getWithAll(id: number): Observable<Matiere> {
    return this.httpClient.get<Matiere>(`${this.url}/${id}/all`);
  }

  public getWithoutFormateur(id: number): Observable<Matiere[]> {
    return this.httpClient.get<Matiere[]>(`${this.url}/withoutformateur/${id}`);
  }

  public addFormateur(matiere: Matiere, formateur: Formateur) {
    return this.httpClient.put<Matiere>(
      `${this.url}/${matiere.id}/formateur`,
      this.formateurToFormateurRequest(formateur)
    );
  }

  public deleteFromFormateur(idM: number, idF: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${idM}/${idF}`);
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
