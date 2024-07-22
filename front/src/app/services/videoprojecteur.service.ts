import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Videoprojecteur } from '../models/videoprojecteur';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class VideoprojecteurService {
  url = 'http://localhost:8080/ajcfinal/api/videoprojecteur';
  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Videoprojecteur[]> {
    return this.httpClient.get<Videoprojecteur[]>(this.url);
  }

  public create(videoprojecteur: Videoprojecteur): Observable<Videoprojecteur> {
    return this.httpClient.post<Videoprojecteur>(
      this.url,
      this.videoprojecteurToVideoprojecteurRequest(videoprojecteur)
    );
  }

  private videoprojecteurToVideoprojecteurRequest(
    videoprojecteur: Videoprojecteur
  ): any {
    let obj = {
      marque: videoprojecteur.marque,
      fonctionnel: videoprojecteur.fonctionnel,
      salle: videoprojecteur.salle?.id,
    };
    return obj;
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  public getById(id: number): Observable<Videoprojecteur> {
    return this.httpClient.get<Videoprojecteur>(`${this.url}/${id}`);
  }

  public getByIdWithSalle(id: number): Observable<Videoprojecteur> {
    return this.httpClient.get<Videoprojecteur>(`${this.url}/${id}/salle`);
  }

  public getByMarque(marque: string): Observable<Videoprojecteur> {
    return this.httpClient.get<Videoprojecteur>(`${this.url}/${marque}`);
  }
  public getByFonctionnel(): Observable<Videoprojecteur[]> {
    return this.httpClient.get<Videoprojecteur[]>(`${this.url}/fonctionne`);
  }
  public getByNonFonctionnel(): Observable<Videoprojecteur[]> {
    return this.httpClient.get<Videoprojecteur[]>(`${this.url}/non-fonctionne`);
  }

  public update(videoprojecteur: Videoprojecteur): Observable<Videoprojecteur> {
    return this.httpClient.put<Videoprojecteur>(
      `${this.url}/${videoprojecteur.id}`,
      this.videoprojecteurToVideoprojecteurRequest(videoprojecteur)
    );
  }
}
