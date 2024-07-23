import { Component } from '@angular/core';
import { Indisponibilite } from '../../../models/indisponibilite';
import { IndisponibiliteService } from '../../../services/indisponibilite.service';
import { ActivatedRoute, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-indisponibilite',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './indisponibilite.component.html',
  styleUrl: './indisponibilite.component.css'
})
export class IndisponibiliteComponent {
  indisponibilites: Indisponibilite[] = [];
  message = '';
  showMessage = false;
  style = '';

  constructor(public iSrv: IndisponibiliteService, private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.initIndisponibilites();
    this.initMessage();
  }

  initIndisponibilites() {
    this.iSrv.getAll().subscribe((indisponibilites) => {
      this.indisponibilites = indisponibilites
    });
  }

  initMessage() {
    this.activatedRoute.queryParams.subscribe((params) => {
      if (params['q']) {
        if (params['q'] == 'create') {
          this.message = `Indisponibilité ${params['id']} créé `;
        } else if (params['q'] == 'update') {
          this.message = `Indisponibilité ${params['id']} mis à jour `;
        }
      }
      this.showMessage = true;
      this.style = 'alert-info';
    });
  }

  delete(id: number) {
    this.iSrv.delete(id).subscribe(() => {
      this.initIndisponibilites();
    });
  }
}
