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
        if (params['q'] === 'create') {
          this.message = `Indisponibilité ${params['id']} créé `;
          this.style = 'alert-success';
        } else if (params['q'] === 'update') {
          this.message = `Indisponibilité ${params['id']} mis à jour `;
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

  delete(id: number) {
    this.iSrv.delete(id).subscribe(() => {
      this.initIndisponibilites();
    });
  }
}
