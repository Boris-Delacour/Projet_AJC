import { Component, Input } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-button-link',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './button-link.component.html',
  styleUrl: './button-link.component.css',
})
export class ButtonLinkComponent {
  @Input()
  link!: string;
  @Input()
  text!: string;
}