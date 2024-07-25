import { Injectable } from '@angular/core';
import { UrlTree } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class FormateurGuardService {

  constructor() {}

  canActivate(): boolean | UrlTree {
    return false;
  }
}
