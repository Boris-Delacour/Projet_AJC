import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {
  ActivatedRoute,
  Router,
  RouterLink,
  RouterLinkActive,
} from '@angular/router';
import { Videoprojecteur } from '../../../models/videoprojecteur';
import { Salle } from '../../../models/salle';
import { Observable } from 'rxjs';
import { SalleService } from '../../../services/salle.service';
import { VideoprojecteurService } from '../../../services/videoprojecteur.service';

@Component({
  selector: 'app-videoprojecteur-edit',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive],
  templateUrl: './videoprojecteur-edit.component.html',
  styleUrl: './videoprojecteur-edit.component.css',
})
export class VideoprojecteurEditComponent implements OnInit {
  videoprojecteur: Videoprojecteur = new Videoprojecteur();

  sallesObservable!: Observable<Salle[]>;

  constructor(
    public salleSrv: SalleService,
    private router: Router,
    public videoprojecteurSrv: VideoprojecteurService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.sallesObservable = this.salleSrv.getAll();
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.videoprojecteurSrv
          .getById(params['id'])
          .subscribe((videoprojecteur) => {
            this.videoprojecteur = videoprojecteur;
          });
      }
    });
  }

  save() {
    if (this.videoprojecteur.id) {
      this.videoprojecteurSrv
        .update(this.videoprojecteur)
        .subscribe((videoprojecteur) => {
          this.router.navigateByUrl(
            '/videoprojecteur?q=update&id=' + videoprojecteur.id
          );
        });
    } else {
      this.videoprojecteurSrv
        .create(this.videoprojecteur)
        .subscribe((videoprojecteur) => {
          this.router.navigateByUrl(
            '/videoprojecteur?q=create&id=' + videoprojecteur.id
          );
        });
    }
  }

  compareFn(f1: Salle, f2: Salle): boolean {
    //return f1 && f2 ? f1.id === f2.id : false;
    if (f1 && f2) {
      return f1.id === f2.id;
    } else {
      return false;
    }
  }
}
