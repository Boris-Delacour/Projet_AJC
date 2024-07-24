import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink, RouterLinkActive } from '@angular/router';
import { Formation } from '../../../models/formation';
import { FormationService } from '../../../services/formation.service';
import { Stagiaire } from '../../../models/stagiaire';
import { StagiaireService } from '../../../services/stagiaire.service';

@Component({
  selector: 'app-formation-details',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive],
  templateUrl: './formation-details.component.html',
  styleUrl: './formation-details.component.css'
})
export class FormationDetailsComponent {
  formation: Formation = new Formation();
  stagiaires: Stagiaire[] = [];

  constructor(
    public formationSrv: FormationService,
    public stagiaireSrv: StagiaireService,
    private router: Router,
    public activatedRoute: ActivatedRoute
  ){}

  ngOnInit(){
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']){
        this.formationSrv.getWithAll(params['id']).subscribe((formation) => {
          this.formation = formation;
        });
      }
    });
  }
}
