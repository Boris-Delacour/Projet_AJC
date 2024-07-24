import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Formateur } from '../../../models/formateur';
import { ActivatedRoute, Router, RouterLink, RouterLinkActive } from '@angular/router';
import { FormateurService } from '../../../services/formateur.service';
import { Matiere } from '../../../models/matiere';
import { MatiereService } from '../../../services/matiere.service';
import { FormationService } from '../../../services/formation.service';
import { Formation } from '../../../models/formation';

@Component({
  selector: 'app-formateur-details',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive],
  templateUrl: './formateur-details.component.html',
  styleUrl: './formateur-details.component.css'
})
export class FormateurDetailsComponent implements OnInit {
  formateur: Formateur = new Formateur();
  matieres: Matiere[] = [];
  matiere: Matiere = new Matiere();
  formations: Formation[] = [];
  formation: Formation = new Formation();
  
  constructor(
    private router: Router,
    public fSrv: FormateurService,
    public mSrv: MatiereService,
    public foSrv: FormationService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.fSrv.getWithAll(params['id']).subscribe((formateur) => {
          this.formateur = formateur;
        });
        this.mSrv.getWithoutFormateur(params['id']).subscribe((matieres: Matiere[]) => {
            this.matieres = matieres;
        });
        this.foSrv.getWithoutFormateur().subscribe((formations: Formation[]) => {
          this.formations = formations;
        })
      }
    });
  }

  add() {
    if(this.matiere) {
      this.fSrv.addMatiere(this.formateur, this.matiere).subscribe((formateur) => {
        this.router.navigateByUrl(`/formateur/details/${this.formateur.id}`);
        this.ngOnInit();
      });
    }
  }

  remove(id: number) {
    this.mSrv.deleteFromFormateur(id, this.formateur.id!).subscribe((formateur) => {
      this.router.navigateByUrl(`/formateur/details/${this.formateur.id}`);
      this.ngOnInit();
    });
  }
}
