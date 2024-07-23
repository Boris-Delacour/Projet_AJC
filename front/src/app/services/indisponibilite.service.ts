import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Indisponibilite } from '../models/indisponibilite';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IndisponibiliteService {
  url = 'http://localhost:8080/ajcfinal/api/indisponibilite';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Indisponibilite[]> {
    return this.httpClient.get<Indisponibilite[]>(`${this.url}/formateur`);
  }

  public getById(id: number): Observable<Indisponibilite> {
    return this.httpClient.get<Indisponibilite>(`${this.url}/${id}/formateur`);
  }

  public create(indisponibilite: Indisponibilite): Observable<Indisponibilite> {
    return this.httpClient.post<Indisponibilite>(
      this.url,
      this.indisponibiliteToIndisponibiliteRequest(indisponibilite)
    );
  }

   private indisponibiliteToIndisponibiliteRequest(indisponibilite: Indisponibilite): any {
    let obj = {
      start: indisponibilite.start,
      end: indisponibilite.end,
      formateur: indisponibilite.formateur?.id
    };
    return obj;
  }

  public update(indisponibilite: Indisponibilite): Observable<Indisponibilite> {
    return this.httpClient.put<Indisponibilite>(
      `${this.url}/${indisponibilite.id}`,
      this.indisponibiliteToIndisponibiliteRequest(indisponibilite)
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }
}
