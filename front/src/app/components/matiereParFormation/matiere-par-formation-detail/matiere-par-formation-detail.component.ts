import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { MatiereParFormation } from '../../../models/matiere-par-formation';
import { MatiereParFormationService } from '../../../services/matiere-par-formation.service';

@Component({
  selector: 'app-matiere-par-formation-detail',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './matiere-par-formation-detail.component.html',
  styleUrl: './matiere-par-formation-detail.component.css',
})
export class MatiereParFormationDetailComponent implements OnInit {
  matiereParFormation: MatiereParFormation = new MatiereParFormation();

  constructor(
    public matiereParFormationSrv: MatiereParFormationService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.matiereParFormationSrv
          .getByIdWithAll(params['id'])
          .subscribe((matiereParFormation) => {
            this.matiereParFormation = matiereParFormation;
          });
      }
    });
  }
}
