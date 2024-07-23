import { Component, OnInit } from '@angular/core';
import { Salle } from '../../../models/salle';
import { Observable } from 'rxjs';
import { Videoprojecteur } from '../../../models/videoprojecteur';
import { MatiereParFormation } from '../../../models/matiere-par-formation';
import { VideoprojecteurService } from '../../../services/videoprojecteur.service';
import { MatiereParFormationService } from '../../../services/matiere-par-formation.service';
import {
  ActivatedRoute,
  Router,
  RouterLink,
  RouterLinkActive,
} from '@angular/router';
import { SalleService } from '../../../services/salle.service';
import { FormsModule } from '@angular/forms';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-salle-edit',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive, AsyncPipe],
  templateUrl: './salle-edit.component.html',
  styleUrl: './salle-edit.component.css',
})
export class SalleEditComponent implements OnInit {
  salle: Salle = new Salle();

  videoprojecteurObservable!: Observable<Videoprojecteur[]>;

  constructor(
    public videoprojecteurSrv: VideoprojecteurService,
    private router: Router,
    public salleSrv: SalleService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.videoprojecteurObservable = this.videoprojecteurSrv.getByFonctionnel();
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.salleSrv.getById(params['id']).subscribe((salle) => {
          this.salle = salle;
        });
      }
    });
  }

  save() {
    if (this.salle.id) {
      this.salleSrv.update(this.salle).subscribe((salle) => {
        this.router.navigateByUrl('/salle?q=update&id=' + salle.id);
      });
    } else {
      this.salleSrv.create(this.salle).subscribe((salle) => {
        this.router.navigateByUrl('/salle?q=create&id=' + salle.id);
      });
    }
  }

  compareVn(f1: Videoprojecteur, f2: Videoprojecteur): boolean {
    //return f1 && f2 ? f1.id === f2.id : false;
    if (f1 && f2) {
      return f1.id === f2.id;
    } else {
      return false;
    }
  }
}
