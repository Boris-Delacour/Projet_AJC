import { Injectable } from '@angular/core';
import { Salle } from '../models/salle';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class SalleService {
  url = 'http://localhost:8080/ajcfinal/api/salle';
  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Salle[]> {
    return this.httpClient.get<Salle[]>(this.url);
  }

  public create(salle: Salle): Observable<Salle> {
    return this.httpClient.post<Salle>(
      this.url,
      this.salleToSalleRequest(salle)
    );
  }

  private salleToSalleRequest(salle: Salle): any {
    let obj = {
      numero: salle.numero,
      nbPlace: salle.nbPlace,
      occuper: salle.occuper,
      idVideoprojecteur: salle.videoprojecteur?.id,
      idMatiereParFormation: salle.matiereParFormation?.id,
    };
    return obj;
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  public getById(id: number): Observable<Salle> {
    return this.httpClient.get<Salle>(`${this.url}/${id}`);
  }

  public getByIdWithVideoprojecteur(id: number): Observable<Salle> {
    return this.httpClient.get<Salle>(`${this.url}/${id}/videoprojecteur`);
  }

  public getByMarque(marque: string): Observable<Salle> {
    return this.httpClient.get<Salle>(`${this.url}/${marque}`);
  }
  public getByoccupees(): Observable<Salle[]> {
    return this.httpClient.get<Salle[]>(`${this.url}/occupees`);
  }
  public getByLibres(): Observable<Salle[]> {
    return this.httpClient.get<Salle[]>(`${this.url}/libres`);
  }

  public update(salle: Salle): Observable<Salle> {
    return this.httpClient.put<Salle>(
      `${this.url}/${salle.id}`,
      this.salleToSalleRequest(salle)
    );
  }
}
