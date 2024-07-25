import { Component } from '@angular/core';
import { ActivatedRoute, Router, RouterLink, RouterLinkActive } from '@angular/router';
import { FormateurService } from '../../../services/formateur.service';
import { Formateur } from '../../../models/formateur';
import { FormsModule } from '@angular/forms';
import { Matiere } from '../../../models/matiere';
import { MatiereService } from '../../../services/matiere.service';
import { Utilisateur } from '../../../models/utilisateur';
import { UtilisateurService } from '../../../services/utilisateur.service';

@Component({
  selector: 'app-formateur-edit',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive],
  templateUrl: './formateur-edit.component.html',
  styleUrl: './formateur-edit.component.css'
})
export class FormateurEditComponent {
  formateur: Formateur = new Formateur();
  username: String = '';
  password: String = '';
  role: String = "ROLE_FORMATEUR";
  matieres: Matiere[] = [];

  constructor(
    private router: Router,
    public fSrv: FormateurService,
    public uSrv: UtilisateurService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.fSrv.getById(params['id']).subscribe((formateur) => {
          this.formateur = formateur;
        });
      }
    });
  }

  save() {
    if (this.formateur.id) {
      this.fSrv.update(this.formateur).subscribe((formateur) => {
        this.router.navigateByUrl('/formateur?q=update&id=' + formateur.id);
      });
    } else {
      this.fSrv.create(this.formateur).subscribe((formateur) => {
        let user = {
          username: this.username,
          password: this.password,
          role: this.role,
          idRole: formateur.id
        }
        this.uSrv.inscription(user).subscribe((user) => {
          console.log(user);
        });
        this.router.navigateByUrl('/formateur?q=create&id=' + formateur.id);
      });
    }
  }
  
}
