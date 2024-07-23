import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Formateur } from '../../../models/formateur';
import { ActivatedRoute, Router, RouterLink, RouterLinkActive } from '@angular/router';
import { FormateurService } from '../../../services/formateur.service';

@Component({
  selector: 'app-formateur-details',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive],
  templateUrl: './formateur-details.component.html',
  styleUrl: './formateur-details.component.css'
})
export class FormateurDetailsComponent implements OnInit {
  formateur: Formateur = new Formateur();

  constructor(
    private router: Router,
    public fSrv: FormateurService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.fSrv.getWithAll(params['id']).subscribe((formateur) => {
          this.formateur = formateur;
        });
      }
    });
  }
}
