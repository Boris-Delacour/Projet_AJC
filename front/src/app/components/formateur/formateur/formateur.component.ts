import { Component, OnInit } from '@angular/core';
import { Formateur } from '../../../models/formateur';
import { FormateurService } from '../../../services/formateur.service';
import { ActivatedRoute, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-formateur',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './formateur.component.html',
  styleUrl: './formateur.component.css',
})
export class FormateurComponent implements OnInit {
  formateurs: Formateur[] = [];
  message = '';
  showMessage: boolean = false;
  style = '';

  constructor(
    public fSrv: FormateurService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.initFormateurs();
    this.initMessage();
  }

  initFormateurs() {
    this.fSrv.getAll().subscribe((formateurs) => {
      this.formateurs = formateurs;
    });
  }

  initMessage() {
    this.activatedRoute.queryParams.subscribe((params) => {
      if (params['q']) {
        if (params['q'] === 'create') {
          this.message = `Formateur ${params['id']} créé `;
          this.style = 'alert-success';
        } else if (params['q'] === 'update') {
          this.message = `Formateur ${params['id']} mis à jour `;
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
    this.fSrv.delete(id).subscribe(() => {
      this.initFormateurs();
      this.message = `Formateur ` + id + ` supprimé `;
      this.style = 'alert-danger';
      this.showMessage = true;
      setTimeout(() => {
        this.showMessage = false;
      }, 5000);
    },
    err => {
      this.message = `Formateur ` + id + ` ne peut pas être supprimé `;
      this.style = 'alert-danger';
      this.showMessage = true;
      setTimeout(() => {
        this.showMessage = false;
      }, 5000);
    });
  }
}
