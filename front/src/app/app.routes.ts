import { Routes } from '@angular/router';
import { FormateurComponent } from './components/formateur/formateur/formateur.component';
import { FormateurEditComponent } from './components/formateur/formateur-edit/formateur-edit.component';
import { MatiereComponent } from './components/matiere/matiere/matiere.component';
import { MatiereEditComponent } from './components/matiere/matiere-edit/matiere-edit.component';

export const routes: Routes = [
    {path: "formateur", component: FormateurComponent},
    {path: "formateur/edit", component: FormateurEditComponent},
    {path: "formateur/edit/:id", component: FormateurEditComponent},

    {path: "matiere", component: MatiereComponent},
    {path: "matiere/edit", component: MatiereEditComponent},
    {path: "matiere/edit/:id", component: MatiereEditComponent},

    {path: "formation", component: MatiereComponent},
    {path: "formation/edit", component: MatiereEditComponent},
    {path: "formation/edit/:id", component: MatiereEditComponent},

    {path: "matiereparformation", component: MatiereComponent},

    {path: "stagiaire", component: MatiereComponent},
    {path: "stagiaire/edit", component: MatiereEditComponent},
    {path: "stagiaire/edit/:id", component: MatiereEditComponent},

    {path: "technicien", component: MatiereComponent},
    {path: "technicien/edit", component: MatiereEditComponent},
    {path: "technicien/edit/:id", component: MatiereEditComponent},

    {path: "gestionnaire", component: MatiereComponent},
    {path: "gestionnaire/edit", component: MatiereEditComponent},
    {path: "gestionnaire/edit/:id", component: MatiereEditComponent},

    {path: "ordinateur", component: MatiereComponent},
    {path: "ordinateur/edit", component: MatiereEditComponent},
    {path: "ordinateur/edit/:id", component: MatiereEditComponent},

    {path: "salle", component: MatiereComponent},
    {path: "salle/edit", component: MatiereEditComponent},
    {path: "salle/edit/:id", component: MatiereEditComponent},

    {path: "videoprojecteur", component: MatiereComponent},
    {path: "videoprojecteur/edit", component: MatiereEditComponent},
    {path: "videoprojecteur/edit/:id", component: MatiereEditComponent},

    {path: "indisponibilite", component: MatiereComponent},
    {path: "indisponibilite/edit", component: MatiereEditComponent},
    {path: "indisponibilite/edit/:id", component: MatiereEditComponent},
];
