import { StagiaireService } from './../../../services/stagiaire.service';
import { Component, OnInit } from '@angular/core';
import { Stagiaire } from '../../../models/stagiaire';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink, RouterLinkActive } from '@angular/router';
import { FormationService } from '../../../services/formation.service';
import { Formation } from '../../../models/formation';
import { Ordinateur } from '../../../models/ordinateur';
import { Observable, of } from 'rxjs';
import { AsyncPipe } from '@angular/common';
import { OrdinateurService } from '../../../services/ordinateur.service';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-stagiaire-edit',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive, AsyncPipe],
  templateUrl: './stagiaire-edit.component.html',
  styleUrl: './stagiaire-edit.component.css',
})
export class StagiaireEditComponent implements OnInit {
  stagiaire: Stagiaire = new Stagiaire();

  formationsObservable!: Observable<Formation[]>;
  availableOrdinateurs$!: Observable<Ordinateur[]>;

  constructor(
    public formationSrv: FormationService,
    public ordinateurSrv: OrdinateurService,
    private router: Router,
    public stagiaireSrv: StagiaireService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.formationsObservable = this.formationSrv.getAll();

    this.activatedroute.params.pipe(
      switchMap((params) => {
        if (params['id']) {
          return this.stagiaireSrv.getWithAll(params['id']);
        } else {
          return of(new Stagiaire());
        }
      })
    ).subscribe((stagiaire) => {
      this.stagiaire = stagiaire;
      this.updateAvailableOrdinateurs();
    });
  }

  updateAvailableOrdinateurs() {
    this.availableOrdinateurs$ = this.ordinateurSrv.getAvailable().pipe(
      switchMap((ordinateurs) => {
        // Inclure l'ordinateur assigné actuel si défini
        if (this.stagiaire.ordinateur) {
          ordinateurs.push(this.stagiaire.ordinateur);
        }
        return of(ordinateurs);
      })
    );
  }

  save() {
    if (this.stagiaire.id) {
      this.stagiaireSrv.update(this.stagiaire).subscribe((stagiaire) => {
        this.router.navigateByUrl('/stagiaire?q=update&id=' + stagiaire.id);
        this.updateAvailableOrdinateurs(); // Met à jour les ordinateurs disponibles après modification
      });
    } else {
      this.stagiaireSrv.create(this.stagiaire).subscribe((stagiaire) => {
        this.router.navigateByUrl('/stagiaire?q=create&id=' + stagiaire.id);
        this.updateAvailableOrdinateurs(); // Met à jour les ordinateurs disponibles après création
      });
    }
  }

  compareFn(f1: Formation, f2: Formation): boolean {
    return f1 && f2 ? f1.id === f2.id : false;
  }

  compareOr(o1: Ordinateur, o2: Ordinateur): boolean {
    return o1 && o2 ? o1.id === o2.id : false;
  }
}
