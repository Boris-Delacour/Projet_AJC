import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stagiaire } from '../models/stagiaire';

@Injectable({
  providedIn: 'root'
})
export class StagiaireService {
url = 'http://localhost:8080/ajcfinal/api/stagiaire' ;
constructor(private httpClient: HttpClient) { }


public getAll(): Observable<Stagiaire[]> {
  return this.httpClient.get<Stagiaire[]>(this.url);
}

public getWithAll(id:number): Observable<Stagiaire> {
  return this.httpClient.get<Stagiaire>(`${this.url}/${id}/all`);
}

public create(stagiaire: Stagiaire): Observable<Stagiaire> {
  return this.httpClient.post<Stagiaire>(
    this.url,
    this.stagiaireToStagiaireRequest(stagiaire)
  );
}

private stagiaireToStagiaireRequest(stagiaire: Stagiaire): any {
  let obj = {
    firstName: stagiaire.firstName,
    lastName: stagiaire.lastName,
    email: stagiaire.email,
    login: stagiaire.login,
    password: stagiaire.password,
    idFormation: stagiaire.formation?.id,
    idOrdinateur: stagiaire.ordinateur?.id,
  };
  return obj;
}

public delete(id: number): Observable<void> {
  return this.httpClient.delete<void>(`${this.url}/${id}`);
}

public getById(id: number): Observable<Stagiaire> {
  return this.httpClient.get<Stagiaire>(`${this.url}/${id}`);
}

public update(stagiaire: Stagiaire): Observable<Stagiaire> {
  return this.httpClient.put<Stagiaire>(
    `${this.url}/${stagiaire.id}`,
    this.stagiaireToStagiaireRequest(stagiaire)
  );
}

}
