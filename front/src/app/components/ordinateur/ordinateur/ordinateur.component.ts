import { Component, OnInit } from '@angular/core';
import { Ordinateur } from '../../../models/ordinateur';
import { OrdinateurService } from '../../../services/ordinateur.service';
import { ActivatedRoute, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-ordinateur',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './ordinateur.component.html',
  styleUrl: './ordinateur.component.css',
})
export class OrdinateurComponent implements OnInit {
  ordinateurs: Ordinateur[] = [];
  message = '';
  showMessage = false;
  style = '';
  nbOrdinateurDispo: number = 0;

  constructor(
    public ordinateurSrv: OrdinateurService,
    private activatedRoute: ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.initOrdinateurs();
    this.initMessage();
  }

  initMessage() {
    this.activatedRoute.queryParams.subscribe((params) => {
      if (params['q']) {
        if (params['q'] == 'create') {
          this.message = `Ordinateur ${params['id']} créé `;
        } else if (params['q'] == 'update') {
          this.message = `Ordinateur ${params['id']} mis à jour `;
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

  initOrdinateurs() {
    this.ordinateurSrv.getAllWithAll().subscribe((ordinateurs) => {
      this.ordinateurs = ordinateurs;
    });
    this.ordinateurSrv.getAvailable().subscribe((nbOrdinateurs) => {
      this.nbOrdinateurDispo = nbOrdinateurs.length;
    });
  }

  delete(id: number) {
    this.ordinateurSrv.delete(id).subscribe(() => {
      this.initOrdinateurs();
      this.message = `Ordinateur ${id} supprimé `;
      this.style = 'alert-warning';
    });
  }
}
