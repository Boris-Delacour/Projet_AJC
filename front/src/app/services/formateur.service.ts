import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Formateur } from '../models/formateur';
import { Matiere } from '../models/matiere';
import { MatiereService } from './matiere.service';

@Injectable({
  providedIn: 'root'
})
export class FormateurService {
  url = 'http://localhost:8080/ajcfinal/api/formateur';

  constructor(
    private httpClient: HttpClient,
    private mSrv: MatiereService
  ) {}

  public getAll(): Observable<Formateur[]> {
    return this.httpClient.get<Formateur[]>(this.url);
  }

  public getById(id: number): Observable<Formateur> {
    return this.httpClient.get<Formateur>(`${this.url}/${id}`);
  }

  public getWithAll(id: number): Observable<Formateur> {
    return this.httpClient.get<Formateur>(`${this.url}/${id}/infos`);
  }

  public create(formateur: Formateur): Observable<Formateur> {
    return this.httpClient.post<Formateur>(
      this.url,
      this.formateurToFormateurRequest(formateur)
    );
  }

   public formateurToFormateurRequest(formateur: Formateur): any {
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

  public update(formateur: Formateur): Observable<Formateur> {
    return this.httpClient.put<Formateur>(
      `${this.url}/${formateur.id}`,
      this.formateurToFormateurRequest(formateur)
    );
  }

  public addMatiere(formateur: Formateur, matiere: Matiere) {
    return this.httpClient.put<Formateur>(
      `${this.url}/${formateur.id}/matiere`,
      this.mSrv.matiereToMatiereRequest(matiere)
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }
}
