import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { OrdinateurComponent } from './components/ordinateur/ordinateur/ordinateur.component';
import { VideoprojecteurComponent } from './components/videoprojecteur/videoprojecteur/videoprojecteur.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, OrdinateurComponent, VideoprojecteurComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'front';
}
