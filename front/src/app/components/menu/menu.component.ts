import { Component} from '@angular/core';
import { ButtonLinkComponent } from '../../component/button-link/button-link.component';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [RouterLink, RouterLinkActive, ButtonLinkComponent],
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {
  constructor(private router: Router) {}

  get login(): string {
    let u: Utilisateur = JSON.parse(localStorage.getItem('utilisateur')!);
    return u.login!;
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('/home');
  }

  get logged(): boolean {
    return localStorage.getItem('token') != null;
  }
}