import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink, RouterLinkActive } from '@angular/router';
import { Formation } from '../../../models/formation';
import { Gestionnaire } from '../../../models/gestionnaire';
import { FormationService } from '../../../services/formation.service';
import { GestionnaireService } from '../../../services/gestionnaire.service';

@Component({
  selector: 'app-gestionnaire-details',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive],
  templateUrl: './gestionnaire-details.component.html',
  styleUrl: './gestionnaire-details.component.css'
})
export class GestionnaireDetailsComponent {
  gestionnaire: Gestionnaire = new Gestionnaire;
  formations: Formation[] = [];

  constructor(
    public gestionnaireSrv: GestionnaireService,
    public formationSrv: FormationService,
    private router: Router,
    public activatedRoute: ActivatedRoute
  ){}

  ngOnInit(){
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']){
        this.gestionnaireSrv.getWithFormations(params['id']).subscribe((gestionnaire) => {
          this.gestionnaire = gestionnaire;
        });
      }
    });
  }

}
