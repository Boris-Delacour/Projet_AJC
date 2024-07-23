import { Component } from '@angular/core';
import { Matiere } from '../../../models/matiere';
import { MatiereService } from '../../../services/matiere.service';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-matiere',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './matiere.component.html',
  styleUrl: './matiere.component.css'
})
export class MatiereComponent {
  matieres: Matiere[] = [];

  constructor(public mSrv: MatiereService) {}

  ngOnInit(): void {
    this.initMatieres();
  }

  initMatieres() {
    this.mSrv.getAll().subscribe((matieres) => {
      this.matieres = matieres
    });
  }

  delete(id: number) {
    this.mSrv.delete(id).subscribe(() => {
      this.initMatieres();
    });
  }
}
