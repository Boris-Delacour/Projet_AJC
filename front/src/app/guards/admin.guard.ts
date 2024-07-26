import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { Utilisateur } from '../models/utilisateur';

export const adminGuard: CanActivateFn = (route, state) => {
  if (localStorage.getItem('utilisateur') != null) {
    let user: Utilisateur = JSON.parse(localStorage.getItem('utilisateur')!);
    if(user.role!.match("ROLE_ADMIN")) {
      return true;
    }
  }
  return inject(Router).createUrlTree(['/login']);
};
