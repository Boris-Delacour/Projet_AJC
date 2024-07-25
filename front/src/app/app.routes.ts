import { Routes } from '@angular/router';
import { FormateurComponent } from './components/formateur/formateur/formateur.component';
import { FormateurEditComponent } from './components/formateur/formateur-edit/formateur-edit.component';
import { MatiereComponent } from './components/matiere/matiere/matiere.component';
import { MatiereEditComponent } from './components/matiere/matiere-edit/matiere-edit.component';
import { GestionnaireComponent } from './components/gestionnaire/gestionnaire/gestionnaire.component';
import { GestionnaireEditComponent } from './components/gestionnaire/gestionnaire-edit/gestionnaire-edit.component';
import { FormationComponent } from './components/formation/formation/formation.component';
import { FormationEditComponent } from './components/formation/formation-edit/formation-edit.component';
import { StagiaireComponent } from './components/stagiaire/stagiaire/stagiaire.component';
import { StagiaireEditComponent } from './components/stagiaire/stagiaire-edit/stagiaire-edit.component';
import { TechnicienComponent } from './components/technicien/technicien/technicien.component';
import { TechnicienEditComponent } from './components/technicien/technicien-edit/technicien-edit.component';
import { IndisponibiliteComponent } from './components/indisponibilite/indisponibilite/indisponibilite.component';
import { IndisponibiliteEditComponent } from './components/indisponibilite/indisponibilite-edit/indisponibilite-edit.component';
import { FormateurDetailsComponent } from './components/formateur/formateur-details/formateur-details.component';
import { OrdinateurComponent } from './components/ordinateur/ordinateur/ordinateur.component';
import { OrdinateurEditComponent } from './components/ordinateur/ordinateur-edit/ordinateur-edit.component';
import { SalleComponent } from './components/salle/salle/salle.component';
import { SalleEditComponent } from './components/salle/salle-edit/salle-edit.component';
import { VideoprojecteurComponent } from './components/videoprojecteur/videoprojecteur/videoprojecteur.component';
import { VideoprojecteurEditComponent } from './components/videoprojecteur/videoprojecteur-edit/videoprojecteur-edit.component';
import { SalleDetailComponent } from './components/salle/salle-detail/salle-detail.component';
import { VideoprojecteurDetailComponent } from './components/videoprojecteur/videoprojecteur-detail/videoprojecteur-detail.component';
import { OrdinateurDetailComponent } from './components/ordinateur/ordinateur-detail/ordinateur-detail.component';
import { MatiereParFormationComponent } from './components/matiereParFormation/matiere-par-formation/matiere-par-formation.component';
import { MatiereParFormationEditComponent } from './components/matiereParFormation/matiere-par-formation-edit/matiere-par-formation-edit.component';
import { MatiereParFormationDetailComponent } from './components/matiereParFormation/matiere-par-formation-detail/matiere-par-formation-detail.component';
import { FormationDetailsComponent } from './components/formation/formation-details/formation-details.component';
import { MatiereDetailsComponent } from './components/matiere/matiere-details/matiere-details.component';
import { GestionnaireDetailsComponent } from './components/gestionnaire/gestionnaire-details/gestionnaire-details.component';
import { LoginComponent } from './components/login/login.component';
import { authGuard } from './guards/auth.guard';
import { anonymousGuard } from './guards/anonymous.guard';

export const routes: Routes = [
  { path: 'formateur', component: FormateurComponent, canActivate: [authGuard] },
  { path: 'formateur/edit', component: FormateurEditComponent, canActivate: [authGuard] },
  { path: 'formateur/edit/:id', component: FormateurEditComponent, canActivate: [authGuard] },
  { path: 'formateur/details/:id', component: FormateurDetailsComponent, canActivate: [authGuard] },

  { path: 'matiere', component: MatiereComponent, canActivate: [authGuard] },
  { path: 'matiere/edit', component: MatiereEditComponent, canActivate: [authGuard] },
  { path: 'matiere/edit/:id', component: MatiereEditComponent, canActivate: [authGuard] },
  { path: 'matiere/details/:id', component: MatiereDetailsComponent, canActivate: [authGuard] },

  { path: 'formation', component: FormationComponent, canActivate: [authGuard] },
  { path: 'formation/edit', component: FormationEditComponent, canActivate: [authGuard] },
  { path: 'formation/edit/:id', component: FormationEditComponent, canActivate: [authGuard] },
  { path: 'formation/details/:id', component: FormationDetailsComponent, canActivate: [authGuard] },

  { path: 'matiereparformation', component: MatiereParFormationComponent, canActivate: [authGuard] },
  {
    path: 'matiereparformation/edit',
    component: MatiereParFormationEditComponent, canActivate: [authGuard]
  },
  {
    path: 'matiereparformation/edit/:id',
    component: MatiereParFormationEditComponent, canActivate: [authGuard]
  },
  {
    path: 'matiereparformation/:id',
    component: MatiereParFormationDetailComponent, canActivate: [authGuard]
  },

  { path: 'stagiaire', component: StagiaireComponent, canActivate: [authGuard] },
  { path: 'stagiaire/edit', component: StagiaireEditComponent, canActivate: [authGuard] },
  { path: 'stagiaire/edit/:id', component: StagiaireEditComponent, canActivate: [authGuard] },

  { path: 'technicien', component: TechnicienComponent, canActivate: [authGuard] },
  { path: 'technicien/edit', component: TechnicienEditComponent, canActivate: [authGuard] },
  { path: 'technicien/edit/:id', component: TechnicienEditComponent, canActivate: [authGuard] },

  { path: 'gestionnaire', component: GestionnaireComponent, canActivate: [authGuard] },
  { path: 'gestionnaire/edit', component: GestionnaireEditComponent, canActivate: [authGuard] },
  { path: 'gestionnaire/edit/:id', component: GestionnaireEditComponent, canActivate: [authGuard] },
  { path: 'gestionnaire/details/:id', component: GestionnaireDetailsComponent, canActivate: [authGuard] },

  { path: 'ordinateur', component: OrdinateurComponent, canActivate: [authGuard] },
  { path: 'ordinateur/edit', component: OrdinateurEditComponent, canActivate: [authGuard] },
  { path: 'ordinateur/edit/:id', component: OrdinateurEditComponent, canActivate: [authGuard] },
  { path: 'ordinateur/:id', component: OrdinateurDetailComponent, canActivate: [authGuard] },

  { path: 'salle', component: SalleComponent, canActivate: [authGuard] },
  { path: 'salle/edit', component: SalleEditComponent, canActivate: [authGuard] },
  { path: 'salle/edit/:id', component: SalleEditComponent, canActivate: [authGuard] },
  { path: 'salle/:id', component: SalleDetailComponent, canActivate: [authGuard] },

  { path: 'videoprojecteur', component: VideoprojecteurComponent, canActivate: [authGuard] },
  { path: 'videoprojecteur/edit', component: VideoprojecteurEditComponent, canActivate: [authGuard] },
  { path: 'videoprojecteur/edit/:id', component: VideoprojecteurEditComponent, canActivate: [authGuard] },
  { path: 'videoprojecteur/:id', component: VideoprojecteurDetailComponent, canActivate: [authGuard] },

  { path: 'indisponibilite', component: IndisponibiliteComponent, canActivate: [authGuard] },
  { path: 'indisponibilite/edit', component: IndisponibiliteEditComponent, canActivate: [authGuard] },
  { path: 'indisponibilite/edit/:id', component: IndisponibiliteEditComponent, canActivate: [authGuard] },

  { path: 'login', component: LoginComponent, canActivate: [anonymousGuard] },
];
