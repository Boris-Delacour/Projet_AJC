import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Ordinateur } from '../../../models/ordinateur';
import { OrdinateurService } from '../../../services/ordinateur.service';

@Component({
  selector: 'app-ordinateur-detail',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './ordinateur-detail.component.html',
  styleUrl: './ordinateur-detail.component.css',
})
export class OrdinateurDetailComponent implements OnInit {
  ordinateur: Ordinateur = new Ordinateur();

  constructor(
    public ordinateurSrv: OrdinateurService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.ordinateurSrv
          .getByIdWithStagiaire(params['id'])
          .subscribe((ordinateur) => {
            this.ordinateur = ordinateur;
          });
      }
    });
  }
}
