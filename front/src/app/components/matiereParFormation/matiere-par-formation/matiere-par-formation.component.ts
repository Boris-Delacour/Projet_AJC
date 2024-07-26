import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink, RouterLinkActive } from '@angular/router';
import { MatiereParFormation } from '../../../models/matiere-par-formation';
import { MatiereParFormationService } from '../../../services/matiere-par-formation.service';

@Component({
  selector: 'app-matiere-par-formation',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './matiere-par-formation.component.html',
  styleUrl: './matiere-par-formation.component.css',
})
export class MatiereParFormationComponent implements OnInit {
  matiereParFormations: MatiereParFormation[] = [];
  message = '';
  showMessage = false;
  style = '';

  constructor(
    public matiereParFormationSrv: MatiereParFormationService,
    private activatedRoute: ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.initMatiereParFormations();
    this.initMessage();
  }

  initMessage() {
    this.activatedRoute.queryParams.subscribe((params) => {
      if (params['q']) {
        if (params['q'] == 'create') {
          this.message = `MatiereParFormation ${params['id']} créé `;
        } else if (params['q'] == 'update') {
          this.message = `MatiereParFormation ${params['id']} mis à jour `;
        }
      }
      this.showMessage = true;
      this.style = 'alert-info';
    });
  }

  initMatiereParFormations() {
    this.matiereParFormationSrv
      .getAllWithFormation()
      .subscribe((matiereParFormations) => {
        this.matiereParFormations = matiereParFormations;
      });
  }

  delete(id: number) {
    this.matiereParFormationSrv.delete(id).subscribe(() => {
      this.initMatiereParFormations();
      this.message = `MatiereParFormation ${id} supprimé `;
      this.style = 'alert-warning';
    });
  }
}
