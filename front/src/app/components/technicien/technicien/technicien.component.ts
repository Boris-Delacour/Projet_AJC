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
  // technicien: Technicien;
  // message: string;
  message = '';
  showMessage = false;
  style = '';
  techniciens: Technicien[] = [];
  constructor(
    public technicienSrv: TechnicienService,
    private activatedRoute: ActivatedRoute
  ) {
    // this.technicien = new Technicien();
    // this.message = '';
  }

  delete(id: number) {
    this.technicienSrv.delete(id).subscribe(() => {
      this.initTechniciens();
      this.message = `Technicien ${id} supprimé `;
      this.style = 'alert-warning';
    });
  }

  // ok() {
  //   if (this.technicien.lastName && this.technicien.firstName) {
  //     this.message = this.technicien.infos;
  //   } else {
  //     this.message = 'Il manque des infos';
  //   }
  // }

  ngOnInit(): void {
    this.initTechniciens();
  }
  initTechniciens() {
    this.technicienSrv.getAll().subscribe((techniciens) => {
      this.techniciens = techniciens;
    });
  }
}
