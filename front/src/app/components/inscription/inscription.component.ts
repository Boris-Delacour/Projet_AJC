import { Component } from '@angular/core';
import {
  AbstractControl,
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { UtilisateurService } from '../../services/utilisateur.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inscription',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './inscription.component.html',
  styleUrl: './inscription.component.css',
})
export class InscriptionComponent {
  form!: FormGroup;

  constructor(
    private utilisateurSrv: UtilisateurService,
    private router: Router
  ) {
    this.form = new FormGroup({
      login: new FormControl('', Validators.required),
      prenom: new FormControl(''),
      passwordGroup: new FormGroup(
        {
          password: new FormControl('', Validators.required),
          confirmation: new FormControl(''),
        },
        this.passwordEtConfirmationEgaux
      ),
    });
  }

  submit() {
    let obj = {
      login: this.form.get('login')?.value,
      prenom: this.form.get('prenom')?.value,
      password: this.form.get('passwordGroup.password')?.value,
    };
    this.utilisateurSrv.inscription(obj).subscribe((data) => {
      this.router.navigateByUrl('/login');
    });
  }

  passwordEtConfirmationEgaux(
    control: AbstractControl
  ): null | ValidationErrors {
    return control.get('password')?.value == control.get('confirmation')?.value
      ? null
      : { passwordEtConfirmationNoTEquals: true };
  }
}