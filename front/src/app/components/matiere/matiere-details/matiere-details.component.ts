import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink, RouterLinkActive } from '@angular/router';
import { Matiere } from '../../../models/matiere';
import { MatiereService } from '../../../services/matiere.service';
import { FormateurService } from '../../../services/formateur.service';
import { Formateur } from '../../../models/formateur';

@Component({
  selector: 'app-matiere-details',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive],
  templateUrl: './matiere-details.component.html',
  styleUrl: './matiere-details.component.css'
})
export class MatiereDetailsComponent implements OnInit {
  matiere: Matiere = new Matiere();
  formateur: Formateur = new Formateur();
  formateurs: Formateur[] = [];

  constructor(
    private router: Router,
    public mSrv: MatiereService,
    public fSrv: FormateurService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.mSrv.getWithAll(params['id']).subscribe((matiere) => {
          this.matiere = matiere;
        });
        this.fSrv.getWithoutMatiere(params['id']).subscribe((formateurs: Formateur[]) => {
          this.formateurs = formateurs;
        });
      }
    });
  }

  add() {
    if(this.formateur) {
      this.mSrv.addFormateur(this.matiere, this.formateur).subscribe((matiere) => {
        this.router.navigateByUrl(`/matiere/details/${this.matiere.id}`);
        this.ngOnInit();
      });
    }
  }

  remove(id: number) {
    this.fSrv.deleteFromMatiere(id, this.matiere.id!).subscribe((matiere) => {
      this.router.navigateByUrl(`/matiere/details/${this.matiere.id}`);
      this.ngOnInit();
    });
  }
}
