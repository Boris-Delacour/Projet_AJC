import { Component} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink, RouterLinkActive } from '@angular/router';
import { Stagiaire } from '../../../models/stagiaire';
import { Formation } from '../../../models/formation';
import { Ordinateur } from '../../../models/ordinateur';
import { StagiaireService } from '../../../services/stagiaire.service';
import { FormationService } from '../../../services/formation.service';
import { OrdinateurService } from '../../../services/ordinateur.service';

@Component({
  selector: 'app-stagiaire-details',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive],
  templateUrl: './stagiaire-details.component.html',
  styleUrls: ['./stagiaire-details.component.css']
})
export class StagiaireDetailsComponent {
  stagiaire: Stagiaire = new Stagiaire();
  formations: Formation[] = [];
  ordinateurs: Ordinateur[] = [];

  constructor(
    public stagiaireSrv: StagiaireService,
    public formationSrv: FormationService,
    public ordinateurSrv: OrdinateurService,
    private router: Router,
    public activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.activatedRoute.params.subscribe((params) =>{
      if (params['id']){
        this.stagiaireSrv.getWithAll(params['id']).subscribe((stagiaire) =>{
          this.stagiaire = stagiaire;
        });
      }
    });
  }
}
