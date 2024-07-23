import { Component } from '@angular/core';
import { ActivatedRoute, Router, RouterLink, RouterLinkActive } from '@angular/router';
import { FormateurService } from '../../../services/formateur.service';
import { Formateur } from '../../../models/formateur';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-formateur-edit',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive],
  templateUrl: './formateur-edit.component.html',
  styleUrl: './formateur-edit.component.css'
})
export class FormateurEditComponent {
  formateur: Formateur = new Formateur();

  constructor(
    private router: Router,
    public fSrv: FormateurService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.fSrv.getById(params['id']).subscribe((formateur) => {
          this.formateur = formateur;
        });
      }
    });
  }

  save() {
    if (this.formateur.id) {
      this.fSrv.update(this.formateur).subscribe((formateur) => {
        this.router.navigateByUrl('/formateur?q=update&id=' + formateur.id);
      });
    } else {
      this.fSrv.create(this.formateur).subscribe((formateur) => {
        this.router.navigateByUrl('/formateur?q=create&id=' + formateur.id);
      });
    }
  }
  
}
