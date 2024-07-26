import { Component } from '@angular/core';
import { ActivatedRoute, RouterLink, RouterLinkActive } from '@angular/router';
import { Gestionnaire } from '../../../models/gestionnaire';
import { GestionnaireService } from '../../../services/gestionnaire.service';

@Component({
  selector: 'app-gestionnaire',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './gestionnaire.component.html',
  styleUrl: './gestionnaire.component.css'
})
export class GestionnaireComponent {
  gestionnaires: Gestionnaire[] = [];

  message = '';
  showMessage = false;
  style = '';

  constructor(
    public gestionnaireSrv: GestionnaireService,
    private activatedRoute: ActivatedRoute
  ){}

  ngOnInit(): void {
    this.initGestionnaires();
    this.initMessage();
  }

  initMessage() {
    this.activatedRoute.queryParams.subscribe((params) => {
      if (params['q']) {
        if (params['q'] == 'create') {
          this.message = `Gestionnaire ${params['id']} créé `;
          this.style = 'alert-success';
        } else if (params['q'] == 'update') {
          this.message = `Gestionnaire ${params['id']} mis à jour `;
          this.style = 'alert-warning';
        }
        this.showMessage = true;
        setTimeout(() => {
          this.showMessage = false;
        }, 5000);
      } else {
        this.showMessage = false;
      }
    });
  }

  initGestionnaires() {
    this.gestionnaireSrv.getAll().subscribe((gestionnaires) => {
      this.gestionnaires = gestionnaires;
    });
  }

  delete(id: number) {
    this.gestionnaireSrv.delete(id).subscribe(() => {
      this.initGestionnaires();
      this.message = `Formation ` + id + ` supprimé `;
      this.style = 'alert-danger';
      this.showMessage = true;
      setTimeout(() => {
        this.showMessage = false;
      }, 5000);
    },
    err => {
      this.message = `Gestionnaire ` + id + ` ne peut pas être supprimé `;
      this.style = 'alert-danger';
      this.showMessage = true;
      setTimeout(() => {
        this.showMessage = false;
      }, 5000);
    });
  }
}
