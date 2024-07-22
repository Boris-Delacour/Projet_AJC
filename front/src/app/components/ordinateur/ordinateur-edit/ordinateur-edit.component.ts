import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {
  ActivatedRoute,
  Router,
  RouterLink,
  RouterLinkActive,
} from '@angular/router';
import { Ordinateur } from '../../../models/ordinateur';
import { Observable } from 'rxjs';
import { StagiaireService } from '../../../services/stagiaire.service';
import { OrdinateurService } from '../../../services/ordinateur.service';
import { Stagiaire } from '../../../models/stagiaire';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-ordinateur-edit',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive, AsyncPipe],
  templateUrl: './ordinateur-edit.component.html',
  styleUrl: './ordinateur-edit.component.css',
})
export class OrdinateurEditComponent implements OnInit {
  ordinateur: Ordinateur = new Ordinateur();

  stagiairesObservable!: Observable<Stagiaire[]>;

  constructor(
    public stagiaireSrv: StagiaireService,
    private router: Router,
    public ordinateurSrv: OrdinateurService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.stagiairesObservable = this.stagiaireSrv.getAll();
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.ordinateurSrv
          .getByIdWithStagiaire(params['id'])
          .subscribe((ordinateur) => {
            this.ordinateur = ordinateur;
          });
      }
    });
  }

  save() {
    if (this.ordinateur.id) {
      this.ordinateurSrv.update(this.ordinateur).subscribe((ordinateur) => {
        this.router.navigateByUrl('/ordinateur?q=update&id=' + ordinateur.id);
      });
    } else {
      this.ordinateurSrv.create(this.ordinateur).subscribe((ordinateur) => {
        this.router.navigateByUrl('/ordinateur?q=create&id=' + ordinateur.id);
      });
    }
  }

  compareFn(f1: Stagiaire, f2: Stagiaire): boolean {
    //return f1 && f2 ? f1.id === f2.id : false;
    if (f1 && f2) {
      return f1.id === f2.id;
    } else {
      return false;
    }
  }
}
