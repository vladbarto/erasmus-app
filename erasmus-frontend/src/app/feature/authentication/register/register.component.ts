import { Component, DestroyRef, OnInit } from '@angular/core';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../../core/service/auth/auth.service';
import { UserService } from '../../../core/service/user/user.service';
import { UserModel } from '../../../shared/models/user.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})

export class RegisterComponent implements OnInit {
  registerForm: FormGroup = new FormGroup({});
  errorMessage?: string;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private userService: UserService,
    private router: Router,
    private destroyRef: DestroyRef
  ) {
  }

  ngOnInit(): void {
      this.buildRegisterForm();
  }

  register(): void {
    if (!this.registerForm?.valid) {
      this.errorMessage = 'Invalid form completion!';
      setTimeout(() => this.errorMessage = undefined, 3000);
      return;
    }

    const credentials: UserModel = {
      email: this.registerForm?.get('email')?.value,
      username: this.registerForm?.get('username')?.value,
      password: this.registerForm?.get('password2')?.value,
      role: this.registerForm?.get('role')?.value
    };
    this.userService.register(credentials)
      .pipe(takeUntilDestroyed(this.destroyRef))
      .subscribe({
        error: () => this.errorMessage = 'Invalid credentials'
      });

    this.router.navigateByUrl('auth/register/all-done');
  }

  private buildRegisterForm(): void {
      this.registerForm = this.formBuilder.group({
        email: [ '', [Validators.required, Validators.email] ],
        username: [ '' ],
        password2: [ '' ],
        role: [ '' ]
      });
  }

  private getUserInfo(): void {
    this.userService.getInfo()
      .pipe(takeUntilDestroyed(this.destroyRef))
      .subscribe(response => {
        localStorage.setItem('loggedUser', JSON.stringify(response));
        this.router.navigateByUrl('/dashboard/home');
      });
  }
}
