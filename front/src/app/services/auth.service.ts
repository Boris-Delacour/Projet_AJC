import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Utilisateur } from '../models/utilisateur';
import { UrlCreationOptions } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private httpClient: HttpClient) {}

  public connect(username: string, password: string): Observable<Utilisateur> {
    let auth = 'Basic ' + window.btoa(username + ':' + password);
    return this.httpClient.get<Utilisateur>(
      'http://localhost:8080/ajcfinal/api/auth',
      { headers: { Authorization: auth } }
    );
  }

  public getByUsername(username: String): Observable<Utilisateur> {
    return this.httpClient.get<Utilisateur>(
      `http://localhost:8080/ajcfinal/api/utilisateur/${username}`
    );
  }
}
