import { Router } from '@angular/router';
import { AuthenticationService } from './../services/authentication.service';
import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  constructor(
    private authenticationService: AuthenticationService,
    private fb: FormBuilder,
    private router: Router
  ) { }

  hidePassword = true;
  processingRequest = false;

  loginForm = this.fb.group({
    email: ['', Validators.required],
    password: ['', Validators.required],
  });

  login() {
    this.processingRequest = true;
    console.log(this.loginForm.value);

    if (this.loginForm.valid) {

      this.authenticationService.authenticate(this.loginForm.value).subscribe({
        next: () => {
          alert("Login efetuado!");
          this.router.navigate(['./home']);
        },
        error: (response) => {
        this.processingRequest = false;
        alert("Usuário ou senha incorretos!")
      }
    });
  }
}

  Enter(event: KeyboardEvent): void {
    if (event.key === 'Enter') {
      this.login();
    }
  }

  OnInit(){
    this.hidePassword = true;
    this.processingRequest = false;
  }

}
