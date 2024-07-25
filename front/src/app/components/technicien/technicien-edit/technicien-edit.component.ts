import { AsyncPipe } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {
  ActivatedRoute,
  Router,
  RouterLink,
  RouterLinkActive,
} from '@angular/router';
import { Technicien } from '../../../models/technicien';
import { TechnicienService } from '../../../services/technicien.service';
import { UtilisateurService } from '../../../services/utilisateur.service';

@Component({
  selector: 'app-technicien-edit',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive, AsyncPipe],
  templateUrl: './technicien-edit.component.html',
  styleUrl: './technicien-edit.component.css',
})
export class TechnicienEditComponent {
  technicien: Technicien = new Technicien();
  username: String = '';
  password: String = '';
  role: String = "ROLE_TECHNICIEN";

  constructor(
    public technicienSrv: TechnicienService,
    public uSrv: UtilisateurService,
    private router: Router,
    public activatedRoute: ActivatedRoute
  ) {}

  save() {
    if (this.technicien.id) {
      this.technicienSrv.update(this.technicien).subscribe((technicien) => {
        this.router.navigateByUrl('/technicien?q=update&id=' + technicien.id);
      });
    } else {
      this.technicienSrv.create(this.technicien).subscribe((technicien) => {
        let user = {
          username: this.username,
          password: this.password,
          role: this.role,
          idRole: technicien.id
        }
        this.uSrv.inscription(user).subscribe((user) => {
          console.log(user);
        });
        this.router.navigateByUrl('/technicien?q=create&id=' + technicien.id);
      });
    }
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.technicienSrv.getById(params['id']).subscribe((technicien) => {
          this.technicien = technicien;
        });
      }
    });
  }
}
