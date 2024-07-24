import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ordinateur } from '../models/ordinateur';

@Injectable({
  providedIn: 'root',
})
export class OrdinateurService {
  url = 'http://localhost:8080/ajcfinal/api/ordinateur';
  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Ordinateur[]> {
    return this.httpClient.get<Ordinateur[]>(this.url);
  }

  public getAvailable(): Observable<Ordinateur[]> {
    return this.httpClient.get<Ordinateur[]>(`${this.url}/available`);
  }

  public create(ordinateur: Ordinateur): Observable<Ordinateur> {
    return this.httpClient.post<Ordinateur>(
      this.url,
      this.ordinateurToOrdinateurRequest(ordinateur)
    );
  }

  private ordinateurToOrdinateurRequest(ordinateur: Ordinateur): any {
    let obj = {
      marque: ordinateur.marque,
      fonctionnel: ordinateur.fonctionnel,
      os: ordinateur.os,
      stagiaire: ordinateur.stagiaire?.id,
    };
    return obj;
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  public getById(id: number): Observable<Ordinateur> {
    return this.httpClient.get<Ordinateur>(`${this.url}/${id}`);
  }

  public getByIdWithStagiaire(id: number): Observable<Ordinateur> {
    return this.httpClient.get<Ordinateur>(`${this.url}/${id}/stagiaire`);
  }

  public getByMarque(marque: string): Observable<Ordinateur> {
    return this.httpClient.get<Ordinateur>(`${this.url}/${marque}`);
  }
  public getByFonctionnel(): Observable<Ordinateur[]> {
    return this.httpClient.get<Ordinateur[]>(`${this.url}/fonctionne`);
  }
  public getByNonFonctionnel(): Observable<Ordinateur[]> {
    return this.httpClient.get<Ordinateur[]>(`${this.url}/non-fonctionne`);
  }

  public update(ordinateur: Ordinateur): Observable<Ordinateur> {
    return this.httpClient.put<Ordinateur>(
      `${this.url}/${ordinateur.id}`,
      this.ordinateurToOrdinateurRequest(ordinateur)
    );
  }
}
