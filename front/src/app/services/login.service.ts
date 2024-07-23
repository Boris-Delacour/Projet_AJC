import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Utilisateur } from '../models/utilisateur';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private httpClient: HttpClient) {}

  public connect(login: string, password: string): Observable<Utilisateur> {
    let auth = 'Basic ' + window.btoa(login + ':' + password);
    return this.httpClient.get<Utilisateur>(
      'http://localhost:8080/api/auth',
      { headers: { Authorization: auth } }
    );
  }
}