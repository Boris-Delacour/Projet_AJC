import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { Technicien } from '../../../models/technicien';
import { Utilisateur } from '../../../models/utilisateur';
import { TechnicienService } from '../../../services/technicien.service';

@Component({
  selector: 'app-technicien-nav',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './technicien-nav.component.html',
  styleUrl: './technicien-nav.component.css'
})
export class TechnicienNavComponent {

  isNavbarCollapsed = true;
  technicien: Technicien = new Technicien();

  constructor(private tSrv: TechnicienService, private router: Router) {}

  ngOnInit(): void {
      this.initFormateur();
  }

  initFormateur() {
    let user: Utilisateur = JSON.parse(localStorage.getItem('utilisateur')!);

    this.tSrv.getById(user.idRole!).subscribe((technicien) => {
      this.technicien = technicien;
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
