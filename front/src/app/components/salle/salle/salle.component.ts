import { Component, OnInit } from '@angular/core';
import { Salle } from '../../../models/salle';
import { SalleService } from '../../../services/salle.service';
import { ActivatedRoute, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-salle',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './salle.component.html',
  styleUrl: './salle.component.css',
})
export class SalleComponent implements OnInit {
  salles: Salle[] = [];
  message = '';
  showMessage = false;
  style = '';

  constructor(
    public salleSrv: SalleService,
    private activatedRoute: ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.initSalles();
    this.initMessage();
  }

  initMessage() {
    this.activatedRoute.queryParams.subscribe((params) => {
      if (params['q']) {
        if (params['q'] == 'create') {
          this.message = `Salle ${params['id']} créé `;
        } else if (params['q'] == 'update') {
          this.message = `Salle ${params['id']} mis à jour `;
        }
        this.showMessage = true;
        setTimeout(() => {
          this.showMessage = false;
        }, 5000);
      } else {
        this.showMessage = false;
      }
    });
  }

  initSalles() {
    this.salleSrv.getAll().subscribe((salles) => {
      this.salles = salles;
    });
  }

  delete(id: number) {
    this.salleSrv.delete(id).subscribe(() => {
      this.initSalles();
      this.message = `Salle ${id} supprimé `;
      this.style = 'alert-warning';
    });
  }
}
