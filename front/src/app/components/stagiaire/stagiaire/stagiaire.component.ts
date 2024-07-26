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
  showMessage: boolean = false;
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
          this.style = 'alert-success';
        } else if (params['q'] == 'update') {
          this.message = `Stagiaire ${params['id']} mis à jour `;
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
      this.showMessage = true;
      setTimeout(() => {
        this.showMessage = false;
      }, 5000);
    });
  }
}
