import { Component, OnInit } from '@angular/core';
import { Formateur } from '../../../models/formateur';
import { Formation } from '../../../models/formation';
import { Matiere } from '../../../models/matiere';
import { Salle } from '../../../models/salle';
import { FormateurService } from '../../../services/formateur.service';
import { FormationService } from '../../../services/formation.service';
import { MatiereService } from '../../../services/matiere.service';
import { SalleService } from '../../../services/salle.service';
import {
  ActivatedRoute,
  Router,
  RouterLink,
  RouterLinkActive,
} from '@angular/router';
import { MatiereParFormationService } from '../../../services/matiere-par-formation.service';
import { Observable } from 'rxjs';
import { FormsModule } from '@angular/forms';
import { AsyncPipe, DatePipe, formatDate } from '@angular/common';
import { MatiereParFormation } from '../../../models/matiere-par-formation';

@Component({
  selector: 'app-matiere-par-formation-edit',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive, AsyncPipe],
  templateUrl: './matiere-par-formation-edit.component.html',
  styleUrl: './matiere-par-formation-edit.component.css',
})
export class MatiereParFormationEditComponent implements OnInit {
  matiereParFormation: MatiereParFormation = new MatiereParFormation();
  response: any = {};
  formateurParMatiere: Formateur[] = [];

  formateurObservable!: Observable<Formateur[]>;
  formationObservable!: Observable<Formation[]>;
  matiereObservable!: Observable<Matiere[]>;
  salleObservable!: Observable<Salle[]>;

  constructor(
    public formateurSrv: FormateurService,
    public formationSrv: FormationService,
    public matiereSrv: MatiereService,
    public salleSrv: SalleService,
    private router: Router,
    public matiereParFormationSrv: MatiereParFormationService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.matiereParFormationSrv
          .getByIdWithAll(params['id'])
          .subscribe((matiereParFormation) => {
            this.matiereParFormation = matiereParFormation;
            this.matiereWithFormateur(matiereParFormation.matiere!);
          });
      }
      this.formateurObservable = this.formateurSrv.getAll();
      this.formationObservable = this.formationSrv.getAll();
      this.matiereObservable = this.matiereSrv.getAll();
      this.salleObservable = this.salleSrv.getAll();
    });
  }

  dateFormatWeek(date: Date) {
    return formatDate(date, 'w', 'en-US');
  }
  dateFormatDay(date: Date) {
    return formatDate(date, 'E', 'en-US');
  }

  verifWeekEnd(date: Date): Date {
    let week = 0;
    if (
      this.dateFormatDay(date) == 'Sat' ||
      this.dateFormatDay(date) == 'Sun'
    ) {
      week = 2;
    }
    date.setDate(date.getDate() + week);
    return date;
  }

  addDays(date: Date, days: number): Date {
    var myDate = date;
    var temp = new Date(myDate);
    var dateCalcul = new Date(myDate); // pour se fixer sur la date de base et non sur la date du jour.
    dateCalcul.setDate(temp.getDate() + days);
    var week = 0;
    if (
      this.dateFormatDay(dateCalcul) == 'Sat' ||
      this.dateFormatDay(dateCalcul) == 'Sun'
    ) {
      week = 2;
    }
    if (this.dateFormatWeek(dateCalcul) != this.dateFormatWeek(myDate)) {
      let weekStart = +this.dateFormatWeek(myDate);
      let weekEnd = +this.dateFormatWeek(dateCalcul);
      week = week + 2 * (weekEnd - weekStart);
    }
    dateCalcul.setDate(dateCalcul.getDate() + week);
    dateCalcul = this.verifWeekEnd(dateCalcul);
    return new Date(dateCalcul);
  }

  verifHidden(formateur: Formateur): boolean {
    for (let f of this.formateurParMatiere) {
      if (f.id == formateur.id) {
        return true;
      }
    }
    return false;
  }

  matiereWithFormateur(matiere: Matiere) {
    this.matiereSrv.getWithFormateur(matiere.id!).subscribe((matiere) => {
      this.formateurParMatiere = matiere.formateurs!;
    });
  }

  save() {
    this.response = {
      id: this.matiereParFormation.id,
      start: this.matiereParFormation.start,
      end: formatDate(
        this.addDays(
          this.matiereParFormation.start!,
          this.matiereParFormation.matiere?.duration!
        ),
        'yyyy-MM-dd',
        'en-US'
      ),
      matiere: this.matiereParFormation.matiere,
      formateur: this.matiereParFormation.formateur,
      formation: this.matiereParFormation.formation,
      salle: this.matiereParFormation.salle,
    };

    if (this.response.id) {
      this.matiereParFormationSrv
        .update(this.response)
        .subscribe((matiereParFormation) => {
          this.router.navigateByUrl(
            '/matiereparformation?q=update&id=' + matiereParFormation.id
          );
        });
    } else {
      this.matiereParFormationSrv
        .create(this.response)
        .subscribe((matiereParFormation) => {
          this.router.navigateByUrl(
            '/matiereparformation?q=create&id=' + matiereParFormation.id
          );
        });
    }
  }

  compareFrn(f1: Formateur, f2: Formateur): boolean {
    //return f1 && f2 ? f1.id === f2.id : false;
    if (f1 && f2) {
      return f1.id === f2.id;
    } else {
      return false;
    }
  }

  compareFnn(f1: Formation, f2: Formation): boolean {
    //return f1 && f2 ? f1.id === f2.id : false;
    if (f1 && f2) {
      return f1.id === f2.id;
    } else {
      return false;
    }
  }

  compareMn(f1: Matiere, f2: Matiere): boolean {
    //return f1 && f2 ? f1.id === f2.id : false;
    if (f1 && f2) {
      return f1.id === f2.id;
    } else {
      return false;
    }
  }

  compareSn(f1: Salle, f2: Salle): boolean {
    //return f1 && f2 ? f1.id === f2.id : false;
    if (f1 && f2) {
      return f1.id === f2.id;
    } else {
      return false;
    }
  }
}
