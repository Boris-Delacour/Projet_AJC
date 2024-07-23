import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {
  ActivatedRoute,
  Router,
  RouterLink,
  RouterLinkActive,
} from '@angular/router';
import { Observable } from 'rxjs';
import { Ordinateur } from '../../../models/ordinateur';
import { Stagiaire } from '../../../models/stagiaire';
import { OrdinateurService } from '../../../services/ordinateur.service';
import { StagiaireService } from '../../../services/stagiaire.service';

@Component({
  selector: 'app-ordinateur-edit',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive],
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
}
