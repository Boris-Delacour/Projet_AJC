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
import { StagiaireDetailsComponent } from './components/stagiaire/stagiaire-details/stagiaire-details.component';
import { formateurGuard } from './guards/formateur.guard';
import { gestionnaireGuard } from './guards/gestionnaire.guard';
import { stagiaireGuard } from './guards/stagiaire.guard';
import { technicienGuard } from './guards/technicien.guard';
import { AccueilComponent } from './components/accueil/accueil.component';
import { adminGuard } from './guards/admin.guard';

export const routes: Routes = [
  {
    path: 'formateur',
    component: FormateurComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'formateur/edit',
    component: FormateurEditComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'formateur/edit/:id',
    component: FormateurEditComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'formateur/details/:id',
    component: FormateurDetailsComponent,
    canActivate: [formateurGuard],
  },

  {
    path: 'matiere',
    component: MatiereComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'matiere/edit',
    component: MatiereEditComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'matiere/edit/:id',
    component: MatiereEditComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'matiere/details/:id',
    component: MatiereDetailsComponent,
    canActivate: [gestionnaireGuard],
  },

  {
    path: 'formation',
    component: FormationComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'formation/edit',
    component: FormationEditComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'formation/edit/:id',
    component: FormationEditComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'formation/details/:id',
    component: FormationDetailsComponent,
    canActivate: [gestionnaireGuard],
  },

  {
    path: 'matiereparformation',
    component: MatiereParFormationComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'matiereparformation/edit',
    component: MatiereParFormationEditComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'matiereparformation/edit/:id',
    component: MatiereParFormationEditComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'matiereparformation/:id',
    component: MatiereParFormationDetailComponent,
    canActivate: [gestionnaireGuard],
  },

  {
    path: 'stagiaire',
    component: StagiaireComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'stagiaire/edit',
    component: StagiaireEditComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'stagiaire/edit/:id',
    component: StagiaireEditComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'stagiaire/details/:id',
    component: StagiaireDetailsComponent,
    canActivate: [stagiaireGuard],
  },

  {
    path: 'technicien',
    component: TechnicienComponent,
    canActivate: [adminGuard],
  },
  {
    path: 'technicien/edit',
    component: TechnicienEditComponent,
    canActivate: [adminGuard],
  },
  {
    path: 'technicien/edit/:id',
    component: TechnicienEditComponent,
    canActivate: [adminGuard],
  },

  {
    path: 'gestionnaire',
    component: GestionnaireComponent,
    canActivate: [adminGuard],
  },
  {
    path: 'gestionnaire/edit',
    component: GestionnaireEditComponent,
    canActivate: [adminGuard],
  },
  {
    path: 'gestionnaire/edit/:id',
    component: GestionnaireEditComponent,
    canActivate: [adminGuard],
  },
  {
    path: 'gestionnaire/details/:id',
    component: GestionnaireDetailsComponent,
    canActivate: [gestionnaireGuard],
  },

  {
    path: 'ordinateur',
    component: OrdinateurComponent,
    canActivate: [technicienGuard],
  },
  {
    path: 'ordinateur/edit',
    component: OrdinateurEditComponent,
    canActivate: [technicienGuard],
  },
  {
    path: 'ordinateur/edit/:id',
    component: OrdinateurEditComponent,
    canActivate: [technicienGuard],
  },
  {
    path: 'ordinateur/:id',
    component: OrdinateurDetailComponent,
    canActivate: [technicienGuard],
  },

  {
    path: 'salle',
    component: SalleComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'salle/edit',
    component: SalleEditComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'salle/edit/:id',
    component: SalleEditComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'salle/:id',
    component: SalleDetailComponent,
    canActivate: [gestionnaireGuard],
  },

  {
    path: 'videoprojecteur',
    component: VideoprojecteurComponent,
    canActivate: [technicienGuard],
  },
  {
    path: 'videoprojecteur/edit',
    component: VideoprojecteurEditComponent,
    canActivate: [technicienGuard],
  },
  {
    path: 'videoprojecteur/edit/:id',
    component: VideoprojecteurEditComponent,
    canActivate: [technicienGuard],
  },
  {
    path: 'videoprojecteur/:id',
    component: VideoprojecteurDetailComponent,
    canActivate: [technicienGuard],
  },

  {
    path: 'indisponibilite',
    component: IndisponibiliteComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'indisponibilite/edit',
    component: IndisponibiliteEditComponent,
    canActivate: [gestionnaireGuard],
  },
  {
    path: 'indisponibilite/edit/:id',
    component: IndisponibiliteEditComponent,
    canActivate: [gestionnaireGuard],
  },

  { path: 'login', component: LoginComponent, canActivate: [anonymousGuard] },
  {
    path: 'accueil',
    component: AccueilComponent,
    canActivate: [authGuard],
  },
  {
    path: '',
    redirectTo: '/accueil',
    pathMatch: 'full',
  },
];
