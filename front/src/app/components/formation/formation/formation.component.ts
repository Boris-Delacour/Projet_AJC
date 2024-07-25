import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink, RouterLinkActive } from '@angular/router';
import { Formation } from '../../../models/formation';
import { FormationService } from '../../../services/formation.service';

@Component({
  selector: 'app-formation',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './formation.component.html',
  styleUrl: './formation.component.css'
})
export class FormationComponent  implements OnInit{
  formations: Formation[] = [];

  message = '';
  showMessage = false;
  style = '';

  constructor(
    public formationSrv: FormationService,
    private activatedRoute: ActivatedRoute
  ){}

  ngOnInit(): void {
    this.initFormations();
    this.initMessage();
  }

  initMessage() {
    this.activatedRoute.queryParams.subscribe((params) => {
      if (params['q']) {
        if (params['q'] == 'create') {
          this.message = `Formation ${params['id']} créée `;
        } else if (params['q'] == 'update') {
          this.message = `Formation ${params['id']} mise à jour `;
        }
      }
      this.showMessage = true;
      this.style = 'alert-info';
    });
  }

  initFormations() {
    this.formationSrv.getAll().subscribe((formations) => {
      this.formations = formations;
    });
  }

  delete(id: number) {
    this.formationSrv.delete(id).subscribe(() => {
      this.initFormations();
    });
    this.message = `Formation ${id} supprimée `;
    this.style = 'alert-warning';
  }
}
