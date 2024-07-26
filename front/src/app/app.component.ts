import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavComponent } from './components/nav/nav.component';
import { Utilisateur } from './models/utilisateur';
import { FormateurNavComponent } from "./components/formateur/formateur-nav/formateur-nav.component";
import { GestionnaireNavComponent } from './components/gestionnaire/gestionnaire-nav/gestionnaire-nav.component';
import { TechnicienNavComponent } from "./components/technicien/technicien-nav/technicien-nav.component";
import { StagiaireNavComponent } from "./components/stagiaire/stagiaire-nav/stagiaire-nav.component";
import { AnonymousNavComponent } from "./components/anonymous-nav/anonymous-nav.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NavComponent, FormateurNavComponent, GestionnaireNavComponent, TechnicienNavComponent, StagiaireNavComponent, AnonymousNavComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'front';

  get logged(): boolean {
    return localStorage.getItem('token') != null;
  }

  get role(): String {
    let u: Utilisateur = JSON.parse(localStorage.getItem('utilisateur')!);

    return u.role!;
  }
}
