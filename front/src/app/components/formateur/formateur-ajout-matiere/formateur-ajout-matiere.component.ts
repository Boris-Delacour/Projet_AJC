import { Component, ElementRef, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Formateur } from '../../../models/formateur';
import { Matiere } from '../../../models/matiere';
import { FormateurService } from '../../../services/formateur.service';
import { ActivatedRoute, Router, RouterLink, RouterLinkActive } from '@angular/router';
import { MatiereService } from '../../../services/matiere.service';
import { Observable } from 'rxjs';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-formateur-ajout-matiere',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive, AsyncPipe],
  templateUrl: './formateur-ajout-matiere.component.html',
  styleUrl: './formateur-ajout-matiere.component.css'
})
export class FormateurAjoutMatiereComponent implements OnInit {

  formateur: Formateur = new Formateur();
  matieres: Matiere[] = [];
  matiere: Matiere = new Matiere();

  constructor(
    private router: Router,
    public fSrv: FormateurService,
    public mSrv: MatiereService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.fSrv.getWithAll(params['id']).subscribe((formateur: Formateur) => {
          this.formateur = formateur;
        });
        this.mSrv.getWithoutFormateur(params['id']).subcribe((matieres: Matiere[]) => {
          this.matieres = matieres;
        });
      }
    });
  }

  add() {
    console.log(this.matiere);
    this.fSrv.addMatiere(this.formateur, this.matiere).subscribe((formateur) => { this.router.navigateByUrl('/formateur'); });
  }
}
