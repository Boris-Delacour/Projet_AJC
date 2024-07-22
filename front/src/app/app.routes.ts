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
];
