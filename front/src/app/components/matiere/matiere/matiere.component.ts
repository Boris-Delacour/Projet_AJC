import { Component } from '@angular/core';
import { Matiere } from '../../../models/matiere';
import { MatiereService } from '../../../services/matiere.service';
import { ActivatedRoute, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-matiere',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './matiere.component.html',
  styleUrl: './matiere.component.css',
})
export class MatiereComponent {
  matieres: Matiere[] = [];
  message = '';
  showMessage: boolean = false;
  style = '';

  constructor(
    public mSrv: MatiereService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.initMatieres();
    this.initMessage();
  }

  initMatieres() {
    this.mSrv.getAll().subscribe((matieres) => {
      this.matieres = matieres;
    });
  }

  initMessage() {
    this.activatedRoute.queryParams.subscribe((params) => {
      if (params['q']) {
        if (params['q'] == 'create') {
          this.message = `Matière ${params['id']} créé `;
          this.style = 'alert-success';
        } else if (params['q'] == 'update') {
          this.message = `Matière ${params['id']} mis à jour `;
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

  delete(id: number) {
    this.mSrv.delete(id).subscribe(() => {
      this.initMatieres();
      this.message = `Formateur ` + id + ` supprimé `;
      this.style = 'alert-danger';
      this.showMessage = true;
      setTimeout(() => {
        this.showMessage = false;
      }, 5000);
    });
  }
}
