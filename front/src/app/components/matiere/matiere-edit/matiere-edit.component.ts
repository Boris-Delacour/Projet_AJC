import { Component } from '@angular/core';
import { Matiere } from '../../../models/matiere';
import { ActivatedRoute, Router, RouterLink, RouterLinkActive } from '@angular/router';
import { MatiereService } from '../../../services/matiere.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-matiere-edit',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive],
  templateUrl: './matiere-edit.component.html',
  styleUrl: './matiere-edit.component.css'
})
export class MatiereEditComponent {
  matiere: Matiere = new Matiere();

  constructor(
    private router: Router,
    public mSrv: MatiereService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.mSrv.getById(params['id']).subscribe((matiere) => {
          this.matiere = matiere;
        });
      }
    });
  }

  save() {
    if (this.matiere.id) {
      this.mSrv.update(this.matiere).subscribe((matiere) => {
        this.router.navigateByUrl('/matiere?q=update&id=' + matiere.id);
      });
    } else {
      this.mSrv.create(this.matiere).subscribe((matiere) => {
        this.router.navigateByUrl('/matiere?q=create&id=' + matiere.id);
      });
    }
  }
}
