import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Indisponibilite } from '../../../models/indisponibilite';
import { IndisponibiliteService } from '../../../services/indisponibilite.service';
import { ActivatedRoute, Router, RouterLink, RouterLinkActive } from '@angular/router';
import { FormateurService } from '../../../services/formateur.service';
import { Formateur } from '../../../models/formateur';
import { Observable } from 'rxjs';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-indisponibilite-edit',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive, AsyncPipe],
  templateUrl: './indisponibilite-edit.component.html',
  styleUrl: './indisponibilite-edit.component.css'
})
export class IndisponibiliteEditComponent {
[x: string]: any;
  indisponibilite: Indisponibilite = new Indisponibilite();
  formateursObservable!: Observable<Formateur[]>;

  constructor(
    private router: Router,
    public iSrv: IndisponibiliteService,
    public fSrv: FormateurService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.formateursObservable = this.fSrv.getAll();
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.iSrv.getById(params['id']).subscribe((indisponibilite) => {
          this.indisponibilite = indisponibilite;
        });
      }
    });
  }

  save() {
    if (this.indisponibilite.id) {
      this.iSrv.update(this.indisponibilite).subscribe((indisponibilite) => {
        this.router.navigateByUrl('/indisponibilite?q=update&id=' + indisponibilite.id);
      });
    } else {
      this.iSrv.create(this.indisponibilite).subscribe((indisponibilite) => {
        this.router.navigateByUrl('/indisponibilite?q=create&id=' + indisponibilite.id);
      });
    }
  }

  compareFn(f1: Formateur, f2: Formateur) {
    return f1 && f2 ? f1.id === f2.id : false;
  }
}
