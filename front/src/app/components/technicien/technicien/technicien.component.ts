import { OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { Technicien } from '../../../models/technicien';
import { FormsModule } from '@angular/forms';
import { TechnicienService } from '../../../services/technicien.service';
import { ActivatedRoute, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-technicien',
  templateUrl: './technicien.component.html',
  styleUrls: ['./technicien.component.css'],
  imports: [RouterLink, RouterLinkActive],
  standalone: true,
})
export class TechnicienComponent implements OnInit {
  techniciens: Technicien[] = [];

  message = '';
  showMessage = false;
  style = '';

  constructor(
    public technicienSrv: TechnicienService,
    private activatedRoute: ActivatedRoute
  ) {
    // this.technicien = new Technicien();
    // this.message = '';
  }
  ngOnInit(): void {
    this.initTechniciens();
    this.initMessage();
    // this.ok();
  }

  initMessage() {
    this.activatedRoute.queryParams.subscribe((params) => {
      if (params['q']) {
        if (params['q'] == 'create') {
          this.message = `Technicien ${params['id']} créé `;
        } else if (params['q'] == 'update') {
          this.message = `Technicien ${params['id']} mis à jour `;
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

  // ok() {
  //   if (this.technicien.lastName && this.technicien.firstName) {
  //     this.message = this.technicien.infos;
  //   } else {
  //     this.message = 'Il manque des infos';
  //   }
  // }

  initTechniciens() {
    this.technicienSrv.getAll().subscribe((techniciens) => {
      this.techniciens = techniciens;
    });
  }

  delete(id: number) {
    this.technicienSrv.delete(id).subscribe(() => {
      this.initTechniciens();
      this.message = `Technicien ${id} supprimé `;
      this.style = 'alert-warning';
    },
    err => {
      this.message = `Technicien ` + id + ` ne peut pas être supprimé `;
      this.style = 'alert-danger';
      this.showMessage = true;
      setTimeout(() => {
        this.showMessage = false;
      }, 5000);
    });
  }
}
