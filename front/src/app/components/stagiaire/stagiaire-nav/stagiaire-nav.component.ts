import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { Stagiaire } from '../../../models/stagiaire';
import { Utilisateur } from '../../../models/utilisateur';
import { StagiaireService } from '../../../services/stagiaire.service';

@Component({
  selector: 'app-stagiaire-nav',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './stagiaire-nav.component.html',
  styleUrl: './stagiaire-nav.component.css'
})
export class StagiaireNavComponent {

  isNavbarCollapsed = true;
  stagiaire: Stagiaire = new Stagiaire();

  constructor(private tSrv: StagiaireService, private router: Router) {}

  ngOnInit(): void {
      this.initFormateur();
  }

  initFormateur() {
    let user: Utilisateur = JSON.parse(localStorage.getItem('utilisateur')!);

    this.tSrv.getById(user.idRole!).subscribe((stagiaire) => {
      this.stagiaire = stagiaire;
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
