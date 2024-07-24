import { Component, OnInit } from '@angular/core';
import { Formateur } from '../../../models/formateur';
import { FormateurService } from '../../../services/formateur.service';
import { ActivatedRoute, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-formateur',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './formateur.component.html',
  styleUrl: './formateur.component.css'
})
export class FormateurComponent implements OnInit {
  
  formateurs: Formateur[] = [];
  message = '';
  showMessage: boolean = false;

  constructor(public fSrv: FormateurService, private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.initFormateurs();
    this.initMessage();
  }

  initFormateurs() {
    this.fSrv.getAll().subscribe((formateurs) => {
      this.formateurs = formateurs
    });
  }

  initMessage() {
    this.activatedRoute.queryParams.subscribe((params) => {
      if (params['q']) {
        if (params['q'] == 'create') {
          this.message = `Formateur ${params['id']} créé `;
        } else if (params['q'] == 'update') {
          this.message = `Formateur ${params['id']} mis à jour `;
        }
      }
      this.showMessage = true;
    });
  }

  delete(id: number) {
    this.fSrv.delete(id).subscribe(() => {
      this.initFormateurs();
    });
  }
}
