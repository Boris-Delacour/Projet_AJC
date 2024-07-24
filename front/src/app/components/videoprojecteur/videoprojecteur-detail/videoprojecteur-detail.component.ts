import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Videoprojecteur } from '../../../models/videoprojecteur';
import { VideoprojecteurService } from '../../../services/videoprojecteur.service';

@Component({
  selector: 'app-videoprojecteur-detail',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './videoprojecteur-detail.component.html',
  styleUrl: './videoprojecteur-detail.component.css',
})
export class VideoprojecteurDetailComponent implements OnInit {
  videoprojecteur: Videoprojecteur = new Videoprojecteur();

  constructor(
    public videoprojecteurSrv: VideoprojecteurService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.videoprojecteurSrv
          .getById(params['id'])
          .subscribe((videoprojecteur) => {
            this.videoprojecteur = videoprojecteur;
          });
      }
    });
  }
}
