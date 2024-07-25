import { Component } from '@angular/core';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css',
})
export class NavComponent {

  constructor(private router: Router) {}

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('/');
  }

  get logged(): boolean {
    return localStorage.getItem('token') != null;
  }
}
