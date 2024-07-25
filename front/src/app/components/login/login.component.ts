import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { Utilisateur } from '../../models/utilisateur';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  error = false;

  constructor(private authSrv: AuthService, private router: Router) {}

  connect() {
    this.authSrv.connect(this.username, this.password).subscribe({
      //next=>on a une reponse
      next: (utilisateur) => {
        //on est sur que le couple login/password est correct
        //je stocke le couple dans le localStorage
        localStorage.setItem(
          'token',
          window.btoa(this.username + ':' + this.password)
        );
        localStorage.setItem('utilisateur', JSON.stringify(utilisateur));
        this.error = false;
        
        this.authSrv.getByUsername(utilisateur.username!).subscribe((u) => {
          if(u.role?.match("ROLE_GESTIONNAIRE")) {
            this.router.navigateByUrl(`/gestionnaire/details/${u.idRole}`);
          }
          else if(u.role?.match("ROLE_TECHNICIEN")) {
            this.router.navigateByUrl(`/technicien/details/${u.idRole}`);
          }
          else if(u.role?.match("ROLE_FORMATEUR")) {
            this.router.navigateByUrl(`/formateur/details/${u.idRole}`);
          }
          else if(u.role?.match("ROLE_STAGIAIRE")) {
            this.router.navigateByUrl(`/stagiaire/details/${u.idRole}`);
          }
          else {
            this.router.navigateByUrl(`/`);
          }
        });
      },
      //on a une erreur
      error: (err) => {
        this.error = true;
        console.debug(err);
      },
    });
  }
}
