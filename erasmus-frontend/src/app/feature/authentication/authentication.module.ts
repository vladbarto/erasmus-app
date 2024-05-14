import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import {AuthenticationRoutingModule} from "./authentication-routing.module";
import { RegisterComponent } from './register/register.component';
import { AllDoneComponent } from './register/all-done/all-done.component';

@NgModule({
  declarations: [
    LoginComponent,
    RegisterComponent,
    AllDoneComponent
  ],
  imports: [
    CommonModule,
    AuthenticationRoutingModule,
    ReactiveFormsModule
  ]
})
export class AuthenticationModule { }
