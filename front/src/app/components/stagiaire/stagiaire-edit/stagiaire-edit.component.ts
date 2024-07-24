import { StagiaireService } from './../../../services/stagiaire.service';
import { Component, OnInit } from '@angular/core';
import { Stagiaire } from '../../../models/stagiaire';
import { FormsModule } from '@angular/forms';
import {
  ActivatedRoute,
  Router,
  RouterLink,
  RouterLinkActive,
} from '@angular/router';
import { FormationService } from '../../../services/formation.service';
import { Formation } from '../../../models/formation';

import { Ordinateur } from '../../../models/ordinateur';
import { Observable } from 'rxjs';
import { AsyncPipe } from '@angular/common';
import { OrdinateurService } from '../../../services/ordinateur.service';

@Component({
  selector: 'app-stagiaire-edit',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive, AsyncPipe],
  templateUrl: './stagiaire-edit.component.html',
  styleUrl: './stagiaire-edit.component.css',
})
export class StagiaireEditComponent implements OnInit {
  stagiaire: Stagiaire = new Stagiaire();

  // fformations: Formation[] = [];
  formationsObservable!: Observable<Formation[]>;
  ordinateursObservable!: Observable<Ordinateur[]>;

  constructor(
    public formationSrv: FormationService,
    public ordinateurSrv: OrdinateurService,
    private router: Router,
    public stagiaireSrv: StagiaireService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    // this.formationSrv.getAll().subscribe((formations) => {
    //   this.formations = formations;
    // });
    this.formationsObservable = this.formationSrv.getAll();
    this.ordinateursObservable = this.ordinateurSrv.getAll();
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.stagiaireSrv.getWithAll(params['id']).subscribe((stagiaire) => {
          this.stagiaire = stagiaire;
        });
      }
    });
  }

  save() {
    if (this.stagiaire.id) {
      this.stagiaireSrv.update(this.stagiaire).subscribe((stagiaire) => {
        this.router.navigateByUrl('/stagiaire?q=update&id=' + stagiaire.id);
      });
    } else {
      this.stagiaireSrv.create(this.stagiaire).subscribe((stagiaire) => {
        this.router.navigateByUrl('/stagiaire?q=create&id=' + stagiaire.id);
      });
    }
  }

  compareFn(f1: Formation, f2: Formation): boolean {
    //return f1 && f2 ? f1.id === f2.id : false;
    if (f1 && f2) {
      return f1.id === f2.id;
    } else {
      return false;
    }
  }

  compareOr(o1: Ordinateur, o2: Ordinateur): boolean {
    //return f1 && f2 ? f1.id === f2.id : false;
    if (o1 && o2) {
      return o1.id === o2.id;
    } else {
      return false;
    }
  }
}
