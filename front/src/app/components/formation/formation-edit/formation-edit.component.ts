import { Component } from '@angular/core';
import { Formation } from '../../../models/formation';
import { Observable } from 'rxjs';
import { FormationService } from '../../../services/formation.service';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink, RouterLinkActive } from '@angular/router';
import { Formateur } from '../../../models/formateur';
import { Gestionnaire } from '../../../models/gestionnaire';
import { AsyncPipe } from '@angular/common';
import { FormateurService } from '../../../services/formateur.service';
import { GestionnaireService } from '../../../services/gestionnaire.service';

@Component({
  selector: 'app-formation-edit',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive, AsyncPipe],
  templateUrl: './formation-edit.component.html',
  styleUrl: './formation-edit.component.css'
})
export class FormationEditComponent {

  formation: Formation = new Formation();

  formateurObservable!: Observable<Formateur[]>;

  gestionnaireObservable!: Observable<Gestionnaire[]>;

  constructor(
    public formationSrv: FormationService,
    private router: Router,
    public gestionnaireSrv: GestionnaireService,
    public formateurSrv: FormateurService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.formateurObservable = this.formateurSrv.getAll();
    this.gestionnaireObservable = this.gestionnaireSrv.getAll();
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.formationSrv.getWithAll(params['id']).subscribe((formation) => {
          this.formation = formation;
        });
      }
    });
  }

  save() {
    if (this.formation.id) {
      this.formationSrv.update(this.formation).subscribe((formation) => {
        this.router.navigateByUrl('/formation?q=update&id=' + formation.id);
      });
    } else {
      this.formationSrv.create(this.formation).subscribe((formation) => {
        this.router.navigateByUrl('/formation?q=create&id=' + formation.id);
      });
    }
  }

  compareFormateur(f1: Formateur, f2: Formateur): boolean {
    //return f1 && f2 ? f1.id === f2.id : false;
    if (f1 && f2) {
      return f1.id === f2.id;
    } else {
      return false;
    }
  }

  compareGestionnaire(g1: Gestionnaire, g2: Gestionnaire): boolean {
    //return f1 && f2 ? f1.id === f2.id : false;
    if (g1 && g2) {
      return g1.id === g2.id;
    } else {
      return false;
    }
  }

}
