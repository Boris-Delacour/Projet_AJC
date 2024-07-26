import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { Gestionnaire } from '../../../models/gestionnaire';
import { Utilisateur } from '../../../models/utilisateur';
import { GestionnaireService } from '../../../services/gestionnaire.service';

@Component({
  selector: 'app-gestionnaire-nav',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './gestionnaire-nav.component.html',
  styleUrl: './gestionnaire-nav.component.css'
})
export class GestionnaireNavComponent {
  isNavbarCollapsed = true;
  gestionnaire: Gestionnaire = new Gestionnaire();

  constructor(private gSrv: GestionnaireService, private router: Router) {}

  ngOnInit(): void {
      this.initGestionnaire();
  }

  initGestionnaire() {
    let user: Utilisateur = JSON.parse(localStorage.getItem('utilisateur')!);

    this.gSrv.getById(user.idRole!).subscribe((gestionnaire) => {
      this.gestionnaire = gestionnaire;
    });
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('/');
  }

  get logged(): boolean {
    return localStorage.getItem('token') != null;
  }

  toggleNavbar(event: Event) {
    event.preventDefault();
    this.isNavbarCollapsed = !this.isNavbarCollapsed;
  }
}
