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
          this.message = `Videoprojecteur ${params['id']} créé `;
        } else if (params['q'] == 'update') {
          this.message = `Videoprojecteur ${params['id']} mis à jour `;
        }
      }
      this.showMessage = true;
      this.style = 'alert-info';
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
    });
  }
}
