import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink, RouterLinkActive } from '@angular/router';
import { Formation } from '../../../models/formation';
import { FormationService } from '../../../services/formation.service';

@Component({
  selector: 'app-formation',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './formation.component.html',
  styleUrl: './formation.component.css'
})
export class FormationComponent  implements OnInit{
  formations: Formation[] = [];

  constructor(
    public formationSrv: FormationService,
    private activatedRoute: ActivatedRoute
  ){}

  ngOnInit(): void {
    this.initFormations();
  }

  initFormations() {
    this.formationSrv.getAll().subscribe((formations) => {
      this.formations = formations;
    });
  }

  delete(id: number) {
    this.formationSrv.delete(id).subscribe(() => {
      this.initFormations();
    });
  }
}
