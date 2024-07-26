import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { Formateur } from '../../../models/formateur';
import { Utilisateur } from '../../../models/utilisateur';
import { FormateurService } from '../../../services/formateur.service';

@Component({
  selector: 'app-formateur-nav',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './formateur-nav.component.html',
  styleUrl: './formateur-nav.component.css'
})
export class FormateurNavComponent implements OnInit {
  isNavbarCollapsed = true;
  formateur: Formateur = new Formateur();

  constructor(private fSrv: FormateurService, private router: Router) {}

  ngOnInit(): void {
      this.initFormateur();
  }

  initFormateur() {
    let user: Utilisateur = JSON.parse(localStorage.getItem('utilisateur')!);

    this.fSrv.getById(user.idRole!).subscribe((formateur) => {
      this.formateur = formateur;
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
