import { AsyncPipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {
  ActivatedRoute,
  Router,
  RouterLink,
  RouterLinkActive,
} from '@angular/router';
import { Observable } from 'rxjs';
import { Salle } from '../../../models/salle';
import { Videoprojecteur } from '../../../models/videoprojecteur';
import { SalleService } from '../../../services/salle.service';
import { VideoprojecteurService } from '../../../services/videoprojecteur.service';

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
  videoprojecteurVide: Videoprojecteur = {
    id: 0,
    marque: '',
    fonctionnel: false,
  };

  constructor(
    public videoprojecteurSrv: VideoprojecteurService,
    private router: Router,
    public salleSrv: SalleService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.salleSrv
          .getByIdWithVideoprojecteur(params['id'])
          .subscribe((salle) => {
            this.salle = salle;
            if (this.salle.videoprojecteur?.id != null) {
              this.videoprojecteurObservable =
                this.videoprojecteurSrv.getByDisponibleWithCurrent(
                  this.salle.videoprojecteur.id!
                );
            } else {
              this.videoprojecteurObservable =
                this.videoprojecteurSrv.getByDisponible();
            }
          });
      } else {
        this.videoprojecteurObservable =
          this.videoprojecteurSrv.getByDisponible();
      }
    });
  }

  save() {
    if (!this.salle.videoprojecteur?.id) {
      this.salle.videoprojecteur = this.videoprojecteurVide;
      console.log(this.salle.videoprojecteur!.id);
    }
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
