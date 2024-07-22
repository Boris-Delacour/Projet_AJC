import { Component, OnInit } from '@angular/core';
import { StagiaireService } from '../../../services/stagiaire.service';
import { Stagiaire } from '../../../models/stagiaire';
import { ActivatedRoute, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-stagiaire',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './stagiaire.component.html',
  styleUrl: './stagiaire.component.css',
})
export class StagiaireComponent implements OnInit {
  stagiaires: Stagiaire[] = [];
  message = '';
  showMessage = false;
  style = '';

  constructor(
    public stagiaireSrv: StagiaireService,
    private activatedRoute: ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.initStagiaires();
    this.initMessage();
  }

  initMessage() {
    this.activatedRoute.queryParams.subscribe((params) => {
      if (params['q']) {
        if (params['q'] == 'create') {
          this.message = `Stagiaire ${params['id']} créé `;
        } else if (params['q'] == 'update') {
          this.message = `Stagiaire ${params['id']} mis à jour `;
        }
      }
      this.showMessage = true;
      this.style = 'alert-info';
    });
  }

  initStagiaires() {
    this.stagiaireSrv.getAll().subscribe((stagiaires) => {
      this.stagiaires = stagiaires;
    });
  }

  delete(id: number) {
    this.stagiaireSrv.delete(id).subscribe(() => {
      this.initStagiaires();
      this.message = `Stagiaire ${id} supprimé `;
      this.style = 'alert-warning';
    });
  }
}