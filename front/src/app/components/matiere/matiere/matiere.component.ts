import { Component } from '@angular/core';
import { Matiere } from '../../../models/matiere';
import { MatiereService } from '../../../services/matiere.service';
import { ActivatedRoute, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-matiere',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './matiere.component.html',
  styleUrl: './matiere.component.css'
})
export class MatiereComponent {
  matieres: Matiere[] = [];
  message = '';
  showMessage: boolean = false;

  constructor(public mSrv: MatiereService, private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.initMatieres();
    this.initMessage();
  }

  initMatieres() {
    this.mSrv.getAll().subscribe((matieres) => {
      this.matieres = matieres
    });
  }

  initMessage() {
    this.activatedRoute.queryParams.subscribe((params) => {
      if (params['q']) {
        if (params['q'] == 'create') {
          this.message = `Matière ${params['id']} créé `;
        } else if (params['q'] == 'update') {
          this.message = `Matière ${params['id']} mis à jour `;
        }
      }
      this.showMessage = true;
    });
  }

  delete(id: number) {
    this.mSrv.delete(id).subscribe(() => {
      this.initMatieres();
    });
  }
}
