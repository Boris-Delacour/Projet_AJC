import { OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { Technicien } from '../../models/technicien';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-technicien',
  templateUrl: './technicien.component.html',
  styleUrls: ['./technicien.component.css'],
  imports: [FormsModule],
  standalone: true,
})
export class TechnicienComponent implements OnInit {
  message: string;

  technicien: Technicien;

  constructor() {
    this.technicien = new Technicien();

    this.message = '';
  }

  ok() {
    if (this.technicien.lastName && this.technicien.firstName) {
      this.message = this.technicien.infos;
    } else {
      this.message = 'Il manque des infos';
    }
  }

  ngOnInit() {}
}
