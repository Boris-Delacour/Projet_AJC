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
import { OrdinateurService } from '../../../services/ordinateur.service';
import { Ordinateur } from '../../../models/ordinateur';
import { Observable } from 'rxjs';
import { AsyncPipe } from '@angular/common';

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

  ngOnInit() {}
}
