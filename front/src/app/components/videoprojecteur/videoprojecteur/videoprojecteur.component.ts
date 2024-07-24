import { Component, OnInit } from '@angular/core';
import { Videoprojecteur } from '../../../models/videoprojecteur';
import { VideoprojecteurService } from '../../../services/videoprojecteur.service';
import { ActivatedRoute, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-videoprojecteur',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './videoprojecteur.component.html',
  styleUrl: './videoprojecteur.component.css',
})
export class VideoprojecteurComponent implements OnInit {
  videoprojecteurs: Videoprojecteur[] = [];
  message = '';
  showMessage = false;
  style = '';
  nbVideoprojecteurDispo: number = 0;

  constructor(
    public videoprojecteurSrv: VideoprojecteurService,
    private activatedRoute: ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.initVideoprojecteurs();
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

  initVideoprojecteurs() {
    this.videoprojecteurSrv.getAllWithAll().subscribe((videoprojecteurs) => {
      this.videoprojecteurs = videoprojecteurs;
    });
    this.videoprojecteurSrv
      .getByDisponible()
      .subscribe((nbVideoprojecteurs) => {
        this.nbVideoprojecteurDispo = nbVideoprojecteurs.length;
      });
  }

  delete(id: number) {
    this.videoprojecteurSrv.delete(id).subscribe(() => {
      this.initVideoprojecteurs();
      this.message = `Videoprojecteur ${id} supprimé `;
      this.style = 'alert-warning';
    });
  }
}
