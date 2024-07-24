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

export const routes: Routes = [
  { path: 'formateur', component: FormateurComponent },
  { path: 'formateur/edit', component: FormateurEditComponent },
  { path: 'formateur/edit/:id', component: FormateurEditComponent },
  { path: 'formateur/details/:id', component: FormateurDetailsComponent },

  { path: 'matiere', component: MatiereComponent },
  { path: 'matiere/edit', component: MatiereEditComponent },
  { path: 'matiere/edit/:id', component: MatiereEditComponent },
  { path: 'matiere/details/:id', component: MatiereDetailsComponent },

  { path: 'formation', component: FormationComponent },
  { path: 'formation/edit', component: FormationEditComponent },
  { path: 'formation/edit/:id', component: FormationEditComponent },
  { path: 'formation/details/:id', component: FormationDetailsComponent },

  { path: 'matiereparformation', component: MatiereParFormationComponent },
  {
    path: 'matiereparformation/edit',
    component: MatiereParFormationEditComponent,
  },
  {
    path: 'matiereparformation/edit/:id',
    component: MatiereParFormationEditComponent,
  },
  {
    path: 'matiereparformation/:id',
    component: MatiereParFormationDetailComponent,
  },

  { path: 'stagiaire', component: StagiaireComponent },
  { path: 'stagiaire/edit', component: StagiaireEditComponent },
  { path: 'stagiaire/edit/:id', component: StagiaireEditComponent },

  { path: 'technicien', component: TechnicienComponent },
  { path: 'technicien/edit', component: TechnicienEditComponent },
  { path: 'technicien/edit/:id', component: TechnicienEditComponent },

  { path: 'gestionnaire', component: GestionnaireComponent },
  { path: 'gestionnaire/edit', component: GestionnaireEditComponent },
  { path: 'gestionnaire/edit/:id', component: GestionnaireEditComponent },

  { path: 'ordinateur', component: OrdinateurComponent },
  { path: 'ordinateur/edit', component: OrdinateurEditComponent },
  { path: 'ordinateur/edit/:id', component: OrdinateurEditComponent },
  { path: 'ordinateur/:id', component: OrdinateurDetailComponent },

  { path: 'salle', component: SalleComponent },
  { path: 'salle/edit', component: SalleEditComponent },
  { path: 'salle/edit/:id', component: SalleEditComponent },
  { path: 'salle/:id', component: SalleDetailComponent },

  { path: 'videoprojecteur', component: VideoprojecteurComponent },
  { path: 'videoprojecteur/edit', component: VideoprojecteurEditComponent },
  { path: 'videoprojecteur/edit/:id', component: VideoprojecteurEditComponent },
  { path: 'videoprojecteur/:id', component: VideoprojecteurDetailComponent },

  { path: 'indisponibilite', component: IndisponibiliteComponent },
  { path: 'indisponibilite/edit', component: IndisponibiliteEditComponent },
  { path: 'indisponibilite/edit/:id', component: IndisponibiliteEditComponent },
];
