import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Salle } from '../../../models/salle';
import { SalleService } from '../../../services/salle.service';

@Component({
  selector: 'app-salle-detail',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './salle-detail.component.html',
  styleUrl: './salle-detail.component.css',
})
export class SalleDetailComponent implements OnInit {
  salle: Salle = new Salle();

  constructor(
    public salleSrv: SalleService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.salleSrv
          .getByIdWithVideoprojecteur(params['id'])
          .subscribe((salle) => {
            this.salle = salle;
          });
      }
    });
  }
}
