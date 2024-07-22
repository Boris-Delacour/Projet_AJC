import { Component, OnInit } from '@angular/core';
import { Formateur } from '../../../models/formateur';
import { FormateurService } from '../../../services/formateur.service';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-formateur',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './formateur.component.html',
  styleUrl: './formateur.component.css'
})
export class FormateurComponent implements OnInit {
  
  formateurs: Formateur[] = [];

  constructor(public fSrv: FormateurService) {}

  ngOnInit(): void {
    this.initFormateurs();
  }

  initFormateurs() {
    this.fSrv.getAll().subscribe((formateurs) => {
      this.formateurs = formateurs
    });
  }

  delete(id: number) {
    this.fSrv.delete(id).subscribe(() => {
      this.initFormateurs();
    });
  }
}
