import { Routes } from '@angular/router';
import { FormateurComponent } from './components/formateur/formateur/formateur.component';
import { FormateurEditComponent } from './components/formateur/formateur-edit/formateur-edit.component';

export const routes: Routes = [
    {path: "formateur", component: FormateurComponent},
    {path: "formateur/edit", component: FormateurEditComponent},
    {path: "formateur/edit/:id", component: FormateurEditComponent},
];
