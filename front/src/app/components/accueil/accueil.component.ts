import { Component } from '@angular/core';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { Utilisateur } from '../../models/utilisateur';

@Component({
  selector: 'app-accueil',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './accueil.component.html',
  styleUrl: './accueil.component.css',
})
export class AccueilComponent {
  get username(): string {
    let u: Utilisateur = JSON.parse(localStorage.getItem('utilisateur')!);
    return u.username!;
  }

  get logged(): boolean {
    return localStorage.getItem('token') != null;
  }
}
