import { AsyncPipe } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink, RouterLinkActive } from '@angular/router';
import { Gestionnaire } from '../../../models/gestionnaire';
import { GestionnaireService } from '../../../services/gestionnaire.service';

@Component({
  selector: 'app-gestionnaire-edit',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive, AsyncPipe],
  templateUrl: './gestionnaire-edit.component.html',
  styleUrl: './gestionnaire-edit.component.css'
})
export class GestionnaireEditComponent {

  gestionnaire: Gestionnaire = new Gestionnaire();

  constructor(
    public gestionnaireSrv: GestionnaireService,
    private router: Router,
    public activatedroute: ActivatedRoute

  ) {}

  ngOnInit(): void {
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.gestionnaireSrv.getById(params['id']).subscribe((gestionnaire) => {
          this.gestionnaire = gestionnaire;
        });
      }
    });
  }

  save() {
    if (this.gestionnaire.id) {
      this.gestionnaireSrv.update(this.gestionnaire).subscribe((gestionnaire) => {
        this.router.navigateByUrl('/gestionnaire?q=update&id=' + gestionnaire.id);
      });
    } else {
      this.gestionnaireSrv.create(this.gestionnaire).subscribe((gestionnaire) => {
        this.router.navigateByUrl('/gestionnaire?q=create&id=' + gestionnaire.id);
      });
    }
  }
}
