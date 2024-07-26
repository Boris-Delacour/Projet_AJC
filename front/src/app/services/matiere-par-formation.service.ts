import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatiereParFormation } from '../models/matiere-par-formation';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class MatiereParFormationService {
  url = 'http://localhost:8080/ajcfinal/api/matiereparformation';
  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<MatiereParFormation[]> {
    return this.httpClient.get<MatiereParFormation[]>(this.url);
  }

  public getAllWithFormation(): Observable<MatiereParFormation[]> {
    return this.httpClient.get<MatiereParFormation[]>(`${this.url}/formation`);
  }

  public create(
    matiereParFormation: MatiereParFormation
  ): Observable<MatiereParFormation> {
    return this.httpClient.post<MatiereParFormation>(
      this.url,
      this.matiereParFormationToMatiereParFormationRequest(matiereParFormation)
    );
  }

  private matiereParFormationToMatiereParFormationRequest(
    matiereParFormation: MatiereParFormation
  ): any {
    let obj = {
      start: matiereParFormation.start,
      end: matiereParFormation.end,
      idMatiere: matiereParFormation.matiere?.id,
      idFormation: matiereParFormation.formation?.id,
      idFormateur: matiereParFormation.formateur?.id,
      idSalle: matiereParFormation.salle?.id,
    };
    return obj;
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  public getById(id: number): Observable<MatiereParFormation> {
    return this.httpClient.get<MatiereParFormation>(`${this.url}/${id}`);
  }

  public getByIdWithAll(id: number): Observable<MatiereParFormation> {
    return this.httpClient.get<MatiereParFormation>(`${this.url}/${id}/all`);
  }

  public getByIdWithVideoprojecteur(
    id: number
  ): Observable<MatiereParFormation> {
    return this.httpClient.get<MatiereParFormation>(
      `${this.url}/${id}/videoprojecteur`
    );
  }

  public getByMarque(marque: string): Observable<MatiereParFormation> {
    return this.httpClient.get<MatiereParFormation>(`${this.url}/${marque}`);
  }
  public getByoccupees(): Observable<MatiereParFormation[]> {
    return this.httpClient.get<MatiereParFormation[]>(`${this.url}/occupees`);
  }
  public getByLibres(): Observable<MatiereParFormation[]> {
    return this.httpClient.get<MatiereParFormation[]>(`${this.url}/libres`);
  }

  public update(
    matiereParFormation: MatiereParFormation
  ): Observable<MatiereParFormation> {
    return this.httpClient.put<MatiereParFormation>(
      `${this.url}/${matiereParFormation.id}`,
      this.matiereParFormationToMatiereParFormationRequest(matiereParFormation)
    );
  }
}
