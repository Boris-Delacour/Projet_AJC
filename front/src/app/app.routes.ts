import { Routes } from '@angular/router';
import { OrdinateurComponent } from './components/ordinateur/ordinateur/ordinateur.component';
import { VideoprojecteurComponent } from './components/videoprojecteur/videoprojecteur/videoprojecteur.component';
import { OrdinateurEditComponent } from './components/ordinateur/ordinateur-edit/ordinateur-edit.component';
import { VideoprojecteurEditComponent } from './components/videoprojecteur/videoprojecteur-edit/videoprojecteur-edit.component';

export const routes: Routes = [
  { path: 'ordinateur', component: OrdinateurComponent },
  {
    path: 'ordinateur/edit',
    component: OrdinateurEditComponent,
  },
  {
    path: 'ordinateur/edit/:id',
    component: OrdinateurEditComponent,
  },
  { path: 'videoprojecteur', component: VideoprojecteurComponent },
  {
    path: 'videoprojecteur/edit',
    component: VideoprojecteurEditComponent,
  },
  {
    path: 'videoprojecteur/edit/:id',
    component: VideoprojecteurEditComponent,
  },
];
