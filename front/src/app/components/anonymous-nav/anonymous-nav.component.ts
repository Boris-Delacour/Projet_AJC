import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-anonymous-nav',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './anonymous-nav.component.html',
  styleUrl: './anonymous-nav.component.css'
})
export class AnonymousNavComponent {
  isNavbarCollapsed = true;

  constructor(private router: Router) {}

  toggleNavbar(event: Event) {
    event.preventDefault();
    this.isNavbarCollapsed = !this.isNavbarCollapsed;
  }
}
